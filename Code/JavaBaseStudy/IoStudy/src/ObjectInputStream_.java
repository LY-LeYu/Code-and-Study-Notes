import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static <OvjectInputStream> void main(String[] args) throws IOException {
        String filePath = ".\\data.dat";
        ObjectInputStream oIS = null;
        try {
            oIS = new ObjectInputStream(new FileInputStream(filePath));
            int x = oIS.readInt();
            Boolean y = oIS.readBoolean();
            String z = oIS.readUTF();
            System.out.println(x);
            System.out.println(y);
            System.out.println(z);
            System.out.println(oIS.readObject());

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            oIS.close();
        }

    }
}
