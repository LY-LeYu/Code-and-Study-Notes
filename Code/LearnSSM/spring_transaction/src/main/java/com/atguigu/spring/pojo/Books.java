package com.atguigu.spring.pojo;

public class Books {
    private int id;
    private String book_name;
    private int price;
    private int stock;

    public Books() {
    }

    public Books(int id, String book_name, int price, int stock) {
        this.id = id;
        this.book_name = book_name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
