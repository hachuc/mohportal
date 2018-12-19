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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VideoClip}.
 * </p>
 *
 * @author ChucHV
 * @see VideoClip
 * @generated
 */
public class VideoClipWrapper implements VideoClip, ModelWrapper<VideoClip> {
	public VideoClipWrapper(VideoClip videoClip) {
		_videoClip = videoClip;
	}

	@Override
	public Class<?> getModelClass() {
		return VideoClip.class;
	}

	@Override
	public String getModelClassName() {
		return VideoClip.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("CategoryID", getCategoryID());
		attributes.put("Description", getDescription());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("VideoUrl", getVideoUrl());
		attributes.put("Duration", getDuration());
		attributes.put("ViewCount", getViewCount());
		attributes.put("Status", getStatus());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());

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

		Integer CategoryID = (Integer)attributes.get("CategoryID");

		if (CategoryID != null) {
			setCategoryID(CategoryID);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		String VideoUrl = (String)attributes.get("VideoUrl");

		if (VideoUrl != null) {
			setVideoUrl(VideoUrl);
		}

		Integer Duration = (Integer)attributes.get("Duration");

		if (Duration != null) {
			setDuration(Duration);
		}

		Integer ViewCount = (Integer)attributes.get("ViewCount");

		if (ViewCount != null) {
			setViewCount(ViewCount);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}
	}

	/**
	* Returns the primary key of this video clip.
	*
	* @return the primary key of this video clip
	*/
	@Override
	public int getPrimaryKey() {
		return _videoClip.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video clip.
	*
	* @param primaryKey the primary key of this video clip
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_videoClip.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this video clip.
	*
	* @return the i d of this video clip
	*/
	@Override
	public int getID() {
		return _videoClip.getID();
	}

	/**
	* Sets the i d of this video clip.
	*
	* @param ID the i d of this video clip
	*/
	@Override
	public void setID(int ID) {
		_videoClip.setID(ID);
	}

	/**
	* Returns the name of this video clip.
	*
	* @return the name of this video clip
	*/
	@Override
	public java.lang.String getName() {
		return _videoClip.getName();
	}

	/**
	* Sets the name of this video clip.
	*
	* @param Name the name of this video clip
	*/
	@Override
	public void setName(java.lang.String Name) {
		_videoClip.setName(Name);
	}

	/**
	* Returns the category i d of this video clip.
	*
	* @return the category i d of this video clip
	*/
	@Override
	public int getCategoryID() {
		return _videoClip.getCategoryID();
	}

	/**
	* Sets the category i d of this video clip.
	*
	* @param CategoryID the category i d of this video clip
	*/
	@Override
	public void setCategoryID(int CategoryID) {
		_videoClip.setCategoryID(CategoryID);
	}

	/**
	* Returns the description of this video clip.
	*
	* @return the description of this video clip
	*/
	@Override
	public java.lang.String getDescription() {
		return _videoClip.getDescription();
	}

	/**
	* Sets the description of this video clip.
	*
	* @param Description the description of this video clip
	*/
	@Override
	public void setDescription(java.lang.String Description) {
		_videoClip.setDescription(Description);
	}

	/**
	* Returns the image url of this video clip.
	*
	* @return the image url of this video clip
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _videoClip.getImageUrl();
	}

	/**
	* Sets the image url of this video clip.
	*
	* @param ImageUrl the image url of this video clip
	*/
	@Override
	public void setImageUrl(java.lang.String ImageUrl) {
		_videoClip.setImageUrl(ImageUrl);
	}

	/**
	* Returns the video url of this video clip.
	*
	* @return the video url of this video clip
	*/
	@Override
	public java.lang.String getVideoUrl() {
		return _videoClip.getVideoUrl();
	}

	/**
	* Sets the video url of this video clip.
	*
	* @param VideoUrl the video url of this video clip
	*/
	@Override
	public void setVideoUrl(java.lang.String VideoUrl) {
		_videoClip.setVideoUrl(VideoUrl);
	}

	/**
	* Returns the duration of this video clip.
	*
	* @return the duration of this video clip
	*/
	@Override
	public int getDuration() {
		return _videoClip.getDuration();
	}

	/**
	* Sets the duration of this video clip.
	*
	* @param Duration the duration of this video clip
	*/
	@Override
	public void setDuration(int Duration) {
		_videoClip.setDuration(Duration);
	}

	/**
	* Returns the view count of this video clip.
	*
	* @return the view count of this video clip
	*/
	@Override
	public int getViewCount() {
		return _videoClip.getViewCount();
	}

	/**
	* Sets the view count of this video clip.
	*
	* @param ViewCount the view count of this video clip
	*/
	@Override
	public void setViewCount(int ViewCount) {
		_videoClip.setViewCount(ViewCount);
	}

	/**
	* Returns the status of this video clip.
	*
	* @return the status of this video clip
	*/
	@Override
	public int getStatus() {
		return _videoClip.getStatus();
	}

	/**
	* Sets the status of this video clip.
	*
	* @param Status the status of this video clip
	*/
	@Override
	public void setStatus(int Status) {
		_videoClip.setStatus(Status);
	}

	/**
	* Returns the creation date of this video clip.
	*
	* @return the creation date of this video clip
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _videoClip.getCreationDate();
	}

	/**
	* Sets the creation date of this video clip.
	*
	* @param CreationDate the creation date of this video clip
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_videoClip.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this video clip.
	*
	* @return the modified date of this video clip
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _videoClip.getModifiedDate();
	}

	/**
	* Sets the modified date of this video clip.
	*
	* @param ModifiedDate the modified date of this video clip
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_videoClip.setModifiedDate(ModifiedDate);
	}

	@Override
	public boolean isNew() {
		return _videoClip.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_videoClip.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _videoClip.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_videoClip.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _videoClip.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _videoClip.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoClip.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoClip.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_videoClip.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_videoClip.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoClip.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoClipWrapper((VideoClip)_videoClip.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.videolibrary.model.VideoClip videoClip) {
		return _videoClip.compareTo(videoClip);
	}

	@Override
	public int hashCode() {
		return _videoClip.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.videolibrary.model.VideoClip> toCacheModel() {
		return _videoClip.toCacheModel();
	}

	@Override
	public com.viettel.portal.videolibrary.model.VideoClip toEscapedModel() {
		return new VideoClipWrapper(_videoClip.toEscapedModel());
	}

	@Override
	public com.viettel.portal.videolibrary.model.VideoClip toUnescapedModel() {
		return new VideoClipWrapper(_videoClip.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoClip.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _videoClip.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoClip.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoClipWrapper)) {
			return false;
		}

		VideoClipWrapper videoClipWrapper = (VideoClipWrapper)obj;

		if (Validator.equals(_videoClip, videoClipWrapper._videoClip)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VideoClip getWrappedVideoClip() {
		return _videoClip;
	}

	@Override
	public VideoClip getWrappedModel() {
		return _videoClip;
	}

	@Override
	public void resetOriginalValues() {
		_videoClip.resetOriginalValues();
	}

	private VideoClip _videoClip;
}