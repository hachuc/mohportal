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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhongBanNhuanButChiTiet}.
 * </p>
 *
 * @author lamvn
 * @see PhongBanNhuanButChiTiet
 * @generated
 */
public class PhongBanNhuanButChiTietWrapper implements PhongBanNhuanButChiTiet,
	ModelWrapper<PhongBanNhuanButChiTiet> {
	public PhongBanNhuanButChiTietWrapper(
		PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		_phongBanNhuanButChiTiet = phongBanNhuanButChiTiet;
	}

	@Override
	public Class<?> getModelClass() {
		return PhongBanNhuanButChiTiet.class;
	}

	@Override
	public String getModelClassName() {
		return PhongBanNhuanButChiTiet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("phongBanNhuanButId", getPhongBanNhuanButId());
		attributes.put("phongBanId", getPhongBanId());
		attributes.put("phongBanTen", getPhongBanTen());
		attributes.put("rating", getRating());
		attributes.put("ratingValue", getRatingValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long phongBanNhuanButId = (Long)attributes.get("phongBanNhuanButId");

		if (phongBanNhuanButId != null) {
			setPhongBanNhuanButId(phongBanNhuanButId);
		}

		Long phongBanId = (Long)attributes.get("phongBanId");

		if (phongBanId != null) {
			setPhongBanId(phongBanId);
		}

		String phongBanTen = (String)attributes.get("phongBanTen");

		if (phongBanTen != null) {
			setPhongBanTen(phongBanTen);
		}

		String rating = (String)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Double ratingValue = (Double)attributes.get("ratingValue");

		if (ratingValue != null) {
			setRatingValue(ratingValue);
		}
	}

	/**
	* Returns the primary key of this phong ban nhuan but chi tiet.
	*
	* @return the primary key of this phong ban nhuan but chi tiet
	*/
	@Override
	public long getPrimaryKey() {
		return _phongBanNhuanButChiTiet.getPrimaryKey();
	}

	/**
	* Sets the primary key of this phong ban nhuan but chi tiet.
	*
	* @param primaryKey the primary key of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_phongBanNhuanButChiTiet.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this phong ban nhuan but chi tiet.
	*
	* @return the ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public long getId() {
		return _phongBanNhuanButChiTiet.getId();
	}

	/**
	* Sets the ID of this phong ban nhuan but chi tiet.
	*
	* @param id the ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setId(long id) {
		_phongBanNhuanButChiTiet.setId(id);
	}

	/**
	* Returns the phong ban nhuan but ID of this phong ban nhuan but chi tiet.
	*
	* @return the phong ban nhuan but ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public long getPhongBanNhuanButId() {
		return _phongBanNhuanButChiTiet.getPhongBanNhuanButId();
	}

	/**
	* Sets the phong ban nhuan but ID of this phong ban nhuan but chi tiet.
	*
	* @param phongBanNhuanButId the phong ban nhuan but ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setPhongBanNhuanButId(long phongBanNhuanButId) {
		_phongBanNhuanButChiTiet.setPhongBanNhuanButId(phongBanNhuanButId);
	}

	/**
	* Returns the phong ban ID of this phong ban nhuan but chi tiet.
	*
	* @return the phong ban ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public long getPhongBanId() {
		return _phongBanNhuanButChiTiet.getPhongBanId();
	}

	/**
	* Sets the phong ban ID of this phong ban nhuan but chi tiet.
	*
	* @param phongBanId the phong ban ID of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setPhongBanId(long phongBanId) {
		_phongBanNhuanButChiTiet.setPhongBanId(phongBanId);
	}

	/**
	* Returns the phong ban ten of this phong ban nhuan but chi tiet.
	*
	* @return the phong ban ten of this phong ban nhuan but chi tiet
	*/
	@Override
	public java.lang.String getPhongBanTen() {
		return _phongBanNhuanButChiTiet.getPhongBanTen();
	}

	/**
	* Sets the phong ban ten of this phong ban nhuan but chi tiet.
	*
	* @param phongBanTen the phong ban ten of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setPhongBanTen(java.lang.String phongBanTen) {
		_phongBanNhuanButChiTiet.setPhongBanTen(phongBanTen);
	}

	/**
	* Returns the rating of this phong ban nhuan but chi tiet.
	*
	* @return the rating of this phong ban nhuan but chi tiet
	*/
	@Override
	public java.lang.String getRating() {
		return _phongBanNhuanButChiTiet.getRating();
	}

	/**
	* Sets the rating of this phong ban nhuan but chi tiet.
	*
	* @param rating the rating of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setRating(java.lang.String rating) {
		_phongBanNhuanButChiTiet.setRating(rating);
	}

	/**
	* Returns the rating value of this phong ban nhuan but chi tiet.
	*
	* @return the rating value of this phong ban nhuan but chi tiet
	*/
	@Override
	public double getRatingValue() {
		return _phongBanNhuanButChiTiet.getRatingValue();
	}

	/**
	* Sets the rating value of this phong ban nhuan but chi tiet.
	*
	* @param ratingValue the rating value of this phong ban nhuan but chi tiet
	*/
	@Override
	public void setRatingValue(double ratingValue) {
		_phongBanNhuanButChiTiet.setRatingValue(ratingValue);
	}

	@Override
	public boolean isNew() {
		return _phongBanNhuanButChiTiet.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_phongBanNhuanButChiTiet.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _phongBanNhuanButChiTiet.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_phongBanNhuanButChiTiet.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _phongBanNhuanButChiTiet.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _phongBanNhuanButChiTiet.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_phongBanNhuanButChiTiet.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _phongBanNhuanButChiTiet.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_phongBanNhuanButChiTiet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_phongBanNhuanButChiTiet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_phongBanNhuanButChiTiet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PhongBanNhuanButChiTietWrapper((PhongBanNhuanButChiTiet)_phongBanNhuanButChiTiet.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		return _phongBanNhuanButChiTiet.compareTo(phongBanNhuanButChiTiet);
	}

	@Override
	public int hashCode() {
		return _phongBanNhuanButChiTiet.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet> toCacheModel() {
		return _phongBanNhuanButChiTiet.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet toEscapedModel() {
		return new PhongBanNhuanButChiTietWrapper(_phongBanNhuanButChiTiet.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet toUnescapedModel() {
		return new PhongBanNhuanButChiTietWrapper(_phongBanNhuanButChiTiet.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _phongBanNhuanButChiTiet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _phongBanNhuanButChiTiet.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_phongBanNhuanButChiTiet.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PhongBanNhuanButChiTietWrapper)) {
			return false;
		}

		PhongBanNhuanButChiTietWrapper phongBanNhuanButChiTietWrapper = (PhongBanNhuanButChiTietWrapper)obj;

		if (Validator.equals(_phongBanNhuanButChiTiet,
					phongBanNhuanButChiTietWrapper._phongBanNhuanButChiTiet)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PhongBanNhuanButChiTiet getWrappedPhongBanNhuanButChiTiet() {
		return _phongBanNhuanButChiTiet;
	}

	@Override
	public PhongBanNhuanButChiTiet getWrappedModel() {
		return _phongBanNhuanButChiTiet;
	}

	@Override
	public void resetOriginalValues() {
		_phongBanNhuanButChiTiet.resetOriginalValues();
	}

	private PhongBanNhuanButChiTiet _phongBanNhuanButChiTiet;
}