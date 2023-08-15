package classwork.udpstudy;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9980);

        byte[] sendData = "Test,UDP!".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(sendData, sendData.length,
                InetAddress.getByName("10.214.129.196"),9990);
        datagramSocket.send(datagramPacket);
        System.out.println("发送完毕");

        //读取数据报
        System.out.println("等待接收端回复");
        byte[] Data = new byte[1024];
        DatagramPacket datagramInput = new DatagramPacket(Data,Data.length);
        datagramSocket.receive(datagramInput);
        String read = new String(datagramInput.getData(), 0, datagramInput.getLength());
        System.out.println(read);
        System.out.println("读取完毕");
        //关闭资源
        datagramSocket.close();



    }
}
