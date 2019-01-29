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

package com.revotech.portal.vbpq.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LoaiVanBan}.
 * </p>
 *
 * @author ChucHV
 * @see LoaiVanBan
 * @generated
 */
public class LoaiVanBanWrapper implements LoaiVanBan, ModelWrapper<LoaiVanBan> {
	public LoaiVanBanWrapper(LoaiVanBan loaiVanBan) {
		_loaiVanBan = loaiVanBan;
	}

	@Override
	public Class<?> getModelClass() {
		return LoaiVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return LoaiVanBan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ten", getTen());
		attributes.put("trangThai", getTrangThai());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("groupId", getGroupId());
		attributes.put("order_", getOrder_());
		attributes.put("nhomVanBanId", getNhomVanBanId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Long nhomVanBanId = (Long)attributes.get("nhomVanBanId");

		if (nhomVanBanId != null) {
			setNhomVanBanId(nhomVanBanId);
		}
	}

	/**
	* Returns the primary key of this loai van ban.
	*
	* @return the primary key of this loai van ban
	*/
	@Override
	public long getPrimaryKey() {
		return _loaiVanBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loai van ban.
	*
	* @param primaryKey the primary key of this loai van ban
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loaiVanBan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this loai van ban.
	*
	* @return the ID of this loai van ban
	*/
	@Override
	public long getId() {
		return _loaiVanBan.getId();
	}

	/**
	* Sets the ID of this loai van ban.
	*
	* @param id the ID of this loai van ban
	*/
	@Override
	public void setId(long id) {
		_loaiVanBan.setId(id);
	}

	/**
	* Returns the ten of this loai van ban.
	*
	* @return the ten of this loai van ban
	*/
	@Override
	public java.lang.String getTen() {
		return _loaiVanBan.getTen();
	}

	/**
	* Sets the ten of this loai van ban.
	*
	* @param ten the ten of this loai van ban
	*/
	@Override
	public void setTen(java.lang.String ten) {
		_loaiVanBan.setTen(ten);
	}

	/**
	* Returns the trang thai of this loai van ban.
	*
	* @return the trang thai of this loai van ban
	*/
	@Override
	public boolean getTrangThai() {
		return _loaiVanBan.getTrangThai();
	}

	/**
	* Returns <code>true</code> if this loai van ban is trang thai.
	*
	* @return <code>true</code> if this loai van ban is trang thai; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrangThai() {
		return _loaiVanBan.isTrangThai();
	}

	/**
	* Sets whether this loai van ban is trang thai.
	*
	* @param trangThai the trang thai of this loai van ban
	*/
	@Override
	public void setTrangThai(boolean trangThai) {
		_loaiVanBan.setTrangThai(trangThai);
	}

	/**
	* Returns the ngay tao of this loai van ban.
	*
	* @return the ngay tao of this loai van ban
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _loaiVanBan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this loai van ban.
	*
	* @param ngayTao the ngay tao of this loai van ban
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_loaiVanBan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this loai van ban.
	*
	* @return the ngay sua of this loai van ban
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _loaiVanBan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this loai van ban.
	*
	* @param ngaySua the ngay sua of this loai van ban
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_loaiVanBan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this loai van ban.
	*
	* @return the nguoi tao of this loai van ban
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _loaiVanBan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this loai van ban.
	*
	* @param nguoiTao the nguoi tao of this loai van ban
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_loaiVanBan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this loai van ban.
	*
	* @return the nguoi sua of this loai van ban
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _loaiVanBan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this loai van ban.
	*
	* @param nguoiSua the nguoi sua of this loai van ban
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_loaiVanBan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the group ID of this loai van ban.
	*
	* @return the group ID of this loai van ban
	*/
	@Override
	public long getGroupId() {
		return _loaiVanBan.getGroupId();
	}

	/**
	* Sets the group ID of this loai van ban.
	*
	* @param groupId the group ID of this loai van ban
	*/
	@Override
	public void setGroupId(long groupId) {
		_loaiVanBan.setGroupId(groupId);
	}

	/**
	* Returns the order_ of this loai van ban.
	*
	* @return the order_ of this loai van ban
	*/
	@Override
	public int getOrder_() {
		return _loaiVanBan.getOrder_();
	}

	/**
	* Sets the order_ of this loai van ban.
	*
	* @param order_ the order_ of this loai van ban
	*/
	@Override
	public void setOrder_(int order_) {
		_loaiVanBan.setOrder_(order_);
	}

	/**
	* Returns the nhom van ban ID of this loai van ban.
	*
	* @return the nhom van ban ID of this loai van ban
	*/
	@Override
	public long getNhomVanBanId() {
		return _loaiVanBan.getNhomVanBanId();
	}

	/**
	* Sets the nhom van ban ID of this loai van ban.
	*
	* @param nhomVanBanId the nhom van ban ID of this loai van ban
	*/
	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_loaiVanBan.setNhomVanBanId(nhomVanBanId);
	}

	@Override
	public boolean isNew() {
		return _loaiVanBan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_loaiVanBan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _loaiVanBan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loaiVanBan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _loaiVanBan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _loaiVanBan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loaiVanBan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loaiVanBan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_loaiVanBan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_loaiVanBan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loaiVanBan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LoaiVanBanWrapper((LoaiVanBan)_loaiVanBan.clone());
	}

	@Override
	public int compareTo(com.revotech.portal.vbpq.model.LoaiVanBan loaiVanBan) {
		return _loaiVanBan.compareTo(loaiVanBan);
	}

	@Override
	public int hashCode() {
		return _loaiVanBan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.vbpq.model.LoaiVanBan> toCacheModel() {
		return _loaiVanBan.toCacheModel();
	}

	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan toEscapedModel() {
		return new LoaiVanBanWrapper(_loaiVanBan.toEscapedModel());
	}

	@Override
	public com.revotech.portal.vbpq.model.LoaiVanBan toUnescapedModel() {
		return new LoaiVanBanWrapper(_loaiVanBan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loaiVanBan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loaiVanBan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loaiVanBan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoaiVanBanWrapper)) {
			return false;
		}

		LoaiVanBanWrapper loaiVanBanWrapper = (LoaiVanBanWrapper)obj;

		if (Validator.equals(_loaiVanBan, loaiVanBanWrapper._loaiVanBan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LoaiVanBan getWrappedLoaiVanBan() {
		return _loaiVanBan;
	}

	@Override
	public LoaiVanBan getWrappedModel() {
		return _loaiVanBan;
	}

	@Override
	public void resetOriginalValues() {
		_loaiVanBan.resetOriginalValues();
	}

	private LoaiVanBan _loaiVanBan;
}