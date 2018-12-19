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

package com.viettel.portal.magazine.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.magazine.service.ClpSerializer;
import com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author namtv
 */
public class MagazineContentClp extends BaseModelImpl<MagazineContent>
	implements MagazineContent {
	public MagazineContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MagazineContent.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineContent.class.getName();
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
		attributes.put("Headline", getHeadline());
		attributes.put("Teaser", getTeaser());
		attributes.put("Body", getBody());
		attributes.put("MagazineZoneID", getMagazineZoneID());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("Author", getAuthor());
		attributes.put("Jobtitle", getJobtitle());
		attributes.put("ViewedCount", getViewedCount());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("MailedCount", getMailedCount());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		String Teaser = (String)attributes.get("Teaser");

		if (Teaser != null) {
			setTeaser(Teaser);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		Integer MagazineZoneID = (Integer)attributes.get("MagazineZoneID");

		if (MagazineZoneID != null) {
			setMagazineZoneID(MagazineZoneID);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String Jobtitle = (String)attributes.get("Jobtitle");

		if (Jobtitle != null) {
			setJobtitle(Jobtitle);
		}

		Integer ViewedCount = (Integer)attributes.get("ViewedCount");

		if (ViewedCount != null) {
			setViewedCount(ViewedCount);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Integer MailedCount = (Integer)attributes.get("MailedCount");

		if (MailedCount != null) {
			setMailedCount(MailedCount);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_magazineContentRemoteModel, ID);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadline", String.class);

				method.invoke(_magazineContentRemoteModel, Headline);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTeaser", String.class);

				method.invoke(_magazineContentRemoteModel, Teaser);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_magazineContentRemoteModel, Body);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMagazineZoneID() {
		return _MagazineZoneID;
	}

	@Override
	public void setMagazineZoneID(int MagazineZoneID) {
		_MagazineZoneID = MagazineZoneID;

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setMagazineZoneID", int.class);

				method.invoke(_magazineContentRemoteModel, MagazineZoneID);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setMagazineID", int.class);

				method.invoke(_magazineContentRemoteModel, MagazineID);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_magazineContentRemoteModel, Author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobtitle() {
		return _Jobtitle;
	}

	@Override
	public void setJobtitle(String Jobtitle) {
		_Jobtitle = Jobtitle;

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setJobtitle", String.class);

				method.invoke(_magazineContentRemoteModel, Jobtitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewedCount() {
		return _ViewedCount;
	}

	@Override
	public void setViewedCount(int ViewedCount) {
		_ViewedCount = ViewedCount;

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setViewedCount", int.class);

				method.invoke(_magazineContentRemoteModel, ViewedCount);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_magazineContentRemoteModel, SortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMailedCount() {
		return _MailedCount;
	}

	@Override
	public void setMailedCount(int MailedCount) {
		_MailedCount = MailedCount;

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setMailedCount", int.class);

				method.invoke(_magazineContentRemoteModel, MailedCount);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_magazineContentRemoteModel, CreationDate);
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

		if (_magazineContentRemoteModel != null) {
			try {
				Class<?> clazz = _magazineContentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_magazineContentRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMagazineContentRemoteModel() {
		return _magazineContentRemoteModel;
	}

	public void setMagazineContentRemoteModel(
		BaseModel<?> magazineContentRemoteModel) {
		_magazineContentRemoteModel = magazineContentRemoteModel;
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

		Class<?> remoteModelClass = _magazineContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_magazineContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MagazineContentLocalServiceUtil.addMagazineContent(this);
		}
		else {
			MagazineContentLocalServiceUtil.updateMagazineContent(this);
		}
	}

	@Override
	public MagazineContent toEscapedModel() {
		return (MagazineContent)ProxyUtil.newProxyInstance(MagazineContent.class.getClassLoader(),
			new Class[] { MagazineContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MagazineContentClp clone = new MagazineContentClp();

		clone.setID(getID());
		clone.setHeadline(getHeadline());
		clone.setTeaser(getTeaser());
		clone.setBody(getBody());
		clone.setMagazineZoneID(getMagazineZoneID());
		clone.setMagazineID(getMagazineID());
		clone.setAuthor(getAuthor());
		clone.setJobtitle(getJobtitle());
		clone.setViewedCount(getViewedCount());
		clone.setSortOrder(getSortOrder());
		clone.setMailedCount(getMailedCount());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(MagazineContent magazineContent) {
		int value = 0;

		if (getSortOrder() < magazineContent.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > magazineContent.getSortOrder()) {
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

		if (!(obj instanceof MagazineContentClp)) {
			return false;
		}

		MagazineContentClp magazineContent = (MagazineContentClp)obj;

		int primaryKey = magazineContent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Headline=");
		sb.append(getHeadline());
		sb.append(", Teaser=");
		sb.append(getTeaser());
		sb.append(", Body=");
		sb.append(getBody());
		sb.append(", MagazineZoneID=");
		sb.append(getMagazineZoneID());
		sb.append(", MagazineID=");
		sb.append(getMagazineID());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append(", Jobtitle=");
		sb.append(getJobtitle());
		sb.append(", ViewedCount=");
		sb.append(getViewedCount());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append(", MailedCount=");
		sb.append(getMailedCount());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.model.MagazineContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Headline</column-name><column-value><![CDATA[");
		sb.append(getHeadline());
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
			"<column><column-name>MagazineZoneID</column-name><column-value><![CDATA[");
		sb.append(getMagazineZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineID</column-name><column-value><![CDATA[");
		sb.append(getMagazineID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Jobtitle</column-name><column-value><![CDATA[");
		sb.append(getJobtitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewedCount</column-name><column-value><![CDATA[");
		sb.append(getViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MailedCount</column-name><column-value><![CDATA[");
		sb.append(getMailedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Headline;
	private String _Teaser;
	private String _Body;
	private int _MagazineZoneID;
	private int _MagazineID;
	private String _Author;
	private String _Jobtitle;
	private int _ViewedCount;
	private int _SortOrder;
	private int _MailedCount;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private BaseModel<?> _magazineContentRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.magazine.service.ClpSerializer.class;
}