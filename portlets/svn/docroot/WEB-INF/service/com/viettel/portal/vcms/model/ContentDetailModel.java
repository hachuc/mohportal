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
 * The base model interface for the ContentDetail service. Represents a row in the &quot;vcms_Content_Detail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.vcms.model.impl.ContentDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.vcms.model.impl.ContentDetailImpl}.
 * </p>
 *
 * @author chuchv
 * @see ContentDetail
 * @see com.viettel.portal.vcms.model.impl.ContentDetailImpl
 * @see com.viettel.portal.vcms.model.impl.ContentDetailModelImpl
 * @generated
 */
public interface ContentDetailModel extends BaseModel<ContentDetail>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a content detail model instance should use the {@link ContentDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this content detail.
	 *
	 * @return the primary key of this content detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this content detail.
	 *
	 * @param primaryKey the primary key of this content detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the auto ID of this content detail.
	 *
	 * @return the auto ID of this content detail
	 */
	public long getAutoId();

	/**
	 * Sets the auto ID of this content detail.
	 *
	 * @param autoId the auto ID of this content detail
	 */
	public void setAutoId(long autoId);

	/**
	 * Returns the content ID of this content detail.
	 *
	 * @return the content ID of this content detail
	 */
	public long getContentId();

	/**
	 * Sets the content ID of this content detail.
	 *
	 * @param contentId the content ID of this content detail
	 */
	public void setContentId(long contentId);

	/**
	 * Returns the group ID of this content detail.
	 *
	 * @return the group ID of this content detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this content detail.
	 *
	 * @param groupId the group ID of this content detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this content detail.
	 *
	 * @return the company ID of this content detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this content detail.
	 *
	 * @param companyId the company ID of this content detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this content detail.
	 *
	 * @return the user ID of this content detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this content detail.
	 *
	 * @param userId the user ID of this content detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this content detail.
	 *
	 * @return the user uuid of this content detail
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this content detail.
	 *
	 * @param userUuid the user uuid of this content detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this content detail.
	 *
	 * @return the user name of this content detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this content detail.
	 *
	 * @param userName the user name of this content detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this content detail.
	 *
	 * @return the create date of this content detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this content detail.
	 *
	 * @param createDate the create date of this content detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this content detail.
	 *
	 * @return the modified date of this content detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this content detail.
	 *
	 * @param modifiedDate the modified date of this content detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the version of this content detail.
	 *
	 * @return the version of this content detail
	 */
	public int getVersion();

	/**
	 * Sets the version of this content detail.
	 *
	 * @param version the version of this content detail
	 */
	public void setVersion(int version);

	/**
	 * Returns the sub title of this content detail.
	 *
	 * @return the sub title of this content detail
	 */
	@AutoEscape
	public String getSubTitle();

	/**
	 * Sets the sub title of this content detail.
	 *
	 * @param subTitle the sub title of this content detail
	 */
	public void setSubTitle(String subTitle);

	/**
	 * Returns the title of this content detail.
	 *
	 * @return the title of this content detail
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this content detail.
	 *
	 * @param title the title of this content detail
	 */
	public void setTitle(String title);

	/**
	 * Returns the summary of this content detail.
	 *
	 * @return the summary of this content detail
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this content detail.
	 *
	 * @param summary the summary of this content detail
	 */
	public void setSummary(String summary);

	/**
	 * Returns the sub content of this content detail.
	 *
	 * @return the sub content of this content detail
	 */
	@AutoEscape
	public String getSubContent();

	/**
	 * Sets the sub content of this content detail.
	 *
	 * @param subContent the sub content of this content detail
	 */
	public void setSubContent(String subContent);

	/**
	 * Returns the content of this content detail.
	 *
	 * @return the content of this content detail
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this content detail.
	 *
	 * @param content the content of this content detail
	 */
	public void setContent(String content);

	/**
	 * Returns the small image ID of this content detail.
	 *
	 * @return the small image ID of this content detail
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image ID of this content detail.
	 *
	 * @param smallImageId the small image ID of this content detail
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Returns the small image url of this content detail.
	 *
	 * @return the small image url of this content detail
	 */
	@AutoEscape
	public String getSmallImageUrl();

	/**
	 * Sets the small image url of this content detail.
	 *
	 * @param smallImageUrl the small image url of this content detail
	 */
	public void setSmallImageUrl(String smallImageUrl);

	/**
	 * Returns the category ID of this content detail.
	 *
	 * @return the category ID of this content detail
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this content detail.
	 *
	 * @param categoryId the category ID of this content detail
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the status of this content detail.
	 *
	 * @return the status of this content detail
	 */
	public int getStatus();

	/**
	 * Sets the status of this content detail.
	 *
	 * @param status the status of this content detail
	 */
	public void setStatus(int status);

	/**
	 * Returns the news type of this content detail.
	 *
	 * @return the news type of this content detail
	 */
	public int getNewsType();

	/**
	 * Sets the news type of this content detail.
	 *
	 * @param newsType the news type of this content detail
	 */
	public void setNewsType(int newsType);

	/**
	 * Returns the image url of this content detail.
	 *
	 * @return the image url of this content detail
	 */
	@AutoEscape
	public String getImageUrl();

	/**
	 * Sets the image url of this content detail.
	 *
	 * @param imageUrl the image url of this content detail
	 */
	public void setImageUrl(String imageUrl);

	/**
	 * Returns the is legal content of this content detail.
	 *
	 * @return the is legal content of this content detail
	 */
	public boolean getIsLegalContent();

	/**
	 * Returns <code>true</code> if this content detail is is legal content.
	 *
	 * @return <code>true</code> if this content detail is is legal content; <code>false</code> otherwise
	 */
	public boolean isIsLegalContent();

	/**
	 * Sets whether this content detail is is legal content.
	 *
	 * @param isLegalContent the is legal content of this content detail
	 */
	public void setIsLegalContent(boolean isLegalContent);

	/**
	 * Returns the image caption of this content detail.
	 *
	 * @return the image caption of this content detail
	 */
	@AutoEscape
	public String getImageCaption();

	/**
	 * Sets the image caption of this content detail.
	 *
	 * @param imageCaption the image caption of this content detail
	 */
	public void setImageCaption(String imageCaption);

	/**
	 * Returns the image position of this content detail.
	 *
	 * @return the image position of this content detail
	 */
	public int getImagePosition();

	/**
	 * Sets the image position of this content detail.
	 *
	 * @param imagePosition the image position of this content detail
	 */
	public void setImagePosition(int imagePosition);

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
		com.viettel.portal.vcms.model.ContentDetail contentDetail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.vcms.model.ContentDetail> toCacheModel();

	@Override
	public com.viettel.portal.vcms.model.ContentDetail toEscapedModel();

	@Override
	public com.viettel.portal.vcms.model.ContentDetail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}