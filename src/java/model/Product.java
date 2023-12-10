/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chuva
 */
public class Product {
    private int id;
    private String name,image,title,description,timeBuy;
    private double price, toltal;
    private int amount;
    public Product() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product(int id, String name, String image, String title, String description, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Product(int id, String name, String image, String title, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(String timeBuy) {
        this.timeBuy = timeBuy;
    }

    public double getToltal() {
        return toltal;
    }

    public void setToltal(double toltal) {
        this.toltal = toltal;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", title=" + title + ", description=" + description + ", price=" + price + ", amount=" + amount + '}';
    }

}
