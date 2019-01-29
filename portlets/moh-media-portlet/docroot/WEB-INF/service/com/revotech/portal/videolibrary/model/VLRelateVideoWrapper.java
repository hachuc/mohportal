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
 * This class is a wrapper for {@link VLRelateVideo}.
 * </p>
 *
 * @author ChucHV
 * @see VLRelateVideo
 * @generated
 */
public class VLRelateVideoWrapper implements VLRelateVideo,
	ModelWrapper<VLRelateVideo> {
	public VLRelateVideoWrapper(VLRelateVideo vlRelateVideo) {
		_vlRelateVideo = vlRelateVideo;
	}

	@Override
	public Class<?> getModelClass() {
		return VLRelateVideo.class;
	}

	@Override
	public String getModelClassName() {
		return VLRelateVideo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("relateId", getRelateId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long relateId = (Long)attributes.get("relateId");

		if (relateId != null) {
			setRelateId(relateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this v l relate video.
	*
	* @return the primary key of this v l relate video
	*/
	@Override
	public long getPrimaryKey() {
		return _vlRelateVideo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v l relate video.
	*
	* @param primaryKey the primary key of this v l relate video
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vlRelateVideo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this v l relate video.
	*
	* @return the ID of this v l relate video
	*/
	@Override
	public long getId() {
		return _vlRelateVideo.getId();
	}

	/**
	* Sets the ID of this v l relate video.
	*
	* @param id the ID of this v l relate video
	*/
	@Override
	public void setId(long id) {
		_vlRelateVideo.setId(id);
	}

	/**
	* Returns the video ID of this v l relate video.
	*
	* @return the video ID of this v l relate video
	*/
	@Override
	public long getVideoId() {
		return _vlRelateVideo.getVideoId();
	}

	/**
	* Sets the video ID of this v l relate video.
	*
	* @param videoId the video ID of this v l relate video
	*/
	@Override
	public void setVideoId(long videoId) {
		_vlRelateVideo.setVideoId(videoId);
	}

	/**
	* Returns the relate ID of this v l relate video.
	*
	* @return the relate ID of this v l relate video
	*/
	@Override
	public long getRelateId() {
		return _vlRelateVideo.getRelateId();
	}

	/**
	* Sets the relate ID of this v l relate video.
	*
	* @param relateId the relate ID of this v l relate video
	*/
	@Override
	public void setRelateId(long relateId) {
		_vlRelateVideo.setRelateId(relateId);
	}

	/**
	* Returns the group ID of this v l relate video.
	*
	* @return the group ID of this v l relate video
	*/
	@Override
	public long getGroupId() {
		return _vlRelateVideo.getGroupId();
	}

	/**
	* Sets the group ID of this v l relate video.
	*
	* @param groupId the group ID of this v l relate video
	*/
	@Override
	public void setGroupId(long groupId) {
		_vlRelateVideo.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _vlRelateVideo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vlRelateVideo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vlRelateVideo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vlRelateVideo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vlRelateVideo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vlRelateVideo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vlRelateVideo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vlRelateVideo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vlRelateVideo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vlRelateVideo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vlRelateVideo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLRelateVideoWrapper((VLRelateVideo)_vlRelateVideo.clone());
	}

	@Override
	public int compareTo(
		com.revotech.portal.videolibrary.model.VLRelateVideo vlRelateVideo) {
		return _vlRelateVideo.compareTo(vlRelateVideo);
	}

	@Override
	public int hashCode() {
		return _vlRelateVideo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.videolibrary.model.VLRelateVideo> toCacheModel() {
		return _vlRelateVideo.toCacheModel();
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo toEscapedModel() {
		return new VLRelateVideoWrapper(_vlRelateVideo.toEscapedModel());
	}

	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo toUnescapedModel() {
		return new VLRelateVideoWrapper(_vlRelateVideo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vlRelateVideo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vlRelateVideo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlRelateVideo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLRelateVideoWrapper)) {
			return false;
		}

		VLRelateVideoWrapper vlRelateVideoWrapper = (VLRelateVideoWrapper)obj;

		if (Validator.equals(_vlRelateVideo, vlRelateVideoWrapper._vlRelateVideo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLRelateVideo getWrappedVLRelateVideo() {
		return _vlRelateVideo;
	}

	@Override
	public VLRelateVideo getWrappedModel() {
		return _vlRelateVideo;
	}

	@Override
	public void resetOriginalValues() {
		_vlRelateVideo.resetOriginalValues();
	}

	private VLRelateVideo _vlRelateVideo;
}