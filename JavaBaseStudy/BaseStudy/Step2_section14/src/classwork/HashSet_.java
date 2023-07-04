package classwork;

import java.util.HashSet;

public class HashSet_ {
    public static void main(String[] args) {
        Employee aa = new Employee("aa", 20, new Mydate(2022, 1, 1));
        Employee bb = new Employee("bb", 40, new Mydate(2022, 1, 2));
        Employee cc= new Employee("aa", 60, new Mydate(2022, 1, 1));
        HashSet<Object> objects = new HashSet<>();
        objects.add(cc);
        objects.add(bb);
        objects.add(aa);
        System.out.println(objects);

    }
}
