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

package com.viettel.portal.videolibrary.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.videolibrary.model.VideoClip;
import com.viettel.portal.videolibrary.model.VideoClipModel;
import com.viettel.portal.videolibrary.model.VideoClipSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VideoClip service. Represents a row in the &quot;VideoClip&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.videolibrary.model.VideoClipModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoClipImpl}.
 * </p>
 *
 * @author ChucHV
 * @see VideoClipImpl
 * @see com.viettel.portal.videolibrary.model.VideoClip
 * @see com.viettel.portal.videolibrary.model.VideoClipModel
 * @generated
 */
@JSON(strict = true)
public class VideoClipModelImpl extends BaseModelImpl<VideoClip>
	implements VideoClipModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video clip model instance should use the {@link com.viettel.portal.videolibrary.model.VideoClip} interface instead.
	 */
	public static final String TABLE_NAME = "VideoClip";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "Name", Types.VARCHAR },
			{ "CategoryID", Types.INTEGER },
			{ "Description", Types.VARCHAR },
			{ "ImageUrl", Types.VARCHAR },
			{ "VideoUrl", Types.VARCHAR },
			{ "Duration", Types.INTEGER },
			{ "ViewCount", Types.INTEGER },
			{ "Status", Types.INTEGER },
			{ "CreationDate", Types.TIMESTAMP },
			{ "ModifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table VideoClip (ID INTEGER not null primary key,Name VARCHAR(75) null,CategoryID INTEGER,Description VARCHAR(75) null,ImageUrl VARCHAR(75) null,VideoUrl VARCHAR(75) null,Duration INTEGER,ViewCount INTEGER,Status INTEGER,CreationDate DATE null,ModifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table VideoClip";
	public static final String ORDER_BY_JPQL = " ORDER BY videoClip.ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY VideoClip.ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.videolibrary.model.VideoClip"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.videolibrary.model.VideoClip"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.videolibrary.model.VideoClip"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VideoClip toModel(VideoClipSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VideoClip model = new VideoClipImpl();

		model.setID(soapModel.getID());
		model.setName(soapModel.getName());
		model.setCategoryID(soapModel.getCategoryID());
		model.setDescription(soapModel.getDescription());
		model.setImageUrl(soapModel.getImageUrl());
		model.setVideoUrl(soapModel.getVideoUrl());
		model.setDuration(soapModel.getDuration());
		model.setViewCount(soapModel.getViewCount());
		model.setStatus(soapModel.getStatus());
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
	public static List<VideoClip> toModels(VideoClipSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VideoClip> models = new ArrayList<VideoClip>(soapModels.length);

		for (VideoClipSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.videolibrary.model.VideoClip"));

	public VideoClipModelImpl() {
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
		return VideoClip.class;
	}

	@Override
	public String getModelClassName() {
		return VideoClip.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("Name", getName());
		attributes.put("CategoryID", getCategoryID());
		attributes.put("Description", getDescription());
		attributes.put("ImageUrl", getImageUrl());
		attributes.put("VideoUrl", getVideoUrl());
		attributes.put("Duration", getDuration());
		attributes.put("ViewCount", getViewCount());
		attributes.put("Status", getStatus());
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

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer CategoryID = (Integer)attributes.get("CategoryID");

		if (CategoryID != null) {
			setCategoryID(CategoryID);
		}

		String Description = (String)attributes.get("Description");

		if (Description != null) {
			setDescription(Description);
		}

		String ImageUrl = (String)attributes.get("ImageUrl");

		if (ImageUrl != null) {
			setImageUrl(ImageUrl);
		}

		String VideoUrl = (String)attributes.get("VideoUrl");

		if (VideoUrl != null) {
			setVideoUrl(VideoUrl);
		}

		Integer Duration = (Integer)attributes.get("Duration");

		if (Duration != null) {
			setDuration(Duration);
		}

		Integer ViewCount = (Integer)attributes.get("ViewCount");

		if (ViewCount != null) {
			setViewCount(ViewCount);
		}

		Integer Status = (Integer)attributes.get("Status");

		if (Status != null) {
			setStatus(Status);
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
	public int getCategoryID() {
		return _CategoryID;
	}

	@Override
	public void setCategoryID(int CategoryID) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryID) {
			_setOriginalCategoryID = true;

			_originalCategoryID = _CategoryID;
		}

		_CategoryID = CategoryID;
	}

	public int getOriginalCategoryID() {
		return _originalCategoryID;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_Description == null) {
			return StringPool.BLANK;
		}
		else {
			return _Description;
		}
	}

	@Override
	public void setDescription(String Description) {
		_Description = Description;
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
	public String getVideoUrl() {
		if (_VideoUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _VideoUrl;
		}
	}

	@Override
	public void setVideoUrl(String VideoUrl) {
		_VideoUrl = VideoUrl;
	}

	@JSON
	@Override
	public int getDuration() {
		return _Duration;
	}

	@Override
	public void setDuration(int Duration) {
		_Duration = Duration;
	}

	@JSON
	@Override
	public int getViewCount() {
		return _ViewCount;
	}

	@Override
	public void setViewCount(int ViewCount) {
		_ViewCount = ViewCount;
	}

	@JSON
	@Override
	public int getStatus() {
		return _Status;
	}

	@Override
	public void setStatus(int Status) {
		_Status = Status;
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
	public VideoClip toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VideoClip)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VideoClipImpl videoClipImpl = new VideoClipImpl();

		videoClipImpl.setID(getID());
		videoClipImpl.setName(getName());
		videoClipImpl.setCategoryID(getCategoryID());
		videoClipImpl.setDescription(getDescription());
		videoClipImpl.setImageUrl(getImageUrl());
		videoClipImpl.setVideoUrl(getVideoUrl());
		videoClipImpl.setDuration(getDuration());
		videoClipImpl.setViewCount(getViewCount());
		videoClipImpl.setStatus(getStatus());
		videoClipImpl.setCreationDate(getCreationDate());
		videoClipImpl.setModifiedDate(getModifiedDate());

		videoClipImpl.resetOriginalValues();

		return videoClipImpl;
	}

	@Override
	public int compareTo(VideoClip videoClip) {
		int primaryKey = videoClip.getPrimaryKey();

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

		if (!(obj instanceof VideoClip)) {
			return false;
		}

		VideoClip videoClip = (VideoClip)obj;

		int primaryKey = videoClip.getPrimaryKey();

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
		VideoClipModelImpl videoClipModelImpl = this;

		videoClipModelImpl._originalCategoryID = videoClipModelImpl._CategoryID;

		videoClipModelImpl._setOriginalCategoryID = false;

		videoClipModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VideoClip> toCacheModel() {
		VideoClipCacheModel videoClipCacheModel = new VideoClipCacheModel();

		videoClipCacheModel.ID = getID();

		videoClipCacheModel.Name = getName();

		String Name = videoClipCacheModel.Name;

		if ((Name != null) && (Name.length() == 0)) {
			videoClipCacheModel.Name = null;
		}

		videoClipCacheModel.CategoryID = getCategoryID();

		videoClipCacheModel.Description = getDescription();

		String Description = videoClipCacheModel.Description;

		if ((Description != null) && (Description.length() == 0)) {
			videoClipCacheModel.Description = null;
		}

		videoClipCacheModel.ImageUrl = getImageUrl();

		String ImageUrl = videoClipCacheModel.ImageUrl;

		if ((ImageUrl != null) && (ImageUrl.length() == 0)) {
			videoClipCacheModel.ImageUrl = null;
		}

		videoClipCacheModel.VideoUrl = getVideoUrl();

		String VideoUrl = videoClipCacheModel.VideoUrl;

		if ((VideoUrl != null) && (VideoUrl.length() == 0)) {
			videoClipCacheModel.VideoUrl = null;
		}

		videoClipCacheModel.Duration = getDuration();

		videoClipCacheModel.ViewCount = getViewCount();

		videoClipCacheModel.Status = getStatus();

		Date CreationDate = getCreationDate();

		if (CreationDate != null) {
			videoClipCacheModel.CreationDate = CreationDate.getTime();
		}
		else {
			videoClipCacheModel.CreationDate = Long.MIN_VALUE;
		}

		Date ModifiedDate = getModifiedDate();

		if (ModifiedDate != null) {
			videoClipCacheModel.ModifiedDate = ModifiedDate.getTime();
		}
		else {
			videoClipCacheModel.ModifiedDate = Long.MIN_VALUE;
		}

		return videoClipCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", CategoryID=");
		sb.append(getCategoryID());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append(", ImageUrl=");
		sb.append(getImageUrl());
		sb.append(", VideoUrl=");
		sb.append(getVideoUrl());
		sb.append(", Duration=");
		sb.append(getDuration());
		sb.append(", ViewCount=");
		sb.append(getViewCount());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.videolibrary.model.VideoClip");
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
			"<column><column-name>CategoryID</column-name><column-value><![CDATA[");
		sb.append(getCategoryID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>VideoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private static ClassLoader _classLoader = VideoClip.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VideoClip.class
		};
	private int _ID;
	private String _Name;
	private int _CategoryID;
	private int _originalCategoryID;
	private boolean _setOriginalCategoryID;
	private String _Description;
	private String _ImageUrl;
	private String _VideoUrl;
	private int _Duration;
	private int _ViewCount;
	private int _Status;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private long _columnBitmask;
	private VideoClip _escapedModel;
}