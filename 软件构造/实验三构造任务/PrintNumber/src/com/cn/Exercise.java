package com.cn;

import com.cn.pojo.Equation;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/25  13:01
 * @Version 1.0
 * @Param $
 * @return $
 */
public class Exercise{
    private int current = 0;

    private int count = 100;
    private int index = 0;
    private ArrayList<BinaryOperation> exercise = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<BinaryOperation> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<BinaryOperation> exercise) {
        this.exercise = exercise;
    }


    public Exercise() {
        // TODO Auto-generated constructor stub
        index = 0;
        exercise = new ArrayList<BinaryOperation>();
    }

    public Exercise(int count) {
        this.setCount(count);
        index = 0;
        exercise = new ArrayList<BinaryOperation>();
    }
    public boolean occursIn(BinaryOperation e) {
        boolean b = false;
        for(BinaryOperation equation: exercise) {
            if(equation.isEqual(e)) {
                b = true;
                break;
            }
        }
        return b;
    }

    //加减法
    private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
    //
    private BinaryOperation generateOperation(){
        Random random = new Random();
        int opValue = random.nextInt(2);
        if(opValue ==0){
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }

    public void generateBinaryExercise(int operationCount){
        BinaryOperation operation;
        //Random random = new Random();
        while(operationCount>0){
            do{
                operation = generateOperation();
            }while (exercise.contains(operation));//operationList-》exercise
            exercise.add(operation);
            operationCount--;
        }
        //System.out.println(operationList);

    }

    //生成加法习题
    public void generateAdditionExercise(int operationCount){
        BinaryOperation operation;
        while (operationCount>0){
            do{
                operation = new AdditionOperation();
            }while(exercise.contains(operation));
            exercise.add(operation);
            operationCount--;
        }
    }



    //生成减法习题
    public void generateSubstractExercise(int operationCount){
        BinaryOperation operation;
        while (operationCount>0){
            do{
                operation = new SubstractOperation();
            }while(exercise.contains(operation));
            exercise.add(operation);
            operationCount--;
        }
    }



    public boolean hasNext() {
        return index < exercise.size();
    }

    public BinaryOperation next() {
        if(index < exercise.size()) {
            return exercise.get(index++);
        }
        else {
            return null;
        }
    }

     /*public boolean hasNext() {
        return current <= operationList.size()-1;
    }*/

    /*
      遍历返回当前算式，游标+1*/
    /*public BinaryOperation next() {
        return operationList.get(current++);
    }*/



    public void generateAddExercise() {
        int i = 0;
        while(i < count) {
            BinaryOperation e = new AdditionOperation();
            if(!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }

    }

    //混合运算
    public void generateExercise() {
        int i = 0;
        Random r = new Random();
        while(i<count) {
            BinaryOperation e;
            if(r.nextInt(2) == 1) {
                e = new AdditionOperation();
            }
            else {
                e = new SubstractOperation();
            }
            if(!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }
    }

    public void generateSubExercise() {
        int i = 0;
        while(i < count) {
            BinaryOperation e = new SubstractOperation();
            if(!occursIn(e)) {
                exercise.add(e);
                i++;
            }
        }

    }

    public void printExercise() {
        int i = 0;
        for(BinaryOperation e:exercise) {
            i++;
            System.out.print("(" + i + ")" + e.toString());
            if(i % 5 == 0) {
                System.out.println();
            }
            else {
                System.out.print("\t");
            }
        }
    }


    public boolean add(BinaryOperation e) {
        if(index < count) {
            exercise.add(e);
            index++;
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return exercise.size();
    }

    public BinaryOperation get(int index) {
        if(index < size()) {
            return exercise.get(index);
        }
        else {
            return null;
        }
    }



}
