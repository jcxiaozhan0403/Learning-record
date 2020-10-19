package abc;

import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("d:\\abc.txt");
        BufferedReader br =new BufferedReader(fr);

        FileWriter fw = new FileWriter("d:\\123.txt");
        BufferedWriter bw =new BufferedWriter(fw);

        int n = 0;
        char[] cs = new char[1024];
        while ((n = br.read(cs, 0, 1024)) != -1) {
            System.out.print(new String(cs,0,n));
            bw.write(cs,0,n);
            }

        bw.close();
        fr.close();
        br.close();

    }
}
