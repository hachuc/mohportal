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
 * This class is a wrapper for {@link CoQuanBanHanhVanBan}.
 * </p>
 *
 * @author ChucHV
 * @see CoQuanBanHanhVanBan
 * @generated
 */
public class CoQuanBanHanhVanBanWrapper implements CoQuanBanHanhVanBan,
	ModelWrapper<CoQuanBanHanhVanBan> {
	public CoQuanBanHanhVanBanWrapper(CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		_coQuanBanHanhVanBan = coQuanBanHanhVanBan;
	}

	@Override
	public Class<?> getModelClass() {
		return CoQuanBanHanhVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return CoQuanBanHanhVanBan.class.getName();
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
	* Returns the primary key of this co quan ban hanh van ban.
	*
	* @return the primary key of this co quan ban hanh van ban
	*/
	@Override
	public long getPrimaryKey() {
		return _coQuanBanHanhVanBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this co quan ban hanh van ban.
	*
	* @param primaryKey the primary key of this co quan ban hanh van ban
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_coQuanBanHanhVanBan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this co quan ban hanh van ban.
	*
	* @return the ID of this co quan ban hanh van ban
	*/
	@Override
	public long getId() {
		return _coQuanBanHanhVanBan.getId();
	}

	/**
	* Sets the ID of this co quan ban hanh van ban.
	*
	* @param id the ID of this co quan ban hanh van ban
	*/
	@Override
	public void setId(long id) {
		_coQuanBanHanhVanBan.setId(id);
	}

	/**
	* Returns the ten of this co quan ban hanh van ban.
	*
	* @return the ten of this co quan ban hanh van ban
	*/
	@Override
	public java.lang.String getTen() {
		return _coQuanBanHanhVanBan.getTen();
	}

	/**
	* Sets the ten of this co quan ban hanh van ban.
	*
	* @param ten the ten of this co quan ban hanh van ban
	*/
	@Override
	public void setTen(java.lang.String ten) {
		_coQuanBanHanhVanBan.setTen(ten);
	}

	/**
	* Returns the trang thai of this co quan ban hanh van ban.
	*
	* @return the trang thai of this co quan ban hanh van ban
	*/
	@Override
	public boolean getTrangThai() {
		return _coQuanBanHanhVanBan.getTrangThai();
	}

	/**
	* Returns <code>true</code> if this co quan ban hanh van ban is trang thai.
	*
	* @return <code>true</code> if this co quan ban hanh van ban is trang thai; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrangThai() {
		return _coQuanBanHanhVanBan.isTrangThai();
	}

	/**
	* Sets whether this co quan ban hanh van ban is trang thai.
	*
	* @param trangThai the trang thai of this co quan ban hanh van ban
	*/
	@Override
	public void setTrangThai(boolean trangThai) {
		_coQuanBanHanhVanBan.setTrangThai(trangThai);
	}

	/**
	* Returns the ngay tao of this co quan ban hanh van ban.
	*
	* @return the ngay tao of this co quan ban hanh van ban
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _coQuanBanHanhVanBan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this co quan ban hanh van ban.
	*
	* @param ngayTao the ngay tao of this co quan ban hanh van ban
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_coQuanBanHanhVanBan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this co quan ban hanh van ban.
	*
	* @return the ngay sua of this co quan ban hanh van ban
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _coQuanBanHanhVanBan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this co quan ban hanh van ban.
	*
	* @param ngaySua the ngay sua of this co quan ban hanh van ban
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_coQuanBanHanhVanBan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this co quan ban hanh van ban.
	*
	* @return the nguoi tao of this co quan ban hanh van ban
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _coQuanBanHanhVanBan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this co quan ban hanh van ban.
	*
	* @param nguoiTao the nguoi tao of this co quan ban hanh van ban
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_coQuanBanHanhVanBan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this co quan ban hanh van ban.
	*
	* @return the nguoi sua of this co quan ban hanh van ban
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _coQuanBanHanhVanBan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this co quan ban hanh van ban.
	*
	* @param nguoiSua the nguoi sua of this co quan ban hanh van ban
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_coQuanBanHanhVanBan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the group ID of this co quan ban hanh van ban.
	*
	* @return the group ID of this co quan ban hanh van ban
	*/
	@Override
	public long getGroupId() {
		return _coQuanBanHanhVanBan.getGroupId();
	}

	/**
	* Sets the group ID of this co quan ban hanh van ban.
	*
	* @param groupId the group ID of this co quan ban hanh van ban
	*/
	@Override
	public void setGroupId(long groupId) {
		_coQuanBanHanhVanBan.setGroupId(groupId);
	}

	/**
	* Returns the order_ of this co quan ban hanh van ban.
	*
	* @return the order_ of this co quan ban hanh van ban
	*/
	@Override
	public int getOrder_() {
		return _coQuanBanHanhVanBan.getOrder_();
	}

	/**
	* Sets the order_ of this co quan ban hanh van ban.
	*
	* @param order_ the order_ of this co quan ban hanh van ban
	*/
	@Override
	public void setOrder_(int order_) {
		_coQuanBanHanhVanBan.setOrder_(order_);
	}

	/**
	* Returns the nhom van ban ID of this co quan ban hanh van ban.
	*
	* @return the nhom van ban ID of this co quan ban hanh van ban
	*/
	@Override
	public long getNhomVanBanId() {
		return _coQuanBanHanhVanBan.getNhomVanBanId();
	}

	/**
	* Sets the nhom van ban ID of this co quan ban hanh van ban.
	*
	* @param nhomVanBanId the nhom van ban ID of this co quan ban hanh van ban
	*/
	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_coQuanBanHanhVanBan.setNhomVanBanId(nhomVanBanId);
	}

	@Override
	public boolean isNew() {
		return _coQuanBanHanhVanBan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_coQuanBanHanhVanBan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _coQuanBanHanhVanBan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coQuanBanHanhVanBan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _coQuanBanHanhVanBan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _coQuanBanHanhVanBan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coQuanBanHanhVanBan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coQuanBanHanhVanBan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_coQuanBanHanhVanBan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_coQuanBanHanhVanBan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coQuanBanHanhVanBan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CoQuanBanHanhVanBanWrapper((CoQuanBanHanhVanBan)_coQuanBanHanhVanBan.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan coQuanBanHanhVanBan) {
		return _coQuanBanHanhVanBan.compareTo(coQuanBanHanhVanBan);
	}

	@Override
	public int hashCode() {
		return _coQuanBanHanhVanBan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan> toCacheModel() {
		return _coQuanBanHanhVanBan.toCacheModel();
	}

	@Override
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan toEscapedModel() {
		return new CoQuanBanHanhVanBanWrapper(_coQuanBanHanhVanBan.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan toUnescapedModel() {
		return new CoQuanBanHanhVanBanWrapper(_coQuanBanHanhVanBan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coQuanBanHanhVanBan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coQuanBanHanhVanBan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coQuanBanHanhVanBan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoQuanBanHanhVanBanWrapper)) {
			return false;
		}

		CoQuanBanHanhVanBanWrapper coQuanBanHanhVanBanWrapper = (CoQuanBanHanhVanBanWrapper)obj;

		if (Validator.equals(_coQuanBanHanhVanBan,
					coQuanBanHanhVanBanWrapper._coQuanBanHanhVanBan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CoQuanBanHanhVanBan getWrappedCoQuanBanHanhVanBan() {
		return _coQuanBanHanhVanBan;
	}

	@Override
	public CoQuanBanHanhVanBan getWrappedModel() {
		return _coQuanBanHanhVanBan;
	}

	@Override
	public void resetOriginalValues() {
		_coQuanBanHanhVanBan.resetOriginalValues();
	}

	private CoQuanBanHanhVanBan _coQuanBanHanhVanBan;
}