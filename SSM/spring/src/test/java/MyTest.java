import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
       ApplicationContext beans = new ClassPathXmlApplicationContext("beans.xml");
        Person person = beans.getBean("person",Person.class);
        System.out.println(person.toString());
    }
}
