package homework;

import org.testng.annotations.Test;

import java.util.HashMap;

public class HomeWork01 {
    public static void main(String[] args) {

    }
    @Test
    public void Test1() {
        HashMap<String, A> aHashMap = new HashMap<>();
        aHashMap.put("01", new A("aa"));
        aHashMap.put("02", new A("bb"));
        DAO<A> dao = new DAO<A>(aHashMap);
        dao.upDate("01",new A("aaa"));
    }
}

class A {
    String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}