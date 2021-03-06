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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DistributionVisisted service. Represents a row in the &quot;vcms_Distribution_Visisted&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.vcms.model.impl.DistributionVisistedImpl}.
 * </p>
 *
 * @author chuchv
 * @see DistributionVisisted
 * @see com.viettel.portal.vcms.model.impl.DistributionVisistedImpl
 * @see com.viettel.portal.vcms.model.impl.DistributionVisistedModelImpl
 * @generated
 */
public interface DistributionVisistedModel extends BaseModel<DistributionVisisted> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a distribution visisted model instance should use the {@link DistributionVisisted} interface instead.
	 */

	/**
	 * Returns the primary key of this distribution visisted.
	 *
	 * @return the primary key of this distribution visisted
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this distribution visisted.
	 *
	 * @param primaryKey the primary key of this distribution visisted
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the visisted ID of this distribution visisted.
	 *
	 * @return the visisted ID of this distribution visisted
	 */
	public long getVisistedId();

	/**
	 * Sets the visisted ID of this distribution visisted.
	 *
	 * @param visistedId the visisted ID of this distribution visisted
	 */
	public void setVisistedId(long visistedId);

	/**
	 * Returns the distribution ID of this distribution visisted.
	 *
	 * @return the distribution ID of this distribution visisted
	 */
	public long getDistributionId();

	/**
	 * Sets the distribution ID of this distribution visisted.
	 *
	 * @param distributionId the distribution ID of this distribution visisted
	 */
	public void setDistributionId(long distributionId);

	/**
	 * Returns the group ID of this distribution visisted.
	 *
	 * @return the group ID of this distribution visisted
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this distribution visisted.
	 *
	 * @param groupId the group ID of this distribution visisted
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the create date of this distribution visisted.
	 *
	 * @return the create date of this distribution visisted
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this distribution visisted.
	 *
	 * @param createDate the create date of this distribution visisted
	 */
	public void setCreateDate(Date createDate);

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
		com.viettel.portal.vcms.model.DistributionVisisted distributionVisisted);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.vcms.model.DistributionVisisted> toCacheModel();

	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted toEscapedModel();

	@Override
	public com.viettel.portal.vcms.model.DistributionVisisted toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}