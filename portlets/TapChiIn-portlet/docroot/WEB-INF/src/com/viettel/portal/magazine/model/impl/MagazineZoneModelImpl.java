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

package com.viettel.portal.magazine.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.magazine.model.MagazineZone;
import com.viettel.portal.magazine.model.MagazineZoneModel;
import com.viettel.portal.magazine.model.MagazineZoneSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MagazineZone service. Represents a row in the &quot;MagazineZone&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.magazine.model.MagazineZoneModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MagazineZoneImpl}.
 * </p>
 *
 * @author namtv
 * @see MagazineZoneImpl
 * @see com.viettel.portal.magazine.model.MagazineZone
 * @see com.viettel.portal.magazine.model.MagazineZoneModel
 * @generated
 */
@JSON(strict = true)
public class MagazineZoneModelImpl extends BaseModelImpl<MagazineZone>
	implements MagazineZoneModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a magazine zone model instance should use the {@link com.viettel.portal.magazine.model.MagazineZone} interface instead.
	 */
	public static final String TABLE_NAME = "MagazineZone";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "Name", Types.VARCHAR },
			{ "MagazineID", Types.INTEGER },
			{ "SortOrder", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table MagazineZone (ID INTEGER not null primary key,Name VARCHAR(255) null,MagazineID INTEGER,SortOrder INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table MagazineZone";
	public static final String ORDER_BY_JPQL = " ORDER BY magazineZone.SortOrder ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MagazineZone.SortOrder ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.magazine.model.MagazineZone"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.magazine.model.MagazineZone"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.magazine.model.MagazineZone"),
			true);
	public static long MAGAZINEID_COLUMN_BITMASK = 1L;
	public static long SORTORDER_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MagazineZone toModel(MagazineZoneSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MagazineZone model = new MagazineZoneImpl();

		model.setID(soapModel.getID());
		model.setName(soapModel.getName());
		model.setMagazineID(soapModel.getMagazineID());
		model.setSortOrder(soapModel.getSortOrder());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MagazineZone> toModels(MagazineZoneSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MagazineZone> models = new ArrayList<MagazineZone>(soapModels.length);

		for (MagazineZoneSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.magazine.model.MagazineZone"));

	public MagazineZoneModelImpl() {
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
		return MagazineZone.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineZone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("SortOrder", getSortOrder());

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

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
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
	public int getMagazineID() {
		return _MagazineID;
	}

	@Override
	public void setMagazineID(int MagazineID) {
		_columnBitmask |= MAGAZINEID_COLUMN_BITMASK;

		if (!_setOriginalMagazineID) {
			_setOriginalMagazineID = true;

			_originalMagazineID = _MagazineID;
		}

		_MagazineID = MagazineID;
	}

	public int getOriginalMagazineID() {
		return _originalMagazineID;
	}

	@JSON
	@Override
	public int getSortOrder() {
		return _SortOrder;
	}

	@Override
	public void setSortOrder(int SortOrder) {
		_columnBitmask = -1L;

		_SortOrder = SortOrder;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public MagazineZone toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MagazineZone)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MagazineZoneImpl magazineZoneImpl = new MagazineZoneImpl();

		magazineZoneImpl.setID(getID());
		magazineZoneImpl.setName(getName());
		magazineZoneImpl.setMagazineID(getMagazineID());
		magazineZoneImpl.setSortOrder(getSortOrder());

		magazineZoneImpl.resetOriginalValues();

		return magazineZoneImpl;
	}

	@Override
	public int compareTo(MagazineZone magazineZone) {
		int value = 0;

		if (getSortOrder() < magazineZone.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > magazineZone.getSortOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof MagazineZone)) {
			return false;
		}

		MagazineZone magazineZone = (MagazineZone)obj;

		int primaryKey = magazineZone.getPrimaryKey();

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
		MagazineZoneModelImpl magazineZoneModelImpl = this;

		magazineZoneModelImpl._originalMagazineID = magazineZoneModelImpl._MagazineID;

		magazineZoneModelImpl._setOriginalMagazineID = false;

		magazineZoneModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MagazineZone> toCacheModel() {
		MagazineZoneCacheModel magazineZoneCacheModel = new MagazineZoneCacheModel();

		magazineZoneCacheModel.ID = getID();

		magazineZoneCacheModel.Name = getName();

		String Name = magazineZoneCacheModel.Name;

		if ((Name != null) && (Name.length() == 0)) {
			magazineZoneCacheModel.Name = null;
		}

		magazineZoneCacheModel.MagazineID = getMagazineID();

		magazineZoneCacheModel.SortOrder = getSortOrder();

		return magazineZoneCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", MagazineID=");
		sb.append(getMagazineID());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.model.MagazineZone");
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
			"<column><column-name>MagazineID</column-name><column-value><![CDATA[");
		sb.append(getMagazineID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MagazineZone.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MagazineZone.class
		};
	private int _ID;
	private String _Name;
	private int _MagazineID;
	private int _originalMagazineID;
	private boolean _setOriginalMagazineID;
	private int _SortOrder;
	private long _columnBitmask;
	private MagazineZone _escapedModel;
}