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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Distribution}.
 * </p>
 *
 * @author chuchv
 * @see Distribution
 * @generated
 */
public class DistributionWrapper implements Distribution,
	ModelWrapper<Distribution> {
	public DistributionWrapper(Distribution distribution) {
		_distribution = distribution;
	}

	@Override
	public Class<?> getModelClass() {
		return Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Distribution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("distributionId", getDistributionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("version", getVersion());
		attributes.put("contentId", getContentId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("distributedDate", getDistributedDate());
		attributes.put("allowDiscussion", getAllowDiscussion());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer version = (Integer)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Date distributedDate = (Date)attributes.get("distributedDate");

		if (distributedDate != null) {
			setDistributedDate(distributedDate);
		}

		Boolean allowDiscussion = (Boolean)attributes.get("allowDiscussion");

		if (allowDiscussion != null) {
			setAllowDiscussion(allowDiscussion);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	/**
	* Returns the primary key of this distribution.
	*
	* @return the primary key of this distribution
	*/
	@Override
	public long getPrimaryKey() {
		return _distribution.getPrimaryKey();
	}

	/**
	* Sets the primary key of this distribution.
	*
	* @param primaryKey the primary key of this distribution
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_distribution.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the distribution ID of this distribution.
	*
	* @return the distribution ID of this distribution
	*/
	@Override
	public long getDistributionId() {
		return _distribution.getDistributionId();
	}

	/**
	* Sets the distribution ID of this distribution.
	*
	* @param distributionId the distribution ID of this distribution
	*/
	@Override
	public void setDistributionId(long distributionId) {
		_distribution.setDistributionId(distributionId);
	}

	/**
	* Returns the group ID of this distribution.
	*
	* @return the group ID of this distribution
	*/
	@Override
	public long getGroupId() {
		return _distribution.getGroupId();
	}

	/**
	* Sets the group ID of this distribution.
	*
	* @param groupId the group ID of this distribution
	*/
	@Override
	public void setGroupId(long groupId) {
		_distribution.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this distribution.
	*
	* @return the company ID of this distribution
	*/
	@Override
	public long getCompanyId() {
		return _distribution.getCompanyId();
	}

	/**
	* Sets the company ID of this distribution.
	*
	* @param companyId the company ID of this distribution
	*/
	@Override
	public void setCompanyId(long companyId) {
		_distribution.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this distribution.
	*
	* @return the user ID of this distribution
	*/
	@Override
	public long getUserId() {
		return _distribution.getUserId();
	}

	/**
	* Sets the user ID of this distribution.
	*
	* @param userId the user ID of this distribution
	*/
	@Override
	public void setUserId(long userId) {
		_distribution.setUserId(userId);
	}

	/**
	* Returns the user uuid of this distribution.
	*
	* @return the user uuid of this distribution
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _distribution.getUserUuid();
	}

	/**
	* Sets the user uuid of this distribution.
	*
	* @param userUuid the user uuid of this distribution
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_distribution.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this distribution.
	*
	* @return the user name of this distribution
	*/
	@Override
	public java.lang.String getUserName() {
		return _distribution.getUserName();
	}

	/**
	* Sets the user name of this distribution.
	*
	* @param userName the user name of this distribution
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_distribution.setUserName(userName);
	}

	/**
	* Returns the create date of this distribution.
	*
	* @return the create date of this distribution
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _distribution.getCreateDate();
	}

	/**
	* Sets the create date of this distribution.
	*
	* @param createDate the create date of this distribution
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_distribution.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this distribution.
	*
	* @return the modified date of this distribution
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _distribution.getModifiedDate();
	}

	/**
	* Sets the modified date of this distribution.
	*
	* @param modifiedDate the modified date of this distribution
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_distribution.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the version of this distribution.
	*
	* @return the version of this distribution
	*/
	@Override
	public int getVersion() {
		return _distribution.getVersion();
	}

	/**
	* Sets the version of this distribution.
	*
	* @param version the version of this distribution
	*/
	@Override
	public void setVersion(int version) {
		_distribution.setVersion(version);
	}

	/**
	* Returns the content ID of this distribution.
	*
	* @return the content ID of this distribution
	*/
	@Override
	public long getContentId() {
		return _distribution.getContentId();
	}

	/**
	* Sets the content ID of this distribution.
	*
	* @param contentId the content ID of this distribution
	*/
	@Override
	public void setContentId(long contentId) {
		_distribution.setContentId(contentId);
	}

	/**
	* Returns the category ID of this distribution.
	*
	* @return the category ID of this distribution
	*/
	@Override
	public long getCategoryId() {
		return _distribution.getCategoryId();
	}

	/**
	* Sets the category ID of this distribution.
	*
	* @param categoryId the category ID of this distribution
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_distribution.setCategoryId(categoryId);
	}

	/**
	* Returns the distributed date of this distribution.
	*
	* @return the distributed date of this distribution
	*/
	@Override
	public java.util.Date getDistributedDate() {
		return _distribution.getDistributedDate();
	}

	/**
	* Sets the distributed date of this distribution.
	*
	* @param distributedDate the distributed date of this distribution
	*/
	@Override
	public void setDistributedDate(java.util.Date distributedDate) {
		_distribution.setDistributedDate(distributedDate);
	}

	/**
	* Returns the allow discussion of this distribution.
	*
	* @return the allow discussion of this distribution
	*/
	@Override
	public boolean getAllowDiscussion() {
		return _distribution.getAllowDiscussion();
	}

	/**
	* Returns <code>true</code> if this distribution is allow discussion.
	*
	* @return <code>true</code> if this distribution is allow discussion; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllowDiscussion() {
		return _distribution.isAllowDiscussion();
	}

	/**
	* Sets whether this distribution is allow discussion.
	*
	* @param allowDiscussion the allow discussion of this distribution
	*/
	@Override
	public void setAllowDiscussion(boolean allowDiscussion) {
		_distribution.setAllowDiscussion(allowDiscussion);
	}

	/**
	* Returns the title of this distribution.
	*
	* @return the title of this distribution
	*/
	@Override
	public java.lang.String getTitle() {
		return _distribution.getTitle();
	}

	/**
	* Sets the title of this distribution.
	*
	* @param title the title of this distribution
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_distribution.setTitle(title);
	}

	@Override
	public boolean isNew() {
		return _distribution.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_distribution.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _distribution.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_distribution.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _distribution.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _distribution.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_distribution.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _distribution.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_distribution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_distribution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_distribution.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DistributionWrapper((Distribution)_distribution.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.Distribution distribution) {
		return _distribution.compareTo(distribution);
	}

	@Override
	public int hashCode() {
		return _distribution.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Distribution> toCacheModel() {
		return _distribution.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Distribution toEscapedModel() {
		return new DistributionWrapper(_distribution.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Distribution toUnescapedModel() {
		return new DistributionWrapper(_distribution.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _distribution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _distribution.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_distribution.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DistributionWrapper)) {
			return false;
		}

		DistributionWrapper distributionWrapper = (DistributionWrapper)obj;

		if (Validator.equals(_distribution, distributionWrapper._distribution)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Distribution getWrappedDistribution() {
		return _distribution;
	}

	@Override
	public Distribution getWrappedModel() {
		return _distribution;
	}

	@Override
	public void resetOriginalValues() {
		_distribution.resetOriginalValues();
	}

	private Distribution _distribution;
}