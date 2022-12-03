package test3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author John.Cena
 * @date 2022/12/3 0:03
 * @Description:
 */
public class BinaryOperationBase {
    //上界
    private final  int UPPER = 100;
    //下界
    private final  int LOWER = 1;

    /**
     * 构造方法调用算式基生成,保证只生成一次
     */
    public BinaryOperationBase() {
        this.generateOperationBase();
    }

    //加法算式基
    private String[] addBase;
    //减法算式基
    private String[] subBase;
    //加减法算式基
    private String[] bopBase;

    /**
     * 获取加法算式基
     * @return
     */
    public String[] getAdditionBase(){
        return this.addBase;
    }

    /**
     * 获取减法算式基
     * @return
     */
    public String[] getSubtractionBase(){
        return this.subBase;
    }

    /**
     * 获取混合算式基
     * @return
     */
    public String[] getMixBase(){
        return this.bopBase;
    }

    /**
     * 存储算式基到文件
     * @param fileName 文件名（不带后缀）
     * @param operator 1：加法 2：减法 3：混合
     * @throws IOException
     */
    public void saveOperationBase(File fileName,int operator) throws IOException {
        String str = "";

        //创建FileOutputStream
        //规定文件路径，没有则创建
        File filePath = new File("src\\outputfile\\");
        if (!filePath.exists()){
            filePath.mkdir();
        }
        File file;
        switch (operator){
            case 1:
                String[] additionBase = getAdditionBase();
                StringBuffer sb1 = new StringBuffer();
                for(int i = 0; i < additionBase.length;i++){
                    sb1.append(additionBase[i] + ",");
                }
                str = sb1.toString();
                file = new File("src\\outputfile\\" + fileName);
            break;
            case 2:
                String[] subtractionBase = getSubtractionBase();
                StringBuffer sb2 = new StringBuffer();
                for(int i = 0; i < subtractionBase.length;i++){
                    sb2.append(subtractionBase[i] + ",");
                }
                str = sb2.toString();
                file = new File("src\\outputfile\\" + fileName);
                break;
            case 3:
                String[] mixBase = getMixBase();
                StringBuffer sb3 = new StringBuffer();
                for(int i = 0; i < mixBase.length;i++){
                    sb3.append(mixBase[i] + ",");
                }
                str = sb3.toString();
                file = new File("src\\outputfile\\" + fileName);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        FileOutputStream fos = new FileOutputStream(file);

        // 字符串的写出
        // getBytes() 将字符串转换为对应的字节数组
        fos.write(str.getBytes());

        // 关闭
        fos.close();
    }

    /**
     * 算式基生成
     */
    private void generateOperationBase(){
        String str = "";
        addBase = new String[5050];
        subBase = new String[10000];
        bopBase = new String[15050];

        //生成加法算式基
        int count = 0;
        for (int i = LOWER; i <= UPPER; i++) {
            for (int j = 1; j <= i; j++) {
                str = "" + i + "+" + j;
                addBase[count++] = str;
            }
        }

        //生成减法算式基
        int count2 = 0;
        for (int i = LOWER; i <= UPPER; i++) {
            for (int j = 1; j <= UPPER; j++) {
                str = "" + i + "-" + j;
                subBase[count2++] = str;
            }
        }

        //加减混合
        int count3 = 0;
        for (int k = 0; k < bopBase.length; k++) {
            if (k > 5049){
                bopBase[k] = subBase[count3++];
            }else {
                bopBase[k] = addBase[k];
            }
        }
    }

    /**
     * 生成习题集
     * @param count 习题数量
     * @param operator 1：加法 2：减法 3：混合
     * @return
     */
    public Set<String> generateOperationExercise(int count, int operator){
        HashSet<String> exercise = new HashSet<>();
        Random random = new Random();
        switch (operator){
            case 1:
                String[] additionBase = this.getAdditionBase();
                for (int i = 0; i < count; i++) {
                    exercise.add(additionBase[random.nextInt(additionBase.length)]);
                }
            break;
            case 2:
                String[] subtractionBase = this.getSubtractionBase();
                for (int i = 0; i < count; i++) {
                    exercise.add(subtractionBase[random.nextInt(subtractionBase.length)]);
                }

            break;
            case 3:
                String[] mixBase = this.getMixBase();
                for (int i = 0; i < count; i++) {
                    exercise.add(mixBase[random.nextInt(mixBase.length)]);
                }
            break;
        }

        return exercise;
    }


    public static void main(String[] args) throws IOException {
        BinaryOperationBase binaryOperationBase = new BinaryOperationBase();
        String[] additionBase = binaryOperationBase.getMixBase();
        binaryOperationBase.saveOperationBase(new File("addtionBase.csv"),1);
        Set<String> strings = binaryOperationBase.generateOperationExercise(50, 1);

        for(Object obj : strings) {
            System.out.print(obj + ",");
        }
    }

}
