**闭卷笔试、96课时**

## Java语言特点
- 面向对象
- 跨平台
- 安全性
- 简洁性
- 分布性
- 多线程
- 图形功能强

## 规范
类名首字母大写

## 数据类型
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

## 流程控制语句
```java
// 从键盘接收数据
Scanner scan = new Scanner(System.in);
int score = sc.nextInt;
```

## 接口
接口中的方法，一定是抽象方法
```java
public class Apple implements Ifruit{
    // 在类中继承抽象方法，如果是普通类，需要重写方法，抽象类则不用
}
```
常用系统接口
```java
list<E> //泛型
list 不排序，不去重复值
set 要去除重复值
```