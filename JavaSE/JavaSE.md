## IDEA快捷键
```
Alt+Ins 生成方法
Ctrl+Alt+t 创建异常代码块
```

## 常用DOS命令
进入磁盘
```
盘符+冒号
例：D:
```
查看当前目录下的所有文件
```
dir
```
切换文件夹
```
cd+目录
例：cd /d \demo
    cd demo
```
清空终端消息
```
cls
```
查看ip
```
ipconfig
```
打开常用软件
```
calc 计算器
mspaint 画图
notepad 记事本
```
文件操作
```
md 目录名 (创建目录)
rd 目录名 (删除目录)
cd> 文件名 (文件名)
del 文件名
```
生成java文档
```
javadoc -encoding UTF-8 -charset UTF-8 java文件名
```

源文件.java
编译后的文件.class

## 环境配置
JAVA_HOME  jdk根目录
path  %JAVA_HOME%\jre\bin  %JAVA_HOME%\bin

JDK(java开发工具包)
JRE(java运行环境，包含一些函数、库之类的)
JVM(java虚拟机，负责编译)
包含关系
JDK>JRE>JVM

## 注释
```JAVA
//文档注释
/**
*
*
*
*/

//常见文档注释
/**
*
* @author 作者名
* @version 版本号
* @since 指明jdk版本
* @param 参数名
* @return 返回值情况
* @throws 异常抛出情况
*/

//单行注释
//

//多行注释
/*

*/
```

## 代码规范
- 包名：所有字母小写
- 类名、接口名：首字母大写
- 变量名、方法名：驼峰命名
- 常量名：所有字母大写、多单词用下划线连接

```java
public class HelloWorld

//public      表示这是一个可以公开访问的类
//class       表示这是一个类
//HelloWorld  表示类的名字，每个单词的首字母大写
```

主方法
```java
public static void main(String[] args)
```

打印语句
```java
System.out.println("hello world");
```

## 什么是字节
位(bit)：是计算机内部数据储存的最小单位，11001100是一个八位二进制数
字节(byte)：是计算机中数据处理的基本单位，习惯上用B来表示
1B = 8bit
1024B = 1KB
1024KB = 1M
1024M = 1G
字符：是指计算机中使用的字母、数字、字和符号

## 进制
二进制：0b
十进制
八进制：0
十六进制：0x

## 数据类型
Java是一种强类型语言，强类型语言：先定义后使用，数据类型严格

java中有8种基本数据类型，除此之外都是引用数据类型

凡是引用数据类型，都可以使用null作为值

```
类型       包装类     字节
int        Intger     4
float      Float      4
double     Double     8
boolean    Boolean    1
char       Character  2
           String
byte       Byte       1
short      Short      2
long       Long       8
```

## equals与==的区别
- 源码分析
==比较的是两个字符串的引用地址值相不相同
由下面这段equals源码可以分析出equals是先将两个字符串的引用地址拿来进行比较，如果相同则返回true，如果不相同再判断传入字符串是否为String类的实例，如果不是，则返回false，如果是，则将传入字符串转换为String类型，先比较两个字符串的长度，长度一致再将字符串拆分为两个char数组进行遍历比较，如果相同再返回true

- 总结：可以简单理解为== 对比的是两个字符串的引用地址，equals对比的是两个字符串的字面值
```java
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

## 字面值
给基本类型的变量赋的值叫做字面值

## 数据类型的相关计算
char可以与数字进行运算，过程是将字母转换为ASCII值再运算

数字与字符串的拼接:String后面的所有数字都会被转换成String类型，然后进行字符串拼接，如果数字是出现在String前面，则会正常运算后拼接

## 变量类型转换
根据位数转换：小到大自动转换，大到小强制转换，short和char相互强制转换

## final
当一个变量被final修饰的时候，该变量只有一次赋值的机会，再次赋值会发生编译错误

final 除了修饰变量，还可以修饰类，修饰方法

被final修饰的类不能被继承

被final修饰的方法不能被重写

被final修饰的引用只有一次指向对象的机会

## 算术运算符
取余的符号由被模数决定

## 赋值运算符
等号可以连续赋值

## 逻辑运算符
```java
&&  //逻辑与
||  //逻辑或
!   //逻辑非
&   //短路与
|   //短路或
^   //异或
```

## 位运算符
正数二进制-->反码-->加1-->负数二进制
```java
n << m      //左移，值等于n*2的m次方
n >> m      //右移，值等于n/2的m次方，如果为负数运算，则右移后在前两位补1
n >>> m     //无符号右移，右移后的最前两位补0
&           //逻辑与
|           //逻辑或
^           //异或运算，转为二进制，相同为0，不同为1
~           //反码，1和0取反，正负号取反
```

## JavaDoc
Java API 文档，可以通过命令行用命令生成或者使用idea生成

## Scanner
```java
Scanner s = new Scanner(System.in);

//判断输入的数是不是一个整数类型
s.hasNextInt();

//判断输入的数是不是一个小数类型
s.hasNextFloat();

//使用Scanner读取整数
int a = s.nextInt();
System.out.println("第一个整数："+a);

//使用Scanner读取浮点数
float b = s.nextFloat();
System.out.println("第二个整数："+b);

//使用Scanner读取字符串
String c = s.nextLine();
System.out.println("读取的字符串是："+c);

s.close(); //关闭，避免内存浪费
```
nextLine()与next()的区别：
- next()读取到空白符就结束，常见空白字符：空格、Tab、回车
- nextLine()读取到回车结束也就是"\r"

- nextLine()在读取字符时不做特殊处理
- next()在读取字符时，会将第一个字符之前的空白字符过滤掉

## switch判断
switch语句中的变量类型可以是byte、short、int、char、String
```java
int score = 100

switch (score) {
case 100:
    System.out.println("优秀");
    break;
case 90:
    System.out.println("良好");
    break;
case 80:
    System.out.println("及格");
    break;
case 50:
    System.out.println("不及格");
    break;
default:
    System.out.println("查不到");
    break;
}
```

## 循环
与其他编程语言相似，break结束循环，continue跳过此次循环
```java
//标签跳出循环
public class HelloWorld {
    public static void main(String[] args) {
          
        //打印单数    
        outloop: //outloop这个标签是可以自定义的比如outloop1,ol2,out5
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

## 方法重载
同名方法不同数量或类型的参数传入，得到不同的返回值，通过方法的重载实现，如果有多个同名方法，系统会在调用时自动选择对应数量参数的一个
重载规则：
- 方法名称必须相同
- 参数列表必须不同(个数不同、或类型不同、参数排列顺序不同等等)
- 方法的返回值类型可以相同也可以不同
- 仅仅返回类型不同不足以成为方法重载

## 可变参数方法
不定参数的方法是用来避免代码冗余的
- 可变参数只能作为函数的最后一个参数，但其前面可以有也可以没有任何其他参数
- 由于可变参数必须是最后一个参数，所以一个函数最多只能有一个可变参数
- Java的可变参数，会被编译器转型为一个数组
- 变长参数在编译为字节码后，在方法签名中就是以数组形态出现的。这两个方法的签名是一致的，不能作为方法的重载。如果同时出现，是不能编译通过的。可变参数可以兼容数组，反之则不成立
```java
public void foo(String...varargs){}

foo("arg1", "arg2", "arg3");

//上述过程和下面的调用是等价的
foo(new String[]{"arg1", "arg2", "arg3"});
```

```java
public class StudentTestMethod {
    // methodName({paramList},paramType…paramName)
    // methodName 表示方法名称
    // paramList 表示方法的固定参数列表
    // paramType 表示可变参数的类型
    // … 是声明可变参数的标识
    // paramName 表示可变参数名称。
    
    
    // 定义输出考试学生的人数及姓名的方法
    public void print(String...names) {
        int count = names.length;    // 获取总个数
        System.out.println("本次参加考试的有"+count+"人，名单如下：");
        for(int i = 0;i < names.length;i++) {
            System.out.println(names[i]);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StudentTestMethod student = new StudentTestMethod();
        student.print("张强","李成","王勇");    // 传入3个值
        student.print("马丽","陈玲");
    }
}
```

## 数组的定义
```java
int[] numbers = {0,2,4,8,6,7};
或
int[] numbers = new int[6];
```

## 复制数组

```java
System.arraycopy(src, srcPos, dest, destPos, length)

//src: 源数组
//srcPos: 从源数组复制数据的起始位置
//dest: 目标数组
//destPos: 复制到目标数组的起始位置
//length: 复制的长度
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

         //toString方法将数组作为字符串打印
        String content = Arrays.toString(a);

        //sort方法将数组进行由小到大排序
        Arrays.sort(a); 

        //binarySearch方法搜索元素出现的位置，必须在sort排序前提下
        //数字62出现的位置
        Arrays.binarySearch(a, 62); 

        //比较两个数组内容是否完全相同
        Arrays.equals(a, b)

        //填充数组
        //Array.fill(arrayname ,starting index ,ending index ,value)
        //Array.fill(数组名，开始位置，结束位置，填充值)
    }
}
```

## 稀疏数组
当一个二维数组中大部分元素为0,或者为同一值时，可以使用稀疏数组来保存该数组

```java
//创建二维数组
int[][] array1 = new int[11][11];
array1[1][2] = 1;
array1[2][3] = 2;

// 获取数组有效值的个数
int sum = 0;
for(int i = 0;i < array1.length; i++){
    for(int j = 0;j < array1[i].length; j++){
        if(array1[i][j] != 0){
            sum++;
        }
    }
}

//创建一个稀疏数组,稀疏数组的第一行存放的是二维数组的构建信息，所以稀疏数组的行数=有效值+1，列数3固定，都为行、列、值
int[][] array2 = new int[sum+1][3];

//编辑稀疏数组第一行，存放二维数组构建信息，11行，11列，sum个有效值
array2[0][0] = 11;
array2[0][1] = 11;
array2[0][2] = sum;

//遍历二维数组，将有效值存入稀疏数组中
int count = 0;
for(int i = 0;i < array1.length; i++){
    for(int j = 0;j < array1[i].length; j++){
        if(array1[i][j] != 0){
            count++;
            array2[count][0] = i;
            array2[count][1] = j;
            array2[count][2] = array1[i][j];
        }
    }
}

//恢复二维数组：用稀疏数组中的信息创建二维数组
int[][] array3 = new int[array2[0][1]][array2[0][2]];

//填充二维数组
for(int i=1;i<array2.length;i++){
    array3[array2[i][0]][array2[i][1]]=array2[i][2];
}
```

## 类与对象(进阶)

简单概念：一个有多种属性的东西，叫对象，有相同属性的对象称为一个类

方法是类的动作,是动态行为,用驼峰命名法

引用：用来代表类的对象的变量

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

继承的用法:一个类可以被多个类继承，一个类只能继承一个类，一个类可以继承多个接口，用逗号分隔多个接口

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
        Weapon weapon = new Weapon();
        weapon.damage = 65; //damage属性在类Weapon中新设计的
         
        weapon.name = "无尽之刃";//name属性，是从Item中继承来的，就不需要重复设计了
        weapon.price = 3600;
         
    }
}
```

构造方法:对象实例化是通过调用构造方法实现的，构造方法方法名和类名一致，无返回值，如果未申明，系统会默认生成一个无参构造方法，如果申明了一个带参的构造方法，那么无参的构造方法将失效
一旦定义了有参构造方法，就必须显示定义无参构造方法，否则会报错

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

```java
//private 私有的
//package/friendly/default 不写
//protected 受保护的
//public 公共的
```

类与类的几种关系

```
自身：指的是Hero自己
同包子类：ADHero这个类是Hero的子类，并且和Hero处于同一个包下
不同包子类：Support这个类是Hero的子类，但是在另一个包下
同包类： GiantDragon 这个类和Hero是同一个包，但是彼此没有继承关系
其他类：Item这个类，在不同包，也没有继承关系的类
```

类方法、类属性和对象方法、对象属性

```java
//如果一个属性，这个类通用，不会改变，那么设计为类属性，用static修饰
public class Hero(){
    private static maxHP = 9000;
}

//如果一个方法，没有调用任何对象属性，那么就可以考虑设计为类方法，用static修饰
public static void printGameDuration(){
    System.out.println("已经玩了10分50秒");
}
```

## 单例模式

单例模式特点

1. 只允许有一个实例
2. 单例类必须创建自己的实例
3. 单例类必须给其他类提供获取实例的方法

什么是单例模式

1. 构造方法私有化
2. 静态属性指向实例
3. public static的 getInstance方法，返回第二步的静态属性

**饿汉式**，是立即加载的方式，无论是否会用到这个对象，都会加载。
如果在构造方法里写了性能消耗较大，占时较久的代码，比如建立与数据库的连接，那么就会在启动的时候感觉稍微有些卡顿。

**懒汉式**，是延迟加载的方式，只有使用的时候才会加载。 并且有线程安全的考量

使用懒汉式，在启动的时候，会感觉到比饿汉式略快，因为并没有做对象的实例化。 但是在第一次调用的时候，会进行实例化操作，感觉上就略慢。

看业务需求，如果业务上允许有比较充分的启动和初始化时间，就使用饿汉式，否则就使用懒汉式

## 枚举
枚举是一种特殊的类，通常配合switch使用
```java
public enum Season {
	SPRING,SUMMER,AUTUMN,WINTER
}

public class HelloWorld {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        switch (season) {
        case SPRING:
            System.out.println("春天");
            break;
        case SUMMER:
            System.out.println("夏天");
            break;
        case AUTUMN:
            System.out.println("秋天");
            break;
        case WINTER:
            System.out.println("冬天");
            break;
        }
    }
}

//使用增强for循环查看枚举中的常量
for (Season s : Season.values()) {
    System.out.println(s);
}
```

## 接口
接口是一种约定，继承接口后必须调用接口方法

## 对象类型转换
用来代表类的对象的变量叫做引用
```java
ADHero ad = new ADHero();
// 第一个 ADHero 是引用类型
// 第二个 ADHero 是对象类型
//通常情况下，引用类型和对象类型是一致的
```
当引用类型和对象类型不同时，就要用到转换

没有继承关系的两个类，互相转换，一定会失败

```java
//子类转父类(自动转换)
ADHero ad = new ADHero();
Hero h = new Hero();
h = ad

//父类转子类(强制转换)
ad = (ADHero)h;
```
类与接口的转换
```java
ADHero ad = new ADHero();

// AD英雄类转为AD接口，是把ADHero类当做AD来使用，然而ADHero中必有AD接口中的方法，所以语义逻辑可行，自动转换
AD adi = ad;
```

## instanceof判断类型
```java
ADHero ad = new ADHero();
APHero ap = new APHero();
    
Hero h1= ad;
Hero h2= ap;
    
//判断引用h1指向的对象，是否是ADHero类型
System.out.println(h1 instanceof ADHero);
    
//判断引用h2指向的对象，是否是APHero类型
System.out.println(h2 instanceof APHero);
    
//判断引用h1指向的对象，是否是Hero的子类型
System.out.println(h1 instanceof Hero);
```

## 方法重写
子类继承父类后在自身命名一个父类已有的方法叫做重写，新方法会覆盖父类方法，产生效果，重写的作用是在继承的同时也能灵活地修改方法，节省开发时间和维护成本

## 多态
类的多态的形成条件
1. 父类（接口）引用指向子类对象
2. 调用的方法有重写

## 隐藏
隐藏也是方法的重写，只不过操作的是类方法

## super
1. 调用父类构造方法，根据给出参数的数量自动选择哪一个构造方法，默认在子类的构造方法中会有一个`super()`，所以调用子类构造方法时，会默认调用父类无参构造方法，如果父类中没有无参构造方法，super会默认传入一个空字符串
2. 调用父类属性，用`super.属性名`的方式
3. 调用父类方法，用`super.方法名`的方式

## Object类
所有类都默认继承了Object类

```java
//toString()返回的是一个对象的字符串表达式，一般在对象中重写方法返回一个字符串;

public String toString(){
    return name;
}
```

```java
//finalize()是一个垃圾回收函数，虚拟机JVM在满足条件是自动调用
```

```java
//equals()用于判断两个对象的内容相不相同，相同返回true，不同返回false
//==比较的则是两个对象在内存中的地址相不相同
```

## 抽象类
抽象方法用abstract修饰,只申明，没有方法体

如果一个类中有抽象方法，那么这个类必须为抽象类

抽象类的子类中，必须重写抽象方法

抽象类中可以没有抽象方法，但是抽象类不能被直接实例化

## 内部类
非静态内部类不需要在外部类存在一个实例时才可调用

静态内部类可以直接调用，因为没有一个外部类的实例，所以在静态内部类里面不可以访问外部类的实例属性和方法

匿名类就是在实例化抽象类的同时写出抽象方法

声明在主方法中的类叫做本地类

## 默认方法
默认方法就是一个方法要在多个类中重复使用，写在接口中，避免重复

## 数字与字符
封装类：所有的基本类型，都有对应的类类型，比如int对应的类是Integer，这种类就叫做封装类

```java
int i = 5;
//基本类型转换成封装类型
Integer it = new Integer(i);

//封装类型转换成基本类型
int i2 = it.intValue();
```
装箱：基本类型自动转换为类类型
拆箱：类类型自动转换为基本类型

```java
int i = 5;
//装箱
Integer it = i;

//拆箱
int it2 = it;
```

数字与字符串的转换
```java
int i = 5;
String x = "999"
//数字转字符串

//方法1:使用String类的静态方法valueOf
String str = String.valueOf(i);
    
//方法2:先把基本类型装箱为对象，然后调用对象的toString
Integer it = i;
String str2 = it.toString();

//字符串转整数
int i= Integer.parseInt(x);
```

## 格式化输出
%s 表示字符串
%d 表示数字
%n 表示换行

printf和format能够达到一模一样的效果

printf中是直接调用了format

数字的格式化输出
```java
public class TestNumber {
   
    public static void main(String[] args) {
        int year = 2020;
          
        //直接打印数字
        System.out.format("%d%n",year);
        //总长度是8,默认右对齐
        System.out.format("%8d%n",year);
        //总长度是8,左对齐
        System.out.format("%-8d%n",year);
        //总长度是8,不够补0
        System.out.format("%08d%n",year);
        //千位分隔符
        System.out.format("%,8d%n",year*10000);
  
        //小数点位数
        System.out.format("%.2f%n",Math.PI);
          
        //不同国家的千位分隔符
        System.out.format(Locale.FRANCE,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.US,"%,.2f%n",Math.PI*10000);
        System.out.format(Locale.UK,"%,.2f%n",Math.PI*10000);
    }
}
```

## 字符串
char对应的封装类是Character

immutable 是指不可改变的，里面的内容**永远**不能改变，String 的表现就像是一个常量

使用equals进行字符串内容的比较，必须大小写一致
equalsIgnoreCase，忽略大小写判断内容是否一致

StringBuffer是可变长的字符串

## 异常处理
单异常处理
```java
//法一：try catch
//如果文件存在，就会顺序往下执行，并且不执行catch块中的代码
//如果文件不存在，try 里的代码会立即终止，程序流程会运行到对应的catch块中
try{
    System.out.println("试图打开 d:/LOL.exe");
    new FileInputStream(f);
    System.out.println("成功打开");
}
catch(FileNotFoundException e){
    System.out.println("d:/LOL.exe不存在");
    e.printStackTrace();
}

//法二：throw 抛出
private static void method2() throws FileNotFoundException {

    File f = new File("d:/LOL.exe");

    System.out.println("试图打开 d:/LOL.exe");
    new FileInputStream(f);
    System.out.println("成功打开");
}
```

多异常处理
```java
//法一：用多个catch进行处理
try {
    System.out.println("试图打开 d:/LOL.exe");
    new FileInputStream(f);
    System.out.println("成功打开");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d = sdf.parse("2016-06-03");
} catch (FileNotFoundException e) {
    System.out.println("d:/LOL.exe不存在");
    e.printStackTrace();
} catch (ParseException e) {
    System.out.println("日期格式解析错误");
    e.printStackTrace();
}
finally{
    //finally中放无论出不出现异常都必会执行的代码
    System.out.println("无论文件是否存在， 都会执行的代码");
}

//法二：用一个catch抛出多个异常，用if来判断异常
try {
    System.out.println("试图打开 d:/LOL.exe");
    new FileInputStream(f);
    System.out.println("成功打开");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date d = sdf.parse("2016-06-03");
} catch (FileNotFoundException | ParseException e) {
    if (e instanceof FileNotFoundException)
        System.out.println("d:/LOL.exe不存在");
    if (e instanceof ParseException)
        System.out.println("日期格式解析错误");

    e.printStackTrace();
}
```

## 集合
概念：对象的容器，定义了对多个对象进行操作的常用方法。可实现数组的功能

集合与数组区别
1. 数组长度固定，集合长度不固定
2. 数组可以存储基本类型和引用类型，集合只能存储引用类型

Collection 是最基本的集合接口，一个 Collection 代表一组 Object，即 Collection 的元素, Java不提供直接继承自Collection的类，只提供继承于的子接口(如List和set)

## Set和List的区别
1. Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素
2. Set检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变 <实现类有HashSet,TreeSet>
3. List和数组类似，可以动态增长，根据实际存储的数据的长度自动增长List的长度。查找元素效率高，插入删除效率低，因为会引起其他元素位置改变 <实现类有ArrayList,LinkedList,Vector>

List集合的遍历
```java
import java.util.*;
 
public class Test{
 public static void main(String[] args) {
     List<String> list=new ArrayList<>();
     list.add("Hello");
     list.add("World");
     list.add("HAHAHAHA");
     
     //第一种遍历方法使用增强型for循环遍历list
     for (String str : list) {   
        System.out.println(str);
     }
 
     //第二种遍历，把链表变为数组相关的内容进行遍历
     String[] strArray=new String[list.size()];
     list.toArray(strArray);
     for(int i=0;i<strArray.length;i++)
     {
        System.out.println(strArray[i]);
     }
     
    //第三种遍历 使用迭代器进行相关遍历
     Iterator<String> ite=list.iterator();
     while(ite.hasNext())//判断下一个元素之后有值
     {
         System.out.println(ite.next());
     }
 }
}
```

Map的遍历
```java
import java.util.*;
 
public class Test{
     public static void main(String[] args) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("1", "value1");
      map.put("2", "value2");
      map.put("3", "value3");
      
      //第一种：普遍使用，二次取值
      //通过Map.keySet遍历key和value
      for (String key : map.keySet()) {
       System.out.println("key= "+ key + " and value= " + map.get(key));
      }
      
      //第二种
      //通过Map.entrySet使用iterator遍历key和value
      Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
      while (it.hasNext()) {
       Map.Entry<String, String> entry = it.next();
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
      
      //第三种：推荐，尤其是容量大时
      //通过Map.entrySet遍历key和value
      for (Map.Entry<String, String> entry : map.entrySet()) {
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
    
      //第四种
      //通过Map.values()遍历所有的value，但不能遍历key
      for (String v : map.values()) {
       System.out.println("value= " + v);
      }
     }
}
```

集合常用方法
```java
转换
集合 –> 数组 ： toArray()
数组 –> 集合 ： Arrays.asList(T...t)

删除
al.remove(1); //删除当前集合对应的索引值上的元素。（bbb）
al.remove(new Integer(1)); //删除当前集合中对应的元素(1)

添加
list.add("内容");
```

迭代器的使用
```java
//创建一个迭代器对象
Iterat iterat = list.iterator();

//返回迭代器的下一个元素，并且更新迭代器的状态
iterat.next()

//用于检测集合中是否还有元素
iterat.hasNext()
    
//将迭代器返回的元素删除
iterat.remove()
```
## I/O
文件和文件夹都是用File代表

```
字节流

输入流： InputStream
输出流：OutputStream

文件输入流：FileInputStream
文件输出流：FileOutputStream

字符流

Reader
Writer
```

将流定义在try括号里,他会自动关闭
```java
try (FileInputStream fis = new FileInputStream(f)) {}

//在finally里面关闭流,需要将fis定义在try外面
finally {
    if (null != fis)
        try {
            fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}
```

## 多线程

继承类实现
```java
// 1.创建一个线程类，继承Thread，重写run方法，run方法里面写需要使用到多线程的操作
public class TestThread1 extends Thread {
    @Override
    public void run() {
        //run方法线程体
    }
} 
// 2.实例化一个线程对象，调用start方法开启线程
// 注：线程开启不一定立即执行，由CPU调度执行
TestThread1 testThread1 = new TestThread1();
testThread1.start();
```
继承Runnable接口实现(常用)
```java
// 1.创建类，继承Runnable接口，重写run方法，run方法里面写需要使用到多线程的操作
public class TestThread1 implements Runnable {
    @Override
    public void run() {
        //run方法线程体
    }
} 
// 2.创建Runnable接口类的实例对象
TestThread1 testThread1 = new TestThread1();
// 3.创建线程对象，通过线程对象来开启线程
new Thread(testThread1).start();
```
继承Callable接口实现
```java

```
获取线程名字
```java
Thread.currentThread().getName()
```
线程休眠
```java
// 每个对象都有一个锁，sleep不会释放锁
Thread.Sleep(1000);
```
线程礼让
```java
// 线程礼让是让当前进程暂停，转为就绪状态，让CUP重新调度，所以礼让不一定成功，主要看CPU怎么调度
Thread.yield();
```
线程强制执行
```java
// 调用join方法会让主线程处于阻塞状态，先将线程内的内容执行完毕，再次开始执行主线程
Demo demo = new Demo();
Thread thread = new Thread(demo);
thread.join();
```
线程优先级
- 优先级低只是意味着获得调度的概率低，并不是优先级低就不会被调用了，还是看CPU调度
```java
// 线程的优先级用数字表示，范围1~10
Thread.MIN_PRIORITY = 1;
Thread.MAX_PRIORITY = 10;
Thread.NORM_PRIORITY = 5;
// 获取线程优先级
Demo demo = new Demo();
Thread thread = new Thread(demo);
thread.getPriority();
// 设置线程优先级
thread.setPriority(xxx);
```

# Lambda表达式

Lambda简化了匿名内部类，方法引用简化了lambda
任何接口，如果只包含唯一一个抽象方法，name它就是一个函数式接口

```java
interface Demo02 {
    void test();
}

// 匿名内部类常规写法
public class Lambda {
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02() {
            @Override
            public void test() {
                System.out.println("Hello World");
            }
        };
        demo02.test();
    }
}

// Lambda用法
public class Lambda {
    public static void main(String[] args) {
        Demo02 demo02 = () -> {
            System.out.println("Hello World");
        };
        demo02.test();
    }
}
```

## 线程锁
```java
// 保证线程同步依靠队列和锁
// 多个线程时，为保证一个方法被一个线程执行时不被影响，需要锁住此方法
private synchronized void buy(){

}

// 多个对象使用同一共享资源时，为了不被影响，需要锁住此资源
synchronized(Obj){}
```

## 生成者与消费者关系模式
- 管程法
- 信号灯法

## 线程池
```java
// 1.创建服务，创建线程池，参数为线程池大小
ExecutorService service = Executors.newFixedThreadPool(10);

// 2.执行
service.execute(new MyThread());
service.execute(new MyThread());
service.execute(new MyThread());

// 3.关闭连接
service.shutdown();
```

## 静态代理
- 真实对象和代理对象都要实现同一个接口
- 代理对象要代理真实对象
- 静态代理的实现类似于多线程的底部

静态代理的优点：
- 可以使得我们的真实角色更加纯粹，不再去关注一些公共的事情
- 公共的业务由代理来完成，实现了业务的分工
- 公共业务发生扩展时变得更加集中和方便

静态代理的缺点：
- 类多了，多了代理类，工作量变大了，开发效率降低

静态代理的使用
1. 创建接口
```java
//增删改查业务
public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}
```
2. 创建真实对象
```java
//真实对象：完成增删改查操作的人
public class UserServiceImpl implements UserService {
 
    public void add() {
        System.out.println("增加了一个用户");
    }
 
    public void delete() {
        System.out.println("删除了一个用户");
    }
 
    public void update() {
        System.out.println("更新了一个用户");
    }
 
    public void query() {
        System.out.println("查询了一个用户");
    }
}
```
3. 创建代理对象
```java
//代理角色：代替真实对象执行操作，顺带添加附加功能
public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;
 
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
 
    public void add() {
        log("add");
        userService.add();
    }
 
    public void delete() {
        log("delete");
        userService.delete();
    }
 
    public void update() {
        log("update");
        userService.update();
    }
 
    public void query() {
        log("query");
        userService.query();
    }
    //在这里面增加日志的实现
    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
}
```
4. 编写测试类
```java
public class Client {
    public static void main(String[] args) {
        //真实业务
        UserServiceImpl userService = new UserServiceImpl();
        //代理类
        UserServiceProxy proxy = new UserServiceProxy();
        //使用代理类执行添加方法！
        proxy.setUserService(userService);
        proxy.add();
    }
}
```

## 动态代理
- 动态代理和静态代理角色一样
- 动态代理的代理类是动态生成的，不是直接写好的
- 动态代理分为两大类：
  - 基于接口的动态代理——JDK动态代理
  - 基于类的动态代理——cglib

动态代理的优点：
- 可以使得我们的真实角色更加纯粹，不再去关注一些公共的事情
- 公共的业务由代理来完成 . 实现了业务的分工
- 公共业务发生扩展时变得更加集中和方便
- 一个动态代理，一般代理某一类业务
- 一个动态代理可以代理多个类，代理的是接口

动态代理的使用：
1. 创建接口
```java
//增删改查业务
public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}
```
2. 创建真实对象
```java
//真实对象：完成增删改查操作的人
public class UserServiceImpl implements UserService {
 
    public void add() {
        System.out.println("增加了一个用户");
    }
 
    public void delete() {
        System.out.println("删除了一个用户");
    }
 
    public void update() {
        System.out.println("更新了一个用户");
    }
 
    public void query() {
        System.out.println("查询了一个用户");
    }
}
```
3. 创建用于生成代理角色的工具类
```java
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;
 
    public void setTarget(Object target) {
        this.target = target;
    }
 
    //生成代理类，重点是第二个参数，获取要代理的抽象角色！之前都是一个角色，现在可以代理一类角色
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
 
    // proxy : 代理类 method : 代理类的调用处理程序的方法对象.
    // 处理代理实例上的方法调用并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //核心：本质利用反射实现！
        Object result = method.invoke(target, args);
        return result;
    }
 
    //用代理添加日志功能
    public void log(String methodName) {
        System.out.println("调用了" + methodName + "方法");
    }
}
```
4. 编写测试类
```java
public class Test {
    public static void main(String[] args) {
        //真实对象
        UserServiceImpl userService = new UserServiceImpl();
        //代理对象的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService); //设置要代理的对象
        UserService proxy = (UserService)pih.getProxy(); //动态生成代理类！
        proxy.add();
    }
}
```

## JDBC数据库连接
1. 定义连接(静态)
```java
private static Connection conn;
```
2. 加载驱动程序
```java
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //SqlServer
Class.forName("com.mysql.jdbc.Driver"); //Mysql 5.0
Class.forName("com.mysql.cj.jdbc.Driver"); //Mysql 8.0
```
3. 创建连接函数
```java
//Sqlserver
String url = "jdbc:sqlserver://localhost:1433;databaseName=soft1901"; //SqlServer
String url = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC;"; //Mysql 8.0
conn = DriverManager.getConnection(url,"sa","lishuang001219");

//Mysql 5.0
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","sa", "lishuang001219");
```
4. 创建关闭函数
```java
public static void closeConn(Statement s) throws SQLException {
    if (s != null){
        s.close();
    }

    if (conn != null){
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
```
5. 在主方法中调用连接函数，书写sql语句，再调用关闭函数
```java
try {
    Connection c = getConn();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch (SQLException throwables) {
    throwables.printStackTrace();
}

Statement s = conn.createStatement();
String sql = "insert into student values('007',"+"'阿九'"+","+"'女'"+","+20+")";
s.execute(sql);

closeConn(s);
```

## JDBCUtil

JDBCUtil是对JDBC的一个简单封装的工具类，简化了开发过程的同时，不会影响程序性能

```java
package com.ut;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/*
 * 封装一个工具类，能够减少重复代码
 *
 *  可以通过一个配置文件的形式，
 *
 * */
public class JDBCUtils {
    private static  String url ;
    private static String pwd;
    private static  String user;
    static {
        // 静态变量代码块中赋值。
        // 1. 读取，配置配置文件
        try {
            Properties properties = new Properties();
            properties.load(handler.JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            url = properties.getProperty("url");
            pwd = properties.getProperty("pwd");
            user = properties.getProperty("user");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    // 获取连接
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,user,pwd);
    }
    
    //封装关闭资源的方法
    public static void close(Connection connection, Statement statement){
        if(statement != null){
            try {
                statement.close(); // 关闭资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close(); /// 关闭conn 资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(statement != null){
            try {
                statement.close(); // 关闭资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close(); /// 关闭conn 资源
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}
```

## JDBC增删改
```java
//增加数据
String sql = "insert into student values('007',"+"'阿九'"+","+"'女'"+","+20+")";

//删除和修改更为简单，注意单双引号的使用即可
```

## JDBC查询
```java
String sql = "select * from hero";

// 执行查询语句，并把结果集返回给ResultSet,基1(下标从一开始)
ResultSet rs = s.executeQuery(sql);
while (rs.next()) {
    int id = rs.getInt("id");// 可以使用字段名
    String name = rs.getString(2);// 也可以使用字段的顺序
    float hp = rs.getFloat("hp");
    int damage = rs.getInt(4);
    System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
}
```

## 断言
```java
Assertions.assertEquals("期望值","实际值")
```

## 注解
三个内置注解
```java
// 重写的注解
@Override

// 不推荐程序员使用，但是可以使用，或者推荐更好的方式
@Deprecated

// 镇压警告
@SuppressWarnings("all")
```
元注解：用来注释注解的注解
```java
// 指明注解可以写实哪些元素，传入值如下
@Target(value={ElementType.CONSTRUCTOR,ElementType.FIELD})
/*
    ElementType.CONSTRUCTOR ：构造器

    ElementType.FIELD：属性

    ElementType.LOCAL_VARIABLE：局部变量

    ElementType.METHOD：方法

    ElementType.PACKAGE：包

    ElementType.PARAMETER：参数

    ElementType.TYPE：类、接口（包括注解类型和 enum 声明）
*/

// 指明注解的生命周期，传入值如下
@Retention(value={RetentionPolicy.SOURCE})
/*
RetentionPolicy.SOURCE

RetentionPolicy.CLASS

RetentionPolicy.RUNTIME
*/

// 使用此修饰的注解将会被 javadoc 工具提取成文档，使用此注解，其 @Retention 必须被设置为 RetentionPolicy.RUNTIME
@Documented

// 具有继承性
@Inherited
```
自定义注解
```java
// 基本格式
// public @interface 注解名{定义内容}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数：参数类型 + 参数名();
    String name() default ""; //用default来设置默认值
    int age();
    int id() default -1; //如果默认值为-1，代表不存在
    String[] schools() default {"清华大学","北京大学"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value(); //如果只有一个参数，默认设置其名字为value，在使用时就可简写
}
```

## 反射
优点：可以实现动态创建对象和编译，体现出很大的灵活性
缺点：对性能有影响。使用反射基本上是一种解释操作，我们告诉JVM要做什么，这类操作总是慢于直接执行相同的操作
一个类只有一个Class对象
```java
// 通过反射，动态创建对象

// 获得Class对象
Class c1 = Class.forName("com.Student");

// 构建一个对象
Student student = (Student)c1.newInstance();

// 通过构造器构建对象
Constructor constructor = c1.getDeclaredConstructor(String.class,int.class);
Student student = (Student)constructor.newInstance("小明",18);

// 通过反射调用普通方法
// 通过反射获取一个方法
User user3 = (User)c1.newInstance();
Method setName = c1.getDeclaredMethod("setName",String.class);

// 用invoke激活方法
// invoke(对象，"值")
setName.invoke(user3,"李爽");

// 通过反射操作属性
User user4 = (User)c1.newInstance();
Field name = c1.getDeclaredField("属性名");
// 对于私有属性，不能直接操作，需要关闭程序的安全检测,true为关闭
name.setAccessible(true);
name.set(user4,"李爽");

// 通过反射获得注解
c1.getAnnotations();

// 获取注解的值
Student student = (Student)c1.getAnnotation(Student.class);
student.value();

// 获得类指定的注解
Field f = c1.getDeclaredField("name");
Student annotation = f.getAnnotation(Student.class);
annotation.name();
annotation.age();
```