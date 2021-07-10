package reflection;

// 获得类的信息
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflection.Person");

        c1.getName(); //获得包名 + 类名
        c1.getSimpleName(); //获得类名
        c1.getFields(); //获得public属性
        c1.getDeclaredFields(); //获得全部属性
        c1.getDeclaredField("demo"); //获得指定属性的值
        c1.getMethods(); //获得本类及其父类的全部public方法
        c1.getDeclaredMethods(); //获得本类的所有方法
        c1.getMethod("demo",null); //获得指定方法
        c1.getConstructors(); //获取所有public构造器
        c1.getDeclaredConstructors(); //获取所有构造器
        c1.getDeclaredConstructor(String.class,int.class); //获取指定构造器

    }
}
