package com.viettel.portal.thongke.action;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.persistence.PortletUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.thongke.model.BaiVietNhuanBut;
import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaoCaoThongKe extends MVCPortlet{
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String keywords = ParamUtil.getString(uploadPortletRequest, "keywords","");
		String fromDate = ParamUtil.getString(uploadPortletRequest, "fromDate","");
		String toDate = ParamUtil.getString(uploadPortletRequest, "toDate","");
		String fileName = ParamUtil.getString(uploadPortletRequest, "fileName","");
		String filePath=request.getPortletSession().getPortletContext().getRealPath("")+"/file-reports/"+fileName;
		System.out.println("filePath: "+filePath);
		Date fDate=null;
		Date tDate=null;
		if(!fromDate.equals("")){
			try{
				fDate=dft.parse(fromDate);
			}
			catch(Exception ex){}
		}
		if(!toDate.equals("")){
			try{
				tDate=dft.parse(toDate);
			}
			catch(Exception ex){}
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			
			byte[]result = createExcelTongHopTinBaiCanBo(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);	
			
			/*HttpServletResponse httpResponse = PortalUtil
					.getHttpServletResponse(response);
			httpResponse.setHeader("Content-disposition",
					"attachment; filename=\"" + "baocao-user.xlsx"
							+ "\"");
			httpResponse.setHeader("Content-Transfer-Encoding", "binary");
			httpResponse.setContentType( "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			 */
			//httpResponse.setContentType("application/vnd.ms-excel");
			resourceResponse.setProperty("Content-disposition", "attachment; filename=\"" + "Bao_cao_thong_ke.xlsx" + "\"");
			resourceResponse.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,"max-age=3600,must-revalidate");
			try {
				resourceResponse.flushBuffer();
				OutputStream out = resourceResponse.getPortletOutputStream();
				out.write(result);
				
				out.flush();
				out.close();
			} catch (Exception e) {
			} finally {
			}
			//response.sendRedirect(themeDisplay.getURLPortal()+"/Cms-EcoIT-portlet/html/baocao-user.xlsx");
		} catch (Exception ex) {
			//response.sendRedirect(themeDisplay.getURLPortal());
		}
		
	}
	SimpleDateFormat dft=new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat dftSql=new SimpleDateFormat("yyyy-MM-dd");
	public byte[] createExcelTongHopTinBaiCanBo(String filePath,int type,Long groupId, String keyword,Date fromDate,Date toDate) throws Exception{
		String sql=" groupId="+groupId;
		if(type>0)sql+=" and type_="+type;
		if(!keyword.equals(""))sql+=" and (tacGia like '%"+keyword+"%' or tieuDe like '%"+keyword+"%')";
		if(fromDate!=null){
			sql += " AND datediff(day,'"+dftSql.format(fromDate)+"',ngayXuatBan)>=0 "; 
		}
		if(toDate!=null){
			sql += " AND datediff(day, ngayXuatBan,'"+dftSql.format(toDate)+"')>=0 "; 
		}
		String sqlFull="select tacGia,sum(TinMoiViet)TinMoiViet,sum(BaiMoiViet)BaiMoiViet,sum(TinKhaiThac)TinKhaiThac,sum(BaiKhaiThac)BaiKhaiThac,sum(ratingValue) ratingValue from  (select tacGia,count(loaiBaiViet) TinMoiViet,0 BaiMoiViet,0 TinKhaiThac,0 BaiKhaiThac,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=1 "+" and "+sql;
		sqlFull+=" group by tacGia  union  select tacGia,0 TinMoiViet,count(loaiBaiViet) BaiMoiViet,0 TinKhaiThac,0 BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=2 "+" and "+sql;
		sqlFull+=" group by tacGia  union  select tacGia,0 TinMoiViet,0 BaiMoiViet,count(loaiBaiViet) TinKhaiThac,0 BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=3 "+" and "+sql;
		sqlFull+=" group by tacGia  union  select tacGia,0 TinMoiViet,0 BaiMoiViet,0 TinKhaiThac,count(loaiBaiViet) BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=4 "+" and "+sql;
		sqlFull+=" group by tacGia  )A group by tacGia order by tacGia asc";
		List<Object> listC = BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButBySQL(sqlFull, -1, -1);
		
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//Create Header
		XSSFFont fontHeader1 = (XSSFFont) wb.createFont();
	    fontHeader1.setFontHeight(16);
		XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
	    style.setAlignment(HorizontalAlignment.CENTER);
	    style.setVerticalAlignment(VerticalAlignment.CENTER);
	    style.setFont(fontHeader1);
		if(fromDate!=null){
			if(toDate==null){
				XSSFRow rowhead = sheet.createRow((short) 1);
				rowhead.createCell((short)0).setCellValue("Từ ngày "+dft.format(fromDate));
				rowhead.getCell(0).setCellStyle(style);
			}
			else{
				if(fromDate!=toDate){
					XSSFRow rowhead = sheet.createRow((short) 1);
					rowhead.createCell((short)0).setCellValue("Từ ngày "+dft.format(fromDate) +" đến ngày "+dft.format(toDate));
					rowhead.getCell(0).setCellStyle(style);
				}
				else{
					XSSFRow rowhead = sheet.createRow((short) 1);
					rowhead.createCell((short)0).setCellValue("Ngày "+dft.format(fromDate));
					rowhead.getCell(0).setCellStyle(style);
				}
			}
		}
		else{
			if(toDate!=null){
				XSSFRow rowhead = sheet.createRow((short) 1);
				rowhead.createCell((short)0).setCellValue("đến ngày "+dft.format(toDate));
				rowhead.getCell(0).setCellStyle(style);
			}
		}
		//
		for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+3);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[0]));
			row.createCell((short)2).setCellValue(Long.valueOf(String.valueOf(c[1])));
			row.createCell((short)3).setCellValue(Long.valueOf(String.valueOf(c[2])));
			row.createCell((short)4).setCellValue(Long.valueOf(String.valueOf(c[3])));
			row.createCell((short)5).setCellValue(Long.valueOf(String.valueOf(c[4])));
		}	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
		    wb.write(bos);
		} finally {
		    bos.close();
		}
		byte[] result = bos.toByteArray();
		return result;
	}
	public void reportExcel(ActionRequest request, ActionResponse response)
			throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String keywords = ParamUtil.getString(uploadPortletRequest, "keywords","");
		String fromDate = ParamUtil.getString(uploadPortletRequest, "fromDate","");
		String toDate = ParamUtil.getString(uploadPortletRequest, "toDate","");
		String fileName = ParamUtil.getString(uploadPortletRequest, "fileName","");
		String filePath=request.getPortletSession().getPortletContext().getRealPath("")+"/file-reports/"+fileName;
		System.out.println("filePath: "+filePath);
		Date fDate=null;
		Date tDate=null;
		if(!fromDate.equals("")){
			try{
				fDate=dft.parse(fromDate);
			}
			catch(Exception ex){}
		}
		if(!toDate.equals("")){
			try{
				tDate=dft.parse(toDate);
			}
			catch(Exception ex){}
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			
			byte[]result = createExcelTongHopTinBaiCanBo(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);	
			
			HttpServletResponse httpResponse = PortalUtil
					.getHttpServletResponse(response);
			httpResponse.setHeader("Content-disposition",
					"attachment; filename=\"" + "baocao-user.xlsx"
							+ "\"");
			httpResponse.setHeader("Content-Transfer-Encoding", "binary");
			httpResponse.setContentType( "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			 
			//httpResponse.setContentType("application/vnd.ms-excel");
			try {
				httpResponse.flushBuffer();
				OutputStream out = httpResponse.getOutputStream();
				out.write(result);
				
				out.flush();
				out.close();
			} catch (Exception e) {
			} finally {
			}
			//response.sendRedirect(themeDisplay.getURLPortal()+"/Cms-EcoIT-portlet/html/baocao-user.xlsx");
		} catch (Exception ex) {
			response.sendRedirect(themeDisplay.getURLPortal());
		}
		
	}
}
