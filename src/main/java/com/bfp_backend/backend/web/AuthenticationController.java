package com.bfp_backend.backend.web;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import com.bfp_backend.backend.config.JWTTokenHelper;
import com.bfp_backend.backend.model.User;
import com.bfp_backend.backend.service.CustomUserService;
import com.bfp_backend.backend.web.dto.AuthenticationRequestDto;
import com.bfp_backend.backend.web.dto.LoginResponseDto;
import com.bfp_backend.backend.web.dto.UserInfoDto;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private JWTTokenHelper jwtTokenHelper;
    private CustomUserService userDetailsService;

    public AuthenticationController(AuthenticationManager authenticationManager, JWTTokenHelper jwtTokenHelper,CustomUserService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenHelper = jwtTokenHelper;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws InvalidKeySpecException, NoSuchAlgorithmException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequestDto.getUsername(),
                    authenticationRequestDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        User user=(User)authentication.getPrincipal();
        String jwtToken=jwtTokenHelper.generateToken(user.getUsername());

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(jwtToken);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/userInfo")
    public ResponseEntity<?> getUserInfo(Principal user)
    {

        User userObject=(User)userDetailsService.loadUserByUsername(user.getName());

        UserInfoDto userInfoDto=new UserInfoDto(userObject.getUserEmail(),userObject.getUserHandle(),userObject.getUserPic(),userObject.getUserBio(),userObject.getUserBugsReported(),userObject.getUserRating());
        userInfoDto.setAuthorities(userObject.getAuthorities().toArray());
        return ResponseEntity.ok(userInfoDto);
    }
  
    
}
