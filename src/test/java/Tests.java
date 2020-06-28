import com.vtbschool.SerializationFactory;
import com.vtbschool.fromxsd.rubenaidar.Root;
import com.vtbschool.mappers.IlyaRailDaniilMapper;
import com.vtbschool.mappers.Mapper;
import com.vtbschool.mappers.RubenAidarMapper;
import com.vtbschool.model.Gender;
import com.vtbschool.model.Group;
import com.vtbschool.model.Intern;
import com.vtbschool.model.Task;
import com.vtbschool.serializers.AnySerializer;
import org.junit.jupiter.api.Test;

import java.io.File;
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


        g.setInterns(Arrays.asList(intern1, intern2));


        AnySerializer serializer = new SerializationFactory(Group.class).getXMLSerializer();
        serializer.serialize("group.xml", g);
    }

    @Test
    void anotherTeamXml() {
        File file = new File(
                getClass().getClassLoader().getResource("team.xml").getFile()
        );
        AnySerializer<Root> serializer = new SerializationFactory<Root>(Root.class).getXMLSerializer();
        Root root = serializer.deserialize(file);
        AnySerializer<Group> groupSerializer = new SerializationFactory<Group>(Group.class).getXMLSerializer();
        Mapper rubenAidarMapper = new RubenAidarMapper();
        Group group = rubenAidarMapper.mapToOur(root);
        groupSerializer.serialize("erubenAidar.xml", group);

    }

    @Test
    void ilyaraildaniil(){
        File file = new File(
                getClass().getClassLoader().getResource("TeamsDIR.xml").getFile()
        );
        AnySerializer<com.vtbschool.fromxsd.ilyaraildaniil.Root> serializer = new SerializationFactory<>(com.vtbschool.fromxsd.ilyaraildaniil.Root.class).getXMLSerializer();
        com.vtbschool.fromxsd.ilyaraildaniil.Root root = serializer.deserialize(file);
        AnySerializer<Group> groupSerializer = new SerializationFactory<Group>(Group.class).getXMLSerializer();
        Mapper ilyaRailDaniil = new IlyaRailDaniilMapper();
        Group group = ilyaRailDaniil.mapToOur(root);
        groupSerializer.serialize("IlyaRailDaniil.xml", group);
    }

}