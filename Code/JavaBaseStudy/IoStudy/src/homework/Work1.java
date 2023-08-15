package homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Work1 {
    public static void main(String[] args) throws IOException {
        String filePath1 = ".\\mytemp";
        String filePath2 = filePath1 + "\\hello.txt";
        File file1 = new File(filePath1);
        if (!file1.exists()) {
            if (file1.mkdir()) {
                System.out.println("文件夹创建成功");
            } else {
                System.out.println("文件夹创建失败");
            }
        } else {
            System.out.println("文件夹已存在！");
        }
        File file2 = new File(filePath2);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath2));
        if (file2.exists()) {
            for (int i = 0; i < 9; i++) {
                bufferedWriter.write("Hello"+i);
                bufferedWriter.newLine();
            }
                bufferedWriter.close();

        } else {
            bufferedWriter.write("Hello,World!");
            bufferedWriter.close();
            System.out.println("创建文件并写入成功！");
        }


    }
}
