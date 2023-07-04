public class HomeWork01 {
    public static void main(String[] args) {
        /*
          写出String转double的语句
          写出char转String的语句
          写出String转char
         */
        String EXAMPLE_1 = "3.1315926";
        double RESULT_1 = Double.parseDouble(EXAMPLE_1);
        System.out.println(RESULT_1);

        char EXAMPLE_2 = 'T';
        String RESULT_2 = EXAMPLE_2 + "";
        System.out.println(RESULT_2);

        char RESULT_3 = EXAMPLE_1.charAt(0);
        System.out.println(RESULT_3);


    }
}
