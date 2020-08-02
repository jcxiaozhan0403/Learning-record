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

