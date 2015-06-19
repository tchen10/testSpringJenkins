package com.thoughtworks.acit.services;

import com.thoughtworks.acit.domain.Project;
import com.thoughtworks.acit.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjectList() {
        return this.projectRepository.getProjects();
    }

    public void save(Project project) {
        this.projectRepository.save(project);
    }
}