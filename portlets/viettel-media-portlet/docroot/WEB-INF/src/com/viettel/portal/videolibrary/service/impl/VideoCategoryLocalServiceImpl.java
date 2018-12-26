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

package com.viettel.portal.videolibrary.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.viettel.portal.videolibrary.model.VideoCategory;
import com.viettel.portal.videolibrary.service.base.VideoCategoryLocalServiceBaseImpl;
import com.viettel.portal.videolibrary.service.persistence.VideoCategoryUtil;

/**
 * The implementation of the video category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.videolibrary.service.VideoCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.viettel.portal.videolibrary.service.base.VideoCategoryLocalServiceBaseImpl
 * @see com.viettel.portal.videolibrary.service.VideoCategoryLocalServiceUtil
 */
public class VideoCategoryLocalServiceImpl
	extends VideoCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.videolibrary.service.VideoCategoryLocalServiceUtil} to access the video category local service.
	 */
	public List<VideoCategory> findAll() throws SystemException, PortalException{
		return VideoCategoryUtil.findAll();
	}
}