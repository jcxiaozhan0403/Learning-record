源文件.java
编译后的文件.class

```java
public class HelloWorld{
  public static void main(String[] args){
    System.out.println("hello world");
  }
}

public //表示这是一个可以公开访问的类
class //表示这是一个类
HelloWorld //类名
public static void main(String[] args) //主方法、代码入口
```

## 类与对象
简单概念：一个有多种属性的东西，叫对象，有相同属性的对象称为一个类
```java
// 类的第一个字母大写
public class Hero {
	
	String name; //姓名
	
	float hp; //血量
	
	float armor; //护甲
	
	int moveSpeed; //移动速度
	
	public static void main(String[] args) {
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
	}	
}
```
方法是类的动作,是动态行为,用驼峰命名法

## 基本数据类型
给基本类型的变量赋值的方式叫做**字面值**
整数字面值
```java
public class HelloWorld {
    public static void main(String[] args) {
        long val = 26L; //以L结尾的字面值表示long型
        int decVal = 26; //默认就是int型
        int hexVal = 0x1a; //16进制
        int oxVal = 032; //8进制
        int binVal = 0b11010; //2进制
        System.out.println(oxVal);
    }
}
```
字符型字面值
```java
public class HelloWorld {
	public static void main(String[] args) {
		char f1 = '好';//char 只能存放一个字符，超过一个字符就会产生编译错误，char的长度和short一样，是16位
	}
}
```
字符串字面量
```java
public class HelloWorld {
	public static void main(String[] args) {
		String str = "Hello World!";;//String并不是基本类型,String类型是Immutable的
	}
}
```
布尔值字面量
```java
public class HelloWorld {
	public static void main(String[] args) {
        boolean b1 = true;//布尔值真正存放的数据是0和1，但赋值时用true和false
        boolean b2 = false;
	}
}
```
浮点数字面值
```java
public class HelloWorld {
	public static void main(String[] args) {
		float f1 = 123.4F;// 以F结尾的字面值表示float类型
		double d1 = 123.4;// 默认就是double类型
		double d2 = 1.234e2;// 科学计数法表示double
	}
}
```

## 变量类型转换
根据位数转换：小到大自动转换，大到小强制转换，short和char相互强制转换

## final
当一个变量被final修饰的时候，该变量只有一次赋值的机会，再次赋值会发生编译错误

## 逻辑运算符
长路与和短路与
```java
public class HelloWorld {
    public static void main(String[] args) {
        //长路与  无论第一个表达式的值是true或者false,第二个的值，都会被运算
        int i = 2;
        System.out.println( i== 1 & i++ ==2  ); //无论如何i++都会被执行，所以i的值变成了3
        System.out.println(i);
         
        //短路与 只要第一个表达式的值是false的，第二个表达式的值，就不需要进行运算了
        int j = 2;
        System.out.println( j== 1 && j++ ==2  );  //因为j==1返回false,所以右边的j++就没有执行了，所以j的值，还是2
        System.out.println(j);
    }
}
```
长路或和短路或
```java
public class HelloWorld {
    public static void main(String[] args) {
        //长路或  无论第一个表达式的值是true或者false,第二个的值，都会被运算
        int i = 2;
        System.out.println( i== 1 | i++ ==2  ); //无论如何i++都会被执行，所以i的值变成了3
        System.out.println(i);
         
        //短路或 只要第一个表达式的值是true的，第二个表达式的值，就不需要进行运算了
        int j = 2;
        System.out.println( j== 2 || j++ ==2  );  //因为j==2返回true,所以右边的j++就没有执行了，所以j的值，还是2
        System.out.println(j); 
    }
}
```
异或^
转换为二进制进行比较，相同为0，不同为1

## 控制台输入(Scanner)
```java
import java.util.Scanner;//表示导入Scanner这个类

public class HelloWorld {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);//创建Scanner对象
        int a = s.nextInt();//获取整数
        System.out.println("第一个整数："+a);
        int b = s.nextInt();
        System.out.println("第二个整数："+b);
    }
}
```
