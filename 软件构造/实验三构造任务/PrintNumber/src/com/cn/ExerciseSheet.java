package com.cn;

import com.cn.file.ExerciseFileDAO;
import com.cn.pojo.Answer;
import com.cn.pojo.Check;
import com.cn.pojo.Parents;
import com.cn.Exercise;

import java.util.Scanner;

/**
 * @Author WangHuaiyu
 * Created by 529044029@qq.com
 * Date on 2022/11/25  12:39
 * @Version 1.0
 * @Param $
 * @return $
 */
public class ExerciseSheet {
    public static final short OPERATION_NUMBER = 50;//50道
    public static final short COLUMN_NUMBER = 5;//列数
   /* private static Exercise exercise;
    private Answer answer;
    private Check check;*/
    private Exercise exercise;


    /*public ExerciseSheet() {
    }*/

    /*public static void setExercise(Exercise exercise) {
        ExerciseSheet.exercise = exercise;
    }*/

    public void formattedDisplay(Exercise ex,int columns,int Number){
        int count =0;
        int index = 1;//下标
        while(ex.hasNext()) {
            /*if(column > columns) {
                //一行中的算式数量超过最大列数，则换行
                System.out.println();
                //换行后重置算式数量
                column = 1;
            }*/

            if(count%columns==0 && count!=0){
                System.out.print("\n");
            }
            //输出题号
            //System.out.printf("%10d、", index);
            //输出算式
            System.out.print(String.format("%-2d",(index))+ "." + (ex.next()).fullString() + "\t"+"\t"+"\t"+String.format("%12s",(" ")));
            index++;
            count++;
        }
        System.out.println();
    }
    public void formattedDisplay(Exercise ex){
        formattedDisplay(ex,COLUMN_NUMBER,OPERATION_NUMBER);
    }

    /*private static void print(String str){
        System.out.println(str);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ExerciseSheet exerciseSheet = new ExerciseSheet();

        //1.批量生成算式存储到csv中
        //添加ExerciseFiles类
        //练习题为20-50d道，生成多个文件，加、减、混合题各一套
        /* Exercise exercise = new Exercise();
        Answer answer = new Answer();
        exercise.setIndex(0);
        Parents parents = new Parents(50,1);
        parents.writeAddExercisesToFiles();//加法运算
        parents.writeSubExercisesToFiles();//减法运算
        parents.writeExercisesToFiles();//混合运算
        */


        //2.读取文件，读取习题，添加运算结果
        //给指定文件添加答案，首先读取文件相应文件
        Answer answer = new Answer();
        answer.scanAnswerFromKeyboard(50);
        answer.writeAnswerToFile("D:\\csv\\answer_add_50_0.csv");


        //3.批改作业
        Parents parents = new Parents(50,1);
        //parents.writeExercisesToFiles();
        //ExerciseFileDAO fileDAO = new ExerciseFileDAO();
        parents.setSc(sc);
        parents.check();





        //exercise.generateBinaryExercise(OPERATION_NUMBER);//混合运算
        //exercise.generateExercise();
        //exercise.generateAddExercise();//减法
        //exercise.generateAddExercise();//加法
        //parents.writeAddExercisesToFiles();//加法
        //parents.writeSubExercisesToFiles();//减法

        /*exercise.generateBinaryExercise(OPERATION_NUMBER);
        System.out.println("---- generate and display add exercises 加减法----") ;
        exerciseSheet.formattedDisplay(exercise,COLUMN_NUMBER,OPERATION_NUMBER) ;*/


       /* while(exercise.hasNext()){
            System.out.print("("+i+")"+exercise.next().asString());
            answer.add(sc.nextInt());
            System.out.println(answer.getIndex());
        }*/

       /* for(int j = 0; j < answer.getIndex(); j++) {
            Integer answerIndex = answer.getAnswer().get(j);
            //out.write(equation.toString() + ",");
            answer.add(sc.nextInt());

        }*/

       // System.out.println(answer.getAnswer());
        /*Check check = new Check();
        check.check(exercise,answer);
        check.printCheck();*/



      /*  parents.setSc(sc);
        parents.check();*/

        //answer.writeAnswerToFile("");
       /* answer.writeAnswerToFile("D://csv/answers_add_50_0.csv");
        parents.writeAddExercisesToFiles();*/
        //parents.writeExercisesToFiles();
        //answer.readAnswerFromFile("D://csv/answers_add_50_3.csv");
       /* answer.readAnswerFromFile("D://csv/answers_add_50_0.csv");
        answer.writeAnswerToFile("D://csv/answers_add_50_0.csv");
        answer.scanAnswerFromKeyboard(50);*/
        //System.out.println(parents.getCount());



    }

   /* public  void practiceOneByOne(){
        exercise.setIndex(0);
        int i = 1;
        System.out.println("输入答案后回车继续下一题");
        Answer answer = new Answer();
        while(exercise.hasNext()){
            System.out.print("("+i+")"+exercise.next().asString());
            answer.add(sc.nextInt());
        }
        Check check = new Check();
        check.check(exercise,answer);
        check.printCheck();
        Parents parents = new Parents(OPERATION_NUMBER,1);
        parents.writeAddExercisesToFiles();
        answer.readAnswerFromFile("D://csv/answers_add_50_3.csv");
        //answer.scanAnswerFromKeyboard(60);
        System.out.println(parents.getCount());

    }*/
}
