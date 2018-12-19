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

package com.viettel.portal.magazine.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.magazine.model.MagazineContent;
import com.viettel.portal.magazine.model.MagazineZone;
import com.viettel.portal.magazine.service.base.MagazineContentLocalServiceBaseImpl;
import com.viettel.portal.magazine.service.persistence.MagazineContentFinderUtil;

/**
 * The implementation of the magazine content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.viettel.portal.magazine.service.MagazineContentLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author namtv
 * @see com.viettel.portal.magazine.service.base.MagazineContentLocalServiceBaseImpl
 * @see com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil
 */
public class MagazineContentLocalServiceImpl extends
		MagazineContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.viettel.portal.magazine.service.MagazineContentLocalServiceUtil} to
	 * access the magazine content local service.
	 */

	public List<MagazineContent> GetByMagazineAndZone(int magazineId, int zoneId)
			throws SystemException, PortalException {
		return magazineContentPersistence.findByMagazineAndZone(magazineId,
				zoneId);
	}

	public List<MagazineContent> getOlderContents(int mcContent, int zoneId,
			int magazineId, int sortOrder) throws SystemException, PortalException {
		return MagazineContentFinderUtil.getOlderContent(mcContent, magazineId, zoneId, sortOrder);
	}
	
	public List<MagazineContent> getNewerContents(int mcContent, int zoneId,
			int magazineId, int sortOrder) throws SystemException, PortalException {
		return MagazineContentFinderUtil.getNewerContent(mcContent, magazineId, zoneId, sortOrder);
	}
	
	public List<MagazineContent> findByMagazineID(int magazineId,int start,int end) throws SystemException, PortalException{
		return magazineContentPersistence.findByMagazineID(magazineId, start, end);
	}
	
	public int countByMagazineID(int magazineId) throws SystemException, PortalException{
		return magazineContentPersistence.countByMagazineID(magazineId);
	}
	
	public int countByMagazineZoneID(int magazineZoneId) throws SystemException, PortalException{
		return magazineContentPersistence.countByMagazineZoneID(magazineZoneId);
	}
	
	public List<MagazineContent> findByMagazineAndZone(int magazineId,int magazineZoneId,int start,int end) throws SystemException, PortalException{
		return magazineContentPersistence.findByMagazineAndZone(magazineId, magazineZoneId, start, end);
	}
	
	public int countByMagazineAndZone(int magazineId,int magazineZoneId) throws SystemException, PortalException{
		return magazineContentPersistence.countByMagazineAndZone(magazineId, magazineZoneId);
	}
	
	public MagazineContent updateMagazineContent(int id,long groupId,long userId,String userFullname, int magazineID, int magazineZoneID, String name, String body,String author,String jobtitle,int sortOrder,ServiceContext serviceContext) throws SystemException, PortalException {
		//Date now = new Date();
		MagazineContent mc = magazineContentPersistence.findByPrimaryKey(id);
		if(mc != null){
			mc.setMagazineZoneID(magazineZoneID);
			mc.setHeadline(name);
			mc.setSortOrder(sortOrder);
			mc.setBody(body);
			mc.setAuthor(author);
			mc.setJobtitle(jobtitle);
			return magazineContentPersistence.update(mc);
		}
		return mc;
}

	public MagazineContent addMagazineContent(long groupId,long userId,String userFullname, int magazineID, int magazineZoneID, String name, String body,String author,String jobtitle,int sortOrder,ServiceContext serviceContext) throws SystemException,
			PortalException {
		
		//Date now = new Date();
		int entryId = (int) counterLocalService.increment();
		MagazineContent mc = magazineContentPersistence.create(entryId);
	
		mc.setHeadline(name);
		mc.setSortOrder(sortOrder);
		mc.setMagazineZoneID(magazineZoneID);
		mc.setBody(body);
		mc.setAuthor(author);
		mc.setJobtitle(jobtitle);
		mc.setMagazineID(magazineID);
		
		return magazineContentPersistence.update(mc);
	}
}