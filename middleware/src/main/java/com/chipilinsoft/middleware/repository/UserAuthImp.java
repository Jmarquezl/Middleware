package com.chipilinsoft.middleware.repository;

public class UserAuthImp implements UserAuth{

	@Override
	public AuthUserDocument getUser(String user) {
		// TODO Auto-generated method stub
		AuthUserDocument usuario =  new AuthUserDocument();
		usuario.setIdentificador("chuñi");
		usuario.setAdministrador(true);
		usuario.setDev(false);
		return usuario;
	}

}
