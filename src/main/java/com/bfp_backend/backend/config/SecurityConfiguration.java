package com.bfp_backend.backend.config;

import com.bfp_backend.backend.service.CustomUserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import org.springframework.web.cors.CorsConfiguration;

// import java.util.List;

// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter
// {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
        
//         CorsConfiguration corsConfiguration = new CorsConfiguration();
//         corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
//         corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
//         corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
//         corsConfiguration.setAllowCredentials(true);
//         corsConfiguration.setExposedHeaders(List.of("Authorization"));
        
//         // You can customize the following part based on your project, it's only a sample
//         http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
//                 .authenticated().and().csrf().disable().cors().configurationSource(request -> corsConfiguration);

        
//         // http.authorizeRequests().antMatchers("/").permitAll();


//     }
    
// }

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private CustomUserService userService;
    private JWTTokenHelper jwtTokenHelper;
    private AuthenticationEntryPoint authenticationEntryPoint;

    public SecurityConfiguration(CustomUserService userService, JWTTokenHelper jwtTokenHelper, AuthenticationEntryPoint authenticationEntryPoint) {
        this.userService = userService;
        this.jwtTokenHelper = jwtTokenHelper;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inmemory authentication
        // auth.inMemoryAuthentication()
        // .withUser("skandan").password(passwordEncoder().encode("skandan")).authorities("USER","ADMIN");

        //database authentication
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().anyRequest().permitAll();

        // http.authorizeRequests().anyRequest().authenticated();
       

        // http.formLogin();
        // http.httpBasic();
        // http.csrf().disable().cors().and().headers().frameOptions().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint).and()
				.authorizeRequests((request) -> request.antMatchers("/auth/login","/auth/register").permitAll()
						.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated())
				.addFilterBefore(new JWTAuthenticationFilter(userService, jwtTokenHelper),
						UsernamePasswordAuthenticationFilter.class);

        http.cors();
		http.csrf().disable().headers().frameOptions().disable();

    }



}

