<%@page import="com.viettel.portal.links.model.LCategory"%>
<%@page import="com.viettel.portal.links.model.VLink"%>
<%@page
	import="com.viettel.portal.links.service.LCategoryLocalServiceUtil"%>
<%@page import="com.viettel.portal.links.service.VLinkLocalServiceUtil"%>

<%@ include file="/html/display/single/init.jsp"%>
<% 
	List<VLink> links = VLinkLocalServiceUtil.findByGroupAndCateActive(scopeGroupId, categoryId, true);
%>
<div class="form-group input-group-sm mb0">
	<select id="categoryId" class="form-control" onchange="gotoUrl(this)">
		<option value="0"><liferay-ui:message
				key="---Trang-lien-ket---" /></option>
		<% for(VLink link : links) { %>
		<option value="<%= link.getUrl() %>"><%=HtmlUtil.escape(link.getLinkName()) %></option>
		<% } %>
	</select>
	<div id="trigger" style="display: none;"></div>
</div>
<script type="text/javascript">
	var gotoUrl = function(e) {
		var url = e.options[e.selectedIndex].value;
		if (!url || url == 0) {
			return;
		}
		if (url.search("http") < 0) {
			url = "http://" + url;
		}
		var $trigger = document.getElementById('trigger');
		var $a = document.createElement('a');
		$a.setAttribute("href", url);
		$a.setAttribute("target", '_blank');
		$trigger.appendChild($a);
		$a.click();
	}
</script>