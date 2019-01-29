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

package com.revotech.portal.videolibrary.model;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the VLRelateVideo service. Represents a row in the &quot;portal_relatevideo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.revotech.portal.videolibrary.model.impl.VLRelateVideoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.revotech.portal.videolibrary.model.impl.VLRelateVideoImpl}.
 * </p>
 *
 * @author ChucHV
 * @see VLRelateVideo
 * @see com.revotech.portal.videolibrary.model.impl.VLRelateVideoImpl
 * @see com.revotech.portal.videolibrary.model.impl.VLRelateVideoModelImpl
 * @generated
 */
public interface VLRelateVideoModel extends BaseModel<VLRelateVideo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a v l relate video model instance should use the {@link VLRelateVideo} interface instead.
	 */

	/**
	 * Returns the primary key of this v l relate video.
	 *
	 * @return the primary key of this v l relate video
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this v l relate video.
	 *
	 * @param primaryKey the primary key of this v l relate video
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this v l relate video.
	 *
	 * @return the ID of this v l relate video
	 */
	public long getId();

	/**
	 * Sets the ID of this v l relate video.
	 *
	 * @param id the ID of this v l relate video
	 */
	public void setId(long id);

	/**
	 * Returns the video ID of this v l relate video.
	 *
	 * @return the video ID of this v l relate video
	 */
	public long getVideoId();

	/**
	 * Sets the video ID of this v l relate video.
	 *
	 * @param videoId the video ID of this v l relate video
	 */
	public void setVideoId(long videoId);

	/**
	 * Returns the relate ID of this v l relate video.
	 *
	 * @return the relate ID of this v l relate video
	 */
	public long getRelateId();

	/**
	 * Sets the relate ID of this v l relate video.
	 *
	 * @param relateId the relate ID of this v l relate video
	 */
	public void setRelateId(long relateId);

	/**
	 * Returns the group ID of this v l relate video.
	 *
	 * @return the group ID of this v l relate video
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this v l relate video.
	 *
	 * @param groupId the group ID of this v l relate video
	 */
	public void setGroupId(long groupId);

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
		com.revotech.portal.videolibrary.model.VLRelateVideo vlRelateVideo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.revotech.portal.videolibrary.model.VLRelateVideo> toCacheModel();

	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo toEscapedModel();

	@Override
	public com.revotech.portal.videolibrary.model.VLRelateVideo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}