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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class ContentClp extends BaseModelImpl<Content> implements Content {
	public ContentClp() {
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
	public long getPrimaryKey() {
		return _autoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAutoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _autoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getAutoId() {
		return _autoId;
	}

	@Override
	public void setAutoId(long autoId) {
		_autoId = autoId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setAutoId", long.class);

				method.invoke(_contentRemoteModel, autoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContentId() {
		return _contentId;
	}

	@Override
	public void setContentId(long contentId) {
		_contentId = contentId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentId", long.class);

				method.invoke(_contentRemoteModel, contentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contentRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contentRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contentRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_contentRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contentRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPreVersion() {
		return _preVersion;
	}

	@Override
	public void setPreVersion(int preVersion) {
		_preVersion = preVersion;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setPreVersion", int.class);

				method.invoke(_contentRemoteModel, preVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVersion() {
		return _version;
	}

	@Override
	public void setVersion(int version) {
		_version = version;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_contentRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubTitle() {
		return _subTitle;
	}

	@Override
	public void setSubTitle(String subTitle) {
		_subTitle = subTitle;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSubTitle", String.class);

				method.invoke(_contentRemoteModel, subTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_contentRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSummary() {
		return _summary;
	}

	@Override
	public void setSummary(String summary) {
		_summary = summary;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSummary", String.class);

				method.invoke(_contentRemoteModel, summary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubContent() {
		return _subContent;
	}

	@Override
	public void setSubContent(String subContent) {
		_subContent = subContent;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSubContent", String.class);

				method.invoke(_contentRemoteModel, subContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_contentRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSmallImageId() {
		return _smallImageId;
	}

	@Override
	public void setSmallImageId(long smallImageId) {
		_smallImageId = smallImageId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageId", long.class);

				method.invoke(_contentRemoteModel, smallImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	@Override
	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageUrl", String.class);

				method.invoke(_contentRemoteModel, smallImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_contentRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCopyRight() {
		return _copyRight;
	}

	@Override
	public void setCopyRight(String copyRight) {
		_copyRight = copyRight;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCopyRight", String.class);

				method.invoke(_contentRemoteModel, copyRight);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_contentRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrlTitle() {
		return _urlTitle;
	}

	@Override
	public void setUrlTitle(String urlTitle) {
		_urlTitle = urlTitle;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setUrlTitle", String.class);

				method.invoke(_contentRemoteModel, urlTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNewsType() {
		return _newsType;
	}

	@Override
	public void setNewsType(int newsType) {
		_newsType = newsType;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsType", int.class);

				method.invoke(_contentRemoteModel, newsType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _imageUrl;
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_contentRemoteModel, imageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsLegalContent() {
		return _isLegalContent;
	}

	@Override
	public boolean isIsLegalContent() {
		return _isLegalContent;
	}

	@Override
	public void setIsLegalContent(boolean isLegalContent) {
		_isLegalContent = isLegalContent;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLegalContent",
						boolean.class);

				method.invoke(_contentRemoteModel, isLegalContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageCaption() {
		return _imageCaption;
	}

	@Override
	public void setImageCaption(String imageCaption) {
		_imageCaption = imageCaption;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setImageCaption", String.class);

				method.invoke(_contentRemoteModel, imageCaption);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getImagePosition() {
		return _imagePosition;
	}

	@Override
	public void setImagePosition(int imagePosition) {
		_imagePosition = imagePosition;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setImagePosition", int.class);

				method.invoke(_contentRemoteModel, imagePosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedByUserId() {
		return _createdByUserId;
	}

	@Override
	public void setCreatedByUserId(long createdByUserId) {
		_createdByUserId = createdByUserId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserId", long.class);

				method.invoke(_contentRemoteModel, createdByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreatedByUserId(), "uuid",
			_createdByUserUuid);
	}

	@Override
	public void setCreatedByUserUuid(String createdByUserUuid) {
		_createdByUserUuid = createdByUserUuid;
	}

	@Override
	public long getEditedByUserId() {
		return _editedByUserId;
	}

	@Override
	public void setEditedByUserId(long editedByUserId) {
		_editedByUserId = editedByUserId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setEditedByUserId", long.class);

				method.invoke(_contentRemoteModel, editedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEditedByUserId(), "uuid",
			_editedByUserUuid);
	}

	@Override
	public void setEditedByUserUuid(String editedByUserUuid) {
		_editedByUserUuid = editedByUserUuid;
	}

	@Override
	public long getReviewedByUserId() {
		return _reviewedByUserId;
	}

	@Override
	public void setReviewedByUserId(long reviewedByUserId) {
		_reviewedByUserId = reviewedByUserId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewedByUserId",
						long.class);

				method.invoke(_contentRemoteModel, reviewedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReviewedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getReviewedByUserId(), "uuid",
			_reviewedByUserUuid);
	}

	@Override
	public void setReviewedByUserUuid(String reviewedByUserUuid) {
		_reviewedByUserUuid = reviewedByUserUuid;
	}

	@Override
	public long getPublishedByUserId() {
		return _publishedByUserId;
	}

	@Override
	public void setPublishedByUserId(long publishedByUserId) {
		_publishedByUserId = publishedByUserId;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishedByUserId",
						long.class);

				method.invoke(_contentRemoteModel, publishedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getPublishedByUserId(), "uuid",
			_publishedByUserUuid);
	}

	@Override
	public void setPublishedByUserUuid(String publishedByUserUuid) {
		_publishedByUserUuid = publishedByUserUuid;
	}

	@Override
	public String getCreatedByUserName() {
		return _createdByUserName;
	}

	@Override
	public void setCreatedByUserName(String createdByUserName) {
		_createdByUserName = createdByUserName;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedByUserName",
						String.class);

				method.invoke(_contentRemoteModel, createdByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditedByUserName() {
		return _editedByUserName;
	}

	@Override
	public void setEditedByUserName(String editedByUserName) {
		_editedByUserName = editedByUserName;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setEditedByUserName",
						String.class);

				method.invoke(_contentRemoteModel, editedByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReviewedByUserName() {
		return _reviewedByUserName;
	}

	@Override
	public void setReviewedByUserName(String reviewedByUserName) {
		_reviewedByUserName = reviewedByUserName;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewedByUserName",
						String.class);

				method.invoke(_contentRemoteModel, reviewedByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishedByUserName() {
		return _publishedByUserName;
	}

	@Override
	public void setPublishedByUserName(String publishedByUserName) {
		_publishedByUserName = publishedByUserName;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishedByUserName",
						String.class);

				method.invoke(_contentRemoteModel, publishedByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_contentRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_contentRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentRemoteModel() {
		return _contentRemoteModel;
	}

	public void setContentRemoteModel(BaseModel<?> contentRemoteModel) {
		_contentRemoteModel = contentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _contentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_contentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentLocalServiceUtil.addContent(this);
		}
		else {
			ContentLocalServiceUtil.updateContent(this);
		}
	}

	@Override
	public Content toEscapedModel() {
		return (Content)ProxyUtil.newProxyInstance(Content.class.getClassLoader(),
			new Class[] { Content.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentClp clone = new ContentClp();

		clone.setAutoId(getAutoId());
		clone.setContentId(getContentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPreVersion(getPreVersion());
		clone.setVersion(getVersion());
		clone.setSubTitle(getSubTitle());
		clone.setTitle(getTitle());
		clone.setSummary(getSummary());
		clone.setSubContent(getSubContent());
		clone.setContent(getContent());
		clone.setSmallImageId(getSmallImageId());
		clone.setSmallImageUrl(getSmallImageUrl());
		clone.setCategoryId(getCategoryId());
		clone.setCopyRight(getCopyRight());
		clone.setStatus(getStatus());
		clone.setUrlTitle(getUrlTitle());
		clone.setNewsType(getNewsType());
		clone.setImageUrl(getImageUrl());
		clone.setIsLegalContent(getIsLegalContent());
		clone.setImageCaption(getImageCaption());
		clone.setImagePosition(getImagePosition());
		clone.setCreatedByUserId(getCreatedByUserId());
		clone.setEditedByUserId(getEditedByUserId());
		clone.setReviewedByUserId(getReviewedByUserId());
		clone.setPublishedByUserId(getPublishedByUserId());
		clone.setCreatedByUserName(getCreatedByUserName());
		clone.setEditedByUserName(getEditedByUserName());
		clone.setReviewedByUserName(getReviewedByUserName());
		clone.setPublishedByUserName(getPublishedByUserName());
		clone.setAuthor(getAuthor());
		clone.setJobTitle(getJobTitle());

		return clone;
	}

	@Override
	public int compareTo(Content content) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), content.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentClp)) {
			return false;
		}

		ContentClp content = (ContentClp)obj;

		long primaryKey = content.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{autoId=");
		sb.append(getAutoId());
		sb.append(", contentId=");
		sb.append(getContentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", preVersion=");
		sb.append(getPreVersion());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", subTitle=");
		sb.append(getSubTitle());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", subContent=");
		sb.append(getSubContent());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", smallImageUrl=");
		sb.append(getSmallImageUrl());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", copyRight=");
		sb.append(getCopyRight());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", urlTitle=");
		sb.append(getUrlTitle());
		sb.append(", newsType=");
		sb.append(getNewsType());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", isLegalContent=");
		sb.append(getIsLegalContent());
		sb.append(", imageCaption=");
		sb.append(getImageCaption());
		sb.append(", imagePosition=");
		sb.append(getImagePosition());
		sb.append(", createdByUserId=");
		sb.append(getCreatedByUserId());
		sb.append(", editedByUserId=");
		sb.append(getEditedByUserId());
		sb.append(", reviewedByUserId=");
		sb.append(getReviewedByUserId());
		sb.append(", publishedByUserId=");
		sb.append(getPublishedByUserId());
		sb.append(", createdByUserName=");
		sb.append(getCreatedByUserName());
		sb.append(", editedByUserName=");
		sb.append(getEditedByUserName());
		sb.append(", reviewedByUserName=");
		sb.append(getReviewedByUserName());
		sb.append(", publishedByUserName=");
		sb.append(getPublishedByUserName());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Content");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>autoId</column-name><column-value><![CDATA[");
		sb.append(getAutoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentId</column-name><column-value><![CDATA[");
		sb.append(getContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preVersion</column-name><column-value><![CDATA[");
		sb.append(getPreVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subTitle</column-name><column-value><![CDATA[");
		sb.append(getSubTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subContent</column-name><column-value><![CDATA[");
		sb.append(getSubContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageUrl</column-name><column-value><![CDATA[");
		sb.append(getSmallImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>copyRight</column-name><column-value><![CDATA[");
		sb.append(getCopyRight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlTitle</column-name><column-value><![CDATA[");
		sb.append(getUrlTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newsType</column-name><column-value><![CDATA[");
		sb.append(getNewsType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLegalContent</column-name><column-value><![CDATA[");
		sb.append(getIsLegalContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageCaption</column-name><column-value><![CDATA[");
		sb.append(getImageCaption());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagePosition</column-name><column-value><![CDATA[");
		sb.append(getImagePosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserId</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editedByUserId</column-name><column-value><![CDATA[");
		sb.append(getEditedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewedByUserId</column-name><column-value><![CDATA[");
		sb.append(getReviewedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishedByUserId</column-name><column-value><![CDATA[");
		sb.append(getPublishedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdByUserName</column-name><column-value><![CDATA[");
		sb.append(getCreatedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editedByUserName</column-name><column-value><![CDATA[");
		sb.append(getEditedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewedByUserName</column-name><column-value><![CDATA[");
		sb.append(getReviewedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishedByUserName</column-name><column-value><![CDATA[");
		sb.append(getPublishedByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _autoId;
	private long _contentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _preVersion;
	private int _version;
	private String _subTitle;
	private String _title;
	private String _summary;
	private String _subContent;
	private String _content;
	private long _smallImageId;
	private String _smallImageUrl;
	private long _categoryId;
	private String _copyRight;
	private int _status;
	private String _urlTitle;
	private int _newsType;
	private String _imageUrl;
	private boolean _isLegalContent;
	private String _imageCaption;
	private int _imagePosition;
	private long _createdByUserId;
	private String _createdByUserUuid;
	private long _editedByUserId;
	private String _editedByUserUuid;
	private long _reviewedByUserId;
	private String _reviewedByUserUuid;
	private long _publishedByUserId;
	private String _publishedByUserUuid;
	private String _createdByUserName;
	private String _editedByUserName;
	private String _reviewedByUserName;
	private String _publishedByUserName;
	private String _author;
	private String _jobTitle;
	private BaseModel<?> _contentRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}