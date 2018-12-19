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

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.Legal_ContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class Legal_ContentClp extends BaseModelImpl<Legal_Content>
	implements Legal_Content {
	public Legal_ContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Content.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Content.class.getName();
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
		attributes.put("ContentID", getContentID());
		attributes.put("Version", getVersion());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("Byline", getByline());
		attributes.put("Headline", getHeadline());
		attributes.put("Tagline", getTagline());
		attributes.put("Teaser", getTeaser());
		attributes.put("Body", getBody());
		attributes.put("Avatar", getAvatar());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("ImageDescription", getImageDescription());
		attributes.put("ImageAlign", getImageAlign());
		attributes.put("ZoneID", getZoneID());
		attributes.put("Source", getSource());
		attributes.put("Status", getStatus());
		attributes.put("Author", getAuthor());
		attributes.put("Editor", getEditor());
		attributes.put("Approver", getApprover());
		attributes.put("Deployer", getDeployer());
		attributes.put("Authors", getAuthors());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String Byline = (String)attributes.get("Byline");

		if (Byline != null) {
			setByline(Byline);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		String Tagline = (String)attributes.get("Tagline");

		if (Tagline != null) {
			setTagline(Tagline);
		}

		String Teaser = (String)attributes.get("Teaser");

		if (Teaser != null) {
			setTeaser(Teaser);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		String Avatar = (String)attributes.get("Avatar");

		if (Avatar != null) {
			setAvatar(Avatar);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		String ImageDescription = (String)attributes.get("ImageDescription");

		if (ImageDescription != null) {
			setImageDescription(ImageDescription);
		}

		Integer ImageAlign = (Integer)attributes.get("ImageAlign");

		if (ImageAlign != null) {
			setImageAlign(ImageAlign);
		}

		Integer ZoneID = (Integer)attributes.get("ZoneID");

		if (ZoneID != null) {
			setZoneID(ZoneID);
		}

		String Source = (String)attributes.get("Source");

		if (Source != null) {
			setSource(Source);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String Editor = (String)attributes.get("Editor");

		if (Editor != null) {
			setEditor(Editor);
		}

		String Approver = (String)attributes.get("Approver");

		if (Approver != null) {
			setApprover(Approver);
		}

		String Deployer = (String)attributes.get("Deployer");

		if (Deployer != null) {
			setDeployer(Deployer);
		}

		String Authors = (String)attributes.get("Authors");

		if (Authors != null) {
			setAuthors(Authors);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_legal_ContentRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getContentID() {
		return _ContentID;
	}

	@Override
	public void setContentID(int ContentID) {
		_ContentID = ContentID;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentID", int.class);

				method.invoke(_legal_ContentRemoteModel, ContentID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVersion() {
		return _Version;
	}

	@Override
	public void setVersion(int Version) {
		_Version = Version;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_legal_ContentRemoteModel, Version);
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

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_legal_ContentRemoteModel, CreationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legal_ContentRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getByline() {
		return _Byline;
	}

	@Override
	public void setByline(String Byline) {
		_Byline = Byline;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setByline", String.class);

				method.invoke(_legal_ContentRemoteModel, Byline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHeadline() {
		return _Headline;
	}

	@Override
	public void setHeadline(String Headline) {
		_Headline = Headline;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadline", String.class);

				method.invoke(_legal_ContentRemoteModel, Headline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTagline() {
		return _Tagline;
	}

	@Override
	public void setTagline(String Tagline) {
		_Tagline = Tagline;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTagline", String.class);

				method.invoke(_legal_ContentRemoteModel, Tagline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTeaser() {
		return _Teaser;
	}

	@Override
	public void setTeaser(String Teaser) {
		_Teaser = Teaser;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTeaser", String.class);

				method.invoke(_legal_ContentRemoteModel, Teaser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _Body;
	}

	@Override
	public void setBody(String Body) {
		_Body = Body;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_legal_ContentRemoteModel, Body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAvatar() {
		return _Avatar;
	}

	@Override
	public void setAvatar(String Avatar) {
		_Avatar = Avatar;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setAvatar", String.class);

				method.invoke(_legal_ContentRemoteModel, Avatar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _ImageUrl;
	}

	@Override
	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_legal_ContentRemoteModel, ImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageDescription() {
		return _ImageDescription;
	}

	@Override
	public void setImageDescription(String ImageDescription) {
		_ImageDescription = ImageDescription;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDescription",
						String.class);

				method.invoke(_legal_ContentRemoteModel, ImageDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getImageAlign() {
		return _ImageAlign;
	}

	@Override
	public void setImageAlign(int ImageAlign) {
		_ImageAlign = ImageAlign;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setImageAlign", int.class);

				method.invoke(_legal_ContentRemoteModel, ImageAlign);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getZoneID() {
		return _ZoneID;
	}

	@Override
	public void setZoneID(int ZoneID) {
		_ZoneID = ZoneID;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setZoneID", int.class);

				method.invoke(_legal_ContentRemoteModel, ZoneID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSource() {
		return _Source;
	}

	@Override
	public void setSource(String Source) {
		_Source = Source;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", String.class);

				method.invoke(_legal_ContentRemoteModel, Source);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _Status;
	}

	@Override
	public void setStatus(int Status) {
		_Status = Status;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_legal_ContentRemoteModel, Status);
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

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_legal_ContentRemoteModel, Author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEditor() {
		return _Editor;
	}

	@Override
	public void setEditor(String Editor) {
		_Editor = Editor;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setEditor", String.class);

				method.invoke(_legal_ContentRemoteModel, Editor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApprover() {
		return _Approver;
	}

	@Override
	public void setApprover(String Approver) {
		_Approver = Approver;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setApprover", String.class);

				method.invoke(_legal_ContentRemoteModel, Approver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeployer() {
		return _Deployer;
	}

	@Override
	public void setDeployer(String Deployer) {
		_Deployer = Deployer;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setDeployer", String.class);

				method.invoke(_legal_ContentRemoteModel, Deployer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthors() {
		return _Authors;
	}

	@Override
	public void setAuthors(String Authors) {
		_Authors = Authors;

		if (_legal_ContentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthors", String.class);

				method.invoke(_legal_ContentRemoteModel, Authors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegal_ContentRemoteModel() {
		return _legal_ContentRemoteModel;
	}

	public void setLegal_ContentRemoteModel(
		BaseModel<?> legal_ContentRemoteModel) {
		_legal_ContentRemoteModel = legal_ContentRemoteModel;
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

		Class<?> remoteModelClass = _legal_ContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legal_ContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_ContentLocalServiceUtil.addLegal_Content(this);
		}
		else {
			Legal_ContentLocalServiceUtil.updateLegal_Content(this);
		}
	}

	@Override
	public Legal_Content toEscapedModel() {
		return (Legal_Content)ProxyUtil.newProxyInstance(Legal_Content.class.getClassLoader(),
			new Class[] { Legal_Content.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Legal_ContentClp clone = new Legal_ContentClp();

		clone.setID(getID());
		clone.setContentID(getContentID());
		clone.setVersion(getVersion());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setByline(getByline());
		clone.setHeadline(getHeadline());
		clone.setTagline(getTagline());
		clone.setTeaser(getTeaser());
		clone.setBody(getBody());
		clone.setAvatar(getAvatar());
		clone.setImageUrl(getImageUrl());
		clone.setImageDescription(getImageDescription());
		clone.setImageAlign(getImageAlign());
		clone.setZoneID(getZoneID());
		clone.setSource(getSource());
		clone.setStatus(getStatus());
		clone.setAuthor(getAuthor());
		clone.setEditor(getEditor());
		clone.setApprover(getApprover());
		clone.setDeployer(getDeployer());
		clone.setAuthors(getAuthors());

		return clone;
	}

	@Override
	public int compareTo(Legal_Content legal_Content) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				legal_Content.getModifiedDate());

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

		if (!(obj instanceof Legal_ContentClp)) {
			return false;
		}

		Legal_ContentClp legal_Content = (Legal_ContentClp)obj;

		int primaryKey = legal_Content.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", ContentID=");
		sb.append(getContentID());
		sb.append(", Version=");
		sb.append(getVersion());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Byline=");
		sb.append(getByline());
		sb.append(", Headline=");
		sb.append(getHeadline());
		sb.append(", Tagline=");
		sb.append(getTagline());
		sb.append(", Teaser=");
		sb.append(getTeaser());
		sb.append(", Body=");
		sb.append(getBody());
		sb.append(", Avatar=");
		sb.append(getAvatar());
		sb.append(", ImageUrl=");
		sb.append(getImageUrl());
		sb.append(", ImageDescription=");
		sb.append(getImageDescription());
		sb.append(", ImageAlign=");
		sb.append(getImageAlign());
		sb.append(", ZoneID=");
		sb.append(getZoneID());
		sb.append(", Source=");
		sb.append(getSource());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append(", Editor=");
		sb.append(getEditor());
		sb.append(", Approver=");
		sb.append(getApprover());
		sb.append(", Deployer=");
		sb.append(getDeployer());
		sb.append(", Authors=");
		sb.append(getAuthors());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Content");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ContentID</column-name><column-value><![CDATA[");
		sb.append(getContentID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Byline</column-name><column-value><![CDATA[");
		sb.append(getByline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Headline</column-name><column-value><![CDATA[");
		sb.append(getHeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tagline</column-name><column-value><![CDATA[");
		sb.append(getTagline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Teaser</column-name><column-value><![CDATA[");
		sb.append(getTeaser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Avatar</column-name><column-value><![CDATA[");
		sb.append(getAvatar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageDescription</column-name><column-value><![CDATA[");
		sb.append(getImageDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageAlign</column-name><column-value><![CDATA[");
		sb.append(getImageAlign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ZoneID</column-name><column-value><![CDATA[");
		sb.append(getZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Editor</column-name><column-value><![CDATA[");
		sb.append(getEditor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Approver</column-name><column-value><![CDATA[");
		sb.append(getApprover());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Deployer</column-name><column-value><![CDATA[");
		sb.append(getDeployer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Authors</column-name><column-value><![CDATA[");
		sb.append(getAuthors());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private int _ContentID;
	private int _Version;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _Byline;
	private String _Headline;
	private String _Tagline;
	private String _Teaser;
	private String _Body;
	private String _Avatar;
	private String _ImageUrl;
	private String _ImageDescription;
	private int _ImageAlign;
	private int _ZoneID;
	private String _Source;
	private int _Status;
	private String _Author;
	private String _Editor;
	private String _Approver;
	private String _Deployer;
	private String _Authors;
	private BaseModel<?> _legal_ContentRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}