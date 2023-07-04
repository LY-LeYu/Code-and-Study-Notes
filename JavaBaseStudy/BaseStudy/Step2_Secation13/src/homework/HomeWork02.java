package homework;

public class HomeWork02 {
    public static void main(String[] args) {
        regeist("jay","123456","1@23123.com");
    }

    public static void regeist(String name, String pwd, String email) {
        if (!(name.length() > 2 && name.length() < 6)) {
            throw new RuntimeException("User‘s name length error");
        }
        if ( !((pwd.length() == 6) && isnum(pwd)) ) {
            throw new RuntimeException("pwd length or format error");
        }
        if (!(email.indexOf('@')>0 && email.indexOf('.')>0 && email.indexOf('@')<email.indexOf('.'))) {
            throw new RuntimeException("email format error");
        }
        System.out.println("注册成功");
        System.out.println("Name:"+name+"\t\t"+"Pwd:"+pwd+"\t\t"+"Email:"+email);
    }

    public static boolean isnum(String str) {
        char[] chars = str.toCharArray();
        for (char i : chars) {
            if (i < '0' || i > '9') {
                return false;
            }
        }
        return true;
    }
}
