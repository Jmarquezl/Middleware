package com.chipilinsoft.middleware.component;

import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.BaseResponse;

@Component
public class MessageProviderImp implements MessageProvider{
	
	@Override
	public void assertCode(BaseResponse response, String codigo) {
		response.setCode(codigo);
	}

}
