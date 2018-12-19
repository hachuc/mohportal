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
import com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class ContentDetailClp extends BaseModelImpl<ContentDetail>
	implements ContentDetail {
	public ContentDetailClp() {
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

	@Override
	public long getAutoId() {
		return _autoId;
	}

	@Override
	public void setAutoId(long autoId) {
		_autoId = autoId;

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAutoId", long.class);

				method.invoke(_contentDetailRemoteModel, autoId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setContentId", long.class);

				method.invoke(_contentDetailRemoteModel, contentId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contentDetailRemoteModel, groupId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_contentDetailRemoteModel, companyId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_contentDetailRemoteModel, userId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_contentDetailRemoteModel, userName);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_contentDetailRemoteModel, createDate);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_contentDetailRemoteModel, modifiedDate);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_contentDetailRemoteModel, version);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSubTitle", String.class);

				method.invoke(_contentDetailRemoteModel, subTitle);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_contentDetailRemoteModel, title);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSummary", String.class);

				method.invoke(_contentDetailRemoteModel, summary);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSubContent", String.class);

				method.invoke(_contentDetailRemoteModel, subContent);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_contentDetailRemoteModel, content);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageId", long.class);

				method.invoke(_contentDetailRemoteModel, smallImageId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageUrl", String.class);

				method.invoke(_contentDetailRemoteModel, smallImageUrl);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_contentDetailRemoteModel, categoryId);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_contentDetailRemoteModel, status);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setNewsType", int.class);

				method.invoke(_contentDetailRemoteModel, newsType);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_contentDetailRemoteModel, imageUrl);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLegalContent",
						boolean.class);

				method.invoke(_contentDetailRemoteModel, isLegalContent);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setImageCaption", String.class);

				method.invoke(_contentDetailRemoteModel, imageCaption);
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

		if (_contentDetailRemoteModel != null) {
			try {
				Class<?> clazz = _contentDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setImagePosition", int.class);

				method.invoke(_contentDetailRemoteModel, imagePosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentDetailRemoteModel() {
		return _contentDetailRemoteModel;
	}

	public void setContentDetailRemoteModel(
		BaseModel<?> contentDetailRemoteModel) {
		_contentDetailRemoteModel = contentDetailRemoteModel;
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

		Class<?> remoteModelClass = _contentDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contentDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentDetailLocalServiceUtil.addContentDetail(this);
		}
		else {
			ContentDetailLocalServiceUtil.updateContentDetail(this);
		}
	}

	@Override
	public ContentDetail toEscapedModel() {
		return (ContentDetail)ProxyUtil.newProxyInstance(ContentDetail.class.getClassLoader(),
			new Class[] { ContentDetail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentDetailClp clone = new ContentDetailClp();

		clone.setAutoId(getAutoId());
		clone.setContentId(getContentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVersion(getVersion());
		clone.setSubTitle(getSubTitle());
		clone.setTitle(getTitle());
		clone.setSummary(getSummary());
		clone.setSubContent(getSubContent());
		clone.setContent(getContent());
		clone.setSmallImageId(getSmallImageId());
		clone.setSmallImageUrl(getSmallImageUrl());
		clone.setCategoryId(getCategoryId());
		clone.setStatus(getStatus());
		clone.setNewsType(getNewsType());
		clone.setImageUrl(getImageUrl());
		clone.setIsLegalContent(getIsLegalContent());
		clone.setImageCaption(getImageCaption());
		clone.setImagePosition(getImagePosition());

		return clone;
	}

	@Override
	public int compareTo(ContentDetail contentDetail) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				contentDetail.getModifiedDate());

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

		if (!(obj instanceof ContentDetailClp)) {
			return false;
		}

		ContentDetailClp contentDetail = (ContentDetailClp)obj;

		long primaryKey = contentDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

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
		sb.append(", status=");
		sb.append(getStatus());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.ContentDetail");
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
	private int _version;
	private String _subTitle;
	private String _title;
	private String _summary;
	private String _subContent;
	private String _content;
	private long _smallImageId;
	private String _smallImageUrl;
	private long _categoryId;
	private int _status;
	private int _newsType;
	private String _imageUrl;
	private boolean _isLegalContent;
	private String _imageCaption;
	private int _imagePosition;
	private BaseModel<?> _contentDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}