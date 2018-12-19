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
 * This class is a wrapper for {@link Content}.
 * </p>
 *
 * @author chuchv
 * @see Content
 * @generated
 */
public class ContentWrapper implements Content, ModelWrapper<Content> {
	public ContentWrapper(Content content) {
		_content = content;
	}

	@Override
	public Class<?> getModelClass() {
		return Content.class;
	}

	@Override
	public String getModelClassName() {
		return Content.class.getName();
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
		attributes.put("preVersion", getPreVersion());
		attributes.put("version", getVersion());
		attributes.put("subTitle", getSubTitle());
		attributes.put("title", getTitle());
		attributes.put("summary", getSummary());
		attributes.put("subContent", getSubContent());
		attributes.put("content", getContent());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("smallImageUrl", getSmallImageUrl());
		attributes.put("categoryId", getCategoryId());
		attributes.put("copyRight", getCopyRight());
		attributes.put("status", getStatus());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("newsType", getNewsType());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("isLegalContent", getIsLegalContent());
		attributes.put("imageCaption", getImageCaption());
		attributes.put("imagePosition", getImagePosition());
		attributes.put("createdByUserId", getCreatedByUserId());
		attributes.put("editedByUserId", getEditedByUserId());
		attributes.put("reviewedByUserId", getReviewedByUserId());
		attributes.put("publishedByUserId", getPublishedByUserId());
		attributes.put("createdByUserName", getCreatedByUserName());
		attributes.put("editedByUserName", getEditedByUserName());
		attributes.put("reviewedByUserName", getReviewedByUserName());
		attributes.put("publishedByUserName", getPublishedByUserName());
		attributes.put("author", getAuthor());
		attributes.put("jobTitle", getJobTitle());

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

		Integer preVersion = (Integer)attributes.get("preVersion");

		if (preVersion != null) {
			setPreVersion(preVersion);
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

		String copyRight = (String)attributes.get("copyRight");

		if (copyRight != null) {
			setCopyRight(copyRight);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
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

		Long createdByUserId = (Long)attributes.get("createdByUserId");

		if (createdByUserId != null) {
			setCreatedByUserId(createdByUserId);
		}

		Long editedByUserId = (Long)attributes.get("editedByUserId");

		if (editedByUserId != null) {
			setEditedByUserId(editedByUserId);
		}

		Long reviewedByUserId = (Long)attributes.get("reviewedByUserId");

		if (reviewedByUserId != null) {
			setReviewedByUserId(reviewedByUserId);
		}

		Long publishedByUserId = (Long)attributes.get("publishedByUserId");

		if (publishedByUserId != null) {
			setPublishedByUserId(publishedByUserId);
		}

		String createdByUserName = (String)attributes.get("createdByUserName");

		if (createdByUserName != null) {
			setCreatedByUserName(createdByUserName);
		}

		String editedByUserName = (String)attributes.get("editedByUserName");

		if (editedByUserName != null) {
			setEditedByUserName(editedByUserName);
		}

		String reviewedByUserName = (String)attributes.get("reviewedByUserName");

		if (reviewedByUserName != null) {
			setReviewedByUserName(reviewedByUserName);
		}

		String publishedByUserName = (String)attributes.get(
				"publishedByUserName");

		if (publishedByUserName != null) {
			setPublishedByUserName(publishedByUserName);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}
	}

	/**
	* Returns the primary key of this content.
	*
	* @return the primary key of this content
	*/
	@Override
	public long getPrimaryKey() {
		return _content.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content.
	*
	* @param primaryKey the primary key of this content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_content.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the auto ID of this content.
	*
	* @return the auto ID of this content
	*/
	@Override
	public long getAutoId() {
		return _content.getAutoId();
	}

	/**
	* Sets the auto ID of this content.
	*
	* @param autoId the auto ID of this content
	*/
	@Override
	public void setAutoId(long autoId) {
		_content.setAutoId(autoId);
	}

	/**
	* Returns the content ID of this content.
	*
	* @return the content ID of this content
	*/
	@Override
	public long getContentId() {
		return _content.getContentId();
	}

	/**
	* Sets the content ID of this content.
	*
	* @param contentId the content ID of this content
	*/
	@Override
	public void setContentId(long contentId) {
		_content.setContentId(contentId);
	}

	/**
	* Returns the group ID of this content.
	*
	* @return the group ID of this content
	*/
	@Override
	public long getGroupId() {
		return _content.getGroupId();
	}

	/**
	* Sets the group ID of this content.
	*
	* @param groupId the group ID of this content
	*/
	@Override
	public void setGroupId(long groupId) {
		_content.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this content.
	*
	* @return the company ID of this content
	*/
	@Override
	public long getCompanyId() {
		return _content.getCompanyId();
	}

	/**
	* Sets the company ID of this content.
	*
	* @param companyId the company ID of this content
	*/
	@Override
	public void setCompanyId(long companyId) {
		_content.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this content.
	*
	* @return the user ID of this content
	*/
	@Override
	public long getUserId() {
		return _content.getUserId();
	}

	/**
	* Sets the user ID of this content.
	*
	* @param userId the user ID of this content
	*/
	@Override
	public void setUserId(long userId) {
		_content.setUserId(userId);
	}

	/**
	* Returns the user uuid of this content.
	*
	* @return the user uuid of this content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _content.getUserUuid();
	}

	/**
	* Sets the user uuid of this content.
	*
	* @param userUuid the user uuid of this content
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_content.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this content.
	*
	* @return the user name of this content
	*/
	@Override
	public java.lang.String getUserName() {
		return _content.getUserName();
	}

	/**
	* Sets the user name of this content.
	*
	* @param userName the user name of this content
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_content.setUserName(userName);
	}

	/**
	* Returns the create date of this content.
	*
	* @return the create date of this content
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _content.getCreateDate();
	}

	/**
	* Sets the create date of this content.
	*
	* @param createDate the create date of this content
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_content.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this content.
	*
	* @return the modified date of this content
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _content.getModifiedDate();
	}

	/**
	* Sets the modified date of this content.
	*
	* @param modifiedDate the modified date of this content
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_content.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the pre version of this content.
	*
	* @return the pre version of this content
	*/
	@Override
	public int getPreVersion() {
		return _content.getPreVersion();
	}

	/**
	* Sets the pre version of this content.
	*
	* @param preVersion the pre version of this content
	*/
	@Override
	public void setPreVersion(int preVersion) {
		_content.setPreVersion(preVersion);
	}

	/**
	* Returns the version of this content.
	*
	* @return the version of this content
	*/
	@Override
	public int getVersion() {
		return _content.getVersion();
	}

	/**
	* Sets the version of this content.
	*
	* @param version the version of this content
	*/
	@Override
	public void setVersion(int version) {
		_content.setVersion(version);
	}

	/**
	* Returns the sub title of this content.
	*
	* @return the sub title of this content
	*/
	@Override
	public java.lang.String getSubTitle() {
		return _content.getSubTitle();
	}

	/**
	* Sets the sub title of this content.
	*
	* @param subTitle the sub title of this content
	*/
	@Override
	public void setSubTitle(java.lang.String subTitle) {
		_content.setSubTitle(subTitle);
	}

	/**
	* Returns the title of this content.
	*
	* @return the title of this content
	*/
	@Override
	public java.lang.String getTitle() {
		return _content.getTitle();
	}

	/**
	* Sets the title of this content.
	*
	* @param title the title of this content
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_content.setTitle(title);
	}

	/**
	* Returns the summary of this content.
	*
	* @return the summary of this content
	*/
	@Override
	public java.lang.String getSummary() {
		return _content.getSummary();
	}

	/**
	* Sets the summary of this content.
	*
	* @param summary the summary of this content
	*/
	@Override
	public void setSummary(java.lang.String summary) {
		_content.setSummary(summary);
	}

	/**
	* Returns the sub content of this content.
	*
	* @return the sub content of this content
	*/
	@Override
	public java.lang.String getSubContent() {
		return _content.getSubContent();
	}

	/**
	* Sets the sub content of this content.
	*
	* @param subContent the sub content of this content
	*/
	@Override
	public void setSubContent(java.lang.String subContent) {
		_content.setSubContent(subContent);
	}

	/**
	* Returns the content of this content.
	*
	* @return the content of this content
	*/
	@Override
	public java.lang.String getContent() {
		return _content.getContent();
	}

	/**
	* Sets the content of this content.
	*
	* @param content the content of this content
	*/
	@Override
	public void setContent(java.lang.String content) {
		_content.setContent(content);
	}

	/**
	* Returns the small image ID of this content.
	*
	* @return the small image ID of this content
	*/
	@Override
	public long getSmallImageId() {
		return _content.getSmallImageId();
	}

	/**
	* Sets the small image ID of this content.
	*
	* @param smallImageId the small image ID of this content
	*/
	@Override
	public void setSmallImageId(long smallImageId) {
		_content.setSmallImageId(smallImageId);
	}

	/**
	* Returns the small image url of this content.
	*
	* @return the small image url of this content
	*/
	@Override
	public java.lang.String getSmallImageUrl() {
		return _content.getSmallImageUrl();
	}

	/**
	* Sets the small image url of this content.
	*
	* @param smallImageUrl the small image url of this content
	*/
	@Override
	public void setSmallImageUrl(java.lang.String smallImageUrl) {
		_content.setSmallImageUrl(smallImageUrl);
	}

	/**
	* Returns the category ID of this content.
	*
	* @return the category ID of this content
	*/
	@Override
	public long getCategoryId() {
		return _content.getCategoryId();
	}

	/**
	* Sets the category ID of this content.
	*
	* @param categoryId the category ID of this content
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_content.setCategoryId(categoryId);
	}

	/**
	* Returns the copy right of this content.
	*
	* @return the copy right of this content
	*/
	@Override
	public java.lang.String getCopyRight() {
		return _content.getCopyRight();
	}

	/**
	* Sets the copy right of this content.
	*
	* @param copyRight the copy right of this content
	*/
	@Override
	public void setCopyRight(java.lang.String copyRight) {
		_content.setCopyRight(copyRight);
	}

	/**
	* Returns the status of this content.
	*
	* @return the status of this content
	*/
	@Override
	public int getStatus() {
		return _content.getStatus();
	}

	/**
	* Sets the status of this content.
	*
	* @param status the status of this content
	*/
	@Override
	public void setStatus(int status) {
		_content.setStatus(status);
	}

	/**
	* Returns the url title of this content.
	*
	* @return the url title of this content
	*/
	@Override
	public java.lang.String getUrlTitle() {
		return _content.getUrlTitle();
	}

	/**
	* Sets the url title of this content.
	*
	* @param urlTitle the url title of this content
	*/
	@Override
	public void setUrlTitle(java.lang.String urlTitle) {
		_content.setUrlTitle(urlTitle);
	}

	/**
	* Returns the news type of this content.
	*
	* @return the news type of this content
	*/
	@Override
	public int getNewsType() {
		return _content.getNewsType();
	}

	/**
	* Sets the news type of this content.
	*
	* @param newsType the news type of this content
	*/
	@Override
	public void setNewsType(int newsType) {
		_content.setNewsType(newsType);
	}

	/**
	* Returns the image url of this content.
	*
	* @return the image url of this content
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _content.getImageUrl();
	}

	/**
	* Sets the image url of this content.
	*
	* @param imageUrl the image url of this content
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_content.setImageUrl(imageUrl);
	}

	/**
	* Returns the is legal content of this content.
	*
	* @return the is legal content of this content
	*/
	@Override
	public boolean getIsLegalContent() {
		return _content.getIsLegalContent();
	}

	/**
	* Returns <code>true</code> if this content is is legal content.
	*
	* @return <code>true</code> if this content is is legal content; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsLegalContent() {
		return _content.isIsLegalContent();
	}

	/**
	* Sets whether this content is is legal content.
	*
	* @param isLegalContent the is legal content of this content
	*/
	@Override
	public void setIsLegalContent(boolean isLegalContent) {
		_content.setIsLegalContent(isLegalContent);
	}

	/**
	* Returns the image caption of this content.
	*
	* @return the image caption of this content
	*/
	@Override
	public java.lang.String getImageCaption() {
		return _content.getImageCaption();
	}

	/**
	* Sets the image caption of this content.
	*
	* @param imageCaption the image caption of this content
	*/
	@Override
	public void setImageCaption(java.lang.String imageCaption) {
		_content.setImageCaption(imageCaption);
	}

	/**
	* Returns the image position of this content.
	*
	* @return the image position of this content
	*/
	@Override
	public int getImagePosition() {
		return _content.getImagePosition();
	}

	/**
	* Sets the image position of this content.
	*
	* @param imagePosition the image position of this content
	*/
	@Override
	public void setImagePosition(int imagePosition) {
		_content.setImagePosition(imagePosition);
	}

	/**
	* Returns the created by user ID of this content.
	*
	* @return the created by user ID of this content
	*/
	@Override
	public long getCreatedByUserId() {
		return _content.getCreatedByUserId();
	}

	/**
	* Sets the created by user ID of this content.
	*
	* @param createdByUserId the created by user ID of this content
	*/
	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_content.setCreatedByUserId(createdByUserId);
	}

	/**
	* Returns the created by user uuid of this content.
	*
	* @return the created by user uuid of this content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreatedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _content.getCreatedByUserUuid();
	}

	/**
	* Sets the created by user uuid of this content.
	*
	* @param createdByUserUuid the created by user uuid of this content
	*/
	@Override
	public void setCreatedByUserUuid(java.lang.String createdByUserUuid) {
		_content.setCreatedByUserUuid(createdByUserUuid);
	}

	/**
	* Returns the edited by user ID of this content.
	*
	* @return the edited by user ID of this content
	*/
	@Override
	public long getEditedByUserId() {
		return _content.getEditedByUserId();
	}

	/**
	* Sets the edited by user ID of this content.
	*
	* @param editedByUserId the edited by user ID of this content
	*/
	@Override
	public void setEditedByUserId(long editedByUserId) {
		_content.setEditedByUserId(editedByUserId);
	}

	/**
	* Returns the edited by user uuid of this content.
	*
	* @return the edited by user uuid of this content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEditedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _content.getEditedByUserUuid();
	}

	/**
	* Sets the edited by user uuid of this content.
	*
	* @param editedByUserUuid the edited by user uuid of this content
	*/
	@Override
	public void setEditedByUserUuid(java.lang.String editedByUserUuid) {
		_content.setEditedByUserUuid(editedByUserUuid);
	}

	/**
	* Returns the reviewed by user ID of this content.
	*
	* @return the reviewed by user ID of this content
	*/
	@Override
	public long getReviewedByUserId() {
		return _content.getReviewedByUserId();
	}

	/**
	* Sets the reviewed by user ID of this content.
	*
	* @param reviewedByUserId the reviewed by user ID of this content
	*/
	@Override
	public void setReviewedByUserId(long reviewedByUserId) {
		_content.setReviewedByUserId(reviewedByUserId);
	}

	/**
	* Returns the reviewed by user uuid of this content.
	*
	* @return the reviewed by user uuid of this content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getReviewedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _content.getReviewedByUserUuid();
	}

	/**
	* Sets the reviewed by user uuid of this content.
	*
	* @param reviewedByUserUuid the reviewed by user uuid of this content
	*/
	@Override
	public void setReviewedByUserUuid(java.lang.String reviewedByUserUuid) {
		_content.setReviewedByUserUuid(reviewedByUserUuid);
	}

	/**
	* Returns the published by user ID of this content.
	*
	* @return the published by user ID of this content
	*/
	@Override
	public long getPublishedByUserId() {
		return _content.getPublishedByUserId();
	}

	/**
	* Sets the published by user ID of this content.
	*
	* @param publishedByUserId the published by user ID of this content
	*/
	@Override
	public void setPublishedByUserId(long publishedByUserId) {
		_content.setPublishedByUserId(publishedByUserId);
	}

	/**
	* Returns the published by user uuid of this content.
	*
	* @return the published by user uuid of this content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getPublishedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _content.getPublishedByUserUuid();
	}

	/**
	* Sets the published by user uuid of this content.
	*
	* @param publishedByUserUuid the published by user uuid of this content
	*/
	@Override
	public void setPublishedByUserUuid(java.lang.String publishedByUserUuid) {
		_content.setPublishedByUserUuid(publishedByUserUuid);
	}

	/**
	* Returns the created by user name of this content.
	*
	* @return the created by user name of this content
	*/
	@Override
	public java.lang.String getCreatedByUserName() {
		return _content.getCreatedByUserName();
	}

	/**
	* Sets the created by user name of this content.
	*
	* @param createdByUserName the created by user name of this content
	*/
	@Override
	public void setCreatedByUserName(java.lang.String createdByUserName) {
		_content.setCreatedByUserName(createdByUserName);
	}

	/**
	* Returns the edited by user name of this content.
	*
	* @return the edited by user name of this content
	*/
	@Override
	public java.lang.String getEditedByUserName() {
		return _content.getEditedByUserName();
	}

	/**
	* Sets the edited by user name of this content.
	*
	* @param editedByUserName the edited by user name of this content
	*/
	@Override
	public void setEditedByUserName(java.lang.String editedByUserName) {
		_content.setEditedByUserName(editedByUserName);
	}

	/**
	* Returns the reviewed by user name of this content.
	*
	* @return the reviewed by user name of this content
	*/
	@Override
	public java.lang.String getReviewedByUserName() {
		return _content.getReviewedByUserName();
	}

	/**
	* Sets the reviewed by user name of this content.
	*
	* @param reviewedByUserName the reviewed by user name of this content
	*/
	@Override
	public void setReviewedByUserName(java.lang.String reviewedByUserName) {
		_content.setReviewedByUserName(reviewedByUserName);
	}

	/**
	* Returns the published by user name of this content.
	*
	* @return the published by user name of this content
	*/
	@Override
	public java.lang.String getPublishedByUserName() {
		return _content.getPublishedByUserName();
	}

	/**
	* Sets the published by user name of this content.
	*
	* @param publishedByUserName the published by user name of this content
	*/
	@Override
	public void setPublishedByUserName(java.lang.String publishedByUserName) {
		_content.setPublishedByUserName(publishedByUserName);
	}

	/**
	* Returns the author of this content.
	*
	* @return the author of this content
	*/
	@Override
	public java.lang.String getAuthor() {
		return _content.getAuthor();
	}

	/**
	* Sets the author of this content.
	*
	* @param author the author of this content
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_content.setAuthor(author);
	}

	/**
	* Returns the job title of this content.
	*
	* @return the job title of this content
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _content.getJobTitle();
	}

	/**
	* Sets the job title of this content.
	*
	* @param jobTitle the job title of this content
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_content.setJobTitle(jobTitle);
	}

	@Override
	public boolean isNew() {
		return _content.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_content.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _content.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_content.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _content.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _content.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_content.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _content.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_content.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_content.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_content.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentWrapper((Content)_content.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.vcms.model.Content content) {
		return _content.compareTo(content);
	}

	@Override
	public int hashCode() {
		return _content.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Content> toCacheModel() {
		return _content.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Content toEscapedModel() {
		return new ContentWrapper(_content.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Content toUnescapedModel() {
		return new ContentWrapper(_content.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _content.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _content.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_content.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentWrapper)) {
			return false;
		}

		ContentWrapper contentWrapper = (ContentWrapper)obj;

		if (Validator.equals(_content, contentWrapper._content)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Content getWrappedContent() {
		return _content;
	}

	@Override
	public Content getWrappedModel() {
		return _content;
	}

	@Override
	public void resetOriginalValues() {
		_content.resetOriginalValues();
	}

	private Content _content;
}