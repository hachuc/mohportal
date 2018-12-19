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

package com.portal_egov.portlet.legal_faq.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LegalFAQCategory service. Represents a row in the &quot;LegalFAQCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryImpl}.
 * </p>
 *
 * @author chuchv
 * @see LegalFAQCategory
 * @see com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryImpl
 * @see com.portal_egov.portlet.legal_faq.model.impl.LegalFAQCategoryModelImpl
 * @generated
 */
public interface LegalFAQCategoryModel extends BaseModel<LegalFAQCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a legal f a q category model instance should use the {@link LegalFAQCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this legal f a q category.
	 *
	 * @return the primary key of this legal f a q category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this legal f a q category.
	 *
	 * @param primaryKey the primary key of this legal f a q category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this legal f a q category.
	 *
	 * @return the category ID of this legal f a q category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this legal f a q category.
	 *
	 * @param categoryId the category ID of this legal f a q category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the company ID of this legal f a q category.
	 *
	 * @return the company ID of this legal f a q category
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this legal f a q category.
	 *
	 * @param companyId the company ID of this legal f a q category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this legal f a q category.
	 *
	 * @return the group ID of this legal f a q category
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this legal f a q category.
	 *
	 * @param groupId the group ID of this legal f a q category
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this legal f a q category.
	 *
	 * @return the user ID of this legal f a q category
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this legal f a q category.
	 *
	 * @param userId the user ID of this legal f a q category
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this legal f a q category.
	 *
	 * @return the user uuid of this legal f a q category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this legal f a q category.
	 *
	 * @param userUuid the user uuid of this legal f a q category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the parent ID of this legal f a q category.
	 *
	 * @return the parent ID of this legal f a q category
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this legal f a q category.
	 *
	 * @param parentId the parent ID of this legal f a q category
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the category name of this legal f a q category.
	 *
	 * @return the category name of this legal f a q category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this legal f a q category.
	 *
	 * @param categoryName the category name of this legal f a q category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * Returns the category desc of this legal f a q category.
	 *
	 * @return the category desc of this legal f a q category
	 */
	@AutoEscape
	public String getCategoryDesc();

	/**
	 * Sets the category desc of this legal f a q category.
	 *
	 * @param categoryDesc the category desc of this legal f a q category
	 */
	public void setCategoryDesc(String categoryDesc);

	/**
	 * Returns the category type of this legal f a q category.
	 *
	 * @return the category type of this legal f a q category
	 */
	public int getCategoryType();

	/**
	 * Sets the category type of this legal f a q category.
	 *
	 * @param categoryType the category type of this legal f a q category
	 */
	public void setCategoryType(int categoryType);

	/**
	 * Returns the create date of this legal f a q category.
	 *
	 * @return the create date of this legal f a q category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this legal f a q category.
	 *
	 * @param createDate the create date of this legal f a q category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this legal f a q category.
	 *
	 * @return the modified date of this legal f a q category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this legal f a q category.
	 *
	 * @param modifiedDate the modified date of this legal f a q category
	 */
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(
		com.portal_egov.portlet.legal_faq.model.LegalFAQCategory legalFAQCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.portal_egov.portlet.legal_faq.model.LegalFAQCategory> toCacheModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory toEscapedModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}