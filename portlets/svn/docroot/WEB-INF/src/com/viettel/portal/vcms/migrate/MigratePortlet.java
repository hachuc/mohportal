package com.viettel.portal.vcms.migrate;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.ant.filters.PrefixLines;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.model.Category;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.ContentDetail;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.Legal_Comment;
import com.viettel.portal.vcms.model.Legal_Content;
import com.viettel.portal.vcms.model.Legal_Distribution;
import com.viettel.portal.vcms.model.Legal_Zone;
import com.viettel.portal.vcms.permission.CategoryPermission;
import com.viettel.portal.vcms.service.CategoryLocalServiceUtil;
import com.viettel.portal.vcms.service.CommentLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentDetailLocalService;
import com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_CommentLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_ZoneLocalServiceUtil;

/**
 * Portlet implementation class MigratePortlet
 */
public class MigratePortlet extends MVCPortlet {
	public void MigrateCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			
			List<Legal_Zone> lstZone = Legal_ZoneLocalServiceUtil.getZoneByStatus(true);
			
			List<Category> cats = CategoryLocalServiceUtil.getAllCategories(groupId);
			
			if(Validator.isNotNull(cats) && !cats.isEmpty()){
				for(Category cat : cats){
					CategoryLocalServiceUtil.deleteCategory(cat);
				}
			}
			
			if(Validator.isNotNull(lstZone) && !lstZone.isEmpty()){
				for(Legal_Zone zone : lstZone){
					//add new FAQ Category
					int zoneId = zone.getID();
					int sortOrder = zone.getSortOrder();
					String categoryName = zone.getName();
					String categoryDesc = zone.getDescription();
					ServiceContext serviceContext = ServiceContextFactory.getInstance(Category.class.getName(), actionRequest);
					
					serviceContext.setGroupPermissions(new String[] {CategoryPermission.VIEW});
					serviceContext.setGuestPermissions(new String[] {CategoryPermission.VIEW});
					CategoryLocalServiceUtil.addLegalCategory(companyId, groupId, userId, zoneId, sortOrder,categoryName, 
							categoryDesc, serviceContext);
				}
			}
			
			String ridirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			
			actionResponse.sendRedirect(ridirectURL);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	public void MigrateContent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException{
		try {
			long groupId = PortalUtil.getScopeGroupId(actionRequest);
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			String expandoKey = ParamUtil.getString(actionRequest, "expandoUserKey", "LegalUserID");
			String prefixUrl = ParamUtil.getString(actionRequest, "prefixUrl", StringPool.BLANK);
			ContentLocalServiceUtil.removeAll();
			DistributionLocalServiceUtil.removeAll();
			CommentLocalServiceUtil.deleteAllData();
			ContentDetailLocalServiceUtil.removeAll();
			List<Legal_Zone> lstZone = Legal_ZoneLocalServiceUtil.getZoneByStatus(true);
			for(Legal_Zone zone : lstZone){
				
				//ContentLocalServiceUtil.deleteByCategory(groupId, zone.getID());
				List<Legal_Content> lstLegalContents = Legal_ContentLocalServiceUtil.getLegalContents(zone.getID());
				if(!lstLegalContents.isEmpty()){
					ServiceContext serviceContext = ServiceContextFactory.getInstance(Content.class.getName(), actionRequest);
					ServiceContext detailServiceContext = ServiceContextFactory.getInstance(ContentDetail.class.getName(), actionRequest);
					serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
					
					detailServiceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					detailServiceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
					for(Legal_Content lcontent : lstLegalContents){
						User u01 = null, u02 = null, u03 = null, u04 = null;
						u01 = Validator.isNotNull(lcontent.getAuthor()) ? findUserByExpandoValue(lcontent.getAuthor(), expandoKey): null;
						long createdByUserId = u01!=null ? u01.getUserId() : 0;
						String createByUserName = u01 !=null ? u01.getScreenName() : StringPool.BLANK;
						u02 = Validator.isNotNull(lcontent.getEditor()) ? findUserByExpandoValue(lcontent.getEditor(), expandoKey) : null;
						long editedByUserId = u02!=null ? u02.getUserId() : 0;
						String editedByUserName = u02 !=null ? u02.getScreenName() : StringPool.BLANK;
						u03 =  Validator.isNotNull(lcontent.getApprover()) ? findUserByExpandoValue(lcontent.getApprover(), expandoKey) : null;
						long reviewedByUserId = u03!=null ? u03.getUserId() : 0;
						String reviewedByUserName = u03 !=null ? u03.getScreenName() : StringPool.BLANK;
						u04 = Validator.isNotNull(lcontent.getDeployer()) ? findUserByExpandoValue(lcontent.getDeployer(), expandoKey) : null;
						long approvedByUserId = u04!=null ? u04.getUserId() : 0;
						String approvedByUserName = u04 !=null ? u04.getScreenName() : StringPool.BLANK;
						String smallImageUrl = StringPool.BLANK;
						if(!lcontent.getAvatar().isEmpty())
							smallImageUrl = prefixUrl + lcontent.getAvatar();
						String imageContent = StringPool.BLANK;
						if(!lcontent.getImageUrl().isEmpty())
							imageContent = prefixUrl + lcontent.getImageUrl();
						ContentLocalServiceUtil.addLegalContent(groupId, companyId, userId, userName, 
								lcontent.getID(), lcontent.getContentID(), lcontent.getVersion(), lcontent.getByline(), lcontent.getHeadline(),
								lcontent.getTagline(), lcontent.getTeaser(), lcontent.getBody(), 0L, smallImageUrl, zone.getID(), 
								lcontent.getSource(), lcontent.getStatus(), createdByUserId, createByUserName, 
								editedByUserId, editedByUserName, reviewedByUserId, reviewedByUserName, 
								approvedByUserId, approvedByUserName, lcontent.getAuthors(), StringPool.BLANK, 0,
								imageContent, true, lcontent.getImageDescription(), lcontent.getImageAlign(), 
								lcontent.getCreationDate(), lcontent.getModifiedDate(), serviceContext);
						
						ContentDetailLocalServiceUtil.addLegalContent(groupId, companyId, userId, userName, lcontent.getID(),
								lcontent.getContentID(), lcontent.getVersion(), lcontent.getByline(), lcontent.getHeadline(),
								lcontent.getTagline(), lcontent.getTeaser(), lcontent.getBody(), 0L, lcontent.getAvatar(), zone.getID(),
								lcontent.getStatus(), 0, imageContent, true, lcontent.getImageDescription(), lcontent.getImageAlign(),
								lcontent.getCreationDate(), lcontent.getModifiedDate(), detailServiceContext);
					}
				}
				
				//DistributionLocalServiceUtil.deleteByGroupAndCategory(groupId, zone.getID());
				List<Legal_Distribution> lstDist = Legal_DistributionLocalServiceUtil.getByZone(zone.getID());
				if(!lstDist.isEmpty()){
					
					ServiceContext serviceContext = ServiceContextFactory.getInstance(Distribution.class.getName(), actionRequest);
					serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
					serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
					for(Legal_Distribution dist : lstDist){
						DistributionLocalServiceUtil.addLegalDistribution(groupId, companyId, userId, userName, dist.getID(), dist.getContentID(), dist.getVersion(), StringPool.BLANK, dist.getZoneID(), dist.getAllowDiscussion(), dist.getDistributedDate(), serviceContext);
					}
					
				}
				
				System.out.println("Finish migrate for zone: " + zone.getName());
			}
			
			//Migrate comment
			
			List<Legal_Comment> lstComment = Legal_CommentLocalServiceUtil.getAllComment();
			if(!lstComment.isEmpty()){
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Comment.class.getName(), actionRequest);
				serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
				serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
				for(Legal_Comment comment : lstComment){
					CommentLocalServiceUtil.addLegalComment(groupId, companyId, userId, userName, comment.getCreationDate(), comment.getModifiedDate(), comment.getID(), comment.getDistributionID(), comment.getFullname(),
					comment.getAddress(), comment.getEmail(), comment.getBody(), comment.getVisible(), comment.getIPAddress(), serviceContext);
				}
			}
			System.out.println("Finish migrate for comment");
		}catch(Exception e){
			_log.error(e);
		}
	}
	
	public User findUserByExpandoValue(String md5, String expandoKey) throws SystemException{
		List<User> allUser = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		User resultUser = null;
		if(Validator.isNull(allUser) || allUser.isEmpty())
			return null;
		for(User user : allUser){
			String matchUser = (String) user.getExpandoBridge().getAttribute(expandoKey);
			if(StringUtil.equalsIgnoreCase(md5, matchUser)){
				resultUser = user;
				break;
			}
		}
		return resultUser;
	}
	private Log _log = LogFactory.getLog(MigratePortlet.class.getName());

}
