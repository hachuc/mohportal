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

package com.viettel.portal.vcms.model;

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
 * The base model interface for the Distribution service. Represents a row in the &quot;vcms_Distribution&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.vcms.model.impl.DistributionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.vcms.model.impl.DistributionImpl}.
 * </p>
 *
 * @author chuchv
 * @see Distribution
 * @see com.viettel.portal.vcms.model.impl.DistributionImpl
 * @see com.viettel.portal.vcms.model.impl.DistributionModelImpl
 * @generated
 */
public interface DistributionModel extends BaseModel<Distribution>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a distribution model instance should use the {@link Distribution} interface instead.
	 */

	/**
	 * Returns the primary key of this distribution.
	 *
	 * @return the primary key of this distribution
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this distribution.
	 *
	 * @param primaryKey the primary key of this distribution
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the distribution ID of this distribution.
	 *
	 * @return the distribution ID of this distribution
	 */
	public long getDistributionId();

	/**
	 * Sets the distribution ID of this distribution.
	 *
	 * @param distributionId the distribution ID of this distribution
	 */
	public void setDistributionId(long distributionId);

	/**
	 * Returns the group ID of this distribution.
	 *
	 * @return the group ID of this distribution
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this distribution.
	 *
	 * @param groupId the group ID of this distribution
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this distribution.
	 *
	 * @return the company ID of this distribution
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this distribution.
	 *
	 * @param companyId the company ID of this distribution
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this distribution.
	 *
	 * @return the user ID of this distribution
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this distribution.
	 *
	 * @param userId the user ID of this distribution
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this distribution.
	 *
	 * @return the user uuid of this distribution
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this distribution.
	 *
	 * @param userUuid the user uuid of this distribution
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this distribution.
	 *
	 * @return the user name of this distribution
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this distribution.
	 *
	 * @param userName the user name of this distribution
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this distribution.
	 *
	 * @return the create date of this distribution
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this distribution.
	 *
	 * @param createDate the create date of this distribution
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this distribution.
	 *
	 * @return the modified date of this distribution
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this distribution.
	 *
	 * @param modifiedDate the modified date of this distribution
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the version of this distribution.
	 *
	 * @return the version of this distribution
	 */
	public int getVersion();

	/**
	 * Sets the version of this distribution.
	 *
	 * @param version the version of this distribution
	 */
	public void setVersion(int version);

	/**
	 * Returns the subversion of this distribution.
	 *
	 * @return the subversion of this distribution
	 */
	public float getSubversion();

	/**
	 * Sets the subversion of this distribution.
	 *
	 * @param subversion the subversion of this distribution
	 */
	public void setSubversion(float subversion);

	/**
	 * Returns the content ID of this distribution.
	 *
	 * @return the content ID of this distribution
	 */
	public long getContentId();

	/**
	 * Sets the content ID of this distribution.
	 *
	 * @param contentId the content ID of this distribution
	 */
	public void setContentId(long contentId);

	/**
	 * Returns the category ID of this distribution.
	 *
	 * @return the category ID of this distribution
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this distribution.
	 *
	 * @param categoryId the category ID of this distribution
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the distributed date of this distribution.
	 *
	 * @return the distributed date of this distribution
	 */
	public Date getDistributedDate();

	/**
	 * Sets the distributed date of this distribution.
	 *
	 * @param distributedDate the distributed date of this distribution
	 */
	public void setDistributedDate(Date distributedDate);

	/**
	 * Returns the allow discussion of this distribution.
	 *
	 * @return the allow discussion of this distribution
	 */
	public boolean getAllowDiscussion();

	/**
	 * Returns <code>true</code> if this distribution is allow discussion.
	 *
	 * @return <code>true</code> if this distribution is allow discussion; <code>false</code> otherwise
	 */
	public boolean isAllowDiscussion();

	/**
	 * Sets whether this distribution is allow discussion.
	 *
	 * @param allowDiscussion the allow discussion of this distribution
	 */
	public void setAllowDiscussion(boolean allowDiscussion);

	/**
	 * Returns the title of this distribution.
	 *
	 * @return the title of this distribution
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this distribution.
	 *
	 * @param title the title of this distribution
	 */
	public void setTitle(String title);

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
		com.viettel.portal.vcms.model.Distribution distribution);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.vcms.model.Distribution> toCacheModel();

	@Override
	public com.viettel.portal.vcms.model.Distribution toEscapedModel();

	@Override
	public com.viettel.portal.vcms.model.Distribution toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}