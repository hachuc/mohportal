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
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.model.JournalArticle;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.service.base.ContentLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.ContentDetailFinderUtil;
import com.viettel.portal.vcms.service.persistence.ContentDetailUtil;
import com.viettel.portal.vcms.service.persistence.ContentFinderUtil;
import com.viettel.portal.vcms.service.persistence.ContentUtil;
import com.viettel.portal.vcms.service.persistence.DistributionUtil;
import com.viettel.portal.vcms.util.CmsUtil;

/**
 * The implementation of the content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.viettel.portal.vcms.service.ContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.ContentLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.ContentLocalServiceUtil
 */
public class ContentLocalServiceImpl extends ContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.viettel.portal.vcms.service.ContentLocalServiceUtil} to access the
	 * content local service.
	 */
	public List<Content> findByStatusVersion(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version, int searchOption, com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end) throws PortalException, SystemException {
		return contentFinder.searchByStatusVersion(keyword, groupId, categoryId, authorId, status, version, searchOption, obc, start, end);
	}
	public List<Content> getContentsByStatusVersion(long groupId, int version, int status, int start, int end) throws SystemException, PortalException{
		return contentPersistence.findByG_V_S(groupId, version, status, start, end);
	}
	public int countContentsByStatusVersion(long groupId, int version, int status) throws SystemException, PortalException{
		return contentPersistence.countByG_V_S(groupId, version, status);
	}
	//Get by Author
	public List<Content> getContentsByASV(long groupId, long authorId, int version, int status, int start, int end) throws SystemException, PortalException{
		return contentPersistence.findByG_AU_V_S(groupId, authorId, version, status, start, end);
	}
	public int countContentsByASV(long groupId, long authorId, int version, int status) throws SystemException, PortalException{
		return contentPersistence.countByG_AU_V_S(groupId, authorId, version, status);
	}
	
	public Content fecthLastestContent(long groupId, long contentId, int version, int status) throws PortalException, SystemException{
		return contentPersistence.fetchByG_C_V_S_First(groupId, contentId, version, status, null);
	}
	public List<Content> findByContentAndVersion(long groupId, long contentId, int version) throws PortalException, SystemException{
		return contentPersistence.findByG_C_V(groupId, contentId, version);
	}
	public List<Content> findByGroupContent(long groupId, long contentId) throws PortalException, SystemException{
		return contentPersistence.findByG_CO(groupId, contentId);
	}
	public int countByStatusVersion(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version) throws PortalException, SystemException {
		return contentFinder.countByStatusVersion(keyword, groupId, categoryId, authorId, status, version);
	}
	
	public List<Content> find(String keyword, long groupId, long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end) throws PortalException, SystemException {
		return contentFinder.findByKeyword(keyword, groupId, categoryId, obc, start, end);
	}

	public int count(String keyword, long groupId, long categoryId) throws PortalException, SystemException {
		return contentFinder.countByKeyword(keyword, groupId, categoryId);
	}
	
	public List<Content> findByCategory(long groupId, long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc, int start, int end) throws PortalException, SystemException {
		return contentFinder.findByCategory(groupId, categoryId, obc, start, end);
	}
	
	public int countByCategory(long groupId, long categoryId) throws PortalException, SystemException {
		return contentFinder.countByCategory(groupId, categoryId);
	}
	
	public List<Content> findByG_C_V_S(long groupId, long contentId, int version, int status) throws PortalException, SystemException {
		return contentPersistence.findByG_C_V_S(groupId, contentId, version, status);
	}
	public List<Content> findByG_CA_V_S(long groupId, long categoryId, int version, int status, int start, int end) throws PortalException, SystemException {
		return contentPersistence.findByG_CA_V_S(groupId, categoryId, version, status, start, end);
	}
	public int countByG_CA_V_S(long groupId, long categoryId, int version, int status)  throws PortalException, SystemException {
		return contentPersistence.countByG_CA_V_S(groupId, categoryId, version, status);
	}
	public Content getContent(long groupId, long contentId, int version, int status) throws SystemException{
		List<Content> lstContent = contentPersistence.findByG_C_V_S(groupId, contentId, version, status);
		if(lstContent.isEmpty())
			return null;
		return lstContent.get(0);
	}
	public void deleteByCategory(long groupId, long categoryId) throws SystemException{
		ContentUtil.removeByG_C(groupId, categoryId);
	}
	public void deleteContentByVersion(long groupId, long contentId, int[] versions) throws SystemException, PortalException{
		List<Content> resultContenst = ContentFinderUtil.findByVersion(groupId, contentId, versions);
		if(resultContenst!=null){
			for(Content content : resultContenst){
				ContentUtil.remove(content.getAutoId());
			}
		}
	}
	public List<Content> findByVersions (long groupId, long contentId, int[] versions) throws SystemException, PortalException{
		return ContentFinderUtil.findByVersion(groupId, contentId, versions);
	}
	public Content fetchByAutoId(long autoId, long groupId) throws SystemException, PortalException{
		Content content = ContentUtil.fetchByPrimaryKey(autoId);
		ContentDetail detail = ContentDetailUtil.fetchByPrimaryKey(autoId);
		if(content !=null && detail != null)
		{
			content.setContent(detail.getContent());
			content.setSubContent(detail.getSubContent());
			return content;
		}
		return null;
	}
	public Content findByContentId(long contentId, long groupId, int version, int status) throws SystemException, PortalException{
		return contentFinder.findByContentId(contentId, groupId, version, status);
	}
	public Content addContent(long groupid, long companyId,
			long userId, String userName, long autoId, long contentId, int preVersion, int version,
			String subTitle, String title, String summary, String subContent,
			String sContent, long smallImageId, String smallImageUrl, long categoryId,
			String copyRight, int status, long createByUserId,
			String createByUserName, String author, String jobTitle, int newsType,
			ServiceContext serviceContext, ServiceContext detailContext) throws SystemException,
			PortalException {
		Date now = new Date();
		Content content; 
		ContentDetail detail;
		String command = Constants.ADD;
		if(autoId==0){
			autoId = counterLocalService.increment();
		}
		if(contentId==0){
			contentId = counterLocalService.increment();
			content = contentPersistence.create(autoId);
			detail = contentDetailPersistence.create(autoId);
		}else{
			content = fetchContent(autoId);
			detail = ContentDetailUtil.fetchByPrimaryKey(autoId);
			command = Constants.UPDATE;
		}
		serviceContext.setAttribute("contentId", contentId);
		
		content.setContentId(contentId);
		content.setGroupId(groupid);
		content.setCompanyId(companyId);
		content.setUserId(userId);
		content.setUserName(userName);
		content.setCreateDate(now);
		content.setModifiedDate(now);
		content.setPreVersion(preVersion);
		content.setVersion(version);
		content.setSubTitle(subTitle);
		content.setTitle(title);
		content.setSummary(summary);
		
		content.setUrlTitle(getUniqueUrlTitle(contentId, title));
		if(smallImageId > 0){
			content.setSmallImageId(smallImageId);
			content.setSmallImageUrl(smallImageUrl);
		}
		content.setCategoryId(categoryId);
		content.setCopyRight(copyRight);
		content.setStatus(status);
		content.setCreatedByUserId(createByUserId);
		content.setCreatedByUserName(createByUserName);
		content.setAuthor(author);
		content.setJobTitle(jobTitle);
		content.setNewsType(newsType);
		
		
		
		detail.setContentId(contentId);
		detail.setGroupId(groupid);
		detail.setCompanyId(companyId);
		detail.setUserId(userId);
		detail.setUserName(userName);
		detail.setCreateDate(now);
		detail.setModifiedDate(now);
		detail.setVersion(version);
		detail.setSubTitle(subTitle);
		detail.setTitle(title);
		detail.setSummary(summary);	
		
		if(smallImageId > 0){
			detail.setSmallImageId(smallImageId);
			detail.setSmallImageUrl(smallImageUrl);
		}
		detail.setCategoryId(categoryId);
		detail.setStatus(status);
		detail.setNewsType(newsType);
		detail.setSubContent(subContent);
		detail.setContent(sContent);
		
		if (command.equals(Constants.ADD) && ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null))) {
			addContentResource(content, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			addContentDetailResource(detail, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}else if(command.equals(Constants.UPDATE) && ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null))){
			updateContentResource(content, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			updateContentDetailResource(detail, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
		contentDetailPersistence.update(detail);
		contentPersistence.update(content);
		content.setSubContent(subContent);
		content.setContent(sContent);
		return content;
	}
	
	public Content addLegalContent(long groupid, long companyId,
			long userId, String userName, long autoId, long contentId, int version,
			String subTitle, String title, String summary, String subContent,
			String sContent, long smallImageId, String smallImageUrl, long categoryId,
			String copyRight, int status, long createByUserId,String createByUserName, 
			long editedByUserId, String editedByUserName, long reviewedByUserId, 
			String reviewedByUserName, long approvedByUserId, String approvedByUserName,
			String author, String jobTitle, int newsType,
			String imageUrl, boolean isLegalContent, String imageCaption, 
			int imagePosition, Date creationDate, Date modifiedDate,
			ServiceContext serviceContext) throws SystemException,
			PortalException {
		Content content = contentPersistence.create(autoId);
		serviceContext.setAttribute("contentId", contentId);
		
		content.setContentId(contentId);
		content.setGroupId(groupid);
		content.setCompanyId(companyId);
		content.setUserId(userId);
		content.setUserName(userName);
		content.setCreateDate(creationDate);
		content.setModifiedDate(modifiedDate);
		content.setVersion(version);
		content.setSubTitle(subTitle);
		content.setTitle(title);
		content.setSummary(summary);
		//content.setSubContent(subContent);
		//content.setContent(sContent);
		if(Validator.isNotNull(smallImageUrl)){
			content.setSmallImageUrl(smallImageUrl);
		}
		content.setCategoryId(categoryId);
		content.setCopyRight(copyRight);
		content.setStatus(status);
		
		if(createByUserId > 0 && Validator.isNotNull(createByUserName)){
			content.setCreatedByUserId(createByUserId);
			content.setCreatedByUserName(createByUserName);
		}
		if(editedByUserId > 0 && Validator.isNotNull(editedByUserName)){
			content.setEditedByUserId(editedByUserId);
			content.setEditedByUserName(editedByUserName);
		}
		if(reviewedByUserId > 0 && Validator.isNotNull(reviewedByUserName)){
			content.setReviewedByUserId(reviewedByUserId);
			content.setReviewedByUserName(reviewedByUserName);
		}
		if(approvedByUserId > 0 && Validator.isNotNull(approvedByUserName)){
			content.setPublishedByUserId(approvedByUserId);
			content.setPublishedByUserName(approvedByUserName);
		}
		
		content.setAuthor(author);
		content.setJobTitle(jobTitle);
		content.setNewsType(newsType);
		
		//Update legal field
		content.setImageUrl(imageUrl);
		content.setIsLegalContent(isLegalContent);
		content.setImageCaption(imageCaption);
		content.setImagePosition(imagePosition);
		
		if ((serviceContext.getGroupPermissions() != null) || (serviceContext.getGuestPermissions() != null)) {
			addContentResource(content, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
		}
		return contentPersistence.update(content);
	}
	
	public Content addContentVersion(long groupid, long companyId,
			long userId, String userName, long contentId, int version,
			String subTitle, String title, String urlTitle, String summary, String subContent,
			String sContent, long smallImageId, String smallImageUrl, long categoryId,
			String copyRight, int status, long createByUserId, long editByUserId, long reviewByUserId, 
			long publishByUserId, String createByUserName, String editByUserName, String reviewByUserName, 
			String publishByUSerName, String author, String jobTitle, int newsType,
			ServiceContext serviceContext, ServiceContext serviceDetailContext) throws SystemException,
			PortalException {
		Date now = new Date();

		long autoId = counterLocalService.increment();
		Content content = contentPersistence.create(autoId);
		content.setContentId(contentId);
		content.setGroupId(groupid);
		content.setCompanyId(companyId);
		content.setUserId(userId);
		content.setUserName(userName);
		content.setCreateDate(now);
		content.setModifiedDate(now);
		content.setVersion(version);
		content.setSubTitle(subTitle);
		content.setTitle(title);
		content.setSummary(summary);
		//content.setSubContent(subContent);
		//content.setContent(sContent);
		if(smallImageId > 0){
			content.setSmallImageId(smallImageId);
			content.setSmallImageUrl(smallImageUrl);
		}
		content.setCategoryId(categoryId);
		content.setCopyRight(copyRight);
		content.setStatus(status);
		if(createByUserId > 0 && Validator.isNotNull(createByUserName)){
			content.setCreatedByUserId(createByUserId);
			content.setCreatedByUserName(createByUserName);
		}
		if(editByUserId > 0 && Validator.isNotNull(editByUserName)){
			content.setEditedByUserId(editByUserId);
			content.setEditedByUserName(editByUserName);
		}
		if(reviewByUserId > 0 && Validator.isNotNull(reviewByUserName)){
			content.setReviewedByUserId(reviewByUserId);
			content.setReviewedByUserName(reviewByUserName);
		}
		if(publishByUserId > 0 && Validator.isNotNull(publishByUSerName)){
			content.setPublishedByUserId(publishByUserId);
			content.setPublishedByUserName(publishByUSerName);
		}
		content.setAuthor(author);
		content.setJobTitle(jobTitle);
		content.setNewsType(newsType);
		
		//Add content detail
		ContentDetail detail = contentDetailPersistence.create(autoId);
		detail.setContentId(contentId);
		detail.setGroupId(groupid);
		detail.setCompanyId(companyId);
		detail.setUserId(userId);
		detail.setUserName(userName);
		detail.setCreateDate(now);
		detail.setModifiedDate(now);
		detail.setVersion(version);
		detail.setSubTitle(subTitle);
		detail.setTitle(title);
		detail.setSummary(summary);	
		
		if(smallImageId > 0){
			detail.setSmallImageId(smallImageId);
			detail.setSmallImageUrl(smallImageUrl);
		}
		detail.setCategoryId(categoryId);
		detail.setStatus(status);
		detail.setNewsType(newsType);
		detail.setSubContent(subContent);
		detail.setContent(sContent);
		
		if ((serviceContext.getGroupPermissions() != null)
				|| (serviceContext.getGuestPermissions() != null)) {

			addContentResource(content, serviceContext.getGroupPermissions(),
					serviceContext.getGuestPermissions());
			addContentDetailResource(detail, serviceDetailContext.getGroupPermissions(),
					serviceDetailContext.getGuestPermissions());
		}
		contentDetailPersistence.update(detail);
		return contentPersistence.update(content);
	}
	public void removeContent(long groupId, long contentId) throws PortalException, SystemException{
		List<Content> lstContent = contentPersistence.findByG_CO(groupId, contentId);
		if(lstContent.isEmpty())
			return;
		for(Content content : lstContent){
			contentPersistence.remove(content);
		}
	}
	
	protected String getUniqueUrlTitle(long id, String title)
		throws PortalException, SystemException {

		String urlTitle = CmsUtil.getUrlTitle(id, title);
		return urlTitle;
	}
	
	protected void addContentResource(Content content,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(content.getCompanyId(),
				content.getGroupId(), content.getUserId(), Content.class.getName(),
				content.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	protected void updateContentResource(Content content,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(content.getCompanyId(),
				content.getGroupId(), Content.class.getName(),
				content.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
	protected void addContentDetailResource(ContentDetail content,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(content.getCompanyId(),
				content.getGroupId(), content.getUserId(), Content.class.getName(),
				content.getPrimaryKey(), groupPermissions, guestPermissions);
	}

	protected void updateContentDetailResource(ContentDetail content,
			String[] groupPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.updateResources(content.getCompanyId(),
				content.getGroupId(), Content.class.getName(),
				content.getPrimaryKey(), groupPermissions, guestPermissions);
	}
	
	public void removeAll() throws SystemException, PortalException{
		ContentUtil.removeAll();
	}
}