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

package com.viettel.portal.thongke.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.thongke.service.ClpSerializer;
import com.viettel.portal.thongke.service.ContentTypeCostLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lamvn
 */
public class ContentTypeCostClp extends BaseModelImpl<ContentTypeCost>
	implements ContentTypeCost {
	public ContentTypeCostClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ContentTypeCost.class;
	}

	@Override
	public String getModelClassName() {
		return ContentTypeCost.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _costId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setCostId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _costId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("costId", getCostId());
		attributes.put("groupId", getGroupId());
		attributes.put("contentTypeID", getContentTypeID());
		attributes.put("fromDate", getFromDate());
		attributes.put("toDate", getToDate());
		attributes.put("cost", getCost());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer costId = (Integer)attributes.get("costId");

		if (costId != null) {
			setCostId(costId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer contentTypeID = (Integer)attributes.get("contentTypeID");

		if (contentTypeID != null) {
			setContentTypeID(contentTypeID);
		}

		Date fromDate = (Date)attributes.get("fromDate");

		if (fromDate != null) {
			setFromDate(fromDate);
		}

		Date toDate = (Date)attributes.get("toDate");

		if (toDate != null) {
			setToDate(toDate);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}
	}

	@Override
	public int getCostId() {
		return _costId;
	}

	@Override
	public void setCostId(int costId) {
		_costId = costId;

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setCostId", int.class);

				method.invoke(_contentTypeCostRemoteModel, costId);
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

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_contentTypeCostRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getContentTypeID() {
		return _contentTypeID;
	}

	@Override
	public void setContentTypeID(int contentTypeID) {
		_contentTypeID = contentTypeID;

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setContentTypeID", int.class);

				method.invoke(_contentTypeCostRemoteModel, contentTypeID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFromDate() {
		return _fromDate;
	}

	@Override
	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setFromDate", Date.class);

				method.invoke(_contentTypeCostRemoteModel, fromDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getToDate() {
		return _toDate;
	}

	@Override
	public void setToDate(Date toDate) {
		_toDate = toDate;

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setToDate", Date.class);

				method.invoke(_contentTypeCostRemoteModel, toDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;

		if (_contentTypeCostRemoteModel != null) {
			try {
				Class<?> clazz = _contentTypeCostRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_contentTypeCostRemoteModel, cost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContentTypeCostRemoteModel() {
		return _contentTypeCostRemoteModel;
	}

	public void setContentTypeCostRemoteModel(
		BaseModel<?> contentTypeCostRemoteModel) {
		_contentTypeCostRemoteModel = contentTypeCostRemoteModel;
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

		Class<?> remoteModelClass = _contentTypeCostRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contentTypeCostRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContentTypeCostLocalServiceUtil.addContentTypeCost(this);
		}
		else {
			ContentTypeCostLocalServiceUtil.updateContentTypeCost(this);
		}
	}

	@Override
	public ContentTypeCost toEscapedModel() {
		return (ContentTypeCost)ProxyUtil.newProxyInstance(ContentTypeCost.class.getClassLoader(),
			new Class[] { ContentTypeCost.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContentTypeCostClp clone = new ContentTypeCostClp();

		clone.setCostId(getCostId());
		clone.setGroupId(getGroupId());
		clone.setContentTypeID(getContentTypeID());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setCost(getCost());

		return clone;
	}

	@Override
	public int compareTo(ContentTypeCost contentTypeCost) {
		int value = 0;

		value = DateUtil.compareTo(getToDate(), contentTypeCost.getToDate());

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

		if (!(obj instanceof ContentTypeCostClp)) {
			return false;
		}

		ContentTypeCostClp contentTypeCost = (ContentTypeCostClp)obj;

		int primaryKey = contentTypeCost.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{costId=");
		sb.append(getCostId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", contentTypeID=");
		sb.append(getContentTypeID());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.thongke.model.ContentTypeCost");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>costId</column-name><column-value><![CDATA[");
		sb.append(getCostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentTypeID</column-name><column-value><![CDATA[");
		sb.append(getContentTypeID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _costId;
	private long _groupId;
	private int _contentTypeID;
	private Date _fromDate;
	private Date _toDate;
	private double _cost;
	private BaseModel<?> _contentTypeCostRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.thongke.service.ClpSerializer.class;
}