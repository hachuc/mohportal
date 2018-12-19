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
import com.liferay.portal.util.PortalUtil;

import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;
import com.viettel.portal.thongke.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lamvn
 */
public class BaiVietNhuanButClp extends BaseModelImpl<BaiVietNhuanBut>
	implements BaiVietNhuanBut {
	public BaiVietNhuanButClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BaiVietNhuanBut.class;
	}

	@Override
	public String getModelClassName() {
		return BaiVietNhuanBut.class.getName();
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
		attributes.put("baiVietId", getBaiVietId());
		attributes.put("loaiBaiViet", getLoaiBaiViet());
		attributes.put("tieuDe", getTieuDe());
		attributes.put("tacGia", getTacGia());
		attributes.put("diaChi", getDiaChi());
		attributes.put("ngayXuatBan", getNgayXuatBan());
		attributes.put("rating", getRating());
		attributes.put("ratingValue", getRatingValue());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifyDate", getModifyDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long baiVietId = (Long)attributes.get("baiVietId");

		if (baiVietId != null) {
			setBaiVietId(baiVietId);
		}

		Integer loaiBaiViet = (Integer)attributes.get("loaiBaiViet");

		if (loaiBaiViet != null) {
			setLoaiBaiViet(loaiBaiViet);
		}

		String tieuDe = (String)attributes.get("tieuDe");

		if (tieuDe != null) {
			setTieuDe(tieuDe);
		}

		String tacGia = (String)attributes.get("tacGia");

		if (tacGia != null) {
			setTacGia(tacGia);
		}

		String diaChi = (String)attributes.get("diaChi");

		if (diaChi != null) {
			setDiaChi(diaChi);
		}

		Date ngayXuatBan = (Date)attributes.get("ngayXuatBan");

		if (ngayXuatBan != null) {
			setNgayXuatBan(ngayXuatBan);
		}

		String rating = (String)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		Double ratingValue = (Double)attributes.get("ratingValue");

		if (ratingValue != null) {
			setRatingValue(ratingValue);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifyDate = (Date)attributes.get("modifyDate");

		if (modifyDate != null) {
			setModifyDate(modifyDate);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_baiVietNhuanButRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBaiVietId() {
		return _baiVietId;
	}

	@Override
	public void setBaiVietId(long baiVietId) {
		_baiVietId = baiVietId;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setBaiVietId", long.class);

				method.invoke(_baiVietNhuanButRemoteModel, baiVietId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLoaiBaiViet() {
		return _loaiBaiViet;
	}

	@Override
	public void setLoaiBaiViet(int loaiBaiViet) {
		_loaiBaiViet = loaiBaiViet;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setLoaiBaiViet", int.class);

				method.invoke(_baiVietNhuanButRemoteModel, loaiBaiViet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTieuDe() {
		return _tieuDe;
	}

	@Override
	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setTieuDe", String.class);

				method.invoke(_baiVietNhuanButRemoteModel, tieuDe);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTacGia() {
		return _tacGia;
	}

	@Override
	public void setTacGia(String tacGia) {
		_tacGia = tacGia;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setTacGia", String.class);

				method.invoke(_baiVietNhuanButRemoteModel, tacGia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiaChi() {
		return _diaChi;
	}

	@Override
	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setDiaChi", String.class);

				method.invoke(_baiVietNhuanButRemoteModel, diaChi);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNgayXuatBan() {
		return _ngayXuatBan;
	}

	@Override
	public void setNgayXuatBan(Date ngayXuatBan) {
		_ngayXuatBan = ngayXuatBan;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setNgayXuatBan", Date.class);

				method.invoke(_baiVietNhuanButRemoteModel, ngayXuatBan);
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

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setRating", String.class);

				method.invoke(_baiVietNhuanButRemoteModel, rating);
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

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingValue", double.class);

				method.invoke(_baiVietNhuanButRemoteModel, ratingValue);
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

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_baiVietNhuanButRemoteModel, companyId);
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

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_baiVietNhuanButRemoteModel, groupId);
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

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_baiVietNhuanButRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifyDate() {
		return _modifyDate;
	}

	@Override
	public void setModifyDate(Date modifyDate) {
		_modifyDate = modifyDate;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setModifyDate", Date.class);

				method.invoke(_baiVietNhuanButRemoteModel, modifyDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_baiVietNhuanButRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_baiVietNhuanButRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;

		if (_baiVietNhuanButRemoteModel != null) {
			try {
				Class<?> clazz = _baiVietNhuanButRemoteModel.getClass();

				Method method = clazz.getMethod("setType", int.class);

				method.invoke(_baiVietNhuanButRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBaiVietNhuanButRemoteModel() {
		return _baiVietNhuanButRemoteModel;
	}

	public void setBaiVietNhuanButRemoteModel(
		BaseModel<?> baiVietNhuanButRemoteModel) {
		_baiVietNhuanButRemoteModel = baiVietNhuanButRemoteModel;
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

		Class<?> remoteModelClass = _baiVietNhuanButRemoteModel.getClass();

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

		Object returnValue = method.invoke(_baiVietNhuanButRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut(this);
		}
		else {
			BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut(this);
		}
	}

	@Override
	public BaiVietNhuanBut toEscapedModel() {
		return (BaiVietNhuanBut)ProxyUtil.newProxyInstance(BaiVietNhuanBut.class.getClassLoader(),
			new Class[] { BaiVietNhuanBut.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BaiVietNhuanButClp clone = new BaiVietNhuanButClp();

		clone.setId(getId());
		clone.setBaiVietId(getBaiVietId());
		clone.setLoaiBaiViet(getLoaiBaiViet());
		clone.setTieuDe(getTieuDe());
		clone.setTacGia(getTacGia());
		clone.setDiaChi(getDiaChi());
		clone.setNgayXuatBan(getNgayXuatBan());
		clone.setRating(getRating());
		clone.setRatingValue(getRatingValue());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setModifyDate(getModifyDate());
		clone.setUserName(getUserName());
		clone.setUserId(getUserId());
		clone.setType(getType());

		return clone;
	}

	@Override
	public int compareTo(BaiVietNhuanBut baiVietNhuanBut) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				baiVietNhuanBut.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getTieuDe().compareTo(baiVietNhuanBut.getTieuDe());

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

		if (!(obj instanceof BaiVietNhuanButClp)) {
			return false;
		}

		BaiVietNhuanButClp baiVietNhuanBut = (BaiVietNhuanButClp)obj;

		long primaryKey = baiVietNhuanBut.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", baiVietId=");
		sb.append(getBaiVietId());
		sb.append(", loaiBaiViet=");
		sb.append(getLoaiBaiViet());
		sb.append(", tieuDe=");
		sb.append(getTieuDe());
		sb.append(", tacGia=");
		sb.append(getTacGia());
		sb.append(", diaChi=");
		sb.append(getDiaChi());
		sb.append(", ngayXuatBan=");
		sb.append(getNgayXuatBan());
		sb.append(", rating=");
		sb.append(getRating());
		sb.append(", ratingValue=");
		sb.append(getRatingValue());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifyDate=");
		sb.append(getModifyDate());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.thongke.model.BaiVietNhuanBut");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baiVietId</column-name><column-value><![CDATA[");
		sb.append(getBaiVietId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiBaiViet</column-name><column-value><![CDATA[");
		sb.append(getLoaiBaiViet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tieuDe</column-name><column-value><![CDATA[");
		sb.append(getTieuDe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tacGia</column-name><column-value><![CDATA[");
		sb.append(getTacGia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChi</column-name><column-value><![CDATA[");
		sb.append(getDiaChi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayXuatBan</column-name><column-value><![CDATA[");
		sb.append(getNgayXuatBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rating</column-name><column-value><![CDATA[");
		sb.append(getRating());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingValue</column-name><column-value><![CDATA[");
		sb.append(getRatingValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifyDate</column-name><column-value><![CDATA[");
		sb.append(getModifyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _baiVietId;
	private int _loaiBaiViet;
	private String _tieuDe;
	private String _tacGia;
	private String _diaChi;
	private Date _ngayXuatBan;
	private String _rating;
	private double _ratingValue;
	private long _companyId;
	private long _groupId;
	private Date _createDate;
	private Date _modifyDate;
	private String _userName;
	private long _userId;
	private String _userUuid;
	private int _type;
	private BaseModel<?> _baiVietNhuanButRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.thongke.service.ClpSerializer.class;
}