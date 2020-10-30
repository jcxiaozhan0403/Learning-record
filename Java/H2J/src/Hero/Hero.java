package Hero;

public class Hero {

    String name; //姓名

    float hp; //血量

    float armor; //护甲

    int moveSpeed; //移动速度

    public static void main(String[] args) {
    //创建对象
        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616.28f;
        garen.armor = 27.536f;
        garen.moveSpeed = 350;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 383f;
        teemo.armor = 14f;
        teemo.moveSpeed = 330;

        float nowHp =  teemo.getHp();
        System.out.println(nowHp);
    }
    //创建无返回值的方法
    void keng(){
        System.out.println("坑队友！");
    }

    //创建有返回值的方法
    float getArmor(){
        return armor;
    }

    //带参方法
    void addSpeed(int speed){
        //在原来的基础上增加移动速度
        moveSpeed = moveSpeed + speed;
    }

    void legendary(){
        System.out.println("超神！");
    }

    float getHp(){
        return hp;
    }

    float recovery(float blood){
        hp = hp + blood;
        return blood;
    }
}
