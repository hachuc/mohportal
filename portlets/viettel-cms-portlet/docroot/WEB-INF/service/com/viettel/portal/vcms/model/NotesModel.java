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

import com.viettel.portal.vcms.service.persistence.NotesPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Notes service. Represents a row in the &quot;vcms_Notes&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.vcms.model.impl.NotesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.vcms.model.impl.NotesImpl}.
 * </p>
 *
 * @author chuchv
 * @see Notes
 * @see com.viettel.portal.vcms.model.impl.NotesImpl
 * @see com.viettel.portal.vcms.model.impl.NotesModelImpl
 * @generated
 */
public interface NotesModel extends BaseModel<Notes>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notes model instance should use the {@link Notes} interface instead.
	 */

	/**
	 * Returns the primary key of this notes.
	 *
	 * @return the primary key of this notes
	 */
	public NotesPK getPrimaryKey();

	/**
	 * Sets the primary key of this notes.
	 *
	 * @param primaryKey the primary key of this notes
	 */
	public void setPrimaryKey(NotesPK primaryKey);

	/**
	 * Returns the content i d of this notes.
	 *
	 * @return the content i d of this notes
	 */
	public long getContentID();

	/**
	 * Sets the content i d of this notes.
	 *
	 * @param ContentID the content i d of this notes
	 */
	public void setContentID(long ContentID);

	/**
	 * Returns the version of this notes.
	 *
	 * @return the version of this notes
	 */
	public int getVersion();

	/**
	 * Sets the version of this notes.
	 *
	 * @param Version the version of this notes
	 */
	public void setVersion(int Version);

	/**
	 * Returns the group ID of this notes.
	 *
	 * @return the group ID of this notes
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this notes.
	 *
	 * @param groupId the group ID of this notes
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this notes.
	 *
	 * @return the company ID of this notes
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this notes.
	 *
	 * @param companyId the company ID of this notes
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this notes.
	 *
	 * @return the user ID of this notes
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this notes.
	 *
	 * @param userId the user ID of this notes
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this notes.
	 *
	 * @return the user uuid of this notes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this notes.
	 *
	 * @param userUuid the user uuid of this notes
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this notes.
	 *
	 * @return the user name of this notes
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this notes.
	 *
	 * @param userName the user name of this notes
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this notes.
	 *
	 * @return the create date of this notes
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this notes.
	 *
	 * @param createDate the create date of this notes
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this notes.
	 *
	 * @return the modified date of this notes
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this notes.
	 *
	 * @param modifiedDate the modified date of this notes
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the content of this notes.
	 *
	 * @return the content of this notes
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this notes.
	 *
	 * @param Content the content of this notes
	 */
	public void setContent(String Content);

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
	public int compareTo(com.viettel.portal.vcms.model.Notes notes);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.vcms.model.Notes> toCacheModel();

	@Override
	public com.viettel.portal.vcms.model.Notes toEscapedModel();

	@Override
	public com.viettel.portal.vcms.model.Notes toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}