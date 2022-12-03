package test3;

import java.io.*;

/**
 * @author John.Cena
 * @date 2022/12/2 17:08
 * @Description:
 */
public class Judgement {
    //正确的
    private int correct = 0;
    //错误的
    private int wrong = 0;
    //文件名
    private String fileName = "";

    /**
     * 读取答案文件
     * @param filePath 文件全限定名
     * @return
     * @throws IOException
     */
    public int[] getResultFile(String filePath) throws IOException {
        //存储读取到的字符串
        String str = "";

        // 创建FileInputStream
        FileInputStream fis = new FileInputStream(filePath);


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
        System.out.println(str);

        //分隔每一个算式
        String[] split = str.split(",");

        //存储答案数组
        int[] values = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.parseInt(split[i]);
        }

        // 关闭流
        fis.close();
        return values;
    }


    /**
     * 读取习题文件，计算出答案
     * @param filePath 文件全限定名
     * @return
     * @throws IOException
     */
    public int[] getExercies(String filePath) throws IOException {
        //存储读取到的字符串
        String str = "";

        //文件名赋值，字符串截取 / 到 .txt 之间的内容
        fileName = filePath.substring(filePath.lastIndexOf('\\')+1,filePath.lastIndexOf(".txt"));

        // 创建FileInputStream
        FileInputStream fis = new FileInputStream(filePath);

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
        System.out.println(str);

        //分隔每一个算式
        String[] split = str.split(",");
        //存储运算后的每一个式子
        String[] exerciseAndValue = new String[split.length];
        //存储答案数组
        int[] values = new int[split.length];
        //存储临时变量
        String tmp = "";
        for (int i = 0; i < split.length; i++) {
            int value = calculate(split[i]);
            tmp = split[i] + "=" + value;
            exerciseAndValue[i] = tmp;
            values[i] = value;
        }

        // 关闭流
        fis.close();
        return values;
    }

    /**
     * 生成报告
     * @param result 结果数组
     * @param answer 答案数组
     * @return
     */
    public String statisticReport(int[] result,int[] answer){
        String str = "";
        int score = 0;

        if (result.length != answer.length){
            return "error";
        }

        for (int i = 0; i < answer.length; i++) {
            if (result[i] == answer[i]){
                correct++;
            }else if(result[i] != answer[i]){
                wrong++;
            }
        }

        score = (correct / answer.length) * 100;

        str = "练习题：" + fileName + "\n" +
                "算式总数：" + answer.length + "\n" +
                "正确：" + correct + "\n" +
                "错误：" + wrong + "\n" +
                "得分：" + (score);

        return str;
    }

    /**
     * 保存报告
     * @param report 生成的报告字符串
     */
    public void saveReport(String report) throws IOException {
        report = report + ",";

        //创建FileOutputStream
        //规定文件路径，没有则创建
        File filePath = new File("src\\outputfile\\");
        if (!filePath.exists()){
            filePath.mkdir();
        }

        File file = new File("src\\outputfile\\" + fileName + "_report.csv");
        FileOutputStream fos = new FileOutputStream(file);

        // 字符串的写出
        fos.write(report.getBytes());

        // 关闭
        fos.close();
    }

    /**
     * 计算结果
     * @param equation
     * @return
     */
    public int calculate(String equation){
        String[] split;
        if (equation.contains("+")){
            split = equation.split("\\+");
            return Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        }else if (equation.contains("-")){
            split = equation.split("-");
            return Integer.parseInt(split[0]) - Integer.parseInt(split[1]);
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Judgement judgement = new Judgement();
        int[] exercies = judgement.getExercies("D:\\Study\\Learning-record\\软件构造\\project\\src\\inputfile\\exercise_add_50_1.txt");
        int[] resultFile = judgement.getResultFile("D:\\Study\\Learning-record\\软件构造\\project\\src\\inputfile\\answers_add_50_3.txt");
        //生成报告，返回字符串
        String s = judgement.statisticReport(exercies, resultFile);
        //打印报告
        System.out.println(s);
        //存储报告
        judgement.saveReport(s);
    }
}
