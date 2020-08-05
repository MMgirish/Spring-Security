package com.ons.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ons.springsecurity.repository.UserRepository;
import com.ons.springsecurity.service.UserService;

@Configuration
@EnableJpaRepositories (basePackageClasses = UserRepository.class)
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserService userService;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests()
//			.antMatchers("/").permitAll()
//			.antMatchers("/dashboard").access("hasAnyRole('USER','ADMIN')")
//			.antMatchers("/admin").access("hasRole('ADMIN')")
//			.and().formLogin().permitAll()
//			.and().logout().permitAll();
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/dashboard.jsf").hasAnyRole("USER","ADMIN")
			.antMatchers("/admin.jsf").hasRole("ADMIN")
			.antMatchers("/admin/viewList.jsf").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			.defaultSuccessUrl("/dashboard.jsf")
			.and()
			.logout().permitAll();
		http.csrf().disable();
	}
	
	private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

}
