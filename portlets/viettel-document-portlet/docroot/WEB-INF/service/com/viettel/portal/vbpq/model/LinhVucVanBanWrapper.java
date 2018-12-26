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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LinhVucVanBan}.
 * </p>
 *
 * @author ChucHV
 * @see LinhVucVanBan
 * @generated
 */
public class LinhVucVanBanWrapper implements LinhVucVanBan,
	ModelWrapper<LinhVucVanBan> {
	public LinhVucVanBanWrapper(LinhVucVanBan linhVucVanBan) {
		_linhVucVanBan = linhVucVanBan;
	}

	@Override
	public Class<?> getModelClass() {
		return LinhVucVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return LinhVucVanBan.class.getName();
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
	* Returns the primary key of this linh vuc van ban.
	*
	* @return the primary key of this linh vuc van ban
	*/
	@Override
	public long getPrimaryKey() {
		return _linhVucVanBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this linh vuc van ban.
	*
	* @param primaryKey the primary key of this linh vuc van ban
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_linhVucVanBan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this linh vuc van ban.
	*
	* @return the ID of this linh vuc van ban
	*/
	@Override
	public long getId() {
		return _linhVucVanBan.getId();
	}

	/**
	* Sets the ID of this linh vuc van ban.
	*
	* @param id the ID of this linh vuc van ban
	*/
	@Override
	public void setId(long id) {
		_linhVucVanBan.setId(id);
	}

	/**
	* Returns the ten of this linh vuc van ban.
	*
	* @return the ten of this linh vuc van ban
	*/
	@Override
	public java.lang.String getTen() {
		return _linhVucVanBan.getTen();
	}

	/**
	* Sets the ten of this linh vuc van ban.
	*
	* @param ten the ten of this linh vuc van ban
	*/
	@Override
	public void setTen(java.lang.String ten) {
		_linhVucVanBan.setTen(ten);
	}

	/**
	* Returns the trang thai of this linh vuc van ban.
	*
	* @return the trang thai of this linh vuc van ban
	*/
	@Override
	public boolean getTrangThai() {
		return _linhVucVanBan.getTrangThai();
	}

	/**
	* Returns <code>true</code> if this linh vuc van ban is trang thai.
	*
	* @return <code>true</code> if this linh vuc van ban is trang thai; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrangThai() {
		return _linhVucVanBan.isTrangThai();
	}

	/**
	* Sets whether this linh vuc van ban is trang thai.
	*
	* @param trangThai the trang thai of this linh vuc van ban
	*/
	@Override
	public void setTrangThai(boolean trangThai) {
		_linhVucVanBan.setTrangThai(trangThai);
	}

	/**
	* Returns the ngay tao of this linh vuc van ban.
	*
	* @return the ngay tao of this linh vuc van ban
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _linhVucVanBan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this linh vuc van ban.
	*
	* @param ngayTao the ngay tao of this linh vuc van ban
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_linhVucVanBan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this linh vuc van ban.
	*
	* @return the ngay sua of this linh vuc van ban
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _linhVucVanBan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this linh vuc van ban.
	*
	* @param ngaySua the ngay sua of this linh vuc van ban
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_linhVucVanBan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this linh vuc van ban.
	*
	* @return the nguoi tao of this linh vuc van ban
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _linhVucVanBan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this linh vuc van ban.
	*
	* @param nguoiTao the nguoi tao of this linh vuc van ban
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_linhVucVanBan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this linh vuc van ban.
	*
	* @return the nguoi sua of this linh vuc van ban
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _linhVucVanBan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this linh vuc van ban.
	*
	* @param nguoiSua the nguoi sua of this linh vuc van ban
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_linhVucVanBan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the group ID of this linh vuc van ban.
	*
	* @return the group ID of this linh vuc van ban
	*/
	@Override
	public long getGroupId() {
		return _linhVucVanBan.getGroupId();
	}

	/**
	* Sets the group ID of this linh vuc van ban.
	*
	* @param groupId the group ID of this linh vuc van ban
	*/
	@Override
	public void setGroupId(long groupId) {
		_linhVucVanBan.setGroupId(groupId);
	}

	/**
	* Returns the order_ of this linh vuc van ban.
	*
	* @return the order_ of this linh vuc van ban
	*/
	@Override
	public int getOrder_() {
		return _linhVucVanBan.getOrder_();
	}

	/**
	* Sets the order_ of this linh vuc van ban.
	*
	* @param order_ the order_ of this linh vuc van ban
	*/
	@Override
	public void setOrder_(int order_) {
		_linhVucVanBan.setOrder_(order_);
	}

	/**
	* Returns the nhom van ban ID of this linh vuc van ban.
	*
	* @return the nhom van ban ID of this linh vuc van ban
	*/
	@Override
	public long getNhomVanBanId() {
		return _linhVucVanBan.getNhomVanBanId();
	}

	/**
	* Sets the nhom van ban ID of this linh vuc van ban.
	*
	* @param nhomVanBanId the nhom van ban ID of this linh vuc van ban
	*/
	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_linhVucVanBan.setNhomVanBanId(nhomVanBanId);
	}

	@Override
	public boolean isNew() {
		return _linhVucVanBan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_linhVucVanBan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _linhVucVanBan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_linhVucVanBan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _linhVucVanBan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _linhVucVanBan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_linhVucVanBan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _linhVucVanBan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_linhVucVanBan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_linhVucVanBan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_linhVucVanBan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinhVucVanBanWrapper((LinhVucVanBan)_linhVucVanBan.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vbpq.model.LinhVucVanBan linhVucVanBan) {
		return _linhVucVanBan.compareTo(linhVucVanBan);
	}

	@Override
	public int hashCode() {
		return _linhVucVanBan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vbpq.model.LinhVucVanBan> toCacheModel() {
		return _linhVucVanBan.toCacheModel();
	}

	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan toEscapedModel() {
		return new LinhVucVanBanWrapper(_linhVucVanBan.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vbpq.model.LinhVucVanBan toUnescapedModel() {
		return new LinhVucVanBanWrapper(_linhVucVanBan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _linhVucVanBan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _linhVucVanBan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_linhVucVanBan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinhVucVanBanWrapper)) {
			return false;
		}

		LinhVucVanBanWrapper linhVucVanBanWrapper = (LinhVucVanBanWrapper)obj;

		if (Validator.equals(_linhVucVanBan, linhVucVanBanWrapper._linhVucVanBan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LinhVucVanBan getWrappedLinhVucVanBan() {
		return _linhVucVanBan;
	}

	@Override
	public LinhVucVanBan getWrappedModel() {
		return _linhVucVanBan;
	}

	@Override
	public void resetOriginalValues() {
		_linhVucVanBan.resetOriginalValues();
	}

	private LinhVucVanBan _linhVucVanBan;
}