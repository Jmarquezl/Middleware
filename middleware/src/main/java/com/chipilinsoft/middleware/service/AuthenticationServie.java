package com.chipilinsoft.middleware.service;

import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.entity.IBaseResponse;

public interface AuthenticationServie {
	public IBaseResponse login(AuthenticationRequest request);
	public IBaseResponse refreshToken(AuthenticationRequest request);
}
