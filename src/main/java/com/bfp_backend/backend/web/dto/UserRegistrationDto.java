package com.bfp_backend.backend.web.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bfp_backend.backend.model.Authority;
import com.bfp_backend.backend.model.Issue;
import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.model.Solution;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserRegistrationDto {

  

    private String userEmail;

    private String userHandle;

    private String userPic;

    private String userBio;

    private long userBugsReported;

    private float userRating;

    private String userPassword;

    

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String userEmail, String userHandle, String userPic, String userBio,
            long userBugsReported, float userRating, String userPassword) {
        this.userEmail = userEmail;
        this.userHandle = userHandle;
        this.userPic = userPic;
        this.userBio = userBio;
        this.userBugsReported = userBugsReported;
        this.userRating = userRating;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public long getUserBugsReported() {
        return userBugsReported;
    }

    public void setUserBugsReported(long userBugsReported) {
        this.userBugsReported = userBugsReported;
    }

    public float getUserRating() {
        return userRating;
    }

    public void setUserRating(float userRating) {
        this.userRating = userRating;
    }


    
    
}
