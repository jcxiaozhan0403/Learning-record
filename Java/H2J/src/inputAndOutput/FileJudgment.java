package inputAndOutput;

import java.io.File;
import java.util.Date;

public class FileJudgment {
    public static void main(String[] args) {
        File f1 = new File("d:/newfile.txt");

        //文件是否存在
        System.out.println("判断是否存在："+f1.exists());

        //是否是文件夹
        System.out.println("判断是否是文件夹："+f1.isDirectory());

        //是否是文件（非文件夹）
        System.out.println("判断是否是文件："+f1.isFile());

        //文件长度
        System.out.println("获取文件的长度："+f1.length());

        //文件最后修改时间
        long time = f1.lastModified();
        Date d = new Date(time);
        System.out.println("获取文件的最后修改时间："+d);

        //设置文件修改时间为1970.1.1 08:00:00
        f1.setLastModified(0);

        //文件重命名
        File f4 =new File("d:/newfile.txt");
        f1.renameTo(f4);
        System.out.println("把LOL.exe改名成了DOTA.exe");

        File f5 = new File("d:/7-Zip");
        f5.list();

    }
}
