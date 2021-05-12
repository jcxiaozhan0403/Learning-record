package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * 加载一个布局，传入布局ID R.layout.activity_main
         *
         * */
        setContentView(R.layout.activity_main);

        /*
         * 通过button触发Toast 通过onCreate方法中添加代码
         * 先通过findViewById() 获得buttonPanel   这个元素实例  操作方式为:  findViewById(R.id.buttonPanel);
         * 由于这个方法返回的是    view    对象,需要向下转型成Button对象
         * 向下转型:向下转型：子类引用指向父类对象  Father  f1 = new Son();   // 这就叫 upcasting （向上转型)， 现在f1引用指向一个Son对象
         * 向上转型：父类引用指向子类对象           Son     s1 = (Son) f1;   // 这就叫 downcasting (向下转型)，现在f1还是指向Son对象
         * */
        Button button_Panel = (Button) findViewById(R.id.buttonPanel);
        /*
         * 用setOnClickListener() 给这个实例注册监听器  OnClickListener()   但是使用语句为 View.OnClickListener()
         * 为什么前面要加个View呢，原因就是后面的OnClickListener是个View类内部的接口，如果直接使用是找不到这个接口的。
         * 参考网址:https://www.jianshu.com/p/2b829738cd69
         * */
        button_Panel.setOnClickListener(new View.OnClickListener() {
            /*
             * 监听创建完成,点击按钮如果被监听到就会执行 onClick() 方法,所以
             * Toast的功能要在onClick()中写.
             * */
            @Override
            public void onClick(View v) {
                /*
                 * 我们想要的效果是,弹出一个小小的消息框,几秒钟之后自动消失
                 * 构想:一个文本框,一个定时器,一个布局位置.一个显示方法
                 * 用静态方法 makeText()创建一个  Toast对象,调用  show()将Toast显示.
                 * 说明:   makeText(参数一[Toast要求的上下文  ],    参数二[Toast显示的文本内容],  参数三[Toast显示的时长])
                 *   参数一:    Context,由于i活动本身就是一个Context对象,因此直接传入 MainActivity.this
                 *   参数二:    内容
                 *   参数三:    有两个内置常量 Toast.LENGTH_SHORT    Toast.LENGTH_LONG
                 *
                 *   引用结束之后记得用   show()方法显示
                 * */
                Toast.makeText(MainActivity.this, "你好，世界！！！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}