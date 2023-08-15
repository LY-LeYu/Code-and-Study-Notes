package classwork.udpstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        //创建UDP传输端口
        DatagramSocket datagramSocket = new DatagramSocket(9990);

        //创建UDP数据报
        byte[] buf = new byte[1024];
        DatagramPacket datagramInput = new DatagramPacket(buf,buf.length);


        System.out.println("接收端等待接收...");
        datagramSocket.receive(datagramInput);

        //读取数据报
        String read = new String(datagramInput.getData(), 0, datagramInput.getLength());
        System.out.println(read);
        System.out.println("接收完成！");

        //发送数据
        System.out.println("发送回复");
        byte[] data = "Test Over!".getBytes();
        DatagramPacket datagramOutput = new DatagramPacket(data,data.length,
                InetAddress.getByName("10.214.129.196"),9980);
        datagramSocket.send(datagramOutput);

        //关闭资源
        datagramSocket.close();


    }
}
