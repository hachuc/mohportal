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

package com.revotech.portal.videolibrary.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.revotech.portal.videolibrary.model.VideoCategory;
import com.revotech.portal.videolibrary.service.VideoCategoryLocalServiceUtil;

/**
 * The extended model base implementation for the VideoCategory service. Represents a row in the &quot;VideoCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoCategoryImpl}.
 * </p>
 *
 * @author ChucHV
 * @see VideoCategoryImpl
 * @see com.revotech.portal.videolibrary.model.VideoCategory
 * @generated
 */
public abstract class VideoCategoryBaseImpl extends VideoCategoryModelImpl
	implements VideoCategory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video category model instance should use the {@link VideoCategory} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoCategoryLocalServiceUtil.addVideoCategory(this);
		}
		else {
			VideoCategoryLocalServiceUtil.updateVideoCategory(this);
		}
	}
}