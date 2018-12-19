<%@page import="com.viettel.portal.vbpq.portlet.NhomVanBanController"%>
<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.viettel.portal.vbpq.terms.LinhVucVanBanTerms"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.viettel.portal.vbpq.terms.CoQuanBanHanhTerms"%>
<%@page import="com.viettel.portal.vbpq.util.MessageErrors"%>
<%@page import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.permission.AdminPermission"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="init.jsp" %>

<liferay-ui:error key="<%= NhomVanBanController.NHOM_VAN_BAN_CREATE_ERROR %>" message="Têm nhóm đã tồn tại!" />
<liferay-ui:error key="<%= NhomVanBanController.NHOM_VAN_BAN_CREATE_ERROR_EMPTY %>" message="Mời nhập tên nhóm!" />

<liferay-util:include page='<%= templatePath + "top_tabs.jsp" %>' servletContext="<%= application %>" />

<liferay-util:include page='<%= templatePath + "top_tabs_danhmuc.jsp" %>' servletContext="<%= application %>" />

<%
	String tenNhom = "";
	boolean hienThi = true;
	long id = ParamUtil.getLong(request, "id", 0);
	if (id > 0) {
		NhomVanBan linhvuc = NhomVanBanLocalServiceUtil.getNhomVanBan(id);
		
		if (linhvuc != null) {
			tenNhom = linhvuc.getTenNhom();
			if (linhvuc.getTrangThai() != 0) hienThi = false; 
		}
	}
	
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (id == 0) ? "Thêm mới nhóm văn bản" : "Chỉnh sửa nhóm văn bản" %>'
	
/>

<portlet:actionURL name="createOrEditNhomVanBan" var="updateLinhVucURL"/>

<aui:form cssClass="vbpq-form" action="<%= updateLinhVucURL %>" method="post">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value=""/>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
	<aui:input name="<%= NhomVanBanController.NHOM_VAN_BAN_ID %>" type="hidden" value="<%= id %>" />
	<aui:col width="<%= 60 %>">
		<aui:row>
			<aui:input name="<%= NhomVanBanController.NHOM_VAN_BAN_TEN_NHOM %>" type="text" label="Tên nhóm:" value="<%= HtmlUtil.escape(tenNhom) %>">
				<aui:validator name="required"></aui:validator>
			</aui:input>
			<aui:input name="<%= NhomVanBanController.NHOM_VAN_BAN_TRANG_THAI %>" type="checkbox" label="Hiển thị" checked="<%= hienThi %>"></aui:input>
		</aui:row>
		
		<aui:button-row>
			<aui:button type="submit"/>
			<aui:button href="<%= redirect %>" name="cancelButton" type="cancel" />
		</aui:button-row>
	</aui:col>

</aui:form>

