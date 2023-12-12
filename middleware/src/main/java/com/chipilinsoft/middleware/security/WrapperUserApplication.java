package com.chipilinsoft.middleware.security;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chipilinsoft.middleware.repository.*;

@Service
@RequiredArgsConstructor
public class WrapperUserApplication implements UserDetailsService 
{
	@Autowired
	private final UserRepo userRepository;
  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{    
		final AuthUserDocument appUser = userRepository.getUser(username);
		if (appUser == null){
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
	
		return org.springframework.security.core.userdetails.User//
		.withUsername(username)//
		.password(appUser.getPss())//
		.authorities(appUser.getAppUserRoles())//
		.accountExpired(false)//
		.accountLocked(false)//
		.credentialsExpired(false)//
		.disabled(false)//
	    .build();
	}

}