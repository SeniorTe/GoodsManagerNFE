package ru.netology.goodsmanagernfe;

public class Product {
    protected int id;
    protected String name;
    protected int price;
    protected String productName;

    public Product(int id, String name, int price, String productName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}