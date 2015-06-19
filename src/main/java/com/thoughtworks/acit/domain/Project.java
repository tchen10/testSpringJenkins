package com.thoughtworks.acit.domain;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name="id_generator", sequenceName="project_project_id_seq")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="id_generator")
    private int project_id;
    private String name;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
