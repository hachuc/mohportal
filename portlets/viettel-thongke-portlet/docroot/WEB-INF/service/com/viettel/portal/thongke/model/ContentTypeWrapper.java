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
 * This class is a wrapper for {@link ContentType}.
 * </p>
 *
 * @author lamvn
 * @see ContentType
 * @generated
 */
public class ContentTypeWrapper implements ContentType,
	ModelWrapper<ContentType> {
	public ContentTypeWrapper(ContentType contentType) {
		_contentType = contentType;
	}

	@Override
	public Class<?> getModelClass() {
		return ContentType.class;
	}

	@Override
	public String getModelClassName() {
		return ContentType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contenTypeId", getContenTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("sortOrder", getSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer contenTypeId = (Integer)attributes.get("contenTypeId");

		if (contenTypeId != null) {
			setContenTypeId(contenTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer sortOrder = (Integer)attributes.get("sortOrder");

		if (sortOrder != null) {
			setSortOrder(sortOrder);
		}
	}

	/**
	* Returns the primary key of this content type.
	*
	* @return the primary key of this content type
	*/
	@Override
	public int getPrimaryKey() {
		return _contentType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content type.
	*
	* @param primaryKey the primary key of this content type
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_contentType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the conten type ID of this content type.
	*
	* @return the conten type ID of this content type
	*/
	@Override
	public int getContenTypeId() {
		return _contentType.getContenTypeId();
	}

	/**
	* Sets the conten type ID of this content type.
	*
	* @param contenTypeId the conten type ID of this content type
	*/
	@Override
	public void setContenTypeId(int contenTypeId) {
		_contentType.setContenTypeId(contenTypeId);
	}

	/**
	* Returns the group ID of this content type.
	*
	* @return the group ID of this content type
	*/
	@Override
	public long getGroupId() {
		return _contentType.getGroupId();
	}

	/**
	* Sets the group ID of this content type.
	*
	* @param groupId the group ID of this content type
	*/
	@Override
	public void setGroupId(long groupId) {
		_contentType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this content type.
	*
	* @return the company ID of this content type
	*/
	@Override
	public long getCompanyId() {
		return _contentType.getCompanyId();
	}

	/**
	* Sets the company ID of this content type.
	*
	* @param companyId the company ID of this content type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contentType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this content type.
	*
	* @return the user ID of this content type
	*/
	@Override
	public long getUserId() {
		return _contentType.getUserId();
	}

	/**
	* Sets the user ID of this content type.
	*
	* @param userId the user ID of this content type
	*/
	@Override
	public void setUserId(long userId) {
		_contentType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this content type.
	*
	* @return the user uuid of this content type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentType.getUserUuid();
	}

	/**
	* Sets the user uuid of this content type.
	*
	* @param userUuid the user uuid of this content type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_contentType.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this content type.
	*
	* @return the name of this content type
	*/
	@Override
	public java.lang.String getName() {
		return _contentType.getName();
	}

	/**
	* Sets the name of this content type.
	*
	* @param name the name of this content type
	*/
	@Override
	public void setName(java.lang.String name) {
		_contentType.setName(name);
	}

	/**
	* Returns the description of this content type.
	*
	* @return the description of this content type
	*/
	@Override
	public java.lang.String getDescription() {
		return _contentType.getDescription();
	}

	/**
	* Sets the description of this content type.
	*
	* @param description the description of this content type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_contentType.setDescription(description);
	}

	/**
	* Returns the sort order of this content type.
	*
	* @return the sort order of this content type
	*/
	@Override
	public int getSortOrder() {
		return _contentType.getSortOrder();
	}

	/**
	* Sets the sort order of this content type.
	*
	* @param sortOrder the sort order of this content type
	*/
	@Override
	public void setSortOrder(int sortOrder) {
		_contentType.setSortOrder(sortOrder);
	}

	@Override
	public boolean isNew() {
		return _contentType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contentType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contentType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contentType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contentType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contentType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contentType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contentType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contentType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contentType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contentType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentTypeWrapper((ContentType)_contentType.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.thongke.model.ContentType contentType) {
		return _contentType.compareTo(contentType);
	}

	@Override
	public int hashCode() {
		return _contentType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.thongke.model.ContentType> toCacheModel() {
		return _contentType.toCacheModel();
	}

	@Override
	public com.viettel.portal.thongke.model.ContentType toEscapedModel() {
		return new ContentTypeWrapper(_contentType.toEscapedModel());
	}

	@Override
	public com.viettel.portal.thongke.model.ContentType toUnescapedModel() {
		return new ContentTypeWrapper(_contentType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contentType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contentType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentTypeWrapper)) {
			return false;
		}

		ContentTypeWrapper contentTypeWrapper = (ContentTypeWrapper)obj;

		if (Validator.equals(_contentType, contentTypeWrapper._contentType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContentType getWrappedContentType() {
		return _contentType;
	}

	@Override
	public ContentType getWrappedModel() {
		return _contentType;
	}

	@Override
	public void resetOriginalValues() {
		_contentType.resetOriginalValues();
	}

	private ContentType _contentType;
}