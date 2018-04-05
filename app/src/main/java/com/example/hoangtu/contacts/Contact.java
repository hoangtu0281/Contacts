package com.example.hoangtu.contacts;

/**
 * Created by HoangTu on 01/04/2018.
 */

public class Contact {
    public int id;
    public String hoTen;
    public String gioiTinh;
    public String sdt;

    public Contact() {
    }

    public Contact(int id,String hoTen, String gioiTinh, String sdt ) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;

    }

    public Contact(String hoTen, String gioiTinh, String sdt) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
