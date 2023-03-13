import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object hello01 = context.getBean("hello01");
        System.out.println(hello01.toString());

    }
}
