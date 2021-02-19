public class Demo{
    public static void main(String[] args) {
// 创建一个10*10的二维数组，放入两个有效值
        int[][] array1 = new int[10][10];
        array1[1][2] = 2;
        array1[4][3] = 5;

//我们打印一下，在控制台会看到如下一个二维数组
/*
        0 0 0 0 0 0 0 0 0 0
        0 0 2 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 5 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
        0 0 0 0 0 0 0 0 0 0
*/
        for (int i = 0;i<array1.length;i++){
            for (int j = 0;j<array1[i].length;j++){
                System.out.print(array1[i][j] + " ");
                if (j == array1[i].length-1) {
                    System.out.println();
                }
            }
        }

// 获取数组中有效值的个数
// 因为数组中初始值全部用0填充，所以这里不为0的就是我们的有效值，把它们筛选出来
        int sum = 0;
        for(int i = 0;i < array1.length; i++){
            for(int j = 0;j < array1[i].length; j++){
                if(array1[i][j] != 0){
                    sum++;
                }
            }
        }

// 创建一个稀疏数组
// 稀疏数组的第一行存放的是原数组的信息，所以稀疏数组的行数=有效值+1，列数3固定
        int[][] array2 = new int[sum+1][3];

//编辑稀疏数组第一行，存放原数组信息
        array2[0][0] = array1.length;
        array2[0][1] = array1[0].length;
        array2[0][2] = sum;

// 再次遍历二维数组，将有效值存入稀疏数组中
// count++的使用恰好让我们在存储有效值时跳过了第一行
        int count = 0;
        for(int i = 0;i < array1.length; i++){
            for(int j = 0;j < array1[i].length; j++){
                if(array1[i][j] != 0){
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }

// 控制台打印查看一下我们转换完成的稀疏数组
/*
        10 10 2
        1 2 2
        4 3 5
*/
        for (int i = 0;i<array2.length;i++){
            for (int j = 0;j<array2[i].length;j++){
                System.out.print(array2[i][j] + " ");
                if (j == array2[i].length-1) {
                    System.out.println();
                }
            }
        }
//恢复
//1. 用稀疏数组中第一行信息创建二维数组
        int[][] array3 = new int[array2[0][0]][array2[0][1]];
//2. 填充二维数组
        for(int i=1; i<array2.length; i++){
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

//        for (int i = 0;i<array3.length;i++){
//            for (int j = 0;j<array3[i].length;j++){
//                System.out.print(array3[i][j] + " ");
//                if (j == array3[i].length-1) {
//                    System.out.println();
//                }
//            }
//        }

    }
}