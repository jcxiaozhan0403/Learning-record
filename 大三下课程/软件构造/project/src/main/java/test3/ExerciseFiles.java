package test3;

import test2.Exercise;
import test2.ExerciseSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author John.Cena
 * @date 2022/12/2 9:14
 * @Description:
 */
public class ExerciseFiles {
    private static int addExerciseNo = 1;
    private static int subExerciseNo = 1;

    /**
     * 向电脑中写入习题，CSV格式
     * @param exercise 习题集
     * @throws IOException
     */
    public void outputToFile(Exercise exercise) throws IOException {
        char operator = ' ';
        String fileName = "";

        if(exercise.hasNext()){
            operator  = exercise.getOperator();
        }

        //规定文件名
        if (operator == '+'){
            fileName = "exercise_" + "add_" + exercise.getSize() + "_" + (addExerciseNo++) + ".csv";
        }else if (operator == '-'){
            fileName = "exercise_" + "add_" + exercise.getSize() + "_" + (subExerciseNo++) + ".csv";
        }

        //创建FileOutputStream
        //规定文件路径，没有则创建
        File filePath = new File("src\\outputfile\\");
        if (!filePath.exists()){
            filePath.mkdir();
        }

        File file = new File("src\\outputfile\\" + fileName);
        FileOutputStream fos = new FileOutputStream(file);

        // 字符串的写出
        // getBytes() 将字符串转换为对应的字节数组
        ExerciseSheet sheet = new ExerciseSheet();
        fos.write(sheet.toString(exercise).getBytes());

        // 关闭
        fos.close();
    }

    //读取电脑中的CSV文件，格式化输出到控制台 32+5=37
    //文件分为有多余符号和无多余符号两种版本（使用正则表达式进行处理）
    //3~5列格式输出
    //读取时处理文件读取异常
    public void inputFromFile() throws IOException {
        //存储读取到的字符串
        String str = "";

        // 创建FileInputStream
        FileInputStream fis = new FileInputStream("D:\\Study\\Learning-record\\软件构造\\project\\src\\inputfile\\exercise_add_50_1.txt");

        // 使用数组一次读取多个字节
        // 创建大小为3的数组，将数组传入read就会3个3个地进行读取
        byte[] buf = new byte[100];

        // 上述优化后
        // new String(buf, 0, count) 从索引0开始取count长度
        int count = 100;
        while((count = fis.read(buf)) != -1){
            str += new String(buf, 0, count,"gbk");
        }

        //正则处理
        str = str.replaceAll("[^\\d+,-]","");

        //分隔每一个算式
        String[] split = str.split(",");
        //存储运算后的每一个式子
        String[] exerciseAndValue = new String[split.length];
        //存储临时变量
        String tmp = "";
        for (int i = 0; i < split.length; i++) {
            tmp = split[i] + "=" + calculate(split[i]);
            exerciseAndValue[i] = tmp;
        }

        printfFormat(exerciseAndValue);

        // 关闭流
        fis.close();
    }

    /**
     * 计算结果
     * @param equation
     * @return
     */
    public int calculate(String equation){
        String[] split = null;
        if (equation.contains("+")){
            split = equation.split("\\+");
            return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }else if (equation.contains("-")){
            split = equation.split("-");
            return Integer.parseInt(split[0]) - Integer.parseInt(split[1]);
        }
        return -1;
    }

    /**
     * 格式化输出
     * @param equations
     */
    public void printfFormat(String[] equations){
        for (int i = 0; i < equations.length; i++) {
            System.out.print(i+1 + ":");
            System.out.print(equations[i] + "\t");
            if ((i+1)%5 == 0){
                System.out.println("\n");
            }
        }
    }

    //junit测试


    public static void main(String[] args) throws IOException {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exerciseAdd = new Exercise();
        ExerciseFiles exerciseFiles = new ExerciseFiles();

        try {
            //产生算式
            exerciseAdd.generateAdditionExercise(50);
            //写入文件
            exerciseFiles.outputToFile(exerciseAdd);

            exerciseAdd.clean();

            //产生算式
            exerciseAdd.generateAdditionExercise(50);
            //写入文件
            exerciseFiles.outputToFile(exerciseAdd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        exerciseFiles.inputFromFile();
    }
}
