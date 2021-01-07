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
list<E> //尖括号中表示泛型
list //不排序，不去重复值,Vector与之类似
set //要去除重复值
```

## 异常处理
```java
public static void main(String[] args) {
    try{
        // 可能异常的代码
        n = 10/0;
    }catch(异常类型1){
        // 异常处理代码1
    }catch(异常类型2){
        // 异常处理代码2
    }finally{
        // 必须执行的代码
    }
}
```

## 布局
```
常规布局

边界布局
BorderLayout()

空布局
null

表格布局
FlowLayout()
```

## JDBC数据库连接
1. 定义连接(静态)
```java
private static Connection conn;
```
2. 加载驱动程序
```java
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Sqlserver
Class.forName("com.mysql.jdbc.Driver"); //Mysql
```
3. 创建连接函数
```java
//Sqlserver
String url = "jdbc:sqlserver://localhost:1433;databaseName=soft1901";
conn = DriverManager.getConnection(url,"sa","lishuang001219");

//Mysql
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

## 图形化界面Swing
容器组件：JFream、JPanel、JScrollpane
非容器组件：JButton、JLabel、JTextfied...

弹簧布局
SpringLayout:布局管理器
SpringLayout.Constraints:使用弹簧布局的组件的布局约束，每个组件对应一个
Spring:可以理解为一个能够进行四则运算的整数
