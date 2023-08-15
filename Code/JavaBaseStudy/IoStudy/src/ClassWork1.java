import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassWork1 {
    public static void main(String[] args) {

    }
    @Test
    public void create1() {
        String filePath = ".\\new1.txt";
        File file1 = new File(filePath);
        try {
            file1.createNewFile();
            System.out.println("创建成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
@Test
    public void writeFile() {
        String filePath = ".\\new2.txt";
        FileOutputStream fileOutput = null;
        try {
            fileOutput = new FileOutputStream(filePath); //覆盖写入
//            fileOutput = new FileOutputStream(filePath,true); //追加写入
            String x = "qwertyu";
//            fileOutput.write(x.getBytes());
            fileOutput.write(x.getBytes(),0,x.length());
            System.out.println("写入成功！");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
//                fileOutput.flush();
                fileOutput.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
