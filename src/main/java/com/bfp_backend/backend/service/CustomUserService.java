package com.bfp_backend.backend.service;

import com.bfp_backend.backend.model.User;
import com.bfp_backend.backend.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    UserRepository userRepository;

    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user=userRepository.findByUserEmail(userEmail);

        if(user==null){
            throw new UsernameNotFoundException("User not found with email: "+userEmail);
        }
        return user;
    }

}
    

