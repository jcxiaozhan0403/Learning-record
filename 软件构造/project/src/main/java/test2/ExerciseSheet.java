package test2;

/**
 * @author John.Cena
 * @date 2022/11/25 13:47
 * @Description:
 */
public class ExerciseSheet {

    //默认5列显示
    private static final short COLUMN_NUM = 5;

    /**
     * 格式化输出
     * @param ex：习题类对象
     * @param columns：每行算式的个数
     */
    public void formattedDisplay(Exercise ex, int columns) {
        int column  =1;
        int count = 1;
        while(ex.hasNext()) {
            if(column > columns) {
                //一行中的算式数量超过最大列数，则换行
                System.out.println();
                //换行后重置算式数量
                column = 1;
            }
            //输出题号
            System.out.printf("%3d. ", count);
            //输出算式
            System.out.print((ex.next()).asString() + "\t");

            column++;
            count++;
        }
        System.out.println();
    }

    //方法的重载
    public void formattedDisplay(Exercise ex) {
        formattedDisplay(ex, COLUMN_NUM);
    }

    public static void main(String[] args) {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exerciseAdd = new Exercise();
        Exercise exerciseSub = new Exercise();
        Exercise exerciseMix = new Exercise();
        /*产生加法算式习题*/
        System.out.println("---- 加法算式习题一 ----");
        exerciseAdd.generateAdditionExercise(50);
        sheet.formattedDisplay(exerciseAdd, 5);
        System.out.println("---- 加法算式习题二 ----");
        exerciseAdd.generateAdditionExercise(50);
        sheet.formattedDisplay(exerciseAdd, 5);

        /*产生减法算式习题*/
        System.out.println("---- 显示减法算式习题一 ----");
        exerciseSub.generateSubstractExercise(50);
        sheet.formattedDisplay(exerciseSub);
        System.out.println("---- 显示减法算式习题二 ----");
        exerciseSub.generateSubstractExercise(50);
        sheet.formattedDisplay(exerciseSub);

        /*产生加、减法混合算式习题*/
        System.out.println("---- 显示加减法混合算式习题一 ----");
        exerciseMix.generateBinaryExercise(50);
        sheet.formattedDisplay(exerciseMix);
        System.out.println("---- 显示加减法混合算式习题二 ----");
        exerciseMix.generateBinaryExercise(50);
        sheet.formattedDisplay(exerciseMix);
    }
}
