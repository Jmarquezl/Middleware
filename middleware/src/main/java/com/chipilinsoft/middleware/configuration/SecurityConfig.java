package com.chipilinsoft.middleware.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.chipilinsoft.middleware.repository.UserAuth;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final UserAuth userAuth;
	
	public SecurityConfig(UserAuth userAuth) 
	{
		this.userAuth = userAuth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
				
	}
}
