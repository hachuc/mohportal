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

package com.viettel.portal.vbpq.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.viettel.portal.vbpq.model.LinhVucVanBan;
import com.viettel.portal.vbpq.model.LinhVucVanBanModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the LinhVucVanBan service. Represents a row in the &quot;portal_linhvucvanban&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vbpq.model.LinhVucVanBanModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LinhVucVanBanImpl}.
 * </p>
 *
 * @author ChucHV
 * @see LinhVucVanBanImpl
 * @see com.viettel.portal.vbpq.model.LinhVucVanBan
 * @see com.viettel.portal.vbpq.model.LinhVucVanBanModel
 * @generated
 */
public class LinhVucVanBanModelImpl extends BaseModelImpl<LinhVucVanBan>
	implements LinhVucVanBanModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a linh vuc van ban model instance should use the {@link com.viettel.portal.vbpq.model.LinhVucVanBan} interface instead.
	 */
	public static final String TABLE_NAME = "portal_linhvucvanban";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "TEN", Types.VARCHAR },
			{ "TRANGTHAI", Types.BOOLEAN },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "NGAYSUA", Types.TIMESTAMP },
			{ "NGUOITAO", Types.VARCHAR },
			{ "NGUOISUA", Types.VARCHAR },
			{ "GROUPID", Types.BIGINT },
			{ "ORDER_", Types.INTEGER },
			{ "nhomVanBanId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table portal_linhvucvanban (ID LONG not null primary key,TEN VARCHAR(500) null,TRANGTHAI BOOLEAN,NGAYTAO DATE null,NGAYSUA DATE null,NGUOITAO VARCHAR(75) null,NGUOISUA VARCHAR(75) null,GROUPID LONG,ORDER_ INTEGER,nhomVanBanId LONG)";
	public static final String TABLE_SQL_DROP = "drop table portal_linhvucvanban";
	public static final String ORDER_BY_JPQL = " ORDER BY linhVucVanBan.order_ ASC, linhVucVanBan.ten ASC";
	public static final String ORDER_BY_SQL = " ORDER BY portal_linhvucvanban.ORDER_ ASC, portal_linhvucvanban.TEN ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vbpq.model.LinhVucVanBan"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vbpq.model.LinhVucVanBan"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vbpq.model.LinhVucVanBan"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long NHOMVANBANID_COLUMN_BITMASK = 2L;
	public static long TEN_COLUMN_BITMASK = 4L;
	public static long TRANGTHAI_COLUMN_BITMASK = 8L;
	public static long ORDER__COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vbpq.model.LinhVucVanBan"));

	public LinhVucVanBanModelImpl() {
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
	public Class<?> getModelClass() {
		return LinhVucVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return LinhVucVanBan.class.getName();
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
	}

	@Override
	public String getTen() {
		if (_ten == null) {
			return StringPool.BLANK;
		}
		else {
			return _ten;
		}
	}

	@Override
	public void setTen(String ten) {
		_columnBitmask = -1L;

		if (_originalTen == null) {
			_originalTen = _ten;
		}

		_ten = ten;
	}

	public String getOriginalTen() {
		return GetterUtil.getString(_originalTen);
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
		_columnBitmask |= TRANGTHAI_COLUMN_BITMASK;

		if (!_setOriginalTrangThai) {
			_setOriginalTrangThai = true;

			_originalTrangThai = _trangThai;
		}

		_trangThai = trangThai;
	}

	public boolean getOriginalTrangThai() {
		return _originalTrangThai;
	}

	@Override
	public Date getNgayTao() {
		return _ngayTao;
	}

	@Override
	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	@Override
	public Date getNgaySua() {
		return _ngaySua;
	}

	@Override
	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	@Override
	public String getNguoiTao() {
		if (_nguoiTao == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiTao;
		}
	}

	@Override
	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	@Override
	public String getNguoiSua() {
		if (_nguoiSua == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiSua;
		}
	}

	@Override
	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public int getOrder_() {
		return _order_;
	}

	@Override
	public void setOrder_(int order_) {
		_columnBitmask = -1L;

		_order_ = order_;
	}

	@Override
	public long getNhomVanBanId() {
		return _nhomVanBanId;
	}

	@Override
	public void setNhomVanBanId(long nhomVanBanId) {
		_columnBitmask |= NHOMVANBANID_COLUMN_BITMASK;

		if (!_setOriginalNhomVanBanId) {
			_setOriginalNhomVanBanId = true;

			_originalNhomVanBanId = _nhomVanBanId;
		}

		_nhomVanBanId = nhomVanBanId;
	}

	public long getOriginalNhomVanBanId() {
		return _originalNhomVanBanId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			LinhVucVanBan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LinhVucVanBan toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LinhVucVanBan)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LinhVucVanBanImpl linhVucVanBanImpl = new LinhVucVanBanImpl();

		linhVucVanBanImpl.setId(getId());
		linhVucVanBanImpl.setTen(getTen());
		linhVucVanBanImpl.setTrangThai(getTrangThai());
		linhVucVanBanImpl.setNgayTao(getNgayTao());
		linhVucVanBanImpl.setNgaySua(getNgaySua());
		linhVucVanBanImpl.setNguoiTao(getNguoiTao());
		linhVucVanBanImpl.setNguoiSua(getNguoiSua());
		linhVucVanBanImpl.setGroupId(getGroupId());
		linhVucVanBanImpl.setOrder_(getOrder_());
		linhVucVanBanImpl.setNhomVanBanId(getNhomVanBanId());

		linhVucVanBanImpl.resetOriginalValues();

		return linhVucVanBanImpl;
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

		if (!(obj instanceof LinhVucVanBan)) {
			return false;
		}

		LinhVucVanBan linhVucVanBan = (LinhVucVanBan)obj;

		long primaryKey = linhVucVanBan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LinhVucVanBanModelImpl linhVucVanBanModelImpl = this;

		linhVucVanBanModelImpl._originalTen = linhVucVanBanModelImpl._ten;

		linhVucVanBanModelImpl._originalTrangThai = linhVucVanBanModelImpl._trangThai;

		linhVucVanBanModelImpl._setOriginalTrangThai = false;

		linhVucVanBanModelImpl._originalGroupId = linhVucVanBanModelImpl._groupId;

		linhVucVanBanModelImpl._setOriginalGroupId = false;

		linhVucVanBanModelImpl._originalNhomVanBanId = linhVucVanBanModelImpl._nhomVanBanId;

		linhVucVanBanModelImpl._setOriginalNhomVanBanId = false;

		linhVucVanBanModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LinhVucVanBan> toCacheModel() {
		LinhVucVanBanCacheModel linhVucVanBanCacheModel = new LinhVucVanBanCacheModel();

		linhVucVanBanCacheModel.id = getId();

		linhVucVanBanCacheModel.ten = getTen();

		String ten = linhVucVanBanCacheModel.ten;

		if ((ten != null) && (ten.length() == 0)) {
			linhVucVanBanCacheModel.ten = null;
		}

		linhVucVanBanCacheModel.trangThai = getTrangThai();

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			linhVucVanBanCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			linhVucVanBanCacheModel.ngayTao = Long.MIN_VALUE;
		}

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			linhVucVanBanCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			linhVucVanBanCacheModel.ngaySua = Long.MIN_VALUE;
		}

		linhVucVanBanCacheModel.nguoiTao = getNguoiTao();

		String nguoiTao = linhVucVanBanCacheModel.nguoiTao;

		if ((nguoiTao != null) && (nguoiTao.length() == 0)) {
			linhVucVanBanCacheModel.nguoiTao = null;
		}

		linhVucVanBanCacheModel.nguoiSua = getNguoiSua();

		String nguoiSua = linhVucVanBanCacheModel.nguoiSua;

		if ((nguoiSua != null) && (nguoiSua.length() == 0)) {
			linhVucVanBanCacheModel.nguoiSua = null;
		}

		linhVucVanBanCacheModel.groupId = getGroupId();

		linhVucVanBanCacheModel.order_ = getOrder_();

		linhVucVanBanCacheModel.nhomVanBanId = getNhomVanBanId();

		return linhVucVanBanCacheModel;
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

	private static ClassLoader _classLoader = LinhVucVanBan.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			LinhVucVanBan.class
		};
	private long _id;
	private String _ten;
	private String _originalTen;
	private boolean _trangThai;
	private boolean _originalTrangThai;
	private boolean _setOriginalTrangThai;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private int _order_;
	private long _nhomVanBanId;
	private long _originalNhomVanBanId;
	private boolean _setOriginalNhomVanBanId;
	private long _columnBitmask;
	private LinhVucVanBan _escapedModel;
}