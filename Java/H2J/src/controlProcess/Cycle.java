package controlProcess;

public class Cycle {
    public static void main(String[] args) {
        int i = 0;

        //只要while中的表达式成立，就会不断地循环执行
        while(i<5){
            System.out.println(i);
            i++;
        }

        //无论是否成立，先执行一次，再进行判断
        do{
            System.out.println(i);
            i++;
        }while(i<5);

        //for循环，和while一样，只是表达方式不一样
        for(int x = 0;x<5;x++){
            System.out.println(x);
        }
    }
}
