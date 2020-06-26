import static com.vtbschool.main.Main.*;
import com.vtbschool.model.Gender;
import com.vtbschool.model.Intern;
import com.vtbschool.model.Task;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Tests {



    @Test
    void toFromJSonXML() throws IOException, JAXBException {
//        Intern intern1 = new Intern();
//        intern1.setFirstName("John");
//        intern1.setLastName("Statham");
//        intern1.setAge(20);
//        intern1.setCompamy("VTB");
//        intern1.setGender(Gender.MALE);
//        intern1.setSkills(new String[]{"java", "sql", "handsome"});
//
//
//
//        Task task1 = new Task();
//        task1.setDescription("first task");
//        task1.setId(1);
//        task1.setName("TASK NAME 1");
//
//        Task task2 = new Task();
//        task2.setDescription("second task");
//        task2.setId(2);
//        task2.setName("TASK NAME 2");
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//        intern1.setTasks(tasks);
//
//
//        String jsonRepresentation = toJSON(intern1);
//        String xmlRepresentation = toXML(intern1);
//        System.out.println("Serialized:");
//        System.out.println(jsonRepresentation);
//        System.out.println(xmlRepresentation);
//
//        System.out.println("Now we deserialize");
//
//        Intern jsonIntern = fromJSON("intern.json");
//        Intern xmlIntern = fromXML("intern.xml");
//        System.out.println(jsonIntern);
//        System.out.println("Let's change something in deserialized object.");
//        jsonIntern.setFirstName("Boris");
//        System.out.println(jsonIntern);
//        System.out.println("Name has been nicely changed.");
    }

}