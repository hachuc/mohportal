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

package com.viettel.portal.banner.model.impl;

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

import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.model.BannerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Banner service. Represents a row in the &quot;portal_banner&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.banner.model.BannerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BannerImpl}.
 * </p>
 *
 * @author ChucHV
 * @see BannerImpl
 * @see com.viettel.portal.banner.model.Banner
 * @see com.viettel.portal.banner.model.BannerModel
 * @generated
 */
public class BannerModelImpl extends BaseModelImpl<Banner>
	implements BannerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a banner model instance should use the {@link com.viettel.portal.banner.model.Banner} interface instead.
	 */
	public static final String TABLE_NAME = "portal_banner";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "TEN", Types.VARCHAR },
			{ "FILEID", Types.BIGINT },
			{ "FILELINK", Types.VARCHAR },
			{ "FILENAME", Types.VARCHAR },
			{ "FILESIZE", Types.VARCHAR },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "NGAYSUA", Types.TIMESTAMP },
			{ "NGAYKETTHUC", Types.TIMESTAMP },
			{ "LIENKET", Types.VARCHAR },
			{ "ORDER_", Types.INTEGER },
			{ "TRANGTHAI", Types.BOOLEAN },
			{ "NGUOITAO", Types.VARCHAR },
			{ "NGUOITAOID", Types.BIGINT },
			{ "NGUOISUA", Types.VARCHAR },
			{ "NGUOISUAID", Types.BIGINT },
			{ "COMPANYID", Types.BIGINT },
			{ "groupId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table portal_banner (ID LONG not null primary key,TEN VARCHAR(500) null,FILEID LONG,FILELINK VARCHAR(255) null,FILENAME VARCHAR(255) null,FILESIZE VARCHAR(75) null,NGAYTAO DATE null,NGAYSUA DATE null,NGAYKETTHUC DATE null,LIENKET VARCHAR(2000) null,ORDER_ INTEGER,TRANGTHAI BOOLEAN,NGUOITAO VARCHAR(75) null,NGUOITAOID LONG,NGUOISUA VARCHAR(75) null,NGUOISUAID LONG,COMPANYID LONG,groupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table portal_banner";
	public static final String ORDER_BY_JPQL = " ORDER BY banner.order_ ASC, banner.ten ASC";
	public static final String ORDER_BY_SQL = " ORDER BY portal_banner.ORDER_ ASC, portal_banner.TEN ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.banner.model.Banner"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.banner.model.Banner"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.banner.model.Banner"),
			true);
	public static long NGAYKETTHUC_COLUMN_BITMASK = 1L;
	public static long TRANGTHAI_COLUMN_BITMASK = 2L;
	public static long ORDER__COLUMN_BITMASK = 4L;
	public static long TEN_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.banner.model.Banner"));

	public BannerModelImpl() {
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
		return Banner.class;
	}

	@Override
	public String getModelClassName() {
		return Banner.class.getName();
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

		_ten = ten;
	}

	@Override
	public long getFileId() {
		return _fileId;
	}

	@Override
	public void setFileId(long fileId) {
		_fileId = fileId;
	}

	@Override
	public String getFileLink() {
		if (_fileLink == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileLink;
		}
	}

	@Override
	public void setFileLink(String fileLink) {
		_fileLink = fileLink;
	}

	@Override
	public String getFileName() {
		if (_fileName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	@Override
	public String getFileSize() {
		if (_fileSize == null) {
			return StringPool.BLANK;
		}
		else {
			return _fileSize;
		}
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
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
	public Date getNgayKetThuc() {
		return _ngayKetThuc;
	}

	@Override
	public void setNgayKetThuc(Date ngayKetThuc) {
		_columnBitmask |= NGAYKETTHUC_COLUMN_BITMASK;

		if (_originalNgayKetThuc == null) {
			_originalNgayKetThuc = _ngayKetThuc;
		}

		_ngayKetThuc = ngayKetThuc;
	}

	public Date getOriginalNgayKetThuc() {
		return _originalNgayKetThuc;
	}

	@Override
	public String getLienKet() {
		if (_lienKet == null) {
			return StringPool.BLANK;
		}
		else {
			return _lienKet;
		}
	}

	@Override
	public void setLienKet(String lienKet) {
		_lienKet = lienKet;
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Banner.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Banner toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Banner)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setId(getId());
		bannerImpl.setTen(getTen());
		bannerImpl.setFileId(getFileId());
		bannerImpl.setFileLink(getFileLink());
		bannerImpl.setFileName(getFileName());
		bannerImpl.setFileSize(getFileSize());
		bannerImpl.setNgayTao(getNgayTao());
		bannerImpl.setNgaySua(getNgaySua());
		bannerImpl.setNgayKetThuc(getNgayKetThuc());
		bannerImpl.setLienKet(getLienKet());
		bannerImpl.setOrder_(getOrder_());
		bannerImpl.setTrangThai(getTrangThai());
		bannerImpl.setNguoiTao(getNguoiTao());
		bannerImpl.setNguoiTaoId(getNguoiTaoId());
		bannerImpl.setNguoiSua(getNguoiSua());
		bannerImpl.setNguoiSuaId(getNguoiSuaId());
		bannerImpl.setCompanyId(getCompanyId());
		bannerImpl.setGroupId(getGroupId());

		bannerImpl.resetOriginalValues();

		return bannerImpl;
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

		if (!(obj instanceof Banner)) {
			return false;
		}

		Banner banner = (Banner)obj;

		long primaryKey = banner.getPrimaryKey();

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
		BannerModelImpl bannerModelImpl = this;

		bannerModelImpl._originalNgayKetThuc = bannerModelImpl._ngayKetThuc;

		bannerModelImpl._originalTrangThai = bannerModelImpl._trangThai;

		bannerModelImpl._setOriginalTrangThai = false;

		bannerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Banner> toCacheModel() {
		BannerCacheModel bannerCacheModel = new BannerCacheModel();

		bannerCacheModel.id = getId();

		bannerCacheModel.ten = getTen();

		String ten = bannerCacheModel.ten;

		if ((ten != null) && (ten.length() == 0)) {
			bannerCacheModel.ten = null;
		}

		bannerCacheModel.fileId = getFileId();

		bannerCacheModel.fileLink = getFileLink();

		String fileLink = bannerCacheModel.fileLink;

		if ((fileLink != null) && (fileLink.length() == 0)) {
			bannerCacheModel.fileLink = null;
		}

		bannerCacheModel.fileName = getFileName();

		String fileName = bannerCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			bannerCacheModel.fileName = null;
		}

		bannerCacheModel.fileSize = getFileSize();

		String fileSize = bannerCacheModel.fileSize;

		if ((fileSize != null) && (fileSize.length() == 0)) {
			bannerCacheModel.fileSize = null;
		}

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			bannerCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			bannerCacheModel.ngayTao = Long.MIN_VALUE;
		}

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			bannerCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			bannerCacheModel.ngaySua = Long.MIN_VALUE;
		}

		Date ngayKetThuc = getNgayKetThuc();

		if (ngayKetThuc != null) {
			bannerCacheModel.ngayKetThuc = ngayKetThuc.getTime();
		}
		else {
			bannerCacheModel.ngayKetThuc = Long.MIN_VALUE;
		}

		bannerCacheModel.lienKet = getLienKet();

		String lienKet = bannerCacheModel.lienKet;

		if ((lienKet != null) && (lienKet.length() == 0)) {
			bannerCacheModel.lienKet = null;
		}

		bannerCacheModel.order_ = getOrder_();

		bannerCacheModel.trangThai = getTrangThai();

		bannerCacheModel.nguoiTao = getNguoiTao();

		String nguoiTao = bannerCacheModel.nguoiTao;

		if ((nguoiTao != null) && (nguoiTao.length() == 0)) {
			bannerCacheModel.nguoiTao = null;
		}

		bannerCacheModel.nguoiTaoId = getNguoiTaoId();

		bannerCacheModel.nguoiSua = getNguoiSua();

		String nguoiSua = bannerCacheModel.nguoiSua;

		if ((nguoiSua != null) && (nguoiSua.length() == 0)) {
			bannerCacheModel.nguoiSua = null;
		}

		bannerCacheModel.nguoiSuaId = getNguoiSuaId();

		bannerCacheModel.companyId = getCompanyId();

		bannerCacheModel.groupId = getGroupId();

		return bannerCacheModel;
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

	private static ClassLoader _classLoader = Banner.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Banner.class };
	private long _id;
	private String _ten;
	private long _fileId;
	private String _fileLink;
	private String _fileName;
	private String _fileSize;
	private Date _ngayTao;
	private Date _ngaySua;
	private Date _ngayKetThuc;
	private Date _originalNgayKetThuc;
	private String _lienKet;
	private int _order_;
	private boolean _trangThai;
	private boolean _originalTrangThai;
	private boolean _setOriginalTrangThai;
	private String _nguoiTao;
	private long _nguoiTaoId;
	private String _nguoiSua;
	private long _nguoiSuaId;
	private long _companyId;
	private long _groupId;
	private long _columnBitmask;
	private Banner _escapedModel;
}