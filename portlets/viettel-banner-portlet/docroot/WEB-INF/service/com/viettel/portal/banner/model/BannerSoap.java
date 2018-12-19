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

package com.viettel.portal.banner.model;

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
public class BannerSoap implements Serializable {
	public static BannerSoap toSoapModel(Banner model) {
		BannerSoap soapModel = new BannerSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setFileId(model.getFileId());
		soapModel.setFileLink(model.getFileLink());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNgayKetThuc(model.getNgayKetThuc());
		soapModel.setLienKet(model.getLienKet());
		soapModel.setOrder_(model.getOrder_());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiTaoId(model.getNguoiTaoId());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNguoiSuaId(model.getNguoiSuaId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static BannerSoap[] toSoapModels(Banner[] models) {
		BannerSoap[] soapModels = new BannerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[][] toSoapModels(Banner[][] models) {
		BannerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BannerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BannerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[] toSoapModels(List<Banner> models) {
		List<BannerSoap> soapModels = new ArrayList<BannerSoap>(models.size());

		for (Banner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BannerSoap[soapModels.size()]);
	}

	public BannerSoap() {
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

	public long getFileId() {
		return _fileId;
	}

	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	public String getFileLink() {
		return _fileLink;
	}

	public void setFileLink(String fileLink) {
		_fileLink = fileLink;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
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

	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;
	}

	public String getLienKet() {
		return _lienKet;
	}

	public void setLienKet(String lienKet) {
		_lienKet = lienKet;
	}

	public int getOrder_() {
		return _order_;
	}

	public void setOrder_(int order_) {
		_order_ = order_;
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

	private long _id;
	private String _ten;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private Date _ngayTao;
	private Date _ngaySua;
	private Date _ngayKetThuc;
	private String _lienKet;
	private int _order_;
	private boolean _trangThai;
	private String _nguoiTao;
	private long _nguoiTaoId;
	private String _nguoiSua;
	private long _nguoiSuaId;
	private long _companyId;
	private long _groupId;
}