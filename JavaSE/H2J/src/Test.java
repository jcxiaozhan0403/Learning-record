import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class student = Class.forName("Student");
        Constructor constructor = student.getDeclaredConstructor(String.class, int.class);
        Student stu1 = (Student) constructor.newInstance("李爽", 18);
        System.out.println(stu1.toString());


    }
}