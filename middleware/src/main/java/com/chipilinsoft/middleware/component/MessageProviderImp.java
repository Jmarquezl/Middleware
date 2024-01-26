package com.chipilinsoft.middleware.component;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chipilinsoft.middleware.entity.BaseResponse;
import com.chipilinsoft.middleware.repository.CodeMessagesDocument;
import com.chipilinsoft.middleware.repository.QuinieleroRepository;

@Component
public class MessageProviderImp implements MessageProvider{
	private List<CodeMessagesDocument> codigos;
	@Autowired
	private QuinieleroRepository quinieleroRepository;
	
	@PostConstruct
	public void MessageProvider() 
	{
		codigos = quinieleroRepository.getCodigosError();
	}
	
	@Override
	public void assertCode(BaseResponse response, String codigo) {
		response.setCode(codigo);
		response.setMessage(codigos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().get().getMensaje());
		response.setFolio(getFolio());
	}
	private String getFolio() {
		LocalDateTime now = LocalDateTime.now();
		return String.format("%s%s%s%s%s%s", now.getYear(), String.format("%02d", now.getMonth().getValue()), 
				String.format("%02d", now.getDayOfMonth()), String.format("%02d", now.getHour()), 
				String.format("%02d", now.getMinute()), String.format("%02d", now.getSecond()));
	}
}