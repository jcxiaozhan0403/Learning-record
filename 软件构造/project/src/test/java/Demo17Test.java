/**
 * @author John.Cena
 * @date 2022/10/7 22:10
 * @Description:
 */
// 17题测试程序
public class Demo17Test {
    public static void main(String[] args) {

    }

    public static String equationFormate(int[] equation){
        String operator = null;
        if (equation[2] == 0){
            operator = "+";
        }else if (equation[2] == 1){
            operator = "-";
        }

        return "" + equation[0] + operator + equation[1] + "=";
    }

    /**
     * 整齐打印题目
     * @param equations
     * @param col 列数
     */
    public static void printExercise(int[][] equations,int col){
        System.out.println("-------------------------------------");
        System.out.println("- 程序输出" + equations.length + "道加减法算式的习题 -");
        System.out.println("-------------------------------------");
        for (int i = 0; i < equations.length; i++) {
            String equation = equationFormate(equations[i]);
            //打印序号
            if ((i)%col == 0){
                if ((i+col)>equations.length){
                    //最后一行特殊处理
                    System.out.print(i+1 + "~" + equations.length + ":\t");
                }else {
                    //正常打印
                    System.out.print(i+1 + "~" + (col+i) + ":\t");
                }
            }
            //制表符控制题目间隔
            System.out.print(equation + "\t");
            //控制换行，指定列数的整数倍，进行换行
            if ((i+1)%col == 0){
                System.out.print("\n");
            }
        }
    }

    /**
     * 测试整齐输出，每行5列算式
     */
    public void printExerciseTester(){
        //判断
        boolean equal;
        //测试数据
        int [] testData = {10,11,19,50,55,59,61,100,101,119,120};
        //期望结果
        String[] expected = new String[10];

        //通过测试、测试失败、未执行测试
        int succeed=0,failed=0,executed=0;

        //循环填充数组
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < testData[i] ;j++){
                int[][] equations = new int[testData[i]][4];
                equations[testData[i]][0] = 1;
                equations[testData[i]][0] = 1;
                equations[testData[i]][0] = 0;
                equations[testData[i]][0] = 2;


            }
        }

    }
}
