/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author chuva
 */
public class Cart extends Product{
    private int quantity,productId,accountId;
    private Date time;
    private String productName, productImage, PurchasedDate;
    private double totalPayment;
    
    public Cart(String productName, int quantity, double totalPayment, String productImage, String PurchasedDate) {
        this.PurchasedDate=this.PurchasedDate;
        this.productImage=productImage;
        this.productName=productName;
        this.quantity=quantity;
        this.totalPayment=totalPayment;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getPurchasedDate() {
        return PurchasedDate;
    }

    public void setPurchasedDate(String PurchasedDate) {
        this.PurchasedDate = PurchasedDate;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
    
    public Cart() {
    }

    public Cart(int quantity, int productId, int accountId, Date time) {
        this.quantity = quantity;
        this.productId = productId;
        this.accountId = accountId;
        this.time = time;
    }

    public Cart(int quantity, int productId, int accountId, Date time, int id, String name, String image, String title, String description, double price) {
        super(id, name, image, title, description, price);
        this.quantity = quantity;
        this.productId = productId;
        this.accountId = accountId;
        this.time = time;
    }

    public Cart(int quantity, int productId, int accountId, Date time, int id, String name, String image, String title, String description, double price, int amount) {
        super(id, name, image, title, description, price, amount);
        this.quantity = quantity;
        this.productId = productId;
        this.accountId = accountId;
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Cart{" + "quantity=" + quantity + ", productId=" + productId + ", accountId=" + accountId + ", time=" + time + '}';
    }
   
}
