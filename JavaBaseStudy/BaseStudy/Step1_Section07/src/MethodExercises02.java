public class MethodExercises02 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        myTools tools = new myTools();
//        tools.printDimensionalArray(arr);
        person jack = new person();
        jack.name = "Jay";
        jack.age = 21;
        System.out.println("开始克隆");
        person jack1 =  tools.copyPerson(jack);
        System.out.print("本人："+jack.name+"克隆人："+jack1.name);

    }
}

class  myTools {
    public void printDimensionalArray(int[][] arr) {
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");

        }
    }
    public person copyPerson(person p) {
        person clonePerson = new person();
        clonePerson.name = p.name;
        clonePerson.age = p.age;
        return clonePerson;
    }
}

class person {
    String name;
    int age;
}