package ru.netology.goodsmanagernfe;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String productName, String manufacturer) {
        super(id, name, price, productName);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
