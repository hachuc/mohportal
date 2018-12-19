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
 * This class is a wrapper for {@link ContentProfit}.
 * </p>
 *
 * @author chuchv
 * @see ContentProfit
 * @generated
 */
public class ContentProfitWrapper implements ContentProfit,
	ModelWrapper<ContentProfit> {
	public ContentProfitWrapper(ContentProfit contentProfit) {
		_contentProfit = contentProfit;
	}

	@Override
	public Class<?> getModelClass() {
		return ContentProfit.class;
	}

	@Override
	public String getModelClassName() {
		return ContentProfit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentId", getContentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("distributedDate", getDistributedDate());
		attributes.put("contentTypeID", getContentTypeID());
		attributes.put("headline", getHeadline());
		attributes.put("cost", getCost());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
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

		Date distributedDate = (Date)attributes.get("distributedDate");

		if (distributedDate != null) {
			setDistributedDate(distributedDate);
		}

		Integer contentTypeID = (Integer)attributes.get("contentTypeID");

		if (contentTypeID != null) {
			setContentTypeID(contentTypeID);
		}

		String headline = (String)attributes.get("headline");

		if (headline != null) {
			setHeadline(headline);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this content profit.
	*
	* @return the primary key of this content profit
	*/
	@Override
	public long getPrimaryKey() {
		return _contentProfit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this content profit.
	*
	* @param primaryKey the primary key of this content profit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_contentProfit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content ID of this content profit.
	*
	* @return the content ID of this content profit
	*/
	@Override
	public long getContentId() {
		return _contentProfit.getContentId();
	}

	/**
	* Sets the content ID of this content profit.
	*
	* @param contentId the content ID of this content profit
	*/
	@Override
	public void setContentId(long contentId) {
		_contentProfit.setContentId(contentId);
	}

	/**
	* Returns the group ID of this content profit.
	*
	* @return the group ID of this content profit
	*/
	@Override
	public long getGroupId() {
		return _contentProfit.getGroupId();
	}

	/**
	* Sets the group ID of this content profit.
	*
	* @param groupId the group ID of this content profit
	*/
	@Override
	public void setGroupId(long groupId) {
		_contentProfit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this content profit.
	*
	* @return the company ID of this content profit
	*/
	@Override
	public long getCompanyId() {
		return _contentProfit.getCompanyId();
	}

	/**
	* Sets the company ID of this content profit.
	*
	* @param companyId the company ID of this content profit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_contentProfit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this content profit.
	*
	* @return the user ID of this content profit
	*/
	@Override
	public long getUserId() {
		return _contentProfit.getUserId();
	}

	/**
	* Sets the user ID of this content profit.
	*
	* @param userId the user ID of this content profit
	*/
	@Override
	public void setUserId(long userId) {
		_contentProfit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this content profit.
	*
	* @return the user uuid of this content profit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contentProfit.getUserUuid();
	}

	/**
	* Sets the user uuid of this content profit.
	*
	* @param userUuid the user uuid of this content profit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_contentProfit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this content profit.
	*
	* @return the user name of this content profit
	*/
	@Override
	public java.lang.String getUserName() {
		return _contentProfit.getUserName();
	}

	/**
	* Sets the user name of this content profit.
	*
	* @param userName the user name of this content profit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_contentProfit.setUserName(userName);
	}

	/**
	* Returns the create date of this content profit.
	*
	* @return the create date of this content profit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _contentProfit.getCreateDate();
	}

	/**
	* Sets the create date of this content profit.
	*
	* @param createDate the create date of this content profit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_contentProfit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this content profit.
	*
	* @return the modified date of this content profit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _contentProfit.getModifiedDate();
	}

	/**
	* Sets the modified date of this content profit.
	*
	* @param modifiedDate the modified date of this content profit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_contentProfit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the distributed date of this content profit.
	*
	* @return the distributed date of this content profit
	*/
	@Override
	public java.util.Date getDistributedDate() {
		return _contentProfit.getDistributedDate();
	}

	/**
	* Sets the distributed date of this content profit.
	*
	* @param distributedDate the distributed date of this content profit
	*/
	@Override
	public void setDistributedDate(java.util.Date distributedDate) {
		_contentProfit.setDistributedDate(distributedDate);
	}

	/**
	* Returns the content type i d of this content profit.
	*
	* @return the content type i d of this content profit
	*/
	@Override
	public int getContentTypeID() {
		return _contentProfit.getContentTypeID();
	}

	/**
	* Sets the content type i d of this content profit.
	*
	* @param contentTypeID the content type i d of this content profit
	*/
	@Override
	public void setContentTypeID(int contentTypeID) {
		_contentProfit.setContentTypeID(contentTypeID);
	}

	/**
	* Returns the headline of this content profit.
	*
	* @return the headline of this content profit
	*/
	@Override
	public java.lang.String getHeadline() {
		return _contentProfit.getHeadline();
	}

	/**
	* Sets the headline of this content profit.
	*
	* @param headline the headline of this content profit
	*/
	@Override
	public void setHeadline(java.lang.String headline) {
		_contentProfit.setHeadline(headline);
	}

	/**
	* Returns the cost of this content profit.
	*
	* @return the cost of this content profit
	*/
	@Override
	public double getCost() {
		return _contentProfit.getCost();
	}

	/**
	* Sets the cost of this content profit.
	*
	* @param cost the cost of this content profit
	*/
	@Override
	public void setCost(double cost) {
		_contentProfit.setCost(cost);
	}

	/**
	* Returns the status of this content profit.
	*
	* @return the status of this content profit
	*/
	@Override
	public int getStatus() {
		return _contentProfit.getStatus();
	}

	/**
	* Sets the status of this content profit.
	*
	* @param status the status of this content profit
	*/
	@Override
	public void setStatus(int status) {
		_contentProfit.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _contentProfit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contentProfit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contentProfit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contentProfit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contentProfit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contentProfit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contentProfit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contentProfit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contentProfit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contentProfit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contentProfit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContentProfitWrapper((ContentProfit)_contentProfit.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.ContentProfit contentProfit) {
		return _contentProfit.compareTo(contentProfit);
	}

	@Override
	public int hashCode() {
		return _contentProfit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.ContentProfit> toCacheModel() {
		return _contentProfit.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.ContentProfit toEscapedModel() {
		return new ContentProfitWrapper(_contentProfit.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.ContentProfit toUnescapedModel() {
		return new ContentProfitWrapper(_contentProfit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contentProfit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contentProfit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contentProfit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContentProfitWrapper)) {
			return false;
		}

		ContentProfitWrapper contentProfitWrapper = (ContentProfitWrapper)obj;

		if (Validator.equals(_contentProfit, contentProfitWrapper._contentProfit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ContentProfit getWrappedContentProfit() {
		return _contentProfit;
	}

	@Override
	public ContentProfit getWrappedModel() {
		return _contentProfit;
	}

	@Override
	public void resetOriginalValues() {
		_contentProfit.resetOriginalValues();
	}

	private ContentProfit _contentProfit;
}