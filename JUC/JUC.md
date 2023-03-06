## JMM

![JMM内存模型](D:\Study\Learning-record\JUC\JMM内存模型.jpg)

### 8大原子操作

> 关于主内存与工作内存之间的交互协议，即一个变量如何从主内存拷贝到工作内存；如何从工作内存同步到主内存中的实现细节。java内存模型定义了8个原子操作。

- lock(锁定)：作用于主内存，它把一个变量标记为一条线程独占状态；
- read(读取)：作用于主内存，它把变量值从主内存传送到线程的工作内存中，以便随后的load动作使用；
- load(载入)：作用于工作内存，它把read操作的值放入工作内存中的变量副本中；
- use(使用)：作用于工作内存，它把工作内存中的值传递给执行引擎，每当虚拟机遇到一个需要使用这个变量的指令时候，将会执行这个动作；
- assign(赋值)：作用于工作内存，它把从执行引擎获取的值赋值给工作内存中的变量，每当虚拟机遇到一个给变量赋值的指令时候，执行该操作；
- store(存储)：作用于工作内存，它把工作内存中的一个变量传送给主内存中，以备随后的write操作使用；
- write(写入)：作用于主内存，它把store传送值放到主内存中的变量中。
- unlock(解锁)：作用于主内存，它将一个处于锁定状态的变量释放出来，释放后的变量才能够被其他线程锁定

![JMM流程](D:\Study\Learning-record\JUC\JMM流程.jpg)

### 缓存一致性协议

流程：

1. 开启缓存一致性协议之后，当一个线程的工作区内存中变量发生变化是，会立即执行store将存储到主内存当中
2. 开启缓存一致性协议之后，每一个线程都会进行总线嗅探，当监听到有和自己工作区内存中相同的变量进行store时候，就会将工作区的变量进行**失效**处理
3. 这是，当线程的执行引擎从工作区内存中使用变量，发现变量失效，就会重新在主内存中查找，这时查找到的就是最新的变量

```
同步代码块能保证可见性的原因：在读取变量时，隐式调用lock指令，并且清空本地工作区，只能从主存中读取内存，在修改后隐式执行了unlock指令，将变量实时刷新到主存当中
```

### volatile关键字

并发编程三大特性：可见性、原子性、有序性

volatile基于总线上的==缓存一致性协议==

1. 保证可见性
2. 不保证原子性
3. 禁止指令重排

分析源码可知，volatile底层主要通过加上汇编前缀指令lock

lock指令的作用：

1. 会将当前处理器缓存行的数据==立刻==写回到系统内存
2. 数据失效
3. 提供内存屏障，防止指令重排
4. 在执行`store`之前会先`lock`锁住主内存,`write`完成之后，会`unlock`

### 指令重排

> 在不影响单线程程序执行结果的前提下，计算机为了最大限度地发挥机器性能，会对机器指令重排序优化，在多线程中是存在问题的。

![指令重排](D:\Study\Learning-record\JUC\指令重排.jpg)

指令重排遵循以下两个原则

#### as-if-serial原则

不管怎么重排序，(单线程)程序执行的结果不能被改变

#### happens-befor原则

1. 程序次序规则：在一个线程中，按照代码的顺序，前面的操作Happens-Before于后面的任意操作。
2. volatile变量规则：对一个volatile变量的写操作，Happens-Before于后续对这个变量的读操作。
3. 传递规则：如果A Happens-Before B，并且B Happens-Before C，则A Happens-Before C。
4. 锁定规则：对一个锁的解锁操作 Happens-Before于后续对这个锁的加锁操作。
5. 线程启动规则：如果线程A调用线程B的start()方法来启动线程B，则start()操作Happens-Before于线程B中的任意操作。
6. 线程终结规则：线程A等待线程B完成（在线程A中调用线程B的join()方法实现），当线程B完成后（线程A调用线程B的join()方法返回），则线程A能够访问到线程B对共享变量的操作。
7. 线程中断规则：对线程interrupt()方法的调用Happens-Before于被中断线程的代码检测到中断事件的发生。
8. 对象终结原则：一个对象的初始化完成Happens-Before于它的finalize()方法的开始。

## 阻塞队列

队列：先进先出

阻塞：线程挂起等待

阻塞队列：

1. 如果队列满了，就必须阻塞等待
2. 如果是队列是空的，必须阻塞等待

![队列继承关系](D:\Study\Learning-record\JUC\队列继承关系.jpg)

| 方式         | 抛出异常 | 有返回值，不抛出异常 | 阻塞 等待 | 超时等待 |
| :----------- | :------- | :------------------- | :-------- | -------- |
| 添加         | add      | offer()              | put()     | offer(,) |
| 移除         | remove   | poll()               | take()    | poll(,)  |
| 检测队首元素 | element  | peek()               | -         | -        |

```java
public class Test {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }
    /**
     * 1. 无返回值，抛出异常的方式
     */
    public static void test1(){
        //队列的大小
        ArrayBlockingQueue blockingQueue =
                new ArrayBlockingQueue<>(3);

        //添加元素
        System.out.println(blockingQueue.add("a"));//true
        System.out.println(blockingQueue.add("b"));//true
        System.out.println(blockingQueue.add("c"));//true

        //System.out.println(blockingQueue.add("d"));
        //IllegalStateException: Queue full 抛出异常---队列已满！

        System.out.println("===========================");

        //队首元素
        System.out.println(blockingQueue.element());//a
        //移除元素
        System.out.println(blockingQueue.remove());//a
        System.out.println(blockingQueue.remove());//b
        System.out.println(blockingQueue.remove());//c

        //System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException 抛出异常---队列已为空！

        //System.out.println(blockingQueue.element());
        //java.util.NoSuchElementException 抛出异常---队列已为空！
    }
    /**
     * 2. 有返回值，不抛出异常的方式
     */
    public static void test2(){
        // 队列的大小
        ArrayBlockingQueue blockingQueue =
                new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));//true
        System.out.println(blockingQueue.offer("b"));//true
        System.out.println(blockingQueue.offer("c"));//true

        //System.out.println(blockingQueue.offer("d"));
        //false 不抛出异常！

        //队首元素
        System.out.println(blockingQueue.peek());

        System.out.println("===========================");
        System.out.println(blockingQueue.poll());//a
        System.out.println(blockingQueue.poll());//b
        System.out.println(blockingQueue.poll());//c

        //System.out.println(blockingQueue.poll());
        //null  不抛出异常！
    }
    /**
     * 3. 等待，阻塞（一直阻塞）
     */
    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue =
                new ArrayBlockingQueue<>(3);
        //一直阻塞
        blockingQueue.put("a");//true
        blockingQueue.put("b");//true
        blockingQueue.put("c");//true
        
        //blockingQueue.put("d");
        //队列没有位置了，一直阻塞等待
        
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        
        //System.out.println(blockingQueue.take());
        //没有这个元素，一直阻塞等待
    }
    /**
     * 4. 等待，阻塞（等待超时）
     */
    public static void test4() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue =
                new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        
        //blockingQueue.offer("d",2,TimeUnit.SECONDS);
        //等待超过2秒没有添加成功就退出
        
        System.out.println("===============");
        System.out.println(blockingQueue.poll());//a
        System.out.println(blockingQueue.poll());//b
        System.out.println(blockingQueue.poll());//c
        
        //blockingQueue.poll(2,TimeUnit.SECONDS);
        //等待超过2秒没有获取成功就退出
    }
}
```

> 同步队列：没有容量，放一个取一个

```java
public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new SynchronousQueue<>(); // 同步队列
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()
                        +" put 1");
                // put进入一个元素
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()
                        +" put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()
                        +" put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                // 睡眠3s取出一个元素
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()
                        +" get "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
```

