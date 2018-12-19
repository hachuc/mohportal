package com.viettel.portal.thongke.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Param;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;
import com.viettel.portal.thongke.service.ContentProfitLocalService;
import com.viettel.portal.thongke.service.ContentProfitLocalServiceUtil;

/**
 * Portlet implementation class BaoCaoNhuanBut
 */
public class BaoCaoNhuanBut extends MVCPortlet {
	SimpleDateFormat dft=new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat dftSql=new SimpleDateFormat("yyyy-MM-dd");
	public byte[] createExcelTongHopNhuanBut(String filePath,int type,Long groupId, String keyword,Date fromDate,Date toDate) throws Exception{
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
		int firstRow=3;
		for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+firstRow);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[0]));
			row.createCell((short)2).setCellValue(Long.valueOf(String.valueOf(c[1])));
			row.createCell((short)3).setCellValue(Long.valueOf(String.valueOf(c[2])));
			row.createCell((short)4).setCellValue(Long.valueOf(String.valueOf(c[3])));
			row.createCell((short)5).setCellValue(Long.valueOf(String.valueOf(c[4])));
			row.createCell((short)6).setCellValue(Double.valueOf(String.valueOf(c[5])));
		}	
		if(listC.size()>0){
			XSSFCellStyle styleFooter = (XSSFCellStyle) wb.createCellStyle();
			styleFooter.setBorderTop(XSSFCellStyle.BORDER_THIN);
			styleFooter.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleFooter.setAlignment(HorizontalAlignment.RIGHT);
			styleFooter.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(listC.size()+firstRow);
			for(int i=0;i<7;i++)row.createCell(i).setCellStyle(styleFooter);
			row.getCell(5).setCellValue("Tổng tiền");
			row.getCell(6).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			row.getCell(6).setCellFormula("SUM(G"+(firstRow+1)+":G"+(listC.size()+firstRow)+")");
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
	public byte[] createExcelTongHopThuLaoBoPhan(String filePath,int type,Long groupId, String keyword,Date fromDate,Date toDate) throws Exception{
		/*String sql=" groupId="+groupId;
		if(type>0)sql+=" and type_="+type;
		if(!keyword.equals(""))sql+=" and (tacGia like '%"+keyword+"%' or tieuDe like '%"+keyword+"%')";
		if(fromDate!=null){
			sql += " AND datediff(day,'"+dftSql.format(fromDate)+"',ngayXuatBan)>=0 "; 
		}
		if(toDate!=null){
			sql += " AND datediff(day, ngayXuatBan,'"+dftSql.format(toDate)+"')>=0 "; 
		}
		String sqlFull="select CONVERT(varchar, ngayXuatBan,103)ngayXuatBan,sum(TinMoiViet)TinMoiViet,sum(BaiMoiViet)BaiMoiViet,sum(TinKhaiThac)TinKhaiThac,sum(BaiKhaiThac)BaiKhaiThac,sum(ratingValue) ratingValue from  (select CONVERT(date, ngayXuatBan)ngayXuatBan,count(loaiBaiViet) TinMoiViet,0 BaiMoiViet,0 TinKhaiThac,0 BaiKhaiThac,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=1 "+" and "+sql;
		sqlFull+=" group by CONVERT(date, ngayXuatBan)  union  select CONVERT(date, ngayXuatBan)ngayXuatBan,0 TinMoiViet,count(loaiBaiViet) BaiMoiViet,0 TinKhaiThac,0 BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=2 "+" and "+sql;
		sqlFull+=" group by CONVERT(date, ngayXuatBan)  union  select CONVERT(date, ngayXuatBan)ngayXuatBan,0 TinMoiViet,0 BaiMoiViet,count(loaiBaiViet) TinKhaiThac,0 BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=3 "+" and "+sql;
		sqlFull+=" group by CONVERT(date, ngayXuatBan)  union  select CONVERT(date, ngayXuatBan)ngayXuatBan,0 TinMoiViet,0 BaiMoiViet,0 TinKhaiThac,count(loaiBaiViet) BaiKhaiThac ,sum(ratingValue) ratingValue from portal_baivietnhuanbut  where loaiBaiViet=4 "+" and "+sql;
		sqlFull+=" group by CONVERT(date, ngayXuatBan)  )A group by ngayXuatBan order by ngayXuatBan asc";
		List<Object> listC = BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButBySQL(sqlFull, -1, -1);*/
		
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
		int firstRow=3;
		/*for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+firstRow);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[0]));
			row.createCell((short)2).setCellValue(Long.valueOf(String.valueOf(c[1])));
			row.createCell((short)3).setCellValue(Long.valueOf(String.valueOf(c[2])));
			row.createCell((short)4).setCellValue(Long.valueOf(String.valueOf(c[3])));
			row.createCell((short)5).setCellValue(Long.valueOf(String.valueOf(c[4])));
			row.createCell((short)6).setCellValue(Double.valueOf(String.valueOf(c[5])));
		}	*/
		/*if(listC.size()>0){
			XSSFCellStyle styleFooter = (XSSFCellStyle) wb.createCellStyle();
			styleFooter.setBorderTop(XSSFCellStyle.BORDER_THIN);
			styleFooter.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleFooter.setAlignment(HorizontalAlignment.RIGHT);
			styleFooter.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(listC.size()+firstRow);
			for(int i=0;i<7;i++)row.createCell(i).setCellStyle(styleFooter);
			row.getCell(5).setCellValue("Tổng tiền");
			row.getCell(6).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			row.getCell(6).setCellFormula("SUM(G"+(firstRow+1)+":G"+(listC.size()+firstRow)+")");
		}*/
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
		    wb.write(bos);
		} finally {
		    bos.close();
		}
		byte[] result = bos.toByteArray();
		return result;
	}
	public byte[] createExcelBangKeNhuanButNgay(String filePath,int type,Long groupId, Date fromDate) throws Exception{
		String sql=" groupId="+groupId;
		if(type>0)sql+=" and type_="+type;
		if(fromDate!=null){
			sql += " AND datediff(day,'"+dftSql.format(fromDate)+"',ngayXuatBan)=0 "; 
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
	    fontHeader1.setFontHeight(20);
		XSSFCellStyle style = (XSSFCellStyle) wb.createCellStyle();
	    style.setAlignment(HorizontalAlignment.CENTER);
	    style.setVerticalAlignment(VerticalAlignment.CENTER);
	    style.setFont(fontHeader1);
	    XSSFRow rowhead1 = sheet.createRow((short) 0);
		rowhead1.createCell((short)0).setCellValue("Tổng hợp nhuận bút ngày "+dft.format(fromDate));
		rowhead1.getCell(0).setCellStyle(style);
		//
		int firstRow=2;
		for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+firstRow);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[0]));
			row.createCell((short)2).setCellValue(Long.valueOf(String.valueOf(c[1])));
			row.createCell((short)3).setCellValue(Long.valueOf(String.valueOf(c[2])));
			row.createCell((short)4).setCellValue(Long.valueOf(String.valueOf(c[3])));
			row.createCell((short)5).setCellValue(Long.valueOf(String.valueOf(c[4])));
			row.createCell((short)6).setCellValue(Double.valueOf(String.valueOf(c[5])));
		}	
		if(listC.size()>0){
			XSSFCellStyle styleFooter = (XSSFCellStyle) wb.createCellStyle();
			styleFooter.setBorderTop(XSSFCellStyle.BORDER_THIN);
			styleFooter.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleFooter.setAlignment(HorizontalAlignment.RIGHT);
			styleFooter.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(listC.size()+firstRow);
			for(int i=0;i<7;i++)row.createCell(i).setCellStyle(styleFooter);
			row.getCell(5).setCellValue("Tổng tiền");
			row.getCell(6).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			row.getCell(6).setCellFormula("SUM(G"+(firstRow+1)+":G"+(listC.size()+firstRow)+")");
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
	public byte[] createExcelBangKeNhuanButCaNhan(String typeNewsString,String filePath,int type,Long groupId, String keyword,Date fromDate,Date toDate) throws Exception{
		String sql=" groupId="+groupId;
		if(type>0)sql+=" and type_="+type;
		if(!keyword.equals(""))sql+=" and tacGia like '%"+keyword+"%' ";
		if(fromDate!=null){
			sql += " AND datediff(day,'"+dftSql.format(fromDate)+"',ngayXuatBan)>=0 "; 
		}
		if(toDate!=null){
			sql += " AND datediff(day, ngayXuatBan,'"+dftSql.format(toDate)+"')>=0 "; 
		}
		String sqlFull="select tacGia,tieuDe,ngayXuatBan,loaiBaiViet,rating,ratingValue from portal_baivietnhuanbut  where  "+sql;
		List<Object> listC = BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButBySQL(sqlFull, -1, -1);
		Map<String,String>hs=new HashMap<String,String>();
		if(!typeNewsString.equals("")){
			String str[]=typeNewsString.split(";");
			for(String s:str){
				if(!hs.containsKey(s.substring(0,s.indexOf(","))))hs.put(s.substring(0,s.indexOf(",")), s.substring(s.indexOf(",")+1));
			}
		}
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//Create Header
		XSSFFont fontHeader1 = (XSSFFont) wb.createFont();
	    fontHeader1.setFontHeight(16);
		XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
	    style1.setAlignment(HorizontalAlignment.CENTER);
	    style1.setVerticalAlignment(VerticalAlignment.CENTER);
	    style1.setFont(fontHeader1);
	    XSSFFont fontHeader2 = (XSSFFont) wb.createFont();
	    fontHeader2.setFontHeight(20);
	    XSSFCellStyle style2 = (XSSFCellStyle) wb.createCellStyle();
	    style2.setVerticalAlignment(VerticalAlignment.CENTER);
	    style2.setFont(fontHeader2);
		if(fromDate!=null){
			if(toDate==null){
				XSSFRow rowhead = sheet.createRow((short) 1);
				rowhead.createCell((short)0).setCellValue("Từ ngày "+dft.format(fromDate));
				rowhead.getCell(0).setCellStyle(style1);
			}
			else{
				if(fromDate!=toDate){
					XSSFRow rowhead = sheet.createRow((short) 1);
					rowhead.createCell((short)0).setCellValue("Từ ngày "+dft.format(fromDate) +" đến ngày "+dft.format(toDate));
					rowhead.getCell(0).setCellStyle(style1);
				}
				else{
					XSSFRow rowhead = sheet.createRow((short) 1);
					rowhead.createCell((short)0).setCellValue("Ngày "+dft.format(fromDate));
					rowhead.getCell(0).setCellStyle(style1);
				}
			}
		}
		else{
			if(toDate!=null){
				XSSFRow rowhead = sheet.createRow((short) 1);
				rowhead.createCell((short)0).setCellValue("đến ngày "+dft.format(toDate));
				rowhead.getCell(0).setCellStyle(style1);
			}
		}
		if(listC.size()>0){
			XSSFRow rowhead1 = sheet.createRow((short) 2);
			rowhead1.createCell((short)0).setCellValue("Tác giả: "+String.valueOf(((Object[])listC.get(0))[0]));
			rowhead1.getCell(0).setCellStyle(style2);
		}
		
		
		//
		int firstRow=4;
		for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+firstRow);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[1]));
			row.createCell((short)2).setCellValue(dft.format(c[2]));
			if(hs.containsKey(String.valueOf(c[3])))row.createCell((short)3).setCellValue(hs.get(String.valueOf(c[3])));
			else row.createCell((short)3).setCellValue(String.valueOf(c[3]));
			row.createCell((short)4).setCellValue(String.valueOf(c[4]));
			row.createCell((short)5).setCellValue(Double.valueOf(String.valueOf(c[5])));
		}	
		if(listC.size()>0){
			XSSFCellStyle styleFooter = (XSSFCellStyle) wb.createCellStyle();
			styleFooter.setBorderTop(XSSFCellStyle.BORDER_THIN);
			styleFooter.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleFooter.setAlignment(HorizontalAlignment.RIGHT);
			styleFooter.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(listC.size()+firstRow);
			for(int i=0;i<7;i++)row.createCell(i).setCellStyle(styleFooter);
			row.getCell(4).setCellValue("Tổng tiền");
			row.getCell(5).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			row.getCell(5).setCellFormula("SUM(F"+(firstRow+1)+":F"+(listC.size()+firstRow)+")");
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
	public byte[] createExcelBangKeNhuanBut(String filePath,Long groupId, String fromDate, String toDate, Long tinBai, Long tacGia) throws IOException, JSONException, SystemException{
		
		List listObj = ContentProfitLocalServiceUtil.findNhuanBut(groupId, fromDate, toDate, tinBai, tacGia);
		
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//Create Header
		XSSFFont fontHeader1 = (XSSFFont) wb.createFont();
	    fontHeader1.setFontHeight(16);
		XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
	    style1.setAlignment(HorizontalAlignment.CENTER);
	    style1.setVerticalAlignment(VerticalAlignment.CENTER);
	    style1.setFont(fontHeader1);
	    XSSFFont fontHeader2 = (XSSFFont) wb.createFont();
	    fontHeader2.setFontHeight(20);
	    XSSFCellStyle style2 = (XSSFCellStyle) wb.createCellStyle();
	    style2.setVerticalAlignment(VerticalAlignment.CENTER);
	    style2.setFont(fontHeader2);

	    XSSFCellStyle style3 = (XSSFCellStyle) wb.createCellStyle();
	    style3.setBorderBottom(CellStyle.BORDER_THIN);
	    style3.setBorderLeft(CellStyle.BORDER_THIN);
	    style3.setBorderRight(CellStyle.BORDER_THIN);
	    style3.setBorderTop(CellStyle.BORDER_THIN);
	    String serilizeString=null;
		JSONArray nhuanBut = null;
		int firstRow=7;
		int stt=0;
		long totalSa =0;
		for(Object nhuanbutObject:listObj){
		serilizeString=JSONFactoryUtil.serialize(nhuanbutObject);
		nhuanBut =JSONFactoryUtil.createJSONArray(serilizeString);
	    
			XSSFRow row = sheet.createRow((short) ++firstRow);
			row.createCell((short)0).setCellValue(++stt);
			row.createCell((short)1).setCellValue(nhuanBut.getString(0));
			row.createCell((short)2).setCellValue(nhuanBut.getString(1));
			
				String temp = nhuanBut.getString(4).substring(0,10);
				String time[] = temp.split("\\-");
				String timePublish ="";
				if(time.length>2){
						timePublish =time[2]+"/"+time[1]+"/"+time[0];
				}
			row.createCell((short)3).setCellValue(timePublish);
			row.createCell((short)4).setCellValue(nhuanBut.getString(3));
			row.createCell((short)5).setCellValue(Long.valueOf(nhuanBut.getString(2)));
			//Border
			totalSa += Long.valueOf(nhuanBut.getString(2));
			row.getCell((short)0).setCellStyle(style3);
			row.getCell((short)1).setCellStyle(style3);
			row.getCell((short)2).setCellStyle(style3);
			row.getCell((short)3).setCellStyle(style3);
			row.getCell((short)4).setCellStyle(style3);
			row.getCell((short)5).setCellStyle(style3);
		}
		//Thành tiền nhuận bút
	    XSSFRow row2 = sheet.getRow((short)6);
	    row2.getCell((short)1).setCellValue(totalSa);
	   //Ngày xuất báo cáo
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String day = dateFormat.format(date);
        row2.getCell((short)8).setCellValue(day);
	    //Tác giả
	    XSSFRow row3 = sheet.getRow((short)3);
	    if(tacGia<1){
	    	row3.getCell((short)1).setCellValue("Tất cả");
	    }else{
	    	 List<User> listUsers = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
         	for(User userObj: listUsers){
         		if(userObj.getUserId()==tacGia){
         			row3.getCell((short)1).setCellValue(userObj.getFullName());
         		}
         	}
	    }
	    //Từ ngày
	    XSSFRow row4 = sheet.getRow((short)5);
	    row4.getCell((short)1).setCellValue(fromDate);
	    //Đến Ngày
	    row4.createCell((short)3).setCellValue(toDate);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
		    wb.write(bos);
		} finally {
		    bos.close();
		}
		byte[] result = bos.toByteArray();
		return result;
	}
	public byte[] createExcelBangKeThanhToanTongHop(String filePath,int type,Long groupId, String thang,String nam) throws Exception{
		String sql=" groupId="+groupId;
		if(type>0)sql+=" and type_="+type;
		if(!thang.equals("")){
			sql += " AND month(ngayXuatBan)="+thang; 
		}
		if(!nam.equals("")){
			sql += " AND year(ngayXuatBan)= "+nam; 
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
	    fontHeader1.setFontHeight(20);
		XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
	    style1.setAlignment(HorizontalAlignment.CENTER);
	    style1.setVerticalAlignment(VerticalAlignment.CENTER);
	    style1.setFont(fontHeader1);
	    
		
		XSSFRow rowhead1 = sheet.createRow((short) 0);
		rowhead1.createCell((short)0).setCellValue("Bảng kê thanh toán tổng hợp tháng "+thang+"/"+nam);
		rowhead1.getCell(0).setCellStyle(style1);
	
		
		int firstRow=2;
		//
		for (int i=0; i<listC.size();i++) {
			Object[] c = (Object[])listC.get(i);
			XSSFRow row = sheet.createRow((short) i+firstRow);
			row.createCell((short)0).setCellValue(i+1);
			row.createCell((short)1).setCellValue(String.valueOf(c[0]));
			row.createCell((short)2).setCellValue(Long.valueOf(String.valueOf(c[1])));
			row.createCell((short)3).setCellValue(Long.valueOf(String.valueOf(c[2])));
			row.createCell((short)4).setCellValue(Long.valueOf(String.valueOf(c[3])));
			row.createCell((short)5).setCellValue(Long.valueOf(String.valueOf(c[4])));
			row.createCell((short)6).setCellValue(Double.valueOf(String.valueOf(c[5])));
		}	
		if(listC.size()>0){
			XSSFCellStyle styleFooter = (XSSFCellStyle) wb.createCellStyle();
			styleFooter.setBorderTop(XSSFCellStyle.BORDER_THIN);
			styleFooter.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleFooter.setAlignment(HorizontalAlignment.RIGHT);
			styleFooter.setVerticalAlignment(VerticalAlignment.CENTER);
			XSSFRow row = sheet.createRow(listC.size()+firstRow);
			for(int i=0;i<7;i++)row.createCell(i).setCellStyle(styleFooter);
			row.getCell(5).setCellValue("Tổng tiền");
			row.getCell(6).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			row.getCell(6).setCellFormula("SUM(G"+(firstRow+1)+":G"+(listC.size()+firstRow)+")");
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
	//ReportExcel 
	public void reportExcel(ActionRequest request, ActionResponse response)
			throws Exception {
		//UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String keywords = ParamUtil.getString(request, "keywords","");
		//Export excel
		String fromDate = ParamUtil.getString(request, "exfromDate","");
		String toDate = ParamUtil.getString(request, "exDate","");
		String fileName = ParamUtil.getString(request, "fileName","");
		long tinBai = ParamUtil.getLong(request, "tinBai", 0l);
		long tacGia = ParamUtil.getLong(request, "tacGia", 0l);
		String typeNewsString = ParamUtil.getString(request, "typeNewsString","");
		String thang = ParamUtil.getString(request, "thang","");
		String nam = ParamUtil.getString(request, "nam","");
		String filePath=request.getPortletSession().getPortletContext().getRealPath("")+"/file-reports/"+fileName;
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
			
			byte[]result = null;
			if(fileName.equals("bang_ke_nhuan_but_ca_nhan.xlsx"))result=createExcelBangKeNhuanButCaNhan(typeNewsString,filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);
			else if(fileName.equals("tong_hop_nhuan_but.xlsx"))result=createExcelTongHopNhuanBut(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);	
			else if(fileName.equals("bang_ke_thanh_toan_tong_hop.xlsx"))result=createExcelBangKeThanhToanTongHop(filePath,0,themeDisplay.getScopeGroupId(),thang,nam);
			else if(fileName.equals("bang_ke_nhuan_but_ngay.xlsx"))result=createExcelBangKeNhuanButNgay(filePath,0,themeDisplay.getScopeGroupId(),fDate);
			else if(fileName.equals("tong_hop_thu_lao_bo_phan.xlsx"))result=createExcelTongHopThuLaoBoPhan(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);	
			else if(fileName.equals("bang_ke_nhuan_but.xlsx"))result=createExcelBangKeNhuanBut(filePath, themeDisplay.getScopeGroupId(), fromDate, toDate, tinBai, tacGia);
			HttpServletResponse httpResponse = PortalUtil
					.getHttpServletResponse(response);
			httpResponse.setHeader("Content-disposition",
					"attachment; filename=\"" + " baocao-user.xlsx "
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
			String redirectURL = ParamUtil.getString(request, "redirectURL","");
			System.out.print("RedirectURL: "+redirectURL);
			response.sendRedirect(redirectURL);
		} catch (Exception ex) {
			response.sendRedirect(themeDisplay.getURLPortal());
		}
		
	}
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		//UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
				String keywords = ParamUtil.getString(request, "keywords","");
				String fromDate = ParamUtil.getString(request, "exfromDate","");
				String toDate = ParamUtil.getString(request, "extoDate","");
				String fileName = ParamUtil.getString(request, "fileName","");
				String typeNewsString = ParamUtil.getString(request, "typeNewsString","");
				String thang = ParamUtil.getString(request, "thang","");
				String nam = ParamUtil.getString(request, "nam","");
				long tinBai = ParamUtil.getLong(request, "tinBai", 0l);
				long tacGia = ParamUtil.getLong(request, "tacGia", 0l);
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
					
					byte[]result = null;
					String fileNameOut="";
					if(fileName.equals("bang_ke_nhuan_but_ca_nhan.xlsx")){
						result=createExcelBangKeNhuanButCaNhan(typeNewsString,filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);
						fileNameOut="Bang_ke_nhuan_but_ca_nhan.xlsx";
					}
					else if(fileName.equals("tong_hop_nhuan_but.xlsx")){
						result=createExcelTongHopNhuanBut(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);	
						fileNameOut="Tong_hop_nhuan_but.xlsx";
					}
					else if(fileName.equals("bang_ke_thanh_toan_tong_hop.xlsx")){
						result=createExcelBangKeThanhToanTongHop(filePath,0,themeDisplay.getScopeGroupId(),thang,nam);
						fileNameOut="Bang_ke_thanh_toan_tong_hop.xlsx";
					}
					else if(fileName.equals("bang_ke_nhuan_but_ngay.xlsx")){
						result=createExcelBangKeNhuanButNgay(filePath,0,themeDisplay.getScopeGroupId(),fDate);
						fileNameOut="Bang_ke_nhuan_but_ngay.xlsx";
					}
					else if(fileName.equals("tong_hop_thu_lao_bo_phan.xlsx")){
						result=createExcelTongHopThuLaoBoPhan(filePath,0,themeDisplay.getScopeGroupId(),keywords,fDate,tDate);
						fileNameOut="Tong_hop_thu_lao_bo_phan.xlsx";
					}
					else if(fileName.equals("bang_ke_nhuan_but.xlsx")){
						result=createExcelBangKeNhuanBut(filePath, themeDisplay.getScopeGroupId(), fromDate, toDate, tinBai, tacGia);
						fileNameOut="Bang_ke_nhuan_but.xlsx";
					}
					//HttpServletResponse httpResponse = PortalUtil
					//		.getHttpServletResponse(response);
					//httpResponse.setHeader("Content-disposition",
					//		"attachment; filename=\"" + "baocao-user.xlsx"
					//				+ "\"");
					//httpResponse.setHeader("Content-Transfer-Encoding", "binary");
					//httpResponse.setContentType( "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
					 
					//httpResponse.setContentType("application/vnd.ms-excel");
					resourceResponse.setProperty("Content-disposition", "attachment; filename=\"" + fileNameOut + "\"");
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
					//String redirectURL = ParamUtil.getString(request, "redirectURL","");
					//response.sendRedirect(redirectURL);
				} catch (Exception ex) {
					//response.sendRedirect(themeDisplay.getURLPortal());
				}

		//super.serveResource(request, resourceResponse);
	}

}
