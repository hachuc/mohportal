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

package com.viettel.portal.magazine.archive.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.magazine.archive.model.Magazine;
import com.viettel.portal.magazine.archive.model.MagazineModel;
import com.viettel.portal.magazine.archive.model.MagazineSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Magazine service. Represents a row in the &quot;ArchiveMagazine&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.magazine.archive.model.MagazineModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MagazineImpl}.
 * </p>
 *
 * @author namtv
 * @see MagazineImpl
 * @see com.viettel.portal.magazine.archive.model.Magazine
 * @see com.viettel.portal.magazine.archive.model.MagazineModel
 * @generated
 */
@JSON(strict = true)
public class MagazineModelImpl extends BaseModelImpl<Magazine>
	implements MagazineModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a magazine model instance should use the {@link com.viettel.portal.magazine.archive.model.Magazine} interface instead.
	 */
	public static final String TABLE_NAME = "ArchiveMagazine";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "Name", Types.VARCHAR },
			{ "PublishNumber", Types.INTEGER },
			{ "PublishMonth", Types.INTEGER },
			{ "PublishYear", Types.INTEGER },
			{ "ImageUrl", Types.VARCHAR },
			{ "MagazineType", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ArchiveMagazine (ID INTEGER not null primary key,Name VARCHAR(75) null,PublishNumber INTEGER,PublishMonth INTEGER,PublishYear INTEGER,ImageUrl VARCHAR(75) null,MagazineType INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ArchiveMagazine";
	public static final String ORDER_BY_JPQL = " ORDER BY magazine.PublishYear DESC, magazine.PublishMonth DESC, magazine.PublishNumber DESC";
	public static final String ORDER_BY_SQL = " ORDER BY ArchiveMagazine.PublishYear DESC, ArchiveMagazine.PublishMonth DESC, ArchiveMagazine.PublishNumber DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.magazine.archive.model.Magazine"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.magazine.archive.model.Magazine"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.magazine.archive.model.Magazine"),
			true);
	public static long PUBLISHYEAR_COLUMN_BITMASK = 1L;
	public static long PUBLISHMONTH_COLUMN_BITMASK = 2L;
	public static long PUBLISHNUMBER_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Magazine toModel(MagazineSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Magazine model = new MagazineImpl();

		model.setID(soapModel.getID());
		model.setName(soapModel.getName());
		model.setPublishNumber(soapModel.getPublishNumber());
		model.setPublishMonth(soapModel.getPublishMonth());
		model.setPublishYear(soapModel.getPublishYear());
		model.setImageUrl(soapModel.getImageUrl());
		model.setMagazineType(soapModel.getMagazineType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Magazine> toModels(MagazineSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Magazine> models = new ArrayList<Magazine>(soapModels.length);

		for (MagazineSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.magazine.archive.model.Magazine"));

	public MagazineModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Magazine.class;
	}

	@Override
	public String getModelClassName() {
		return Magazine.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("PublishNumber", getPublishNumber());
		attributes.put("PublishMonth", getPublishMonth());
		attributes.put("PublishYear", getPublishYear());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("MagazineType", getMagazineType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer PublishNumber = (Integer)attributes.get("PublishNumber");

		if (PublishNumber != null) {
			setPublishNumber(PublishNumber);
		}

		Integer PublishMonth = (Integer)attributes.get("PublishMonth");

		if (PublishMonth != null) {
			setPublishMonth(PublishMonth);
		}

		Integer PublishYear = (Integer)attributes.get("PublishYear");

		if (PublishYear != null) {
			setPublishYear(PublishYear);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		Integer MagazineType = (Integer)attributes.get("MagazineType");

		if (MagazineType != null) {
			setMagazineType(MagazineType);
		}
	}

	@JSON
	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;
	}

	@JSON
	@Override
	public String getName() {
		if (_Name == null) {
			return StringPool.BLANK;
		}
		else {
			return _Name;
		}
	}

	@Override
	public void setName(String Name) {
		_Name = Name;
	}

	@JSON
	@Override
	public int getPublishNumber() {
		return _PublishNumber;
	}

	@Override
	public void setPublishNumber(int PublishNumber) {
		_columnBitmask = -1L;

		_PublishNumber = PublishNumber;
	}

	@JSON
	@Override
	public int getPublishMonth() {
		return _PublishMonth;
	}

	@Override
	public void setPublishMonth(int PublishMonth) {
		_columnBitmask = -1L;

		_PublishMonth = PublishMonth;
	}

	@JSON
	@Override
	public int getPublishYear() {
		return _PublishYear;
	}

	@Override
	public void setPublishYear(int PublishYear) {
		_columnBitmask = -1L;

		if (!_setOriginalPublishYear) {
			_setOriginalPublishYear = true;

			_originalPublishYear = _PublishYear;
		}

		_PublishYear = PublishYear;
	}

	public int getOriginalPublishYear() {
		return _originalPublishYear;
	}

	@JSON
	@Override
	public String getImageUrl() {
		if (_ImageUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _ImageUrl;
		}
	}

	@Override
	public void setImageUrl(String ImageUrl) {
		_ImageUrl = ImageUrl;
	}

	@JSON
	@Override
	public int getMagazineType() {
		return _MagazineType;
	}

	@Override
	public void setMagazineType(int MagazineType) {
		_MagazineType = MagazineType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Magazine toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Magazine)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MagazineImpl magazineImpl = new MagazineImpl();

		magazineImpl.setID(getID());
		magazineImpl.setName(getName());
		magazineImpl.setPublishNumber(getPublishNumber());
		magazineImpl.setPublishMonth(getPublishMonth());
		magazineImpl.setPublishYear(getPublishYear());
		magazineImpl.setImageUrl(getImageUrl());
		magazineImpl.setMagazineType(getMagazineType());

		magazineImpl.resetOriginalValues();

		return magazineImpl;
	}

	@Override
	public int compareTo(Magazine magazine) {
		int value = 0;

		if (getPublishYear() < magazine.getPublishYear()) {
			value = -1;
		}
		else if (getPublishYear() > magazine.getPublishYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPublishMonth() < magazine.getPublishMonth()) {
			value = -1;
		}
		else if (getPublishMonth() > magazine.getPublishMonth()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPublishNumber() < magazine.getPublishNumber()) {
			value = -1;
		}
		else if (getPublishNumber() > magazine.getPublishNumber()) {
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

		if (!(obj instanceof Magazine)) {
			return false;
		}

		Magazine magazine = (Magazine)obj;

		int primaryKey = magazine.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		MagazineModelImpl magazineModelImpl = this;

		magazineModelImpl._originalPublishYear = magazineModelImpl._PublishYear;

		magazineModelImpl._setOriginalPublishYear = false;

		magazineModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Magazine> toCacheModel() {
		MagazineCacheModel magazineCacheModel = new MagazineCacheModel();

		magazineCacheModel.ID = getID();

		magazineCacheModel.Name = getName();

		String Name = magazineCacheModel.Name;

		if ((Name != null) && (Name.length() == 0)) {
			magazineCacheModel.Name = null;
		}

		magazineCacheModel.PublishNumber = getPublishNumber();

		magazineCacheModel.PublishMonth = getPublishMonth();

		magazineCacheModel.PublishYear = getPublishYear();

		magazineCacheModel.ImageUrl = getImageUrl();

		String ImageUrl = magazineCacheModel.ImageUrl;

		if ((ImageUrl != null) && (ImageUrl.length() == 0)) {
			magazineCacheModel.ImageUrl = null;
		}

		magazineCacheModel.MagazineType = getMagazineType();

		return magazineCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", PublishNumber=");
		sb.append(getPublishNumber());
		sb.append(", PublishMonth=");
		sb.append(getPublishMonth());
		sb.append(", PublishYear=");
		sb.append(getPublishYear());
		sb.append(", ImageUrl=");
		sb.append(getImageUrl());
		sb.append(", MagazineType=");
		sb.append(getMagazineType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.archive.model.Magazine");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PublishNumber</column-name><column-value><![CDATA[");
		sb.append(getPublishNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PublishMonth</column-name><column-value><![CDATA[");
		sb.append(getPublishMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PublishYear</column-name><column-value><![CDATA[");
		sb.append(getPublishYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineType</column-name><column-value><![CDATA[");
		sb.append(getMagazineType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Magazine.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Magazine.class
		};
	private int _ID;
	private String _Name;
	private int _PublishNumber;
	private int _PublishMonth;
	private int _PublishYear;
	private int _originalPublishYear;
	private boolean _setOriginalPublishYear;
	private String _ImageUrl;
	private int _MagazineType;
	private long _columnBitmask;
	private Magazine _escapedModel;
}