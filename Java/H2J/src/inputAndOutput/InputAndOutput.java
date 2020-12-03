package inputAndOutput;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class InputAndOutput {
    public static void main(String[] args) throws IOException {
        //绝对路径
        File f1 = new File("d:/newfile.txt");

        //相对路径
        File f2 = new File("LOL.exe");

        //把f1作为父目录创建文件对象
        File f3 = new File(f1, "LOL.exe");

    }
}