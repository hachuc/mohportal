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

package com.viettel.portal.vbpq.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vbpq.service.ClpSerializer;
import com.viettel.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class LinhVucVanBanClp extends BaseModelImpl<LinhVucVanBan>
	implements LinhVucVanBan {
	public LinhVucVanBanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LinhVucVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return LinhVucVanBan.class.getName();
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
		attributes.put("ten", getTen());
		attributes.put("trangThai", getTrangThai());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("groupId", getGroupId());
		attributes.put("order_", getOrder_());
		attributes.put("nhomVanBanId", getNhomVanBanId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Long nhomVanBanId = (Long)attributes.get("nhomVanBanId");

		if (nhomVanBanId != null) {
			setNhomVanBanId(nhomVanBanId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_linhVucVanBanRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTen() {
		return _ten;
	}

	@Override
	public void setTen(String ten) {
		_ten = ten;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setTen", String.class);

				method.invoke(_linhVucVanBanRemoteModel, ten);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTrangThai() {
		return _trangThai;
	}

	@Override
	public boolean isTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(boolean trangThai) {
		_trangThai = trangThai;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setTrangThai", boolean.class);

				method.invoke(_linhVucVanBanRemoteModel, trangThai);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayTao() {
		return _ngayTao;
	}

	@Override
	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayTao", Date.class);

				method.invoke(_linhVucVanBanRemoteModel, ngayTao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgaySua() {
		return _ngaySua;
	}

	@Override
	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNgaySua", Date.class);

				method.invoke(_linhVucVanBanRemoteModel, ngaySua);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNguoiTao() {
		return _nguoiTao;
	}

	@Override
	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTao", String.class);

				method.invoke(_linhVucVanBanRemoteModel, nguoiTao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNguoiSua() {
		return _nguoiSua;
	}

	@Override
	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSua", String.class);

				method.invoke(_linhVucVanBanRemoteModel, nguoiSua);
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

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_linhVucVanBanRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOrder_() {
		return _order_;
	}

	@Override
	public void setOrder_(int order_) {
		_order_ = order_;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder_", int.class);

				method.invoke(_linhVucVanBanRemoteModel, order_);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNhomVanBanId() {
		return _nhomVanBanId;
	}

	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_nhomVanBanId = nhomVanBanId;

		if (_linhVucVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _linhVucVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNhomVanBanId", long.class);

				method.invoke(_linhVucVanBanRemoteModel, nhomVanBanId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLinhVucVanBanRemoteModel() {
		return _linhVucVanBanRemoteModel;
	}

	public void setLinhVucVanBanRemoteModel(
		BaseModel<?> linhVucVanBanRemoteModel) {
		_linhVucVanBanRemoteModel = linhVucVanBanRemoteModel;
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

		Class<?> remoteModelClass = _linhVucVanBanRemoteModel.getClass();

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

		Object returnValue = method.invoke(_linhVucVanBanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LinhVucVanBanLocalServiceUtil.addLinhVucVanBan(this);
		}
		else {
			LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(this);
		}
	}

	@Override
	public LinhVucVanBan toEscapedModel() {
		return (LinhVucVanBan)ProxyUtil.newProxyInstance(LinhVucVanBan.class.getClassLoader(),
			new Class[] { LinhVucVanBan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LinhVucVanBanClp clone = new LinhVucVanBanClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setTrangThai(getTrangThai());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setGroupId(getGroupId());
		clone.setOrder_(getOrder_());
		clone.setNhomVanBanId(getNhomVanBanId());

		return clone;
	}

	@Override
	public int compareTo(LinhVucVanBan linhVucVanBan) {
		int value = 0;

		if (getOrder_() < linhVucVanBan.getOrder_()) {
			value = -1;
		}
		else if (getOrder_() > linhVucVanBan.getOrder_()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getTen().compareTo(linhVucVanBan.getTen());

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

		if (!(obj instanceof LinhVucVanBanClp)) {
			return false;
		}

		LinhVucVanBanClp linhVucVanBan = (LinhVucVanBanClp)obj;

		long primaryKey = linhVucVanBan.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", order_=");
		sb.append(getOrder_());
		sb.append(", nhomVanBanId=");
		sb.append(getNhomVanBanId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vbpq.model.LinhVucVanBan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order_</column-name><column-value><![CDATA[");
		sb.append(getOrder_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomVanBanId</column-name><column-value><![CDATA[");
		sb.append(getNhomVanBanId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private boolean _trangThai;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _groupId;
	private int _order_;
	private long _nhomVanBanId;
	private BaseModel<?> _linhVucVanBanRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vbpq.service.ClpSerializer.class;
}