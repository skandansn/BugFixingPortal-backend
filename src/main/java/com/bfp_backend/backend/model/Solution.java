package com.bfp_backend.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    public Solution() {
    }

    public Solution(String solutionFiles, String solutionDesc, String solutionTitle) {
        this.solutionFiles = solutionFiles;
        this.solutionDesc = solutionDesc;
        this.solutionTitle = solutionTitle;
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

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    

    
}
