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

package com.portal_egov.portlet.legal_faq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.portal_egov.portlet.legal_faq.service.ClpSerializer;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class LegalFAQEntryClp extends BaseModelImpl<LegalFAQEntry>
	implements LegalFAQEntry {
	public LegalFAQEntryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegalFAQEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LegalFAQEntry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _entryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("askDate", getAskDate());
		attributes.put("askTitle", getAskTitle());
		attributes.put("askContent", getAskContent());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("publishStatus", getPublishStatus());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		String askTitle = (String)attributes.get("askTitle");

		if (askTitle != null) {
			setAskTitle(askTitle);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer publishStatus = (Integer)attributes.get("publishStatus");

		if (publishStatus != null) {
			setPublishStatus(publishStatus);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		_entryId = entryId;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setEntryId", long.class);

				method.invoke(_legalFAQEntryRemoteModel, entryId);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_legalFAQEntryRemoteModel, companyId);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_legalFAQEntryRemoteModel, groupId);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legalFAQEntryRemoteModel, userId);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_legalFAQEntryRemoteModel, userName);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_legalFAQEntryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCitizenName() {
		return _citizenName;
	}

	@Override
	public void setCitizenName(String citizenName) {
		_citizenName = citizenName;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCitizenName", String.class);

				method.invoke(_legalFAQEntryRemoteModel, citizenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCitizenPhone() {
		return _citizenPhone;
	}

	@Override
	public void setCitizenPhone(String citizenPhone) {
		_citizenPhone = citizenPhone;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCitizenPhone", String.class);

				method.invoke(_legalFAQEntryRemoteModel, citizenPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCitizenEmail() {
		return _citizenEmail;
	}

	@Override
	public void setCitizenEmail(String citizenEmail) {
		_citizenEmail = citizenEmail;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCitizenEmail", String.class);

				method.invoke(_legalFAQEntryRemoteModel, citizenEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAskDate() {
		return _askDate;
	}

	@Override
	public void setAskDate(Date askDate) {
		_askDate = askDate;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAskDate", Date.class);

				method.invoke(_legalFAQEntryRemoteModel, askDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAskTitle() {
		return _askTitle;
	}

	@Override
	public void setAskTitle(String askTitle) {
		_askTitle = askTitle;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAskTitle", String.class);

				method.invoke(_legalFAQEntryRemoteModel, askTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAskContent() {
		return _askContent;
	}

	@Override
	public void setAskContent(String askContent) {
		_askContent = askContent;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAskContent", String.class);

				method.invoke(_legalFAQEntryRemoteModel, askContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAnswerDate() {
		return _answerDate;
	}

	@Override
	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerDate", Date.class);

				method.invoke(_legalFAQEntryRemoteModel, answerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerContent() {
		return _answerContent;
	}

	@Override
	public void setAnswerContent(String answerContent) {
		_answerContent = answerContent;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerContent", String.class);

				method.invoke(_legalFAQEntryRemoteModel, answerContent);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_legalFAQEntryRemoteModel, createDate);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legalFAQEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDate", Date.class);

				method.invoke(_legalFAQEntryRemoteModel, publishDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewCount() {
		return _viewCount;
	}

	@Override
	public void setViewCount(int viewCount) {
		_viewCount = viewCount;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCount", int.class);

				method.invoke(_legalFAQEntryRemoteModel, viewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublishStatus() {
		return _publishStatus;
	}

	@Override
	public void setPublishStatus(int publishStatus) {
		_publishStatus = publishStatus;

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStatus", int.class);

				method.invoke(_legalFAQEntryRemoteModel, publishStatus);
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

		if (_legalFAQEntryRemoteModel != null) {
			try {
				Class<?> clazz = _legalFAQEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_legalFAQEntryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegalFAQEntryRemoteModel() {
		return _legalFAQEntryRemoteModel;
	}

	public void setLegalFAQEntryRemoteModel(
		BaseModel<?> legalFAQEntryRemoteModel) {
		_legalFAQEntryRemoteModel = legalFAQEntryRemoteModel;
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

		Class<?> remoteModelClass = _legalFAQEntryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legalFAQEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegalFAQEntryLocalServiceUtil.addLegalFAQEntry(this);
		}
		else {
			LegalFAQEntryLocalServiceUtil.updateLegalFAQEntry(this);
		}
	}

	@Override
	public LegalFAQEntry toEscapedModel() {
		return (LegalFAQEntry)ProxyUtil.newProxyInstance(LegalFAQEntry.class.getClassLoader(),
			new Class[] { LegalFAQEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegalFAQEntryClp clone = new LegalFAQEntryClp();

		clone.setEntryId(getEntryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCategoryId(getCategoryId());
		clone.setCitizenName(getCitizenName());
		clone.setCitizenPhone(getCitizenPhone());
		clone.setCitizenEmail(getCitizenEmail());
		clone.setAskDate(getAskDate());
		clone.setAskTitle(getAskTitle());
		clone.setAskContent(getAskContent());
		clone.setAnswerDate(getAnswerDate());
		clone.setAnswerContent(getAnswerContent());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPublishDate(getPublishDate());
		clone.setViewCount(getViewCount());
		clone.setPublishStatus(getPublishStatus());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(LegalFAQEntry legalFAQEntry) {
		int value = 0;

		value = DateUtil.compareTo(getPublishDate(),
				legalFAQEntry.getPublishDate());

		value = value * -1;

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

		if (!(obj instanceof LegalFAQEntryClp)) {
			return false;
		}

		LegalFAQEntryClp legalFAQEntry = (LegalFAQEntryClp)obj;

		long primaryKey = legalFAQEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{entryId=");
		sb.append(getEntryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", citizenName=");
		sb.append(getCitizenName());
		sb.append(", citizenPhone=");
		sb.append(getCitizenPhone());
		sb.append(", citizenEmail=");
		sb.append(getCitizenEmail());
		sb.append(", askDate=");
		sb.append(getAskDate());
		sb.append(", askTitle=");
		sb.append(getAskTitle());
		sb.append(", askContent=");
		sb.append(getAskContent());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append(", answerContent=");
		sb.append(getAnswerContent());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", publishStatus=");
		sb.append(getPublishStatus());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.portal_egov.portlet.legal_faq.model.LegalFAQEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entryId</column-name><column-value><![CDATA[");
		sb.append(getEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenName</column-name><column-value><![CDATA[");
		sb.append(getCitizenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenPhone</column-name><column-value><![CDATA[");
		sb.append(getCitizenPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citizenEmail</column-name><column-value><![CDATA[");
		sb.append(getCitizenEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askDate</column-name><column-value><![CDATA[");
		sb.append(getAskDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askTitle</column-name><column-value><![CDATA[");
		sb.append(getAskTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>askContent</column-name><column-value><![CDATA[");
		sb.append(getAskContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerContent</column-name><column-value><![CDATA[");
		sb.append(getAnswerContent());
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
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatus</column-name><column-value><![CDATA[");
		sb.append(getPublishStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _categoryId;
	private String _citizenName;
	private String _citizenPhone;
	private String _citizenEmail;
	private Date _askDate;
	private String _askTitle;
	private String _askContent;
	private Date _answerDate;
	private String _answerContent;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _publishDate;
	private int _viewCount;
	private int _publishStatus;
	private int _status;
	private BaseModel<?> _legalFAQEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.portal_egov.portlet.legal_faq.service.ClpSerializer.class;
}