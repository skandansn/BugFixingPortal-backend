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

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;

    private String projectTitle;

    private String projectDesc;

    private String projectFiles;

    private long projectDownloadNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectIssue_fid",referencedColumnName = "projectId")
    private List<Issue> issues = new ArrayList<>();

    public Project() {
    }

    public Project(String projectTitle, String projectDesc, String projectFiles, long projectDownloadNo) {
        this.projectTitle = projectTitle;
        this.projectDesc = projectDesc;
        this.projectFiles = projectFiles;
        this.projectDownloadNo = projectDownloadNo;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
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
