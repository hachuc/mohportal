<%@page import="com.viettel.portal.magazine.util.WebKeys"%>
<%@page import="com.viettel.portal.magazine.service.MagazineLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.model.Magazine"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.viettel.portal.magazine.util.MagazineFileUtil" %>
<%@ include file="/html/magazine/init.jsp"%>

<portlet:resourceURL var="serverURL"></portlet:resourceURL>
<%
	String thumbnailURL = request.getContextPath() + "/images/default-thumbnail.jpg";
	FileEntry thumbnailImage = null;
	if(latestItem.getImageID() > 0){
		try{
			thumbnailImage = DLAppServiceUtil.getFileEntry(latestItem.getImageID());
		}catch(Exception e){
			
		}
		if(thumbnailImage != null){
			thumbnailURL = MagazineFileUtil.getThumbnailURL(themeDisplay, thumbnailImage);
		}
	}
	else{
		thumbnailURL = "http://xaydungdang.org.vn" + latestItem.getImageUrl();
	}
%>
<liferay-portlet:renderURL var="viewMagazineContent"
	plid="<%=layoutId%>" portletName="<%=WebKeys.MAGAZINE_PORTLET_NAME%>">
	<portlet:param name="magazineId"
		value="<%=String.valueOf(latestItem.getID())%>" />
</liferay-portlet:renderURL>
<div class="mt15">
	<div class="headerBox">
		<liferay-ui:message key="intro-magazine" />
	</div>
	<div class="magazinecontent clearfix">
		<div class="photo col-md-5">
			<a href="<%=viewMagazineContent%>"><img
				src="<%=thumbnailURL%>"
				style="border-width: 0px;"></a>
		</div>
		<div class="info col-md-7">
			<div class="infonew">
				<span><liferay-ui:message key="magazine-number" /><%=" " + latestItem.getPublishNumber() + " " + latestItem.getPublishYear()%></span>
			</div>
			<div class="infochapter">
				<a href="<%=viewMagazineContent%>"><liferay-ui:message
						key="list-page" /></a>
			</div>
		</div>
	</div>
</div>

<div class="mt15">
	<div class="headerBox">
		<liferay-ui:message key="search-magazine" />
	</div>
	<div class="magazinecontent clearfix">
		<div class="col-md-4">
			<aui:select name="publishYear" id="publishYear" label=""
				placeholder="choose-publish-year">
				<aui:option value="2018">2018</aui:option>
				<aui:option value="2017">2017</aui:option>
				<aui:option value="2016">2016</aui:option>
				<aui:option value="2015">2015</aui:option>
				<aui:option value="2014">2014</aui:option>
				<aui:option value="2013">2013</aui:option>
				<aui:option value="2012">2012</aui:option>
				<aui:option value="2011">2011</aui:option>
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
	function escapeHtml(html) {
		var text = document.createTextNode(html);
		var div = document.createElement('div');
		div.appendChild(text);
		return div.innerHTML;
	};
	getData("<%= serverURL %>", "2018", "getMagazineByYear",
			"#<portlet:namespace/>publishYear",
			"#<portlet:namespace/>publishYearNumber");
	A.one("#<portlet:namespace/>publishYear").on(
			"change",
			function() {
				//console.log("thay doi nhom van ban");
				getData("<%= serverURL %>", "2018", "getMagazineByYear",
						"#<portlet:namespace/>publishYear",
						"#<portlet:namespace/>publishYearNumber");
			});
	
	A.ready('liferay-portlet-url', function(A) {
		var renderURL = Liferay.PortletURL.createRenderURL();
		renderURL.setLifecycle(Liferay.PortletURL.RENDER_PHASE);
		renderURL.setPlid('<%= layoutId%>');
		renderURL.setPortletId("MagazineDisplay_WAR_TapChiInportlet");
		console.log("value = " + renderURL);
		A.one("#<portlet:namespace/>publishYearNumber").on(
		"change",
		function() {
			if (this.val() != ''){
				renderURL.setParameter("magazineId", this.val());
				window.location = renderURL;
				
			}
		});
	});
	function getData(url, currentData, useMethod, selectFromId,
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
													+ escapeHtml(data[i].name)
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
	




