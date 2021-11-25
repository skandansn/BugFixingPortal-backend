package com.bfp_backend.backend.model;
public class Tester {

    private String testerHandle;

    private int testerProjects;

    public Tester(String testerHandle, int testerProjects, int testerIssues, int testerSolutions) {
        this.testerHandle = testerHandle;
        this.testerProjects = testerProjects;
        this.testerIssues = testerIssues;
        this.testerSolutions = testerSolutions;
    }

    public String getTesterHandle() {
        return testerHandle;
    }

    public void setTesterHandle(String testerHandle) {
        this.testerHandle = testerHandle;
    }

    public int getTesterProjects() {
        return testerProjects;
    }

    public void setTesterProjects(int testerProjects) {
        this.testerProjects = testerProjects;
    }

    public int getTesterIssues() {
        return testerIssues;
    }

    public void setTesterIssues(int testerIssues) {
        this.testerIssues = testerIssues;
    }

    public int getTesterSolutions() {
        return testerSolutions;
    }

    public void setTesterSolutions(int testerSolutions) {
        this.testerSolutions = testerSolutions;
    }

    private int testerIssues;

    private int testerSolutions;

}
