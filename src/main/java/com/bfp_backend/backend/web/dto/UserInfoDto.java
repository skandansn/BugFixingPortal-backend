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

public class UserInfoDto {

  

    private String userEmail;

    private String userHandle;

    private String userPic;

    private String userBio;

    private long userBugsReported;

    private float userRating;


   
    private List<Project> projects = new ArrayList<>();

  
    private List<Issue> issues = new ArrayList<>();
    
   
    private List<Solution> solutions = new ArrayList<>();

   
    private  Object[] authorities;

    public UserInfoDto() {
    }

    public UserInfoDto(String userEmail,String userHandle, String userPic, String userBio, long userBugsReported,
            float userRating) {
        this.userEmail=userEmail;
        this.userHandle = userHandle;
        this.userPic = userPic;
        this.userBio = userBio;
        this.userBugsReported = userBugsReported;
        this.userRating = userRating;
    }

   

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public void setAuthorities(Object[] objects) {
        this.authorities = objects;
    }



    
    
}
