package com.vtbschool.model;

import java.util.List;

public class Group {
    private long id;
    private List<Intern> interns;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Intern> getInterns() {
        return interns;
    }

    public void setInterns(List<Intern> interns) {
        this.interns = interns;
    }
}
