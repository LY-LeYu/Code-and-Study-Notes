package homework;


import java.io.*;


public class Work2 {
    public static void main(String[] args) throws IOException {
        String filePath1 = ".\\src\\homework\\test1.txt";
        String filePath2 = ".\\src\\homework\\test2.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath1));
            bufferedWriter = new BufferedWriter(new FileWriter(filePath2));
            String read;
            int i = 1;
            System.out.println("读取成功");
            while ((read = bufferedReader.readLine()) != null) {
                System.out.println(i+":"+read);
                bufferedWriter.write(i+":"+read);
                bufferedWriter.newLine();
                i++;
            }
            System.out.println("写入完成");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bufferedWriter.close();
            bufferedReader.close();

        }
    }
}
