package com.thoughtworks.acit.repositories;

import com.thoughtworks.acit.domain.Project;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by sradloff on 6/18/15.
 */
public class ProjectRepositoryTest {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessions;

    private ProjectRepository projectRepository = new ProjectRepository();

    @Test
    public void testGetProjects() throws Exception {
        Project project = new Project();
        project.setName("Test A");
        assertThat(projectRepository.getProjects().size() , is(0));
    }
}