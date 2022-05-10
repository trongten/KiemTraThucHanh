package com.firebase.kiemtrathuchanh;

public class KhoaHoc {
    private String ten;
    private int gia;

    public KhoaHoc(String ten, int gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
