package com.chipilinsoft.middleware.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImp implements UserRepo {

	@Override
	public AuthUserDocument getUser(String user, String pss) {
		AuthUserDocument appUser = new AuthUserDocument();
		appUser.setUss(user);
		appUser.setPss(pss);
		return appUser;
	}


}
