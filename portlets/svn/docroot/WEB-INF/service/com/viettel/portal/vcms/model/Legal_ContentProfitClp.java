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
import com.viettel.portal.vcms.service.Legal_ContentProfitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class Legal_ContentProfitClp extends BaseModelImpl<Legal_ContentProfit>
	implements Legal_ContentProfit {
	public Legal_ContentProfitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_ContentProfit.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_ContentProfit.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _ContentID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setContentID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ContentID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ContentID", getContentID());
		attributes.put("ContentTypeID", getContentTypeID());
		attributes.put("Headline", getHeadline());
		attributes.put("Cost", getCost());
		attributes.put("Author", getAuthor());
		attributes.put("Status", getStatus());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("DistributedDate", getDistributedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer ContentTypeID = (Integer)attributes.get("ContentTypeID");

		if (ContentTypeID != null) {
			setContentTypeID(ContentTypeID);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		Double Cost = (Double)attributes.get("Cost");

		if (Cost != null) {
			setCost(Cost);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		Date DistributedDate = (Date)attributes.get("DistributedDate");

		if (DistributedDate != null) {
			setDistributedDate(DistributedDate);
		}
	}

	@Override
	public int getContentID() {
		return _ContentID;
	}

	@Override
	public void setContentID(int ContentID) {
		_ContentID = ContentID;

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setContentID", int.class);

				method.invoke(_legal_ContentProfitRemoteModel, ContentID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getContentTypeID() {
		return _ContentTypeID;
	}

	@Override
	public void setContentTypeID(int ContentTypeID) {
		_ContentTypeID = ContentTypeID;

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setContentTypeID", int.class);

				method.invoke(_legal_ContentProfitRemoteModel, ContentTypeID);
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

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadline", String.class);

				method.invoke(_legal_ContentProfitRemoteModel, Headline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCost() {
		return _Cost;
	}

	@Override
	public void setCost(double Cost) {
		_Cost = Cost;

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_legal_ContentProfitRemoteModel, Cost);
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

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_legal_ContentProfitRemoteModel, Author);
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

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_legal_ContentProfitRemoteModel, Status);
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

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreationDate", Date.class);

				method.invoke(_legal_ContentProfitRemoteModel, CreationDate);
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

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legal_ContentProfitRemoteModel, ModifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDistributedDate() {
		return _DistributedDate;
	}

	@Override
	public void setDistributedDate(Date DistributedDate) {
		_DistributedDate = DistributedDate;

		if (_legal_ContentProfitRemoteModel != null) {
			try {
				Class<?> clazz = _legal_ContentProfitRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributedDate", Date.class);

				method.invoke(_legal_ContentProfitRemoteModel, DistributedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegal_ContentProfitRemoteModel() {
		return _legal_ContentProfitRemoteModel;
	}

	public void setLegal_ContentProfitRemoteModel(
		BaseModel<?> legal_ContentProfitRemoteModel) {
		_legal_ContentProfitRemoteModel = legal_ContentProfitRemoteModel;
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

		Class<?> remoteModelClass = _legal_ContentProfitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legal_ContentProfitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_ContentProfitLocalServiceUtil.addLegal_ContentProfit(this);
		}
		else {
			Legal_ContentProfitLocalServiceUtil.updateLegal_ContentProfit(this);
		}
	}

	@Override
	public Legal_ContentProfit toEscapedModel() {
		return (Legal_ContentProfit)ProxyUtil.newProxyInstance(Legal_ContentProfit.class.getClassLoader(),
			new Class[] { Legal_ContentProfit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Legal_ContentProfitClp clone = new Legal_ContentProfitClp();

		clone.setContentID(getContentID());
		clone.setContentTypeID(getContentTypeID());
		clone.setHeadline(getHeadline());
		clone.setCost(getCost());
		clone.setAuthor(getAuthor());
		clone.setStatus(getStatus());
		clone.setCreationDate(getCreationDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDistributedDate(getDistributedDate());

		return clone;
	}

	@Override
	public int compareTo(Legal_ContentProfit legal_ContentProfit) {
		int value = 0;

		value = DateUtil.compareTo(getDistributedDate(),
				legal_ContentProfit.getDistributedDate());

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

		if (!(obj instanceof Legal_ContentProfitClp)) {
			return false;
		}

		Legal_ContentProfitClp legal_ContentProfit = (Legal_ContentProfitClp)obj;

		int primaryKey = legal_ContentProfit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{ContentID=");
		sb.append(getContentID());
		sb.append(", ContentTypeID=");
		sb.append(getContentTypeID());
		sb.append(", Headline=");
		sb.append(getHeadline());
		sb.append(", Cost=");
		sb.append(getCost());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", DistributedDate=");
		sb.append(getDistributedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_ContentProfit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ContentID</column-name><column-value><![CDATA[");
		sb.append(getContentID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ContentTypeID</column-name><column-value><![CDATA[");
		sb.append(getContentTypeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Headline</column-name><column-value><![CDATA[");
		sb.append(getHeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
			"<column><column-name>DistributedDate</column-name><column-value><![CDATA[");
		sb.append(getDistributedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ContentID;
	private int _ContentTypeID;
	private String _Headline;
	private double _Cost;
	private String _Author;
	private int _Status;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private Date _DistributedDate;
	private BaseModel<?> _legal_ContentProfitRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}