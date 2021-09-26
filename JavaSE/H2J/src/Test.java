import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // 1. 创建FileWriter对象
        // 构造时只填写路径的话，默认每次写出都覆盖源文件(从流开启到关闭，算一次写出)，第二个参数添加true，表示追加输出
        FileWriter fw = new FileWriter("e:\\hello.txt",true);

        // 2. 写出文件
        for(int i = 0; i < 10; i ++){
            fw.write("这里写一些内容进去");
            // 缓存区要堆积满了才会一次性写出，在文件极小的情况下可能会存在不写出的问题，所以最好手动调用flush()方法，每次都强制写出
            fw.flush();
        }

        // 3. 关闭
        fw.close();

        try (FileInputStream fis = new FileInputStream(f)) {

        }

        //在finally里面关闭流,需要将fis定义在try外面
        finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
