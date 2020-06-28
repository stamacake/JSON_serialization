package com.vtbschool.mappers;

import com.vtbschool.fromxsd.rubenaidar.*;
import com.vtbschool.model.Group;
import com.vtbschool.model.Intern;
import com.vtbschool.model.TaskTag;

import java.util.ArrayList;
import java.util.List;

public class RubenAidarMapper implements Mapper {

    @Override
    public Group mapToOur(Object obj) {
        if (!(obj instanceof Root)) {
            return null; // Throw ex;
        }

        Root root = (Root) obj;
        Group group = new Group();
        group.setId(root.getTeam().getId());
        List<Member> members = root.getTeam().getMembers().getValue().getMember();
        List<Intern> interns = new ArrayList<>();
        for (Member member : members) {
            Intern intern = new Intern();
            intern.setId(member.getId());
            populateNames(intern, member.getName());
            populateTasks(intern, member.getTasks().getValue());


            interns.add(intern);

        }
        group.setInterns(interns);
        return group;
    }

    private void populateNames(Intern intern, String name) {
        String[] fullName = name.split(" ");
        if (fullName.length == 0) {
            intern.setFirstName("");
            intern.setLastName("");
        }
        if (fullName.length == 2) {
            intern.setFirstName(fullName[0]);
            intern.setLastName(fullName[1]);
        }
        intern.setFirstName(fullName[0]);
        intern.setLastName("");
    }

    private void populateTasks(Intern intern, Tasks tasksWrapper) {
        List<Task> tasks = tasksWrapper.getTask();
        List<com.vtbschool.model.Task> ourTasks = new ArrayList<>();
        for (Task task : tasks) {
            com.vtbschool.model.Task ourTask = new com.vtbschool.model.Task();
            ourTask.setId(task.getId());
            ourTask.setName(task.getName());

            List<Tag> tags = task.getTags().getValue().getTag();
            populateTags(ourTask, tags);

        }
    }

    private void populateTags(com.vtbschool.model.Task task, List<Tag> tags) {
        List<TaskTag> taskTags = new ArrayList<>();

        for (Tag tag : tags) {
            TaskTag taskTag = new TaskTag();

            taskTag.setId(tag.getId());
            taskTag.setName(tag.getName());
            taskTags.add(taskTag)
        }
        task.setTags(taskTags);
    }

}
