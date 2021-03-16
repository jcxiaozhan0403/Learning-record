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
```
JAVA_HOME  jdk目录
CLASSPATH  .
path  bin目录
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

常见文档注释
/**
*
* @author 作者名
* @version 版本号
* @since 指明jdk版本
* @param 参数名
* @return 返回值情况
* @throws 异常抛出情况
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
public class HelloWorld

//public      表示这是一个可以公开访问的类
//class       表示这是一个类
//HelloWorld  表示类的名字，每个单词的首字母大写
```

主方法
```java
public static void main(String[] args)
```

打印
```java
System.out.println("hello world");
```

## 数据类型
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
long       Long       8
```

## 类与对象(简单)
简单概念：一个有多种属性的东西，叫对象，有相同属性的对象称为一个类

方法是类的动作,是动态行为,用驼峰命名法

## 字面值
给基本类型的变量赋值的方式叫做字面值

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
& 逻辑与
| 逻辑或
! 逻辑非
&& 短路与
|| 短路或
^  异或
```

## 位运算符
正数二进制-->反码-->加1-->负数二进制
```java
n << m //左移，值等于n*2的m次方
n >> m //右移，值等于n/2的m次方，如果为负数运算，则右移后在前两位补1
n >>> m //无符号右移，右移后的最前两位补0
^异或运算 //转为二进制，相同为0，不同为1
~反码 //1和0取反，正负号取反

```

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

## 循环
与其他语言相似，break结束循环，continue跳过此次循环
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
        Weapon infinityEdge = new Weapon();
        infinityEdge.damage = 65; //damage属性在类Weapon中新设计的
         
        infinityEdge.name = "无尽之刃";//name属性，是从Item中继承来的，就不需要重复设计了
        infinityEdge.price = 3600;
         
    }
     
}
```

方法重载:同名方法不同数量或类型的参数传入，得到不同的返回值，通过方法的重载实现，如果有多个同名方法，系统会在调用时自动选择对应数量参数的一个

可变参数方法(不定参数的方法是用来避免代码冗余的)
```java
public void heal(Hero ... heroes){
        for (Hero hero : heroes){
            System.out.println(name + "给" + hero.name + "加血");
        }
}
```

构造方法:对象实例化是通过调用构造方法实现的，构造方法方法名和类名一致，无返回值，如果未申明，系统会默认生成一个构造方法，如果申明了一个带参的构造方法，那么无参的构造方法将失效
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
```java
//子类转父类(自动转换)
ADHero ad = new ADHero();
Hero h = new Hero();
    h = ad

//父类转子类(强制转换)
    ad = (ADHero)h;
```
没有继承关系的两个类，互相转换，一定会失败

类与接口的转换
```java
ADHero ad = new ADHero();
    AD adi = ad;
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
//equals()用于判断两个对象相不相同，相同返回true，不同返回false
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
    System.out.println("无论文件是否存在， 都会执行的代码");
}
//finally中放无论出不出现异常都必会执行的代码

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

## Lamda表达式
Lambda简化了匿名内部类，方法引用简化了lambda
任何接口，如果只包含唯一一个抽象方法，name它就是一个函数式接口
```java
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

interface Demo02 {
    void test();
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

interface Demo02 {
    void test();
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

好处
1. 代理对象可以做很多真实对象做不了的事情
2. 真实对象专注做自己的事情

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