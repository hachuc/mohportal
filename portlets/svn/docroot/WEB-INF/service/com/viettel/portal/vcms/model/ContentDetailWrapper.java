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

package com.viettel.portal.vcms.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ContentDetail}.
 * </p>
 *
 * @author chuchv
 * @see ContentDetail
 * @generated
 */
public class ContentDetailWrapper implements ContentDetail,
	ModelWrapper<ContentDetail> {
	public ContentDetailWrapper(ContentDetail contentDetail) {
		_contentDetail = contentDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return ContentDetail.class;
	}

	@Override
	public String getModelClassName() {
		return ContentDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("autoId", getAutoId());
		attributes.put("contentId", getContentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("version", getVersion());
		attributes.put("subTitle", getSubTitle());
		attributes.put("title", getTitle());
		attributes.put("summary", getSummary());
		attributes.put("subContent", getSubContent());
		attributes.put("content", getContent());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("smallImageUrl", getSmallImageUrl());
		attributes.put("categoryId", getCategoryId());
		attributes.put("status", getStatus());
		attributes.put("newsType", getNewsType());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("isLegalContent", getIsLegalContent());
		attributes.put("imageCaption", getImageCaption());
		attributes.put("imagePosition", getImagePosition());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long autoId = (Long)attributes.get("autoId");

		if (autoId != null) {
			setAutoId(autoId);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
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

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String subTitle = (String)attributes.get("subTitle");

		if (subTitle != null) {
			setSubTitle(subTitle);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String subContent = (String)attributes.get("subContent");

		if (subContent != null) {
			setSubContent(subContent);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long smallImageId = (Long)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		String smallImageUrl = (String)attributes.get("smallImageUrl");

		if (smallImageUrl != null) {
			setSmallImageUrl(smallImageUrl);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer newsType = (Integer)attributes.get("newsType");

		if (newsType != null) {
			setNewsType(newsType);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		Boolean isLegalContent = (Boolean)attributes.get("isLegalContent");

		if (isLegalContent != null) {
			setIsLegalContent(isLegalContent);
		}

		String imageCaption = (String)attributes.get("imageCaption");

		if (imageCaption != null) {
			setImageCaption(imageCaption);
		}

		Integer imagePosition = (Integer)attributes.get("imagePosition");

		if (imagePosition != null) {
			setImagePosition(imagePosition);
		}
	}

	/**
	* Returns the primary key of this content detail.
	*
	* @return the primary key of this content detail
	*/
	@Override
	public long getPrimaryKey() {
		return _contentDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content detail.
	*
	* @param primaryKey the primary key of this content detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contentDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the auto ID of this content detail.
	*
	* @return the auto ID of this content detail
	*/
	@Override
	public long getAutoId() {
		return _contentDetail.getAutoId();
	}

	/**
	* Sets the auto ID of this content detail.
	*
	* @param autoId the auto ID of this content detail
	*/
	@Override
	public void setAutoId(long autoId) {
		_contentDetail.setAutoId(autoId);
	}

	/**
	* Returns the content ID of this content detail.
	*
	* @return the content ID of this content detail
	*/
	@Override
	public long getContentId() {
		return _contentDetail.getContentId();
	}

	/**
	* Sets the content ID of this content detail.
	*
	* @param contentId the content ID of this content detail
	*/
	@Override
	public void setContentId(long contentId) {
		_contentDetail.setContentId(contentId);
	}

	/**
	* Returns the group ID of this content detail.
	*
	* @return the group ID of this content detail
	*/
	@Override
	public long getGroupId() {
		return _contentDetail.getGroupId();
	}

	/**
	* Sets the group ID of this content detail.
	*
	* @param groupId the group ID of this content detail
	*/
	@Override
	public void setGroupId(long groupId) {
		_contentDetail.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this content detail.
	*
	* @return the company ID of this content detail
	*/
	@Override
	public long getCompanyId() {
		return _contentDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this content detail.
	*
	* @param companyId the company ID of this content detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contentDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this content detail.
	*
	* @return the user ID of this content detail
	*/
	@Override
	public long getUserId() {
		return _contentDetail.getUserId();
	}

	/**
	* Sets the user ID of this content detail.
	*
	* @param userId the user ID of this content detail
	*/
	@Override
	public void setUserId(long userId) {
		_contentDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this content detail.
	*
	* @return the user uuid of this content detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this content detail.
	*
	* @param userUuid the user uuid of this content detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_contentDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this content detail.
	*
	* @return the user name of this content detail
	*/
	@Override
	public java.lang.String getUserName() {
		return _contentDetail.getUserName();
	}

	/**
	* Sets the user name of this content detail.
	*
	* @param userName the user name of this content detail
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_contentDetail.setUserName(userName);
	}

	/**
	* Returns the create date of this content detail.
	*
	* @return the create date of this content detail
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contentDetail.getCreateDate();
	}

	/**
	* Sets the create date of this content detail.
	*
	* @param createDate the create date of this content detail
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contentDetail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this content detail.
	*
	* @return the modified date of this content detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contentDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this content detail.
	*
	* @param modifiedDate the modified date of this content detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contentDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the version of this content detail.
	*
	* @return the version of this content detail
	*/
	@Override
	public int getVersion() {
		return _contentDetail.getVersion();
	}

	/**
	* Sets the version of this content detail.
	*
	* @param version the version of this content detail
	*/
	@Override
	public void setVersion(int version) {
		_contentDetail.setVersion(version);
	}

	/**
	* Returns the sub title of this content detail.
	*
	* @return the sub title of this content detail
	*/
	@Override
	public java.lang.String getSubTitle() {
		return _contentDetail.getSubTitle();
	}

	/**
	* Sets the sub title of this content detail.
	*
	* @param subTitle the sub title of this content detail
	*/
	@Override
	public void setSubTitle(java.lang.String subTitle) {
		_contentDetail.setSubTitle(subTitle);
	}

	/**
	* Returns the title of this content detail.
	*
	* @return the title of this content detail
	*/
	@Override
	public java.lang.String getTitle() {
		return _contentDetail.getTitle();
	}

	/**
	* Sets the title of this content detail.
	*
	* @param title the title of this content detail
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_contentDetail.setTitle(title);
	}

	/**
	* Returns the summary of this content detail.
	*
	* @return the summary of this content detail
	*/
	@Override
	public java.lang.String getSummary() {
		return _contentDetail.getSummary();
	}

	/**
	* Sets the summary of this content detail.
	*
	* @param summary the summary of this content detail
	*/
	@Override
	public void setSummary(java.lang.String summary) {
		_contentDetail.setSummary(summary);
	}

	/**
	* Returns the sub content of this content detail.
	*
	* @return the sub content of this content detail
	*/
	@Override
	public java.lang.String getSubContent() {
		return _contentDetail.getSubContent();
	}

	/**
	* Sets the sub content of this content detail.
	*
	* @param subContent the sub content of this content detail
	*/
	@Override
	public void setSubContent(java.lang.String subContent) {
		_contentDetail.setSubContent(subContent);
	}

	/**
	* Returns the content of this content detail.
	*
	* @return the content of this content detail
	*/
	@Override
	public java.lang.String getContent() {
		return _contentDetail.getContent();
	}

	/**
	* Sets the content of this content detail.
	*
	* @param content the content of this content detail
	*/
	@Override
	public void setContent(java.lang.String content) {
		_contentDetail.setContent(content);
	}

	/**
	* Returns the small image ID of this content detail.
	*
	* @return the small image ID of this content detail
	*/
	@Override
	public long getSmallImageId() {
		return _contentDetail.getSmallImageId();
	}

	/**
	* Sets the small image ID of this content detail.
	*
	* @param smallImageId the small image ID of this content detail
	*/
	@Override
	public void setSmallImageId(long smallImageId) {
		_contentDetail.setSmallImageId(smallImageId);
	}

	/**
	* Returns the small image url of this content detail.
	*
	* @return the small image url of this content detail
	*/
	@Override
	public java.lang.String getSmallImageUrl() {
		return _contentDetail.getSmallImageUrl();
	}

	/**
	* Sets the small image url of this content detail.
	*
	* @param smallImageUrl the small image url of this content detail
	*/
	@Override
	public void setSmallImageUrl(java.lang.String smallImageUrl) {
		_contentDetail.setSmallImageUrl(smallImageUrl);
	}

	/**
	* Returns the category ID of this content detail.
	*
	* @return the category ID of this content detail
	*/
	@Override
	public long getCategoryId() {
		return _contentDetail.getCategoryId();
	}

	/**
	* Sets the category ID of this content detail.
	*
	* @param categoryId the category ID of this content detail
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_contentDetail.setCategoryId(categoryId);
	}

	/**
	* Returns the status of this content detail.
	*
	* @return the status of this content detail
	*/
	@Override
	public int getStatus() {
		return _contentDetail.getStatus();
	}

	/**
	* Sets the status of this content detail.
	*
	* @param status the status of this content detail
	*/
	@Override
	public void setStatus(int status) {
		_contentDetail.setStatus(status);
	}

	/**
	* Returns the news type of this content detail.
	*
	* @return the news type of this content detail
	*/
	@Override
	public int getNewsType() {
		return _contentDetail.getNewsType();
	}

	/**
	* Sets the news type of this content detail.
	*
	* @param newsType the news type of this content detail
	*/
	@Override
	public void setNewsType(int newsType) {
		_contentDetail.setNewsType(newsType);
	}

	/**
	* Returns the image url of this content detail.
	*
	* @return the image url of this content detail
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _contentDetail.getImageUrl();
	}

	/**
	* Sets the image url of this content detail.
	*
	* @param imageUrl the image url of this content detail
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_contentDetail.setImageUrl(imageUrl);
	}

	/**
	* Returns the is legal content of this content detail.
	*
	* @return the is legal content of this content detail
	*/
	@Override
	public boolean getIsLegalContent() {
		return _contentDetail.getIsLegalContent();
	}

	/**
	* Returns <code>true</code> if this content detail is is legal content.
	*
	* @return <code>true</code> if this content detail is is legal content; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsLegalContent() {
		return _contentDetail.isIsLegalContent();
	}

	/**
	* Sets whether this content detail is is legal content.
	*
	* @param isLegalContent the is legal content of this content detail
	*/
	@Override
	public void setIsLegalContent(boolean isLegalContent) {
		_contentDetail.setIsLegalContent(isLegalContent);
	}

	/**
	* Returns the image caption of this content detail.
	*
	* @return the image caption of this content detail
	*/
	@Override
	public java.lang.String getImageCaption() {
		return _contentDetail.getImageCaption();
	}

	/**
	* Sets the image caption of this content detail.
	*
	* @param imageCaption the image caption of this content detail
	*/
	@Override
	public void setImageCaption(java.lang.String imageCaption) {
		_contentDetail.setImageCaption(imageCaption);
	}

	/**
	* Returns the image position of this content detail.
	*
	* @return the image position of this content detail
	*/
	@Override
	public int getImagePosition() {
		return _contentDetail.getImagePosition();
	}

	/**
	* Sets the image position of this content detail.
	*
	* @param imagePosition the image position of this content detail
	*/
	@Override
	public void setImagePosition(int imagePosition) {
		_contentDetail.setImagePosition(imagePosition);
	}

	@Override
	public boolean isNew() {
		return _contentDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contentDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contentDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contentDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contentDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contentDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contentDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contentDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contentDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contentDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contentDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentDetailWrapper((ContentDetail)_contentDetail.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.ContentDetail contentDetail) {
		return _contentDetail.compareTo(contentDetail);
	}

	@Override
	public int hashCode() {
		return _contentDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.ContentDetail> toCacheModel() {
		return _contentDetail.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.ContentDetail toEscapedModel() {
		return new ContentDetailWrapper(_contentDetail.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.ContentDetail toUnescapedModel() {
		return new ContentDetailWrapper(_contentDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contentDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contentDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentDetailWrapper)) {
			return false;
		}

		ContentDetailWrapper contentDetailWrapper = (ContentDetailWrapper)obj;

		if (Validator.equals(_contentDetail, contentDetailWrapper._contentDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContentDetail getWrappedContentDetail() {
		return _contentDetail;
	}

	@Override
	public ContentDetail getWrappedModel() {
		return _contentDetail;
	}

	@Override
	public void resetOriginalValues() {
		_contentDetail.resetOriginalValues();
	}

	private ContentDetail _contentDetail;
}