package com.chipilinsoft.middleware.entity;

import lombok.Data;

@Data
public class AuthenticationRequest implements IBaseRequest{
	private String uss;
	private String pss;
}
