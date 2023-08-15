package ly.study.string;

public class Test {
    public static void main(String[] args) {
        Str1 str1 = new Str1();
        str1.change(str1.str);
        System.out.println(str1.str);

    }
}

class Str1 {
    String str = new String("abc");

    public void change(String str) {
        this.str = "java";
    }
}
