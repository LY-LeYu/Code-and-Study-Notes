package classwork;

import java.security.AllPermission;
import java.util.List;
import java.util.Vector;

public class ClassWork02 {

    public static void main(String[] args) {
        Book book1 = new Book("aaa", 20.5);
        Book book2 = new Book("bbb", 201.5);
        Book book3 = new Book("ccc", 2.5);
        Vector list = new Vector();
        list.add(book1);
        list.add(book2);
        list.add(book3);
        System.out.println(list);
        bubble(list);


    }

    public static void bubble(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0;j < list.size() - i - 1; j++) {
                Book b1 = (Book)list.get(j);
                Book b2 = (Book)list.get(j+1);
                if (b1.price > b2.price) {
                    list.set(j,b2);
                    list.set(j+1,b1);
                }
            }
        }
        System.out.println(list);

    }
}

class Book {
    String name;
    Double price;

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


