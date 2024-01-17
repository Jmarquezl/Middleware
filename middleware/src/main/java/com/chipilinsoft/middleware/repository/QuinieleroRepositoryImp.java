package com.chipilinsoft.middleware.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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


}
