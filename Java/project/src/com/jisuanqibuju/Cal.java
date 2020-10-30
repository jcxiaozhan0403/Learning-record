package com.jisuanqibuju;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal extends JFrame implements ActionListener{
    private JPanel mainPanel,topPanel,buttomPanel;
    private JTextField txtResult;
    private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,
            btnJia,btnJian,btnCheng,btnChu,btnDian,btnDeng,btnC;
    private double op1,op2,result;
    private char op;
    public Cal(){

        mainPanel=new JPanel(new BorderLayout());
        topPanel=new JPanel(new FlowLayout());
        buttomPanel=new JPanel(new GridLayout(4,4,2,2));
        this.setContentPane(mainPanel);
        mainPanel.add(topPanel,"North");
        mainPanel.add(buttomPanel,"Center");
        txtResult=new JTextField(10);
        txtResult.setFont(new Font("微软雅黑",Font.BOLD,20));
        topPanel.add(txtResult);
        //
        btn0=new MyButton("0");
        btn1=new MyButton("1");
        btn2=new MyButton("2");
        btn3=new MyButton("3");
        btn4=new MyButton("4");
        btn5=new MyButton("5");
        btn6=new MyButton("6");
        btn7=new MyButton("7");
        btn8=new MyButton("8");
        btn9=new MyButton("9");
        btnJia=new MyButton("+");
        btnJian=new MyButton("-");
        btnCheng=new MyButton("*");
        btnChu=new MyButton("/");
        btnDian=new MyButton(".");
        btnDeng=new MyButton("=");
        btnC=new MyButton("C");
        //
        topPanel.add(btnC);
        buttomPanel.add(btn1);
        buttomPanel.add(btn2);
        buttomPanel.add(btn3);
        buttomPanel.add(btnJia);
        buttomPanel.add(btn4);
        buttomPanel.add(btn5);
        buttomPanel.add(btn6);
        buttomPanel.add(btnJian);
        buttomPanel.add(btn7);
        buttomPanel.add(btn8);
        buttomPanel.add(btn9);
        buttomPanel.add(btnCheng);
        buttomPanel.add(btn0);
        buttomPanel.add(btnDian);
        buttomPanel.add(btnDeng);
        buttomPanel.add(btnChu);
        //监听按钮
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnJia.addActionListener(this);
        btnJian.addActionListener(this);
        btnCheng.addActionListener(this);
        btnChu.addActionListener(this);
        btnDian.addActionListener(this);
        btnDeng.addActionListener(this);
        btnC.addActionListener(this);

        //
        this.setBounds(200,200,290,255);//设置窗口的位置和大小
        this.setVisible(true);//设置窗口看得见
        this.setResizable(false);//设置窗口大小不能再改变
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗口在关闭时退出程序

    }
    public static void main(String[] args) {
        new Cal();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=1;i<=9;i++){
            //JOptionPane.showMessageDialog(null, e.getActionCommand());
            if(e.getActionCommand().equals(String.valueOf(i))){

                txtResult.setText(txtResult.getText()+i);
            }
        }
        if(e.getSource().equals(btnC)){
            txtResult.setText("");
        }
        if(e.getSource().equals(btn0)){
            double n=0;
            try {
                n=Double.valueOf( txtResult.getText());
            } catch (Exception e2) {
                txtResult.setText("0");
            }
            if(n!=0){
                txtResult.setText(txtResult.getText()+"0");
            }
        }
        if(e.getSource().equals(btnDian)){
            String str=txtResult.getText();
            if(str.indexOf('.')<0){
                txtResult.setText(txtResult.getText()+".");
            }
        }
        if(e.getSource().equals(btnJia)){
            op='+';
            op1=Double.valueOf(txtResult.getText());
            txtResult.setText("");
        }
        if(e.getSource().equals(btnJian)){
            op='-';
            op1=Double.valueOf(txtResult.getText());
            txtResult.setText("");
        }
        if(e.getSource().equals(btnCheng)){
            op='*';
            op1=Double.valueOf(txtResult.getText());
            txtResult.setText("");
        }
        if(e.getSource().equals(btnChu)){
            op='/';
            op1=Double.valueOf(txtResult.getText());
            txtResult.setText("");
        }
        if(e.getSource().equals(btnDeng)){
            op2=Double.valueOf(txtResult.getText());
            switch (op) {
                case '+':
                    result=op1+op2;
                    break;
                case '-':
                    result=op1-op2;
                    break;
                case '*':
                    result=op1*op2;
                    break;
                case '/':
                    result=op1/op2;
            }
            txtResult.setText(String.valueOf( result));
        }
    }
}
