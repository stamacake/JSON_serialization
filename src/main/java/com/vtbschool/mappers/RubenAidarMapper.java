package com.vtbschool.mappers;

import com.vtbschool.fromxsd.rubenaidar.Member;
import com.vtbschool.fromxsd.rubenaidar.Task;
import com.vtbschool.fromxsd.rubenaidar.Tasks;
import com.vtbschool.fromxsd.rubenaidar.Team;
import com.vtbschool.model.Group;
import com.vtbschool.model.Intern;

import java.util.ArrayList;
import java.util.List;

public class RubenAidarMapper implements Mapper {

    @Override
    public Group mapToOur(Object obj) {
        if (!(obj instanceof Team)) {
            return null; // Throw ex;
        }
        Team team = (Team) obj;
        Group group = new Group();
        group.setId(team.getId());
        List<Member> members = team.getMembers().getValue().getMember();
        List<Intern> interns = new ArrayList<>();
        for (Member member : members) {
            Intern intern = new Intern();
            intern.setId(member.getId());
            populateNames(intern, member.getName());
            populateTasks(intern, member.getTasks().getValue());

        }
        return null;
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
        for (Task task : tasks) {

        }
    }
}
