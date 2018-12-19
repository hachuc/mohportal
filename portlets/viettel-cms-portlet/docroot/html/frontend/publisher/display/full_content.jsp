<%@page import="com.viettel.portal.vcms.publisher.util.VCMSPubliserUtil"%>
<%@page
	import="com.viettel.portal.vcms.service.DistributionLocalServiceUtil"%>
<%@page
	import="com.viettel.portal.vcms.service.DistributionLocalService"%>
<%@page import="com.viettel.portal.vcms.util.CmsConstants"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.model.Distribution"%>
<%@ include file="/html/frontend/publisher/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	boolean show = ((Boolean) request.getAttribute("view.jsp-show")).booleanValue();
	Distribution assetEntry = (Distribution) request.getAttribute("view.jsp-assetEntry");
%>
