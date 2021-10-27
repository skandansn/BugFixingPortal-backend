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
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long issueId;

    private String issueTitle;

    private String issueDesc;

    private String issueFiles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueSol_fid",referencedColumnName = "issueId")
    private List<Solution> solutions = new ArrayList<>();

    public Issue() {
    }

    public Issue(String issueTitle, String issueDesc, String issueFiles) {
        this.issueTitle = issueTitle;
        this.issueDesc = issueDesc;
        this.issueFiles = issueFiles;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
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

    
    
}
