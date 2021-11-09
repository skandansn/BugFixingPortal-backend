package com.bfp_backend.backend.web.dto;

public class SolutionDto {
    
    private String solutionTitle;

    private String solutionDesc;

    private String solutionFiles;

    private String userId;

    
    public SolutionDto() {
    }

    public SolutionDto(String solutionTitle, String solutionDesc, String solutionFiles, String userId) {
        this.solutionTitle = solutionTitle;
        this.solutionDesc = solutionDesc;
        this.solutionFiles = solutionFiles;
        this.userId = userId;
    }

    public String getsolutionTitle() {
        return solutionTitle;
    }

    public void setsolutionTitle(String solutionTitle) {
        this.solutionTitle = solutionTitle;
    }

    public String getsolutionDesc() {
        return solutionDesc;
    }

    public void setsolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    public String getsolutionFiles() {
        return solutionFiles;
    }

    public void setsolutionFiles(String solutionFiles) {
        this.solutionFiles = solutionFiles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

 

    
}
