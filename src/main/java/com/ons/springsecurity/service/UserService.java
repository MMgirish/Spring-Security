package com.ons.springsecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ons.springsecurity.model.User;
import com.ons.springsecurity.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User>optionalUser= userRepository.findByUsername(username);
		
		optionalUser.orElseThrow(()-> new UsernameNotFoundException("UserName not found!!...."));
		
		return optionalUser.map(CustomeUserDetails::new).get();
	}

}
