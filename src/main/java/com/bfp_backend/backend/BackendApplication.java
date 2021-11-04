package com.bfp_backend.backend;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.bfp_backend.backend.model.Authority;
import com.bfp_backend.backend.model.User;
import com.bfp_backend.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendApplication {

	// @Autowired
	// private UserRepository userRepository;

	// @Autowired
	// private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @PostConstruct
	// protected void init()
	// {
	// 	List<Authority> authorities = new ArrayList<Authority>();
	// 	authorities.add(new Authority("USER","User role"));
	// 	authorities.add(new Authority("ADMIN","Admin role"));

	// 	User user=new User();

	// 	user.setUserEmail("godskandan3@gmail.com");
	// 	user.setUserHandle("skandansn");
	// 	user.setUserBio("trial for me");
	// 	user.setUserBugsReported(0);
	// 	user.setUserPic("userPic");
	// 	user.setUserRating(1);
	// 	user.setUserPassword(passwordEncoder.encode("password"));
	// 	user.setEnabled(true);
	// 	user.setAuthorities(authorities);
		
	// 	userRepository.save(user);



	// }

}
