import java.util.Scanner;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class ArrayReduce {
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceDataLine;

    public ArrayReduce(String path) {
        playMusic(path);
    }
    private void playMusic(String path){
        try{
            int count;
            byte buf[] = new byte[2048];
            //获取音频输入流
            audioStream = AudioSystem.getAudioInputStream(new File(path));
            //获取音频格式
            audioFormat = audioStream.getFormat();

            System.out.println("音频文件: "+path);
            System.out.println("音频Encoding: "+audioFormat.getEncoding());

            //如果不是wav格式，转换mp3文件编码。MPEG1L3（mp3格式）转为PCM_SIGNED（wav格式）
            if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
                audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                        audioFormat.getSampleRate(), 16, audioFormat
                        .getChannels(), audioFormat.getChannels() * 2,
                        audioFormat.getSampleRate(), false);

                audioStream = AudioSystem.getAudioInputStream(audioFormat,
                        audioStream);
            } //转换mp3文件编码结束
            //封装音频信息
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
                    audioFormat,AudioSystem.NOT_SPECIFIED);
            //获取虚拟扬声器（SourceDataLine）实例
            sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);

            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
            //播放音频
            while((count = audioStream.read(buf,0,buf.length)) != -1){
                sourceDataLine.write(buf,0,count);
            }
            //播放结束，释放资源
            sourceDataLine.drain();
            sourceDataLine.close();
            audioStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }




    public static void main(String[] args) throws InterruptedException {
        int[] arrCurrent = {7, 3, 5, 5, 6, 0, 5};
        System.out.println("倒序输入密码7355605，即可拆卸C4");
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("密码总共为7位数，还剩"+arrCurrent.length+"位，加油！请输入：");
            int passWord = scanner.nextInt();
            if (passWord == arrCurrent[arrCurrent.length - 1]) {
                int[] arrNew = new int[arrCurrent.length - 1];
                for (int j = 0; j < arrNew.length; j++) {
                    arrNew[j] = arrCurrent[j];
                }
                arrCurrent = arrNew;
            } else {
                System.out.print("输入错误\nYou Die！");
                break;
            }
            if (arrCurrent.length == 1) {
                System.out.println("就剩最后一位啦，你输入密码的手不禁颤抖起来，突然你的眼前一黑");
                String path = "D:\\Java Study\\Step1_Section06\\src\\9076.wav";
                new ArrayReduce(path);
//                Thread.sleep(3000);

                System.out.println("就当你即将输入最后一位密码时，敌方的一颗子弹带走了你...");
                break;
            }
        } while (true);
        System.out.println("Game Over！C4密码还剩下：");
        for (int j = 0; j < arrCurrent.length; j++) {
            System.out.print(arrCurrent[j] + "\t");
        }
    }


}
