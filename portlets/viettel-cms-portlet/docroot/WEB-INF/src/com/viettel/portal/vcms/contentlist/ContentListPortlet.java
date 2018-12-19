package com.viettel.portal.vcms.contentlist;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import com.liferay.portal.kernel.util.GetterUtil;
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
import com.viettel.portal.vcms.model.ContentProfit;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.Notes;
import com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentProfitLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.NotesLocalServiceUtil;
import com.viettel.portal.vcms.service.persistence.NotesPK;
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
			String[] attToFilter = new String[]{"onmouseover"};
			subContent = CmsUtil.filterHtmlAttribute(subContent, attToFilter);
			content = CmsUtil.filterHtmlAttribute(content, attToFilter);
			
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
		System.out.println("Bắt đầu debug");
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
			System.out.println("curAutoId "+curAutoId+" groupId " +groupId+ "companyId "+companyId+" userId "+userId+" userName "+userName+" version "+version+" status "+status+" editUserName "+editUserName+" redirectURL "+redirectURL);
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
					if(curContent.getEditedByUserId()>0){
						editUserId = curContent.getEditedByUserId();
						editUserName = curContent.getEditedByUserName();
					}else{
						editUserId = userId;
						editUserName = userName;
					}
					curContent.setEditedByUserId(editUserId);
					curContent.setEditedByUserName(editUserName);
				}
				// Bai gui tu pho tong bien tap
				if (version == 3 && (status == 256 || status == 512)) {
					nextVersion = 4;
					nextStatus = 2048;
					curContent.setVersion(3);
					curContent.setStatus(1024);
					if(curContent.getReviewedByUserId()>0){
						reviewUserId = curContent.getReviewedByUserId();
						reviewUserName = curContent.getReviewedByUserName();
					}else{
						reviewUserId = userId;
						reviewUserName = userName;
					}
					curContent.setReviewedByUserId(reviewUserId);
					curContent.setReviewedByUserName(reviewUserName);
				}

				ContentLocalServiceUtil.updateContent(curContent);
				// Clone content for next version
				System.out.println("CurContent Object "+curContent.toString());
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
			System.out.println("RedirectURL "+redirectURL);
			if (!(version == 3 && (status == 256 || status == 512))) {
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			} else {
				SessionMessages.add(actionRequest, "success");
			}

			if (!(version == 2 && (status == 8 || status == 16))) {
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			} else {
				SessionMessages.add(actionRequest, "success");
			}

			if (!(version == 1 && status == 1)) {
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
						+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			} else {
				SessionMessages.add(actionRequest, "success");
			}
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	public void removeContent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		try{
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long contentId = ParamUtil.getLong(actionRequest, "contentId");
			long autoId = ParamUtil.getLong(actionRequest, "autoId");
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
			//SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionMessages.add(actionRequest, "Thao tác thành công");
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
			if (contentId == 0L || autoId == 0L || version == 0 || status == 0) {
				SessionErrors.add(actionRequest, "content-not-exists");
			}
			DistributionLocalServiceUtil.unPublishContent(groupId, contentId);
			Content curContent = ContentLocalServiceUtil.fetchContent(autoId);
			if (curContent == null) {
				SessionErrors.add(actionRequest, "content-not-exists");
				return;
			}
			curContent.setPublishedByUserId(0L);
			curContent.setPublishedByUserName(StringPool.BLANK);
			curContent.setStatus(CmsConstants.WAIT_DEPLOY);
			ContentLocalServiceUtil.updateContent(curContent);
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	/*
	 * Update status for current version when edit content
	 */
	public void publishContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
			Calendar calendar = Calendar.getInstance(timezone);
			DateFormat dateTimeformatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dateTimeformatter.setCalendar(calendar);
			dateTimeformatter.setTimeZone(timezone);
				
			long autoId = ParamUtil.getLong(actionRequest, "autoId");
			long contentId = ParamUtil.getLong(actionRequest, "contentId");
			long userId = PortalUtil.getUserId(actionRequest);
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			int version = ParamUtil.getInteger(actionRequest, "version", 4);
			long newsType = ParamUtil.getLong(actionRequest, "newsType");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			int date = ParamUtil.getInteger(actionRequest, "vdate");
			int month = ParamUtil.getInteger(actionRequest, "vmonth");
			int year = ParamUtil.getInteger(actionRequest, "vyear");
			int hours = ParamUtil.getInteger(actionRequest, "vhouses");
			int minute = ParamUtil.getInteger(actionRequest, "vminutes");
			int second = ParamUtil.getInteger(actionRequest, "vseconds");
			//String datePublish = ParamUtil.getString(actionRequest, "publishDateTime");
			Calendar c = Calendar.getInstance();
			c.set(year, month - 1, date, hours, minute);  
			//Date publishDate = new Date(year, month - 1, date, hours, minute, second);
			boolean allowDiscussion = ParamUtil.getBoolean(actionRequest, "allowDiscustion");
			String[] arrcategoryIds = ParamUtil.getParameterValues(actionRequest, "categoryIds");
			
			long[] categoryIds = GetterUtil.getLongValues(arrcategoryIds);
			//Content content = ContentLocalServiceUtil.fetchByAutoId(autoId, groupId);
			//SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			ServiceContext context = ServiceContextFactory.getInstance(Distribution.class.getName(), actionRequest);
			context.setGroupPermissions(new String[] { ActionKeys.VIEW });
			context.setGuestPermissions(new String[] { ActionKeys.VIEW });
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(ContentProfit.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			
			Content content = ContentLocalServiceUtil.fetchContent(autoId);
			ContentDetail contentDetail = ContentDetailLocalServiceUtil.fetchContentDetail(autoId);
			
			//Date publishDate = dateTimeFormat.parse(datePublish);
			if(c.getTime()!=null && content!=null & categoryIds!=null && contentDetail!=null){
				System.out.println(autoId);
				content.setStatus(CmsConstants.FINAL_STATUS);
				content.setModifiedDate(new Date());
				content.setUserId(userId);
				contentDetail.setStatus(CmsConstants.FINAL_STATUS);
				contentDetail.setModifiedDate(new Date());
				contentDetail.setUserId(userId);
				content.setPublishedByUserId(userId);
				content.setPublishedByUserName(userName);
				ContentLocalServiceUtil.updateContent(content);
				ContentDetailLocalServiceUtil.updateContentDetail(contentDetail);
				DistributionLocalServiceUtil.publishContent(
						groupId, companyId, userId, userName,
						contentId, version, content.getTitle(), categoryIds,
						allowDiscussion, c.getTime(), context);
				ContentProfitLocalServiceUtil.addContentCost(groupId, companyId, content.getCreatedByUserId(), content.getCreatedByUserName(), contentId, c.getTime(), newsType, content.getTitle(), serviceContext);
			}
			//actionResponse.sendRedirect(redirectURL);
		}	catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
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
						if(curContent.getEditedByUserId()>0){
							editUserId = curContent.getEditedByUserId();
							editUserName = curContent.getEditedByUserName();
						}else{
						editUserId = userId;
						editUserName = userName;
						}
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
						if(curContent.getReviewedByUserId()>0){
							reviewUserId = curContent.getReviewedByUserId();
							reviewUserName = curContent.getReviewedByUserName();
						}else{
						reviewUserId = userId;
						reviewUserName = userName;
						}
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
						if (curContent.getPublishedByUserId() > 0) {
							deployUserId = curContent.getPublishedByUserId();
							deployUserName = curContent.getPublishedByUserName();
						} else {
							deployUserId = userId;
							deployUserName = userName;
						}
						if (status == 8192) {
							ServiceContext serviceContext = ServiceContextFactory
									.getInstance(Distribution.class.getName(), actionRequest);
							long[] categoryIds = new long[] { curContent.getCategoryId() };
							serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
							serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
							boolean allowDiscussion = ParamUtil.getBoolean(actionRequest, "allowDiscussion", false);
							// Update distribution table
							DistributionLocalServiceUtil.publishContent(groupId, companyId, userId, userName, contentId,
									version, curContent.getTitle(), categoryIds, allowDiscussion, now, serviceContext);

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

	public void rejectContentToAuthor(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			System.out.print("rejectContentToAuthor");
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			int status = ParamUtil.getInteger(actionRequest, "status");
			String comment = ParamUtil.getString(actionRequest, "comment");
			String redirectURL = ParamUtil.getString(actionRequest, "redirect");
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			int version = ParamUtil.getInteger(actionRequest, "version");
			int newVersion = 2;
			int contentId = ParamUtil.getInteger(actionRequest, "contentId");
			Content curContent = ContentLocalServiceUtil.fetchByAutoId(curAutoId, groupId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);
			if (curContent != null && detail != null) {
				// curContent.setEditedByUserId(0);

				if (version == 2) {
					curContent.setStatus(status);
					// curContent.setEditedByUserId(0);

					if (curContent.getEditedByUserId() == 0) {
						curContent.setEditedByUserId(userId);
						curContent.setEditedByUserName(userName);
					}
					detail.setStatus(status);

					ContentLocalServiceUtil.updateContent(curContent);
					ContentDetailLocalServiceUtil.updateContentDetail(detail);
				} 
				else if (version == 3 || version == 4) {
					ContentLocalServiceUtil.deleteContentByVersion(groupId, curContent.getContentId(),
							new int[] { 3, 4 });
					ContentDetailLocalServiceUtil.deleteByVersions(groupId, curContent.getContentId(),
							new int[] { 3, 4 });

					List<Content> lstContentV2 = ContentLocalServiceUtil.findByVersions(groupId,
							curContent.getContentId(), new int[] { 2 });
					List<ContentDetail> lstContentDetailV2 = ContentDetailLocalServiceUtil.findByVersions(groupId,
							curContent.getContentId(), new int[] { 2 });
					if (lstContentV2 != null && lstContentDetailV2 != null) {
						long autoId = curAutoId;
						for (Content newContent : lstContentV2) {
							if (newContent.getEditedByUserId() == 0) {
								newContent.setEditedByUserId(userId);
								newContent.setEditedByUserName(userName);
							}
							newContent.setStatus(status);
							ContentLocalServiceUtil.updateContent(newContent);
							autoId = newContent.getAutoId();
						}
						for (ContentDetail newContentDetail : lstContentDetailV2) {
							newContentDetail.setStatus(status);
							ContentDetailLocalServiceUtil.updateContentDetail(newContentDetail);
						}
					}
				}

				ServiceContext serviceContext = ServiceContextFactory.getInstance(Notes.class.getName(), actionRequest);

				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });

				if (NotesLocalServiceUtil.fetchNotes(new NotesPK(curContent.getContentId(), newVersion)) != null) {
					NotesLocalServiceUtil.deleteNotes(new NotesPK(curContent.getContentId(), newVersion));
				}
				NotesLocalServiceUtil.addNote(companyId, groupId, userId, curContent.getContentId(), newVersion,
						comment, userName, serviceContext);
			}

			actionResponse.sendRedirect(redirectURL);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void rejectContentToEditor(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			System.out.print("rejectContentToEditor");
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

				if(NotesLocalServiceUtil.fetchNotes(new NotesPK(curContent.getContentId(), version)) != null){
					NotesLocalServiceUtil.deleteNotes(new NotesPK(curContent.getContentId(), version));
				}
				NotesLocalServiceUtil.addNote(companyId, groupId, userId, curContent.getContentId(), version, comment, userName, serviceContext);
				
				/*NotesLocalServiceUtil.addNote(companyId, groupId, userId,
						curContent.getContentId(), version, comment, userName,
						serviceContext);*/
				//Xóa các bản ghi ở gửi kiểm duyệt và gửi triển khai
				try {
					if (version == 4) {
						Content sendContent = ContentLocalServiceUtil.findByContentId(curContent.getContentId(),
								groupId, 3, 1024);
						if (sendContent != null) {
							ContentLocalServiceUtil.deleteContent(sendContent);
							ContentDetailLocalServiceUtil.deleteContentDetail(sendContent.getAutoId());
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			actionResponse.sendRedirect(redirectURL);
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
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
			String[] attToFilter = new String[]{"onmouseover"};
			subContent = CmsUtil.filterHtmlAttribute(subContent, attToFilter);
			content = CmsUtil.filterHtmlAttribute(content, attToFilter);
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
						subTitle, title, summary, subContent, content, 
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
	
	public void updatePublishContent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			Content entry = null;
			ContentDetail detail = null;
			Distribution dist = null;
			String cmd = ParamUtil.getString(actionRequest,
					Constants.CMD);
			String redirect = ParamUtil.getString(actionRequest, "redirect");
			long autoId = ParamUtil.getLong(actionRequest, "autoId", 0L);
			long fileId = ParamUtil.getLong(actionRequest, "fileId", 0L);
			long distributionId = ParamUtil.getLong(actionRequest, "distributionId", 0L);
			String fileUuId = ParamUtil.getString(actionRequest, "fileUuId", StringPool.BLANK);
			String fileName = ParamUtil.getString(actionRequest, "fileName", StringPool.BLANK);
			if(Validator.isNotNull(fileUuId) && fileId == 0L){
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntryByUuidAndGroupId(fileUuId, groupId);
				if(fileEntry!=null)
					fileId = fileEntry.getFileEntryId();
			}
			
			
			long contentId = ParamUtil.getLong(actionRequest, "contentId", 0L);
			if (autoId > 0L && contentId > 0L && distributionId > 0L) {
				entry = ContentLocalServiceUtil.fetchContent(autoId);
				detail = ContentDetailLocalServiceUtil.fetchContentDetail(autoId);
				dist = DistributionLocalServiceUtil.fetchDistribution(distributionId);
			}
			String title = ParamUtil.getString(actionRequest, "title", StringPool.BLANK);
			String subTitle = ParamUtil.getString(actionRequest, "subTitle", StringPool.BLANK);
			String summary = ParamUtil.getString(actionRequest, "summary", StringPool.BLANK);
			String subContent = ParamUtil.getString(actionRequest, "subContent", StringPool.BLANK);
			String content = ParamUtil.getString(actionRequest, "content", StringPool.BLANK);
			String[] attToFilter = new String[]{"onmouseover"};
			subContent = CmsUtil.filterHtmlAttribute(subContent, attToFilter);
			content = CmsUtil.filterHtmlAttribute(content, attToFilter);
			
			String copyRight = ParamUtil.getString(actionRequest, "copyRight", StringPool.BLANK);
			String author = ParamUtil.getString(actionRequest, "author", StringPool.BLANK);
			String jobTitle = ParamUtil.getString(actionRequest, "jobTitle", StringPool.BLANK);
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");
			int newsType = ParamUtil.getInteger(actionRequest, "newsType");
			boolean allowDiscussion = ParamUtil.getBoolean(actionRequest, "allowDiscussion", false);
			List<String> errors = new ArrayList<String>();			
			
			
			if (validationInput(title, categoryId, content, newsType, errors)
					&& cmd.equals(Constants.UPDATE)
					&& Validator.isNotNull(entry)
					&& Validator.isNotNull(detail)
					&& Validator.isNotNull(dist)
					) {
				//Update content table
				entry.setTitle(title);
				entry.setSubTitle(subTitle);
				entry.setSummary(summary);
				entry.setSubContent(subContent);
				entry.setContent(content);
				entry.setCopyRight(copyRight);
				entry.setAuthor(author);
				entry.setJobTitle(jobTitle);
				entry.setNewsType(newsType);
				entry.setCategoryId(categoryId);
				entry.setModifiedDate(new Date());
				entry.setSmallImageId(fileId);
				entry.setSmallImageUrl(fileName);
				ContentLocalServiceUtil.updateContent(entry);
				
				//update content detail table
				detail.setTitle(title);
				detail.setSubTitle(subTitle);
				detail.setSummary(summary);
				detail.setSubContent(subContent);
				detail.setContent(content);
				detail.setNewsType(newsType);
				detail.setCategoryId(categoryId);
				detail.setModifiedDate(new Date());
				detail.setSmallImageId(fileId);
				detail.setSmallImageUrl(fileName);
				detail.setSubContent(subContent);
				detail.setContent(content);
				ContentDetailLocalServiceUtil.updateContentDetail(detail);
				
				//update distribution table
				
				dist.setAllowDiscussion(allowDiscussion);
				dist.setTitle(title);
				dist.setUserId(userId);
				dist.setUserName(userName);
				dist.setCategoryId(categoryId);
				DistributionLocalServiceUtil.updateDistribution(dist);
			}

			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}
			actionResponse.sendRedirect(redirect);
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
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
				actionResponse.setRenderParameter("mvcPath", "/html/admin/list-content/edit_content.jsp");
			}
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
		} catch (Exception e) {
			_log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	}
	
	public void rewriteContentVersion34(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long curAutoId = ParamUtil.getLong(actionRequest, "autoId");
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			int version = ParamUtil.getInteger(actionRequest, "version");
			int status = ParamUtil.getInteger(actionRequest, "status");
			int newStatus = 16;
			Content curContent = ContentLocalServiceUtil.fetchContent(curAutoId);
			ContentDetail detail = ContentDetailLocalServiceUtil.fetchContentDetail(curAutoId);
			if (curContent != null && detail !=null) {
				if (version > 2) {
					newStatus = 16;
				}
				//xóa bài ở phần bài gửi kiểm duyệt
				/*if((version==3 && status == 128) ||(version==4 && status == 64)) {
					ContentDetailLocalServiceUtil.deleteContentDetail(curAutoId);
					ContentLocalServiceUtil.deleteContent(curAutoId);
				}*/
				ContentLocalServiceUtil.deleteContentByVersion(groupId, curContent.getContentId(), new int[]{3,4});
				ContentDetailLocalServiceUtil.deleteByVersions(groupId, curContent.getContentId(), new int[]{3,4});
				
				List<Content> lstContentV2 = ContentLocalServiceUtil.findByVersions(groupId, curContent.getContentId(), new int[]{2});
				List<ContentDetail> lstContentDetailV2 = ContentDetailLocalServiceUtil.findByVersions(groupId, curContent.getContentId(), new int[]{2});
				if(lstContentV2!=null && lstContentDetailV2!=null){
					long autoId = curAutoId;
					for(Content newContent: lstContentV2){
						newContent.setStatus(newStatus);
						ContentLocalServiceUtil.updateContent(newContent);
						autoId = newContent.getAutoId();
					}
					for(ContentDetail newContentDetail: lstContentDetailV2){
						newContentDetail.setStatus(newStatus);
						ContentDetailLocalServiceUtil.updateContentDetail(newContentDetail);
					}
					actionResponse.setRenderParameter("autoId", String.valueOf(autoId));
				}
				
				actionResponse.setRenderParameter("mvcPath", "/html/admin/list-content/edit_content.jsp");
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
			result = false;
		}
		if (categoryId <= 0) {
			errors.add("you-must-choose-category");
			result = false;
		}
		if (newsType <= 0) {
			errors.add("you-must-choose-news-type");
			result = false;
		}
		if (Validator.isNull(content)) {
			errors.add("empty-content");
			result = false;
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
