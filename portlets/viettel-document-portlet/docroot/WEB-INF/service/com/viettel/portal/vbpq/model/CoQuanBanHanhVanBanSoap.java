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

package com.viettel.portal.vbpq.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author ChucHV
 * @generated
 */
public class CoQuanBanHanhVanBanSoap implements Serializable {
	public static CoQuanBanHanhVanBanSoap toSoapModel(CoQuanBanHanhVanBan model) {
		CoQuanBanHanhVanBanSoap soapModel = new CoQuanBanHanhVanBanSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setOrder_(model.getOrder_());
		soapModel.setNhomVanBanId(model.getNhomVanBanId());

		return soapModel;
	}

	public static CoQuanBanHanhVanBanSoap[] toSoapModels(
		CoQuanBanHanhVanBan[] models) {
		CoQuanBanHanhVanBanSoap[] soapModels = new CoQuanBanHanhVanBanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoQuanBanHanhVanBanSoap[][] toSoapModels(
		CoQuanBanHanhVanBan[][] models) {
		CoQuanBanHanhVanBanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoQuanBanHanhVanBanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoQuanBanHanhVanBanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoQuanBanHanhVanBanSoap[] toSoapModels(
		List<CoQuanBanHanhVanBan> models) {
		List<CoQuanBanHanhVanBanSoap> soapModels = new ArrayList<CoQuanBanHanhVanBanSoap>(models.size());

		for (CoQuanBanHanhVanBan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoQuanBanHanhVanBanSoap[soapModels.size()]);
	}

	public CoQuanBanHanhVanBanSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public boolean getTrangThai() {
		return _trangThai;
	}

	public boolean isTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		_trangThai = trangThai;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getOrder_() {
		return _order_;
	}

	public void setOrder_(int order_) {
		_order_ = order_;
	}

	public long getNhomVanBanId() {
		return _nhomVanBanId;
	}

	public void setNhomVanBanId(long nhomVanBanId) {
		_nhomVanBanId = nhomVanBanId;
	}

	private long _id;
	private String _ten;
	private boolean _trangThai;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _groupId;
	private int _order_;
	private long _nhomVanBanId;
}