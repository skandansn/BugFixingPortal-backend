package com.bfp_backend.backend.web.dto;

public class ProjectDto {
    
    private String projectTitle;

    private String projectDesc;

    private String projectFiles;

    private long projectDownloadNo;

    private String userId;

    
    public ProjectDto() {
    }

    public ProjectDto(String projectTitle, String projectDesc, String projectFiles, long projectDownloadNo, String userId) {
        this.projectTitle = projectTitle;
        this.projectDesc = projectDesc;
        this.projectFiles = projectFiles;
        this.projectDownloadNo = projectDownloadNo;
        this.userId = userId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDesc() {
        return projectDesc;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectFiles() {
        return projectFiles;
    }

    public void setProjectFiles(String projectFiles) {
        this.projectFiles = projectFiles;
    }

    public long getProjectDownloadNo() {
        return projectDownloadNo;
    }

    public void setProjectDownloadNo(long projectDownloadNo) {
        this.projectDownloadNo = projectDownloadNo;
    }

    
}
