public class ConstructorExercise {
    public static void main(String[] args) {
        Test P = new Test();
        System.out.println(P.name+P.age);
        Test P1 = new Test("Jay", 80);
        System.out.println(P1.name+P1.age);
        boolean index = P.compare(P1);
        System.out.println(index);


    }
}
class Test {
    String name;
    int age;
    public Test() {
        name = "Jay";
        age = 40;
    }
    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compare(Test T) {
        return this.name.equals(T.name) && this.age == T.age;
    }

}