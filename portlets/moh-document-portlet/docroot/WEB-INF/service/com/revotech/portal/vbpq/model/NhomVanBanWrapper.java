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
 * This class is a wrapper for {@link NhomVanBan}.
 * </p>
 *
 * @author ChucHV
 * @see NhomVanBan
 * @generated
 */
public class NhomVanBanWrapper implements NhomVanBan, ModelWrapper<NhomVanBan> {
	public NhomVanBanWrapper(NhomVanBan nhomVanBan) {
		_nhomVanBan = nhomVanBan;
	}

	@Override
	public Class<?> getModelClass() {
		return NhomVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return NhomVanBan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tenNhom", getTenNhom());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiTaoId", getNguoiTaoId());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("nguoiSuaId", getNguoiSuaId());
		attributes.put("trangThai", getTrangThai());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tenNhom = (String)attributes.get("tenNhom");

		if (tenNhom != null) {
			setTenNhom(tenNhom);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		Long nguoiTaoId = (Long)attributes.get("nguoiTaoId");

		if (nguoiTaoId != null) {
			setNguoiTaoId(nguoiTaoId);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long nguoiSuaId = (Long)attributes.get("nguoiSuaId");

		if (nguoiSuaId != null) {
			setNguoiSuaId(nguoiSuaId);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this nhom van ban.
	*
	* @return the primary key of this nhom van ban
	*/
	@Override
	public long getPrimaryKey() {
		return _nhomVanBan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nhom van ban.
	*
	* @param primaryKey the primary key of this nhom van ban
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nhomVanBan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nhom van ban.
	*
	* @return the ID of this nhom van ban
	*/
	@Override
	public long getId() {
		return _nhomVanBan.getId();
	}

	/**
	* Sets the ID of this nhom van ban.
	*
	* @param id the ID of this nhom van ban
	*/
	@Override
	public void setId(long id) {
		_nhomVanBan.setId(id);
	}

	/**
	* Returns the ten nhom of this nhom van ban.
	*
	* @return the ten nhom of this nhom van ban
	*/
	@Override
	public java.lang.String getTenNhom() {
		return _nhomVanBan.getTenNhom();
	}

	/**
	* Sets the ten nhom of this nhom van ban.
	*
	* @param tenNhom the ten nhom of this nhom van ban
	*/
	@Override
	public void setTenNhom(java.lang.String tenNhom) {
		_nhomVanBan.setTenNhom(tenNhom);
	}

	/**
	* Returns the nguoi tao of this nhom van ban.
	*
	* @return the nguoi tao of this nhom van ban
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _nhomVanBan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nhom van ban.
	*
	* @param nguoiTao the nguoi tao of this nhom van ban
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_nhomVanBan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi tao ID of this nhom van ban.
	*
	* @return the nguoi tao ID of this nhom van ban
	*/
	@Override
	public long getNguoiTaoId() {
		return _nhomVanBan.getNguoiTaoId();
	}

	/**
	* Sets the nguoi tao ID of this nhom van ban.
	*
	* @param nguoiTaoId the nguoi tao ID of this nhom van ban
	*/
	@Override
	public void setNguoiTaoId(long nguoiTaoId) {
		_nhomVanBan.setNguoiTaoId(nguoiTaoId);
	}

	/**
	* Returns the ngay tao of this nhom van ban.
	*
	* @return the ngay tao of this nhom van ban
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _nhomVanBan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nhom van ban.
	*
	* @param ngayTao the ngay tao of this nhom van ban
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_nhomVanBan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this nhom van ban.
	*
	* @return the ngay sua of this nhom van ban
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _nhomVanBan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this nhom van ban.
	*
	* @param ngaySua the ngay sua of this nhom van ban
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_nhomVanBan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this nhom van ban.
	*
	* @return the nguoi sua of this nhom van ban
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _nhomVanBan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this nhom van ban.
	*
	* @param nguoiSua the nguoi sua of this nhom van ban
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_nhomVanBan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nguoi sua ID of this nhom van ban.
	*
	* @return the nguoi sua ID of this nhom van ban
	*/
	@Override
	public long getNguoiSuaId() {
		return _nhomVanBan.getNguoiSuaId();
	}

	/**
	* Sets the nguoi sua ID of this nhom van ban.
	*
	* @param nguoiSuaId the nguoi sua ID of this nhom van ban
	*/
	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_nhomVanBan.setNguoiSuaId(nguoiSuaId);
	}

	/**
	* Returns the trang thai of this nhom van ban.
	*
	* @return the trang thai of this nhom van ban
	*/
	@Override
	public int getTrangThai() {
		return _nhomVanBan.getTrangThai();
	}

	/**
	* Sets the trang thai of this nhom van ban.
	*
	* @param trangThai the trang thai of this nhom van ban
	*/
	@Override
	public void setTrangThai(int trangThai) {
		_nhomVanBan.setTrangThai(trangThai);
	}

	/**
	* Returns the group ID of this nhom van ban.
	*
	* @return the group ID of this nhom van ban
	*/
	@Override
	public long getGroupId() {
		return _nhomVanBan.getGroupId();
	}

	/**
	* Sets the group ID of this nhom van ban.
	*
	* @param groupId the group ID of this nhom van ban
	*/
	@Override
	public void setGroupId(long groupId) {
		_nhomVanBan.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _nhomVanBan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nhomVanBan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nhomVanBan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nhomVanBan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nhomVanBan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nhomVanBan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nhomVanBan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nhomVanBan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nhomVanBan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nhomVanBan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nhomVanBan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NhomVanBanWrapper((NhomVanBan)_nhomVanBan.clone());
	}

	@Override
	public int compareTo(com.revotech.portal.vbpq.model.NhomVanBan nhomVanBan) {
		return _nhomVanBan.compareTo(nhomVanBan);
	}

	@Override
	public int hashCode() {
		return _nhomVanBan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.vbpq.model.NhomVanBan> toCacheModel() {
		return _nhomVanBan.toCacheModel();
	}

	@Override
	public com.revotech.portal.vbpq.model.NhomVanBan toEscapedModel() {
		return new NhomVanBanWrapper(_nhomVanBan.toEscapedModel());
	}

	@Override
	public com.revotech.portal.vbpq.model.NhomVanBan toUnescapedModel() {
		return new NhomVanBanWrapper(_nhomVanBan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nhomVanBan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nhomVanBan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nhomVanBan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NhomVanBanWrapper)) {
			return false;
		}

		NhomVanBanWrapper nhomVanBanWrapper = (NhomVanBanWrapper)obj;

		if (Validator.equals(_nhomVanBan, nhomVanBanWrapper._nhomVanBan)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NhomVanBan getWrappedNhomVanBan() {
		return _nhomVanBan;
	}

	@Override
	public NhomVanBan getWrappedModel() {
		return _nhomVanBan;
	}

	@Override
	public void resetOriginalValues() {
		_nhomVanBan.resetOriginalValues();
	}

	private NhomVanBan _nhomVanBan;
}