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

package com.viettel.portal.videolibrary.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VLVideoCategory}.
 * </p>
 *
 * @author ChucHV
 * @see VLVideoCategory
 * @generated
 */
public class VLVideoCategoryWrapper implements VLVideoCategory,
	ModelWrapper<VLVideoCategory> {
	public VLVideoCategoryWrapper(VLVideoCategory vlVideoCategory) {
		_vlVideoCategory = vlVideoCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return VLVideoCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VLVideoCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("videoId", getVideoId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this v l video category.
	*
	* @return the primary key of this v l video category
	*/
	@Override
	public long getPrimaryKey() {
		return _vlVideoCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v l video category.
	*
	* @param primaryKey the primary key of this v l video category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vlVideoCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this v l video category.
	*
	* @return the ID of this v l video category
	*/
	@Override
	public long getId() {
		return _vlVideoCategory.getId();
	}

	/**
	* Sets the ID of this v l video category.
	*
	* @param id the ID of this v l video category
	*/
	@Override
	public void setId(long id) {
		_vlVideoCategory.setId(id);
	}

	/**
	* Returns the category ID of this v l video category.
	*
	* @return the category ID of this v l video category
	*/
	@Override
	public long getCategoryId() {
		return _vlVideoCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this v l video category.
	*
	* @param categoryId the category ID of this v l video category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_vlVideoCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the video ID of this v l video category.
	*
	* @return the video ID of this v l video category
	*/
	@Override
	public long getVideoId() {
		return _vlVideoCategory.getVideoId();
	}

	/**
	* Sets the video ID of this v l video category.
	*
	* @param videoId the video ID of this v l video category
	*/
	@Override
	public void setVideoId(long videoId) {
		_vlVideoCategory.setVideoId(videoId);
	}

	/**
	* Returns the group ID of this v l video category.
	*
	* @return the group ID of this v l video category
	*/
	@Override
	public long getGroupId() {
		return _vlVideoCategory.getGroupId();
	}

	/**
	* Sets the group ID of this v l video category.
	*
	* @param groupId the group ID of this v l video category
	*/
	@Override
	public void setGroupId(long groupId) {
		_vlVideoCategory.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _vlVideoCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vlVideoCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vlVideoCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vlVideoCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vlVideoCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vlVideoCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vlVideoCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vlVideoCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vlVideoCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vlVideoCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vlVideoCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLVideoCategoryWrapper((VLVideoCategory)_vlVideoCategory.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.videolibrary.model.VLVideoCategory vlVideoCategory) {
		return _vlVideoCategory.compareTo(vlVideoCategory);
	}

	@Override
	public int hashCode() {
		return _vlVideoCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.videolibrary.model.VLVideoCategory> toCacheModel() {
		return _vlVideoCategory.toCacheModel();
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideoCategory toEscapedModel() {
		return new VLVideoCategoryWrapper(_vlVideoCategory.toEscapedModel());
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideoCategory toUnescapedModel() {
		return new VLVideoCategoryWrapper(_vlVideoCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vlVideoCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vlVideoCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlVideoCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLVideoCategoryWrapper)) {
			return false;
		}

		VLVideoCategoryWrapper vlVideoCategoryWrapper = (VLVideoCategoryWrapper)obj;

		if (Validator.equals(_vlVideoCategory,
					vlVideoCategoryWrapper._vlVideoCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLVideoCategory getWrappedVLVideoCategory() {
		return _vlVideoCategory;
	}

	@Override
	public VLVideoCategory getWrappedModel() {
		return _vlVideoCategory;
	}

	@Override
	public void resetOriginalValues() {
		_vlVideoCategory.resetOriginalValues();
	}

	private VLVideoCategory _vlVideoCategory;
}