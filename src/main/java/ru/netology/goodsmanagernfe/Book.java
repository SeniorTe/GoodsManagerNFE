package ru.netology.goodsmanagernfe;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String productName, String author) {
        super(id, name, price, productName);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}