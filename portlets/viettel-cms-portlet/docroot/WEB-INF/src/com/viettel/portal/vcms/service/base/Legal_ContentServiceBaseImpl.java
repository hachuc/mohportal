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

package com.viettel.portal.vcms.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.viettel.portal.vcms.model.Legal_Content;
import com.viettel.portal.vcms.service.Legal_ContentService;
import com.viettel.portal.vcms.service.persistence.CategoryPersistence;
import com.viettel.portal.vcms.service.persistence.CommentFinder;
import com.viettel.portal.vcms.service.persistence.CommentPersistence;
import com.viettel.portal.vcms.service.persistence.ContentDetailFinder;
import com.viettel.portal.vcms.service.persistence.ContentDetailPersistence;
import com.viettel.portal.vcms.service.persistence.ContentFinder;
import com.viettel.portal.vcms.service.persistence.ContentPersistence;
import com.viettel.portal.vcms.service.persistence.ContentProfitPersistence;
import com.viettel.portal.vcms.service.persistence.ContentTypeFinder;
import com.viettel.portal.vcms.service.persistence.ContentTypePersistence;
import com.viettel.portal.vcms.service.persistence.DistributionFinder;
import com.viettel.portal.vcms.service.persistence.DistributionPersistence;
import com.viettel.portal.vcms.service.persistence.DistributionVisistedPersistence;
import com.viettel.portal.vcms.service.persistence.Legal_CommentPersistence;
import com.viettel.portal.vcms.service.persistence.Legal_ContentPersistence;
import com.viettel.portal.vcms.service.persistence.Legal_ContentProfitPersistence;
import com.viettel.portal.vcms.service.persistence.Legal_DistributionPersistence;
import com.viettel.portal.vcms.service.persistence.Legal_ZonePersistence;
import com.viettel.portal.vcms.service.persistence.NotesPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the legal_ content remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.viettel.portal.vcms.service.impl.Legal_ContentServiceImpl}.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.impl.Legal_ContentServiceImpl
 * @see com.viettel.portal.vcms.service.Legal_ContentServiceUtil
 * @generated
 */
public abstract class Legal_ContentServiceBaseImpl extends BaseServiceImpl
	implements Legal_ContentService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.viettel.portal.vcms.service.Legal_ContentServiceUtil} to access the legal_ content remote service.
	 */

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public com.viettel.portal.vcms.service.CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		com.viettel.portal.vcms.service.CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public com.viettel.portal.vcms.service.CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setCategoryService(
		com.viettel.portal.vcms.service.CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the comment local service.
	 *
	 * @return the comment local service
	 */
	public com.viettel.portal.vcms.service.CommentLocalService getCommentLocalService() {
		return commentLocalService;
	}

	/**
	 * Sets the comment local service.
	 *
	 * @param commentLocalService the comment local service
	 */
	public void setCommentLocalService(
		com.viettel.portal.vcms.service.CommentLocalService commentLocalService) {
		this.commentLocalService = commentLocalService;
	}

	/**
	 * Returns the comment remote service.
	 *
	 * @return the comment remote service
	 */
	public com.viettel.portal.vcms.service.CommentService getCommentService() {
		return commentService;
	}

	/**
	 * Sets the comment remote service.
	 *
	 * @param commentService the comment remote service
	 */
	public void setCommentService(
		com.viettel.portal.vcms.service.CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * Returns the comment persistence.
	 *
	 * @return the comment persistence
	 */
	public CommentPersistence getCommentPersistence() {
		return commentPersistence;
	}

	/**
	 * Sets the comment persistence.
	 *
	 * @param commentPersistence the comment persistence
	 */
	public void setCommentPersistence(CommentPersistence commentPersistence) {
		this.commentPersistence = commentPersistence;
	}

	/**
	 * Returns the comment finder.
	 *
	 * @return the comment finder
	 */
	public CommentFinder getCommentFinder() {
		return commentFinder;
	}

	/**
	 * Sets the comment finder.
	 *
	 * @param commentFinder the comment finder
	 */
	public void setCommentFinder(CommentFinder commentFinder) {
		this.commentFinder = commentFinder;
	}

	/**
	 * Returns the content local service.
	 *
	 * @return the content local service
	 */
	public com.viettel.portal.vcms.service.ContentLocalService getContentLocalService() {
		return contentLocalService;
	}

	/**
	 * Sets the content local service.
	 *
	 * @param contentLocalService the content local service
	 */
	public void setContentLocalService(
		com.viettel.portal.vcms.service.ContentLocalService contentLocalService) {
		this.contentLocalService = contentLocalService;
	}

	/**
	 * Returns the content remote service.
	 *
	 * @return the content remote service
	 */
	public com.viettel.portal.vcms.service.ContentService getContentService() {
		return contentService;
	}

	/**
	 * Sets the content remote service.
	 *
	 * @param contentService the content remote service
	 */
	public void setContentService(
		com.viettel.portal.vcms.service.ContentService contentService) {
		this.contentService = contentService;
	}

	/**
	 * Returns the content persistence.
	 *
	 * @return the content persistence
	 */
	public ContentPersistence getContentPersistence() {
		return contentPersistence;
	}

	/**
	 * Sets the content persistence.
	 *
	 * @param contentPersistence the content persistence
	 */
	public void setContentPersistence(ContentPersistence contentPersistence) {
		this.contentPersistence = contentPersistence;
	}

	/**
	 * Returns the content finder.
	 *
	 * @return the content finder
	 */
	public ContentFinder getContentFinder() {
		return contentFinder;
	}

	/**
	 * Sets the content finder.
	 *
	 * @param contentFinder the content finder
	 */
	public void setContentFinder(ContentFinder contentFinder) {
		this.contentFinder = contentFinder;
	}

	/**
	 * Returns the content detail local service.
	 *
	 * @return the content detail local service
	 */
	public com.viettel.portal.vcms.service.ContentDetailLocalService getContentDetailLocalService() {
		return contentDetailLocalService;
	}

	/**
	 * Sets the content detail local service.
	 *
	 * @param contentDetailLocalService the content detail local service
	 */
	public void setContentDetailLocalService(
		com.viettel.portal.vcms.service.ContentDetailLocalService contentDetailLocalService) {
		this.contentDetailLocalService = contentDetailLocalService;
	}

	/**
	 * Returns the content detail remote service.
	 *
	 * @return the content detail remote service
	 */
	public com.viettel.portal.vcms.service.ContentDetailService getContentDetailService() {
		return contentDetailService;
	}

	/**
	 * Sets the content detail remote service.
	 *
	 * @param contentDetailService the content detail remote service
	 */
	public void setContentDetailService(
		com.viettel.portal.vcms.service.ContentDetailService contentDetailService) {
		this.contentDetailService = contentDetailService;
	}

	/**
	 * Returns the content detail persistence.
	 *
	 * @return the content detail persistence
	 */
	public ContentDetailPersistence getContentDetailPersistence() {
		return contentDetailPersistence;
	}

	/**
	 * Sets the content detail persistence.
	 *
	 * @param contentDetailPersistence the content detail persistence
	 */
	public void setContentDetailPersistence(
		ContentDetailPersistence contentDetailPersistence) {
		this.contentDetailPersistence = contentDetailPersistence;
	}

	/**
	 * Returns the content detail finder.
	 *
	 * @return the content detail finder
	 */
	public ContentDetailFinder getContentDetailFinder() {
		return contentDetailFinder;
	}

	/**
	 * Sets the content detail finder.
	 *
	 * @param contentDetailFinder the content detail finder
	 */
	public void setContentDetailFinder(ContentDetailFinder contentDetailFinder) {
		this.contentDetailFinder = contentDetailFinder;
	}

	/**
	 * Returns the content profit local service.
	 *
	 * @return the content profit local service
	 */
	public com.viettel.portal.vcms.service.ContentProfitLocalService getContentProfitLocalService() {
		return contentProfitLocalService;
	}

	/**
	 * Sets the content profit local service.
	 *
	 * @param contentProfitLocalService the content profit local service
	 */
	public void setContentProfitLocalService(
		com.viettel.portal.vcms.service.ContentProfitLocalService contentProfitLocalService) {
		this.contentProfitLocalService = contentProfitLocalService;
	}

	/**
	 * Returns the content profit remote service.
	 *
	 * @return the content profit remote service
	 */
	public com.viettel.portal.vcms.service.ContentProfitService getContentProfitService() {
		return contentProfitService;
	}

	/**
	 * Sets the content profit remote service.
	 *
	 * @param contentProfitService the content profit remote service
	 */
	public void setContentProfitService(
		com.viettel.portal.vcms.service.ContentProfitService contentProfitService) {
		this.contentProfitService = contentProfitService;
	}

	/**
	 * Returns the content profit persistence.
	 *
	 * @return the content profit persistence
	 */
	public ContentProfitPersistence getContentProfitPersistence() {
		return contentProfitPersistence;
	}

	/**
	 * Sets the content profit persistence.
	 *
	 * @param contentProfitPersistence the content profit persistence
	 */
	public void setContentProfitPersistence(
		ContentProfitPersistence contentProfitPersistence) {
		this.contentProfitPersistence = contentProfitPersistence;
	}

	/**
	 * Returns the content type local service.
	 *
	 * @return the content type local service
	 */
	public com.viettel.portal.vcms.service.ContentTypeLocalService getContentTypeLocalService() {
		return contentTypeLocalService;
	}

	/**
	 * Sets the content type local service.
	 *
	 * @param contentTypeLocalService the content type local service
	 */
	public void setContentTypeLocalService(
		com.viettel.portal.vcms.service.ContentTypeLocalService contentTypeLocalService) {
		this.contentTypeLocalService = contentTypeLocalService;
	}

	/**
	 * Returns the content type remote service.
	 *
	 * @return the content type remote service
	 */
	public com.viettel.portal.vcms.service.ContentTypeService getContentTypeService() {
		return contentTypeService;
	}

	/**
	 * Sets the content type remote service.
	 *
	 * @param contentTypeService the content type remote service
	 */
	public void setContentTypeService(
		com.viettel.portal.vcms.service.ContentTypeService contentTypeService) {
		this.contentTypeService = contentTypeService;
	}

	/**
	 * Returns the content type persistence.
	 *
	 * @return the content type persistence
	 */
	public ContentTypePersistence getContentTypePersistence() {
		return contentTypePersistence;
	}

	/**
	 * Sets the content type persistence.
	 *
	 * @param contentTypePersistence the content type persistence
	 */
	public void setContentTypePersistence(
		ContentTypePersistence contentTypePersistence) {
		this.contentTypePersistence = contentTypePersistence;
	}

	/**
	 * Returns the content type finder.
	 *
	 * @return the content type finder
	 */
	public ContentTypeFinder getContentTypeFinder() {
		return contentTypeFinder;
	}

	/**
	 * Sets the content type finder.
	 *
	 * @param contentTypeFinder the content type finder
	 */
	public void setContentTypeFinder(ContentTypeFinder contentTypeFinder) {
		this.contentTypeFinder = contentTypeFinder;
	}

	/**
	 * Returns the distribution local service.
	 *
	 * @return the distribution local service
	 */
	public com.viettel.portal.vcms.service.DistributionLocalService getDistributionLocalService() {
		return distributionLocalService;
	}

	/**
	 * Sets the distribution local service.
	 *
	 * @param distributionLocalService the distribution local service
	 */
	public void setDistributionLocalService(
		com.viettel.portal.vcms.service.DistributionLocalService distributionLocalService) {
		this.distributionLocalService = distributionLocalService;
	}

	/**
	 * Returns the distribution remote service.
	 *
	 * @return the distribution remote service
	 */
	public com.viettel.portal.vcms.service.DistributionService getDistributionService() {
		return distributionService;
	}

	/**
	 * Sets the distribution remote service.
	 *
	 * @param distributionService the distribution remote service
	 */
	public void setDistributionService(
		com.viettel.portal.vcms.service.DistributionService distributionService) {
		this.distributionService = distributionService;
	}

	/**
	 * Returns the distribution persistence.
	 *
	 * @return the distribution persistence
	 */
	public DistributionPersistence getDistributionPersistence() {
		return distributionPersistence;
	}

	/**
	 * Sets the distribution persistence.
	 *
	 * @param distributionPersistence the distribution persistence
	 */
	public void setDistributionPersistence(
		DistributionPersistence distributionPersistence) {
		this.distributionPersistence = distributionPersistence;
	}

	/**
	 * Returns the distribution finder.
	 *
	 * @return the distribution finder
	 */
	public DistributionFinder getDistributionFinder() {
		return distributionFinder;
	}

	/**
	 * Sets the distribution finder.
	 *
	 * @param distributionFinder the distribution finder
	 */
	public void setDistributionFinder(DistributionFinder distributionFinder) {
		this.distributionFinder = distributionFinder;
	}

	/**
	 * Returns the distribution visisted local service.
	 *
	 * @return the distribution visisted local service
	 */
	public com.viettel.portal.vcms.service.DistributionVisistedLocalService getDistributionVisistedLocalService() {
		return distributionVisistedLocalService;
	}

	/**
	 * Sets the distribution visisted local service.
	 *
	 * @param distributionVisistedLocalService the distribution visisted local service
	 */
	public void setDistributionVisistedLocalService(
		com.viettel.portal.vcms.service.DistributionVisistedLocalService distributionVisistedLocalService) {
		this.distributionVisistedLocalService = distributionVisistedLocalService;
	}

	/**
	 * Returns the distribution visisted remote service.
	 *
	 * @return the distribution visisted remote service
	 */
	public com.viettel.portal.vcms.service.DistributionVisistedService getDistributionVisistedService() {
		return distributionVisistedService;
	}

	/**
	 * Sets the distribution visisted remote service.
	 *
	 * @param distributionVisistedService the distribution visisted remote service
	 */
	public void setDistributionVisistedService(
		com.viettel.portal.vcms.service.DistributionVisistedService distributionVisistedService) {
		this.distributionVisistedService = distributionVisistedService;
	}

	/**
	 * Returns the distribution visisted persistence.
	 *
	 * @return the distribution visisted persistence
	 */
	public DistributionVisistedPersistence getDistributionVisistedPersistence() {
		return distributionVisistedPersistence;
	}

	/**
	 * Sets the distribution visisted persistence.
	 *
	 * @param distributionVisistedPersistence the distribution visisted persistence
	 */
	public void setDistributionVisistedPersistence(
		DistributionVisistedPersistence distributionVisistedPersistence) {
		this.distributionVisistedPersistence = distributionVisistedPersistence;
	}

	/**
	 * Returns the legal_ comment local service.
	 *
	 * @return the legal_ comment local service
	 */
	public com.viettel.portal.vcms.service.Legal_CommentLocalService getLegal_CommentLocalService() {
		return legal_CommentLocalService;
	}

	/**
	 * Sets the legal_ comment local service.
	 *
	 * @param legal_CommentLocalService the legal_ comment local service
	 */
	public void setLegal_CommentLocalService(
		com.viettel.portal.vcms.service.Legal_CommentLocalService legal_CommentLocalService) {
		this.legal_CommentLocalService = legal_CommentLocalService;
	}

	/**
	 * Returns the legal_ comment remote service.
	 *
	 * @return the legal_ comment remote service
	 */
	public com.viettel.portal.vcms.service.Legal_CommentService getLegal_CommentService() {
		return legal_CommentService;
	}

	/**
	 * Sets the legal_ comment remote service.
	 *
	 * @param legal_CommentService the legal_ comment remote service
	 */
	public void setLegal_CommentService(
		com.viettel.portal.vcms.service.Legal_CommentService legal_CommentService) {
		this.legal_CommentService = legal_CommentService;
	}

	/**
	 * Returns the legal_ comment persistence.
	 *
	 * @return the legal_ comment persistence
	 */
	public Legal_CommentPersistence getLegal_CommentPersistence() {
		return legal_CommentPersistence;
	}

	/**
	 * Sets the legal_ comment persistence.
	 *
	 * @param legal_CommentPersistence the legal_ comment persistence
	 */
	public void setLegal_CommentPersistence(
		Legal_CommentPersistence legal_CommentPersistence) {
		this.legal_CommentPersistence = legal_CommentPersistence;
	}

	/**
	 * Returns the legal_ content local service.
	 *
	 * @return the legal_ content local service
	 */
	public com.viettel.portal.vcms.service.Legal_ContentLocalService getLegal_ContentLocalService() {
		return legal_ContentLocalService;
	}

	/**
	 * Sets the legal_ content local service.
	 *
	 * @param legal_ContentLocalService the legal_ content local service
	 */
	public void setLegal_ContentLocalService(
		com.viettel.portal.vcms.service.Legal_ContentLocalService legal_ContentLocalService) {
		this.legal_ContentLocalService = legal_ContentLocalService;
	}

	/**
	 * Returns the legal_ content remote service.
	 *
	 * @return the legal_ content remote service
	 */
	public com.viettel.portal.vcms.service.Legal_ContentService getLegal_ContentService() {
		return legal_ContentService;
	}

	/**
	 * Sets the legal_ content remote service.
	 *
	 * @param legal_ContentService the legal_ content remote service
	 */
	public void setLegal_ContentService(
		com.viettel.portal.vcms.service.Legal_ContentService legal_ContentService) {
		this.legal_ContentService = legal_ContentService;
	}

	/**
	 * Returns the legal_ content persistence.
	 *
	 * @return the legal_ content persistence
	 */
	public Legal_ContentPersistence getLegal_ContentPersistence() {
		return legal_ContentPersistence;
	}

	/**
	 * Sets the legal_ content persistence.
	 *
	 * @param legal_ContentPersistence the legal_ content persistence
	 */
	public void setLegal_ContentPersistence(
		Legal_ContentPersistence legal_ContentPersistence) {
		this.legal_ContentPersistence = legal_ContentPersistence;
	}

	/**
	 * Returns the legal_ content profit local service.
	 *
	 * @return the legal_ content profit local service
	 */
	public com.viettel.portal.vcms.service.Legal_ContentProfitLocalService getLegal_ContentProfitLocalService() {
		return legal_ContentProfitLocalService;
	}

	/**
	 * Sets the legal_ content profit local service.
	 *
	 * @param legal_ContentProfitLocalService the legal_ content profit local service
	 */
	public void setLegal_ContentProfitLocalService(
		com.viettel.portal.vcms.service.Legal_ContentProfitLocalService legal_ContentProfitLocalService) {
		this.legal_ContentProfitLocalService = legal_ContentProfitLocalService;
	}

	/**
	 * Returns the legal_ content profit remote service.
	 *
	 * @return the legal_ content profit remote service
	 */
	public com.viettel.portal.vcms.service.Legal_ContentProfitService getLegal_ContentProfitService() {
		return legal_ContentProfitService;
	}

	/**
	 * Sets the legal_ content profit remote service.
	 *
	 * @param legal_ContentProfitService the legal_ content profit remote service
	 */
	public void setLegal_ContentProfitService(
		com.viettel.portal.vcms.service.Legal_ContentProfitService legal_ContentProfitService) {
		this.legal_ContentProfitService = legal_ContentProfitService;
	}

	/**
	 * Returns the legal_ content profit persistence.
	 *
	 * @return the legal_ content profit persistence
	 */
	public Legal_ContentProfitPersistence getLegal_ContentProfitPersistence() {
		return legal_ContentProfitPersistence;
	}

	/**
	 * Sets the legal_ content profit persistence.
	 *
	 * @param legal_ContentProfitPersistence the legal_ content profit persistence
	 */
	public void setLegal_ContentProfitPersistence(
		Legal_ContentProfitPersistence legal_ContentProfitPersistence) {
		this.legal_ContentProfitPersistence = legal_ContentProfitPersistence;
	}

	/**
	 * Returns the legal_ distribution local service.
	 *
	 * @return the legal_ distribution local service
	 */
	public com.viettel.portal.vcms.service.Legal_DistributionLocalService getLegal_DistributionLocalService() {
		return legal_DistributionLocalService;
	}

	/**
	 * Sets the legal_ distribution local service.
	 *
	 * @param legal_DistributionLocalService the legal_ distribution local service
	 */
	public void setLegal_DistributionLocalService(
		com.viettel.portal.vcms.service.Legal_DistributionLocalService legal_DistributionLocalService) {
		this.legal_DistributionLocalService = legal_DistributionLocalService;
	}

	/**
	 * Returns the legal_ distribution remote service.
	 *
	 * @return the legal_ distribution remote service
	 */
	public com.viettel.portal.vcms.service.Legal_DistributionService getLegal_DistributionService() {
		return legal_DistributionService;
	}

	/**
	 * Sets the legal_ distribution remote service.
	 *
	 * @param legal_DistributionService the legal_ distribution remote service
	 */
	public void setLegal_DistributionService(
		com.viettel.portal.vcms.service.Legal_DistributionService legal_DistributionService) {
		this.legal_DistributionService = legal_DistributionService;
	}

	/**
	 * Returns the legal_ distribution persistence.
	 *
	 * @return the legal_ distribution persistence
	 */
	public Legal_DistributionPersistence getLegal_DistributionPersistence() {
		return legal_DistributionPersistence;
	}

	/**
	 * Sets the legal_ distribution persistence.
	 *
	 * @param legal_DistributionPersistence the legal_ distribution persistence
	 */
	public void setLegal_DistributionPersistence(
		Legal_DistributionPersistence legal_DistributionPersistence) {
		this.legal_DistributionPersistence = legal_DistributionPersistence;
	}

	/**
	 * Returns the legal_ zone local service.
	 *
	 * @return the legal_ zone local service
	 */
	public com.viettel.portal.vcms.service.Legal_ZoneLocalService getLegal_ZoneLocalService() {
		return legal_ZoneLocalService;
	}

	/**
	 * Sets the legal_ zone local service.
	 *
	 * @param legal_ZoneLocalService the legal_ zone local service
	 */
	public void setLegal_ZoneLocalService(
		com.viettel.portal.vcms.service.Legal_ZoneLocalService legal_ZoneLocalService) {
		this.legal_ZoneLocalService = legal_ZoneLocalService;
	}

	/**
	 * Returns the legal_ zone remote service.
	 *
	 * @return the legal_ zone remote service
	 */
	public com.viettel.portal.vcms.service.Legal_ZoneService getLegal_ZoneService() {
		return legal_ZoneService;
	}

	/**
	 * Sets the legal_ zone remote service.
	 *
	 * @param legal_ZoneService the legal_ zone remote service
	 */
	public void setLegal_ZoneService(
		com.viettel.portal.vcms.service.Legal_ZoneService legal_ZoneService) {
		this.legal_ZoneService = legal_ZoneService;
	}

	/**
	 * Returns the legal_ zone persistence.
	 *
	 * @return the legal_ zone persistence
	 */
	public Legal_ZonePersistence getLegal_ZonePersistence() {
		return legal_ZonePersistence;
	}

	/**
	 * Sets the legal_ zone persistence.
	 *
	 * @param legal_ZonePersistence the legal_ zone persistence
	 */
	public void setLegal_ZonePersistence(
		Legal_ZonePersistence legal_ZonePersistence) {
		this.legal_ZonePersistence = legal_ZonePersistence;
	}

	/**
	 * Returns the notes local service.
	 *
	 * @return the notes local service
	 */
	public com.viettel.portal.vcms.service.NotesLocalService getNotesLocalService() {
		return notesLocalService;
	}

	/**
	 * Sets the notes local service.
	 *
	 * @param notesLocalService the notes local service
	 */
	public void setNotesLocalService(
		com.viettel.portal.vcms.service.NotesLocalService notesLocalService) {
		this.notesLocalService = notesLocalService;
	}

	/**
	 * Returns the notes remote service.
	 *
	 * @return the notes remote service
	 */
	public com.viettel.portal.vcms.service.NotesService getNotesService() {
		return notesService;
	}

	/**
	 * Sets the notes remote service.
	 *
	 * @param notesService the notes remote service
	 */
	public void setNotesService(
		com.viettel.portal.vcms.service.NotesService notesService) {
		this.notesService = notesService;
	}

	/**
	 * Returns the notes persistence.
	 *
	 * @return the notes persistence
	 */
	public NotesPersistence getNotesPersistence() {
		return notesPersistence;
	}

	/**
	 * Sets the notes persistence.
	 *
	 * @param notesPersistence the notes persistence
	 */
	public void setNotesPersistence(NotesPersistence notesPersistence) {
		this.notesPersistence = notesPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Legal_Content.class;
	}

	protected String getModelClassName() {
		return Legal_Content.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = legal_ContentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.viettel.portal.vcms.service.CategoryLocalService.class)
	protected com.viettel.portal.vcms.service.CategoryLocalService categoryLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.CategoryService.class)
	protected com.viettel.portal.vcms.service.CategoryService categoryService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.CommentLocalService.class)
	protected com.viettel.portal.vcms.service.CommentLocalService commentLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.CommentService.class)
	protected com.viettel.portal.vcms.service.CommentService commentService;
	@BeanReference(type = CommentPersistence.class)
	protected CommentPersistence commentPersistence;
	@BeanReference(type = CommentFinder.class)
	protected CommentFinder commentFinder;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentLocalService.class)
	protected com.viettel.portal.vcms.service.ContentLocalService contentLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentService.class)
	protected com.viettel.portal.vcms.service.ContentService contentService;
	@BeanReference(type = ContentPersistence.class)
	protected ContentPersistence contentPersistence;
	@BeanReference(type = ContentFinder.class)
	protected ContentFinder contentFinder;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentDetailLocalService.class)
	protected com.viettel.portal.vcms.service.ContentDetailLocalService contentDetailLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentDetailService.class)
	protected com.viettel.portal.vcms.service.ContentDetailService contentDetailService;
	@BeanReference(type = ContentDetailPersistence.class)
	protected ContentDetailPersistence contentDetailPersistence;
	@BeanReference(type = ContentDetailFinder.class)
	protected ContentDetailFinder contentDetailFinder;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentProfitLocalService.class)
	protected com.viettel.portal.vcms.service.ContentProfitLocalService contentProfitLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentProfitService.class)
	protected com.viettel.portal.vcms.service.ContentProfitService contentProfitService;
	@BeanReference(type = ContentProfitPersistence.class)
	protected ContentProfitPersistence contentProfitPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentTypeLocalService.class)
	protected com.viettel.portal.vcms.service.ContentTypeLocalService contentTypeLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.ContentTypeService.class)
	protected com.viettel.portal.vcms.service.ContentTypeService contentTypeService;
	@BeanReference(type = ContentTypePersistence.class)
	protected ContentTypePersistence contentTypePersistence;
	@BeanReference(type = ContentTypeFinder.class)
	protected ContentTypeFinder contentTypeFinder;
	@BeanReference(type = com.viettel.portal.vcms.service.DistributionLocalService.class)
	protected com.viettel.portal.vcms.service.DistributionLocalService distributionLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.DistributionService.class)
	protected com.viettel.portal.vcms.service.DistributionService distributionService;
	@BeanReference(type = DistributionPersistence.class)
	protected DistributionPersistence distributionPersistence;
	@BeanReference(type = DistributionFinder.class)
	protected DistributionFinder distributionFinder;
	@BeanReference(type = com.viettel.portal.vcms.service.DistributionVisistedLocalService.class)
	protected com.viettel.portal.vcms.service.DistributionVisistedLocalService distributionVisistedLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.DistributionVisistedService.class)
	protected com.viettel.portal.vcms.service.DistributionVisistedService distributionVisistedService;
	@BeanReference(type = DistributionVisistedPersistence.class)
	protected DistributionVisistedPersistence distributionVisistedPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_CommentLocalService.class)
	protected com.viettel.portal.vcms.service.Legal_CommentLocalService legal_CommentLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_CommentService.class)
	protected com.viettel.portal.vcms.service.Legal_CommentService legal_CommentService;
	@BeanReference(type = Legal_CommentPersistence.class)
	protected Legal_CommentPersistence legal_CommentPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ContentLocalService.class)
	protected com.viettel.portal.vcms.service.Legal_ContentLocalService legal_ContentLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ContentService.class)
	protected com.viettel.portal.vcms.service.Legal_ContentService legal_ContentService;
	@BeanReference(type = Legal_ContentPersistence.class)
	protected Legal_ContentPersistence legal_ContentPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ContentProfitLocalService.class)
	protected com.viettel.portal.vcms.service.Legal_ContentProfitLocalService legal_ContentProfitLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ContentProfitService.class)
	protected com.viettel.portal.vcms.service.Legal_ContentProfitService legal_ContentProfitService;
	@BeanReference(type = Legal_ContentProfitPersistence.class)
	protected Legal_ContentProfitPersistence legal_ContentProfitPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_DistributionLocalService.class)
	protected com.viettel.portal.vcms.service.Legal_DistributionLocalService legal_DistributionLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_DistributionService.class)
	protected com.viettel.portal.vcms.service.Legal_DistributionService legal_DistributionService;
	@BeanReference(type = Legal_DistributionPersistence.class)
	protected Legal_DistributionPersistence legal_DistributionPersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ZoneLocalService.class)
	protected com.viettel.portal.vcms.service.Legal_ZoneLocalService legal_ZoneLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.Legal_ZoneService.class)
	protected com.viettel.portal.vcms.service.Legal_ZoneService legal_ZoneService;
	@BeanReference(type = Legal_ZonePersistence.class)
	protected Legal_ZonePersistence legal_ZonePersistence;
	@BeanReference(type = com.viettel.portal.vcms.service.NotesLocalService.class)
	protected com.viettel.portal.vcms.service.NotesLocalService notesLocalService;
	@BeanReference(type = com.viettel.portal.vcms.service.NotesService.class)
	protected com.viettel.portal.vcms.service.NotesService notesService;
	@BeanReference(type = NotesPersistence.class)
	protected NotesPersistence notesPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private Legal_ContentServiceClpInvoker _clpInvoker = new Legal_ContentServiceClpInvoker();
}