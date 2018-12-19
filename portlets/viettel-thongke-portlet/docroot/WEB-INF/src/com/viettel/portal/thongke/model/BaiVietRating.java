package com.viettel.portal.thongke.model;

import java.util.Date;

public class BaiVietRating {
	long id;
    String tieuDe;
    Date ngayXuatBan;
    String tacGia;
    String diaChi;
    String rating;
    double ratingValue;
    int loaiBaiViet;
    public BaiVietRating(long id,String tieuDe, Date ngayXuatBan,String tacGia,String diaChi,String rating, double ratingValue,int loaiBaiViet){
    	this.id = id;
    	this.tieuDe = tieuDe;
    	this.ngayXuatBan = ngayXuatBan;
    	this.tacGia = tacGia;
    	this.diaChi = diaChi;
    	this.rating = rating;
    	this.ratingValue = ratingValue;
    	this.loaiBaiViet=loaiBaiViet;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public Date getNgayXuatBan() {
		return ngayXuatBan;
	}
	public void setNgayXuatBan(Date ngayXuatBan) {
		this.ngayXuatBan = ngayXuatBan;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public double getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(double ratingValue) {
		this.ratingValue = ratingValue;
	}
	public int getLoaiBaiViet() {
		return loaiBaiViet;
	}
	public void setLoaiBaiViet(int loaiBaiViet) {
		this.loaiBaiViet = loaiBaiViet;
	}
	
}
