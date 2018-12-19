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

package com.portal_egov.portlet.legal_faq.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.model.LegalFAQEntry;
import com.portal_egov.portlet.legal_faq.service.base.FeedbackLocalServiceBaseImpl;

/**
 * The implementation of the feedback local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.portal_egov.portlet.legal_faq.service.FeedbackLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.portal_egov.portlet.legal_faq.service.base.FeedbackLocalServiceBaseImpl
 * @see com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil
 */
public class FeedbackLocalServiceImpl extends FeedbackLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil} to access the feedback local service.
	 */
	public List<Feedback> findByGroupId(long groupId) throws SystemException {
		return feedbackPersistence.findByG(groupId);
	}
	public Feedback getEntry(long entryId) throws SystemException{
		return feedbackPersistence.fetchByPrimaryKey(entryId);
	}
	
	public List<Feedback> findByKeyword(long groupId, String keyword, int start, int end) throws SystemException {
		return feedbackFinder.findByKeyword(groupId, keyword, start, end);
	}
	
	public int countFeedbacks(long groupId, String keyword){
		return feedbackFinder.countFeedbacks(groupId,keyword);
	}
	
}