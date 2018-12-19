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
public class VanBanPhapQuySoap implements Serializable {
	public static VanBanPhapQuySoap toSoapModel(VanBanPhapQuy model) {
		VanBanPhapQuySoap soapModel = new VanBanPhapQuySoap();

		soapModel.setId(model.getId());
		soapModel.setMaVanBan(model.getMaVanBan());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrichYeu(model.getTrichYeu());
		soapModel.setCoQuanBanHanh(model.getCoQuanBanHanh());
		soapModel.setLoaiVanBan(model.getLoaiVanBan());
		soapModel.setLinhVucVanBan(model.getLinhVucVanBan());
		soapModel.setNgayBanHanh(model.getNgayBanHanh());
		soapModel.setNgayCoHieuLuc(model.getNgayCoHieuLuc());
		soapModel.setNgayHetHieuLuc(model.getNgayHetHieuLuc());
		soapModel.setNguoiKy(model.getNguoiKy());
		soapModel.setVanBanThayThe(model.getVanBanThayThe());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByDate(model.getStatusByDate());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setNhomVanBanId(model.getNhomVanBanId());

		return soapModel;
	}

	public static VanBanPhapQuySoap[] toSoapModels(VanBanPhapQuy[] models) {
		VanBanPhapQuySoap[] soapModels = new VanBanPhapQuySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VanBanPhapQuySoap[][] toSoapModels(VanBanPhapQuy[][] models) {
		VanBanPhapQuySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VanBanPhapQuySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VanBanPhapQuySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VanBanPhapQuySoap[] toSoapModels(List<VanBanPhapQuy> models) {
		List<VanBanPhapQuySoap> soapModels = new ArrayList<VanBanPhapQuySoap>(models.size());

		for (VanBanPhapQuy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VanBanPhapQuySoap[soapModels.size()]);
	}

	public VanBanPhapQuySoap() {
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

	public String getMaVanBan() {
		return _maVanBan;
	}

	public void setMaVanBan(String maVanBan) {
		_maVanBan = maVanBan;
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

	public String getTrichYeu() {
		return _trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		_trichYeu = trichYeu;
	}

	public long getCoQuanBanHanh() {
		return _coQuanBanHanh;
	}

	public void setCoQuanBanHanh(long coQuanBanHanh) {
		_coQuanBanHanh = coQuanBanHanh;
	}

	public long getLoaiVanBan() {
		return _loaiVanBan;
	}

	public void setLoaiVanBan(long loaiVanBan) {
		_loaiVanBan = loaiVanBan;
	}

	public long getLinhVucVanBan() {
		return _linhVucVanBan;
	}

	public void setLinhVucVanBan(long linhVucVanBan) {
		_linhVucVanBan = linhVucVanBan;
	}

	public Date getNgayBanHanh() {
		return _ngayBanHanh;
	}

	public void setNgayBanHanh(Date ngayBanHanh) {
		_ngayBanHanh = ngayBanHanh;
	}

	public Date getNgayCoHieuLuc() {
		return _ngayCoHieuLuc;
	}

	public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
		_ngayCoHieuLuc = ngayCoHieuLuc;
	}

	public Date getNgayHetHieuLuc() {
		return _ngayHetHieuLuc;
	}

	public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
		_ngayHetHieuLuc = ngayHetHieuLuc;
	}

	public String getNguoiKy() {
		return _nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		_nguoiKy = nguoiKy;
	}

	public long getVanBanThayThe() {
		return _vanBanThayThe;
	}

	public void setVanBanThayThe(long vanBanThayThe) {
		_vanBanThayThe = vanBanThayThe;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getStatusByDate() {
		return _statusByDate;
	}

	public void setStatusByDate(Date statusByDate) {
		_statusByDate = statusByDate;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public long getNhomVanBanId() {
		return _nhomVanBanId;
	}

	public void setNhomVanBanId(long nhomVanBanId) {
		_nhomVanBanId = nhomVanBanId;
	}

	private long _id;
	private String _maVanBan;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private String _trichYeu;
	private long _coQuanBanHanh;
	private long _loaiVanBan;
	private long _linhVucVanBan;
	private Date _ngayBanHanh;
	private Date _ngayCoHieuLuc;
	private Date _ngayHetHieuLuc;
	private String _nguoiKy;
	private long _vanBanThayThe;
	private long _groupId;
	private int _status;
	private Date _statusByDate;
	private long _statusByUserId;
	private String _statusByUserName;
	private long _nhomVanBanId;
}