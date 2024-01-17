package com.chipilinsoft.middleware.component;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.BaseResponse;

@Component
public class MessageProviderImp implements MessageProvider{
	
	@Override
	public void assertCode(BaseResponse response, String codigo) {
		response.setCode(codigo);
		response.setFolio(getFolio());
	}
	private String getFolio() {
		LocalDateTime now = LocalDateTime.now();
		return String.format("%s%s%s%s%s%s", now.getYear(), String.format("%02d", now.getMonth().getValue()), 
				String.format("%02d", now.getDayOfMonth()), String.format("%02d", now.getHour()), 
				String.format("%02d", now.getMinute()), String.format("%02d", now.getSecond()));
	}
}