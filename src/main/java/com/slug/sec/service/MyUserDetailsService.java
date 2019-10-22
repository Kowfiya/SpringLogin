package com.slug.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.slug.sec.entity.User;
import com.slug.sec.impls.UserImpl;
import com.slug.sec.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No existe el usuario");
		}
		
		return new UserImpl(user);
	}

}
