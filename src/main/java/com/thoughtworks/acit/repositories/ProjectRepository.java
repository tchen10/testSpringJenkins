package com.thoughtworks.acit.repositories;

import com.thoughtworks.acit.domain.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProjectRepository {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessions;

    public void save(Project project) {
        Session session = sessions.getCurrentSession();
        session.save(project);
    }

    public List<Project> getProjects() {
        return sessions.getCurrentSession().createQuery("from Project").list();
    }
}
