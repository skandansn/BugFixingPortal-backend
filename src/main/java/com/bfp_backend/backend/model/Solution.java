package com.bfp_backend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solutions")
public class Solution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long solutionId;

    private String solutionFiles;

    private String solutionTitle;

    private String solutionDesc;

    @ManyToOne
    private Issue issue;
    
    @ManyToOne
    private User user;

    public Solution() {
    }

    public Solution(String solutionTitle, String solutionDesc,String solutionFiles) {
        this.solutionTitle = solutionTitle;
        this.solutionDesc = solutionDesc;
        this.solutionFiles = solutionFiles;
        
    }

    public long getSolutionId() {
        return solutionId;
    }
    

    public String getSolutionTitle() {
        return solutionTitle;
    }

    public void setSolutionTitle(String solutionTitle) {
        this.solutionTitle = solutionTitle;
    }

    public void setSolutionId(long solutionId) {
        this.solutionId = solutionId;
    }

    public String getSolutionFiles() {
        return solutionFiles;
    }

    public void setSolutionFiles(String solutionFiles) {
        this.solutionFiles = solutionFiles;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    

    
}
