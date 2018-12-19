package com.viettel.portal.vcms.publisher;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.DistributionVisisted;
import com.viettel.portal.vcms.service.CommentLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionVisistedLocalServiceUtil;

/**
 * Portlet implementation class CMSPublisher
 */
public class CMSPublisher extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			long groupId = PortalUtil.getScopeGroupId(renderRequest);
			long distId = ParamUtil.getLong(renderRequest, "distId", 0);
			String urlTitle = ParamUtil.getString(renderRequest, "urlTitle", StringPool.BLANK);
			//ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			//Locale currentLocale = themeDisplay.getLocale();
			//SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", currentLocale);
			TimeZone timezone = TimeZone.getTimeZone("Asia/Saigon");
			Calendar calendar = Calendar.getInstance(timezone);
			calendar.setTime(new Date());
			DateFormat dateTimeformatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			
			dateTimeformatter.setCalendar(calendar);
			dateTimeformatter.setTimeZone(timezone);
			Date now = new Date();
			//calendar.setTime(now);
			if(distId > 0L && !urlTitle.isEmpty()){
				
				DistributionVisistedLocalServiceUtil.addVisited(groupId, distId, calendar.getTime());
				_log.info("add visisted" + distId + "-" + dateTimeformatter.format(calendar.getTime()));
				
				_log.info("add visisted now" + distId + "-" + calendar.getTime());
				_log.info("add visisted now2" + distId + "-" + now);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		super.render(renderRequest, renderResponse);
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String method = ParamUtil.getString(resourceRequest, "method", null);
		if (Validator.isNotNull(method)) {
			try {

				if (checkCaptcha(resourceRequest)) {
					String fullName = ParamUtil.getString(resourceRequest, "fullName", null);
					String email = ParamUtil.getString(resourceRequest, "email", null);
					String address = ParamUtil.getString(resourceRequest, "address", null);
					String message = ParamUtil.getString(resourceRequest, "message", null);
					long groupId = PortalUtil.getScopeGroupId(resourceRequest);
					long companyId = PortalUtil.getCompanyId(resourceRequest);
					long userId = PortalUtil.getUserId(resourceRequest);
					int distributionId = ParamUtil.getInteger(resourceRequest, "distId", 0);
					String userName = PortalUtil.getUserName(userId, "Guest");
					String ipAddress = PortalUtil.getHttpServletRequest(resourceRequest).getRemoteAddr();
					if(distributionId>0L){
						ServiceContext serviceContext = ServiceContextFactory.getInstance(Comment.class.getName(), resourceRequest);
						serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
						serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
						CommentLocalServiceUtil.addComment(groupId, companyId, userId, userName, 0, distributionId, fullName, address, email, message, false, ipAddress, serviceContext);
					}
					
					
					String esponseErrorCode = "{\"KetQua\": \"1\",\"ErrorCode\": \"200\",\"ErrorMessage\": \"Gửi phản hồi thành công\"}";
					JSONObject array = JSONFactoryUtil.createJSONObject(esponseErrorCode);
					resourceResponse.setContentType("text/html");
					PrintWriter writer = resourceResponse.getWriter();

					writer.print(array.toString());
					writer.flush();
					writer.close();
				}else{
					String esponseErrorCode = "{\"KetQua\": \"2\",\"ErrorCode\": \"201\",\"ErrorMessage\": \"Mã xác thực không đúng\"}";
					JSONObject array = JSONFactoryUtil.createJSONObject(esponseErrorCode);
					resourceResponse.setContentType("text/html");
					PrintWriter writer = resourceResponse.getWriter();

					writer.print(array.toString());
					writer.flush();
					writer.close();
				}
			} catch (Exception ex) {
				_log.error(ex);
			}
		}
		com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	}
	public static boolean checkCaptcha(ResourceRequest request) throws Exception {

		boolean isValidCaptcha = true;

		String enteredCaptchaText = ParamUtil.getString(request, "captchaText");

		PortletSession session = request.getPortletSession();

		String captchaText = getCaptchaValueFromSession(session);

		if (Validator.isNull(captchaText)) {

			isValidCaptcha = false;
		}
		if (!Validator.equals(captchaText, enteredCaptchaText)) {

			isValidCaptcha = false;
			_log.info("Warning: Viettel FAQ Portlet - invalid captcha text!");
		}

		return isValidCaptcha;
	}

	private static String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {

			String name = atNames.nextElement();

			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}

	private static Log _log = LogFactory.getLog(CMSPublisher.class.getName());
}
