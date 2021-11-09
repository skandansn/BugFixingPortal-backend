package com.bfp_backend.backend.web.dto;

public class IssueDto {
    
    private String issueTitle;

    private String issueDesc;

    private String issueFiles;

    private String userId;

    
    public IssueDto() {
    }

    public IssueDto(String issueTitle, String issueDesc, String issueFiles, String userId) {
        this.issueTitle = issueTitle;
        this.issueDesc = issueDesc;
        this.issueFiles = issueFiles;
        this.userId = userId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String getIssueFiles() {
        return issueFiles;
    }

    public void setIssueFiles(String issueFiles) {
        this.issueFiles = issueFiles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

 

    
}
