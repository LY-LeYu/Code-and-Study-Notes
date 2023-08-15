package generic_study;

import java.util.HashMap;
import java.util.HashSet;

public class ClassWork {
    public static void main(String[] args) {
        Student aa = new Student("aa");
        Student bb = new Student("bb");
        Student cc = new Student("cc");
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(aa);
        hashSet.add(bb);
        hashSet.add(cc);
        HashMap<String, Student> stuHashMap = new HashMap<>();
        stuHashMap.put(aa.name, aa);
        stuHashMap.put(aa.name, aa);
        stuHashMap.put(aa.name, aa);
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

}
