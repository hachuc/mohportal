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

package com.viettel.portal.links.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LCategory service. Represents a row in the &quot;portal_linkcategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.links.model.impl.LCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.links.model.impl.LCategoryImpl}.
 * </p>
 *
 * @author ChucHV
 * @see LCategory
 * @see com.viettel.portal.links.model.impl.LCategoryImpl
 * @see com.viettel.portal.links.model.impl.LCategoryModelImpl
 * @generated
 */
public interface LCategoryModel extends BaseModel<LCategory>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a l category model instance should use the {@link LCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this l category.
	 *
	 * @return the primary key of this l category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this l category.
	 *
	 * @param primaryKey the primary key of this l category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this l category.
	 *
	 * @return the category ID of this l category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this l category.
	 *
	 * @param categoryId the category ID of this l category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the group ID of this l category.
	 *
	 * @return the group ID of this l category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this l category.
	 *
	 * @param groupId the group ID of this l category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this l category.
	 *
	 * @return the company ID of this l category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this l category.
	 *
	 * @param companyId the company ID of this l category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this l category.
	 *
	 * @return the user ID of this l category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this l category.
	 *
	 * @param userId the user ID of this l category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this l category.
	 *
	 * @return the user uuid of this l category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this l category.
	 *
	 * @param userUuid the user uuid of this l category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this l category.
	 *
	 * @return the user name of this l category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this l category.
	 *
	 * @param userName the user name of this l category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this l category.
	 *
	 * @return the create date of this l category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this l category.
	 *
	 * @param createDate the create date of this l category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this l category.
	 *
	 * @return the modified date of this l category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this l category.
	 *
	 * @param modifiedDate the modified date of this l category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the category name of this l category.
	 *
	 * @return the category name of this l category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this l category.
	 *
	 * @param categoryName the category name of this l category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * Returns the corder of this l category.
	 *
	 * @return the corder of this l category
	 */
	public int getCorder();

	/**
	 * Sets the corder of this l category.
	 *
	 * @param corder the corder of this l category
	 */
	public void setCorder(int corder);

	/**
	 * Returns the is active of this l category.
	 *
	 * @return the is active of this l category
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this l category is is active.
	 *
	 * @return <code>true</code> if this l category is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this l category is is active.
	 *
	 * @param isActive the is active of this l category
	 */
	public void setIsActive(boolean isActive);

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
	public int compareTo(com.viettel.portal.links.model.LCategory lCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.links.model.LCategory> toCacheModel();

	@Override
	public com.viettel.portal.links.model.LCategory toEscapedModel();

	@Override
	public com.viettel.portal.links.model.LCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}