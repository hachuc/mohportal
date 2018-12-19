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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.service.base.CommentLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.CommentUtil;

/**
 * The implementation of the comment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.CommentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.CommentLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.CommentLocalServiceUtil
 */
public class CommentLocalServiceImpl extends CommentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.CommentLocalServiceUtil} to access the comment local service.
	 */	
	public List<Comment> getAllComment()throws SystemException, PortalException {
		return CommentUtil.findAll();
	}
	public void addLegalComment(long groupId, long companyId, long userId, String userName, Date createDate, Date modifyDate, int id, int distributionId, 
			String fullName, String address, String email, String body, boolean visible, String ipAddress, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		Comment comment = commentPersistence.create(id);
		comment.setGroupId(groupId);
		comment.setCompanyId(companyId);
		comment.setCreateDate(createDate);
		comment.setModifiedDate(modifyDate);
		comment.setDistributionId(distributionId);
		comment.setFullName(fullName);
		comment.setAddress(address);
		comment.setEmail(email);
		comment.setBody(body);
		comment.setVisible(visible);
		comment.setIpAddress(ipAddress);
		addCommentResource(comment, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		commentPersistence.update(comment);
	}
	
	public void addComment(long groupId, long companyId, long userId, String userName, int id, int distributionId, 
			String fullName, String address, String email, String body, boolean visible, String ipAddress, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		Comment comment = commentPersistence.create(id);
		comment.setGroupId(groupId);
		comment.setCompanyId(companyId);
		comment.setCreateDate(now);
		comment.setModifiedDate(now);
		comment.setDistributionId(distributionId);
		comment.setFullName(fullName);
		comment.setAddress(address);
		comment.setEmail(email);
		comment.setBody(body);
		comment.setVisible(visible);
		comment.setIpAddress(ipAddress);
		addCommentResource(comment, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		commentPersistence.update(comment);
	}
	
	public void deleteAllData() throws PortalException, SystemException{
		CommentUtil.removeAll();
	}
	protected void addCommentResource(Comment comment,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(comment.getCompanyId(),
				comment.getGroupId(), comment.getUserId(), Distribution.class.getName(),
				comment.getPrimaryKey(), groupPermissions, guestPermissions);
	}
}