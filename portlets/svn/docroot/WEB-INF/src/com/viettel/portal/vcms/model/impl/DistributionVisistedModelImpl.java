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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.viettel.portal.vcms.model.DistributionVisisted;
import com.viettel.portal.vcms.model.DistributionVisistedModel;
import com.viettel.portal.vcms.model.DistributionVisistedSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the DistributionVisisted service. Represents a row in the &quot;vcms_Distribution_Visisted&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.DistributionVisistedModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DistributionVisistedImpl}.
 * </p>
 *
 * @author chuchv
 * @see DistributionVisistedImpl
 * @see com.viettel.portal.vcms.model.DistributionVisisted
 * @see com.viettel.portal.vcms.model.DistributionVisistedModel
 * @generated
 */
@JSON(strict = true)
public class DistributionVisistedModelImpl extends BaseModelImpl<DistributionVisisted>
	implements DistributionVisistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a distribution visisted model instance should use the {@link com.viettel.portal.vcms.model.DistributionVisisted} interface instead.
	 */
	public static final String TABLE_NAME = "vcms_Distribution_Visisted";
	public static final Object[][] TABLE_COLUMNS = {
			{ "visistedId", Types.BIGINT },
			{ "distributionId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table vcms_Distribution_Visisted (visistedId LONG not null primary key,distributionId LONG,groupId LONG,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vcms_Distribution_Visisted";
	public static final String ORDER_BY_JPQL = " ORDER BY distributionVisisted.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vcms_Distribution_Visisted.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.DistributionVisisted"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.DistributionVisisted"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.DistributionVisisted"),
			true);
	public static long DISTRIBUTIONID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DistributionVisisted toModel(
		DistributionVisistedSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DistributionVisisted model = new DistributionVisistedImpl();

		model.setVisistedId(soapModel.getVisistedId());
		model.setDistributionId(soapModel.getDistributionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DistributionVisisted> toModels(
		DistributionVisistedSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<DistributionVisisted> models = new ArrayList<DistributionVisisted>(soapModels.length);

		for (DistributionVisistedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.DistributionVisisted"));

	public DistributionVisistedModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _visistedId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVisistedId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _visistedId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DistributionVisisted.class;
	}

	@Override
	public String getModelClassName() {
		return DistributionVisisted.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("visistedId", getVisistedId());
		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long visistedId = (Long)attributes.get("visistedId");

		if (visistedId != null) {
			setVisistedId(visistedId);
		}

		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public long getVisistedId() {
		return _visistedId;
	}

	@Override
	public void setVisistedId(long visistedId) {
		_visistedId = visistedId;
	}

	@JSON
	@Override
	public long getDistributionId() {
		return _distributionId;
	}

	@Override
	public void setDistributionId(long distributionId) {
		_columnBitmask |= DISTRIBUTIONID_COLUMN_BITMASK;

		if (!_setOriginalDistributionId) {
			_setOriginalDistributionId = true;

			_originalDistributionId = _distributionId;
		}

		_distributionId = distributionId;
	}

	public long getOriginalDistributionId() {
		return _originalDistributionId;
	}

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			DistributionVisisted.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DistributionVisisted toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DistributionVisisted)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DistributionVisistedImpl distributionVisistedImpl = new DistributionVisistedImpl();

		distributionVisistedImpl.setVisistedId(getVisistedId());
		distributionVisistedImpl.setDistributionId(getDistributionId());
		distributionVisistedImpl.setGroupId(getGroupId());
		distributionVisistedImpl.setCreateDate(getCreateDate());

		distributionVisistedImpl.resetOriginalValues();

		return distributionVisistedImpl;
	}

	@Override
	public int compareTo(DistributionVisisted distributionVisisted) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				distributionVisisted.getCreateDate());

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

		if (!(obj instanceof DistributionVisisted)) {
			return false;
		}

		DistributionVisisted distributionVisisted = (DistributionVisisted)obj;

		long primaryKey = distributionVisisted.getPrimaryKey();

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
		DistributionVisistedModelImpl distributionVisistedModelImpl = this;

		distributionVisistedModelImpl._originalDistributionId = distributionVisistedModelImpl._distributionId;

		distributionVisistedModelImpl._setOriginalDistributionId = false;

		distributionVisistedModelImpl._originalGroupId = distributionVisistedModelImpl._groupId;

		distributionVisistedModelImpl._setOriginalGroupId = false;

		distributionVisistedModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DistributionVisisted> toCacheModel() {
		DistributionVisistedCacheModel distributionVisistedCacheModel = new DistributionVisistedCacheModel();

		distributionVisistedCacheModel.visistedId = getVisistedId();

		distributionVisistedCacheModel.distributionId = getDistributionId();

		distributionVisistedCacheModel.groupId = getGroupId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			distributionVisistedCacheModel.createDate = createDate.getTime();
		}
		else {
			distributionVisistedCacheModel.createDate = Long.MIN_VALUE;
		}

		return distributionVisistedCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{visistedId=");
		sb.append(getVisistedId());
		sb.append(", distributionId=");
		sb.append(getDistributionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.DistributionVisisted");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>visistedId</column-name><column-value><![CDATA[");
		sb.append(getVisistedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distributionId</column-name><column-value><![CDATA[");
		sb.append(getDistributionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DistributionVisisted.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DistributionVisisted.class
		};
	private long _visistedId;
	private long _distributionId;
	private long _originalDistributionId;
	private boolean _setOriginalDistributionId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _createDate;
	private long _columnBitmask;
	private DistributionVisisted _escapedModel;
}