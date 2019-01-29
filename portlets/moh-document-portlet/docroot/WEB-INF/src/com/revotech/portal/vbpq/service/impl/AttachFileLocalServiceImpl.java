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

package com.revotech.portal.vbpq.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.revotech.portal.vbpq.service.base.AttachFileLocalServiceBaseImpl;
import com.revotech.portal.vbpq.model.AttachFile;

/**
 * The implementation of the attach file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.revotech.portal.vbpq.service.AttachFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.vbpq.service.base.AttachFileLocalServiceBaseImpl
 * @see com.revotech.portal.vbpq.service.AttachFileLocalServiceUtil
 */
public class AttachFileLocalServiceImpl extends AttachFileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.revotech.portal.vbpq.service.AttachFileLocalServiceUtil} to access
	 * the attach file local service.
	 */
	public void deleteAttachFileVanBan(long vanBanId) throws PortalException, SystemException {

	}

	public List<AttachFile> getAttachByVanBan(long vanBanId) throws PortalException, SystemException {

		return attachFilePersistence.findByVANBANID(vanBanId);
	}

	/**
	 * @param id
	 * @param vanBanId
	 * @param fileId
	 * @param fileLink
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public AttachFile updateAttachFile(long id, long vanBanId, long fileId, String fileLink)
			throws PortalException, SystemException {

		AttachFile atf = null;

		if (id > 0) {
			atf = attachFilePersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(AttachFile.class.getName());

			atf = attachFilePersistence.create(id);
		}

		atf.setVanBanId(vanBanId);
		atf.setFileId(fileId);
		atf.setFileLink(fileLink);

		attachFilePersistence.update(atf);

		attachFilePersistence.clearCache();

		return atf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.viettel.portal.vbpq.service.AttachFileLocalService#updateAttachFile(
	 * long, long, long, java.lang.String, java.lang.String, java.lang.String)
	 */
	public AttachFile updateAttachFile(long id, long vanBanId, long fileId, String fileLink, String fileName,
			String fileSize) throws PortalException, SystemException {

		AttachFile atf = null;

		if (id > 0) {
			atf = attachFilePersistence.findByPrimaryKey(id);
		} else {
			id = counterLocalService.increment(AttachFile.class.getName());

			atf = attachFilePersistence.create(id);
		}

		atf.setVanBanId(vanBanId);
		atf.setFileId(fileId);
		atf.setFileLink(fileLink);
		atf.setFileName(fileName);
		atf.setFileSize(fileSize);

		attachFilePersistence.update(atf);

		attachFilePersistence.clearCache();

		return atf;
	}
}