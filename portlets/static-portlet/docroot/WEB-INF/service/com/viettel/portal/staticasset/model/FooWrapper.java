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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Foo}.
 * </p>
 *
 * @author chuchv
 * @see Foo
 * @generated
 */
public class FooWrapper implements Foo, ModelWrapper<Foo> {
	public FooWrapper(Foo foo) {
		_foo = foo;
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

	/**
	* Returns the primary key of this foo.
	*
	* @return the primary key of this foo
	*/
	@Override
	public long getPrimaryKey() {
		return _foo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this foo.
	*
	* @param primaryKey the primary key of this foo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_foo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_ of this foo.
	*
	* @return the id_ of this foo
	*/
	@Override
	public long getId_() {
		return _foo.getId_();
	}

	/**
	* Sets the id_ of this foo.
	*
	* @param id_ the id_ of this foo
	*/
	@Override
	public void setId_(long id_) {
		_foo.setId_(id_);
	}

	@Override
	public boolean isNew() {
		return _foo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_foo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _foo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_foo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _foo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _foo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_foo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _foo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_foo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_foo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_foo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FooWrapper((Foo)_foo.clone());
	}

	@Override
	public int compareTo(com.viettel.portal.staticasset.model.Foo foo) {
		return _foo.compareTo(foo);
	}

	@Override
	public int hashCode() {
		return _foo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.staticasset.model.Foo> toCacheModel() {
		return _foo.toCacheModel();
	}

	@Override
	public com.viettel.portal.staticasset.model.Foo toEscapedModel() {
		return new FooWrapper(_foo.toEscapedModel());
	}

	@Override
	public com.viettel.portal.staticasset.model.Foo toUnescapedModel() {
		return new FooWrapper(_foo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _foo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _foo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_foo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FooWrapper)) {
			return false;
		}

		FooWrapper fooWrapper = (FooWrapper)obj;

		if (Validator.equals(_foo, fooWrapper._foo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Foo getWrappedFoo() {
		return _foo;
	}

	@Override
	public Foo getWrappedModel() {
		return _foo;
	}

	@Override
	public void resetOriginalValues() {
		_foo.resetOriginalValues();
	}

	private Foo _foo;
}