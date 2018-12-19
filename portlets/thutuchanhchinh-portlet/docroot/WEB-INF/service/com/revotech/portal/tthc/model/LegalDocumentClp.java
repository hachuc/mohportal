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

package com.revotech.portal.tthc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.revotech.portal.tthc.service.ClpSerializer;
import com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hieptran
 */
public class LegalDocumentClp extends BaseModelImpl<LegalDocument>
	implements LegalDocument {
	public LegalDocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegalDocument.class;
	}

	@Override
	public String getModelClassName() {
		return LegalDocument.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ldId", getLdId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ldCode", getLdCode());
		attributes.put("ldTitle", getLdTitle());
		attributes.put("ldLink", getLdLink());
		attributes.put("ldLevel3Link", getLdLevel3Link());
		attributes.put("ldSubcontent", getLdSubcontent());
		attributes.put("isActive", getIsActive());
		attributes.put("idLinhvuc", getIdLinhvuc());
		attributes.put("idCoquanbanhanh", getIdCoquanbanhanh());
		attributes.put("ldDonvithuchien", getLdDonvithuchien());
		attributes.put("ldLevel", getLdLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ldId = (Long)attributes.get("ldId");

		if (ldId != null) {
			setLdId(ldId);
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

		String ldCode = (String)attributes.get("ldCode");

		if (ldCode != null) {
			setLdCode(ldCode);
		}

		String ldTitle = (String)attributes.get("ldTitle");

		if (ldTitle != null) {
			setLdTitle(ldTitle);
		}

		String ldLink = (String)attributes.get("ldLink");

		if (ldLink != null) {
			setLdLink(ldLink);
		}

		String ldLevel3Link = (String)attributes.get("ldLevel3Link");

		if (ldLevel3Link != null) {
			setLdLevel3Link(ldLevel3Link);
		}

		String ldSubcontent = (String)attributes.get("ldSubcontent");

		if (ldSubcontent != null) {
			setLdSubcontent(ldSubcontent);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Long idLinhvuc = (Long)attributes.get("idLinhvuc");

		if (idLinhvuc != null) {
			setIdLinhvuc(idLinhvuc);
		}

		Long idCoquanbanhanh = (Long)attributes.get("idCoquanbanhanh");

		if (idCoquanbanhanh != null) {
			setIdCoquanbanhanh(idCoquanbanhanh);
		}

		String ldDonvithuchien = (String)attributes.get("ldDonvithuchien");

		if (ldDonvithuchien != null) {
			setLdDonvithuchien(ldDonvithuchien);
		}

		Integer ldLevel = (Integer)attributes.get("ldLevel");

		if (ldLevel != null) {
			setLdLevel(ldLevel);
		}
	}

	@Override
	public long getLdId() {
		return _ldId;
	}

	@Override
	public void setLdId(long ldId) {
		_ldId = ldId;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdId", long.class);

				method.invoke(_legalDocumentRemoteModel, ldId);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_legalDocumentRemoteModel, groupId);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_legalDocumentRemoteModel, companyId);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legalDocumentRemoteModel, userId);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_legalDocumentRemoteModel, userName);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_legalDocumentRemoteModel, createDate);
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

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legalDocumentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdCode() {
		return _ldCode;
	}

	@Override
	public void setLdCode(String ldCode) {
		_ldCode = ldCode;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdCode", String.class);

				method.invoke(_legalDocumentRemoteModel, ldCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdTitle() {
		return _ldTitle;
	}

	@Override
	public void setLdTitle(String ldTitle) {
		_ldTitle = ldTitle;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdTitle", String.class);

				method.invoke(_legalDocumentRemoteModel, ldTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdLink() {
		return _ldLink;
	}

	@Override
	public void setLdLink(String ldLink) {
		_ldLink = ldLink;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdLink", String.class);

				method.invoke(_legalDocumentRemoteModel, ldLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdLevel3Link() {
		return _ldLevel3Link;
	}

	@Override
	public void setLdLevel3Link(String ldLevel3Link) {
		_ldLevel3Link = ldLevel3Link;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdLevel3Link", String.class);

				method.invoke(_legalDocumentRemoteModel, ldLevel3Link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdSubcontent() {
		return _ldSubcontent;
	}

	@Override
	public void setLdSubcontent(String ldSubcontent) {
		_ldSubcontent = ldSubcontent;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdSubcontent", String.class);

				method.invoke(_legalDocumentRemoteModel, ldSubcontent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_isActive = isActive;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", boolean.class);

				method.invoke(_legalDocumentRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdLinhvuc() {
		return _idLinhvuc;
	}

	@Override
	public void setIdLinhvuc(long idLinhvuc) {
		_idLinhvuc = idLinhvuc;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIdLinhvuc", long.class);

				method.invoke(_legalDocumentRemoteModel, idLinhvuc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIdCoquanbanhanh() {
		return _idCoquanbanhanh;
	}

	@Override
	public void setIdCoquanbanhanh(long idCoquanbanhanh) {
		_idCoquanbanhanh = idCoquanbanhanh;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIdCoquanbanhanh", long.class);

				method.invoke(_legalDocumentRemoteModel, idCoquanbanhanh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdDonvithuchien() {
		return _ldDonvithuchien;
	}

	@Override
	public void setLdDonvithuchien(String ldDonvithuchien) {
		_ldDonvithuchien = ldDonvithuchien;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdDonvithuchien",
						String.class);

				method.invoke(_legalDocumentRemoteModel, ldDonvithuchien);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLdLevel() {
		return _ldLevel;
	}

	@Override
	public void setLdLevel(int ldLevel) {
		_ldLevel = ldLevel;

		if (_legalDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _legalDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLdLevel", int.class);

				method.invoke(_legalDocumentRemoteModel, ldLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegalDocumentRemoteModel() {
		return _legalDocumentRemoteModel;
	}

	public void setLegalDocumentRemoteModel(
		BaseModel<?> legalDocumentRemoteModel) {
		_legalDocumentRemoteModel = legalDocumentRemoteModel;
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

		Class<?> remoteModelClass = _legalDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legalDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegalDocumentLocalServiceUtil.addLegalDocument(this);
		}
		else {
			LegalDocumentLocalServiceUtil.updateLegalDocument(this);
		}
	}

	@Override
	public LegalDocument toEscapedModel() {
		return (LegalDocument)ProxyUtil.newProxyInstance(LegalDocument.class.getClassLoader(),
			new Class[] { LegalDocument.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegalDocumentClp clone = new LegalDocumentClp();

		clone.setLdId(getLdId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLdCode(getLdCode());
		clone.setLdTitle(getLdTitle());
		clone.setLdLink(getLdLink());
		clone.setLdLevel3Link(getLdLevel3Link());
		clone.setLdSubcontent(getLdSubcontent());
		clone.setIsActive(getIsActive());
		clone.setIdLinhvuc(getIdLinhvuc());
		clone.setIdCoquanbanhanh(getIdCoquanbanhanh());
		clone.setLdDonvithuchien(getLdDonvithuchien());
		clone.setLdLevel(getLdLevel());

		return clone;
	}

	@Override
	public int compareTo(LegalDocument legalDocument) {
		int value = 0;

		value = getLdCode().compareTo(legalDocument.getLdCode());

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

		if (!(obj instanceof LegalDocumentClp)) {
			return false;
		}

		LegalDocumentClp legalDocument = (LegalDocumentClp)obj;

		long primaryKey = legalDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{ldId=");
		sb.append(getLdId());
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
		sb.append(", ldCode=");
		sb.append(getLdCode());
		sb.append(", ldTitle=");
		sb.append(getLdTitle());
		sb.append(", ldLink=");
		sb.append(getLdLink());
		sb.append(", ldLevel3Link=");
		sb.append(getLdLevel3Link());
		sb.append(", ldSubcontent=");
		sb.append(getLdSubcontent());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", idLinhvuc=");
		sb.append(getIdLinhvuc());
		sb.append(", idCoquanbanhanh=");
		sb.append(getIdCoquanbanhanh());
		sb.append(", ldDonvithuchien=");
		sb.append(getLdDonvithuchien());
		sb.append(", ldLevel=");
		sb.append(getLdLevel());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.revotech.portal.tthc.model.LegalDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ldId</column-name><column-value><![CDATA[");
		sb.append(getLdId());
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
			"<column><column-name>ldCode</column-name><column-value><![CDATA[");
		sb.append(getLdCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldTitle</column-name><column-value><![CDATA[");
		sb.append(getLdTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldLink</column-name><column-value><![CDATA[");
		sb.append(getLdLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldLevel3Link</column-name><column-value><![CDATA[");
		sb.append(getLdLevel3Link());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldSubcontent</column-name><column-value><![CDATA[");
		sb.append(getLdSubcontent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idLinhvuc</column-name><column-value><![CDATA[");
		sb.append(getIdLinhvuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCoquanbanhanh</column-name><column-value><![CDATA[");
		sb.append(getIdCoquanbanhanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldDonvithuchien</column-name><column-value><![CDATA[");
		sb.append(getLdDonvithuchien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldLevel</column-name><column-value><![CDATA[");
		sb.append(getLdLevel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ldId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _ldCode;
	private String _ldTitle;
	private String _ldLink;
	private String _ldLevel3Link;
	private String _ldSubcontent;
	private boolean _isActive;
	private long _idLinhvuc;
	private long _idCoquanbanhanh;
	private String _ldDonvithuchien;
	private int _ldLevel;
	private BaseModel<?> _legalDocumentRemoteModel;
	private Class<?> _clpSerializerClass = com.revotech.portal.tthc.service.ClpSerializer.class;
}