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
 * This class is a wrapper for {@link VanBanPhapQuy}.
 * </p>
 *
 * @author ChucHV
 * @see VanBanPhapQuy
 * @generated
 */
public class VanBanPhapQuyWrapper implements VanBanPhapQuy,
	ModelWrapper<VanBanPhapQuy> {
	public VanBanPhapQuyWrapper(VanBanPhapQuy vanBanPhapQuy) {
		_vanBanPhapQuy = vanBanPhapQuy;
	}

	@Override
	public Class<?> getModelClass() {
		return VanBanPhapQuy.class;
	}

	@Override
	public String getModelClassName() {
		return VanBanPhapQuy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("maVanBan", getMaVanBan());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("trichYeu", getTrichYeu());
		attributes.put("coQuanBanHanh", getCoQuanBanHanh());
		attributes.put("loaiVanBan", getLoaiVanBan());
		attributes.put("linhVucVanBan", getLinhVucVanBan());
		attributes.put("ngayBanHanh", getNgayBanHanh());
		attributes.put("ngayCoHieuLuc", getNgayCoHieuLuc());
		attributes.put("ngayHetHieuLuc", getNgayHetHieuLuc());
		attributes.put("nguoiKy", getNguoiKy());
		attributes.put("vanBanThayThe", getVanBanThayThe());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByDate", getStatusByDate());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("nhomVanBanId", getNhomVanBanId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String maVanBan = (String)attributes.get("maVanBan");

		if (maVanBan != null) {
			setMaVanBan(maVanBan);
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

		String trichYeu = (String)attributes.get("trichYeu");

		if (trichYeu != null) {
			setTrichYeu(trichYeu);
		}

		Long coQuanBanHanh = (Long)attributes.get("coQuanBanHanh");

		if (coQuanBanHanh != null) {
			setCoQuanBanHanh(coQuanBanHanh);
		}

		Long loaiVanBan = (Long)attributes.get("loaiVanBan");

		if (loaiVanBan != null) {
			setLoaiVanBan(loaiVanBan);
		}

		Long linhVucVanBan = (Long)attributes.get("linhVucVanBan");

		if (linhVucVanBan != null) {
			setLinhVucVanBan(linhVucVanBan);
		}

		Date ngayBanHanh = (Date)attributes.get("ngayBanHanh");

		if (ngayBanHanh != null) {
			setNgayBanHanh(ngayBanHanh);
		}

		Date ngayCoHieuLuc = (Date)attributes.get("ngayCoHieuLuc");

		if (ngayCoHieuLuc != null) {
			setNgayCoHieuLuc(ngayCoHieuLuc);
		}

		Date ngayHetHieuLuc = (Date)attributes.get("ngayHetHieuLuc");

		if (ngayHetHieuLuc != null) {
			setNgayHetHieuLuc(ngayHetHieuLuc);
		}

		String nguoiKy = (String)attributes.get("nguoiKy");

		if (nguoiKy != null) {
			setNguoiKy(nguoiKy);
		}

		Long vanBanThayThe = (Long)attributes.get("vanBanThayThe");

		if (vanBanThayThe != null) {
			setVanBanThayThe(vanBanThayThe);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusByDate = (Date)attributes.get("statusByDate");

		if (statusByDate != null) {
			setStatusByDate(statusByDate);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Long nhomVanBanId = (Long)attributes.get("nhomVanBanId");

		if (nhomVanBanId != null) {
			setNhomVanBanId(nhomVanBanId);
		}
	}

	/**
	* Returns the primary key of this van ban phap quy.
	*
	* @return the primary key of this van ban phap quy
	*/
	@Override
	public long getPrimaryKey() {
		return _vanBanPhapQuy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this van ban phap quy.
	*
	* @param primaryKey the primary key of this van ban phap quy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vanBanPhapQuy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this van ban phap quy.
	*
	* @return the ID of this van ban phap quy
	*/
	@Override
	public long getId() {
		return _vanBanPhapQuy.getId();
	}

	/**
	* Sets the ID of this van ban phap quy.
	*
	* @param id the ID of this van ban phap quy
	*/
	@Override
	public void setId(long id) {
		_vanBanPhapQuy.setId(id);
	}

	/**
	* Returns the ma van ban of this van ban phap quy.
	*
	* @return the ma van ban of this van ban phap quy
	*/
	@Override
	public java.lang.String getMaVanBan() {
		return _vanBanPhapQuy.getMaVanBan();
	}

	/**
	* Sets the ma van ban of this van ban phap quy.
	*
	* @param maVanBan the ma van ban of this van ban phap quy
	*/
	@Override
	public void setMaVanBan(java.lang.String maVanBan) {
		_vanBanPhapQuy.setMaVanBan(maVanBan);
	}

	/**
	* Returns the ngay tao of this van ban phap quy.
	*
	* @return the ngay tao of this van ban phap quy
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _vanBanPhapQuy.getNgayTao();
	}

	/**
	* Sets the ngay tao of this van ban phap quy.
	*
	* @param ngayTao the ngay tao of this van ban phap quy
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_vanBanPhapQuy.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this van ban phap quy.
	*
	* @return the ngay sua of this van ban phap quy
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _vanBanPhapQuy.getNgaySua();
	}

	/**
	* Sets the ngay sua of this van ban phap quy.
	*
	* @param ngaySua the ngay sua of this van ban phap quy
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_vanBanPhapQuy.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this van ban phap quy.
	*
	* @return the nguoi tao of this van ban phap quy
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _vanBanPhapQuy.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this van ban phap quy.
	*
	* @param nguoiTao the nguoi tao of this van ban phap quy
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_vanBanPhapQuy.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this van ban phap quy.
	*
	* @return the nguoi sua of this van ban phap quy
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _vanBanPhapQuy.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this van ban phap quy.
	*
	* @param nguoiSua the nguoi sua of this van ban phap quy
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_vanBanPhapQuy.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the trich yeu of this van ban phap quy.
	*
	* @return the trich yeu of this van ban phap quy
	*/
	@Override
	public java.lang.String getTrichYeu() {
		return _vanBanPhapQuy.getTrichYeu();
	}

	/**
	* Sets the trich yeu of this van ban phap quy.
	*
	* @param trichYeu the trich yeu of this van ban phap quy
	*/
	@Override
	public void setTrichYeu(java.lang.String trichYeu) {
		_vanBanPhapQuy.setTrichYeu(trichYeu);
	}

	/**
	* Returns the co quan ban hanh of this van ban phap quy.
	*
	* @return the co quan ban hanh of this van ban phap quy
	*/
	@Override
	public long getCoQuanBanHanh() {
		return _vanBanPhapQuy.getCoQuanBanHanh();
	}

	/**
	* Sets the co quan ban hanh of this van ban phap quy.
	*
	* @param coQuanBanHanh the co quan ban hanh of this van ban phap quy
	*/
	@Override
	public void setCoQuanBanHanh(long coQuanBanHanh) {
		_vanBanPhapQuy.setCoQuanBanHanh(coQuanBanHanh);
	}

	/**
	* Returns the loai van ban of this van ban phap quy.
	*
	* @return the loai van ban of this van ban phap quy
	*/
	@Override
	public long getLoaiVanBan() {
		return _vanBanPhapQuy.getLoaiVanBan();
	}

	/**
	* Sets the loai van ban of this van ban phap quy.
	*
	* @param loaiVanBan the loai van ban of this van ban phap quy
	*/
	@Override
	public void setLoaiVanBan(long loaiVanBan) {
		_vanBanPhapQuy.setLoaiVanBan(loaiVanBan);
	}

	/**
	* Returns the linh vuc van ban of this van ban phap quy.
	*
	* @return the linh vuc van ban of this van ban phap quy
	*/
	@Override
	public long getLinhVucVanBan() {
		return _vanBanPhapQuy.getLinhVucVanBan();
	}

	/**
	* Sets the linh vuc van ban of this van ban phap quy.
	*
	* @param linhVucVanBan the linh vuc van ban of this van ban phap quy
	*/
	@Override
	public void setLinhVucVanBan(long linhVucVanBan) {
		_vanBanPhapQuy.setLinhVucVanBan(linhVucVanBan);
	}

	/**
	* Returns the ngay ban hanh of this van ban phap quy.
	*
	* @return the ngay ban hanh of this van ban phap quy
	*/
	@Override
	public java.util.Date getNgayBanHanh() {
		return _vanBanPhapQuy.getNgayBanHanh();
	}

	/**
	* Sets the ngay ban hanh of this van ban phap quy.
	*
	* @param ngayBanHanh the ngay ban hanh of this van ban phap quy
	*/
	@Override
	public void setNgayBanHanh(java.util.Date ngayBanHanh) {
		_vanBanPhapQuy.setNgayBanHanh(ngayBanHanh);
	}

	/**
	* Returns the ngay co hieu luc of this van ban phap quy.
	*
	* @return the ngay co hieu luc of this van ban phap quy
	*/
	@Override
	public java.util.Date getNgayCoHieuLuc() {
		return _vanBanPhapQuy.getNgayCoHieuLuc();
	}

	/**
	* Sets the ngay co hieu luc of this van ban phap quy.
	*
	* @param ngayCoHieuLuc the ngay co hieu luc of this van ban phap quy
	*/
	@Override
	public void setNgayCoHieuLuc(java.util.Date ngayCoHieuLuc) {
		_vanBanPhapQuy.setNgayCoHieuLuc(ngayCoHieuLuc);
	}

	/**
	* Returns the ngay het hieu luc of this van ban phap quy.
	*
	* @return the ngay het hieu luc of this van ban phap quy
	*/
	@Override
	public java.util.Date getNgayHetHieuLuc() {
		return _vanBanPhapQuy.getNgayHetHieuLuc();
	}

	/**
	* Sets the ngay het hieu luc of this van ban phap quy.
	*
	* @param ngayHetHieuLuc the ngay het hieu luc of this van ban phap quy
	*/
	@Override
	public void setNgayHetHieuLuc(java.util.Date ngayHetHieuLuc) {
		_vanBanPhapQuy.setNgayHetHieuLuc(ngayHetHieuLuc);
	}

	/**
	* Returns the nguoi ky of this van ban phap quy.
	*
	* @return the nguoi ky of this van ban phap quy
	*/
	@Override
	public java.lang.String getNguoiKy() {
		return _vanBanPhapQuy.getNguoiKy();
	}

	/**
	* Sets the nguoi ky of this van ban phap quy.
	*
	* @param nguoiKy the nguoi ky of this van ban phap quy
	*/
	@Override
	public void setNguoiKy(java.lang.String nguoiKy) {
		_vanBanPhapQuy.setNguoiKy(nguoiKy);
	}

	/**
	* Returns the van ban thay the of this van ban phap quy.
	*
	* @return the van ban thay the of this van ban phap quy
	*/
	@Override
	public long getVanBanThayThe() {
		return _vanBanPhapQuy.getVanBanThayThe();
	}

	/**
	* Sets the van ban thay the of this van ban phap quy.
	*
	* @param vanBanThayThe the van ban thay the of this van ban phap quy
	*/
	@Override
	public void setVanBanThayThe(long vanBanThayThe) {
		_vanBanPhapQuy.setVanBanThayThe(vanBanThayThe);
	}

	/**
	* Returns the group ID of this van ban phap quy.
	*
	* @return the group ID of this van ban phap quy
	*/
	@Override
	public long getGroupId() {
		return _vanBanPhapQuy.getGroupId();
	}

	/**
	* Sets the group ID of this van ban phap quy.
	*
	* @param groupId the group ID of this van ban phap quy
	*/
	@Override
	public void setGroupId(long groupId) {
		_vanBanPhapQuy.setGroupId(groupId);
	}

	/**
	* Returns the status of this van ban phap quy.
	*
	* @return the status of this van ban phap quy
	*/
	@Override
	public int getStatus() {
		return _vanBanPhapQuy.getStatus();
	}

	/**
	* Sets the status of this van ban phap quy.
	*
	* @param status the status of this van ban phap quy
	*/
	@Override
	public void setStatus(int status) {
		_vanBanPhapQuy.setStatus(status);
	}

	/**
	* Returns the status by date of this van ban phap quy.
	*
	* @return the status by date of this van ban phap quy
	*/
	@Override
	public java.util.Date getStatusByDate() {
		return _vanBanPhapQuy.getStatusByDate();
	}

	/**
	* Sets the status by date of this van ban phap quy.
	*
	* @param statusByDate the status by date of this van ban phap quy
	*/
	@Override
	public void setStatusByDate(java.util.Date statusByDate) {
		_vanBanPhapQuy.setStatusByDate(statusByDate);
	}

	/**
	* Returns the status by user ID of this van ban phap quy.
	*
	* @return the status by user ID of this van ban phap quy
	*/
	@Override
	public long getStatusByUserId() {
		return _vanBanPhapQuy.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this van ban phap quy.
	*
	* @param statusByUserId the status by user ID of this van ban phap quy
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_vanBanPhapQuy.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this van ban phap quy.
	*
	* @return the status by user uuid of this van ban phap quy
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vanBanPhapQuy.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this van ban phap quy.
	*
	* @param statusByUserUuid the status by user uuid of this van ban phap quy
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_vanBanPhapQuy.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this van ban phap quy.
	*
	* @return the status by user name of this van ban phap quy
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _vanBanPhapQuy.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this van ban phap quy.
	*
	* @param statusByUserName the status by user name of this van ban phap quy
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_vanBanPhapQuy.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the nhom van ban ID of this van ban phap quy.
	*
	* @return the nhom van ban ID of this van ban phap quy
	*/
	@Override
	public long getNhomVanBanId() {
		return _vanBanPhapQuy.getNhomVanBanId();
	}

	/**
	* Sets the nhom van ban ID of this van ban phap quy.
	*
	* @param nhomVanBanId the nhom van ban ID of this van ban phap quy
	*/
	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_vanBanPhapQuy.setNhomVanBanId(nhomVanBanId);
	}

	@Override
	public boolean isNew() {
		return _vanBanPhapQuy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vanBanPhapQuy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vanBanPhapQuy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vanBanPhapQuy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vanBanPhapQuy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vanBanPhapQuy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vanBanPhapQuy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vanBanPhapQuy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vanBanPhapQuy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vanBanPhapQuy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vanBanPhapQuy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VanBanPhapQuyWrapper((VanBanPhapQuy)_vanBanPhapQuy.clone());
	}

	@Override
	public int compareTo(
		com.revotech.portal.vbpq.model.VanBanPhapQuy vanBanPhapQuy) {
		return _vanBanPhapQuy.compareTo(vanBanPhapQuy);
	}

	@Override
	public int hashCode() {
		return _vanBanPhapQuy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.vbpq.model.VanBanPhapQuy> toCacheModel() {
		return _vanBanPhapQuy.toCacheModel();
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy toEscapedModel() {
		return new VanBanPhapQuyWrapper(_vanBanPhapQuy.toEscapedModel());
	}

	@Override
	public com.revotech.portal.vbpq.model.VanBanPhapQuy toUnescapedModel() {
		return new VanBanPhapQuyWrapper(_vanBanPhapQuy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vanBanPhapQuy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vanBanPhapQuy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vanBanPhapQuy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VanBanPhapQuyWrapper)) {
			return false;
		}

		VanBanPhapQuyWrapper vanBanPhapQuyWrapper = (VanBanPhapQuyWrapper)obj;

		if (Validator.equals(_vanBanPhapQuy, vanBanPhapQuyWrapper._vanBanPhapQuy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VanBanPhapQuy getWrappedVanBanPhapQuy() {
		return _vanBanPhapQuy;
	}

	@Override
	public VanBanPhapQuy getWrappedModel() {
		return _vanBanPhapQuy;
	}

	@Override
	public void resetOriginalValues() {
		_vanBanPhapQuy.resetOriginalValues();
	}

	private VanBanPhapQuy _vanBanPhapQuy;
}