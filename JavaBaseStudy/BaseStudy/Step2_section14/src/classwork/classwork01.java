package classwork;

import java.util.ArrayList;
import java.util.Iterator;

public class classwork01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        String[] str1 = new String[10];
        for (int i = 0; i < 10; i++) {
            str1[i] = "str"+i;
            list.add(str1[i]);
        }
        System.out.println(list);
        Iterator iterator = list.iterator();


        list.set(7,"777");
        System.out.println("第五个元素是：" + list.get(5));
        list.remove(6);
        list.add(2,"str22");
        System.out.println("修改后的List：");
        for (Object a : list) { //加强for循环调用

            System.out.println(a);
        }
//        while (iterator.hasNext()) { //使用迭代器调用ArrayList
//            System.out.println(iterator.next());
//        }


    }


}


