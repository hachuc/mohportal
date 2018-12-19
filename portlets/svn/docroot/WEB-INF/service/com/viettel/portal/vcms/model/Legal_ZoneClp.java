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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.Legal_ZoneLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class Legal_ZoneClp extends BaseModelImpl<Legal_Zone>
	implements Legal_Zone {
	public Legal_ZoneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Zone.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Zone.class.getName();
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
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("Name", getName());
		attributes.put("Url", getUrl());
		attributes.put("Description", getDescription());
		attributes.put("ParentID", getParentID());
		attributes.put("RealUrl", getRealUrl());
		attributes.put("Visible", getVisible());
		attributes.put("Archived", getArchived());
		attributes.put("SortOrder", getSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Url = (String)attributes.get("Url");

		if (Url != null) {
			setUrl(Url);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		Integer ParentID = (Integer)attributes.get("ParentID");

		if (ParentID != null) {
			setParentID(ParentID);
		}

		String RealUrl = (String)attributes.get("RealUrl");

		if (RealUrl != null) {
			setRealUrl(RealUrl);
		}

		Boolean Visible = (Boolean)attributes.get("Visible");

		if (Visible != null) {
			setVisible(Visible);
		}

		Boolean Archived = (Boolean)attributes.get("Archived");

		if (Archived != null) {
			setArchived(Archived);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_legal_ZoneRemoteModel, ID);
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

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_legal_ZoneRemoteModel, CreationDate);
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

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legal_ZoneRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _Name;
	}

	@Override
	public void setName(String Name) {
		_Name = Name;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_legal_ZoneRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _Url;
	}

	@Override
	public void setUrl(String Url) {
		_Url = Url;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_legal_ZoneRemoteModel, Url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _Description;
	}

	@Override
	public void setDescription(String Description) {
		_Description = Description;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_legal_ZoneRemoteModel, Description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getParentID() {
		return _ParentID;
	}

	@Override
	public void setParentID(int ParentID) {
		_ParentID = ParentID;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setParentID", int.class);

				method.invoke(_legal_ZoneRemoteModel, ParentID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRealUrl() {
		return _RealUrl;
	}

	@Override
	public void setRealUrl(String RealUrl) {
		_RealUrl = RealUrl;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setRealUrl", String.class);

				method.invoke(_legal_ZoneRemoteModel, RealUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVisible() {
		return _Visible;
	}

	@Override
	public boolean isVisible() {
		return _Visible;
	}

	@Override
	public void setVisible(boolean Visible) {
		_Visible = Visible;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setVisible", boolean.class);

				method.invoke(_legal_ZoneRemoteModel, Visible);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getArchived() {
		return _Archived;
	}

	@Override
	public boolean isArchived() {
		return _Archived;
	}

	@Override
	public void setArchived(boolean Archived) {
		_Archived = Archived;

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setArchived", boolean.class);

				method.invoke(_legal_ZoneRemoteModel, Archived);
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

		if (_legal_ZoneRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_legal_ZoneRemoteModel, SortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegal_ZoneRemoteModel() {
		return _legal_ZoneRemoteModel;
	}

	public void setLegal_ZoneRemoteModel(BaseModel<?> legal_ZoneRemoteModel) {
		_legal_ZoneRemoteModel = legal_ZoneRemoteModel;
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

		Class<?> remoteModelClass = _legal_ZoneRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legal_ZoneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_ZoneLocalServiceUtil.addLegal_Zone(this);
		}
		else {
			Legal_ZoneLocalServiceUtil.updateLegal_Zone(this);
		}
	}

	@Override
	public Legal_Zone toEscapedModel() {
		return (Legal_Zone)ProxyUtil.newProxyInstance(Legal_Zone.class.getClassLoader(),
			new Class[] { Legal_Zone.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Legal_ZoneClp clone = new Legal_ZoneClp();

		clone.setID(getID());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setDescription(getDescription());
		clone.setParentID(getParentID());
		clone.setRealUrl(getRealUrl());
		clone.setVisible(getVisible());
		clone.setArchived(getArchived());
		clone.setSortOrder(getSortOrder());

		return clone;
	}

	@Override
	public int compareTo(Legal_Zone legal_Zone) {
		int value = 0;

		if (getSortOrder() < legal_Zone.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > legal_Zone.getSortOrder()) {
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

		if (!(obj instanceof Legal_ZoneClp)) {
			return false;
		}

		Legal_ZoneClp legal_Zone = (Legal_ZoneClp)obj;

		int primaryKey = legal_Zone.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Url=");
		sb.append(getUrl());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append(", ParentID=");
		sb.append(getParentID());
		sb.append(", RealUrl=");
		sb.append(getRealUrl());
		sb.append(", Visible=");
		sb.append(getVisible());
		sb.append(", Archived=");
		sb.append(getArchived());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Zone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
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
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ParentID</column-name><column-value><![CDATA[");
		sb.append(getParentID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RealUrl</column-name><column-value><![CDATA[");
		sb.append(getRealUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Archived</column-name><column-value><![CDATA[");
		sb.append(getArchived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _Name;
	private String _Url;
	private String _Description;
	private int _ParentID;
	private String _RealUrl;
	private boolean _Visible;
	private boolean _Archived;
	private int _SortOrder;
	private BaseModel<?> _legal_ZoneRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}