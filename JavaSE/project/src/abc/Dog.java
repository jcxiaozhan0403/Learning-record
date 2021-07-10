package abc;

public class Dog extends Animals{
    public static void main(String[] args) {
        Dog one = new Dog();
        one.name = "小黄";
        one.age = 3;
        one.color = "yello";
        one.run("小黄");
    }
}
