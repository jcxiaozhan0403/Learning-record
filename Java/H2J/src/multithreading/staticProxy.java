package multithreading;

public class staticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new People()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

// 真实对象
class People implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("结婚了");
    }
}

// 代理对象
class WeddingCompany implements Marry{
    private Marry target;

    public  WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        befor();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("婚前准备");
    }

    private void befor() {
        System.out.println("婚后数钱");
    }
}
