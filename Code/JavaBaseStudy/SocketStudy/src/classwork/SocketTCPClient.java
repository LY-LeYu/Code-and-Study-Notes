package classwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClient {
    public static void main(String[] args) throws IOException {

        //创建socket及IO流
        System.out.println("客户端建立链接");
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        System.out.println("客户端socket ："+socket.getClass());
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        //发送内容
        outputStream.write("Test Socket".getBytes());
        socket.shutdownOutput(); //写入结束标记
        //接受内容
        byte[] y = new byte[1024];
        int ylen = 0;
        System.out.print("服务器回复：");
        while ((ylen = inputStream.read(y)) != -1) {
            System.out.println(new String(y,0, ylen));
        }
//        socket.shutdownInput();

        //关闭io、socket流
        outputStream.close();
        inputStream.close();

        socket.close();
        System.out.println("客户端退出");
    }
}
