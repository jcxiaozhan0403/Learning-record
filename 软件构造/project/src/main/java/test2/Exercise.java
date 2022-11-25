package test2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author John.Cena
 * @date 2022/11/25 12:48
 * @Description:
 */
public class Exercise {
    //存放算式的集合
    private ArrayList<BinaryOperation_3_2> operationList = new ArrayList<>();
    //集合的游标
    private int current = 0;

    /**
     * 产生加法算式习题
     * @param operationCount：习题中算式的个数
     */
    public void generateAdditionExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        while(operationCount > 0) {
            do {
                anOperation = new AdditionOperation();
                //算式存在，重新生成
            }while(operationList.contains(anOperation));
            //向习题中添加算式，计数减一
            operationList.add(anOperation);
            operationCount--;
        }
    }

    /**
     * 产生减法算式习题
     * @param operationCount：习题中算式的个数
     */
    public void generateSubstractExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        while(operationCount > 0) {
            do {
                anOperation = new SubstractOperation();
                //算式存在，重新生成
            }while(operationList.contains(anOperation));
            //向习题中添加算式，计数减一
            operationList.add(anOperation);
            operationCount--;
        }
    }

    /**
     * 产生加减法混合算式习题
     * @param operationCount：习题中算式的个数
     */
    public void generateBinaryExercise(int operationCount) {
        BinaryOperation_3_2 anOperation;
        Random random = new Random();
        while(operationCount > 0) {
            do {
                //生成随机操作符
                int opValue = random.nextInt(2);
                if(opValue == 0)
                    //生成加法算式
                    anOperation = new AdditionOperation();
                else{
                    //减法加法算式
                    anOperation = new SubstractOperation();
                }
                //算式存在，重新生成
            }while(operationList.contains(anOperation));
            //向习题中添加算式，计数减一
            operationList.add(anOperation);
            operationCount--;
        }
    }

    /**
     * 遍历判断是否有下一个算式
     * @return
     */
    public boolean hasNext() {
        return current <= operationList.size()-1;
    }

    /**
     * 遍历返回当前算式，游标+1
     * @return 当前算式
     */
    public BinaryOperation_3_2 next() {
        return operationList.get(current++);
    }

}
