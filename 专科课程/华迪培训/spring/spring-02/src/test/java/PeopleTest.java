import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.People;

public class PeopleTest {
    @Test
    public void t1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people);
        people.getCat().eat();
        people.getDog().eat();
    }
}
