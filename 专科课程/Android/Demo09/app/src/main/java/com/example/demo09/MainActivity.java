package com.example.demo09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Test testview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testview = new Test(this);
        setContentView(testview);
        testview.setOnTouchListener(new View.OnTouchListener() {
            int x,y;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    x = (int) event.getX();
                    y = (int) event.getY();
                }
                return false;
            }
        });
    }

    private class Test extends View {
        Bitmap mAlice,mPoint;
        int tAlicX,tAlicY;

        public Test(Context context) {
            super(context);
            mAlice = BitmapFactory.decodeResource(getResources(),R.drawable.image_1);
            mPoint = BitmapFactory.decodeResource(getResources(),R.drawable.image_2);

            tAlicX = mAlice.getWidth();
            tAlicY = mAlice.getHeight();
        }

        int x = 600,y = 600;

        public void getXY(int mX,int mY) {
            if (mX<tAlicX && mY<tAlicY) {
                Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT);
            }
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(mAlice,0,0,null);
            canvas.drawBitmap(mPoint,x,y,null);
        }
    }
}