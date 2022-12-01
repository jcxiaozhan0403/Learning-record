package com.cn;

import com.cn.pojo.Equation;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/25  16:17
 * @Version 1.0
 * @Param $
 * @return $
 */
public class AdditionOperation extends BinaryOperation {
   /* public AdditionOperation() {
        generateBinaryOperation('+');
    }*/
    public AdditionOperation(){
        generateBinaryOperation('+');
    }

    public AdditionOperation(String s) {
        //System.out.println(s);
        int index = s.indexOf("+");
        int length = s.length();
        this.setLeft_operand(Integer.parseInt(s.substring(0,index)));
        this.setRight_operand(Integer.parseInt(s.substring(index+1,length)));
        this.setOperator(s.charAt(index));
        this.setResult(calculate());
    }

    @Override
    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    @Override
    public int calculate(int left, int right) {
        return left+right;
    }

    @Override
    protected int calculate() {
        return this.getLeftOperand()+this.getRightOperand();
    }





   /* protected int calculate() {
        return this.getLeft()+ this.getRight();
    }


    public AdditionOperation(String s) {
        int index = s.indexOf("+");
        int length = s.length();
        this.setLeft(Integer.parseInt(s.substring(0,index)));
        this.setRight(Integer.parseInt(s.substring(index+1,length)));
        this.setOp(s.charAt(index));
        //this.setOp('+');
        this.setResult(calculate());
    }*/

}
