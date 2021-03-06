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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalFAQEntry}.
 * </p>
 *
 * @author chuchv
 * @see LegalFAQEntry
 * @generated
 */
public class LegalFAQEntryWrapper implements LegalFAQEntry,
	ModelWrapper<LegalFAQEntry> {
	public LegalFAQEntryWrapper(LegalFAQEntry legalFAQEntry) {
		_legalFAQEntry = legalFAQEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return LegalFAQEntry.class;
	}

	@Override
	public String getModelClassName() {
		return LegalFAQEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("categoryId", getCategoryId());
		attributes.put("citizenName", getCitizenName());
		attributes.put("citizenPhone", getCitizenPhone());
		attributes.put("citizenEmail", getCitizenEmail());
		attributes.put("askDate", getAskDate());
		attributes.put("askTitle", getAskTitle());
		attributes.put("askContent", getAskContent());
		attributes.put("answerDate", getAnswerDate());
		attributes.put("answerContent", getAnswerContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("publishDate", getPublishDate());
		attributes.put("viewCount", getViewCount());
		attributes.put("publishStatus", getPublishStatus());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String citizenName = (String)attributes.get("citizenName");

		if (citizenName != null) {
			setCitizenName(citizenName);
		}

		String citizenPhone = (String)attributes.get("citizenPhone");

		if (citizenPhone != null) {
			setCitizenPhone(citizenPhone);
		}

		String citizenEmail = (String)attributes.get("citizenEmail");

		if (citizenEmail != null) {
			setCitizenEmail(citizenEmail);
		}

		Date askDate = (Date)attributes.get("askDate");

		if (askDate != null) {
			setAskDate(askDate);
		}

		String askTitle = (String)attributes.get("askTitle");

		if (askTitle != null) {
			setAskTitle(askTitle);
		}

		String askContent = (String)attributes.get("askContent");

		if (askContent != null) {
			setAskContent(askContent);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}

		String answerContent = (String)attributes.get("answerContent");

		if (answerContent != null) {
			setAnswerContent(answerContent);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}

		Integer publishStatus = (Integer)attributes.get("publishStatus");

		if (publishStatus != null) {
			setPublishStatus(publishStatus);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this legal f a q entry.
	*
	* @return the primary key of this legal f a q entry
	*/
	@Override
	public long getPrimaryKey() {
		return _legalFAQEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal f a q entry.
	*
	* @param primaryKey the primary key of this legal f a q entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legalFAQEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entry ID of this legal f a q entry.
	*
	* @return the entry ID of this legal f a q entry
	*/
	@Override
	public long getEntryId() {
		return _legalFAQEntry.getEntryId();
	}

	/**
	* Sets the entry ID of this legal f a q entry.
	*
	* @param entryId the entry ID of this legal f a q entry
	*/
	@Override
	public void setEntryId(long entryId) {
		_legalFAQEntry.setEntryId(entryId);
	}

	/**
	* Returns the company ID of this legal f a q entry.
	*
	* @return the company ID of this legal f a q entry
	*/
	@Override
	public long getCompanyId() {
		return _legalFAQEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this legal f a q entry.
	*
	* @param companyId the company ID of this legal f a q entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_legalFAQEntry.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this legal f a q entry.
	*
	* @return the group ID of this legal f a q entry
	*/
	@Override
	public long getGroupId() {
		return _legalFAQEntry.getGroupId();
	}

	/**
	* Sets the group ID of this legal f a q entry.
	*
	* @param groupId the group ID of this legal f a q entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_legalFAQEntry.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this legal f a q entry.
	*
	* @return the user ID of this legal f a q entry
	*/
	@Override
	public long getUserId() {
		return _legalFAQEntry.getUserId();
	}

	/**
	* Sets the user ID of this legal f a q entry.
	*
	* @param userId the user ID of this legal f a q entry
	*/
	@Override
	public void setUserId(long userId) {
		_legalFAQEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legal f a q entry.
	*
	* @return the user uuid of this legal f a q entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalFAQEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this legal f a q entry.
	*
	* @param userUuid the user uuid of this legal f a q entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legalFAQEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this legal f a q entry.
	*
	* @return the user name of this legal f a q entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _legalFAQEntry.getUserName();
	}

	/**
	* Sets the user name of this legal f a q entry.
	*
	* @param userName the user name of this legal f a q entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_legalFAQEntry.setUserName(userName);
	}

	/**
	* Returns the category ID of this legal f a q entry.
	*
	* @return the category ID of this legal f a q entry
	*/
	@Override
	public long getCategoryId() {
		return _legalFAQEntry.getCategoryId();
	}

	/**
	* Sets the category ID of this legal f a q entry.
	*
	* @param categoryId the category ID of this legal f a q entry
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_legalFAQEntry.setCategoryId(categoryId);
	}

	/**
	* Returns the citizen name of this legal f a q entry.
	*
	* @return the citizen name of this legal f a q entry
	*/
	@Override
	public java.lang.String getCitizenName() {
		return _legalFAQEntry.getCitizenName();
	}

	/**
	* Sets the citizen name of this legal f a q entry.
	*
	* @param citizenName the citizen name of this legal f a q entry
	*/
	@Override
	public void setCitizenName(java.lang.String citizenName) {
		_legalFAQEntry.setCitizenName(citizenName);
	}

	/**
	* Returns the citizen phone of this legal f a q entry.
	*
	* @return the citizen phone of this legal f a q entry
	*/
	@Override
	public java.lang.String getCitizenPhone() {
		return _legalFAQEntry.getCitizenPhone();
	}

	/**
	* Sets the citizen phone of this legal f a q entry.
	*
	* @param citizenPhone the citizen phone of this legal f a q entry
	*/
	@Override
	public void setCitizenPhone(java.lang.String citizenPhone) {
		_legalFAQEntry.setCitizenPhone(citizenPhone);
	}

	/**
	* Returns the citizen email of this legal f a q entry.
	*
	* @return the citizen email of this legal f a q entry
	*/
	@Override
	public java.lang.String getCitizenEmail() {
		return _legalFAQEntry.getCitizenEmail();
	}

	/**
	* Sets the citizen email of this legal f a q entry.
	*
	* @param citizenEmail the citizen email of this legal f a q entry
	*/
	@Override
	public void setCitizenEmail(java.lang.String citizenEmail) {
		_legalFAQEntry.setCitizenEmail(citizenEmail);
	}

	/**
	* Returns the ask date of this legal f a q entry.
	*
	* @return the ask date of this legal f a q entry
	*/
	@Override
	public java.util.Date getAskDate() {
		return _legalFAQEntry.getAskDate();
	}

	/**
	* Sets the ask date of this legal f a q entry.
	*
	* @param askDate the ask date of this legal f a q entry
	*/
	@Override
	public void setAskDate(java.util.Date askDate) {
		_legalFAQEntry.setAskDate(askDate);
	}

	/**
	* Returns the ask title of this legal f a q entry.
	*
	* @return the ask title of this legal f a q entry
	*/
	@Override
	public java.lang.String getAskTitle() {
		return _legalFAQEntry.getAskTitle();
	}

	/**
	* Sets the ask title of this legal f a q entry.
	*
	* @param askTitle the ask title of this legal f a q entry
	*/
	@Override
	public void setAskTitle(java.lang.String askTitle) {
		_legalFAQEntry.setAskTitle(askTitle);
	}

	/**
	* Returns the ask content of this legal f a q entry.
	*
	* @return the ask content of this legal f a q entry
	*/
	@Override
	public java.lang.String getAskContent() {
		return _legalFAQEntry.getAskContent();
	}

	/**
	* Sets the ask content of this legal f a q entry.
	*
	* @param askContent the ask content of this legal f a q entry
	*/
	@Override
	public void setAskContent(java.lang.String askContent) {
		_legalFAQEntry.setAskContent(askContent);
	}

	/**
	* Returns the answer date of this legal f a q entry.
	*
	* @return the answer date of this legal f a q entry
	*/
	@Override
	public java.util.Date getAnswerDate() {
		return _legalFAQEntry.getAnswerDate();
	}

	/**
	* Sets the answer date of this legal f a q entry.
	*
	* @param answerDate the answer date of this legal f a q entry
	*/
	@Override
	public void setAnswerDate(java.util.Date answerDate) {
		_legalFAQEntry.setAnswerDate(answerDate);
	}

	/**
	* Returns the answer content of this legal f a q entry.
	*
	* @return the answer content of this legal f a q entry
	*/
	@Override
	public java.lang.String getAnswerContent() {
		return _legalFAQEntry.getAnswerContent();
	}

	/**
	* Sets the answer content of this legal f a q entry.
	*
	* @param answerContent the answer content of this legal f a q entry
	*/
	@Override
	public void setAnswerContent(java.lang.String answerContent) {
		_legalFAQEntry.setAnswerContent(answerContent);
	}

	/**
	* Returns the create date of this legal f a q entry.
	*
	* @return the create date of this legal f a q entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _legalFAQEntry.getCreateDate();
	}

	/**
	* Sets the create date of this legal f a q entry.
	*
	* @param createDate the create date of this legal f a q entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_legalFAQEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legal f a q entry.
	*
	* @return the modified date of this legal f a q entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legalFAQEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal f a q entry.
	*
	* @param modifiedDate the modified date of this legal f a q entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legalFAQEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the publish date of this legal f a q entry.
	*
	* @return the publish date of this legal f a q entry
	*/
	@Override
	public java.util.Date getPublishDate() {
		return _legalFAQEntry.getPublishDate();
	}

	/**
	* Sets the publish date of this legal f a q entry.
	*
	* @param publishDate the publish date of this legal f a q entry
	*/
	@Override
	public void setPublishDate(java.util.Date publishDate) {
		_legalFAQEntry.setPublishDate(publishDate);
	}

	/**
	* Returns the view count of this legal f a q entry.
	*
	* @return the view count of this legal f a q entry
	*/
	@Override
	public int getViewCount() {
		return _legalFAQEntry.getViewCount();
	}

	/**
	* Sets the view count of this legal f a q entry.
	*
	* @param viewCount the view count of this legal f a q entry
	*/
	@Override
	public void setViewCount(int viewCount) {
		_legalFAQEntry.setViewCount(viewCount);
	}

	/**
	* Returns the publish status of this legal f a q entry.
	*
	* @return the publish status of this legal f a q entry
	*/
	@Override
	public int getPublishStatus() {
		return _legalFAQEntry.getPublishStatus();
	}

	/**
	* Sets the publish status of this legal f a q entry.
	*
	* @param publishStatus the publish status of this legal f a q entry
	*/
	@Override
	public void setPublishStatus(int publishStatus) {
		_legalFAQEntry.setPublishStatus(publishStatus);
	}

	/**
	* Returns the status of this legal f a q entry.
	*
	* @return the status of this legal f a q entry
	*/
	@Override
	public int getStatus() {
		return _legalFAQEntry.getStatus();
	}

	/**
	* Sets the status of this legal f a q entry.
	*
	* @param status the status of this legal f a q entry
	*/
	@Override
	public void setStatus(int status) {
		_legalFAQEntry.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _legalFAQEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legalFAQEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legalFAQEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legalFAQEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legalFAQEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legalFAQEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legalFAQEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legalFAQEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legalFAQEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legalFAQEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legalFAQEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegalFAQEntryWrapper((LegalFAQEntry)_legalFAQEntry.clone());
	}

	@Override
	public int compareTo(
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry) {
		return _legalFAQEntry.compareTo(legalFAQEntry);
	}

	@Override
	public int hashCode() {
		return _legalFAQEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> toCacheModel() {
		return _legalFAQEntry.toCacheModel();
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry toEscapedModel() {
		return new LegalFAQEntryWrapper(_legalFAQEntry.toEscapedModel());
	}

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry toUnescapedModel() {
		return new LegalFAQEntryWrapper(_legalFAQEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legalFAQEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legalFAQEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalFAQEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalFAQEntryWrapper)) {
			return false;
		}

		LegalFAQEntryWrapper legalFAQEntryWrapper = (LegalFAQEntryWrapper)obj;

		if (Validator.equals(_legalFAQEntry, legalFAQEntryWrapper._legalFAQEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegalFAQEntry getWrappedLegalFAQEntry() {
		return _legalFAQEntry;
	}

	@Override
	public LegalFAQEntry getWrappedModel() {
		return _legalFAQEntry;
	}

	@Override
	public void resetOriginalValues() {
		_legalFAQEntry.resetOriginalValues();
	}

	private LegalFAQEntry _legalFAQEntry;
}