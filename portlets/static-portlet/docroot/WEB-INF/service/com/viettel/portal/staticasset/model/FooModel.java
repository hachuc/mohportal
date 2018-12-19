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

package com.viettel.portal.staticasset.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Foo service. Represents a row in the &quot;Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.staticasset.model.impl.FooModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.staticasset.model.impl.FooImpl}.
 * </p>
 *
 * @author chuchv
 * @see Foo
 * @see com.viettel.portal.staticasset.model.impl.FooImpl
 * @see com.viettel.portal.staticasset.model.impl.FooModelImpl
 * @generated
 */
public interface FooModel extends BaseModel<Foo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a foo model instance should use the {@link Foo} interface instead.
	 */

	/**
	 * Returns the primary key of this foo.
	 *
	 * @return the primary key of this foo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this foo.
	 *
	 * @param primaryKey the primary key of this foo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_ of this foo.
	 *
	 * @return the id_ of this foo
	 */
	public long getId_();

	/**
	 * Sets the id_ of this foo.
	 *
	 * @param id_ the id_ of this foo
	 */
	public void setId_(long id_);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.viettel.portal.staticasset.model.Foo foo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.staticasset.model.Foo> toCacheModel();

	@Override
	public com.viettel.portal.staticasset.model.Foo toEscapedModel();

	@Override
	public com.viettel.portal.staticasset.model.Foo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}