package com.chipilinsoft.middleware.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class QuinieleroRepositoryImp implements QuinieleroRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(QuinieleroRepositoryImp.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public AuthUserDocument getUser(String user) {
		AuthUserDocument usuario;
		Query query= new Query();
		query.addCriteria(Criteria.where("uss").is(user));
		usuario = mongoTemplate.find(query, AuthUserDocument.class).stream().findFirst().orElse(null);
		ArrayList<AppUserRole> roles = new ArrayList<>();
		roles.add(AppUserRole.ROLE_CLIENT);
		usuario.setAppUserRoles(roles);
		logger.info("************** " + usuario.getNombre());
		return usuario;
	}

	@Override
	public GrupoDocument getGrupo(String id) {
		Query query= new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, GrupoDocument.class);
	}

	@Override
	public TorneoDocument getTorneo(String idGrupo) {
		Query query= new Query();
		query.addCriteria(Criteria.where("idGrupo").is(idGrupo));
		return mongoTemplate.findOne(query, TorneoDocument.class);
	}

	@Override
	public List<EquipoDocument> getEquipos() {
		return mongoTemplate.findAll(EquipoDocument.class);
	}

	@Override
	public JornadaDocument getJornadaActiva(String idGrupo) {
		Query query= new Query();
		query.addCriteria(Criteria.where("idGrupo").is(idGrupo));
		query.addCriteria(Criteria.where("activo").is(true));
		return mongoTemplate.findOne(query, JornadaDocument.class);
	}

	@Override
	public JornadaDocument getLastJornada(String idGrupo) {
		Query query= new Query();
		query.addCriteria(Criteria.where("idGrupo").is(idGrupo));
		query.with(Sort.by(Sort.Direction.DESC, "fechaCreacion"));
		return mongoTemplate.findOne(query, JornadaDocument.class);
	}

	@Override
	public boolean saveJornada(String idGrupo, String nombre, LocalDateTime fechaCierre) {
		try {			
			JornadaDocument jornada = new JornadaDocument(idGrupo, nombre, fechaCierre);
			mongoTemplate.save(jornada);
		} catch (Exception ex) {
			logger.error("Ocurrió un error al guardar la jornda: " + ex.getMessage());
		}
		return true;
	}

	@Override
	public boolean updateJornada(String idJornada, String nombre, LocalDateTime fechaCierre) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(idJornada));
			Update update = new Update();
			update.set("nombre", nombre);
			update.set("fechaCierre", fechaCierre);

			mongoTemplate.updateFirst(query, update, JornadaDocument.class);
		} catch (Exception ex) {
			logger.error("Ocurrió un error al actuaizar la jornda: " + ex.getMessage());
		}
		return true;
	}

	@Override
	public boolean cerraJornada(String id) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(id));
			Update update = new Update();
			update.set("activo", false);

			mongoTemplate.updateFirst(query, update, JornadaDocument.class);
		} catch (Exception ex) {
			logger.error("Ocurrió un error al actuaizar la jornda: " + ex.getMessage());
		}
		return true;
	}


}
