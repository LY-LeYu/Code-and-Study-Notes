import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class homework1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class<PrivateTest> ptc = PrivateTest.class;
//        Constructor ptcConstructor = ptc.getDeclaredConstructor(String.class);
//        ptcConstructor.setAccessible(true);
//        Object ptcObj = ptcConstructor.newInstance("newTest");

        Object ptcObj = ptc.getDeclaredConstructor().newInstance();
        Field name = ptc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(ptcObj, "Update");
        Method getName = ptc.getMethod("getName");
        Object str = getName.invoke(ptcObj);
        System.out.println(str);

    }

}

class PrivateTest {
    private String name = "test";

    public PrivateTest() {
    }

    public PrivateTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}