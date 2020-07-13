package com.quiz.webbiskoolsltd.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.quiz.webbiskoolsltd.services.QuizUserDetailsService;
import com.quiz.webbiskoolsltd.services.util.JwtFilter;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private QuizUserDetailsService userDetailsService;

	@Autowired
	private JwtFilter jwtFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().formLogin().defaultSuccessUrl("/message").permitAll().and().logout().logoutSuccessUrl("/login")
				.permitAll();
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
}
