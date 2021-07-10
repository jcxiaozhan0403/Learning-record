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

        //加强型for循环,用于遍历数组，但有缺点，缺点就是无法对数组元素进行操作
        int a[] = new int[]{24,58,74,51,74};

        for(int each : a){
            System.out.println(each);
        }
    }
}
