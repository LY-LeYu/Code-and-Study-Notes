package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HomeWork03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println("修改前的hashMap:\n"+hashMap);
        hashMap.replace("jack", 2600);
        System.out.println("jack工资改为2600");
        for (Object key : hashMap.keySet()) {
            hashMap.replace(key,(int)hashMap.get(key)+100);
        }
        System.out.println("所有人工资涨100");
        System.out.println("修改后的hashMap：\n"+hashMap);

        Set key = hashMap.keySet();
        Iterator iterator = key.iterator();
        System.out.println("遍历员工：");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("遍历工资：");
        for (Object values : hashMap.values()) {
            System.out.println(values);
        }


    }
}
