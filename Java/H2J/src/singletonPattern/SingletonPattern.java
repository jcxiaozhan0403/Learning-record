package singletonPattern;

public class SingletonPattern {
    //单例模式又叫做 Singleton模式，指的是一个类，在一个JVM里，只有一个实例存在。

    //饿汉式单例模式

    //私有化构造方法使得该类无法在外部通过new 进行实例化
    private SingletonPattern(){
    }

    //准备一个类属性，指向一个实例化对象。 因为是类属性，所以只有一个
    private static SingletonPattern instance = new SingletonPattern();

    //public static 方法，提供给调用者获取12行定义的对象
    public static SingletonPattern getInstance(){
        return instance;
    }

    //懒汉单例模式

//    //私有化构造方法使得该类无法在外部通过new 进行实例化
//    private SingletonPattern(){
//    }
//
//    //准备一个类属性，用于指向一个实例化对象，但是暂时指向null
//    private static SingletonPattern instance;
//
//    //public static 方法，返回实例对象
//    public static GiantDragon getInstance(){
//        //第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象
//        if(null==instance){
//            instance = new SingletonPattern();
//        }
//        //返回 instance指向的对象
//        return instance;
//    }
}
