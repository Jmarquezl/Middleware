package com.chipilinsoft.middleware.service;

import com.chipilinsoft.middleware.entity.AuthenticationRequest;
import com.chipilinsoft.middleware.entity.BaseResponse;

public interface AuthenticationServie {
	public BaseResponse login(AuthenticationRequest request);
	public BaseResponse refreshToken(AuthenticationRequest request);
}
