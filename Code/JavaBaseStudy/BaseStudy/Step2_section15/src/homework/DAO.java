package homework;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DAO<T> {
   private Map<String,T> map;

    public DAO(Map map) {
        this.map = map;
    }

    public void save(String id, T entity) {
        this.map.put(id, entity);
        System.out.println(map);
    }

    public void upDate(String id, T entity) {
        this.map.put(id, entity);
        System.out.println(map);
    }


}
