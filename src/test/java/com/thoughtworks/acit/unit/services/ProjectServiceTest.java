package com.thoughtworks.acit.unit.services;

import com.thoughtworks.acit.domain.Project;
import com.thoughtworks.acit.repositories.ProjectRepository;
import com.thoughtworks.acit.services.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;


/**
 * Created by sradloff on 6/18/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {
    @Mock
    private ProjectRepository mockProjectRepository;

    ProjectService projectService;
    Project projectA;

    @Test
    public void shouldGetListOfAllProjects() throws Exception {
        projectService = new ProjectService(mockProjectRepository);
        projectA = new Project();
        projectA.setName("Project A");
        projectService.save(projectA);
        verify(mockProjectRepository).save(projectA);
        projectService.getProjectList();
        verify(mockProjectRepository).getProjects();
    }

}