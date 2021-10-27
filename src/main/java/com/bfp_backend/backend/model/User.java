package com.bfp_backend.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "userEmail"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String userEmail;

    private String userHandle;

    private String userPassword;

    private String userPic;

    private String userBio;

    private long userBugsReported;

    private float userRating;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectUser_fid",referencedColumnName = "userId")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueUser_fid",referencedColumnName = "userId")
    private List<Issue> issues = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solutionIssue_fid",referencedColumnName = "userId")
    private List<Solution> solutions = new ArrayList<>();

    public User() {
    }

    public User(String userHandle, String userPassword, String userPic, String userBio, long userBugsReported,
            float userRating) {
        this.userHandle = userHandle;
        this.userPassword = userPassword;
        this.userPic = userPic;
        this.userBio = userBio;
        this.userBugsReported = userBugsReported;
        this.userRating = userRating;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    
    
}
