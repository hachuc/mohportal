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
import com.viettel.portal.magazine.service.MagazineZoneLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author namtv
 */
public class MagazineZoneClp extends BaseModelImpl<MagazineZone>
	implements MagazineZone {
	public MagazineZoneClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MagazineZone.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineZone.class.getName();
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
		attributes.put("Name", getName());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("SortOrder", getSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
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

		if (_magazineZoneRemoteModel != null) {
			try {
				Class<?> clazz = _magazineZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_magazineZoneRemoteModel, ID);
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

		if (_magazineZoneRemoteModel != null) {
			try {
				Class<?> clazz = _magazineZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_magazineZoneRemoteModel, Name);
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

		if (_magazineZoneRemoteModel != null) {
			try {
				Class<?> clazz = _magazineZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setMagazineID", int.class);

				method.invoke(_magazineZoneRemoteModel, MagazineID);
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

		if (_magazineZoneRemoteModel != null) {
			try {
				Class<?> clazz = _magazineZoneRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", int.class);

				method.invoke(_magazineZoneRemoteModel, SortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMagazineZoneRemoteModel() {
		return _magazineZoneRemoteModel;
	}

	public void setMagazineZoneRemoteModel(BaseModel<?> magazineZoneRemoteModel) {
		_magazineZoneRemoteModel = magazineZoneRemoteModel;
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

		Class<?> remoteModelClass = _magazineZoneRemoteModel.getClass();

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

		Object returnValue = method.invoke(_magazineZoneRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MagazineZoneLocalServiceUtil.addMagazineZone(this);
		}
		else {
			MagazineZoneLocalServiceUtil.updateMagazineZone(this);
		}
	}

	@Override
	public MagazineZone toEscapedModel() {
		return (MagazineZone)ProxyUtil.newProxyInstance(MagazineZone.class.getClassLoader(),
			new Class[] { MagazineZone.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MagazineZoneClp clone = new MagazineZoneClp();

		clone.setID(getID());
		clone.setName(getName());
		clone.setMagazineID(getMagazineID());
		clone.setSortOrder(getSortOrder());

		return clone;
	}

	@Override
	public int compareTo(MagazineZone magazineZone) {
		int value = 0;

		if (getSortOrder() < magazineZone.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > magazineZone.getSortOrder()) {
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

		if (!(obj instanceof MagazineZoneClp)) {
			return false;
		}

		MagazineZoneClp magazineZone = (MagazineZoneClp)obj;

		int primaryKey = magazineZone.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", MagazineID=");
		sb.append(getMagazineID());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.model.MagazineZone");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineID</column-name><column-value><![CDATA[");
		sb.append(getMagazineID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Name;
	private int _MagazineID;
	private int _SortOrder;
	private BaseModel<?> _magazineZoneRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.magazine.service.ClpSerializer.class;
}