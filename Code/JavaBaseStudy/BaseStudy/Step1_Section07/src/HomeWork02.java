public class HomeWork02 {
    public static void main(String[] args) {
        A02 A = new A02();
       int index =  A.find(new String[]{"小猪", "fafa", "22","小猪"});
       System.out.println(index);
    }
}

class A02 {
    public int find(String[] arr) {
        int index = 0;
        for (String i : arr) {
            if (i.equals("小猪")) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
