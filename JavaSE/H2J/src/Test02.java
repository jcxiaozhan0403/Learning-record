import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.*;
import java.lang.reflect.Field;

// 反射操作泛型
public class Test02 {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("Student");
        // 获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获取指定的类注解的值
        MyAnnotation annotation = (MyAnnotation) c1.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());

        // 获取指定的属性注解的值
        Field f = c1.getDeclaredField("name");
        MyAnnotation2 annotation1 = f.getAnnotation(MyAnnotation2.class);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.length());
    }
}

@MyAnnotation("student")
class Student {
    @MyAnnotation2(columnName = "name",type = "String",length = 10)
    private String name;
    @MyAnnotation2(columnName = "age",type = "int",length = 4)
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// 类的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String columnName();
    String type();
    int length();
}

