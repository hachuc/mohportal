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
import com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class NhomVanBanClp extends BaseModelImpl<NhomVanBan>
	implements NhomVanBan {
	public NhomVanBanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NhomVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return NhomVanBan.class.getName();
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
		attributes.put("tenNhom", getTenNhom());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiTaoId", getNguoiTaoId());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("nguoiSuaId", getNguoiSuaId());
		attributes.put("trangThai", getTrangThai());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tenNhom = (String)attributes.get("tenNhom");

		if (tenNhom != null) {
			setTenNhom(tenNhom);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		Long nguoiTaoId = (Long)attributes.get("nguoiTaoId");

		if (nguoiTaoId != null) {
			setNguoiTaoId(nguoiTaoId);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long nguoiSuaId = (Long)attributes.get("nguoiSuaId");

		if (nguoiSuaId != null) {
			setNguoiSuaId(nguoiSuaId);
		}

		Integer trangThai = (Integer)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_nhomVanBanRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTenNhom() {
		return _tenNhom;
	}

	@Override
	public void setTenNhom(String tenNhom) {
		_tenNhom = tenNhom;

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setTenNhom", String.class);

				method.invoke(_nhomVanBanRemoteModel, tenNhom);
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

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTao", String.class);

				method.invoke(_nhomVanBanRemoteModel, nguoiTao);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNguoiTaoId() {
		return _nguoiTaoId;
	}

	@Override
	public void setNguoiTaoId(long nguoiTaoId) {
		_nguoiTaoId = nguoiTaoId;

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTaoId", long.class);

				method.invoke(_nhomVanBanRemoteModel, nguoiTaoId);
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

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayTao", Date.class);

				method.invoke(_nhomVanBanRemoteModel, ngayTao);
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

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNgaySua", Date.class);

				method.invoke(_nhomVanBanRemoteModel, ngaySua);
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

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSua", String.class);

				method.invoke(_nhomVanBanRemoteModel, nguoiSua);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNguoiSuaId() {
		return _nguoiSuaId;
	}

	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_nguoiSuaId = nguoiSuaId;

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSuaId", long.class);

				method.invoke(_nhomVanBanRemoteModel, nguoiSuaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setTrangThai", int.class);

				method.invoke(_nhomVanBanRemoteModel, trangThai);
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

		if (_nhomVanBanRemoteModel != null) {
			try {
				Class<?> clazz = _nhomVanBanRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_nhomVanBanRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNhomVanBanRemoteModel() {
		return _nhomVanBanRemoteModel;
	}

	public void setNhomVanBanRemoteModel(BaseModel<?> nhomVanBanRemoteModel) {
		_nhomVanBanRemoteModel = nhomVanBanRemoteModel;
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

		Class<?> remoteModelClass = _nhomVanBanRemoteModel.getClass();

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

		Object returnValue = method.invoke(_nhomVanBanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NhomVanBanLocalServiceUtil.addNhomVanBan(this);
		}
		else {
			NhomVanBanLocalServiceUtil.updateNhomVanBan(this);
		}
	}

	@Override
	public NhomVanBan toEscapedModel() {
		return (NhomVanBan)ProxyUtil.newProxyInstance(NhomVanBan.class.getClassLoader(),
			new Class[] { NhomVanBan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NhomVanBanClp clone = new NhomVanBanClp();

		clone.setId(getId());
		clone.setTenNhom(getTenNhom());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiTaoId(getNguoiTaoId());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiSua(getNguoiSua());
		clone.setNguoiSuaId(getNguoiSuaId());
		clone.setTrangThai(getTrangThai());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(NhomVanBan nhomVanBan) {
		long primaryKey = nhomVanBan.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NhomVanBanClp)) {
			return false;
		}

		NhomVanBanClp nhomVanBan = (NhomVanBanClp)obj;

		long primaryKey = nhomVanBan.getPrimaryKey();

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
		sb.append(", tenNhom=");
		sb.append(getTenNhom());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiTaoId=");
		sb.append(getNguoiTaoId());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", nguoiSuaId=");
		sb.append(getNguoiSuaId());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vbpq.model.NhomVanBan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenNhom</column-name><column-value><![CDATA[");
		sb.append(getTenNhom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTaoId</column-name><column-value><![CDATA[");
		sb.append(getNguoiTaoId());
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
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSuaId</column-name><column-value><![CDATA[");
		sb.append(getNguoiSuaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _tenNhom;
	private String _nguoiTao;
	private long _nguoiTaoId;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private long _nguoiSuaId;
	private int _trangThai;
	private long _groupId;
	private BaseModel<?> _nhomVanBanRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vbpq.service.ClpSerializer.class;
}