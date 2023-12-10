/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author chuva
 */
public class Account {
    private int id,isSell,isAdmin,daMua,canBan,daBan;
    private double daThanhToan,tienThuVe;
    private String user,pass;

    public Account() {
    }

    public Account(int id, int isSell, int isAdmin, String user, String pass) {
        this.id = id;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.user = user;
        this.pass = pass;
    }

    public int getCanBan() {
        return canBan;
    }

    public void setCanBan(int canBan) {
        this.canBan = canBan;
    }

    public int getDaBan() {
        return daBan;
    }

    public void setDaBan(int daBan) {
        this.daBan = daBan;
    }

    public double getTienThuVe() {
        return tienThuVe;
    }

    public void setTienThuVe(double tienThuVe) {
        this.tienThuVe = tienThuVe;
    }
    
    public int getDaMua() {
        return daMua;
    }

    public void setDaMua(int daMua) {
        this.daMua = daMua;
    }

    public double getDaThanhToan() {
        return daThanhToan;
    }

    public void setDaThanhToan(double daThanhToan) {
        this.daThanhToan = daThanhToan;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", isSell=" + isSell + ", isAdmin=" + isAdmin + ", user=" + user + ", pass=" + pass + '}';
    }
    
}
