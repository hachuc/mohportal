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

package com.viettel.portal.vcms.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Category;
import com.viettel.portal.vcms.model.Notes;
import com.viettel.portal.vcms.service.base.NotesLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.DistributionUtil;
import com.viettel.portal.vcms.service.persistence.NotesPK;
import com.viettel.portal.vcms.service.persistence.NotesUtil;

/**
 * The implementation of the notes local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.NotesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.NotesLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.NotesLocalServiceUtil
 */
public class NotesLocalServiceImpl extends NotesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.NotesLocalServiceUtil} to access the notes local service.
	 */
	public Notes addNote(long companyId, long groupId, long userId, long contentId, int version, String content,
			String userName, ServiceContext serviceContext) throws SystemException, PortalException {

		Date now = new Date();

		NotesPK notePK = new NotesPK(contentId, version);

		Notes note = notesPersistence.create(notePK);

		note.setCompanyId(companyId);
		note.setGroupId(groupId);
		note.setUserId(userId);
		note.setUserName(userName);
		note.setContent(content);
		note.setCreateDate(now);
		note.setModifiedDate(now);

		notesPersistence.update(note);

		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

			addNotesResources(note, serviceContext.isAddGroupPermissions(),
					serviceContext.isAddGuestPermissions());
		} else {

			addNotesResources(note, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}

		return note;
	}
	
	private void addNotesResources(Notes note, boolean addGroupPermissions,
			boolean addGuestPermissions) throws PortalException, SystemException {

		resourceLocalService.addResources(note.getCompanyId(), note.getGroupId(),
				note.getUserId(), Category.class.getName(), note.getContentID(), false,
				addGroupPermissions, addGuestPermissions);
	}

	private void addNotesResources(Notes note, String[] groupPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		resourceLocalService.addModelResources(note.getCompanyId(), note.getGroupId(),
				note.getUserId(), Category.class.getName(), note.getContentID(),
				groupPermissions, guestPermissions);
	}
	
	public void removeAll() throws SystemException, PortalException{
		NotesUtil.removeAll();
	}
}