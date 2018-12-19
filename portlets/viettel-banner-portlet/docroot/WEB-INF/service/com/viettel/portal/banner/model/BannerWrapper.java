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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Banner}.
 * </p>
 *
 * @author ChucHV
 * @see Banner
 * @generated
 */
public class BannerWrapper implements Banner, ModelWrapper<Banner> {
	public BannerWrapper(Banner banner) {
		_banner = banner;
	}

	@Override
	public Class<?> getModelClass() {
		return Banner.class;
	}

	@Override
	public String getModelClassName() {
		return Banner.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ten", getTen());
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("lienKet", getLienKet());
		attributes.put("order_", getOrder_());
		attributes.put("trangThai", getTrangThai());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiTaoId", getNguoiTaoId());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("nguoiSuaId", getNguoiSuaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileLink = (String)attributes.get("fileLink");

		if (fileLink != null) {
			setFileLink(fileLink);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		String lienKet = (String)attributes.get("lienKet");

		if (lienKet != null) {
			setLienKet(lienKet);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		Long nguoiTaoId = (Long)attributes.get("nguoiTaoId");

		if (nguoiTaoId != null) {
			setNguoiTaoId(nguoiTaoId);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long nguoiSuaId = (Long)attributes.get("nguoiSuaId");

		if (nguoiSuaId != null) {
			setNguoiSuaId(nguoiSuaId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this banner.
	*
	* @return the primary key of this banner
	*/
	@Override
	public long getPrimaryKey() {
		return _banner.getPrimaryKey();
	}

	/**
	* Sets the primary key of this banner.
	*
	* @param primaryKey the primary key of this banner
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_banner.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this banner.
	*
	* @return the ID of this banner
	*/
	@Override
	public long getId() {
		return _banner.getId();
	}

	/**
	* Sets the ID of this banner.
	*
	* @param id the ID of this banner
	*/
	@Override
	public void setId(long id) {
		_banner.setId(id);
	}

	/**
	* Returns the ten of this banner.
	*
	* @return the ten of this banner
	*/
	@Override
	public java.lang.String getTen() {
		return _banner.getTen();
	}

	/**
	* Sets the ten of this banner.
	*
	* @param ten the ten of this banner
	*/
	@Override
	public void setTen(java.lang.String ten) {
		_banner.setTen(ten);
	}

	/**
	* Returns the file ID of this banner.
	*
	* @return the file ID of this banner
	*/
	@Override
	public long getFileId() {
		return _banner.getFileId();
	}

	/**
	* Sets the file ID of this banner.
	*
	* @param fileId the file ID of this banner
	*/
	@Override
	public void setFileId(long fileId) {
		_banner.setFileId(fileId);
	}

	/**
	* Returns the file link of this banner.
	*
	* @return the file link of this banner
	*/
	@Override
	public java.lang.String getFileLink() {
		return _banner.getFileLink();
	}

	/**
	* Sets the file link of this banner.
	*
	* @param fileLink the file link of this banner
	*/
	@Override
	public void setFileLink(java.lang.String fileLink) {
		_banner.setFileLink(fileLink);
	}

	/**
	* Returns the file name of this banner.
	*
	* @return the file name of this banner
	*/
	@Override
	public java.lang.String getFileName() {
		return _banner.getFileName();
	}

	/**
	* Sets the file name of this banner.
	*
	* @param fileName the file name of this banner
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_banner.setFileName(fileName);
	}

	/**
	* Returns the file size of this banner.
	*
	* @return the file size of this banner
	*/
	@Override
	public java.lang.String getFileSize() {
		return _banner.getFileSize();
	}

	/**
	* Sets the file size of this banner.
	*
	* @param fileSize the file size of this banner
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_banner.setFileSize(fileSize);
	}

	/**
	* Returns the ngay tao of this banner.
	*
	* @return the ngay tao of this banner
	*/
	@Override
	public java.util.Date getNgayTao() {
		return _banner.getNgayTao();
	}

	/**
	* Sets the ngay tao of this banner.
	*
	* @param ngayTao the ngay tao of this banner
	*/
	@Override
	public void setNgayTao(java.util.Date ngayTao) {
		_banner.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this banner.
	*
	* @return the ngay sua of this banner
	*/
	@Override
	public java.util.Date getNgaySua() {
		return _banner.getNgaySua();
	}

	/**
	* Sets the ngay sua of this banner.
	*
	* @param ngaySua the ngay sua of this banner
	*/
	@Override
	public void setNgaySua(java.util.Date ngaySua) {
		_banner.setNgaySua(ngaySua);
	}

	/**
	* Returns the ngay ket thuc of this banner.
	*
	* @return the ngay ket thuc of this banner
	*/
	@Override
	public java.util.Date getNgayKetThuc() {
		return _banner.getNgayKetThuc();
	}

	/**
	* Sets the ngay ket thuc of this banner.
	*
	* @param ngayKetThuc the ngay ket thuc of this banner
	*/
	@Override
	public void setNgayKetThuc(java.util.Date ngayKetThuc) {
		_banner.setNgayKetThuc(ngayKetThuc);
	}

	/**
	* Returns the lien ket of this banner.
	*
	* @return the lien ket of this banner
	*/
	@Override
	public java.lang.String getLienKet() {
		return _banner.getLienKet();
	}

	/**
	* Sets the lien ket of this banner.
	*
	* @param lienKet the lien ket of this banner
	*/
	@Override
	public void setLienKet(java.lang.String lienKet) {
		_banner.setLienKet(lienKet);
	}

	/**
	* Returns the order_ of this banner.
	*
	* @return the order_ of this banner
	*/
	@Override
	public int getOrder_() {
		return _banner.getOrder_();
	}

	/**
	* Sets the order_ of this banner.
	*
	* @param order_ the order_ of this banner
	*/
	@Override
	public void setOrder_(int order_) {
		_banner.setOrder_(order_);
	}

	/**
	* Returns the trang thai of this banner.
	*
	* @return the trang thai of this banner
	*/
	@Override
	public boolean getTrangThai() {
		return _banner.getTrangThai();
	}

	/**
	* Returns <code>true</code> if this banner is trang thai.
	*
	* @return <code>true</code> if this banner is trang thai; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrangThai() {
		return _banner.isTrangThai();
	}

	/**
	* Sets whether this banner is trang thai.
	*
	* @param trangThai the trang thai of this banner
	*/
	@Override
	public void setTrangThai(boolean trangThai) {
		_banner.setTrangThai(trangThai);
	}

	/**
	* Returns the nguoi tao of this banner.
	*
	* @return the nguoi tao of this banner
	*/
	@Override
	public java.lang.String getNguoiTao() {
		return _banner.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this banner.
	*
	* @param nguoiTao the nguoi tao of this banner
	*/
	@Override
	public void setNguoiTao(java.lang.String nguoiTao) {
		_banner.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi tao ID of this banner.
	*
	* @return the nguoi tao ID of this banner
	*/
	@Override
	public long getNguoiTaoId() {
		return _banner.getNguoiTaoId();
	}

	/**
	* Sets the nguoi tao ID of this banner.
	*
	* @param nguoiTaoId the nguoi tao ID of this banner
	*/
	@Override
	public void setNguoiTaoId(long nguoiTaoId) {
		_banner.setNguoiTaoId(nguoiTaoId);
	}

	/**
	* Returns the nguoi sua of this banner.
	*
	* @return the nguoi sua of this banner
	*/
	@Override
	public java.lang.String getNguoiSua() {
		return _banner.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this banner.
	*
	* @param nguoiSua the nguoi sua of this banner
	*/
	@Override
	public void setNguoiSua(java.lang.String nguoiSua) {
		_banner.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the nguoi sua ID of this banner.
	*
	* @return the nguoi sua ID of this banner
	*/
	@Override
	public long getNguoiSuaId() {
		return _banner.getNguoiSuaId();
	}

	/**
	* Sets the nguoi sua ID of this banner.
	*
	* @param nguoiSuaId the nguoi sua ID of this banner
	*/
	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_banner.setNguoiSuaId(nguoiSuaId);
	}

	/**
	* Returns the company ID of this banner.
	*
	* @return the company ID of this banner
	*/
	@Override
	public long getCompanyId() {
		return _banner.getCompanyId();
	}

	/**
	* Sets the company ID of this banner.
	*
	* @param companyId the company ID of this banner
	*/
	@Override
	public void setCompanyId(long companyId) {
		_banner.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this banner.
	*
	* @return the group ID of this banner
	*/
	@Override
	public long getGroupId() {
		return _banner.getGroupId();
	}

	/**
	* Sets the group ID of this banner.
	*
	* @param groupId the group ID of this banner
	*/
	@Override
	public void setGroupId(long groupId) {
		_banner.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _banner.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_banner.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _banner.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_banner.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _banner.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _banner.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_banner.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _banner.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_banner.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_banner.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_banner.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BannerWrapper((Banner)_banner.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.banner.model.Banner banner) {
		return _banner.compareTo(banner);
	}

	@Override
	public int hashCode() {
		return _banner.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.banner.model.Banner> toCacheModel() {
		return _banner.toCacheModel();
	}

	@Override
	public com.viettel.portal.banner.model.Banner toEscapedModel() {
		return new BannerWrapper(_banner.toEscapedModel());
	}

	@Override
	public com.viettel.portal.banner.model.Banner toUnescapedModel() {
		return new BannerWrapper(_banner.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _banner.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _banner.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_banner.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BannerWrapper)) {
			return false;
		}

		BannerWrapper bannerWrapper = (BannerWrapper)obj;

		if (Validator.equals(_banner, bannerWrapper._banner)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Banner getWrappedBanner() {
		return _banner;
	}

	@Override
	public Banner getWrappedModel() {
		return _banner;
	}

	@Override
	public void resetOriginalValues() {
		_banner.resetOriginalValues();
	}

	private Banner _banner;
}