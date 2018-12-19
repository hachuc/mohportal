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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.vbpq.service.ClpSerializer;
import com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class VanBanPhapQuyClp extends BaseModelImpl<VanBanPhapQuy>
	implements VanBanPhapQuy {
	public VanBanPhapQuyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VanBanPhapQuy.class;
	}

	@Override
	public String getModelClassName() {
		return VanBanPhapQuy.class.getName();
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
		attributes.put("maVanBan", getMaVanBan());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("trichYeu", getTrichYeu());
		attributes.put("coQuanBanHanh", getCoQuanBanHanh());
		attributes.put("loaiVanBan", getLoaiVanBan());
		attributes.put("linhVucVanBan", getLinhVucVanBan());
		attributes.put("ngayBanHanh", getNgayBanHanh());
		attributes.put("ngayCoHieuLuc", getNgayCoHieuLuc());
		attributes.put("ngayHetHieuLuc", getNgayHetHieuLuc());
		attributes.put("nguoiKy", getNguoiKy());
		attributes.put("vanBanThayThe", getVanBanThayThe());
		attributes.put("groupId", getGroupId());
		attributes.put("status", getStatus());
		attributes.put("statusByDate", getStatusByDate());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("nhomVanBanId", getNhomVanBanId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String maVanBan = (String)attributes.get("maVanBan");

		if (maVanBan != null) {
			setMaVanBan(maVanBan);
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

		String trichYeu = (String)attributes.get("trichYeu");

		if (trichYeu != null) {
			setTrichYeu(trichYeu);
		}

		Long coQuanBanHanh = (Long)attributes.get("coQuanBanHanh");

		if (coQuanBanHanh != null) {
			setCoQuanBanHanh(coQuanBanHanh);
		}

		Long loaiVanBan = (Long)attributes.get("loaiVanBan");

		if (loaiVanBan != null) {
			setLoaiVanBan(loaiVanBan);
		}

		Long linhVucVanBan = (Long)attributes.get("linhVucVanBan");

		if (linhVucVanBan != null) {
			setLinhVucVanBan(linhVucVanBan);
		}

		Date ngayBanHanh = (Date)attributes.get("ngayBanHanh");

		if (ngayBanHanh != null) {
			setNgayBanHanh(ngayBanHanh);
		}

		Date ngayCoHieuLuc = (Date)attributes.get("ngayCoHieuLuc");

		if (ngayCoHieuLuc != null) {
			setNgayCoHieuLuc(ngayCoHieuLuc);
		}

		Date ngayHetHieuLuc = (Date)attributes.get("ngayHetHieuLuc");

		if (ngayHetHieuLuc != null) {
			setNgayHetHieuLuc(ngayHetHieuLuc);
		}

		String nguoiKy = (String)attributes.get("nguoiKy");

		if (nguoiKy != null) {
			setNguoiKy(nguoiKy);
		}

		Long vanBanThayThe = (Long)attributes.get("vanBanThayThe");

		if (vanBanThayThe != null) {
			setVanBanThayThe(vanBanThayThe);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusByDate = (Date)attributes.get("statusByDate");

		if (statusByDate != null) {
			setStatusByDate(statusByDate);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaVanBan() {
		return _maVanBan;
	}

	@Override
	public void setMaVanBan(String maVanBan) {
		_maVanBan = maVanBan;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setMaVanBan", String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, maVanBan);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayTao", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, ngayTao);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNgaySua", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, ngaySua);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTao", String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, nguoiTao);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSua", String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, nguoiSua);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrichYeu() {
		return _trichYeu;
	}

	@Override
	public void setTrichYeu(String trichYeu) {
		_trichYeu = trichYeu;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setTrichYeu", String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, trichYeu);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoQuanBanHanh() {
		return _coQuanBanHanh;
	}

	@Override
	public void setCoQuanBanHanh(long coQuanBanHanh) {
		_coQuanBanHanh = coQuanBanHanh;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setCoQuanBanHanh", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, coQuanBanHanh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLoaiVanBan() {
		return _loaiVanBan;
	}

	@Override
	public void setLoaiVanBan(long loaiVanBan) {
		_loaiVanBan = loaiVanBan;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setLoaiVanBan", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, loaiVanBan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLinhVucVanBan() {
		return _linhVucVanBan;
	}

	@Override
	public void setLinhVucVanBan(long linhVucVanBan) {
		_linhVucVanBan = linhVucVanBan;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setLinhVucVanBan", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, linhVucVanBan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayBanHanh() {
		return _ngayBanHanh;
	}

	@Override
	public void setNgayBanHanh(Date ngayBanHanh) {
		_ngayBanHanh = ngayBanHanh;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayBanHanh", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, ngayBanHanh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayCoHieuLuc() {
		return _ngayCoHieuLuc;
	}

	@Override
	public void setNgayCoHieuLuc(Date ngayCoHieuLuc) {
		_ngayCoHieuLuc = ngayCoHieuLuc;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayCoHieuLuc", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, ngayCoHieuLuc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayHetHieuLuc() {
		return _ngayHetHieuLuc;
	}

	@Override
	public void setNgayHetHieuLuc(Date ngayHetHieuLuc) {
		_ngayHetHieuLuc = ngayHetHieuLuc;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayHetHieuLuc", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, ngayHetHieuLuc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNguoiKy() {
		return _nguoiKy;
	}

	@Override
	public void setNguoiKy(String nguoiKy) {
		_nguoiKy = nguoiKy;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiKy", String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, nguoiKy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVanBanThayThe() {
		return _vanBanThayThe;
	}

	@Override
	public void setVanBanThayThe(long vanBanThayThe) {
		_vanBanThayThe = vanBanThayThe;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setVanBanThayThe", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, vanBanThayThe);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_vanBanPhapQuyRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusByDate() {
		return _statusByDate;
	}

	@Override
	public void setStatusByDate(Date statusByDate) {
		_statusByDate = statusByDate;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByDate", Date.class);

				method.invoke(_vanBanPhapQuyRemoteModel, statusByDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_vanBanPhapQuyRemoteModel, statusByUserName);
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

		if (_vanBanPhapQuyRemoteModel != null) {
			try {
				Class<?> clazz = _vanBanPhapQuyRemoteModel.getClass();

				Method method = clazz.getMethod("setNhomVanBanId", long.class);

				method.invoke(_vanBanPhapQuyRemoteModel, nhomVanBanId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVanBanPhapQuyRemoteModel() {
		return _vanBanPhapQuyRemoteModel;
	}

	public void setVanBanPhapQuyRemoteModel(
		BaseModel<?> vanBanPhapQuyRemoteModel) {
		_vanBanPhapQuyRemoteModel = vanBanPhapQuyRemoteModel;
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

		Class<?> remoteModelClass = _vanBanPhapQuyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vanBanPhapQuyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VanBanPhapQuyLocalServiceUtil.addVanBanPhapQuy(this);
		}
		else {
			VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy(this);
		}
	}

	@Override
	public VanBanPhapQuy toEscapedModel() {
		return (VanBanPhapQuy)ProxyUtil.newProxyInstance(VanBanPhapQuy.class.getClassLoader(),
			new Class[] { VanBanPhapQuy.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VanBanPhapQuyClp clone = new VanBanPhapQuyClp();

		clone.setId(getId());
		clone.setMaVanBan(getMaVanBan());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setTrichYeu(getTrichYeu());
		clone.setCoQuanBanHanh(getCoQuanBanHanh());
		clone.setLoaiVanBan(getLoaiVanBan());
		clone.setLinhVucVanBan(getLinhVucVanBan());
		clone.setNgayBanHanh(getNgayBanHanh());
		clone.setNgayCoHieuLuc(getNgayCoHieuLuc());
		clone.setNgayHetHieuLuc(getNgayHetHieuLuc());
		clone.setNguoiKy(getNguoiKy());
		clone.setVanBanThayThe(getVanBanThayThe());
		clone.setGroupId(getGroupId());
		clone.setStatus(getStatus());
		clone.setStatusByDate(getStatusByDate());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setNhomVanBanId(getNhomVanBanId());

		return clone;
	}

	@Override
	public int compareTo(VanBanPhapQuy vanBanPhapQuy) {
		int value = 0;

		value = DateUtil.compareTo(getNgayBanHanh(),
				vanBanPhapQuy.getNgayBanHanh());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getNgayCoHieuLuc(),
				vanBanPhapQuy.getNgayCoHieuLuc());

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

		if (!(obj instanceof VanBanPhapQuyClp)) {
			return false;
		}

		VanBanPhapQuyClp vanBanPhapQuy = (VanBanPhapQuyClp)obj;

		long primaryKey = vanBanPhapQuy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", maVanBan=");
		sb.append(getMaVanBan());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", trichYeu=");
		sb.append(getTrichYeu());
		sb.append(", coQuanBanHanh=");
		sb.append(getCoQuanBanHanh());
		sb.append(", loaiVanBan=");
		sb.append(getLoaiVanBan());
		sb.append(", linhVucVanBan=");
		sb.append(getLinhVucVanBan());
		sb.append(", ngayBanHanh=");
		sb.append(getNgayBanHanh());
		sb.append(", ngayCoHieuLuc=");
		sb.append(getNgayCoHieuLuc());
		sb.append(", ngayHetHieuLuc=");
		sb.append(getNgayHetHieuLuc());
		sb.append(", nguoiKy=");
		sb.append(getNguoiKy());
		sb.append(", vanBanThayThe=");
		sb.append(getVanBanThayThe());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByDate=");
		sb.append(getStatusByDate());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", nhomVanBanId=");
		sb.append(getNhomVanBanId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vbpq.model.VanBanPhapQuy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maVanBan</column-name><column-value><![CDATA[");
		sb.append(getMaVanBan());
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
			"<column><column-name>trichYeu</column-name><column-value><![CDATA[");
		sb.append(getTrichYeu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanBanHanh</column-name><column-value><![CDATA[");
		sb.append(getCoQuanBanHanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiVanBan</column-name><column-value><![CDATA[");
		sb.append(getLoaiVanBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linhVucVanBan</column-name><column-value><![CDATA[");
		sb.append(getLinhVucVanBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayBanHanh</column-name><column-value><![CDATA[");
		sb.append(getNgayBanHanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCoHieuLuc</column-name><column-value><![CDATA[");
		sb.append(getNgayCoHieuLuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHetHieuLuc</column-name><column-value><![CDATA[");
		sb.append(getNgayHetHieuLuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiKy</column-name><column-value><![CDATA[");
		sb.append(getNguoiKy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vanBanThayThe</column-name><column-value><![CDATA[");
		sb.append(getVanBanThayThe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByDate</column-name><column-value><![CDATA[");
		sb.append(getStatusByDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nhomVanBanId</column-name><column-value><![CDATA[");
		sb.append(getNhomVanBanId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _maVanBan;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private String _trichYeu;
	private long _coQuanBanHanh;
	private long _loaiVanBan;
	private long _linhVucVanBan;
	private Date _ngayBanHanh;
	private Date _ngayCoHieuLuc;
	private Date _ngayHetHieuLuc;
	private String _nguoiKy;
	private long _vanBanThayThe;
	private long _groupId;
	private int _status;
	private Date _statusByDate;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private long _nhomVanBanId;
	private BaseModel<?> _vanBanPhapQuyRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vbpq.service.ClpSerializer.class;
}