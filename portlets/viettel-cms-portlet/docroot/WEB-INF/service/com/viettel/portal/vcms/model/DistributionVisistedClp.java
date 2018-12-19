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
import com.viettel.portal.vcms.service.DistributionVisistedLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class DistributionVisistedClp extends BaseModelImpl<DistributionVisisted>
	implements DistributionVisisted {
	public DistributionVisistedClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DistributionVisisted.class;
	}

	@Override
	public String getModelClassName() {
		return DistributionVisisted.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _visistedId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVisistedId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _visistedId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visistedId", getVisistedId());
		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long visistedId = (Long)attributes.get("visistedId");

		if (visistedId != null) {
			setVisistedId(visistedId);
		}

		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getVisistedId() {
		return _visistedId;
	}

	@Override
	public void setVisistedId(long visistedId) {
		_visistedId = visistedId;

		if (_distributionVisistedRemoteModel != null) {
			try {
				Class<?> clazz = _distributionVisistedRemoteModel.getClass();

				Method method = clazz.getMethod("setVisistedId", long.class);

				method.invoke(_distributionVisistedRemoteModel, visistedId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDistributionId() {
		return _distributionId;
	}

	@Override
	public void setDistributionId(long distributionId) {
		_distributionId = distributionId;

		if (_distributionVisistedRemoteModel != null) {
			try {
				Class<?> clazz = _distributionVisistedRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributionId", long.class);

				method.invoke(_distributionVisistedRemoteModel, distributionId);
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

		if (_distributionVisistedRemoteModel != null) {
			try {
				Class<?> clazz = _distributionVisistedRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_distributionVisistedRemoteModel, groupId);
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

		if (_distributionVisistedRemoteModel != null) {
			try {
				Class<?> clazz = _distributionVisistedRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_distributionVisistedRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDistributionVisistedRemoteModel() {
		return _distributionVisistedRemoteModel;
	}

	public void setDistributionVisistedRemoteModel(
		BaseModel<?> distributionVisistedRemoteModel) {
		_distributionVisistedRemoteModel = distributionVisistedRemoteModel;
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

		Class<?> remoteModelClass = _distributionVisistedRemoteModel.getClass();

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

		Object returnValue = method.invoke(_distributionVisistedRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DistributionVisistedLocalServiceUtil.addDistributionVisisted(this);
		}
		else {
			DistributionVisistedLocalServiceUtil.updateDistributionVisisted(this);
		}
	}

	@Override
	public DistributionVisisted toEscapedModel() {
		return (DistributionVisisted)ProxyUtil.newProxyInstance(DistributionVisisted.class.getClassLoader(),
			new Class[] { DistributionVisisted.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DistributionVisistedClp clone = new DistributionVisistedClp();

		clone.setVisistedId(getVisistedId());
		clone.setDistributionId(getDistributionId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(DistributionVisisted distributionVisisted) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				distributionVisisted.getCreateDate());

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

		if (!(obj instanceof DistributionVisistedClp)) {
			return false;
		}

		DistributionVisistedClp distributionVisisted = (DistributionVisistedClp)obj;

		long primaryKey = distributionVisisted.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{visistedId=");
		sb.append(getVisistedId());
		sb.append(", distributionId=");
		sb.append(getDistributionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.DistributionVisisted");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>visistedId</column-name><column-value><![CDATA[");
		sb.append(getVisistedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distributionId</column-name><column-value><![CDATA[");
		sb.append(getDistributionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _visistedId;
	private long _distributionId;
	private long _groupId;
	private Date _createDate;
	private BaseModel<?> _distributionVisistedRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}