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

package com.viettel.portal.magazine.archive.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.viettel.portal.magazine.archive.model.Content;
import com.viettel.portal.magazine.archive.service.base.ContentLocalServiceBaseImpl;

/**
 * The implementation of the content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.magazine.archive.service.ContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author namtv
 * @see com.viettel.portal.magazine.archive.service.base.ContentLocalServiceBaseImpl
 * @see com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil
 */
public class ContentLocalServiceImpl extends ContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil} to access the content local service.
	 */
	public List<Content> GetAllContentByMagazineId(int magazineId, int start, int end) throws SystemException, PortalException{
		return contentPersistence.findByMagazine(magazineId, start, end);
	}
	public int CountAll(int magazineId) throws SystemException, PortalException{
		return contentPersistence.countByMagazine(magazineId);
	}
}