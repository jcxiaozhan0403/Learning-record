public class Demo{
    public static void print(String... names) {
        int count = names.length;    // 获取总个数
        System.out.println("本次参加考试的有"+count+"人，名单如下：");
        for(int i = 0;i < names.length;i++) {
            System.out.println(names[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        print("张强","李成","王勇");    // 传入3个值
        print("马丽","陈玲");
    }
}