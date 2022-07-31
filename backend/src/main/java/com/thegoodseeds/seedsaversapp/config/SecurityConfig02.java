package com.thegoodseeds.seedsaversapp.config;


import org.springframework.context.annotation.Configuration;

/*This set the configuration is to enable this backend application that is in hosted in a platform Heroku 
 * be accessed by another hosted in git hub - for standards cross-plataform comes disable*/

@Configuration
//@EnableWebSecurity
public class SecurityConfig02 {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.headers().frameOptions().disable();
//		http.cors().and().csrf().disable();// this method liberates the CORS based on that configuration below.
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll());
//
//		return http.build();
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}