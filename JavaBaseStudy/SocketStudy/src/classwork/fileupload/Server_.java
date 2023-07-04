package classwork.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_ {
    public static void main(String[] args) throws Exception {
        String filePath1 = ".\\src\\classwork\\fileupload\\xkkkk2.jpg";
        //创建资源
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器开始监听...");
        Socket socket = serverSocket.accept();
        //创建IO流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath1));
        BufferedInputStream socketInputStream = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream socketOutputStream = new BufferedOutputStream(socket.getOutputStream());

        //将客户端上传的字节流转换为图片并保存
        byte[] y = StreamUtils.streamToByteArray(socketInputStream);
        bufferedOutputStream.write(y);
        bufferedOutputStream.flush();
        System.out.println("图片保存成功！");

        //回复客户端
        socketOutputStream.write("图片保存成功！".getBytes());
        socketOutputStream.flush(); //不写会报错,因为处理流写入内容先写入到方法的缓存，不调用flush()方法，
                                    // 将导致并未向客户端返回内容，服务器端soket就输入shutdownOutput标识
                                    // 客户端未接受到返回内容就释放资源，导致后续服务器端释放 socketOutputStream 资源时socket已关闭
        socket.shutdownOutput();

        //释放资源
        bufferedOutputStream.close();
        socketInputStream.close();
        socketOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
