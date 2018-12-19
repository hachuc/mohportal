package com.viettel.portal.thongke.model;

import java.util.Date;

public class PhongBanRating {
    long id;
    String phonBanTen;
    Date ngayTao;
    String nguoiTao;
    String rating;
    double ratingValue;
    public PhongBanRating(long id,String phonBanTen, Date ngayTao,String nguoiTao,String rating,double ratingValue){
    	this.id = id;
    	this.phonBanTen = phonBanTen;
    	this.ngayTao = ngayTao;
    	this.nguoiTao = nguoiTao;
    	this.rating = rating;
    	this.ratingValue = ratingValue;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhonBanTen() {
		return phonBanTen;
	}
	public void setPhonBanTen(String phonBanTen) {
		this.phonBanTen = phonBanTen;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public String getNguoiTao() {
		return nguoiTao;
	}
	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
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
	
}
