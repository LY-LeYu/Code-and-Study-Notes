package classwork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        //创建socket及IO流
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器开始监听...");
        Socket socket = serverSocket.accept();
//        System.out.println("服务端Socket :"+ socket.getClass());
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        //接收并输出
        System.out.print("客户端请求：");
        byte[] x = new byte[1024];
        int xLen = 0;
        while ((xLen = inputStream.read(x)) != -1) {
            System.out.println(new String(x,0, xLen));
        }

        // 发送内容
        outputStream.write("OK!".getBytes());
        socket.shutdownOutput();  //写入结束标记

        //释放资源
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
