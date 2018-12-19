package com.viettel.portal.vcms.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.service.base.CommentLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.CommentFinderUtil;
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
	public List customSearchByKeyword(long companyId, long groupId, String keyword, int type, int start, int end) throws PortalException, SystemException{
		return CommentFinderUtil.customSearchByKeywords(companyId, groupId, keyword, type, start, end);
	}
	public int customCountByKeyword(long companyId, long groupId, String keywords, int type) throws PortalException, SystemException{
		return CommentFinderUtil.customCountByKeywords(companyId, groupId, keywords, type);
	}
	public List<Comment> getAllComment()throws SystemException, PortalException {
		return CommentUtil.findAll();
	}
	public List<Comment> getVisibleComment(long groupId, long distId, boolean isVisible) throws PortalException, SystemException{
		return commentPersistence.findByG_D_V(groupId, distId, isVisible);
	}
	public List<Comment> findByKeyword(long companyId, long groupId, String keyword, int start, int end) throws PortalException, SystemException{
		return CommentFinderUtil.findByKeywords(companyId, groupId, keyword, start, end);
	}
	public int countByKeyword(long companyId, long groupId, String keywords) throws PortalException, SystemException{
		return CommentFinderUtil.countByKeywords(companyId, groupId, keywords);
	}
	public List<Comment> getByContentId(long groupId, long distributionId, int start, int end) throws SystemException, PortalException{
		return CommentUtil.findByG_D(groupId, distributionId, start, end);
	}
	public int countByContentId(long groupId, long distributionId) throws PortalException, SystemException{
		return CommentUtil.countByG_D(groupId, distributionId);
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
	
	public void addComment(long groupId, long companyId, long userId, String userName, long id, long distributionId, 
			String fullName, String address, String email, String body, boolean visible, String ipAddress, ServiceContext serviceContext) throws SystemException, PortalException{
		Date now = new Date();
		if(id==0L)
			id=counterLocalService.increment();
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