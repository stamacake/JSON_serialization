import com.vtbschool.InternSerializer;
import com.vtbschool.SerializationFactory;
import com.vtbschool.model.Gender;
import com.vtbschool.model.Group;
import com.vtbschool.model.Intern;
import com.vtbschool.model.Task;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tests {

    @Test
    void toFromJSonXML() {
        Intern intern1 = new Intern();
        intern1.setFirstName("John");
        intern1.setLastName("Statham");
        intern1.setAge(20);
        intern1.setCompamy("VTB");
        intern1.setGender(Gender.MALE);
        intern1.setSkills(Arrays.asList("java", "sql", "maven"));
        intern1.setId(2201);

        List<Task> tasks = new ArrayList<>();
        Task t1 = new Task();
        t1.setId(11);
        t1.setName("Generate XSD");
        t1.setDescription("generate xsd schema using specific software");
        tasks.add(t1);
        intern1.setTasks(tasks);

        Group g = new Group();
        g.setId(333);

        Intern intern2 = new Intern();
        intern2.setFirstName("Katy");
        intern2.setLastName("Perry");
        intern2.setAge(20);
        intern2.setCompamy("VTB");
        intern2.setGender(Gender.FEMALE);
        intern2.setSkills(Arrays.asList("go", "sql", "devops"));
        intern2.setId(2202);

        List<Task> tasks2 = new ArrayList<>();
        Task t2 = new Task();
        t2.setId(15);
        t2.setName("Generate JSON");
        t2.setDescription("generate json schema using specific software");
        tasks2.add(t2);
        intern2.setTasks(tasks2);


        g.setInterns(Arrays.asList(intern1,intern2));


        InternSerializer serializer = new SerializationFactory().getXMLSerializer();

        serializer.serialize("group.xml",g);
    }

}