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
 * This class is a wrapper for {@link VLVideoTag}.
 * </p>
 *
 * @author ChucHV
 * @see VLVideoTag
 * @generated
 */
public class VLVideoTagWrapper implements VLVideoTag, ModelWrapper<VLVideoTag> {
	public VLVideoTagWrapper(VLVideoTag vlVideoTag) {
		_vlVideoTag = vlVideoTag;
	}

	@Override
	public Class<?> getModelClass() {
		return VLVideoTag.class;
	}

	@Override
	public String getModelClassName() {
		return VLVideoTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("tagId", getTagId());
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

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this v l video tag.
	*
	* @return the primary key of this v l video tag
	*/
	@Override
	public long getPrimaryKey() {
		return _vlVideoTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v l video tag.
	*
	* @param primaryKey the primary key of this v l video tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vlVideoTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this v l video tag.
	*
	* @return the ID of this v l video tag
	*/
	@Override
	public long getId() {
		return _vlVideoTag.getId();
	}

	/**
	* Sets the ID of this v l video tag.
	*
	* @param id the ID of this v l video tag
	*/
	@Override
	public void setId(long id) {
		_vlVideoTag.setId(id);
	}

	/**
	* Returns the video ID of this v l video tag.
	*
	* @return the video ID of this v l video tag
	*/
	@Override
	public long getVideoId() {
		return _vlVideoTag.getVideoId();
	}

	/**
	* Sets the video ID of this v l video tag.
	*
	* @param videoId the video ID of this v l video tag
	*/
	@Override
	public void setVideoId(long videoId) {
		_vlVideoTag.setVideoId(videoId);
	}

	/**
	* Returns the tag ID of this v l video tag.
	*
	* @return the tag ID of this v l video tag
	*/
	@Override
	public long getTagId() {
		return _vlVideoTag.getTagId();
	}

	/**
	* Sets the tag ID of this v l video tag.
	*
	* @param tagId the tag ID of this v l video tag
	*/
	@Override
	public void setTagId(long tagId) {
		_vlVideoTag.setTagId(tagId);
	}

	/**
	* Returns the group ID of this v l video tag.
	*
	* @return the group ID of this v l video tag
	*/
	@Override
	public long getGroupId() {
		return _vlVideoTag.getGroupId();
	}

	/**
	* Sets the group ID of this v l video tag.
	*
	* @param groupId the group ID of this v l video tag
	*/
	@Override
	public void setGroupId(long groupId) {
		_vlVideoTag.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _vlVideoTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vlVideoTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vlVideoTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vlVideoTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vlVideoTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vlVideoTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vlVideoTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vlVideoTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vlVideoTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vlVideoTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vlVideoTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VLVideoTagWrapper((VLVideoTag)_vlVideoTag.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.videolibrary.model.VLVideoTag vlVideoTag) {
		return _vlVideoTag.compareTo(vlVideoTag);
	}

	@Override
	public int hashCode() {
		return _vlVideoTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.videolibrary.model.VLVideoTag> toCacheModel() {
		return _vlVideoTag.toCacheModel();
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideoTag toEscapedModel() {
		return new VLVideoTagWrapper(_vlVideoTag.toEscapedModel());
	}

	@Override
	public com.viettel.portal.videolibrary.model.VLVideoTag toUnescapedModel() {
		return new VLVideoTagWrapper(_vlVideoTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vlVideoTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vlVideoTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vlVideoTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VLVideoTagWrapper)) {
			return false;
		}

		VLVideoTagWrapper vlVideoTagWrapper = (VLVideoTagWrapper)obj;

		if (Validator.equals(_vlVideoTag, vlVideoTagWrapper._vlVideoTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VLVideoTag getWrappedVLVideoTag() {
		return _vlVideoTag;
	}

	@Override
	public VLVideoTag getWrappedModel() {
		return _vlVideoTag;
	}

	@Override
	public void resetOriginalValues() {
		_vlVideoTag.resetOriginalValues();
	}

	private VLVideoTag _vlVideoTag;
}