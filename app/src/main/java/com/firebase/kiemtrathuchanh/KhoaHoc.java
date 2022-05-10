package com.firebase.kiemtrathuchanh;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class KhoaHoc {
    private String ten;
    private int gia;

    public KhoaHoc() {
    }

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
