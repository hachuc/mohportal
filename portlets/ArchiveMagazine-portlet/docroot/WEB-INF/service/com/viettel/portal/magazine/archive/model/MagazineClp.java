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
import com.viettel.portal.magazine.archive.service.MagazineLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author namtv
 */
public class MagazineClp extends BaseModelImpl<Magazine> implements Magazine {
	public MagazineClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Magazine.class;
	}

	@Override
	public String getModelClassName() {
		return Magazine.class.getName();
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
		attributes.put("PublishNumber", getPublishNumber());
		attributes.put("PublishMonth", getPublishMonth());
		attributes.put("PublishYear", getPublishYear());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("MagazineType", getMagazineType());

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

		Integer PublishNumber = (Integer)attributes.get("PublishNumber");

		if (PublishNumber != null) {
			setPublishNumber(PublishNumber);
		}

		Integer PublishMonth = (Integer)attributes.get("PublishMonth");

		if (PublishMonth != null) {
			setPublishMonth(PublishMonth);
		}

		Integer PublishYear = (Integer)attributes.get("PublishYear");

		if (PublishYear != null) {
			setPublishYear(PublishYear);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		Integer MagazineType = (Integer)attributes.get("MagazineType");

		if (MagazineType != null) {
			setMagazineType(MagazineType);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_magazineRemoteModel, ID);
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

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_magazineRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublishNumber() {
		return _PublishNumber;
	}

	@Override
	public void setPublishNumber(int PublishNumber) {
		_PublishNumber = PublishNumber;

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishNumber", int.class);

				method.invoke(_magazineRemoteModel, PublishNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublishMonth() {
		return _PublishMonth;
	}

	@Override
	public void setPublishMonth(int PublishMonth) {
		_PublishMonth = PublishMonth;

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishMonth", int.class);

				method.invoke(_magazineRemoteModel, PublishMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPublishYear() {
		return _PublishYear;
	}

	@Override
	public void setPublishYear(int PublishYear) {
		_PublishYear = PublishYear;

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishYear", int.class);

				method.invoke(_magazineRemoteModel, PublishYear);
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

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_magazineRemoteModel, ImageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMagazineType() {
		return _MagazineType;
	}

	@Override
	public void setMagazineType(int MagazineType) {
		_MagazineType = MagazineType;

		if (_magazineRemoteModel != null) {
			try {
				Class<?> clazz = _magazineRemoteModel.getClass();

				Method method = clazz.getMethod("setMagazineType", int.class);

				method.invoke(_magazineRemoteModel, MagazineType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMagazineRemoteModel() {
		return _magazineRemoteModel;
	}

	public void setMagazineRemoteModel(BaseModel<?> magazineRemoteModel) {
		_magazineRemoteModel = magazineRemoteModel;
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

		Class<?> remoteModelClass = _magazineRemoteModel.getClass();

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

		Object returnValue = method.invoke(_magazineRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MagazineLocalServiceUtil.addMagazine(this);
		}
		else {
			MagazineLocalServiceUtil.updateMagazine(this);
		}
	}

	@Override
	public Magazine toEscapedModel() {
		return (Magazine)ProxyUtil.newProxyInstance(Magazine.class.getClassLoader(),
			new Class[] { Magazine.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MagazineClp clone = new MagazineClp();

		clone.setID(getID());
		clone.setName(getName());
		clone.setPublishNumber(getPublishNumber());
		clone.setPublishMonth(getPublishMonth());
		clone.setPublishYear(getPublishYear());
		clone.setImageUrl(getImageUrl());
		clone.setMagazineType(getMagazineType());

		return clone;
	}

	@Override
	public int compareTo(Magazine magazine) {
		int value = 0;

		if (getPublishYear() < magazine.getPublishYear()) {
			value = -1;
		}
		else if (getPublishYear() > magazine.getPublishYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPublishMonth() < magazine.getPublishMonth()) {
			value = -1;
		}
		else if (getPublishMonth() > magazine.getPublishMonth()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPublishNumber() < magazine.getPublishNumber()) {
			value = -1;
		}
		else if (getPublishNumber() > magazine.getPublishNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof MagazineClp)) {
			return false;
		}

		MagazineClp magazine = (MagazineClp)obj;

		int primaryKey = magazine.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", PublishNumber=");
		sb.append(getPublishNumber());
		sb.append(", PublishMonth=");
		sb.append(getPublishMonth());
		sb.append(", PublishYear=");
		sb.append(getPublishYear());
		sb.append(", ImageUrl=");
		sb.append(getImageUrl());
		sb.append(", MagazineType=");
		sb.append(getMagazineType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.archive.model.Magazine");
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
			"<column><column-name>PublishNumber</column-name><column-value><![CDATA[");
		sb.append(getPublishNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PublishMonth</column-name><column-value><![CDATA[");
		sb.append(getPublishMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PublishYear</column-name><column-value><![CDATA[");
		sb.append(getPublishYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineType</column-name><column-value><![CDATA[");
		sb.append(getMagazineType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private String _Name;
	private int _PublishNumber;
	private int _PublishMonth;
	private int _PublishYear;
	private String _ImageUrl;
	private int _MagazineType;
	private BaseModel<?> _magazineRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.magazine.archive.service.ClpSerializer.class;
}