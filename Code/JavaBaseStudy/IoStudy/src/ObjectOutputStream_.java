import java.io.*;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\data.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeUTF("测试");
            objectOutputStream.writeObject(new Dog());
            System.out.println("序列化成功！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        PrintStream out = System.out;
        out.write("asd".getBytes());
    }
}

class Dog implements Serializable {
    String name = "小白";

    public void growl() {
        System.out.print("wang~");
    }

    @Override
    public String toString() {
        growl();
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
