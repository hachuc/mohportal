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

package com.revotech.portal.videolibrary.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VideoCategory}.
 * </p>
 *
 * @author ChucHV
 * @see VideoCategory
 * @generated
 */
public class VideoCategoryWrapper implements VideoCategory,
	ModelWrapper<VideoCategory> {
	public VideoCategoryWrapper(VideoCategory videoCategory) {
		_videoCategory = videoCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return VideoCategory.class;
	}

	@Override
	public String getModelClassName() {
		return VideoCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("Url", getUrl());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("ItemCount", getItemCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Url = (String)attributes.get("Url");

		if (Url != null) {
			setUrl(Url);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Integer ItemCount = (Integer)attributes.get("ItemCount");

		if (ItemCount != null) {
			setItemCount(ItemCount);
		}
	}

	/**
	* Returns the primary key of this video category.
	*
	* @return the primary key of this video category
	*/
	@Override
	public int getPrimaryKey() {
		return _videoCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video category.
	*
	* @param primaryKey the primary key of this video category
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_videoCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this video category.
	*
	* @return the i d of this video category
	*/
	@Override
	public int getID() {
		return _videoCategory.getID();
	}

	/**
	* Sets the i d of this video category.
	*
	* @param ID the i d of this video category
	*/
	@Override
	public void setID(int ID) {
		_videoCategory.setID(ID);
	}

	/**
	* Returns the name of this video category.
	*
	* @return the name of this video category
	*/
	@Override
	public java.lang.String getName() {
		return _videoCategory.getName();
	}

	/**
	* Sets the name of this video category.
	*
	* @param Name the name of this video category
	*/
	@Override
	public void setName(java.lang.String Name) {
		_videoCategory.setName(Name);
	}

	/**
	* Returns the url of this video category.
	*
	* @return the url of this video category
	*/
	@Override
	public java.lang.String getUrl() {
		return _videoCategory.getUrl();
	}

	/**
	* Sets the url of this video category.
	*
	* @param Url the url of this video category
	*/
	@Override
	public void setUrl(java.lang.String Url) {
		_videoCategory.setUrl(Url);
	}

	/**
	* Returns the sort order of this video category.
	*
	* @return the sort order of this video category
	*/
	@Override
	public int getSortOrder() {
		return _videoCategory.getSortOrder();
	}

	/**
	* Sets the sort order of this video category.
	*
	* @param SortOrder the sort order of this video category
	*/
	@Override
	public void setSortOrder(int SortOrder) {
		_videoCategory.setSortOrder(SortOrder);
	}

	/**
	* Returns the item count of this video category.
	*
	* @return the item count of this video category
	*/
	@Override
	public int getItemCount() {
		return _videoCategory.getItemCount();
	}

	/**
	* Sets the item count of this video category.
	*
	* @param ItemCount the item count of this video category
	*/
	@Override
	public void setItemCount(int ItemCount) {
		_videoCategory.setItemCount(ItemCount);
	}

	@Override
	public boolean isNew() {
		return _videoCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_videoCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _videoCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_videoCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _videoCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _videoCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_videoCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_videoCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoCategoryWrapper((VideoCategory)_videoCategory.clone());
	}

	@Override
	public int compareTo(
		com.revotech.portal.videolibrary.model.VideoCategory videoCategory) {
		return _videoCategory.compareTo(videoCategory);
	}

	@Override
	public int hashCode() {
		return _videoCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.videolibrary.model.VideoCategory> toCacheModel() {
		return _videoCategory.toCacheModel();
	}

	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory toEscapedModel() {
		return new VideoCategoryWrapper(_videoCategory.toEscapedModel());
	}

	@Override
	public com.revotech.portal.videolibrary.model.VideoCategory toUnescapedModel() {
		return new VideoCategoryWrapper(_videoCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _videoCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoCategoryWrapper)) {
			return false;
		}

		VideoCategoryWrapper videoCategoryWrapper = (VideoCategoryWrapper)obj;

		if (Validator.equals(_videoCategory, videoCategoryWrapper._videoCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VideoCategory getWrappedVideoCategory() {
		return _videoCategory;
	}

	@Override
	public VideoCategory getWrappedModel() {
		return _videoCategory;
	}

	@Override
	public void resetOriginalValues() {
		_videoCategory.resetOriginalValues();
	}

	private VideoCategory _videoCategory;
}