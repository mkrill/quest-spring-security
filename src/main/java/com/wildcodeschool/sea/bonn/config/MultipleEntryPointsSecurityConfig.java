package com.wildcodeschool.sea.bonn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("steveguy").password(passwordEncoder().encode("steveguy")).roles("Civilist")
          .and()
          .withUser("tonystark").password(passwordEncoder().encode("tonystark")).roles("SHIELDheroes")
          .and()
          .withUser("nickfury").password(passwordEncoder().encode("nickfury")).roles("SHIELDdirectors");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/secret-bases").hasRole("SHIELDdirectors")
		.antMatchers("/avengers/assemble").hasAnyRole("SHIELDheroes")
		.anyRequest().authenticated()
			.and()
		.formLogin()
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}

}