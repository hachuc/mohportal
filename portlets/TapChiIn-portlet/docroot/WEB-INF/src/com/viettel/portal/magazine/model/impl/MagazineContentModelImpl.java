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

import com.viettel.portal.magazine.model.MagazineContent;
import com.viettel.portal.magazine.model.MagazineContentModel;
import com.viettel.portal.magazine.model.MagazineContentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the MagazineContent service. Represents a row in the &quot;MagazineContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.magazine.model.MagazineContentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MagazineContentImpl}.
 * </p>
 *
 * @author namtv
 * @see MagazineContentImpl
 * @see com.viettel.portal.magazine.model.MagazineContent
 * @see com.viettel.portal.magazine.model.MagazineContentModel
 * @generated
 */
@JSON(strict = true)
public class MagazineContentModelImpl extends BaseModelImpl<MagazineContent>
	implements MagazineContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a magazine content model instance should use the {@link com.viettel.portal.magazine.model.MagazineContent} interface instead.
	 */
	public static final String TABLE_NAME = "MagazineContent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "Headline", Types.VARCHAR },
			{ "Teaser", Types.VARCHAR },
			{ "Body", Types.CLOB },
			{ "MagazineZoneID", Types.INTEGER },
			{ "MagazineID", Types.INTEGER },
			{ "Author", Types.VARCHAR },
			{ "Jobtitle", Types.VARCHAR },
			{ "ViewedCount", Types.INTEGER },
			{ "SortOrder", Types.INTEGER },
			{ "MailedCount", Types.INTEGER },
			{ "CreationDate", Types.TIMESTAMP },
			{ "ModifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table MagazineContent (ID INTEGER not null primary key,Headline VARCHAR(75) null,Teaser VARCHAR(75) null,Body TEXT null,MagazineZoneID INTEGER,MagazineID INTEGER,Author VARCHAR(255) null,Jobtitle VARCHAR(75) null,ViewedCount INTEGER,SortOrder INTEGER,MailedCount INTEGER,CreationDate DATE null,ModifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MagazineContent";
	public static final String ORDER_BY_JPQL = " ORDER BY magazineContent.SortOrder ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MagazineContent.SortOrder ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.magazine.model.MagazineContent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.magazine.model.MagazineContent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.magazine.model.MagazineContent"),
			true);
	public static long MAGAZINEID_COLUMN_BITMASK = 1L;
	public static long MAGAZINEZONEID_COLUMN_BITMASK = 2L;
	public static long SORTORDER_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static MagazineContent toModel(MagazineContentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		MagazineContent model = new MagazineContentImpl();

		model.setID(soapModel.getID());
		model.setHeadline(soapModel.getHeadline());
		model.setTeaser(soapModel.getTeaser());
		model.setBody(soapModel.getBody());
		model.setMagazineZoneID(soapModel.getMagazineZoneID());
		model.setMagazineID(soapModel.getMagazineID());
		model.setAuthor(soapModel.getAuthor());
		model.setJobtitle(soapModel.getJobtitle());
		model.setViewedCount(soapModel.getViewedCount());
		model.setSortOrder(soapModel.getSortOrder());
		model.setMailedCount(soapModel.getMailedCount());
		model.setCreationDate(soapModel.getCreationDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<MagazineContent> toModels(
		MagazineContentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<MagazineContent> models = new ArrayList<MagazineContent>(soapModels.length);

		for (MagazineContentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.magazine.model.MagazineContent"));

	public MagazineContentModelImpl() {
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
		return MagazineContent.class;
	}

	@Override
	public String getModelClassName() {
		return MagazineContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Headline", getHeadline());
		attributes.put("Teaser", getTeaser());
		attributes.put("Body", getBody());
		attributes.put("MagazineZoneID", getMagazineZoneID());
		attributes.put("MagazineID", getMagazineID());
		attributes.put("Author", getAuthor());
		attributes.put("Jobtitle", getJobtitle());
		attributes.put("ViewedCount", getViewedCount());
		attributes.put("SortOrder", getSortOrder());
		attributes.put("MailedCount", getMailedCount());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String Headline = (String)attributes.get("Headline");

		if (Headline != null) {
			setHeadline(Headline);
		}

		String Teaser = (String)attributes.get("Teaser");

		if (Teaser != null) {
			setTeaser(Teaser);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		Integer MagazineZoneID = (Integer)attributes.get("MagazineZoneID");

		if (MagazineZoneID != null) {
			setMagazineZoneID(MagazineZoneID);
		}

		Integer MagazineID = (Integer)attributes.get("MagazineID");

		if (MagazineID != null) {
			setMagazineID(MagazineID);
		}

		String Author = (String)attributes.get("Author");

		if (Author != null) {
			setAuthor(Author);
		}

		String Jobtitle = (String)attributes.get("Jobtitle");

		if (Jobtitle != null) {
			setJobtitle(Jobtitle);
		}

		Integer ViewedCount = (Integer)attributes.get("ViewedCount");

		if (ViewedCount != null) {
			setViewedCount(ViewedCount);
		}

		Integer SortOrder = (Integer)attributes.get("SortOrder");

		if (SortOrder != null) {
			setSortOrder(SortOrder);
		}

		Integer MailedCount = (Integer)attributes.get("MailedCount");

		if (MailedCount != null) {
			setMailedCount(MailedCount);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
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
	public String getHeadline() {
		if (_Headline == null) {
			return StringPool.BLANK;
		}
		else {
			return _Headline;
		}
	}

	@Override
	public void setHeadline(String Headline) {
		_Headline = Headline;
	}

	@JSON
	@Override
	public String getTeaser() {
		if (_Teaser == null) {
			return StringPool.BLANK;
		}
		else {
			return _Teaser;
		}
	}

	@Override
	public void setTeaser(String Teaser) {
		_Teaser = Teaser;
	}

	@JSON
	@Override
	public String getBody() {
		if (_Body == null) {
			return StringPool.BLANK;
		}
		else {
			return _Body;
		}
	}

	@Override
	public void setBody(String Body) {
		_Body = Body;
	}

	@JSON
	@Override
	public int getMagazineZoneID() {
		return _MagazineZoneID;
	}

	@Override
	public void setMagazineZoneID(int MagazineZoneID) {
		_columnBitmask |= MAGAZINEZONEID_COLUMN_BITMASK;

		if (!_setOriginalMagazineZoneID) {
			_setOriginalMagazineZoneID = true;

			_originalMagazineZoneID = _MagazineZoneID;
		}

		_MagazineZoneID = MagazineZoneID;
	}

	public int getOriginalMagazineZoneID() {
		return _originalMagazineZoneID;
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
	public String getAuthor() {
		if (_Author == null) {
			return StringPool.BLANK;
		}
		else {
			return _Author;
		}
	}

	@Override
	public void setAuthor(String Author) {
		_Author = Author;
	}

	@JSON
	@Override
	public String getJobtitle() {
		if (_Jobtitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _Jobtitle;
		}
	}

	@Override
	public void setJobtitle(String Jobtitle) {
		_Jobtitle = Jobtitle;
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
	public int getSortOrder() {
		return _SortOrder;
	}

	@Override
	public void setSortOrder(int SortOrder) {
		_columnBitmask = -1L;

		_SortOrder = SortOrder;
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
	public Date getCreationDate() {
		return _CreationDate;
	}

	@Override
	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_ModifiedDate = ModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public MagazineContent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MagazineContent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MagazineContentImpl magazineContentImpl = new MagazineContentImpl();

		magazineContentImpl.setID(getID());
		magazineContentImpl.setHeadline(getHeadline());
		magazineContentImpl.setTeaser(getTeaser());
		magazineContentImpl.setBody(getBody());
		magazineContentImpl.setMagazineZoneID(getMagazineZoneID());
		magazineContentImpl.setMagazineID(getMagazineID());
		magazineContentImpl.setAuthor(getAuthor());
		magazineContentImpl.setJobtitle(getJobtitle());
		magazineContentImpl.setViewedCount(getViewedCount());
		magazineContentImpl.setSortOrder(getSortOrder());
		magazineContentImpl.setMailedCount(getMailedCount());
		magazineContentImpl.setCreationDate(getCreationDate());
		magazineContentImpl.setModifiedDate(getModifiedDate());

		magazineContentImpl.resetOriginalValues();

		return magazineContentImpl;
	}

	@Override
	public int compareTo(MagazineContent magazineContent) {
		int value = 0;

		if (getSortOrder() < magazineContent.getSortOrder()) {
			value = -1;
		}
		else if (getSortOrder() > magazineContent.getSortOrder()) {
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

		if (!(obj instanceof MagazineContent)) {
			return false;
		}

		MagazineContent magazineContent = (MagazineContent)obj;

		int primaryKey = magazineContent.getPrimaryKey();

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
		MagazineContentModelImpl magazineContentModelImpl = this;

		magazineContentModelImpl._originalMagazineZoneID = magazineContentModelImpl._MagazineZoneID;

		magazineContentModelImpl._setOriginalMagazineZoneID = false;

		magazineContentModelImpl._originalMagazineID = magazineContentModelImpl._MagazineID;

		magazineContentModelImpl._setOriginalMagazineID = false;

		magazineContentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MagazineContent> toCacheModel() {
		MagazineContentCacheModel magazineContentCacheModel = new MagazineContentCacheModel();

		magazineContentCacheModel.ID = getID();

		magazineContentCacheModel.Headline = getHeadline();

		String Headline = magazineContentCacheModel.Headline;

		if ((Headline != null) && (Headline.length() == 0)) {
			magazineContentCacheModel.Headline = null;
		}

		magazineContentCacheModel.Teaser = getTeaser();

		String Teaser = magazineContentCacheModel.Teaser;

		if ((Teaser != null) && (Teaser.length() == 0)) {
			magazineContentCacheModel.Teaser = null;
		}

		magazineContentCacheModel.Body = getBody();

		String Body = magazineContentCacheModel.Body;

		if ((Body != null) && (Body.length() == 0)) {
			magazineContentCacheModel.Body = null;
		}

		magazineContentCacheModel.MagazineZoneID = getMagazineZoneID();

		magazineContentCacheModel.MagazineID = getMagazineID();

		magazineContentCacheModel.Author = getAuthor();

		String Author = magazineContentCacheModel.Author;

		if ((Author != null) && (Author.length() == 0)) {
			magazineContentCacheModel.Author = null;
		}

		magazineContentCacheModel.Jobtitle = getJobtitle();

		String Jobtitle = magazineContentCacheModel.Jobtitle;

		if ((Jobtitle != null) && (Jobtitle.length() == 0)) {
			magazineContentCacheModel.Jobtitle = null;
		}

		magazineContentCacheModel.ViewedCount = getViewedCount();

		magazineContentCacheModel.SortOrder = getSortOrder();

		magazineContentCacheModel.MailedCount = getMailedCount();

		Date CreationDate = getCreationDate();

		if (CreationDate != null) {
			magazineContentCacheModel.CreationDate = CreationDate.getTime();
		}
		else {
			magazineContentCacheModel.CreationDate = Long.MIN_VALUE;
		}

		Date ModifiedDate = getModifiedDate();

		if (ModifiedDate != null) {
			magazineContentCacheModel.ModifiedDate = ModifiedDate.getTime();
		}
		else {
			magazineContentCacheModel.ModifiedDate = Long.MIN_VALUE;
		}

		return magazineContentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Headline=");
		sb.append(getHeadline());
		sb.append(", Teaser=");
		sb.append(getTeaser());
		sb.append(", Body=");
		sb.append(getBody());
		sb.append(", MagazineZoneID=");
		sb.append(getMagazineZoneID());
		sb.append(", MagazineID=");
		sb.append(getMagazineID());
		sb.append(", Author=");
		sb.append(getAuthor());
		sb.append(", Jobtitle=");
		sb.append(getJobtitle());
		sb.append(", ViewedCount=");
		sb.append(getViewedCount());
		sb.append(", SortOrder=");
		sb.append(getSortOrder());
		sb.append(", MailedCount=");
		sb.append(getMailedCount());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.magazine.model.MagazineContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Headline</column-name><column-value><![CDATA[");
		sb.append(getHeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Teaser</column-name><column-value><![CDATA[");
		sb.append(getTeaser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineZoneID</column-name><column-value><![CDATA[");
		sb.append(getMagazineZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MagazineID</column-name><column-value><![CDATA[");
		sb.append(getMagazineID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Jobtitle</column-name><column-value><![CDATA[");
		sb.append(getJobtitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewedCount</column-name><column-value><![CDATA[");
		sb.append(getViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>SortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MailedCount</column-name><column-value><![CDATA[");
		sb.append(getMailedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MagazineContent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MagazineContent.class
		};
	private int _ID;
	private String _Headline;
	private String _Teaser;
	private String _Body;
	private int _MagazineZoneID;
	private int _originalMagazineZoneID;
	private boolean _setOriginalMagazineZoneID;
	private int _MagazineID;
	private int _originalMagazineID;
	private boolean _setOriginalMagazineID;
	private String _Author;
	private String _Jobtitle;
	private int _ViewedCount;
	private int _SortOrder;
	private int _MailedCount;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private long _columnBitmask;
	private MagazineContent _escapedModel;
}