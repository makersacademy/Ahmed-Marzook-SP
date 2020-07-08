package com.quiz.webbiskoolsltd.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.quiz.webbiskoolsltd.services.QuizUserDetailsService;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private QuizUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
				.defaultSuccessUrl("/message").permitAll().and().logout().logoutSuccessUrl("/login").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
		;
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication().withUser("email1@gmail.com").password("ram123").roles("ADMIN");
//		  auth.inMemoryAuthentication().withUser("email2@gmail.com").password("ravan123").roles("USER");
//		  auth.inMemoryAuthentication().withUser("email3@gmail.com").password("kans123").roles("VIEW_USER");
//	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
