/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package com.viettel.portal.thongke.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author lamvn
 * @generated
 */
public class BaiVietNhuanButSoap implements Serializable {
	public static BaiVietNhuanButSoap toSoapModel(BaiVietNhuanBut model) {
		BaiVietNhuanButSoap soapModel = new BaiVietNhuanButSoap();

		soapModel.setId(model.getId());
		soapModel.setBaiVietId(model.getBaiVietId());
		soapModel.setLoaiBaiViet(model.getLoaiBaiViet());
		soapModel.setTieuDe(model.getTieuDe());
		soapModel.setTacGia(model.getTacGia());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setNgayXuatBan(model.getNgayXuatBan());
		soapModel.setRating(model.getRating());
		soapModel.setRatingValue(model.getRatingValue());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifyDate(model.getModifyDate());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserId(model.getUserId());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static BaiVietNhuanButSoap[] toSoapModels(BaiVietNhuanBut[] models) {
		BaiVietNhuanButSoap[] soapModels = new BaiVietNhuanButSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BaiVietNhuanButSoap[][] toSoapModels(
		BaiVietNhuanBut[][] models) {
		BaiVietNhuanButSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BaiVietNhuanButSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BaiVietNhuanButSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BaiVietNhuanButSoap[] toSoapModels(
		List<BaiVietNhuanBut> models) {
		List<BaiVietNhuanButSoap> soapModels = new ArrayList<BaiVietNhuanButSoap>(models.size());

		for (BaiVietNhuanBut model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BaiVietNhuanButSoap[soapModels.size()]);
	}

	public BaiVietNhuanButSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getBaiVietId() {
		return _baiVietId;
	}

	public void setBaiVietId(long baiVietId) {
		_baiVietId = baiVietId;
	}

	public int getLoaiBaiViet() {
		return _loaiBaiViet;
	}

	public void setLoaiBaiViet(int loaiBaiViet) {
		_loaiBaiViet = loaiBaiViet;
	}

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getTacGia() {
		return _tacGia;
	}

	public void setTacGia(String tacGia) {
		_tacGia = tacGia;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public Date getNgayXuatBan() {
		return _ngayXuatBan;
	}

	public void setNgayXuatBan(Date ngayXuatBan) {
		_ngayXuatBan = ngayXuatBan;
	}

	public String getRating() {
		return _rating;
	}

	public void setRating(String rating) {
		_rating = rating;
	}

	public double getRatingValue() {
		return _ratingValue;
	}

	public void setRatingValue(double ratingValue) {
		_ratingValue = ratingValue;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifyDate() {
		return _modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private long _id;
	private long _baiVietId;
	private int _loaiBaiViet;
	private String _tieuDe;
	private String _tacGia;
	private String _diaChi;
	private Date _ngayXuatBan;
	private String _rating;
	private double _ratingValue;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifyDate;
	private String _userName;
	private long _userId;
	private int _type;
}