package test4;

/**
 * @author John.Cena
 * @date 2022/12/10 15:33
 * @Description:
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IVRProgram {
    // 习题集
    static class ExerciseSet {
        int id;
        String type;
        int num;
        String[] formate;
        int[] questions;
        int[] answers;
        int wrongNum;
        int rightNum;

        ExerciseSet(int id, String type, int num) {
            this.id = id;
            this.type = type;
            this.num = num;
            this.formate = new String[num];
            this.questions = new int[num];
            this.answers = new int[num];
        }
    }

    static int id = 1;
    static int num = 50; // 默认习题数量
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ExerciseSet> sets = new ArrayList<>(); // 习题集列表

    public static void main(String[] args) {
        while (true) {
            System.out.println("=====================");
            System.out.println("1. 批量产生习题");
            System.out.println("2. 随机产生习题");
            System.out.println("3. 离线操练习题");
            System.out.println("4. 批量批改操练");
            System.out.println("5. 联机操练习题");
            System.out.println("6. 退出程序");
            System.out.println("=====================");
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    batchGenerateExercise();
                    break;
                case 2:
                    randomGenerateExercise();
                    break;
                case 3:
                    offlineExercise();
                    break;
                case 4:
                    batchCheckExercise();
                    break;
                case 5:
                    onlineExercise();
                    break;
                case 6:
                    System.out.println("退出程序");
                    return;
            }
        }
    }

    // 批量产生习题
    static void batchGenerateExercise() {
        while (true) {
            System.out.println("=====================");
            System.out.println("1. 产生减法习题");
            System.out.println("2. 产生加法习题");
            System.out.println("3. 产生混合习题");
            System.out.println("4. 返回主菜单");
            System.out.println("=====================");
            System.out.print("请选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    generateSubtractionExercise();
                    break;
                case 2:
                    generateAdditionExercise();
                    break;
                case 3:
                    generateMixedExercise();
                    break;
                case 4:
                    return;
            }
        }
    }

    // 产生减法习题
    static void generateSubtractionExercise() {
        System.out.print("请输入要产生的习题数量：");
        int num = scanner.nextInt();
        ExerciseSet set = new ExerciseSet(id++, "减法", num);
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            set.formate[i] = "" + a + "-" + b;
            set.questions[i] = a - b;
            set.answers[i] = a;
        }
        sets.add(set);
        System.out.println("产生减法习题成功，习题集编号为：" + set.id);
    }

    // 产生加法习题
    static void generateAdditionExercise() {
        System.out.print("请输入要产生的习题数量：");
        int num = scanner.nextInt();
        ExerciseSet set = new ExerciseSet(id++, "加法", num);
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            set.formate[i] = "" + a + "+" + b;
            set.questions[i] = a + b;
            set.answers[i] = a;
        }
        sets.add(set);
        System.out.println("产生加法习题成功，习题集编号为：" + set.id);
    }

    // 产生混合习题
    static void generateMixedExercise() {
        System.out.print("请输入要产生的习题数量：");
        int num = scanner.nextInt();
        ExerciseSet set = new ExerciseSet(id++, "混合", num);
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            if (random.nextBoolean()) {
                set.formate[i] = "" + a + "+" + b;
                set.questions[i] = a + b;
            } else {
                set.formate[i] = "" + a + "-" + b;
                set.questions[i] = a - b;
            }
            set.answers[i] = a;
        }
        sets.add(set);
        System.out.println("产生混合习题成功，习题集编号为：" + set.id);
    }

    // 随机产生习题
    static void randomGenerateExercise() {
        System.out.print("请输入要产生的习题数量：");
        int num = scanner.nextInt();
        ExerciseSet set = new ExerciseSet(id++, "随机", num);
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            if (random.nextBoolean()) {
                set.formate[i] = "" + a + "+" + b;
                set.questions[i] = a + b;
            } else {
                set.formate[i] = "" + a + "-" + b;
                set.questions[i] = a - b;
            }
            set.answers[i] = a;
        }
        sets.add(set);
        System.out.println("产生随机习题成功，习题集编号为：" + set.id);
    }

    // 离线操练习题
    static void offlineExercise() {
        System.out.print("请输入要离线操练的习题集编号：");
        int setId = scanner.nextInt();
        ExerciseSet set = null;
        for (ExerciseSet s : sets) {
            if (s.id == setId) {
                set = s;
                break;
            }
        }
        if (set == null) {
            System.out.println("没有找到指定的习题集！");
            return;
        }
        for (int i = 0; i < set.num; i++) {
            System.out.print(set.formate[i] + " = ");
            int answer = scanner.nextInt();
            if (answer == set.answers[i]) {
                set.rightNum++;
            } else {
                set.wrongNum++;
            }
        }
        System.out.println("离线操练习题完成，正确数：" + set.rightNum + "，错误数：" + set.wrongNum);
    }

    // 批量批改操练
    static void batchCheckExercise() {
        System.out.print("请输入要批改的习题集编号：");
        int setId = scanner.nextInt();
        ExerciseSet set = null;
        for (ExerciseSet s : sets) {
            if (s.id == setId) {
                set = s;
                break;
            }
        }
        if (set == null) {
            System.out.println("没有找到指定的习题集！");
            return;
        }
        set.rightNum = 0;
        set.wrongNum = 0;
        for (int i = 0; i < set.num; i++) {
            if (set.questions[i] == set.answers[i]) {
                set.rightNum++;
            } else {
                set.wrongNum++;
            }
        }
        System.out.println("批改操练成功，正确数：" + set.rightNum + "，错误数：" + set.wrongNum);
    }

    // 联机操练习题
    static void onlineExercise() {
        System.out.println("联机操练习题成功！");
    }
}


