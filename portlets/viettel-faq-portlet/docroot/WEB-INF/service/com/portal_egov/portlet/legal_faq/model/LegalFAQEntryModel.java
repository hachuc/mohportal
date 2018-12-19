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
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LegalFAQEntry service. Represents a row in the &quot;LegalFAQEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryImpl}.
 * </p>
 *
 * @author chuchv
 * @see LegalFAQEntry
 * @see com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryImpl
 * @see com.portal_egov.portlet.legal_faq.model.impl.LegalFAQEntryModelImpl
 * @generated
 */
public interface LegalFAQEntryModel extends BaseModel<LegalFAQEntry>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a legal f a q entry model instance should use the {@link LegalFAQEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this legal f a q entry.
	 *
	 * @return the primary key of this legal f a q entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this legal f a q entry.
	 *
	 * @param primaryKey the primary key of this legal f a q entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the entry ID of this legal f a q entry.
	 *
	 * @return the entry ID of this legal f a q entry
	 */
	public long getEntryId();

	/**
	 * Sets the entry ID of this legal f a q entry.
	 *
	 * @param entryId the entry ID of this legal f a q entry
	 */
	public void setEntryId(long entryId);

	/**
	 * Returns the company ID of this legal f a q entry.
	 *
	 * @return the company ID of this legal f a q entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this legal f a q entry.
	 *
	 * @param companyId the company ID of this legal f a q entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this legal f a q entry.
	 *
	 * @return the group ID of this legal f a q entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this legal f a q entry.
	 *
	 * @param groupId the group ID of this legal f a q entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this legal f a q entry.
	 *
	 * @return the user ID of this legal f a q entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this legal f a q entry.
	 *
	 * @param userId the user ID of this legal f a q entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this legal f a q entry.
	 *
	 * @return the user uuid of this legal f a q entry
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this legal f a q entry.
	 *
	 * @param userUuid the user uuid of this legal f a q entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this legal f a q entry.
	 *
	 * @return the user name of this legal f a q entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this legal f a q entry.
	 *
	 * @param userName the user name of this legal f a q entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the category ID of this legal f a q entry.
	 *
	 * @return the category ID of this legal f a q entry
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this legal f a q entry.
	 *
	 * @param categoryId the category ID of this legal f a q entry
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the citizen name of this legal f a q entry.
	 *
	 * @return the citizen name of this legal f a q entry
	 */
	@AutoEscape
	public String getCitizenName();

	/**
	 * Sets the citizen name of this legal f a q entry.
	 *
	 * @param citizenName the citizen name of this legal f a q entry
	 */
	public void setCitizenName(String citizenName);

	/**
	 * Returns the citizen phone of this legal f a q entry.
	 *
	 * @return the citizen phone of this legal f a q entry
	 */
	@AutoEscape
	public String getCitizenPhone();

	/**
	 * Sets the citizen phone of this legal f a q entry.
	 *
	 * @param citizenPhone the citizen phone of this legal f a q entry
	 */
	public void setCitizenPhone(String citizenPhone);

	/**
	 * Returns the citizen email of this legal f a q entry.
	 *
	 * @return the citizen email of this legal f a q entry
	 */
	@AutoEscape
	public String getCitizenEmail();

	/**
	 * Sets the citizen email of this legal f a q entry.
	 *
	 * @param citizenEmail the citizen email of this legal f a q entry
	 */
	public void setCitizenEmail(String citizenEmail);

	/**
	 * Returns the ask date of this legal f a q entry.
	 *
	 * @return the ask date of this legal f a q entry
	 */
	public Date getAskDate();

	/**
	 * Sets the ask date of this legal f a q entry.
	 *
	 * @param askDate the ask date of this legal f a q entry
	 */
	public void setAskDate(Date askDate);

	/**
	 * Returns the ask title of this legal f a q entry.
	 *
	 * @return the ask title of this legal f a q entry
	 */
	@AutoEscape
	public String getAskTitle();

	/**
	 * Sets the ask title of this legal f a q entry.
	 *
	 * @param askTitle the ask title of this legal f a q entry
	 */
	public void setAskTitle(String askTitle);

	/**
	 * Returns the ask content of this legal f a q entry.
	 *
	 * @return the ask content of this legal f a q entry
	 */
	@AutoEscape
	public String getAskContent();

	/**
	 * Sets the ask content of this legal f a q entry.
	 *
	 * @param askContent the ask content of this legal f a q entry
	 */
	public void setAskContent(String askContent);

	/**
	 * Returns the answer date of this legal f a q entry.
	 *
	 * @return the answer date of this legal f a q entry
	 */
	public Date getAnswerDate();

	/**
	 * Sets the answer date of this legal f a q entry.
	 *
	 * @param answerDate the answer date of this legal f a q entry
	 */
	public void setAnswerDate(Date answerDate);

	/**
	 * Returns the answer content of this legal f a q entry.
	 *
	 * @return the answer content of this legal f a q entry
	 */
	@AutoEscape
	public String getAnswerContent();

	/**
	 * Sets the answer content of this legal f a q entry.
	 *
	 * @param answerContent the answer content of this legal f a q entry
	 */
	public void setAnswerContent(String answerContent);

	/**
	 * Returns the create date of this legal f a q entry.
	 *
	 * @return the create date of this legal f a q entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this legal f a q entry.
	 *
	 * @param createDate the create date of this legal f a q entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this legal f a q entry.
	 *
	 * @return the modified date of this legal f a q entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this legal f a q entry.
	 *
	 * @param modifiedDate the modified date of this legal f a q entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the publish date of this legal f a q entry.
	 *
	 * @return the publish date of this legal f a q entry
	 */
	public Date getPublishDate();

	/**
	 * Sets the publish date of this legal f a q entry.
	 *
	 * @param publishDate the publish date of this legal f a q entry
	 */
	public void setPublishDate(Date publishDate);

	/**
	 * Returns the view count of this legal f a q entry.
	 *
	 * @return the view count of this legal f a q entry
	 */
	public int getViewCount();

	/**
	 * Sets the view count of this legal f a q entry.
	 *
	 * @param viewCount the view count of this legal f a q entry
	 */
	public void setViewCount(int viewCount);

	/**
	 * Returns the publish status of this legal f a q entry.
	 *
	 * @return the publish status of this legal f a q entry
	 */
	public int getPublishStatus();

	/**
	 * Sets the publish status of this legal f a q entry.
	 *
	 * @param publishStatus the publish status of this legal f a q entry
	 */
	public void setPublishStatus(int publishStatus);

	/**
	 * Returns the status of this legal f a q entry.
	 *
	 * @return the status of this legal f a q entry
	 */
	public int getStatus();

	/**
	 * Sets the status of this legal f a q entry.
	 *
	 * @param status the status of this legal f a q entry
	 */
	public void setStatus(int status);

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
		com.portal_egov.portlet.legal_faq.model.LegalFAQEntry legalFAQEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.portal_egov.portlet.legal_faq.model.LegalFAQEntry> toCacheModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry toEscapedModel();

	@Override
	public com.portal_egov.portlet.legal_faq.model.LegalFAQEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}