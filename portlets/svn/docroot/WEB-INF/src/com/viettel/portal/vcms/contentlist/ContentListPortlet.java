package com.viettel.portal.vcms.contentlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.Notes;
import com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.NotesLocalServiceUtil;
import com.viettel.portal.vcms.util.CmsConstants;
import com.viettel.portal.vcms.util.CmsUtil;

/**
 * Portlet implementation class ContentListPortlet
 */
public class ContentListPortlet extends MVCPortlet {
	/*
	 * Add new content
	 */
	public void addContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		UploadPortletRequest uploadPortletRequest = null;
		try {
			uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			long autoId = ParamUtil.getLong(uploadPortletRequest,"autoId", 0L);
			long fileId = 0L;
			String fileUuId = ParamUtil.getString(uploadPortletRequest, "fileId", StringPool.BLANK);
			String fileName = ParamUtil.getString(uploadPortletRequest, "fileName", StringPool.BLANK);
			if(Validator.isNotNull(fileUuId)){
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntryByUuidAndGroupId(fileUuId, groupId);
				if(fileEntry!=null)
					fileId = fileEntry.getFileEntryId();
			}
			
			String redirect = ParamUtil.getString(uploadPortletRequest, "redirect", StringPool.BLANK);
			String userName = PortalUtil.getUserName(userId, "Guest");
			String cmd = ParamUtil.getString(uploadPortletRequest,
					Constants.CMD);
			String title = ParamUtil.getString(uploadPortletRequest, "title",
					StringPool.BLANK);
			String subTitle = ParamUtil.getString(uploadPortletRequest,
					"subTitle", StringPool.BLANK);
			String summary = ParamUtil.getString(uploadPortletRequest,
					"summary", StringPool.BLANK);
			String subContent = ParamUtil.getString(uploadPortletRequest,
					"subContent", StringPool.BLANK);
			String content = ParamUtil.getString(uploadPortletRequest,
					"content", StringPool.BLANK);
			String copyRight = ParamUtil.getString(uploadPortletRequest,
					"copyRight", StringPool.BLANK);
			String author = ParamUtil.getString(uploadPortletRequest, "author",
					StringPool.BLANK);
			String jobTitle = ParamUtil.getString(uploadPortletRequest,
					"jobTitle", StringPool.BLANK);
			long categoryId = ParamUtil.getLong(uploadPortletRequest,
					"categoryId");
			int newsType = ParamUtil.getInteger(uploadPortletRequest,
					"newsType");

			List<String> errors = new ArrayList<String>();
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Content.class.getName(), actionRequest);
			ServiceContext serviceDetailContext = ServiceContextFactory.getInstance(
					ContentDetail.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (validationInput(title, categoryId, content, newsType, errors)) {
				if (cmd.equals(Constants.ADD)) {
					ContentLocalServiceUtil.addContent(groupId, companyId,
							userId, userName, autoId, 0L, 0, 1, subTitle, title,
							summary, subContent, content, fileId,
							fileName, categoryId, copyRight,
							CmsConstants.ADD_NEWS, userId, userName, author,
							jobTitle, newsType, serviceContext, serviceDetailContext);
				}
			}

			for (String error : errors) {
				SessionErrors.add(uploadPortletRequest, error);
			}
			actionResponse.sendRedirect(redirect);
		    SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		    //System.out.println(redirectURL.toString());
		    

		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(uploadPortletRequest, e.getClass().getName());
		}
	}

	/*
	 * Send content to next version
	 * update current status to sent, create new version with state wait for edit
	 */
	public void sendToNextStep(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			int version = ParamUtil.getInteger(actionRequest, "version");
			int status = ParamUtil.getInteger(actionRequest, "status");
			long editUserId = 0L, reviewUserId = 0L;
			String editUserName = StringPool.BLANK, reviewUserName = StringPool.BLANK;
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");

			Content curContent = ContentLocalServiceUtil.fetchByAutoId(curAutoId, groupId);
			int nextVersion = 2;
			int nextStatus = 8;
			if (curContent != null) {
				// Bai gui tu phong vien
				if (version == 1 && status == 1) {
					nextVersion = 2;
					nextStatus = 8;
					//curContent.setVersion(1);
					curContent.setStatus(2);
				}
				// Bai gui tu thu ky toa soan
				if (version == 2 && (status == 8 || status == 16)) {
					nextVersion = 3;
					nextStatus = 256;
					curContent.setVersion(2);
					curContent.setStatus(32);
					editUserId = userId;
					editUserName = userName;
					curContent.setEditedByUserId(editUserId);
					curContent.setEditedByUserName(editUserName);
				}
				// Bai gui tu pho tong bien tap
				if (version == 3 && (status == 256 || status == 512)) {
					nextVersion = 4;
					nextStatus = 2048;
					curContent.setVersion(3);
					curContent.setStatus(1024);
					reviewUserId = userId;
					reviewUserName = userName;
					curContent.setReviewedByUserId(reviewUserId);
					curContent.setReviewedByUserName(reviewUserName);
				}

				ContentLocalServiceUtil.updateContent(curContent);
				// Clone content for next version
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Content.class.getName(), actionRequest);

				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				
				ServiceContext serviceDetailContext = ServiceContextFactory.getInstance(ContentDetail.class.getName(), actionRequest);

				serviceDetailContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceDetailContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

				ContentLocalServiceUtil.addContentVersion(groupId, companyId,
						userId, userName, curContent.getContentId(),
						nextVersion, curContent.getSubTitle(),
						curContent.getTitle(), curContent.getUrlTitle(),
						curContent.getSummary(), curContent.getSubContent(),
						curContent.getContent(), curContent.getSmallImageId(),
						curContent.getSmallImageUrl(),
						curContent.getCategoryId(), curContent.getCopyRight(),
						nextStatus, curContent.getCreatedByUserId(),
						curContent.getEditedByUserId(),
						curContent.getReviewedByUserId(),
						curContent.getPublishedByUserId(),
						curContent.getCreatedByUserName(),
						curContent.getEditedByUserName(),
						curContent.getReviewedByUserName(),
						curContent.getPublishedByUserName(),
						curContent.getAuthor(), curContent.getJobTitle(),
						curContent.getNewsType(), serviceContext, serviceDetailContext);
			}

			actionResponse.sendRedirect(redirectURL);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void removeContent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		try{
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long contentId = ParamUtil.getLong(actionRequest, "contentId");
			long autoId = ParamUtil.getLong(actionRequest, "contentId");
			int version = ParamUtil.getInteger(actionRequest, "version");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			if(contentId == 0L || autoId == 0L || version == 0){
				SessionErrors.add(actionRequest, "content-not-exists");
				return;
			}
			DistributionLocalServiceUtil.unPublishContent(groupId, contentId);
			ContentLocalServiceUtil.removeContent(groupId, contentId);
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}	
		catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void unPublishContent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		try{
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long contentId = ParamUtil.getLong(actionRequest, "contentId");
			long autoId = ParamUtil.getLong(actionRequest, "autoId");
			int version = ParamUtil.getInteger(actionRequest, "version");
			int status = ParamUtil.getInteger(actionRequest, "status");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			if(contentId == 0L || autoId == 0L || version == 0 || status ==0){
				SessionErrors.add(actionRequest, "content-not-exists");
			}
			DistributionLocalServiceUtil.unPublishContent(groupId, contentId);
			Content curContent = ContentLocalServiceUtil
					.fetchContent(autoId);
			if(curContent == null){
				SessionErrors.add(actionRequest, "content-not-exists");
				return;
			}
			curContent.setPublishedByUserId(0L);
			curContent.setPublishedByUserName(StringPool.BLANK);
			curContent.setStatus(CmsConstants.WAIT_DEPLOY);
			ContentLocalServiceUtil.updateContent(curContent);
			if(Validator.isNotNull(redirectURL)){
				actionResponse.sendRedirect(redirectURL);
			}
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		}catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	/*
	 * Update status for current version when edit content
	 */
	public void updateNextStatus(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			long contentId = ParamUtil.getLong(actionRequest, "contentId");
			long userId = PortalUtil.getUserId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			int version = ParamUtil.getInteger(actionRequest, "version");
			int status = ParamUtil.getInteger(actionRequest, "nextStatus");
			long editUserId = 0L, reviewUserId = 0L, deployUserId = 0L;
			String editUserName = StringPool.BLANK, reviewUserName = StringPool.BLANK, deployUserName = StringPool.BLANK;
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			String command = ParamUtil.getString(actionRequest, "cmd");
			Content curContent = ContentLocalServiceUtil.fetchByAutoId(curAutoId, groupId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);
			Date now = new Date();
			if (curContent != null && detail != null) {
				contentId = curContent.getContentId();
				curContent.setStatus(status);
				detail.setStatus(status);
				// cap nhat editor
				if (version == 2) {
					if ("UDEDITOR".equals(command)) {
						editUserId = userId;
						editUserName = userName;
					} else if ("RMEDITOR".equals(command)) {
						editUserId = 0L;
						editUserName = StringPool.BLANK;
					}
					curContent.setEditedByUserId(editUserId);
					curContent.setEditedByUserName(editUserName);
				}
				// cap nhat reviewer
				if (version == 3) {
					if ("UDREVIEWER".equals(command)) {
						reviewUserId = userId;
						reviewUserName = userName;
					} else if ("RMREVIEWER".equals(command)) {
						reviewUserId = 0L;
						reviewUserName = StringPool.BLANK;
					}
					curContent.setReviewedByUserId(reviewUserId);
					curContent.setReviewedByUserName(reviewUserName);
				}
				// cap nhat deployer
				if (version == 4) {
					if ("UDDEPLOYER".equals(command)) {
						deployUserId = userId;
						deployUserName = userName;

						if (status == 8192) {
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(Distribution.class.getName(),
											actionRequest);
							long[] categoryIds = new long[] { curContent
									.getCategoryId() };
							serviceContext
									.setGroupPermissions(new String[] { ActionKeys.VIEW });
							serviceContext
									.setGuestPermissions(new String[] { ActionKeys.VIEW });
							boolean allowDiscussion = ParamUtil.getBoolean(
									actionRequest, "allowDiscussion", false);
							// Update distribution table
							DistributionLocalServiceUtil.publishContent(
									groupId, companyId, userId, userName,
									contentId, version, curContent.getTitle(), categoryIds,
									allowDiscussion, now, serviceContext);
							
						}
					} else if ("RMDEPLOYER".equals(command)) {
						deployUserId = 0L;
						deployUserName = StringPool.BLANK;
					}
					curContent.setPublishedByUserId(deployUserId);
					curContent.setPublishedByUserName(deployUserName);
				}
				ContentLocalServiceUtil.updateContent(curContent);
				ContentDetailLocalServiceUtil.updateContentDetail(detail);
			}

			actionResponse.sendRedirect(redirectURL);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void currentURL(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			// long groupId = PortalUtil.getScopeGroupId(actionRequest);
			// long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			// int version = ParamUtil.getInteger(actionRequest, "version");
			int nextStatus = ParamUtil.getInteger(actionRequest, "nextStatus");

			String redirectURL = ParamUtil.getString(actionRequest, "redirect");

			Content curContent = ContentLocalServiceUtil
					.fetchContent(curAutoId);

			if (curContent != null) {
				// curContent.setVersion(1);
				curContent.setStatus(nextStatus);
				curContent.setEditedByUserId(userId);
				curContent.setEditedByUserName(userName);
				ContentLocalServiceUtil.updateContent(curContent);

				// Clone content for next version
				// ServiceContext serviceContext =
				// ServiceContextFactory.getInstance(
				// Content.class.getName(), actionRequest);

				// serviceContext.setGroupPermissions(new String[] {
				// ActionKeys.VIEW });
				// serviceContext.setGuestPermissions(new String[] {
				// ActionKeys.VIEW });

				// ContentLocalServiceUtil.addContentVersion(groupId, companyId,
				// userId, userName,curContent.getContentId(), nextVersion,
				// curContent.getSubTitle(),
				// curContent.getTitle(), curContent.getUrlTitle(),
				// curContent.getSummary(),curContent.getSubContent(),
				// curContent.getContent(),curContent.getSmallImageId(),
				// curContent.getSmallImageUrl(), curContent.getCategoryId(),
				// curContent.getCopyRight(), nextStatus,
				// curContent.getCreatedByUserId(), 0, 0, 0,
				// curContent.getCreatedByUserName(),
				// StringPool.BLANK, StringPool.BLANK, StringPool.BLANK,
				// curContent.getAuthor(), curContent.getJobTitle(),
				// curContent.getNewsType(), serviceContext);
			}

			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	public void rejectContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			int status = ParamUtil.getInteger(actionRequest, "status");
			String comment = ParamUtil.getString(actionRequest, "comment");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			int version = ParamUtil.getInteger(actionRequest, "version");
			Content curContent = ContentLocalServiceUtil.fetchByAutoId(curAutoId, groupId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);
			if (curContent != null && detail !=null) {
				curContent.setStatus(status);
				//curContent.setEditedByUserId(0);
				curContent.setReviewedByUserId(0);
				curContent.setPublishedByUserId(0);
				//curContent.setEditedByUserName(StringPool.BLANK);
				curContent.setReviewedByUserName(StringPool.BLANK);
				curContent.setPublishedByUserName(StringPool.BLANK);
				
				detail.setStatus(status);
				
				ContentLocalServiceUtil.updateContent(curContent);
				ContentDetailLocalServiceUtil.updateContentDetail(detail);
				ServiceContext serviceContext = ServiceContextFactory
						.getInstance(Notes.class.getName(), actionRequest);

				serviceContext
						.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext
						.setGuestPermissions(new String[] { ActionKeys.VIEW });

				NotesLocalServiceUtil.addNote(companyId, groupId, userId,
						curContent.getContentId(), version, comment, userName,
						serviceContext);
			}

			actionResponse.sendRedirect(redirectURL);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	public void updateContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		UploadPortletRequest uploadPortletRequest = null;
		try {
			uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			Content entry = null;
			String cmd = ParamUtil.getString(uploadPortletRequest,
					Constants.CMD);
			String redirect = ParamUtil.getString(actionRequest, "redirect");
			long autoId = ParamUtil.getLong(uploadPortletRequest, "autoId", 0L);
			long fileId = ParamUtil.getLong(uploadPortletRequest, "fileId", 0L);
			String fileUuId = ParamUtil.getString(uploadPortletRequest, "fileUuId", StringPool.BLANK);
			String fileName = ParamUtil.getString(uploadPortletRequest, "fileName", StringPool.BLANK);
			if(Validator.isNotNull(fileUuId) && fileId == 0L){
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntryByUuidAndGroupId(fileUuId, groupId);
				if(fileEntry!=null)
					fileId = fileEntry.getFileEntryId();
			}
			
			
			long contentId = ParamUtil.getLong(uploadPortletRequest,
					"contentId", 0L);
			if (autoId > 0 && contentId > 0) {
				entry = ContentLocalServiceUtil.fetchContent(autoId);
			}
			String title = ParamUtil.getString(uploadPortletRequest, "title", StringPool.BLANK);
			String subTitle = ParamUtil.getString(uploadPortletRequest, "subTitle", StringPool.BLANK);
			String summary = ParamUtil.getString(uploadPortletRequest, "summary", StringPool.BLANK);
			String subContent = ParamUtil.getString(uploadPortletRequest, "subContent", StringPool.BLANK);
			String content = ParamUtil.getString(uploadPortletRequest, "content", StringPool.BLANK);
			String copyRight = ParamUtil.getString(uploadPortletRequest, "copyRight", StringPool.BLANK);
			String author = ParamUtil.getString(uploadPortletRequest, "author",
					StringPool.BLANK);
			String jobTitle = ParamUtil.getString(uploadPortletRequest,
					"jobTitle", StringPool.BLANK);
			long categoryId = ParamUtil.getLong(uploadPortletRequest,
					"categoryId");
			int newsType = ParamUtil.getInteger(uploadPortletRequest,
					"newsType");

			List<String> errors = new ArrayList<String>();			
			String urlTitle = CmsUtil.getFriendlyFileName(title);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Content.class.getName(), actionRequest);
			ServiceContext serviceDetailContext = ServiceContextFactory.getInstance(
					Content.class.getName(), actionRequest);
			serviceContext
					.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext
					.setGuestPermissions(new String[] { ActionKeys.VIEW });
			if (validationInput(title, categoryId, content, newsType, errors)
					&& cmd.equals(Constants.UPDATE)
					&& Validator.isNotNull(entry)) {
				ContentLocalServiceUtil.addContent(groupId, companyId, userId,
						userName, autoId, contentId, 0, entry.getVersion(),
						subTitle, title, urlTitle, summary, subContent,
						fileId, fileName, categoryId, copyRight,
						entry.getStatus(), entry.getCreatedByUserId(),
						entry.getCreatedByUserName(), author, jobTitle,
						newsType, serviceContext, serviceDetailContext);
			}

			for (String error : errors) {
				SessionErrors.add(uploadPortletRequest, error);
			}
			actionResponse.sendRedirect(redirect);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(uploadPortletRequest, e.getClass().getName());
		}
	}

	public void deleteContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			String command = ParamUtil.getString(actionRequest, "cmd");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			Content curContent = ContentLocalServiceUtil.fetchContent(curAutoId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);

			if (curContent != null && detail!=null && command.equals(Constants.DELETE)) {
				ContentLocalServiceUtil.deleteContent(curContent);
				ContentDetailLocalServiceUtil.deleteContentDetail(detail);
			}
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			actionResponse.sendRedirect(redirectURL);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}

	public void rewriteContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			int version = ParamUtil.getInteger(actionRequest, "version");
			int preVersion = 1;
			int preStatus = 2;
			int newStatus = 1;
			Content curContent = ContentLocalServiceUtil.fetchContent(curAutoId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);
			
			if (curContent != null && detail !=null) {
				if (version == 2) {
					preVersion = 1;
					preStatus = 2;
					newStatus = 1;
				} else if (version > 2) {
					preVersion = 2;
					preStatus = 32;
					newStatus = 8;
				}

				Content newContent = ContentLocalServiceUtil.findByContentId(curContent.getContentId(), groupId, preVersion, preStatus);
				
				if(newContent!=null){
					ContentDetail detail2 = ContentDetailLocalServiceUtil.fetchContentDetail(newContent.getAutoId());
					
					newContent.setStatus(newStatus);	
					detail2.setStatus(newStatus);
					ContentLocalServiceUtil.updateContent(newContent);
					ContentDetailLocalServiceUtil.updateContentDetail(detail2);
					ContentLocalServiceUtil.deleteContent(curContent);
					ContentDetailLocalServiceUtil.deleteContentDetail(detail);
					actionResponse.setRenderParameter("autoId", String.valueOf(newContent.getAutoId()));
				}else{
					curContent.setVersion(preVersion);
					curContent.setStatus(preStatus);
					detail.setVersion(preVersion);
					detail.setStatus(preStatus);
					ContentLocalServiceUtil.updateContent(curContent);
					ContentDetailLocalServiceUtil.updateContentDetail(detail);
					actionResponse.setRenderParameter("autoId", String.valueOf(curContent.getAutoId()));
				}
				
				//RenderUrl
				
				actionResponse.setRenderParameter("mvcPath", "/html/admin/list-content/view_content.jsp");
			}
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	private boolean validationInput(String ten, long categoryId,
			String content, int newsType, List<String> errors) {

		boolean result = true;
		if (Validator.isNull(ten) || (categoryId <= 0) || (newsType <= 0)
				|| (Validator.isNull(content)))
			result = false;
		if (Validator.isNull(ten)) {
			errors.add("empty-title");
		}
		if (categoryId <= 0) {
			errors.add("you-must-choose-category");
		}
		if (newsType <= 0) {
			errors.add("you-must-choose-news-type");
		}
		if (Validator.isNull(content)) {
			errors.add("empty-content");
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.
	 * ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			resourceResponse.setContentType("text/html");
			PrintWriter writer = resourceResponse.getWriter();
			int version = ParamUtil.getInteger(resourceRequest, "version", 0);
			JSONArray statusArray = JSONFactoryUtil.createJSONArray();
			if (version != 0) {
				JSONArray arrays = JSONFactoryUtil
						.createJSONArray(VERSION_STATUS);
				for (int i = 0; i < arrays.length(); i++) {
					JSONObject jsonObject = arrays.getJSONObject(i);
					if (version == jsonObject.getInt("Version")) {
						statusArray = jsonObject.getJSONArray("Status");
						break;
					}
				}
			}
			writer.print(statusArray.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(ContentListPortlet.class);
	private static String VERSION_STATUS = "[{\"Version\":1,\"Status\":[{\"Status\":1, \"Message\":\"BÃ i má»›i viáº¿t\"},{\"Status\":2, \"Message\":\"BÃ i gá»­i biÃªn táº­p\"}]},{\"Version\":2,\"Status\":[{\"Status\":4, \"Message\":\"BÃ i tráº£ láº¡i phÃ³ng viÃªn\"},{\"Status\":8, \"Message\":\"BÃ i chá»� biÃªn táº­p\"},{\"Status\":16, \"Message\":\"BÃ i Ä‘ang biÃªn táº­p\"},{\"Status\":32, \"Message\":\"BÃ i gá»­i kiá»ƒm duyá»‡t\"}]},{\"Version\":3,\"Status\":[{\"Status\":128, \"Message\":\"BÃ i tráº£ láº¡i biÃªn táº­p\"},{\"Status\":256, \"Message\":\"BÃ i chá»� kiá»ƒm duyá»‡t\"},{\"Status\":512, \"Message\":\"BÃ i Ä‘ang kiá»ƒm duyá»‡t\"},{\"Status\":1024, \"Message\":\"BÃ i gá»­i triá»ƒn khai\"}]},{\"Version\":4,\"Status\":[{\"Status\":64, \"Message\":\"BÃ i tráº£ láº¡i biÃªn táº­p\"},{\"Status\":2048, \"Message\":\"BÃ i chá»� triá»ƒn khai\"},{\"Status\":4096, \"Message\":\"BÃ i Ä‘ang triá»ƒn khai\"},{\"Status\":8192, \"Message\":\"BÃ i Ä‘Ã£ Ä‘Äƒng\"}]}]";

}
