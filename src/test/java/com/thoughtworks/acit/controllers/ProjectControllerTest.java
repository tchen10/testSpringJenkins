package com.thoughtworks.acit.controllers;

import com.thoughtworks.acit.domain.Project;
import com.thoughtworks.acit.services.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProjectControllerTest {

    @Mock
    ProjectService mockProjectService;

    ProjectController projectController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        projectController = new ProjectController();
        projectController.projectService = mockProjectService;
    }

    @Test
    public void shouldDisplayAllTasks() {
        List<Project> expectedProjectList = new ArrayList<>();
        when(mockProjectService.getProjectList()).thenReturn(expectedProjectList);

        ModelAndView modelAndView = projectController.display();

        assertEquals("projects", modelAndView.getViewName());
        assertEquals(expectedProjectList, modelAndView.getModelMap().get("projectList"));
    }
}