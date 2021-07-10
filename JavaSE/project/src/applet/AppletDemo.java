package applet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class AppletDemo extends JApplet implements MouseListener, MouseMotionListener {
    private int x1,y1,x2,y2;
    public AppletDemo() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void init(){
        System.out.println("初始化...");
    }

    @Override
    public void start(){
        System.out.println("开始...");
    }

    @Override
    public void stop(){
        System.out.println("停止...");
    }

    @Override
    public void destroy(){
        System.out.println("销毁...");
    }

    @Override
    public void paint(Graphics g){
        System.out.println("绘画...");
        g.setColor(Color.red);
        g.drawLine(x1,y1,x2,y2);
        x1=x2;
        y1=y2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==1){
            x1=x2=e.getX();
            y1=y2=e.getY();
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2=e.getX();
        y2=e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
