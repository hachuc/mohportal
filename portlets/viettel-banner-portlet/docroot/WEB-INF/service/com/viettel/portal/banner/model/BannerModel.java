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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Banner service. Represents a row in the &quot;portal_banner&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.banner.model.impl.BannerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.banner.model.impl.BannerImpl}.
 * </p>
 *
 * @author ChucHV
 * @see Banner
 * @see com.viettel.portal.banner.model.impl.BannerImpl
 * @see com.viettel.portal.banner.model.impl.BannerModelImpl
 * @generated
 */
public interface BannerModel extends BaseModel<Banner> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a banner model instance should use the {@link Banner} interface instead.
	 */

	/**
	 * Returns the primary key of this banner.
	 *
	 * @return the primary key of this banner
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this banner.
	 *
	 * @param primaryKey the primary key of this banner
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this banner.
	 *
	 * @return the ID of this banner
	 */
	public long getId();

	/**
	 * Sets the ID of this banner.
	 *
	 * @param id the ID of this banner
	 */
	public void setId(long id);

	/**
	 * Returns the ten of this banner.
	 *
	 * @return the ten of this banner
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this banner.
	 *
	 * @param ten the ten of this banner
	 */
	public void setTen(String ten);

	/**
	 * Returns the file ID of this banner.
	 *
	 * @return the file ID of this banner
	 */
	public long getFileId();

	/**
	 * Sets the file ID of this banner.
	 *
	 * @param fileId the file ID of this banner
	 */
	public void setFileId(long fileId);

	/**
	 * Returns the file link of this banner.
	 *
	 * @return the file link of this banner
	 */
	@AutoEscape
	public String getFileLink();

	/**
	 * Sets the file link of this banner.
	 *
	 * @param fileLink the file link of this banner
	 */
	public void setFileLink(String fileLink);

	/**
	 * Returns the file name of this banner.
	 *
	 * @return the file name of this banner
	 */
	@AutoEscape
	public String getFileName();

	/**
	 * Sets the file name of this banner.
	 *
	 * @param fileName the file name of this banner
	 */
	public void setFileName(String fileName);

	/**
	 * Returns the file size of this banner.
	 *
	 * @return the file size of this banner
	 */
	@AutoEscape
	public String getFileSize();

	/**
	 * Sets the file size of this banner.
	 *
	 * @param fileSize the file size of this banner
	 */
	public void setFileSize(String fileSize);

	/**
	 * Returns the ngay tao of this banner.
	 *
	 * @return the ngay tao of this banner
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this banner.
	 *
	 * @param ngayTao the ngay tao of this banner
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the ngay sua of this banner.
	 *
	 * @return the ngay sua of this banner
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this banner.
	 *
	 * @param ngaySua the ngay sua of this banner
	 */
	public void setNgaySua(Date ngaySua);

	/**
	 * Returns the ngay ket thuc of this banner.
	 *
	 * @return the ngay ket thuc of this banner
	 */
	public Date getNgayKetThuc();

	/**
	 * Sets the ngay ket thuc of this banner.
	 *
	 * @param ngayKetThuc the ngay ket thuc of this banner
	 */
	public void setNgayKetThuc(Date ngayKetThuc);

	/**
	 * Returns the lien ket of this banner.
	 *
	 * @return the lien ket of this banner
	 */
	@AutoEscape
	public String getLienKet();

	/**
	 * Sets the lien ket of this banner.
	 *
	 * @param lienKet the lien ket of this banner
	 */
	public void setLienKet(String lienKet);

	/**
	 * Returns the order_ of this banner.
	 *
	 * @return the order_ of this banner
	 */
	public int getOrder_();

	/**
	 * Sets the order_ of this banner.
	 *
	 * @param order_ the order_ of this banner
	 */
	public void setOrder_(int order_);

	/**
	 * Returns the trang thai of this banner.
	 *
	 * @return the trang thai of this banner
	 */
	public boolean getTrangThai();

	/**
	 * Returns <code>true</code> if this banner is trang thai.
	 *
	 * @return <code>true</code> if this banner is trang thai; <code>false</code> otherwise
	 */
	public boolean isTrangThai();

	/**
	 * Sets whether this banner is trang thai.
	 *
	 * @param trangThai the trang thai of this banner
	 */
	public void setTrangThai(boolean trangThai);

	/**
	 * Returns the nguoi tao of this banner.
	 *
	 * @return the nguoi tao of this banner
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this banner.
	 *
	 * @param nguoiTao the nguoi tao of this banner
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the nguoi tao ID of this banner.
	 *
	 * @return the nguoi tao ID of this banner
	 */
	public long getNguoiTaoId();

	/**
	 * Sets the nguoi tao ID of this banner.
	 *
	 * @param nguoiTaoId the nguoi tao ID of this banner
	 */
	public void setNguoiTaoId(long nguoiTaoId);

	/**
	 * Returns the nguoi sua of this banner.
	 *
	 * @return the nguoi sua of this banner
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this banner.
	 *
	 * @param nguoiSua the nguoi sua of this banner
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the nguoi sua ID of this banner.
	 *
	 * @return the nguoi sua ID of this banner
	 */
	public long getNguoiSuaId();

	/**
	 * Sets the nguoi sua ID of this banner.
	 *
	 * @param nguoiSuaId the nguoi sua ID of this banner
	 */
	public void setNguoiSuaId(long nguoiSuaId);

	/**
	 * Returns the company ID of this banner.
	 *
	 * @return the company ID of this banner
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this banner.
	 *
	 * @param companyId the company ID of this banner
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this banner.
	 *
	 * @return the group ID of this banner
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this banner.
	 *
	 * @param groupId the group ID of this banner
	 */
	public void setGroupId(long groupId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.viettel.portal.banner.model.Banner banner);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.banner.model.Banner> toCacheModel();

	@Override
	public com.viettel.portal.banner.model.Banner toEscapedModel();

	@Override
	public com.viettel.portal.banner.model.Banner toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}