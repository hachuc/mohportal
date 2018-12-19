package com.viettel.portal.thongke.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

//import org.hsqldb.lib.HashMap;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.thongke.model.BaiVietNhuanBut;
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.model.PhongBanNhuanButChiTiet;
import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;
import com.viettel.portal.thongke.service.PhongBanLocalServiceUtil;
import com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalServiceUtil;
import com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil;

/**
 * Portlet implementation class QuanLyChamDiem
 */
public class QuanLyChamDiem extends MVCPortlet {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		   ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		   PrintWriter writer = resourceResponse.getWriter();
		   resourceResponse.setContentType("application/text");
		   resourceResponse.setCharacterEncoding("UTF-8");
		   
		   String cmd=ParamUtil.getString(resourceRequest, "cmd");
		   System.out.println("cmd: "+cmd);
		   if(cmd.equals("chamdiemphongban")){
			   String phongBanId=ParamUtil.getString(resourceRequest, "phongBanId");
			   String phongBanIds=themeDisplay.getRequest().getSession().getAttribute("phongBanIds")!=null?themeDisplay.getRequest().getSession().getAttribute("phongBanIds").toString():"";
			   if(!phongBanId.equals("")){
				   if(phongBanId.equals("clear")){
					   phongBanIds="";
				   }else{
					   if(phongBanIds.equals("")){
						   phongBanIds=phongBanId;
					   }
					   else {
						   String []str=phongBanIds.split("\\};\\{");
						   boolean checkExist=false;
						   for(String s:str){
							   if(s.equals(phongBanId)){
								   checkExist=true;break;
							   }
							   else{
								   if(s.substring(0,s.indexOf("},{")).equals(phongBanId.substring(0,phongBanId.indexOf("},{")))){
									   phongBanIds=phongBanIds.replace(s, phongBanId);
									   checkExist=true;break;
								   }
							   }
						   }
						   if(!checkExist)phongBanIds+=";"+phongBanId;
					   }
				   }
				   
			   }
			   
			   themeDisplay.getRequest().getSession().setAttribute("phongBanIds",phongBanIds);
			   if(!phongBanIds.equals("")){
				   writer.println(phongBanIds);
				   writer.flush();
				   writer.close();
			   }
		   }else if(cmd.equals("chamdiembaiviet")){
			   String baiVietId=ParamUtil.getString(resourceRequest, "baiVietId");
			   //System.out.println("baiVietId: "+baiVietId);
			   if(!baiVietId.equals("")){
				   String []str=baiVietId.split("\\},\\{");
				   if(str.length>=8){
					   try{
						   long id=Long.parseLong(str[0].replace("rating_", "").replace("{", ""));
						   ServiceContext serviceContext = ServiceContextFactory.getInstance(BaiVietNhuanBut.class.getName(), resourceRequest);
						   serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
						   serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
						   if(id>0){
							   List<BaiVietNhuanBut>bvnbs=BaiVietNhuanButLocalServiceUtil.getByBaiVietId(id);
							   if(bvnbs!=null && bvnbs.size()>0){
								   BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut(Integer.valueOf(str[7].replace("{", "").replace("}", "")),bvnbs.get(0).getType(),bvnbs.get(0).getId(), bvnbs.get(0).getCompanyId(),bvnbs.get(0).getGroupId() , themeDisplay.getUserId(), PortalUtil.getUserName(themeDisplay.getUserId(), "Guest"), id, str[1].replace("{", "").replace("}", ""), str[2].replace("{", "").replace("}", ""), str[3].replace("{", "").replace("}", ""),dateTimeFormat.parse(str[4].replace("{", "").replace("}", "")) , str[5].replace("{", "").replace("}", ""), Double.valueOf(str[6].replace("{", "").replace("}", "")), serviceContext);
							   }
							   else BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut(Integer.valueOf(str[7].replace("{", "").replace("}", "")),1,themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId() , themeDisplay.getUserId(), PortalUtil.getUserName(themeDisplay.getUserId(), "Guest"), id, str[1].replace("{", "").replace("}", ""), str[2].replace("{", "").replace("}", ""), str[3].replace("{", "").replace("}", ""),dateTimeFormat.parse(str[4].replace("{", "").replace("}", "")) , str[5].replace("{", "").replace("}", ""), Double.valueOf(str[6].replace("{", "").replace("}", "")), serviceContext);
							   writer.println("Xếp hạng thành công bài: "+str[1].replace("{", "").replace("}", ""));
							   writer.flush();
							   writer.close();
							   
						   }
					   }
					   catch(Exception ex){}
				   }
			   }
		   }else if(cmd.equals("chamdiembaivietngoai")){
			   String baiVietId=ParamUtil.getString(resourceRequest, "baiVietId");
			   System.out.println("baiVietId: "+baiVietId);
			   if(!baiVietId.equals("")){
				   String []str=baiVietId.split("\\},\\{");
				   System.out.println("str.length: "+str.length);
				   if(str.length>=8){
					   try{
						   long id=Long.parseLong(str[0].replace("rating_", "").replace("{", ""));
						   ServiceContext serviceContext = ServiceContextFactory.getInstance(BaiVietNhuanBut.class.getName(), resourceRequest);
						   serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
						   serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
						   if(id>0){
							   BaiVietNhuanBut bvnb=BaiVietNhuanButLocalServiceUtil.getBaiVietNhuanBut(id);
							   if(bvnb!=null ){
								   BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut(Integer.valueOf(str[7].replace("{", "").replace("}", "")),bvnb.getType(),bvnb.getId(), bvnb.getCompanyId(),bvnb.getGroupId() , themeDisplay.getUserId(), PortalUtil.getUserName(themeDisplay.getUserId(), "Guest"), 0, str[1].replace("{", "").replace("}", ""), str[2].replace("{", "").replace("}", ""), str[3].replace("{", "").replace("}", ""),dateTimeFormat.parse(str[4].replace("{", "").replace("}", "")) , str[5].replace("{", "").replace("}", ""), Double.valueOf(str[6].replace("{", "").replace("}", "")), serviceContext);
							   }
							   else BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut(Integer.valueOf(str[7].replace("{", "").replace("}", "")),2,themeDisplay.getCompanyId(),themeDisplay.getScopeGroupId() , themeDisplay.getUserId(), PortalUtil.getUserName(themeDisplay.getUserId(), "Guest"), 0, str[1].replace("{", "").replace("}", ""), str[2].replace("{", "").replace("}", ""), str[3].replace("{", "").replace("}", ""),dateTimeFormat.parse(str[4].replace("{", "").replace("}", "")) , str[5].replace("{", "").replace("}", ""), Double.valueOf(str[6].replace("{", "").replace("}", "")), serviceContext);
							   writer.println("Xếp hạng thành công bài: "+str[1].replace("{", "").replace("}", ""));
							   writer.flush();
							   writer.close();
							   
						   }
					   }
					   catch(Exception ex){}
				   }
			   }
		   }
		   
		  
		
		//super.serveResource(resourceRequest, resourceResponse);
	}
	public void updateChamDiemPhongBan(ActionRequest actionRequest,	ActionResponse actionResponse) throws SystemException, PortalException{
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			long menuId = ParamUtil.getLong(uploadPortletRequest, "menuId");
			//String phongBanIds = themeDisplay.getRequest().getSession().getAttribute("phongBanIds")!=null?themeDisplay.getRequest().getSession().getAttribute("phongBanIds").toString():"";
			String phongBanIds = ParamUtil.getString(uploadPortletRequest, "phongBanIds");
			String toDateRating = ParamUtil.getString(uploadPortletRequest, "toDateRating");
			String fromDateRating = ParamUtil.getString(uploadPortletRequest, "fromDateRating");
			long id = ParamUtil.getLong(uploadPortletRequest, "id");
			String phongBanIdKhoiTaos = ParamUtil.getString(uploadPortletRequest, "phongBanIdKhoiTaos");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(PhongBan.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			String caption=ParamUtil.getString(uploadPortletRequest, "caption");
			boolean status = ParamUtil.getBoolean(actionRequest, "status", true);
			if(caption.equals(""))caption="Xếp hạng phòng ban";
			//System.out.println("phongBanIds: "+phongBanIds);
			//System.out.println("toDateRating: "+toDateRating);
			//System.out.println("fromDateRating: "+fromDateRating);
			String redirectURL = ParamUtil.getString(actionRequest,	"redirectURL");
            Date toDate=null,fromDate=null;
            try{
            	toDate=dateFormat.parse(toDateRating);
            	fromDate=dateFormat.parse(fromDateRating);
            }
            catch(Exception ex){
            	
            }
            PhongBanNhuanBut phongBanNhuanBut=null;
			if(id>0){
				phongBanNhuanBut=PhongBanNhuanButLocalServiceUtil.updatePhongBanNhuanBut(id, companyId, groupId, userId, userName, caption, fromDate, toDate, status, serviceContext); 
			}
			else{
				phongBanNhuanBut=PhongBanNhuanButLocalServiceUtil.addPhongBanNhuanBut(companyId, groupId, userId, userName, caption, fromDate, toDate, status, serviceContext);
			}
			if(phongBanNhuanBut!=null){
				List<PhongBanNhuanButChiTiet>pbnbcts= PhongBanNhuanButChiTietLocalServiceUtil.getByPhongBanNhuanButId(phongBanNhuanBut.getId());
			    if(pbnbcts!=null && pbnbcts.size()>0){
			    	for(PhongBanNhuanButChiTiet pbnbct:pbnbcts){
			    		PhongBanNhuanButChiTietLocalServiceUtil.deletePhongBanNhuanButChiTiet(pbnbct);
			    	}
			    }
			    if(!phongBanIdKhoiTaos.equals("")){
			    	if(!phongBanIds.equals(""))phongBanIds+=";"+phongBanIdKhoiTaos;
			    	else phongBanIds=phongBanIdKhoiTaos;
			    }
			    if(!phongBanIds.equals("")){
			    	HashMap<String,String>hs=new HashMap<String,String>();
					String []str=phongBanIds.split("\\};\\{");
					   for(String s:str){
						   String []s1=s.split("\\},\\{");
						   if(s1.length>=4){
							   if(!hs.containsKey(s1[0].replace("rating_", "").replace("{", "").replace("}", ""))){
								   hs.put(s1[0].replace("rating_", "").replace("{", "").replace("}", ""), "1");
								   PhongBanNhuanButChiTietLocalServiceUtil.addPhongBanNhuanButChiTiet(phongBanNhuanBut.getId(),Long.valueOf(s1[0].replace("rating_", "").replace("{", "").replace("}", "")) , s1[1].replace("{", "").replace("}", ""), s1[2].replace("{", "").replace("}", ""), Double.valueOf(s1[3].replace("{", "").replace("}", "")), serviceContext);
							   }
							   
						   }
					   }
				}
			}
			
			themeDisplay.getRequest().getSession().setAttribute("phongBanIds","");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				try {
					actionResponse.sendRedirect(redirectURL);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	public void deleteChamDiemPhongBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException, PortalException{
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			if (id > 0) {
				List<PhongBanNhuanButChiTiet>pbnbcts= PhongBanNhuanButChiTietLocalServiceUtil.getByPhongBanNhuanButId(id);
			    if(pbnbcts!=null && pbnbcts.size()>0){
			    	for(PhongBanNhuanButChiTiet pbnbct:pbnbcts){
			    		PhongBanNhuanButChiTietLocalServiceUtil.deletePhongBanNhuanButChiTiet(pbnbct);
			    	}
			    }
			    PhongBanNhuanButLocalServiceUtil.deletePhongBanNhuanBut(id);
			}

			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void deleteChamDiemBaiViet(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException, PortalException{
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			if (id > 0) {
				BaiVietNhuanButLocalServiceUtil.deleteBaiVietNhuanBut(id);
			}
			long menuId = ParamUtil.getLong(actionRequest, "menuId");
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void deleteChamDiemBaiVietNgoai(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException, PortalException{
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			if (id > 0) {
				BaiVietNhuanButLocalServiceUtil.deleteBaiVietNhuanBut(id);
			}
			long menuId = ParamUtil.getLong(actionRequest, "menuId");
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}

		} catch (Exception e) {
			_log.error(e);
		}
	}
	public void updateChamDiemBaiViet(ActionRequest actionRequest,	ActionResponse actionResponse) throws SystemException, PortalException{
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
		if (Validator.isNotNull(redirectURL)) {
			try {
				actionResponse.sendRedirect(redirectURL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_log.error(e);
			}
		}
	}
public void updateChamDiemBaiVietNgoai(ActionRequest actionRequest,	ActionResponse actionResponse) throws SystemException, PortalException{
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest = PortalUtil
					.getUploadPortletRequest(actionRequest);
			long companyId = PortalUtil.getCompanyId(uploadPortletRequest);
			long groupId = PortalUtil.getScopeGroupId(uploadPortletRequest);
			long userId = PortalUtil.getUserId(uploadPortletRequest);
			String userName = PortalUtil.getUserName(userId, "Guest");
			long menuId = ParamUtil.getLong(uploadPortletRequest, "menuId");
			
			String tieuDe = ParamUtil.getString(uploadPortletRequest, "tieuDe");
			String tacGia = ParamUtil.getString(uploadPortletRequest, "tacGia");
			String ngayXuatBans= ParamUtil.getString(uploadPortletRequest, "ngayXuatBan");
			String ratings=ParamUtil.getString(uploadPortletRequest, "rating");
			String loaiBaiViet=ParamUtil.getString(uploadPortletRequest, "loaiBaiViet","1");
			String typeNewsValuesPrice=ParamUtil.getString(uploadPortletRequest, "typeNewsValuesPrice");
			double ratingValue=0;
			String str[]=typeNewsValuesPrice.split(";");
			if(str.length>0){
				for(String s :str){
					if(s.substring(0,s.indexOf(",")).equals(loaiBaiViet)){
						ratingValue=Double.valueOf(s.substring(s.indexOf(",")+1));
					}
				}
			}
			str=ratings.split(";");
			String rating="";
			
			if(str.length>=2){
				rating=str[1];
				ratingValue=(long)(Double.parseDouble(str[0])*ratingValue/100);
			}
			long id = ParamUtil.getLong(uploadPortletRequest, "id");
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(PhongBan.class.getName(), actionRequest);
			serviceContext.setGroupPermissions(new String[] { ActionKeys.VIEW });
			serviceContext.setGuestPermissions(new String[] { ActionKeys.VIEW });
			
			String redirectURL = ParamUtil.getString(actionRequest,	"redirectURL");
            Date ngayXuatBan=null;
            try{
            	ngayXuatBan=dateFormat.parse(ngayXuatBans);
           	}
            catch(Exception ex){
            	ngayXuatBan=new Date();
            }
            if(!tieuDe.equals("") && !tacGia.equals("")){
            	if(id>0){
            		BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut(Integer.parseInt(loaiBaiViet),2,id, companyId, groupId, userId, userName, 0, tieuDe, tacGia, "", ngayXuatBan, rating, ratingValue, serviceContext);
    			}
    			else{
    				BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut(Integer.parseInt(loaiBaiViet),2,companyId, groupId, userId, userName, 0, tieuDe, tacGia, "", ngayXuatBan, rating, ratingValue, serviceContext);
    			}
    			
            }
			
			
			if (Validator.isNotNull(redirectURL)) {
				actionResponse.sendRedirect(redirectURL);
			}
		}
		catch(Exception e){
			
			String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

			if (Validator.isNotNull(redirectURL)) {
				try {
					actionResponse.sendRedirect(redirectURL);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	private final static Log _log = LogFactoryUtil
			.getLog(QuanLyChamDiem.class);
	public static void main(String args[]){
		String str="1";
		String s[]=str.split(";");
		System.out.println(s.length);
	}
}
