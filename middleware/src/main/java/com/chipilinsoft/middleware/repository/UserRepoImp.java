package com.chipilinsoft.middleware.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImp implements UserRepo {

	@Override
	public AuthUserDocument getUser(String user, String pss) {
		AuthUserDocument appUser = new AuthUserDocument();
		appUser.setUss(user);
		appUser.setPss("$2a$12$D9AbzNg9YAtc.nu54t5w5OmLhuLIzgQTGE1JTB7HQNR619Xj1tgUK");
		ArrayList<AppUserRole> roles = new ArrayList<>();
		roles.add(AppUserRole.ROLE_CLIENT);
		roles.add(AppUserRole.ROLE_ADMIN);
		appUser.setAppUserRoles(roles);
		return appUser;
	}


}
