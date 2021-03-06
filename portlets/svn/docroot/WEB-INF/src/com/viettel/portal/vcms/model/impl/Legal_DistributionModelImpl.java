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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vcms.model.Legal_Distribution;
import com.viettel.portal.vcms.model.Legal_DistributionModel;
import com.viettel.portal.vcms.model.Legal_DistributionSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Legal_Distribution service. Represents a row in the &quot;Distribution&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.Legal_DistributionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Legal_DistributionImpl}.
 * </p>
 *
 * @author chuchv
 * @see Legal_DistributionImpl
 * @see com.viettel.portal.vcms.model.Legal_Distribution
 * @see com.viettel.portal.vcms.model.Legal_DistributionModel
 * @generated
 */
@JSON(strict = true)
public class Legal_DistributionModelImpl extends BaseModelImpl<Legal_Distribution>
	implements Legal_DistributionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal_ distribution model instance should use the {@link com.viettel.portal.vcms.model.Legal_Distribution} interface instead.
	 */
	public static final String TABLE_NAME = "Distribution";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "ContentID", Types.INTEGER },
			{ "Version", Types.INTEGER },
			{ "ZoneID", Types.INTEGER },
			{ "DistributedDate", Types.TIMESTAMP },
			{ "Ranking", Types.INTEGER },
			{ "AllowDiscussion", Types.BOOLEAN },
			{ "ViewedCount", Types.INTEGER },
			{ "MailedCount", Types.INTEGER },
			{ "RatedCount", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Distribution (ID INTEGER not null primary key,ContentID INTEGER,Version INTEGER,ZoneID INTEGER,DistributedDate DATE null,Ranking INTEGER,AllowDiscussion BOOLEAN,ViewedCount INTEGER,MailedCount INTEGER,RatedCount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Distribution";
	public static final String ORDER_BY_JPQL = " ORDER BY legal_Distribution.DistributedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Distribution.DistributedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.Legal_Distribution"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.Legal_Distribution"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.Legal_Distribution"),
			true);
	public static long ZONEID_COLUMN_BITMASK = 1L;
	public static long DISTRIBUTEDDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Legal_Distribution toModel(Legal_DistributionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Legal_Distribution model = new Legal_DistributionImpl();

		model.setID(soapModel.getID());
		model.setContentID(soapModel.getContentID());
		model.setVersion(soapModel.getVersion());
		model.setZoneID(soapModel.getZoneID());
		model.setDistributedDate(soapModel.getDistributedDate());
		model.setRanking(soapModel.getRanking());
		model.setAllowDiscussion(soapModel.getAllowDiscussion());
		model.setViewedCount(soapModel.getViewedCount());
		model.setMailedCount(soapModel.getMailedCount());
		model.setRatedCount(soapModel.getRatedCount());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Legal_Distribution> toModels(
		Legal_DistributionSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Legal_Distribution> models = new ArrayList<Legal_Distribution>(soapModels.length);

		for (Legal_DistributionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.Legal_Distribution"));

	public Legal_DistributionModelImpl() {
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
		return Legal_Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Distribution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("ContentID", getContentID());
		attributes.put("Version", getVersion());
		attributes.put("ZoneID", getZoneID());
		attributes.put("DistributedDate", getDistributedDate());
		attributes.put("Ranking", getRanking());
		attributes.put("AllowDiscussion", getAllowDiscussion());
		attributes.put("ViewedCount", getViewedCount());
		attributes.put("MailedCount", getMailedCount());
		attributes.put("RatedCount", getRatedCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}

		Integer ZoneID = (Integer)attributes.get("ZoneID");

		if (ZoneID != null) {
			setZoneID(ZoneID);
		}

		Date DistributedDate = (Date)attributes.get("DistributedDate");

		if (DistributedDate != null) {
			setDistributedDate(DistributedDate);
		}

		Integer Ranking = (Integer)attributes.get("Ranking");

		if (Ranking != null) {
			setRanking(Ranking);
		}

		Boolean AllowDiscussion = (Boolean)attributes.get("AllowDiscussion");

		if (AllowDiscussion != null) {
			setAllowDiscussion(AllowDiscussion);
		}

		Integer ViewedCount = (Integer)attributes.get("ViewedCount");

		if (ViewedCount != null) {
			setViewedCount(ViewedCount);
		}

		Integer MailedCount = (Integer)attributes.get("MailedCount");

		if (MailedCount != null) {
			setMailedCount(MailedCount);
		}

		Integer RatedCount = (Integer)attributes.get("RatedCount");

		if (RatedCount != null) {
			setRatedCount(RatedCount);
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
	public int getContentID() {
		return _ContentID;
	}

	@Override
	public void setContentID(int ContentID) {
		_ContentID = ContentID;
	}

	@JSON
	@Override
	public int getVersion() {
		return _Version;
	}

	@Override
	public void setVersion(int Version) {
		_Version = Version;
	}

	@JSON
	@Override
	public int getZoneID() {
		return _ZoneID;
	}

	@Override
	public void setZoneID(int ZoneID) {
		_columnBitmask |= ZONEID_COLUMN_BITMASK;

		if (!_setOriginalZoneID) {
			_setOriginalZoneID = true;

			_originalZoneID = _ZoneID;
		}

		_ZoneID = ZoneID;
	}

	public int getOriginalZoneID() {
		return _originalZoneID;
	}

	@JSON
	@Override
	public Date getDistributedDate() {
		return _DistributedDate;
	}

	@Override
	public void setDistributedDate(Date DistributedDate) {
		_columnBitmask = -1L;

		_DistributedDate = DistributedDate;
	}

	@JSON
	@Override
	public int getRanking() {
		return _Ranking;
	}

	@Override
	public void setRanking(int Ranking) {
		_Ranking = Ranking;
	}

	@JSON
	@Override
	public boolean getAllowDiscussion() {
		return _AllowDiscussion;
	}

	@Override
	public boolean isAllowDiscussion() {
		return _AllowDiscussion;
	}

	@Override
	public void setAllowDiscussion(boolean AllowDiscussion) {
		_AllowDiscussion = AllowDiscussion;
	}

	@JSON
	@Override
	public int getViewedCount() {
		return _ViewedCount;
	}

	@Override
	public void setViewedCount(int ViewedCount) {
		_ViewedCount = ViewedCount;
	}

	@JSON
	@Override
	public int getMailedCount() {
		return _MailedCount;
	}

	@Override
	public void setMailedCount(int MailedCount) {
		_MailedCount = MailedCount;
	}

	@JSON
	@Override
	public int getRatedCount() {
		return _RatedCount;
	}

	@Override
	public void setRatedCount(int RatedCount) {
		_RatedCount = RatedCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Legal_Distribution toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Legal_Distribution)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Legal_DistributionImpl legal_DistributionImpl = new Legal_DistributionImpl();

		legal_DistributionImpl.setID(getID());
		legal_DistributionImpl.setContentID(getContentID());
		legal_DistributionImpl.setVersion(getVersion());
		legal_DistributionImpl.setZoneID(getZoneID());
		legal_DistributionImpl.setDistributedDate(getDistributedDate());
		legal_DistributionImpl.setRanking(getRanking());
		legal_DistributionImpl.setAllowDiscussion(getAllowDiscussion());
		legal_DistributionImpl.setViewedCount(getViewedCount());
		legal_DistributionImpl.setMailedCount(getMailedCount());
		legal_DistributionImpl.setRatedCount(getRatedCount());

		legal_DistributionImpl.resetOriginalValues();

		return legal_DistributionImpl;
	}

	@Override
	public int compareTo(Legal_Distribution legal_Distribution) {
		int value = 0;

		value = DateUtil.compareTo(getDistributedDate(),
				legal_Distribution.getDistributedDate());

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

		if (!(obj instanceof Legal_Distribution)) {
			return false;
		}

		Legal_Distribution legal_Distribution = (Legal_Distribution)obj;

		int primaryKey = legal_Distribution.getPrimaryKey();

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
		Legal_DistributionModelImpl legal_DistributionModelImpl = this;

		legal_DistributionModelImpl._originalZoneID = legal_DistributionModelImpl._ZoneID;

		legal_DistributionModelImpl._setOriginalZoneID = false;

		legal_DistributionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Legal_Distribution> toCacheModel() {
		Legal_DistributionCacheModel legal_DistributionCacheModel = new Legal_DistributionCacheModel();

		legal_DistributionCacheModel.ID = getID();

		legal_DistributionCacheModel.ContentID = getContentID();

		legal_DistributionCacheModel.Version = getVersion();

		legal_DistributionCacheModel.ZoneID = getZoneID();

		Date DistributedDate = getDistributedDate();

		if (DistributedDate != null) {
			legal_DistributionCacheModel.DistributedDate = DistributedDate.getTime();
		}
		else {
			legal_DistributionCacheModel.DistributedDate = Long.MIN_VALUE;
		}

		legal_DistributionCacheModel.Ranking = getRanking();

		legal_DistributionCacheModel.AllowDiscussion = getAllowDiscussion();

		legal_DistributionCacheModel.ViewedCount = getViewedCount();

		legal_DistributionCacheModel.MailedCount = getMailedCount();

		legal_DistributionCacheModel.RatedCount = getRatedCount();

		return legal_DistributionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", ContentID=");
		sb.append(getContentID());
		sb.append(", Version=");
		sb.append(getVersion());
		sb.append(", ZoneID=");
		sb.append(getZoneID());
		sb.append(", DistributedDate=");
		sb.append(getDistributedDate());
		sb.append(", Ranking=");
		sb.append(getRanking());
		sb.append(", AllowDiscussion=");
		sb.append(getAllowDiscussion());
		sb.append(", ViewedCount=");
		sb.append(getViewedCount());
		sb.append(", MailedCount=");
		sb.append(getMailedCount());
		sb.append(", RatedCount=");
		sb.append(getRatedCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Distribution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ContentID</column-name><column-value><![CDATA[");
		sb.append(getContentID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ZoneID</column-name><column-value><![CDATA[");
		sb.append(getZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DistributedDate</column-name><column-value><![CDATA[");
		sb.append(getDistributedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Ranking</column-name><column-value><![CDATA[");
		sb.append(getRanking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AllowDiscussion</column-name><column-value><![CDATA[");
		sb.append(getAllowDiscussion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewedCount</column-name><column-value><![CDATA[");
		sb.append(getViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MailedCount</column-name><column-value><![CDATA[");
		sb.append(getMailedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RatedCount</column-name><column-value><![CDATA[");
		sb.append(getRatedCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Legal_Distribution.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Legal_Distribution.class
		};
	private int _ID;
	private int _ContentID;
	private int _Version;
	private int _ZoneID;
	private int _originalZoneID;
	private boolean _setOriginalZoneID;
	private Date _DistributedDate;
	private int _Ranking;
	private boolean _AllowDiscussion;
	private int _ViewedCount;
	private int _MailedCount;
	private int _RatedCount;
	private long _columnBitmask;
	private Legal_Distribution _escapedModel;
}