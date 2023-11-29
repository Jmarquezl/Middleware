package com.chipilinsoft.middleware.repository;

public interface UserRepo {
	AuthUserDocument getUser(String user, String pss);
}
