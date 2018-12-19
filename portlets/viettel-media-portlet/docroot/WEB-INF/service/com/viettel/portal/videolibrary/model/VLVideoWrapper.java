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
 * This class is a wrapper for {@link VLVideo}.
 * </p>
 *
 * @author ChucHV
 * @see VLVideo
 * @generated
 */
public class VLVideoWrapper implements VLVideo, ModelWrapper<VLVideo> {
	public VLVideoWrapper(VLVideo vlVideo) {
		_vlVideo = vlVideo;
	}

	@Override
	public Class<?> getModelClass() {
		return VLVideo.class;
	}

	@Override
	public String getModelClassName() {
		return VLVideo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoId", getVideoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("videoName", getVideoName());
		attributes.put("description", getDescription());
		attributes.put("videoType", getVideoType());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("viewCount", getViewCount());
		attributes.put("fileId", getFileId());
		attributes.put("image", getImage());
		attributes.put("imageId", getImageId());
		attributes.put("smallImageUrl", getSmallImageUrl());
		attributes.put("relateId", getRelateId());
		attributes.put("invisible", getInvisible());
		attributes.put("categoryId", getCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String videoName = (String)attributes.get("videoName");

		if (videoName != null) {
			setVideoName(videoName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String videoType = (String)attributes.get("videoType");

		if (videoType != null) {
			setVideoType(videoType);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		Boolean image = (Boolean)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String smallImageUrl = (String)attributes.get("smallImageUrl");

		if (smallImageUrl != null) {
			setSmallImageUrl(smallImageUrl);
		}

		Long relateId = (Long)attributes.get("relateId");

		if (relateId != null) {
			setRelateId(relateId);
		}

		Boolean invisible = (Boolean)attributes.get("invisible");

		if (invisible != null) {
			setInvisible(invisible);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}
	}

	/**
	* Returns the primary key of this v l video.
	*
	* @return the primary key of this v l video
	*/
	@Override
	public long getPrimaryKey() {
		return _vlVideo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v l video.
	*
	* @param primaryKey the primary key of this v l video
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vlVideo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video ID of this v l video.
	*
	* @return the video ID of this v l video
	*/
	@Override
	public long getVideoId() {
		return _vlVideo.getVideoId();
	}

	/**
	* Sets the video ID of this v l video.
	*
	* @param videoId the video ID of this v l video
	*/
	@Override
	public void setVideoId(long videoId) {
		_vlVideo.setVideoId(videoId);
	}

	/**
	* Returns the group ID of this v l video.
	*
	* @return the group ID of this v l video
	*/
	@Override
	public long getGroupId() {
		return _vlVideo.getGroupId();
	}

	/**
	* Sets the group ID of this v l video.
	*
	* @param groupId the group ID of this v l video
	*/
	@Override
	public void setGroupId(long groupId) {
		_vlVideo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this v l video.
	*
	* @return the company ID of this v l video
	*/
	@Override
	public long getCompanyId() {
		return _vlVideo.getCompanyId();
	}

	/**
	* Sets the company ID of this v l video.
	*
	* @param companyId the company ID of this v l video
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vlVideo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this v l video.
	*
	* @return the user ID of this v l video
	*/
	@Override
	public long getUserId() {
		return _vlVideo.getUserId();
	}

	/**
	* Sets the user ID of this v l video.
	*
	* @param userId the user ID of this v l video
	*/
	@Override
	public void setUserId(long userId) {
		_vlVideo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v l video.
	*
	* @return the user uuid of this v l video
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vlVideo.getUserUuid();
	}

	/**
	* Sets the user uuid of this v l video.
	*
	* @param userUuid the user uuid of this v l video
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vlVideo.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this v l video.
	*
	* @return the user name of this v l video
	*/
	@Override
	public java.lang.String getUserName() {
		return _vlVideo.getUserName();
	}

	/**
	* Sets the user name of this v l video.
	*
	* @param userName the user name of this v l video
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vlVideo.setUserName(userName);
	}

	/**
	* Returns the create date of this v l video.
	*
	* @return the create date of this v l video
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vlVideo.getCreateDate();
	}

	/**
	* Sets the create date of this v l video.
	*
	* @param createDate the create date of this v l video
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vlVideo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this v l video.
	*
	* @return the modified date of this v l video
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vlVideo.getModifiedDate();
	}

	/**
	* Sets the modified date of this v l video.
	*
	* @param modifiedDate the modified date of this v l video
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vlVideo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the video name of this v l video.
	*
	* @return the video name of this v l video
	*/
	@Override
	public java.lang.String getVideoName() {
		return _vlVideo.getVideoName();
	}

	/**
	* Sets the video name of this v l video.
	*
	* @param videoName the video name of this v l video
	*/
	@Override
	public void setVideoName(java.lang.String videoName) {
		_vlVideo.setVideoName(videoName);
	}

	/**
	* Returns the description of this v l video.
	*
	* @return the description of this v l video
	*/
	@Override
	public java.lang.String getDescription() {
		return _vlVideo.getDescription();
	}

	/**
	* Sets the description of this v l video.
	*
	* @param description the description of this v l video
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vlVideo.setDescription(description);
	}

	/**
	* Returns the video type of this v l video.
	*
	* @return the video type of this v l video
	*/
	@Override
	public java.lang.String getVideoType() {
		return _vlVideo.getVideoType();
	}

	/**
	* Sets the video type of this v l video.
	*
	* @param videoType the video type of this v l video
	*/
	@Override
	public void setVideoType(java.lang.String videoType) {
		_vlVideo.setVideoType(videoType);
	}

	/**
	* Returns the video url of this v l video.
	*
	* @return the video url of this v l video
	*/
	@Override
	public java.lang.String getVideoUrl() {
		return _vlVideo.getVideoUrl();
	}

	/**
	* Sets the video url of this v l video.
	*
	* @param videoUrl the video url of this v l video
	*/
	@Override
	public void setVideoUrl(java.lang.String videoUrl) {
		_vlVideo.setVideoUrl(videoUrl);
	}

	/**
	* Returns the view count of this v l video.
	*
	* @return the view count of this v l video
	*/
	@Override
	public int getViewCount() {
		return _vlVideo.getViewCount();
	}

	/**
	* Sets the view count of this v l video.
	*
	* @param viewCount the view count of this v l video
	*/
	@Override
	public void setViewCount(int viewCount) {
		_vlVideo.setViewCount(viewCount);
	}

	/**
	* Returns the file ID of this v l video.
	*
	* @return the file ID of this v l video
	*/
	@Override
	public long getFileId() {
		return _vlVideo.getFileId();
	}

	/**
	* Sets the file ID of this v l video.
	*
	* @param fileId the file ID of this v l video
	*/
	@Override
	public void setFileId(long fileId) {
		_vlVideo.setFileId(fileId);
	}

	/**
	* Returns the image of this v l video.
	*
	* @return the image of this v l video
	*/
	@Override
	public boolean getImage() {
		return _vlVideo.getImage();
	}

	/**
	* Returns <code>true</code> if this v l video is image.
	*
	* @return <code>true</code> if this v l video is image; <code>false</code> otherwise
	*/
	@Override
	public boolean isImage() {
		return _vlVideo.isImage();
	}

	/**
	* Sets whether this v l video is image.
	*
	* @param image the image of this v l video
	*/
	@Override
	public void setImage(boolean image) {
		_vlVideo.setImage(image);
	}

	/**
	* Returns the image ID of this v l video.
	*
	* @return the image ID of this v l video
	*/
	@Override
	public long getImageId() {
		return _vlVideo.getImageId();
	}

	/**
	* Sets the image ID of this v l video.
	*
	* @param imageId the image ID of this v l video
	*/
	@Override
	public void setImageId(long imageId) {
		_vlVideo.setImageId(imageId);
	}

	/**
	* Returns the small image url of this v l video.
	*
	* @return the small image url of this v l video
	*/
	@Override
	public java.lang.String getSmallImageUrl() {
		return _vlVideo.getSmallImageUrl();
	}

	/**
	* Sets the small image url of this v l video.
	*
	* @param smallImageUrl the small image url of this v l video
	*/
	@Override
	public void setSmallImageUrl(java.lang.String smallImageUrl) {
		_vlVideo.setSmallImageUrl(smallImageUrl);
	}

	/**
	* Returns the relate ID of this v l video.
	*
	* @return the relate ID of this v l video
	*/
	@Override
	public long getRelateId() {
		return _vlVideo.getRelateId();
	}

	/**
	* Sets the relate ID of this v l video.
	*
	* @param relateId the relate ID of this v l video
	*/
	@Override
	public void setRelateId(long relateId) {
		_vlVideo.setRelateId(relateId);
	}

	/**
	* Returns the invisible of this v l video.
	*
	* @return the invisible of this v l video
	*/
	@Override
	public boolean getInvisible() {
		return _vlVideo.getInvisible();
	}

	/**
	* Returns <code>true</code> if this v l video is invisible.
	*
	* @return <code>true</code> if this v l video is invisible; <code>false</code> otherwise
	*/
	@Override
	public boolean isInvisible() {
		return _vlVideo.isInvisible();
	}

	/**
	* Sets whether this v l video is invisible.
	*
	* @param invisible the invisible of this v l video
	*/
	@Override
	public void setInvisible(boolean invisible) {
		_vlVideo.setInvisible(invisible);
	}

	/**
	* Returns the category ID of this v l video.
	*
	* @return the category ID of this v l video
	*/
	@Override
	public long getCategoryId() {
		return _vlVideo.getCategoryId();
	}

	/**
	* Sets the category ID of this v l video.
	*
	* @param categoryId the category ID of this v l video
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_vlVideo.setCategoryId(categoryId);
	}

	@Override
	public boolean isNew() {
		return _vlVideo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vlVideo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vlVideo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vlVideo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vlVideo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vlVideo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vlVideo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vlVideo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vlVideo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vlVideo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vlVideo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLVideoWrapper((VLVideo)_vlVideo.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.videolibrary.model.VLVideo vlVideo) {
		return _vlVideo.compareTo(vlVideo);
	}

	@Override
	public int hashCode() {
		return _vlVideo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.videolibrary.model.VLVideo> toCacheModel() {
		return _vlVideo.toCacheModel();
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo toEscapedModel() {
		return new VLVideoWrapper(_vlVideo.toEscapedModel());
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideo toUnescapedModel() {
		return new VLVideoWrapper(_vlVideo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vlVideo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vlVideo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlVideo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLVideoWrapper)) {
			return false;
		}

		VLVideoWrapper vlVideoWrapper = (VLVideoWrapper)obj;

		if (Validator.equals(_vlVideo, vlVideoWrapper._vlVideo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLVideo getWrappedVLVideo() {
		return _vlVideo;
	}

	@Override
	public VLVideo getWrappedModel() {
		return _vlVideo;
	}

	@Override
	public void resetOriginalValues() {
		_vlVideo.resetOriginalValues();
	}

	private VLVideo _vlVideo;
}