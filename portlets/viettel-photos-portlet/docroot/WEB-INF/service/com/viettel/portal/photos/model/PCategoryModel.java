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

package com.viettel.portal.photos.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PCategory service. Represents a row in the &quot;portal_photocategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.photos.model.impl.PCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.photos.model.impl.PCategoryImpl}.
 * </p>
 *
 * @author ChucHV
 * @see PCategory
 * @see com.viettel.portal.photos.model.impl.PCategoryImpl
 * @see com.viettel.portal.photos.model.impl.PCategoryModelImpl
 * @generated
 */
public interface PCategoryModel extends BaseModel<PCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a p category model instance should use the {@link PCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this p category.
	 *
	 * @return the primary key of this p category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this p category.
	 *
	 * @param primaryKey the primary key of this p category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this p category.
	 *
	 * @return the ID of this p category
	 */
	public long getId();

	/**
	 * Sets the ID of this p category.
	 *
	 * @param id the ID of this p category
	 */
	public void setId(long id);

	/**
	 * Returns the name of this p category.
	 *
	 * @return the name of this p category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this p category.
	 *
	 * @param name the name of this p category
	 */
	public void setName(String name);

	/**
	 * Returns the order_ of this p category.
	 *
	 * @return the order_ of this p category
	 */
	public int getOrder_();

	/**
	 * Sets the order_ of this p category.
	 *
	 * @param order_ the order_ of this p category
	 */
	public void setOrder_(int order_);

	/**
	 * Returns the status of this p category.
	 *
	 * @return the status of this p category
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this p category is status.
	 *
	 * @return <code>true</code> if this p category is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this p category is status.
	 *
	 * @param status the status of this p category
	 */
	public void setStatus(boolean status);

	/**
	 * Returns the company ID of this p category.
	 *
	 * @return the company ID of this p category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this p category.
	 *
	 * @param companyId the company ID of this p category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this p category.
	 *
	 * @return the group ID of this p category
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this p category.
	 *
	 * @param groupId the group ID of this p category
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this p category.
	 *
	 * @return the create date of this p category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this p category.
	 *
	 * @param createDate the create date of this p category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modify date of this p category.
	 *
	 * @return the modify date of this p category
	 */
	public Date getModifyDate();

	/**
	 * Sets the modify date of this p category.
	 *
	 * @param modifyDate the modify date of this p category
	 */
	public void setModifyDate(Date modifyDate);

	/**
	 * Returns the user name of this p category.
	 *
	 * @return the user name of this p category
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this p category.
	 *
	 * @param userName the user name of this p category
	 */
	public void setUserName(String userName);

	/**
	 * Returns the user ID of this p category.
	 *
	 * @return the user ID of this p category
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this p category.
	 *
	 * @param userId the user ID of this p category
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this p category.
	 *
	 * @return the user uuid of this p category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this p category.
	 *
	 * @param userUuid the user uuid of this p category
	 */
	public void setUserUuid(String userUuid);

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
	public int compareTo(com.viettel.portal.photos.model.PCategory pCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.photos.model.PCategory> toCacheModel();

	@Override
	public com.viettel.portal.photos.model.PCategory toEscapedModel();

	@Override
	public com.viettel.portal.photos.model.PCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}