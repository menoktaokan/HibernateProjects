package com.okan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users= User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("okan").password("yilmaz").roles("ADMIN"))
		.withUser(users.username("ali").password("can").roles("PERSONEL"))
		.withUser(users.username("a").password("a").roles("PERSONEL"))
		.withUser(users.username("fethi").password("sen").roles("PERSONEL"));
		// TODO Auto-generated method stub
//		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated(); //gelen bütün istekleri kontrol et (hepsini ele al)
		
		http.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/authenticateTheUser") //işi springe yaptırmak istediğimizi söyledik
		.permitAll();
		
		http.logout().permitAll();
	}

	
}
