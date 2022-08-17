package com.thegoodseeds.seedsaversapp.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile(value = "dev")
public class SecurityConfigDev {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http// Usar o basic para se autenticar
                .authorizeRequests()
                .antMatchers("/**").permitAll() // Estou permitindo todos os acessos no sistema.
                .and().csrf().disable();


		return http.build();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
				"/swagger-resources/**", "/h2-console/**");
	}
	 
}