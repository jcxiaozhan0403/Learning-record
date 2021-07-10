package object_;

public class Hero {
    String name;
    int leavel;

    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        Hero gailun = new Hero();
        gailun.name = "盖伦";

        Hero timo = new Hero();
        timo.name = "盖伦";

        System.out.println(gailun.toString());
        System.out.println(gailun.equals(gailun));
    }
}
