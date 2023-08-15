package homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Work3 {
    public static void main(String[] args) throws IOException {
        String filePath1 = ".\\src\\homework\\dog.properties";
        String filePath2 = ".\\src\\homework\\dog.dat";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath1));
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age")+"");
        String color = properties.get("color") + "";
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //序列化dog类
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath2));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
        System.out.println("dog对象序列化完成");

        //测试反序列化
    }
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String filePath3 = ".\\src\\homework\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath3));
        Dog dog2 = (Dog)objectInputStream.readObject();
        System.out.println("反序列化完成");
        System.out.println(dog2);
    }
}

class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {

        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
