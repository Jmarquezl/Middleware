package com.chipilinsoft.middleware.repository;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepoImp implements UserRepo {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepoImp.class);
	
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


}
