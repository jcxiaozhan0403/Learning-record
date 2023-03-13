package com.example.demo06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestView testView = new TestView(this);
        setContentView(testView);
    }

    private class TestView extends View {
        private Paint paint;

        public TestView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(6);
            paint1(canvas);
        }
        private void paint1(Canvas canvas) {
            canvas.drawColor(Color.BLACK); //填充背景为黑色
            int color[] = {Color.RED,Color.BLUE,Color.GREEN,Color.MAGENTA}; //定义颜色数组
            canvas.translate(550,750); //移动画布
            int a = 2; //定义线条长度
            for (int i=0; i<100; i++) {
                paint.setColor(color[i % 4]);
                canvas.drawLine(0,0,a,a,paint);
                canvas.translate(a,a);
                canvas.rotate(91);
                a += 5;
            }

        }
    }
}