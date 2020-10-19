package xxx;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        File file = new File("d:");
        showFile(file);
    }
    public  static void showFile(File file){
        File []files = file.listFiles();
        for(File f:files){
            Date date = new Date(f.lastModified());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.print(format.format(date)+"\t");
            if(f.isDirectory()){
                System.out.print("<DIR>\t\t\t"+f.getName()+"\n");
                showFile(f);
            }else{
                System.out.print("\t\t"+f.length()+"\t");
                System.out.print("\t"+f.getName()+"\n");
            }
        }
    }
}
