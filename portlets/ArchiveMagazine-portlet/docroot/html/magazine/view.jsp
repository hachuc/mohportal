<%@page import="com.viettel.portal.magazine.archive.util.WebKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ include file="/html/magazine/init.jsp"%>

<portlet:resourceURL var="serverURL2K"></portlet:resourceURL>

<div class="mt15">
	<div class="headerBox">
		<%= HtmlUtil.escape(portletTitle) %>
	</div>
	<div class="magazinecontent clearfix">
		<div class="col-md-4">
			<aui:select name="publishYear" id="publishYear" label=""
				placeholder="choose-publish-year">
				<% for(int i = 2010 ; i >= 1965; i--) { %>
					<aui:option value="<%= i %>"><%= i %></aui:option>				
				<% } %>
			</aui:select>
		</div>
		<div class="col-md-8">
			<aui:select name="publishYearNumber" id="publishYearNumber" label=""
				placeholder="choose-publish-year-number">
				<aui:option value="">
					<liferay-ui:message key="choose" />
				</aui:option>
			</aui:select>
		</div>
	</div>
</div>
<aui:script use="aui-base,node,aui-io-request">
	function escapeHtml2010(html) {
		var text = document.createTextNode(html);
		var div = document.createElement('div');
		div.appendChild(text);
		return div.innerHTML;
	};
	getData2010("<%= serverURL2K%>", 2010 , "getMagazineByYear", "#<portlet:namespace/>publishYear", "#<portlet:namespace/>publishYearNumber");
	A.one("#<portlet:namespace/>publishYear").on("change", function() {
		//console.log("thay doi nhom van ban");
		getData2010("<%= serverURL2K %>", this.val() , "getMagazineByYear", "#<portlet:namespace/>publishYear", "#<portlet:namespace/>publishYearNumber");
	});
	
	A.ready('liferay-portlet-url', function(A) {
		var renderURL = Liferay.PortletURL.createRenderURL();
		renderURL.setLifecycle(Liferay.PortletURL.RENDER_PHASE);
		renderURL.setPlid('<%= layoutId%>');
		renderURL.setPortletId("ArchiveMagazine_WAR_ArchiveMagazineportlet");
		
		A.one("#<portlet:namespace/>publishYearNumber").on(
		"change",
		function() {
			if (this.val() != ''){
				renderURL.setParameter("mgzId", this.val());
				//console.log(renderURL);
				//debugger;
				window.location = renderURL;
				
			}
		});
	});
	function getData2010(url, currentData, useMethod, selectFromId,
			selectToIdChange) {
		var id01 = selectFromId.split("#");
		var id02 = selectToIdChange.split("#");
		if (id01 == null || id02 == null)
			return;
		var se1 = document.getElementById(id01[1]);
		var se2 = document.getElementById(id02[1]);

		if (se1 == null || se2 == null)
			return;
		var value = A.one(selectFromId).val();
		
		var nhom = A.one(selectToIdChange);
		if (value != "") {
			A.io
					.request(
							url,
							{
								method : 'post',
								dataType : 'json',
								data : {
									<portlet:namespace/>PublishYear : value,
									<portlet:namespace/>method : useMethod
								},
								on : {
									success : function(data) {
										nhom.empty();
										//							console.log(data);

										data = this.get("responseData");
										if (data == null
												|| (data != null && data.length == 0))
											return;
										var nhomVanBanId = currentData;
										nhom.append("<option value=''>"
												+ Liferay.Language
														.get('choose')
												+ "</option>");
										for (var i = 0; i < data.length; i++) {
											var selected = "";
											if (nhomVanBanId == data[i].id)
												selected = " selected ";
											var op = "<option value='"+ data[i].id +"' +"+ selected +">"
													+ escapeHtml2010(data[i].name)
													+ "</option>";
											nhom.append(op);
											//								console.log(op);
										}
									},
									error : function() {
										alert("error");
									}
								}
							});
		}

	}
</aui:script>
	




