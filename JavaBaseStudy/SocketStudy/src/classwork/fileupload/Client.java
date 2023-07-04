package classwork.fileupload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String filePath = ".\\src\\classwork\\fileupload\\xk.jpg";
        //创建资源
        System.out.println("客户端建立链接");
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //创建IO流
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        BufferedInputStream socketInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream socketOutputStream = new BufferedOutputStream(socket.getOutputStream());

        //读取图片转换为字节流并发送至服务器
        byte[] x = StreamUtils.streamToByteArray(inputStream);
        socketOutputStream.write(x);
        socketOutputStream.flush();
        socket.shutdownOutput();

        //获取服务器回复
        System.out.print("服务器回复：");
        byte[] data = new byte[1024];
        int readlen = 0;
        while ((readlen = socketInputStream.read(data)) != -1) {
            System.out.println(new String(data,0,readlen));
        }

        //释放资源
        socketInputStream.close();
        socketOutputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
