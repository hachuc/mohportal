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
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
Map<String,String> typeNews = new HashMap<String,String>();
typeNews.put("1","Tin mới viết");
typeNews.put("2","Bài mới viết");
typeNews.put("3","Tin khai thác");
typeNews.put("4","Bài khai thác");
String typeNewsString="";
for(String key:typeNews.keySet()){
	typeNewsString+=typeNewsString.equals("")?key+","+typeNews.get(key):";"+key+","+typeNews.get(key);
}
/*- A1 = 200K
- A2 = 150K
- B1 = 100K
- B2 = 70K */
Map<String,String> royalties=new HashMap<String,String>();
royalties.put("A1", "120");
royalties.put("A2", "100");
royalties.put("B1", "90");
royalties.put("B2", "80");

Map<String,String> typeNewsValues=new HashMap<String,String>();
typeNewsValues.put("1", "150000");
typeNewsValues.put("2", "200000");
typeNewsValues.put("3", "70000");
typeNewsValues.put("4", "100000");
String typeNewsValuesPrice="";
for(String key :typeNewsValues.keySet()){
	typeNewsValuesPrice+=typeNewsValuesPrice.equals("")?key+","+typeNewsValues.get(key):";"+key+","+typeNewsValues.get(key);
}
%>
