package com.cn;

import com.cn.pojo.Equation;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/25  12:37
 * @Version 1.0
 * @Param $
 * @return $
 */
public abstract class BinaryOperation {
    static final int UPPER = 100;
    static final int LOWER = 0;
    private int left_operand =0,right_operand=0;
    private char operator='+';
    private int value = 0;



    public void setLeft_operand(int left_operand) {
        this.left_operand = left_operand;
    }

    public void setRight_operand(int right_operand) {
        this.right_operand = right_operand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setResult(int value) {
        this.value = value;
    }

    public int getLeftOperand(){
        return left_operand;
    }
    public int getRightOperand(){
        return right_operand;
    }
    public char getoperator(){
        return operator;
    }
    public int getResult(){
        return value;
    }

    protected void generateBinaryOperation(char anOperator){
        int left,right,result;
        Random random = new Random();
        left = random.nextInt(UPPER+1);
        do{
            right = random.nextInt(UPPER+1);
            result = calculate(left,right);
        }while(!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;

    }

    protected abstract boolean checkingCalculation(int anInteger);
    protected abstract int calculate(int left,int right);
    protected abstract int calculate();


    public int construct(int left, int right, char op){
        int result=0;//初始化
        if (!(0 <= left && left <= 100)){
            throw new RuntimeException("左运算数不在0~100的范围");
        }
        if (!(0 <= right && right <= 100)){
            throw new RuntimeException("右运算数不在0~100的范围");
        }
        if (op == '+'){
            result = left+right;
            if (!(0 <= result && result <= 100)){
                throw new RuntimeException("加法运算结果不在0~100的范围");
            }
        } else if (op == '-'){
            result = left-right;
            if (!(0 <= result && result <= 100)){
                throw new RuntimeException("减法运算结果不在0~100的范围");
            }
        } else {
            throw new RuntimeException(op+"不是加号或减号运算符！");
        }
        left_operand = left;
        right_operand = right;
        operator = op;
        value = result;
        return value;
    }

    private int generateRandom(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    private boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public boolean isEqual(BinaryOperation e) {
        boolean b = false;
        if(e.getoperator() != this.getoperator()) {
            b = false;
        }
        else {
            b = e.getLeftOperand() == this.getLeftOperand() && e.getRightOperand() == this.getRightOperand();
        }
        return b;
    }

    public void generateEquation(char op) {
        int left,right,result;
        do {
            left = generateRandom(LOWER, UPPER);
            right = generateRandom(LOWER, UPPER);
            result = calculate();
        }while(!isBetween(result, LOWER, UPPER));
        this.setOperator(op);
    }




    /*public com.cn.BinaryOperation generateAdditionOperation(){
        Random random = new Random();
        int left ,right,result;
        left = random.nextInt(UPPER+1);
        do{
            left = random.nextInt(UPPER+1);
            right = random.nextInt(UPPER+1);
            result = left + right;
        }while(result>UPPER);
        com.cn.BinaryOperation bop = new com.cn.BinaryOperation();
        bop.construct(left,right,'+');
        return bop;
    }*/

   /* public com.cn.BinaryOperation generateSubstractOperation(){
        Random random = new Random();
        int left ,right,result;
        left = random.nextInt(UPPER+1);
        do{
            left = random.nextInt(UPPER+1);
            right = random.nextInt(UPPER+1);
            result = left - right;
        }while(result<LOWER);
        com.cn.BinaryOperation bop = new com.cn.BinaryOperation();
        bop.construct(left,right,'-');
        return bop;
    }*/



    public boolean equals (BinaryOperation binaryOperation){
        return  left_operand == binaryOperation.getLeftOperand() &
                right_operand == binaryOperation.getRightOperand() &
                operator == binaryOperation.getoperator();
    }

    //
    public String toString(){
        return ""+left_operand+operator+right_operand+"";
    }
    public String toCsV(){
        return ""+' '+this.toString()+' '+"";
    }
    public String asString(){
        return  toString()+"=";
    }
    public String fullString(){
        return asString()+value;
    }


}





