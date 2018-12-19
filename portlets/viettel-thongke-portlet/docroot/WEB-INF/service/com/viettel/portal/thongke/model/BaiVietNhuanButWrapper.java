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

package com.viettel.portal.thongke.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BaiVietNhuanBut}.
 * </p>
 *
 * @author lamvn
 * @see BaiVietNhuanBut
 * @generated
 */
public class BaiVietNhuanButWrapper implements BaiVietNhuanBut,
	ModelWrapper<BaiVietNhuanBut> {
	public BaiVietNhuanButWrapper(BaiVietNhuanBut baiVietNhuanBut) {
		_baiVietNhuanBut = baiVietNhuanBut;
	}

	@Override
	public Class<?> getModelClass() {
		return BaiVietNhuanBut.class;
	}

	@Override
	public String getModelClassName() {
		return BaiVietNhuanBut.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("baiVietId", getBaiVietId());
		attributes.put("loaiBaiViet", getLoaiBaiViet());
		attributes.put("tieuDe", getTieuDe());
		attributes.put("tacGia", getTacGia());
		attributes.put("diaChi", getDiaChi());
		attributes.put("ngayXuatBan", getNgayXuatBan());
		attributes.put("rating", getRating());
		attributes.put("ratingValue", getRatingValue());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long baiVietId = (Long)attributes.get("baiVietId");

		if (baiVietId != null) {
			setBaiVietId(baiVietId);
		}

		Integer loaiBaiViet = (Integer)attributes.get("loaiBaiViet");

		if (loaiBaiViet != null) {
			setLoaiBaiViet(loaiBaiViet);
		}

		String tieuDe = (String)attributes.get("tieuDe");

		if (tieuDe != null) {
			setTieuDe(tieuDe);
		}

		String tacGia = (String)attributes.get("tacGia");

		if (tacGia != null) {
			setTacGia(tacGia);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		Date ngayXuatBan = (Date)attributes.get("ngayXuatBan");

		if (ngayXuatBan != null) {
			setNgayXuatBan(ngayXuatBan);
		}

		String rating = (String)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Double ratingValue = (Double)attributes.get("ratingValue");

		if (ratingValue != null) {
			setRatingValue(ratingValue);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this bai viet nhuan but.
	*
	* @return the primary key of this bai viet nhuan but
	*/
	@Override
	public long getPrimaryKey() {
		return _baiVietNhuanBut.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bai viet nhuan but.
	*
	* @param primaryKey the primary key of this bai viet nhuan but
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_baiVietNhuanBut.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this bai viet nhuan but.
	*
	* @return the ID of this bai viet nhuan but
	*/
	@Override
	public long getId() {
		return _baiVietNhuanBut.getId();
	}

	/**
	* Sets the ID of this bai viet nhuan but.
	*
	* @param id the ID of this bai viet nhuan but
	*/
	@Override
	public void setId(long id) {
		_baiVietNhuanBut.setId(id);
	}

	/**
	* Returns the bai viet ID of this bai viet nhuan but.
	*
	* @return the bai viet ID of this bai viet nhuan but
	*/
	@Override
	public long getBaiVietId() {
		return _baiVietNhuanBut.getBaiVietId();
	}

	/**
	* Sets the bai viet ID of this bai viet nhuan but.
	*
	* @param baiVietId the bai viet ID of this bai viet nhuan but
	*/
	@Override
	public void setBaiVietId(long baiVietId) {
		_baiVietNhuanBut.setBaiVietId(baiVietId);
	}

	/**
	* Returns the loai bai viet of this bai viet nhuan but.
	*
	* @return the loai bai viet of this bai viet nhuan but
	*/
	@Override
	public int getLoaiBaiViet() {
		return _baiVietNhuanBut.getLoaiBaiViet();
	}

	/**
	* Sets the loai bai viet of this bai viet nhuan but.
	*
	* @param loaiBaiViet the loai bai viet of this bai viet nhuan but
	*/
	@Override
	public void setLoaiBaiViet(int loaiBaiViet) {
		_baiVietNhuanBut.setLoaiBaiViet(loaiBaiViet);
	}

	/**
	* Returns the tieu de of this bai viet nhuan but.
	*
	* @return the tieu de of this bai viet nhuan but
	*/
	@Override
	public java.lang.String getTieuDe() {
		return _baiVietNhuanBut.getTieuDe();
	}

	/**
	* Sets the tieu de of this bai viet nhuan but.
	*
	* @param tieuDe the tieu de of this bai viet nhuan but
	*/
	@Override
	public void setTieuDe(java.lang.String tieuDe) {
		_baiVietNhuanBut.setTieuDe(tieuDe);
	}

	/**
	* Returns the tac gia of this bai viet nhuan but.
	*
	* @return the tac gia of this bai viet nhuan but
	*/
	@Override
	public java.lang.String getTacGia() {
		return _baiVietNhuanBut.getTacGia();
	}

	/**
	* Sets the tac gia of this bai viet nhuan but.
	*
	* @param tacGia the tac gia of this bai viet nhuan but
	*/
	@Override
	public void setTacGia(java.lang.String tacGia) {
		_baiVietNhuanBut.setTacGia(tacGia);
	}

	/**
	* Returns the dia chi of this bai viet nhuan but.
	*
	* @return the dia chi of this bai viet nhuan but
	*/
	@Override
	public java.lang.String getDiaChi() {
		return _baiVietNhuanBut.getDiaChi();
	}

	/**
	* Sets the dia chi of this bai viet nhuan but.
	*
	* @param diaChi the dia chi of this bai viet nhuan but
	*/
	@Override
	public void setDiaChi(java.lang.String diaChi) {
		_baiVietNhuanBut.setDiaChi(diaChi);
	}

	/**
	* Returns the ngay xuat ban of this bai viet nhuan but.
	*
	* @return the ngay xuat ban of this bai viet nhuan but
	*/
	@Override
	public java.util.Date getNgayXuatBan() {
		return _baiVietNhuanBut.getNgayXuatBan();
	}

	/**
	* Sets the ngay xuat ban of this bai viet nhuan but.
	*
	* @param ngayXuatBan the ngay xuat ban of this bai viet nhuan but
	*/
	@Override
	public void setNgayXuatBan(java.util.Date ngayXuatBan) {
		_baiVietNhuanBut.setNgayXuatBan(ngayXuatBan);
	}

	/**
	* Returns the rating of this bai viet nhuan but.
	*
	* @return the rating of this bai viet nhuan but
	*/
	@Override
	public java.lang.String getRating() {
		return _baiVietNhuanBut.getRating();
	}

	/**
	* Sets the rating of this bai viet nhuan but.
	*
	* @param rating the rating of this bai viet nhuan but
	*/
	@Override
	public void setRating(java.lang.String rating) {
		_baiVietNhuanBut.setRating(rating);
	}

	/**
	* Returns the rating value of this bai viet nhuan but.
	*
	* @return the rating value of this bai viet nhuan but
	*/
	@Override
	public double getRatingValue() {
		return _baiVietNhuanBut.getRatingValue();
	}

	/**
	* Sets the rating value of this bai viet nhuan but.
	*
	* @param ratingValue the rating value of this bai viet nhuan but
	*/
	@Override
	public void setRatingValue(double ratingValue) {
		_baiVietNhuanBut.setRatingValue(ratingValue);
	}

	/**
	* Returns the company ID of this bai viet nhuan but.
	*
	* @return the company ID of this bai viet nhuan but
	*/
	@Override
	public long getCompanyId() {
		return _baiVietNhuanBut.getCompanyId();
	}

	/**
	* Sets the company ID of this bai viet nhuan but.
	*
	* @param companyId the company ID of this bai viet nhuan but
	*/
	@Override
	public void setCompanyId(long companyId) {
		_baiVietNhuanBut.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this bai viet nhuan but.
	*
	* @return the group ID of this bai viet nhuan but
	*/
	@Override
	public long getGroupId() {
		return _baiVietNhuanBut.getGroupId();
	}

	/**
	* Sets the group ID of this bai viet nhuan but.
	*
	* @param groupId the group ID of this bai viet nhuan but
	*/
	@Override
	public void setGroupId(long groupId) {
		_baiVietNhuanBut.setGroupId(groupId);
	}

	/**
	* Returns the create date of this bai viet nhuan but.
	*
	* @return the create date of this bai viet nhuan but
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _baiVietNhuanBut.getCreateDate();
	}

	/**
	* Sets the create date of this bai viet nhuan but.
	*
	* @param createDate the create date of this bai viet nhuan but
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_baiVietNhuanBut.setCreateDate(createDate);
	}

	/**
	* Returns the modify date of this bai viet nhuan but.
	*
	* @return the modify date of this bai viet nhuan but
	*/
	@Override
	public java.util.Date getModifyDate() {
		return _baiVietNhuanBut.getModifyDate();
	}

	/**
	* Sets the modify date of this bai viet nhuan but.
	*
	* @param modifyDate the modify date of this bai viet nhuan but
	*/
	@Override
	public void setModifyDate(java.util.Date modifyDate) {
		_baiVietNhuanBut.setModifyDate(modifyDate);
	}

	/**
	* Returns the user name of this bai viet nhuan but.
	*
	* @return the user name of this bai viet nhuan but
	*/
	@Override
	public java.lang.String getUserName() {
		return _baiVietNhuanBut.getUserName();
	}

	/**
	* Sets the user name of this bai viet nhuan but.
	*
	* @param userName the user name of this bai viet nhuan but
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_baiVietNhuanBut.setUserName(userName);
	}

	/**
	* Returns the user ID of this bai viet nhuan but.
	*
	* @return the user ID of this bai viet nhuan but
	*/
	@Override
	public long getUserId() {
		return _baiVietNhuanBut.getUserId();
	}

	/**
	* Sets the user ID of this bai viet nhuan but.
	*
	* @param userId the user ID of this bai viet nhuan but
	*/
	@Override
	public void setUserId(long userId) {
		_baiVietNhuanBut.setUserId(userId);
	}

	/**
	* Returns the user uuid of this bai viet nhuan but.
	*
	* @return the user uuid of this bai viet nhuan but
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _baiVietNhuanBut.getUserUuid();
	}

	/**
	* Sets the user uuid of this bai viet nhuan but.
	*
	* @param userUuid the user uuid of this bai viet nhuan but
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_baiVietNhuanBut.setUserUuid(userUuid);
	}

	/**
	* Returns the type of this bai viet nhuan but.
	*
	* @return the type of this bai viet nhuan but
	*/
	@Override
	public int getType() {
		return _baiVietNhuanBut.getType();
	}

	/**
	* Sets the type of this bai viet nhuan but.
	*
	* @param type the type of this bai viet nhuan but
	*/
	@Override
	public void setType(int type) {
		_baiVietNhuanBut.setType(type);
	}

	@Override
	public boolean isNew() {
		return _baiVietNhuanBut.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_baiVietNhuanBut.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _baiVietNhuanBut.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_baiVietNhuanBut.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _baiVietNhuanBut.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _baiVietNhuanBut.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_baiVietNhuanBut.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _baiVietNhuanBut.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_baiVietNhuanBut.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_baiVietNhuanBut.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_baiVietNhuanBut.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BaiVietNhuanButWrapper((BaiVietNhuanBut)_baiVietNhuanBut.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.thongke.model.BaiVietNhuanBut baiVietNhuanBut) {
		return _baiVietNhuanBut.compareTo(baiVietNhuanBut);
	}

	@Override
	public int hashCode() {
		return _baiVietNhuanBut.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.BaiVietNhuanBut> toCacheModel() {
		return _baiVietNhuanBut.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut toEscapedModel() {
		return new BaiVietNhuanButWrapper(_baiVietNhuanBut.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.BaiVietNhuanBut toUnescapedModel() {
		return new BaiVietNhuanButWrapper(_baiVietNhuanBut.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _baiVietNhuanBut.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _baiVietNhuanBut.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_baiVietNhuanBut.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BaiVietNhuanButWrapper)) {
			return false;
		}

		BaiVietNhuanButWrapper baiVietNhuanButWrapper = (BaiVietNhuanButWrapper)obj;

		if (Validator.equals(_baiVietNhuanBut,
					baiVietNhuanButWrapper._baiVietNhuanBut)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BaiVietNhuanBut getWrappedBaiVietNhuanBut() {
		return _baiVietNhuanBut;
	}

	@Override
	public BaiVietNhuanBut getWrappedModel() {
		return _baiVietNhuanBut;
	}

	@Override
	public void resetOriginalValues() {
		_baiVietNhuanBut.resetOriginalValues();
	}

	private BaiVietNhuanBut _baiVietNhuanBut;
}