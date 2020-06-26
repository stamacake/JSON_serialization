package com.vtbschool.model;

import java.util.List;

public class Task {
    private long id;
    private String name;
    private String description;
    private List<TaskTag> tags;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskTag> getTags() {
        return tags;
    }

    public void setTags(List<TaskTag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
