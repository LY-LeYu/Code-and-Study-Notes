public class StudyBreak {
    public static void main(String[] args) {
        int flag = 1;
        while (true) {
            int rand = (int) (Math.random() * 100);
            if (rand == 98) {
                break;
            }
            flag++;
        }
        System.out.println("生成了" + flag + "次随机数");
    }
}
