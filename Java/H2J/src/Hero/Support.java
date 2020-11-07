package hero;

public class Support extends Hero{

    public static void main(String[] args) {
        Hero qinnv = new Hero();
        qinnv.name = "琴女";

        Hero gailun = new Hero();
        gailun.name = "盖伦";

        Hero timo = new Hero();
        timo.name = "提莫";

        qinnv.heal(timo,10);

    }
}
