package mapstudy;

import java.util.*;

public class ClassWork {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Employer jack = new Employer("jack", 001, 2000);
        Employer jay = new Employer("jay", 002, 30000);
        Employer lucy = new Employer("lucy", 003, 40000);
        hashMap.put(jack.id, jack);
        hashMap.put(jay.id, jay);
        hashMap.put(lucy.id, lucy);
        //第一种遍历方式
        Collection values = hashMap.values();
//        for (Object value : values) {
//            Employer employer = (Employer) value;
//            if (employer.salary > 18000) {
//                System.out.println(employer);
//            }
//        }
        //第二种遍历方式

        Iterator iterator = values.iterator();
        System.out.println(iterator.next().getClass());
        while (iterator.hasNext()) {
//            Object next = iterator.next();
            System.out.println(iterator.next());
            Employer employer = (Employer) iterator.next();
            if (employer.salary > 18000) {
                System.out.println(employer);
            }
        }

        //第三种迭代方式
        Set keySet = hashMap.keySet();
//        for (Object key : keySet) {
//            Employer employer = (Employer) hashMap.get(key);
//            if (employer.salary > 18000) {
//                System.out.println(employer);
//            }
//        }

        //第四种遍历方式
//        Iterator iterator = keySet.iterator();
//        while (iterator.hasNext()) {
////            Object key =  iterator.next();
//            Employer employer = (Employer) hashMap.get(iterator.next());
//            if (employer.salary > 18000) {
//                System.out.println(employer);
//            }
//        }

        //第五种遍历方式
//        Set<Map.Entry<Object, Object>> entrySet = hashMap.entrySet();
//        Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
//        System.out.println(iterator.next().getClass());
//        while (iterator.hasNext()) {
//            Map.Entry<Object, Object> entry = iterator.next();
//            Employer employer = (Employer) entry.getValue();
//            if (employer.salary > 18000) {
//                System.out.println(entry.getValue());
//            }
//
//        }
    }
}

class Employer {
    String name;
    int id;
    double salary;

    public Employer(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}

