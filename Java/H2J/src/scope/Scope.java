package scope;

public class Scope {
    int i = 1;
    int j = i;  //其他的属性可以访问i

    public void method1(){
        System.out.println(i); //方法1里可以访问i
    }

    public void method2(){
        System.out.println(i); //方法2里可以访问i
    }

    public void method3(int t){ //参数t的作用域即方法method3
        System.out.println(t);
    }
    public void method4(){
        //method4 不能访问参数t
        //System.out.println(t);
    }
    //类里面也不能访问参数t

    public void method5() {
        int a  = 5;  //其作用范围是从声明的第25行，到其所处于的块结束33行位置
        System.out.println(a);
        {            //子块
            System.out.println(a); //可以访问a
            int b = 6;
            System.out.println(b); //可以访问b
        }
        //不能访问b,因为其作用域到第31行就结束了
        //System.out.println(b);
    }
}