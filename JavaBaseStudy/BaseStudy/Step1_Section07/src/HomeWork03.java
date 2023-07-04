
public class HomeWork03 {
    public static void main(String[] args) {
        Book b = new Book(500);
        b.updateBook();
        System.out.println(b.price);
    }

}

class Book {
    String name;
    int price;
    public Book(int price) {
        this.name = "三国演义";
        this.price = price;
    }

    public void updateBook() {
        if (this.price > 150) {
            this.price = 150;
        } else if (this.price < 100) {
            this.price = 100;
        }
    }
}
