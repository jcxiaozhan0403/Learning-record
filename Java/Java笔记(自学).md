源文件.java
编译后的文件.class

## 环境配置
```
JAVA_HOME  jdk目录
CLASSPATH  .;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar
path  %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin
```

JDK(java开发工具包)
JRE(java运行环境)
包含关系
JDK>JRE>JVM

## 注释
```
文档注释
/**
*
*
*
*/

单行注释
//

多行注释
/*

*/
```
## 代码规范
- 包名：所有字母小写
- 类名、接口名：每个单词首字母大写
- 变量名、方法名：驼峰命名
- 常量名：所有字母大写、多单词用下划线连接

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

## 数据类型
java中有8种基本数据类型，除此之外都是引用数据类型

凡是引用数据类型，都可以使用null作为值
## 类与对象(简单)
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

## 数据类型的相关计算
char可以与数字进行运算，过程是将字母转换为ASCII值再运算

数字与字符串的拼接:String后面的所有数字都会被转换成String类型，然后进行字符串拼接，如果数字是出现在String前面，则会正常运算后拼接

## 变量类型转换
根据位数转换：小到大自动转换，大到小强制转换，short和char相互强制转换

## final
当一个变量被final修饰的时候，该变量只有一次赋值的机会，再次赋值会发生编译错误

## 算术运算符
取余的符号由被模数决定
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

## 循环
与其他语言相似，break结束循环，continue跳过此次循环
```java
//标签跳出循环
public class HelloWorld {
    public static void main(String[] args) {
          
        //打印单数    
        outloop: //outloop这个标示是可以自定义的比如outloop1,ol2,out5
        for (int i = 0; i < 10; i++) {
             
            for (int j = 0; j < 10; j++) {
                System.out.println(i+":"+j);
                if(0==j%2) 
                    break outloop; //如果是双数，结束外部循环
            }
        }
         
    }
}
```

## 数组
```java
public class HelloWorld {
    public static void main(String[] args) {
        int a[]; //声明数组
        a = new int[5]; //创建数组
        int b[] = new int[6]{0,1,2,3,4,5}; //创建数组,并赋值
         
        a[0]= 1;  //数组赋值

        System.out.println(a.length); //输出数组长度
    }
}
```

## Arrays类操作数组
```java
import java.util.Arrays;//导入Arrays类
 
public class HelloWorld {
    public static void main(String[] args) {
        int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
 
        // copyOfRange(int[] original, int from, int to)
        // 第一个参数表示源数组
        // 第二个参数表示开始位置(取得到)
        // 第三个参数表示结束位置(取不到)
        int[] b = Arrays.copyOfRange(a, 0, 3);
 
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        String content = Arrays.toString(a); //toString方法将数组作为字符串打印
        Arrays.sort(a); //sort方法将数组进行由小到大排序
        Arrays.binarySearch(a, 62); //binarySearch方法搜索元素出现的位置，必须在sort排序前提下
        System.out.println(content);
    }
}
```

## 类与对象(进阶)
用来代表类的对象的变量叫做引用
```java
public class Hero {
    String name; //姓名
      
    float hp; //血量

    public static void main(String[] args) {
        //创建一个对象
        new Hero();
         
        //使用一个引用来指向这个对象,h1就叫做引用
        Hero h1 = new Hero();
        Hero h2 = h1;  //h2指向h1所指向的对象，同一个对象可以有多个引用
        Hero h3 = h1;
        Hero h4 = h1;
        Hero h5 = h4;
    }  
}
```
继承的用法:一个类可以被多个类继承，一个类只能继承一个类
```java
public class Item {
    String name;
    int price;
}

public class Armor {
    int ac;
}
public class Weapon extends Item{
    int damage; //攻击力
     
    public static void main(String[] args) {
        Weapon infinityEdge = new Weapon();
        infinityEdge.damage = 65; //damage属性在类Weapon中新设计的
         
        infinityEdge.name = "无尽之刃";//name属性，是从Item中继承来的，就不需要重复设计了
        infinityEdge.price = 3600;
         
    }
     
}
```
包：package，一般将比较接近的类，规划在同一个包下
```java
//使用同一个包下的其他类，直接使用即可
//但是要使用其他包下的类，必须import

package charactor;
 
//Weapon类在其他包里，使用必须进行import
import property.Weapon;
 
public class Hero {
        
    String name; //姓名
        
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed; //移动速度
     
    //装备一把武器
    public void equip(Weapon w){
         
    }  
}
```
访问修饰符
```
private 私有的
package/friendly/default 不写
protected 受保护的
public 公共的
```
类与类的几种关系
```
自身：指的是Hero自己
同包子类：ADHero这个类是Hero的子类，并且和Hero处于同一个包下
不同包子类：Support这个类是Hero的子类，但是在另一个包下
同包类： GiantDragon 这个类和Hero是同一个包，但是彼此没有继承关系
其他类：Item这个类，在不同包，也没有继承关系的类
```
类方法和对象方法
```java
//如果一个方法，没有调用任何对象属性，那么就可以考虑设计为类方法，比如
    public static void printGameDuration(){
    	System.out.println("已经玩了10分50秒");
    }
```
单例模式特点
```
1. 只允许有一个实例
2. 单例类必须创建自己的实例
3. 单例类必须给其他类提供获取实例的方法
```
什么是单例模式
```
1. 构造方法私有化
2. 静态属性指向实例
3. public static的 getInstance方法，返回第二步的静态属性
```
问题：增强for循环，可变数量参数，修饰符的使用常识,单例模式