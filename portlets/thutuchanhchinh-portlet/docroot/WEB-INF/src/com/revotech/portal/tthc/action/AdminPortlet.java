package com.revotech.portal.tthc.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.revotech.portal.tthc.DuplicateCategoryNameException;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.LegalDocument;
import com.revotech.portal.tthc.service.CategoryLocalServiceUtil;
import com.revotech.portal.tthc.service.LegalDocumentLocalServiceUtil;

public class AdminPortlet extends MVCPortlet {

	public void updateCategory(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			//long groupId = ParamUtil.getLong(actionRequest, "groupId");
			String userName = PortalUtil.getUserName(userId, "Guest");
			long categoryId = ParamUtil.getLong(actionRequest, "id", 0L);
			String categoryName = ParamUtil.getString(actionRequest, "categoryName");
			String categoryDesc = ParamUtil.getString(actionRequest, "categoryDesc");
			boolean isActive = ParamUtil.getBoolean(actionRequest, "isActive");
			int corder = ParamUtil.getInteger(actionRequest, "catOrder");
			int categoryType = ParamUtil.getInteger(actionRequest, "categoryType");
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			List<Category> categories = CategoryLocalServiceUtil.findByCategoryName(groupId, categoryType, categoryName);
			if (Validator.isNotNull(categoryId)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
				Category category = null;
				if (categoryId > 0) {
					category = CategoryLocalServiceUtil.fetchCategory(categoryId);
				}

				if (Validator.isNotNull(category)) {
					if (categories != null && !categories.isEmpty() && !category.getCategoryName().equals(categoryName)) {
						throw new DuplicateCategoryNameException();
					}
					CategoryLocalServiceUtil.updateCategory(groupId, companyId,
							userId, userName, categoryId, categoryName, categoryDesc, isActive, categoryType, corder,
							serviceContext);
				}
				} else {
					if (categories != null && !categories.isEmpty()) {
						throw new Exception();
					}
					ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
					serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
					CategoryLocalServiceUtil.addCategory(groupId, companyId, userId, userName, categoryName, categoryDesc, categoryType, corder, isActive, serviceContext);
	
				}
			SessionMessages.add(actionRequest, "category-saved-successfully");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateCategoryNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				SessionErrors.add(actionRequest, "save-failed");
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}

	public void updateDocument(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			long ldId = ParamUtil.getLong(actionRequest, "ldId", 0L);
			long idCoquanbanhanh = ParamUtil.getLong(actionRequest, "idCoquanbanhanh", 0L);
			String ldDonvithuchien = ParamUtil.getString(actionRequest, "ldDonvithuchien");
			long idLinhvuc = ParamUtil.getLong(actionRequest, "idLinhvuc", 0L);
			String ldCode = ParamUtil.getString(actionRequest, "ldCode");
			String ldTitle = ParamUtil.getString(actionRequest, "ldTitle");
			String ldLink = ParamUtil.getString(actionRequest, "ldLink");
			String ldLevel3Link = ParamUtil.getString(actionRequest, "ldLevel3Link");
			String ldSubcontent = ParamUtil.getString(actionRequest, "ldSubcontent");
			boolean isActive = ParamUtil.getBoolean(actionRequest, "isActive");
			int ldLevel = ParamUtil.getInteger(actionRequest, "ldlevel");
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			if (Validator.isNotNull(ldId)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
				LegalDocument legalDocument = null;
				if (ldId > 0) {
					legalDocument = LegalDocumentLocalServiceUtil.fetchLegalDocument(ldId);
				}

				if (Validator.isNotNull(legalDocument)) {
					LegalDocumentLocalServiceUtil.updateLegalDocument(ldId, groupId,  companyId,  userId,  userName,  
							 ldCode,  ldTitle,  ldLink,  ldLevel3Link,  ldSubcontent,  isActive, 
							 idLinhvuc,  idCoquanbanhanh, ldDonvithuchien, ldLevel,  serviceContext);
				}
			} else {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				LegalDocumentLocalServiceUtil.addLegalDocument(groupId,  companyId,  userId,  userName,  
						 ldCode,  ldTitle,  ldLink,  ldLevel3Link,  ldSubcontent,  isActive, 
						 idLinhvuc,  idCoquanbanhanh, ldDonvithuchien, ldLevel,  serviceContext);

			}
			SessionMessages.add(actionRequest, "legaldocument-saved-successfully");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			if (e instanceof DuplicateCategoryNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
			} else {
				SessionErrors.add(actionRequest, "save-failed");
			}

			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
	
	public void deleteCategory(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId", 0L);
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			Category cat = CategoryLocalServiceUtil.fetchCategory(categoryId);
			if(cat!=null)
				CategoryLocalServiceUtil.deleteCategory(cat);
			
			SessionMessages.add(actionRequest, "category-delete-successfully");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
	
	public void deleteDocument(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long ldId = ParamUtil.getLong(actionRequest, "ldId", 0L);
			String redirectURL = ParamUtil.getString(actionRequest,"redirectURL");
			LegalDocument ld = LegalDocumentLocalServiceUtil.fetchLegalDocument(ldId);
			if(ld!=null)
				LegalDocumentLocalServiceUtil.deleteLegalDocument(ldId);
				SessionMessages.add(actionRequest, "category-delete-successfully");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			
			String redirectURL = ParamUtil.getString(actionRequest,
					"redirectURL");

			if (Validator.isNotNull(redirectURL)) {

				actionResponse.sendRedirect(redirectURL);
			}
		}
	}
}
