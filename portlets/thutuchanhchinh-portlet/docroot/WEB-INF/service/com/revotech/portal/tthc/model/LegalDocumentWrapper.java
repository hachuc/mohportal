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

package com.revotech.portal.tthc.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegalDocument}.
 * </p>
 *
 * @author hieptran
 * @see LegalDocument
 * @generated
 */
public class LegalDocumentWrapper implements LegalDocument,
	ModelWrapper<LegalDocument> {
	public LegalDocumentWrapper(LegalDocument legalDocument) {
		_legalDocument = legalDocument;
	}

	@Override
	public Class<?> getModelClass() {
		return LegalDocument.class;
	}

	@Override
	public String getModelClassName() {
		return LegalDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ldId", getLdId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ldCode", getLdCode());
		attributes.put("ldTitle", getLdTitle());
		attributes.put("ldLink", getLdLink());
		attributes.put("ldLevel3Link", getLdLevel3Link());
		attributes.put("ldSubcontent", getLdSubcontent());
		attributes.put("isActive", getIsActive());
		attributes.put("idLinhvuc", getIdLinhvuc());
		attributes.put("idCoquanbanhanh", getIdCoquanbanhanh());
		attributes.put("ldDonvithuchien", getLdDonvithuchien());
		attributes.put("ldLevel", getLdLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ldId = (Long)attributes.get("ldId");

		if (ldId != null) {
			setLdId(ldId);
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

		String ldCode = (String)attributes.get("ldCode");

		if (ldCode != null) {
			setLdCode(ldCode);
		}

		String ldTitle = (String)attributes.get("ldTitle");

		if (ldTitle != null) {
			setLdTitle(ldTitle);
		}

		String ldLink = (String)attributes.get("ldLink");

		if (ldLink != null) {
			setLdLink(ldLink);
		}

		String ldLevel3Link = (String)attributes.get("ldLevel3Link");

		if (ldLevel3Link != null) {
			setLdLevel3Link(ldLevel3Link);
		}

		String ldSubcontent = (String)attributes.get("ldSubcontent");

		if (ldSubcontent != null) {
			setLdSubcontent(ldSubcontent);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Long idLinhvuc = (Long)attributes.get("idLinhvuc");

		if (idLinhvuc != null) {
			setIdLinhvuc(idLinhvuc);
		}

		Long idCoquanbanhanh = (Long)attributes.get("idCoquanbanhanh");

		if (idCoquanbanhanh != null) {
			setIdCoquanbanhanh(idCoquanbanhanh);
		}

		String ldDonvithuchien = (String)attributes.get("ldDonvithuchien");

		if (ldDonvithuchien != null) {
			setLdDonvithuchien(ldDonvithuchien);
		}

		Integer ldLevel = (Integer)attributes.get("ldLevel");

		if (ldLevel != null) {
			setLdLevel(ldLevel);
		}
	}

	/**
	* Returns the primary key of this legal document.
	*
	* @return the primary key of this legal document
	*/
	@Override
	public long getPrimaryKey() {
		return _legalDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal document.
	*
	* @param primaryKey the primary key of this legal document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legalDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ld ID of this legal document.
	*
	* @return the ld ID of this legal document
	*/
	@Override
	public long getLdId() {
		return _legalDocument.getLdId();
	}

	/**
	* Sets the ld ID of this legal document.
	*
	* @param ldId the ld ID of this legal document
	*/
	@Override
	public void setLdId(long ldId) {
		_legalDocument.setLdId(ldId);
	}

	/**
	* Returns the group ID of this legal document.
	*
	* @return the group ID of this legal document
	*/
	@Override
	public long getGroupId() {
		return _legalDocument.getGroupId();
	}

	/**
	* Sets the group ID of this legal document.
	*
	* @param groupId the group ID of this legal document
	*/
	@Override
	public void setGroupId(long groupId) {
		_legalDocument.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this legal document.
	*
	* @return the company ID of this legal document
	*/
	@Override
	public long getCompanyId() {
		return _legalDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this legal document.
	*
	* @param companyId the company ID of this legal document
	*/
	@Override
	public void setCompanyId(long companyId) {
		_legalDocument.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this legal document.
	*
	* @return the user ID of this legal document
	*/
	@Override
	public long getUserId() {
		return _legalDocument.getUserId();
	}

	/**
	* Sets the user ID of this legal document.
	*
	* @param userId the user ID of this legal document
	*/
	@Override
	public void setUserId(long userId) {
		_legalDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this legal document.
	*
	* @return the user uuid of this legal document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _legalDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this legal document.
	*
	* @param userUuid the user uuid of this legal document
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_legalDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this legal document.
	*
	* @return the user name of this legal document
	*/
	@Override
	public java.lang.String getUserName() {
		return _legalDocument.getUserName();
	}

	/**
	* Sets the user name of this legal document.
	*
	* @param userName the user name of this legal document
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_legalDocument.setUserName(userName);
	}

	/**
	* Returns the create date of this legal document.
	*
	* @return the create date of this legal document
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _legalDocument.getCreateDate();
	}

	/**
	* Sets the create date of this legal document.
	*
	* @param createDate the create date of this legal document
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_legalDocument.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this legal document.
	*
	* @return the modified date of this legal document
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legalDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal document.
	*
	* @param modifiedDate the modified date of this legal document
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_legalDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the ld code of this legal document.
	*
	* @return the ld code of this legal document
	*/
	@Override
	public java.lang.String getLdCode() {
		return _legalDocument.getLdCode();
	}

	/**
	* Sets the ld code of this legal document.
	*
	* @param ldCode the ld code of this legal document
	*/
	@Override
	public void setLdCode(java.lang.String ldCode) {
		_legalDocument.setLdCode(ldCode);
	}

	/**
	* Returns the ld title of this legal document.
	*
	* @return the ld title of this legal document
	*/
	@Override
	public java.lang.String getLdTitle() {
		return _legalDocument.getLdTitle();
	}

	/**
	* Sets the ld title of this legal document.
	*
	* @param ldTitle the ld title of this legal document
	*/
	@Override
	public void setLdTitle(java.lang.String ldTitle) {
		_legalDocument.setLdTitle(ldTitle);
	}

	/**
	* Returns the ld link of this legal document.
	*
	* @return the ld link of this legal document
	*/
	@Override
	public java.lang.String getLdLink() {
		return _legalDocument.getLdLink();
	}

	/**
	* Sets the ld link of this legal document.
	*
	* @param ldLink the ld link of this legal document
	*/
	@Override
	public void setLdLink(java.lang.String ldLink) {
		_legalDocument.setLdLink(ldLink);
	}

	/**
	* Returns the ld level3 link of this legal document.
	*
	* @return the ld level3 link of this legal document
	*/
	@Override
	public java.lang.String getLdLevel3Link() {
		return _legalDocument.getLdLevel3Link();
	}

	/**
	* Sets the ld level3 link of this legal document.
	*
	* @param ldLevel3Link the ld level3 link of this legal document
	*/
	@Override
	public void setLdLevel3Link(java.lang.String ldLevel3Link) {
		_legalDocument.setLdLevel3Link(ldLevel3Link);
	}

	/**
	* Returns the ld subcontent of this legal document.
	*
	* @return the ld subcontent of this legal document
	*/
	@Override
	public java.lang.String getLdSubcontent() {
		return _legalDocument.getLdSubcontent();
	}

	/**
	* Sets the ld subcontent of this legal document.
	*
	* @param ldSubcontent the ld subcontent of this legal document
	*/
	@Override
	public void setLdSubcontent(java.lang.String ldSubcontent) {
		_legalDocument.setLdSubcontent(ldSubcontent);
	}

	/**
	* Returns the is active of this legal document.
	*
	* @return the is active of this legal document
	*/
	@Override
	public boolean getIsActive() {
		return _legalDocument.getIsActive();
	}

	/**
	* Returns <code>true</code> if this legal document is is active.
	*
	* @return <code>true</code> if this legal document is is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsActive() {
		return _legalDocument.isIsActive();
	}

	/**
	* Sets whether this legal document is is active.
	*
	* @param isActive the is active of this legal document
	*/
	@Override
	public void setIsActive(boolean isActive) {
		_legalDocument.setIsActive(isActive);
	}

	/**
	* Returns the id linhvuc of this legal document.
	*
	* @return the id linhvuc of this legal document
	*/
	@Override
	public long getIdLinhvuc() {
		return _legalDocument.getIdLinhvuc();
	}

	/**
	* Sets the id linhvuc of this legal document.
	*
	* @param idLinhvuc the id linhvuc of this legal document
	*/
	@Override
	public void setIdLinhvuc(long idLinhvuc) {
		_legalDocument.setIdLinhvuc(idLinhvuc);
	}

	/**
	* Returns the id coquanbanhanh of this legal document.
	*
	* @return the id coquanbanhanh of this legal document
	*/
	@Override
	public long getIdCoquanbanhanh() {
		return _legalDocument.getIdCoquanbanhanh();
	}

	/**
	* Sets the id coquanbanhanh of this legal document.
	*
	* @param idCoquanbanhanh the id coquanbanhanh of this legal document
	*/
	@Override
	public void setIdCoquanbanhanh(long idCoquanbanhanh) {
		_legalDocument.setIdCoquanbanhanh(idCoquanbanhanh);
	}

	/**
	* Returns the ld donvithuchien of this legal document.
	*
	* @return the ld donvithuchien of this legal document
	*/
	@Override
	public java.lang.String getLdDonvithuchien() {
		return _legalDocument.getLdDonvithuchien();
	}

	/**
	* Sets the ld donvithuchien of this legal document.
	*
	* @param ldDonvithuchien the ld donvithuchien of this legal document
	*/
	@Override
	public void setLdDonvithuchien(java.lang.String ldDonvithuchien) {
		_legalDocument.setLdDonvithuchien(ldDonvithuchien);
	}

	/**
	* Returns the ld level of this legal document.
	*
	* @return the ld level of this legal document
	*/
	@Override
	public int getLdLevel() {
		return _legalDocument.getLdLevel();
	}

	/**
	* Sets the ld level of this legal document.
	*
	* @param ldLevel the ld level of this legal document
	*/
	@Override
	public void setLdLevel(int ldLevel) {
		_legalDocument.setLdLevel(ldLevel);
	}

	@Override
	public boolean isNew() {
		return _legalDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legalDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legalDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legalDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legalDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legalDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legalDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legalDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legalDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legalDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legalDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegalDocumentWrapper((LegalDocument)_legalDocument.clone());
	}

	@Override
	public int compareTo(
		com.revotech.portal.tthc.model.LegalDocument legalDocument) {
		return _legalDocument.compareTo(legalDocument);
	}

	@Override
	public int hashCode() {
		return _legalDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.revotech.portal.tthc.model.LegalDocument> toCacheModel() {
		return _legalDocument.toCacheModel();
	}

	@Override
	public com.revotech.portal.tthc.model.LegalDocument toEscapedModel() {
		return new LegalDocumentWrapper(_legalDocument.toEscapedModel());
	}

	@Override
	public com.revotech.portal.tthc.model.LegalDocument toUnescapedModel() {
		return new LegalDocumentWrapper(_legalDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legalDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legalDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legalDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegalDocumentWrapper)) {
			return false;
		}

		LegalDocumentWrapper legalDocumentWrapper = (LegalDocumentWrapper)obj;

		if (Validator.equals(_legalDocument, legalDocumentWrapper._legalDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegalDocument getWrappedLegalDocument() {
		return _legalDocument;
	}

	@Override
	public LegalDocument getWrappedModel() {
		return _legalDocument;
	}

	@Override
	public void resetOriginalValues() {
		_legalDocument.resetOriginalValues();
	}

	private LegalDocument _legalDocument;
}