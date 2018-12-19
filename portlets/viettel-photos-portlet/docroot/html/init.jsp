<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
long groupId = scopeGroupId;
%>

<%!
/**
* Tao cay thu muc trong document media
* parentFolderId - Id cua thu muc cha (mac dinh la thu muc Root)
* treeLevel - Cap thu muc
* selectedFolderId - Thu muc dang duoc chon de hien thi anh
*/
protected void buildDLFolderTree(long groupId,long parentFolderId,int treeLevel,JspWriter jspWriter,long selectedFolderId){
	
	try{

		//Lay danh sach thu muc con cap 1 tinh tu thu muc cha (theo parentFolderId)
		List<DLFolder> subFolderList = DLFolderLocalServiceUtil.getFolders(groupId, parentFolderId);
		
		if(subFolderList.size() > 0){
			
			for(DLFolder subFolder : subFolderList){
				
				String folderNamePrefix = "";
				
				if(treeLevel > 0){
					
					for(int i = 0; i< treeLevel; i++){
						
						folderNamePrefix += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
				}
				
				String subFolderName = folderNamePrefix + subFolder.getName();
				
				if(subFolder.getFolderId() == selectedFolderId){
					
					jspWriter.println("<option selected=\"selected\" value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
				}else{
					
					jspWriter.println("<option value=\"" + subFolder.getFolderId() + "\">" + subFolderName + "</option>");
				}
				
				int nextTreeLevel = treeLevel + 1;
				
				buildDLFolderTree(groupId, subFolder.getFolderId(), nextTreeLevel, jspWriter, selectedFolderId);
			}
		}
	}catch(Exception e){
		
	}
}
%>
