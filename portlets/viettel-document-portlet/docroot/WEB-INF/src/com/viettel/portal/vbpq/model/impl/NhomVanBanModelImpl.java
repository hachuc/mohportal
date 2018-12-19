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

import com.viettel.portal.vbpq.model.NhomVanBan;
import com.viettel.portal.vbpq.model.NhomVanBanModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the NhomVanBan service. Represents a row in the &quot;portal_vbpq_nhom_van_ban&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vbpq.model.NhomVanBanModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NhomVanBanImpl}.
 * </p>
 *
 * @author ChucHV
 * @see NhomVanBanImpl
 * @see com.viettel.portal.vbpq.model.NhomVanBan
 * @see com.viettel.portal.vbpq.model.NhomVanBanModel
 * @generated
 */
public class NhomVanBanModelImpl extends BaseModelImpl<NhomVanBan>
	implements NhomVanBanModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a nhom van ban model instance should use the {@link com.viettel.portal.vbpq.model.NhomVanBan} interface instead.
	 */
	public static final String TABLE_NAME = "portal_vbpq_nhom_van_ban";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "tenNhom", Types.VARCHAR },
			{ "nguoiTao", Types.VARCHAR },
			{ "nguoiTaoId", Types.BIGINT },
			{ "ngayTao", Types.TIMESTAMP },
			{ "ngaySua", Types.TIMESTAMP },
			{ "nguoiSua", Types.VARCHAR },
			{ "nguoiSuaId", Types.BIGINT },
			{ "trangThai", Types.INTEGER },
			{ "groupId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table portal_vbpq_nhom_van_ban (id LONG not null primary key,tenNhom VARCHAR(500) null,nguoiTao VARCHAR(75) null,nguoiTaoId LONG,ngayTao DATE null,ngaySua DATE null,nguoiSua VARCHAR(75) null,nguoiSuaId LONG,trangThai INTEGER,groupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table portal_vbpq_nhom_van_ban";
	public static final String ORDER_BY_JPQL = " ORDER BY nhomVanBan.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY portal_vbpq_nhom_van_ban.id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vbpq.model.NhomVanBan"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vbpq.model.NhomVanBan"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vbpq.model.NhomVanBan"));

	public NhomVanBanModelImpl() {
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
		return NhomVanBan.class;
	}

	@Override
	public String getModelClassName() {
		return NhomVanBan.class.getName();
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
	}

	@Override
	public String getTenNhom() {
		if (_tenNhom == null) {
			return StringPool.BLANK;
		}
		else {
			return _tenNhom;
		}
	}

	@Override
	public void setTenNhom(String tenNhom) {
		_tenNhom = tenNhom;
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
	public long getNguoiTaoId() {
		return _nguoiTaoId;
	}

	@Override
	public void setNguoiTaoId(long nguoiTaoId) {
		_nguoiTaoId = nguoiTaoId;
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
	public long getNguoiSuaId() {
		return _nguoiSuaId;
	}

	@Override
	public void setNguoiSuaId(long nguoiSuaId) {
		_nguoiSuaId = nguoiSuaId;
	}

	@Override
	public int getTrangThai() {
		return _trangThai;
	}

	@Override
	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NhomVanBan.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NhomVanBan toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NhomVanBan)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NhomVanBanImpl nhomVanBanImpl = new NhomVanBanImpl();

		nhomVanBanImpl.setId(getId());
		nhomVanBanImpl.setTenNhom(getTenNhom());
		nhomVanBanImpl.setNguoiTao(getNguoiTao());
		nhomVanBanImpl.setNguoiTaoId(getNguoiTaoId());
		nhomVanBanImpl.setNgayTao(getNgayTao());
		nhomVanBanImpl.setNgaySua(getNgaySua());
		nhomVanBanImpl.setNguoiSua(getNguoiSua());
		nhomVanBanImpl.setNguoiSuaId(getNguoiSuaId());
		nhomVanBanImpl.setTrangThai(getTrangThai());
		nhomVanBanImpl.setGroupId(getGroupId());

		nhomVanBanImpl.resetOriginalValues();

		return nhomVanBanImpl;
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

		if (!(obj instanceof NhomVanBan)) {
			return false;
		}

		NhomVanBan nhomVanBan = (NhomVanBan)obj;

		long primaryKey = nhomVanBan.getPrimaryKey();

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
	}

	@Override
	public CacheModel<NhomVanBan> toCacheModel() {
		NhomVanBanCacheModel nhomVanBanCacheModel = new NhomVanBanCacheModel();

		nhomVanBanCacheModel.id = getId();

		nhomVanBanCacheModel.tenNhom = getTenNhom();

		String tenNhom = nhomVanBanCacheModel.tenNhom;

		if ((tenNhom != null) && (tenNhom.length() == 0)) {
			nhomVanBanCacheModel.tenNhom = null;
		}

		nhomVanBanCacheModel.nguoiTao = getNguoiTao();

		String nguoiTao = nhomVanBanCacheModel.nguoiTao;

		if ((nguoiTao != null) && (nguoiTao.length() == 0)) {
			nhomVanBanCacheModel.nguoiTao = null;
		}

		nhomVanBanCacheModel.nguoiTaoId = getNguoiTaoId();

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			nhomVanBanCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			nhomVanBanCacheModel.ngayTao = Long.MIN_VALUE;
		}

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			nhomVanBanCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			nhomVanBanCacheModel.ngaySua = Long.MIN_VALUE;
		}

		nhomVanBanCacheModel.nguoiSua = getNguoiSua();

		String nguoiSua = nhomVanBanCacheModel.nguoiSua;

		if ((nguoiSua != null) && (nguoiSua.length() == 0)) {
			nhomVanBanCacheModel.nguoiSua = null;
		}

		nhomVanBanCacheModel.nguoiSuaId = getNguoiSuaId();

		nhomVanBanCacheModel.trangThai = getTrangThai();

		nhomVanBanCacheModel.groupId = getGroupId();

		return nhomVanBanCacheModel;
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

	private static ClassLoader _classLoader = NhomVanBan.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			NhomVanBan.class
		};
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
	private NhomVanBan _escapedModel;
}