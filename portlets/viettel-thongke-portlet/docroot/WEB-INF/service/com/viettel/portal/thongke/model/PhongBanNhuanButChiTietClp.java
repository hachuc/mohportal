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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.thongke.service.ClpSerializer;
import com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lamvn
 */
public class PhongBanNhuanButChiTietClp extends BaseModelImpl<PhongBanNhuanButChiTiet>
	implements PhongBanNhuanButChiTiet {
	public PhongBanNhuanButChiTietClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PhongBanNhuanButChiTiet.class;
	}

	@Override
	public String getModelClassName() {
		return PhongBanNhuanButChiTiet.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("phongBanNhuanButId", getPhongBanNhuanButId());
		attributes.put("phongBanId", getPhongBanId());
		attributes.put("phongBanTen", getPhongBanTen());
		attributes.put("rating", getRating());
		attributes.put("ratingValue", getRatingValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long phongBanNhuanButId = (Long)attributes.get("phongBanNhuanButId");

		if (phongBanNhuanButId != null) {
			setPhongBanNhuanButId(phongBanNhuanButId);
		}

		Long phongBanId = (Long)attributes.get("phongBanId");

		if (phongBanId != null) {
			setPhongBanId(phongBanId);
		}

		String phongBanTen = (String)attributes.get("phongBanTen");

		if (phongBanTen != null) {
			setPhongBanTen(phongBanTen);
		}

		String rating = (String)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Double ratingValue = (Double)attributes.get("ratingValue");

		if (ratingValue != null) {
			setRatingValue(ratingValue);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPhongBanNhuanButId() {
		return _phongBanNhuanButId;
	}

	@Override
	public void setPhongBanNhuanButId(long phongBanNhuanButId) {
		_phongBanNhuanButId = phongBanNhuanButId;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setPhongBanNhuanButId",
						long.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel,
					phongBanNhuanButId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPhongBanId() {
		return _phongBanId;
	}

	@Override
	public void setPhongBanId(long phongBanId) {
		_phongBanId = phongBanId;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setPhongBanId", long.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel, phongBanId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhongBanTen() {
		return _phongBanTen;
	}

	@Override
	public void setPhongBanTen(String phongBanTen) {
		_phongBanTen = phongBanTen;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setPhongBanTen", String.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel, phongBanTen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRating() {
		return _rating;
	}

	@Override
	public void setRating(String rating) {
		_rating = rating;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setRating", String.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel, rating);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRatingValue() {
		return _ratingValue;
	}

	@Override
	public void setRatingValue(double ratingValue) {
		_ratingValue = ratingValue;

		if (_phongBanNhuanButChiTietRemoteModel != null) {
			try {
				Class<?> clazz = _phongBanNhuanButChiTietRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingValue", double.class);

				method.invoke(_phongBanNhuanButChiTietRemoteModel, ratingValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPhongBanNhuanButChiTietRemoteModel() {
		return _phongBanNhuanButChiTietRemoteModel;
	}

	public void setPhongBanNhuanButChiTietRemoteModel(
		BaseModel<?> phongBanNhuanButChiTietRemoteModel) {
		_phongBanNhuanButChiTietRemoteModel = phongBanNhuanButChiTietRemoteModel;
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

		Class<?> remoteModelClass = _phongBanNhuanButChiTietRemoteModel.getClass();

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

		Object returnValue = method.invoke(_phongBanNhuanButChiTietRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PhongBanNhuanButChiTietLocalServiceUtil.addPhongBanNhuanButChiTiet(this);
		}
		else {
			PhongBanNhuanButChiTietLocalServiceUtil.updatePhongBanNhuanButChiTiet(this);
		}
	}

	@Override
	public PhongBanNhuanButChiTiet toEscapedModel() {
		return (PhongBanNhuanButChiTiet)ProxyUtil.newProxyInstance(PhongBanNhuanButChiTiet.class.getClassLoader(),
			new Class[] { PhongBanNhuanButChiTiet.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PhongBanNhuanButChiTietClp clone = new PhongBanNhuanButChiTietClp();

		clone.setId(getId());
		clone.setPhongBanNhuanButId(getPhongBanNhuanButId());
		clone.setPhongBanId(getPhongBanId());
		clone.setPhongBanTen(getPhongBanTen());
		clone.setRating(getRating());
		clone.setRatingValue(getRatingValue());

		return clone;
	}

	@Override
	public int compareTo(PhongBanNhuanButChiTiet phongBanNhuanButChiTiet) {
		int value = 0;

		if (getPhongBanNhuanButId() < phongBanNhuanButChiTiet.getPhongBanNhuanButId()) {
			value = -1;
		}
		else if (getPhongBanNhuanButId() > phongBanNhuanButChiTiet.getPhongBanNhuanButId()) {
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

		if (!(obj instanceof PhongBanNhuanButChiTietClp)) {
			return false;
		}

		PhongBanNhuanButChiTietClp phongBanNhuanButChiTiet = (PhongBanNhuanButChiTietClp)obj;

		long primaryKey = phongBanNhuanButChiTiet.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", phongBanNhuanButId=");
		sb.append(getPhongBanNhuanButId());
		sb.append(", phongBanId=");
		sb.append(getPhongBanId());
		sb.append(", phongBanTen=");
		sb.append(getPhongBanTen());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", ratingValue=");
		sb.append(getRatingValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phongBanNhuanButId</column-name><column-value><![CDATA[");
		sb.append(getPhongBanNhuanButId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phongBanId</column-name><column-value><![CDATA[");
		sb.append(getPhongBanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phongBanTen</column-name><column-value><![CDATA[");
		sb.append(getPhongBanTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingValue</column-name><column-value><![CDATA[");
		sb.append(getRatingValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _phongBanNhuanButId;
	private long _phongBanId;
	private String _phongBanTen;
	private String _rating;
	private double _ratingValue;
	private BaseModel<?> _phongBanNhuanButChiTietRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.thongke.service.ClpSerializer.class;
}