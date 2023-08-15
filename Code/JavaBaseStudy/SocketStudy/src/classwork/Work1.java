package classwork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Work1 {
    public static void main(String[] args) throws UnknownHostException {
        //本机IntAddress
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //获取百度IP，根据域名
        InetAddress baiDu = InetAddress.getByName("www.baidu.com");
        System.out.println("B aiDu:"+baiDu);
    }
}
