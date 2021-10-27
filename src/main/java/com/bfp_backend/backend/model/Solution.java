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

    private String solutionDesc;
    
    public Solution() {
    }

    public Solution(String solutionFiles, String solutionDesc) {
        this.solutionFiles = solutionFiles;
        this.solutionDesc = solutionDesc;
    }

    public long getSolutionId() {
        return solutionId;
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
