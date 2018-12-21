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

package com.revotech.portal.tthc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.LegalDocument;
import com.revotech.portal.tthc.service.base.LegalDocumentLocalServiceBaseImpl;
import com.revotech.portal.tthc.service.persistence.LegalDocumentFinderUtil;
import com.revotech.portal.tthc.service.persistence.LegalDocumentUtil;

/**
 * The implementation of the legal document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.tthc.service.LegalDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hieptran
 * @see com.revotech.portal.tthc.service.base.LegalDocumentLocalServiceBaseImpl
 * @see com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil
 */
public class LegalDocumentLocalServiceImpl
	extends LegalDocumentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil} to access the legal document local service.
	 */
	public List findFieldByKeyword(String keywords, long groupId, long category1Id, long category12d, int level,
			int start, int end) throws PortalException, SystemException{
		return LegalDocumentFinderUtil.searchFieldByStatusVersion(keywords, groupId, category1Id, category12d, level, start, end);
	}
	public List<LegalDocument> findByKeyword(String keywords, long groupId, long category1Id, long category12d, int level,
			int start, int end) throws PortalException, SystemException{
		return LegalDocumentFinderUtil.searchByStatusVersion(keywords, groupId, category1Id, category12d, level, start, end);
	}
	public int countByKeyword(String keywords, long groupId, long category1Id, long category2Id, int level) throws PortalException,
	SystemException {
		return LegalDocumentFinderUtil.countByStatusVersion(keywords, groupId, category1Id, category2Id, level);
	}
	public List<LegalDocument> getLatestLegalDocument(long groupId, int level, boolean isActive, int start, int end, OrderByComparator obc) throws PortalException, SystemException{
		return LegalDocumentUtil.findByG_L_A(groupId, level, isActive, start, end , obc);
	}
	public void addLegalDocument(long groupId, long companyId, long userId, String userName,  
			String ldCode, String ldTitle, String ldLink, String ldLevel3Link, String ldSubcontent, boolean isActive, 
			long idLinhvuc, long idCoquanbanhanh, String ldDonvithuchien, int level, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		long ldId = counterLocalService.increment(LegalDocument.class.getName());
		LegalDocument legalDocument = legalDocumentPersistence.create(ldId);
		legalDocument.setGroupId(groupId);
		legalDocument.setCompanyId(companyId);
		legalDocument.setCreateDate(now);
		legalDocument.setModifiedDate(now);
		legalDocument.setUserId(userId);
		legalDocument.setUserName(userName);
		
		legalDocument.setLdCode(ldCode);
		legalDocument.setLdTitle(ldTitle);
		legalDocument.setLdLink(ldLink);
		legalDocument.setLdLevel3Link(ldLevel3Link);
		legalDocument.setLdSubcontent(ldSubcontent);
		legalDocument.setIsActive(isActive);
		legalDocument.setIdLinhvuc(idLinhvuc);
		legalDocument.setIdCoquanbanhanh(idCoquanbanhanh);
		legalDocument.setLdDonvithuchien(ldDonvithuchien);
		legalDocument.setLdLevel(level);
		
		addLegalDocumentResource(legalDocument, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		legalDocumentPersistence.update(legalDocument);
	}
	
	public void updateLegalDocument(long ldId, long groupId, long companyId, long userId, String userName,  
			String ldCode, String ldTitle, String ldLink, String ldLevel3Link, String ldSubcontent, boolean isActive, 
			long idLinhvuc, long idCoquanbanhanh, String ldDonvithuchien, int level, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		LegalDocument legalDocument = legalDocumentPersistence.fetchByPrimaryKey(ldId);
		legalDocument.setGroupId(groupId);
		legalDocument.setCompanyId(companyId);
		legalDocument.setModifiedDate(now);
		legalDocument.setUserId(userId);
		legalDocument.setUserName(userName);
		
		legalDocument.setLdCode(ldCode);
		legalDocument.setLdTitle(ldTitle);
		legalDocument.setLdLink(ldLink);
		legalDocument.setLdLevel3Link(ldLevel3Link);
		legalDocument.setLdSubcontent(ldSubcontent);
		legalDocument.setIsActive(isActive);
		legalDocument.setIdLinhvuc(idLinhvuc);
		legalDocument.setIdCoquanbanhanh(idCoquanbanhanh);
		legalDocument.setLdDonvithuchien(ldDonvithuchien);
		legalDocument.setLdLevel(level);
		
		updateLegalDocumentResource(legalDocument, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		legalDocumentPersistence.update(legalDocument);
	}
	
	protected void addLegalDocumentResource(LegalDocument legalDocument,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(legalDocument.getCompanyId(),
				legalDocument.getGroupId(), legalDocument.getUserId(), LegalDocument.class.getName(),
				legalDocument.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
	protected void updateLegalDocumentResource(LegalDocument legalDocument,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(legalDocument.getCompanyId(),
				legalDocument.getGroupId(), Category.class.getName(),
				legalDocument.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}