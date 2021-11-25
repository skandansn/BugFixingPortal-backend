package com.bfp_backend.backend.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bfp_backend.backend.model.Issue;
import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.model.User;
import com.bfp_backend.backend.model.Solution;
import com.bfp_backend.backend.model.Tester;
import com.bfp_backend.backend.repository.IssueRepository;
import com.bfp_backend.backend.repository.SolutionRepository;
import com.bfp_backend.backend.repository.ProjectRepository;
import com.bfp_backend.backend.repository.UserRepository;
import com.bfp_backend.backend.web.dto.IssueDto;
import com.bfp_backend.backend.web.dto.ProjectDto;
import com.bfp_backend.backend.web.dto.SolutionDto;

import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;
    private IssueRepository issueRepository;
    private UserRepository userRepository;
    private SolutionRepository solutionRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, IssueRepository issueRepository, SolutionRepository solutionRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.issueRepository = issueRepository;
        this.solutionRepository = solutionRepository;
    }


    @Override
    public Project save(ProjectDto projectDto) {
        Project project = new Project(projectDto.getProjectTitle(),projectDto.getProjectDesc(),projectDto.getProjectFiles(),projectDto.getProjectDownloadNo());
        User user=userRepository.findByUserEmail(projectDto.getUserId());
        List<Project> projects=user.getProjects();
        projects.add(project);
        user.setProjects(projects);
        return projectRepository.save(project);
    }


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProject(long id) {
        return projectRepository.findById(id).get();
    }


    @Override
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
        
    }


    @Override
    public void editProject(long id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id).get();
        project.setProjectTitle(projectDto.getProjectTitle());
        project.setProjectDesc(projectDto.getProjectDesc());
        project.setProjectFiles(projectDto.getProjectFiles());
        project.setProjectDownloadNo(projectDto.getProjectDownloadNo());
        projectRepository.save(project);
        
    }

    @Override
    public Set<Long> getProjectsByUserEmail(String email) {
        User user=userRepository.findByUserEmail(email);
        List<Project> userProjects=user.getProjects();
        Set<Long> projectIds=new HashSet<>();
        for (Project project : userProjects) {
            projectIds.add(project.getProjectId());
        }
        return projectIds;
    }


    @Override
    public Issue addIssue(long id, IssueDto issueDto) {
        Project project = projectRepository.findById(id).get();
        User user=userRepository.findByUserEmail(issueDto.getUserId());
        Issue issue = new Issue(issueDto.getIssueTitle(),issueDto.getIssueDesc(),issueDto.getIssueFiles());
        List<Issue> issues=project.getIssues();
        issues.add(issue);
        project.setIssues(issues);
        List<Issue> userIssues=user.getIssues();
        userIssues.add(issue);
        user.setIssues(userIssues);
        return issueRepository.save(issue);
    }


    @Override
    public List<Issue> getIssues(long id) {
        Project project = projectRepository.findById(id).get();
        List<Issue> issues=project.getIssues();
        return issues;
    }

    @Override
    public Solution addSolution(long id, long id2, SolutionDto solutionDto) {
        Issue issue = issueRepository.findById(id2).get();
        User user=userRepository.findByUserEmail(solutionDto.getUserId());
        Solution solution = new Solution(solutionDto.getSolutionTitle(),solutionDto.getSolutionDesc(),solutionDto.getSolutionFiles());
        List<Solution> solutions=issue.getSolutions();
        solutions.add(solution);
        issue.setSolutions(solutions);
        List<Solution> userSolutions=user.getSolutions();
        userSolutions.add(solution);
        user.setSolutions(userSolutions);
        return solutionRepository.save(solution);
    }

    @Override
    public List<Solution> getSolutions(long id,long id2) {
        Issue issue = issueRepository.findById(id2).get();
        List<Solution> solutions=issue.getSolutions();
        return solutions;
    }

    @Override
    public List<Tester> getTesters(long id){
        List<Long> issues = issueRepository.findIssuesByProjectId(id);
        List<Long> users=issueRepository.findUserIdByProjectId(id);
        for (int i = 0;i < issues.size();i++){
            long iid = issues.get(i);
            List<Long> iSolutions = solutionRepository.findSolutionsByIssueId(iid);
            for (int j = 0;j < iSolutions.size();j++){
                List<Long> sUsers = solutionRepository.findUserIdByIssueId(iid);
                users.addAll(sUsers);
            }
        }
        Set<Long> set = new HashSet<>(users);
        users.clear();
        users.addAll(set);
        List<Tester> testers = new ArrayList<Tester>();
        for (int i = 0; i < users.size();i++){
            long uid = users.get(i);
            String testerHandle = userRepository.findUserHandleById(uid);
            int testerProjects = projectRepository.findProjectsFromUserId(uid).size();
            int testerIssues = issueRepository.findIssuesByProjectandUserId(id, uid).size();
            List<Long> uSolutions = new ArrayList<Long>();
            for(int j = 0;j < issues.size();j++){
            long iid = issues.get(j);
                List<Long> uSol = solutionRepository.findSolutionsByIssueandUserId(iid, uid);
                uSolutions.addAll(uSol);
            }
            int testerSolutions = uSolutions.size();
            Tester tester = new Tester(testerHandle,testerProjects,testerIssues,testerSolutions);
            testers.add(tester);
        }
        return testers;
    }

    // @Override
    // public void addSolution(long id, long id2, SolutionDto solutionDto) {
    //     Issue issue = issueRepository.findById(id2).get();
    //     issue.setSolution(solutionDto.getSolution());
    //     issueRepository.save(issue);
        
        

        
    // }
    
    
}
