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

package com.viettel.portal.banner.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.banner.service.BannerLocalServiceUtil;
import com.viettel.portal.banner.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChucHV
 */
public class BannerClp extends BaseModelImpl<Banner> implements Banner {
	public BannerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Banner.class;
	}

	@Override
	public String getModelClassName() {
		return Banner.class.getName();
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
		attributes.put("fileId", getFileId());
		attributes.put("fileLink", getFileLink());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("ngayKetThuc", getNgayKetThuc());
		attributes.put("lienKet", getLienKet());
		attributes.put("order_", getOrder_());
		attributes.put("trangThai", getTrangThai());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("nguoiTaoId", getNguoiTaoId());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("nguoiSuaId", getNguoiSuaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

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

		Long fileId = (Long)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}

		String fileLink = (String)attributes.get("fileLink");

		if (fileLink != null) {
			setFileLink(fileLink);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		Date ngayKetThuc = (Date)attributes.get("ngayKetThuc");

		if (ngayKetThuc != null) {
			setNgayKetThuc(ngayKetThuc);
		}

		String lienKet = (String)attributes.get("lienKet");

		if (lienKet != null) {
			setLienKet(lienKet);
		}

		Integer order_ = (Integer)attributes.get("order_");

		if (order_ != null) {
			setOrder_(order_);
		}

		Boolean trangThai = (Boolean)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
		}

		String nguoiTao = (String)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		Long nguoiTaoId = (Long)attributes.get("nguoiTaoId");

		if (nguoiTaoId != null) {
			setNguoiTaoId(nguoiTaoId);
		}

		String nguoiSua = (String)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Long nguoiSuaId = (Long)attributes.get("nguoiSuaId");

		if (nguoiSuaId != null) {
			setNguoiSuaId(nguoiSuaId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_bannerRemoteModel, id);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setTen", String.class);

				method.invoke(_bannerRemoteModel, ten);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setFileId", long.class);

				method.invoke(_bannerRemoteModel, fileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileLink() {
		return _fileLink;
	}

	@Override
	public void setFileLink(String fileLink) {
		_fileLink = fileLink;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setFileLink", String.class);

				method.invoke(_bannerRemoteModel, fileLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_bannerRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_bannerRemoteModel, fileSize);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayTao", Date.class);

				method.invoke(_bannerRemoteModel, ngayTao);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNgaySua", Date.class);

				method.invoke(_bannerRemoteModel, ngaySua);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		_ngayKetThuc = ngayKetThuc;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayKetThuc", Date.class);

				method.invoke(_bannerRemoteModel, ngayKetThuc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLienKet() {
		return _lienKet;
	}

	@Override
	public void setLienKet(String lienKet) {
		_lienKet = lienKet;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setLienKet", String.class);

				method.invoke(_bannerRemoteModel, lienKet);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder_", int.class);

				method.invoke(_bannerRemoteModel, order_);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setTrangThai", boolean.class);

				method.invoke(_bannerRemoteModel, trangThai);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTao", String.class);

				method.invoke(_bannerRemoteModel, nguoiTao);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiTaoId", long.class);

				method.invoke(_bannerRemoteModel, nguoiTaoId);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSua", String.class);

				method.invoke(_bannerRemoteModel, nguoiSua);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setNguoiSuaId", long.class);

				method.invoke(_bannerRemoteModel, nguoiSuaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_bannerRemoteModel, companyId);
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

		if (_bannerRemoteModel != null) {
			try {
				Class<?> clazz = _bannerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_bannerRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBannerRemoteModel() {
		return _bannerRemoteModel;
	}

	public void setBannerRemoteModel(BaseModel<?> bannerRemoteModel) {
		_bannerRemoteModel = bannerRemoteModel;
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

		Class<?> remoteModelClass = _bannerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bannerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BannerLocalServiceUtil.addBanner(this);
		}
		else {
			BannerLocalServiceUtil.updateBanner(this);
		}
	}

	@Override
	public Banner toEscapedModel() {
		return (Banner)ProxyUtil.newProxyInstance(Banner.class.getClassLoader(),
			new Class[] { Banner.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BannerClp clone = new BannerClp();

		clone.setId(getId());
		clone.setTen(getTen());
		clone.setFileId(getFileId());
		clone.setFileLink(getFileLink());
		clone.setFileName(getFileName());
		clone.setFileSize(getFileSize());
		clone.setNgayTao(getNgayTao());
		clone.setNgaySua(getNgaySua());
		clone.setNgayKetThuc(getNgayKetThuc());
		clone.setLienKet(getLienKet());
		clone.setOrder_(getOrder_());
		clone.setTrangThai(getTrangThai());
		clone.setNguoiTao(getNguoiTao());
		clone.setNguoiTaoId(getNguoiTaoId());
		clone.setNguoiSua(getNguoiSua());
		clone.setNguoiSuaId(getNguoiSuaId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(Banner banner) {
		int value = 0;

		if (getOrder_() < banner.getOrder_()) {
			value = -1;
		}
		else if (getOrder_() > banner.getOrder_()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getTen().compareTo(banner.getTen());

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

		if (!(obj instanceof BannerClp)) {
			return false;
		}

		BannerClp banner = (BannerClp)obj;

		long primaryKey = banner.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", fileId=");
		sb.append(getFileId());
		sb.append(", fileLink=");
		sb.append(getFileLink());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", ngayKetThuc=");
		sb.append(getNgayKetThuc());
		sb.append(", lienKet=");
		sb.append(getLienKet());
		sb.append(", order_=");
		sb.append(getOrder_());
		sb.append(", trangThai=");
		sb.append(getTrangThai());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", nguoiTaoId=");
		sb.append(getNguoiTaoId());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", nguoiSuaId=");
		sb.append(getNguoiSuaId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.banner.model.Banner");
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
			"<column><column-name>fileId</column-name><column-value><![CDATA[");
		sb.append(getFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileLink</column-name><column-value><![CDATA[");
		sb.append(getFileLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
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
			"<column><column-name>ngayKetThuc</column-name><column-value><![CDATA[");
		sb.append(getNgayKetThuc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lienKet</column-name><column-value><![CDATA[");
		sb.append(getLienKet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order_</column-name><column-value><![CDATA[");
		sb.append(getOrder_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThai</column-name><column-value><![CDATA[");
		sb.append(getTrangThai());
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
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSuaId</column-name><column-value><![CDATA[");
		sb.append(getNguoiSuaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _ten;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private Date _ngayTao;
	private Date _ngaySua;
	private Date _ngayKetThuc;
	private String _lienKet;
	private int _order_;
	private boolean _trangThai;
	private String _nguoiTao;
	private long _nguoiTaoId;
	private String _nguoiSua;
	private long _nguoiSuaId;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _bannerRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.banner.service.ClpSerializer.class;
}