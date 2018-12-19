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

package com.viettel.portal.magazine.archive.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.magazine.archive.service.ClpSerializer;
import com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author namtv
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
	public int getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Subject", getSubject());
		attributes.put("NormalZoneID", getNormalZoneID());
		attributes.put("SpecialZoneID", getSpecialZoneID());
		attributes.put("FileUrl", getFileUrl());
		attributes.put("Author", getAuthor());
		attributes.put("AuthorTitle", getAuthorTitle());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("CreationDate", getCreationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Subject = (String)attributes.get("Subject");

		if (Subject != null) {
			setSubject(Subject);
		}

		Integer NormalZoneID = (Integer)attributes.get("NormalZoneID");

		if (NormalZoneID != null) {
			setNormalZoneID(NormalZoneID);
		}

		Integer SpecialZoneID = (Integer)attributes.get("SpecialZoneID");

		if (SpecialZoneID != null) {
			setSpecialZoneID(SpecialZoneID);
		}

		String FileUrl = (String)attributes.get("FileUrl");

		if (FileUrl != null) {
			setFileUrl(FileUrl);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String AuthorTitle = (String)attributes.get("AuthorTitle");

		if (AuthorTitle != null) {
			setAuthorTitle(AuthorTitle);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_contentRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _Subject;
	}

	@Override
	public void setSubject(String Subject) {
		_Subject = Subject;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_contentRemoteModel, Subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNormalZoneID() {
		return _NormalZoneID;
	}

	@Override
	public void setNormalZoneID(int NormalZoneID) {
		_NormalZoneID = NormalZoneID;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setNormalZoneID", int.class);

				method.invoke(_contentRemoteModel, NormalZoneID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSpecialZoneID() {
		return _SpecialZoneID;
	}

	@Override
	public void setSpecialZoneID(int SpecialZoneID) {
		_SpecialZoneID = SpecialZoneID;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecialZoneID", int.class);

				method.invoke(_contentRemoteModel, SpecialZoneID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileUrl() {
		return _FileUrl;
	}

	@Override
	public void setFileUrl(String FileUrl) {
		_FileUrl = FileUrl;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileUrl", String.class);

				method.invoke(_contentRemoteModel, FileUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _Author;
	}

	@Override
	public void setAuthor(String Author) {
		_Author = Author;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_contentRemoteModel, Author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthorTitle() {
		return _AuthorTitle;
	}

	@Override
	public void setAuthorTitle(String AuthorTitle) {
		_AuthorTitle = AuthorTitle;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorTitle", String.class);

				method.invoke(_contentRemoteModel, AuthorTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMagazineID() {
		return _MagazineID;
	}

	@Override
	public void setMagazineID(int MagazineID) {
		_MagazineID = MagazineID;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setMagazineID", int.class);

				method.invoke(_contentRemoteModel, MagazineID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortOrder() {
		return _SortOrder;
	}

	@Override
	public void setSortOrder(int SortOrder) {
		_SortOrder = SortOrder;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_contentRemoteModel, SortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreationDate() {
		return _CreationDate;
	}

	@Override
	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;

		if (_contentRemoteModel != null) {
			try {
				Class<?> clazz = _contentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_contentRemoteModel, CreationDate);
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

		clone.setID(getID());
		clone.setSubject(getSubject());
		clone.setNormalZoneID(getNormalZoneID());
		clone.setSpecialZoneID(getSpecialZoneID());
		clone.setFileUrl(getFileUrl());
		clone.setAuthor(getAuthor());
		clone.setAuthorTitle(getAuthorTitle());
		clone.setMagazineID(getMagazineID());
		clone.setSortOrder(getSortOrder());
		clone.setCreationDate(getCreationDate());

		return clone;
	}

	@Override
	public int compareTo(Content content) {
		int value = 0;

		if (getSortOrder() < content.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > content.getSortOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		int primaryKey = content.getPrimaryKey();

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
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Subject=");
		sb.append(getSubject());
		sb.append(", NormalZoneID=");
		sb.append(getNormalZoneID());
		sb.append(", SpecialZoneID=");
		sb.append(getSpecialZoneID());
		sb.append(", FileUrl=");
		sb.append(getFileUrl());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append(", AuthorTitle=");
		sb.append(getAuthorTitle());
		sb.append(", MagazineID=");
		sb.append(getMagazineID());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.archive.model.Content");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NormalZoneID</column-name><column-value><![CDATA[");
		sb.append(getNormalZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SpecialZoneID</column-name><column-value><![CDATA[");
		sb.append(getSpecialZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FileUrl</column-name><column-value><![CDATA[");
		sb.append(getFileUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AuthorTitle</column-name><column-value><![CDATA[");
		sb.append(getAuthorTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineID</column-name><column-value><![CDATA[");
		sb.append(getMagazineID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Subject;
	private int _NormalZoneID;
	private int _SpecialZoneID;
	private String _FileUrl;
	private String _Author;
	private String _AuthorTitle;
	private int _MagazineID;
	private int _SortOrder;
	private Date _CreationDate;
	private BaseModel<?> _contentRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.magazine.archive.service.ClpSerializer.class;
}