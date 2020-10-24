package com.jisuanqibuju;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cal extends JFrame implements ActionListener{
    private JPanel mainPanel,topPanel,buttomPanel;
    private JTextField txtResult;
    private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnJia,btnJian,btnCheng,btnChu,btnDian,btnDeng;
    public Cal(){

        mainPanel=new JPanel(new FlowLayout());
        topPanel=new JPanel(new FlowLayout());
        buttomPanel=new JPanel(new GridLayout(4,4,2,2));
        this.setContentPane(mainPanel);
        mainPanel.add(topPanel);
        mainPanel.add(buttomPanel);
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
        //
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
        //

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

        this.setBounds(200,200,250,255);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Cal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = txtResult.getText();
        String num1,num2,num3;

        if(e.getSource().equals(btn0)){
            txtResult.setText(s + "0");
        }else if(e.getSource().equals(btn1)){
            txtResult.setText(s + "1");
        }else if(e.getSource().equals(btn2)){
            txtResult.setText(s + "2");
        }else if(e.getSource().equals(btn3)){
            txtResult.setText(s + "3");
        }else if(e.getSource().equals(btn4)){
            txtResult.setText(s + "4");
        }else if(e.getSource().equals(btn5)){
            txtResult.setText(s + "5");
        }else if(e.getSource().equals(btn6)){
            txtResult.setText(s + "6");
        }else if(e.getSource().equals(btn7)){
            txtResult.setText(s + "7");
        }else if(e.getSource().equals(btn8)){
            txtResult.setText(s + "8");
        }else if(e.getSource().equals(btn9)){
            txtResult.setText(s + "9");
        }else if(e.getSource().equals(btnJia)){
            txtResult.setText(s + "+");
        }else if(e.getSource().equals(btnJian)){
            txtResult.setText(s + "-");
        }else if(e.getSource().equals(btnCheng)){
            txtResult.setText(s + "*");
        }else if(e.getSource().equals(btnChu)){
            txtResult.setText(s + "/");
        }else if(e.getSource().equals(btnDian)){
            txtResult.setText(s + ".");
        }else if(e.getSource().equals(btnDeng)){

        }
    }
}
