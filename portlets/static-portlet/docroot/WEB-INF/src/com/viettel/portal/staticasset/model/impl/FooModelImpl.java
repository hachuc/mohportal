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

package com.viettel.portal.staticasset.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.viettel.portal.staticasset.model.Foo;
import com.viettel.portal.staticasset.model.FooModel;
import com.viettel.portal.staticasset.model.FooSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Foo service. Represents a row in the &quot;Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.staticasset.model.FooModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FooImpl}.
 * </p>
 *
 * @author chuchv
 * @see FooImpl
 * @see com.viettel.portal.staticasset.model.Foo
 * @see com.viettel.portal.staticasset.model.FooModel
 * @generated
 */
@JSON(strict = true)
public class FooModelImpl extends BaseModelImpl<Foo> implements FooModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a foo model instance should use the {@link com.viettel.portal.staticasset.model.Foo} interface instead.
	 */
	public static final String TABLE_NAME = "Foo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Foo (id_ LONG not null primary key)";
	public static final String TABLE_SQL_DROP = "drop table Foo";
	public static final String ORDER_BY_JPQL = " ORDER BY foo.id_ ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Foo.id_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.staticasset.model.Foo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.staticasset.model.Foo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Foo toModel(FooSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Foo model = new FooImpl();

		model.setId_(soapModel.getId_());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Foo> toModels(FooSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Foo> models = new ArrayList<Foo>(soapModels.length);

		for (FooSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.staticasset.model.Foo"));

	public FooModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Foo.class;
	}

	@Override
	public String getModelClassName() {
		return Foo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
		}
	}

	@JSON
	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Foo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Foo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Foo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FooImpl fooImpl = new FooImpl();

		fooImpl.setId_(getId_());

		fooImpl.resetOriginalValues();

		return fooImpl;
	}

	@Override
	public int compareTo(Foo foo) {
		long primaryKey = foo.getPrimaryKey();

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

		if (!(obj instanceof Foo)) {
			return false;
		}

		Foo foo = (Foo)obj;

		long primaryKey = foo.getPrimaryKey();

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
	public CacheModel<Foo> toCacheModel() {
		FooCacheModel fooCacheModel = new FooCacheModel();

		fooCacheModel.id_ = getId_();

		return fooCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{id_=");
		sb.append(getId_());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.staticasset.model.Foo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_</column-name><column-value><![CDATA[");
		sb.append(getId_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Foo.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Foo.class };
	private long _id_;
	private Foo _escapedModel;
}