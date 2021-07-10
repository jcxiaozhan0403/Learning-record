package item;

public class Armor extends Item {
    int ac;

    public static void main(String[] args) {
        Armor bujia = new Armor();
        Armor suozijia = new Armor();

        bujia.price = 300;
        bujia.name = "布甲";
        bujia.ac = 15;

        suozijia.price = 500;
        suozijia.name = "锁子甲";
        suozijia.ac = 40;
    }
}
