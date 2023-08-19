## Java Scanner 类简介

java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入。

下面是创建 Scanner 对象的基本语法：

```Scanner s = new Scanner(System.in);```

## 使用 next 方法：

```import java.util.Scanner; 
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }
}
```

```next方式接收：
next方式接收：
20
输入的数据为：20
输出效果：输入20，回车直接打印20，并且结束
next方式接收：
121212121 1212 1212
输入的数据为：121212121
输出效果:输入121212121 1212 1212，回车直接打印121212121，并且结束
```



## 使用 nextLine 方法：

             // 从键盘接收数据
             Scanner scan = new Scanner(System.in); 
           	// nextLine方式接收字符串
            System.out.println("nextLine方式接收：");
            // 判断是否还有输入
            if (scan.hasNextLine()) {
                String str2 = scan.nextLine();
                System.out.println("输入的数据为：" + str2);
            }
            scan.close();
        }
```nextLine方式接收：
1212 11 151 515 1515
输入的数据为：1212 11 151 515 1515
输出效果：输出了我们输入的一行数据，包括空格 
```

## next() 与 nextLine() 区别

### next():

1. 一定要读取到有效字符后才可以结束输入。
2. 对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
3. 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
4. next() 不能得到带有空格的字符串。

### nextLine()：

1. 以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
2. 2、可以获得空白。
3. 引用：Java Scanner 类 | 菜鸟教程 (runoob.com) 

1. nextInt或者nextFloat......输入 int 或 float 类型的数据,但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取.

### 注意事项 

nextLine（）方法返回的是Enter键之前的所有字符，它是可以得到带空格的字符串的。next（）会自动消去有效字符前的空格键、Tab键或Enter，只返回输入的字符，不能得到带空格的字符串。输入有效字符之后，将其后输入的空格键、Tab键或Enter键等视为分隔符或结束符，但是这些符号仍然在缓冲区内，**如果紧接着使用nextLine()，那么nextLine（）自动读取了被next（）去掉的Enter作为他的结束符，所以没办法从键盘输入值。**

**nextDouble() ，nextFloat() ，nextInt() 等与nextLine（）连用时都存在这个问题。**

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据
     
            // nextInt先接收数据
            int num = scan.nextInt();
            String string = scan.nextLine();
            System.out.println(num);
            System.out.print("......"+string);
            scan.close();
        }
### 输入的数字转换成数组

错误写法

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据
     
            // nextInt先接收数据 确定有几个数组
            int num = scan.nextInt();
            while (num-->0){
                String string = scan.nextLine();
                System.out.println(string);
            }
            scan.close();
        }
正确写法 

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据
     
            // nextInt先接收数据 确定有几个数组
            int num = scan.nextInt();
            scan.nextLine();
            while (num-->0){
                String string = scan.nextLine();
                System.out.println(string);
            }
            scan.close();
        }
```//输入转化成数组
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            // 从键盘接收数据2
            // nextInt先接收数据 确定有几个数组
            int num = scan.nextInt();
            scan.nextLine();
            while (num-->0){
                String string = scan.nextLine();
                String[] strSplit = string.split(" ");
                int[] nums = new int[strSplit.length];
                for (int i = 0; i < strSplit.length; i++) {
                    nums[i] = Integer.parseInt(strSplit[i]);
                }
                for (int i = 0; i < strSplit.length; i++) {
                    System.out.print(nums[i]+" ");
                }
                System.out.println();
            }
            scan.close();
        }
```

