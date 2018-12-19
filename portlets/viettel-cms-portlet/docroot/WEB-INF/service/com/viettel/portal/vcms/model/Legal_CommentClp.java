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
import com.viettel.portal.vcms.service.Legal_CommentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class Legal_CommentClp extends BaseModelImpl<Legal_Comment>
	implements Legal_Comment {
	public Legal_CommentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Comment.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Comment.class.getName();
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
		attributes.put("DistributionID", getDistributionID());
		attributes.put("Fullname", getFullname());
		attributes.put("Address", getAddress());
		attributes.put("Email", getEmail());
		attributes.put("Body", getBody());
		attributes.put("Visible", getVisible());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("IPAddress", getIPAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer DistributionID = (Integer)attributes.get("DistributionID");

		if (DistributionID != null) {
			setDistributionID(DistributionID);
		}

		String Fullname = (String)attributes.get("Fullname");

		if (Fullname != null) {
			setFullname(Fullname);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		Boolean Visible = (Boolean)attributes.get("Visible");

		if (Visible != null) {
			setVisible(Visible);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String IPAddress = (String)attributes.get("IPAddress");

		if (IPAddress != null) {
			setIPAddress(IPAddress);
		}
	}

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_legal_CommentRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDistributionID() {
		return _DistributionID;
	}

	@Override
	public void setDistributionID(int DistributionID) {
		_DistributionID = DistributionID;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributionID", int.class);

				method.invoke(_legal_CommentRemoteModel, DistributionID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullname() {
		return _Fullname;
	}

	@Override
	public void setFullname(String Fullname) {
		_Fullname = Fullname;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setFullname", String.class);

				method.invoke(_legal_CommentRemoteModel, Fullname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _Address;
	}

	@Override
	public void setAddress(String Address) {
		_Address = Address;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_legal_CommentRemoteModel, Address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _Email;
	}

	@Override
	public void setEmail(String Email) {
		_Email = Email;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_legal_CommentRemoteModel, Email);
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

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_legal_CommentRemoteModel, Body);
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

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setVisible", boolean.class);

				method.invoke(_legal_CommentRemoteModel, Visible);
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

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_legal_CommentRemoteModel, CreationDate);
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

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legal_CommentRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIPAddress() {
		return _IPAddress;
	}

	@Override
	public void setIPAddress(String IPAddress) {
		_IPAddress = IPAddress;

		if (_legal_CommentRemoteModel != null) {
			try {
				Class<?> clazz = _legal_CommentRemoteModel.getClass();

				Method method = clazz.getMethod("setIPAddress", String.class);

				method.invoke(_legal_CommentRemoteModel, IPAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegal_CommentRemoteModel() {
		return _legal_CommentRemoteModel;
	}

	public void setLegal_CommentRemoteModel(
		BaseModel<?> legal_CommentRemoteModel) {
		_legal_CommentRemoteModel = legal_CommentRemoteModel;
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

		Class<?> remoteModelClass = _legal_CommentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legal_CommentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_CommentLocalServiceUtil.addLegal_Comment(this);
		}
		else {
			Legal_CommentLocalServiceUtil.updateLegal_Comment(this);
		}
	}

	@Override
	public Legal_Comment toEscapedModel() {
		return (Legal_Comment)ProxyUtil.newProxyInstance(Legal_Comment.class.getClassLoader(),
			new Class[] { Legal_Comment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Legal_CommentClp clone = new Legal_CommentClp();

		clone.setID(getID());
		clone.setDistributionID(getDistributionID());
		clone.setFullname(getFullname());
		clone.setAddress(getAddress());
		clone.setEmail(getEmail());
		clone.setBody(getBody());
		clone.setVisible(getVisible());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIPAddress(getIPAddress());

		return clone;
	}

	@Override
	public int compareTo(Legal_Comment legal_Comment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				legal_Comment.getModifiedDate());

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

		if (!(obj instanceof Legal_CommentClp)) {
			return false;
		}

		Legal_CommentClp legal_Comment = (Legal_CommentClp)obj;

		int primaryKey = legal_Comment.getPrimaryKey();

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
		sb.append(", DistributionID=");
		sb.append(getDistributionID());
		sb.append(", Fullname=");
		sb.append(getFullname());
		sb.append(", Address=");
		sb.append(getAddress());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", Body=");
		sb.append(getBody());
		sb.append(", Visible=");
		sb.append(getVisible());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", IPAddress=");
		sb.append(getIPAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Comment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DistributionID</column-name><column-value><![CDATA[");
		sb.append(getDistributionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Fullname</column-name><column-value><![CDATA[");
		sb.append(getFullname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
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
			"<column><column-name>IPAddress</column-name><column-value><![CDATA[");
		sb.append(getIPAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private int _DistributionID;
	private String _Fullname;
	private String _Address;
	private String _Email;
	private String _Body;
	private boolean _Visible;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _IPAddress;
	private BaseModel<?> _legal_CommentRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}