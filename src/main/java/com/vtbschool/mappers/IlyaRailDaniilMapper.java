package com.vtbschool.mappers;

import com.vtbschool.fromxsd.ilyaraildaniil.*;

import com.vtbschool.fromxsd.rubenaidar.Tag;
import com.vtbschool.model.Group;
import com.vtbschool.model.Intern;
import com.vtbschool.model.Task;
import com.vtbschool.model.TaskTag;

import java.util.ArrayList;
import java.util.List;

public class IlyaRailDaniilMapper implements Mapper {


    @Override
    public Group mapToOur(Object obj) {
        if (!(obj instanceof Root)) {
            return null; // Throw ex;
        }
        Root root = (Root) obj;
        Group group = new Group();
        List<Intern> interns = new ArrayList<>();
        for(Team team:root.getTeams().getTeam()){

            for(Student student:team.getStudents().getStudent()){
                Intern intern = new Intern();
                intern.setId(student.getId());
                intern.setFirstName(student.getFirstName());
                intern.setLastName(student.getSecondName());

                List<Task> AllTasks = new ArrayList<>();
                for(com.vtbschool.fromxsd.ilyaraildaniil.Task task:student.getTasks().getTask()){
                    Task tasks = new Task();
                    tasks.setId(task.getId());
                    tasks.setName(task.getName());
                    List<TaskTag> tags = new ArrayList<>();
                   for(Label tag:task.getLabels().getLabel()){
                       TaskTag taskTag = new TaskTag();
                       taskTag.setName(tag.getName());
                       tags.add(taskTag);
                   }
                   tasks.setTags(tags);
                   AllTasks.add(tasks);
                }
                intern.setTasks(AllTasks);
                interns.add(intern);
            }

        }
        group.setInterns(interns);
        return group;
    }
}

