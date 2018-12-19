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
public class NhomVanBanSoap implements Serializable {
	public static NhomVanBanSoap toSoapModel(NhomVanBan model) {
		NhomVanBanSoap soapModel = new NhomVanBanSoap();

		soapModel.setId(model.getId());
		soapModel.setTenNhom(model.getTenNhom());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiTaoId(model.getNguoiTaoId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNguoiSuaId(model.getNguoiSuaId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static NhomVanBanSoap[] toSoapModels(NhomVanBan[] models) {
		NhomVanBanSoap[] soapModels = new NhomVanBanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NhomVanBanSoap[][] toSoapModels(NhomVanBan[][] models) {
		NhomVanBanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NhomVanBanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NhomVanBanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NhomVanBanSoap[] toSoapModels(List<NhomVanBan> models) {
		List<NhomVanBanSoap> soapModels = new ArrayList<NhomVanBanSoap>(models.size());

		for (NhomVanBan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NhomVanBanSoap[soapModels.size()]);
	}

	public NhomVanBanSoap() {
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

	public String getTenNhom() {
		return _tenNhom;
	}

	public void setTenNhom(String tenNhom) {
		_tenNhom = tenNhom;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getNguoiTaoId() {
		return _nguoiTaoId;
	}

	public void setNguoiTaoId(long nguoiTaoId) {
		_nguoiTaoId = nguoiTaoId;
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

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getNguoiSuaId() {
		return _nguoiSuaId;
	}

	public void setNguoiSuaId(long nguoiSuaId) {
		_nguoiSuaId = nguoiSuaId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _id;
	private String _tenNhom;
	private String _nguoiTao;
	private long _nguoiTaoId;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private long _nguoiSuaId;
	private int _trangThai;
	private long _groupId;
}