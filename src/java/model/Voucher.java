/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chuva
 */
public class Voucher {
    private String id;
    private double moneyVoucher;

    public Voucher() {
    }

    public Voucher(String id, double moneyVoucher) {
        this.id = id;
        this.moneyVoucher = moneyVoucher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoneyVoucher() {
        return moneyVoucher;
    }

    public void setMoneyVoucher(double moneyVoucher) {
        this.moneyVoucher = moneyVoucher;
    }
    
}
