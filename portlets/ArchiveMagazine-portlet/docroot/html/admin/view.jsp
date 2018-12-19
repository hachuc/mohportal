<%@page
	import="com.viettel.portal.magazine.archive.service.ContentLocalServiceUtil"%>
<%@page import="com.viettel.portal.magazine.archive.model.Content"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page
	import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/html/admin/init.jsp"%>

<aui:nav-bar cssClass="custom-toolbar">
	<aui:nav-bar-search cssClass="pull-right">
		<liferay-portlet:renderURL var="searchContentURL">
			<liferay-portlet:param name="mvcPath" value="/html/admin/view.jsp" />
			<liferay-portlet:param name="publishYear" value="<%=String.valueOf(publishYear)%>" />
		</liferay-portlet:renderURL>

		<div class="form-search">
			<aui:form action="<%=searchContentURL%>" method="post" name="fm">
				<div class="row">
					<table class="table borderless">
						<td class="col-md-4">
							<aui:select name="publishYear"
								id="publishYear" label="" placeholder="choose-publish-year">
								<%
									for(int i = 2010 ; i >= 1965; i--) {
								%>
								<aui:option selected="<%=i == publishYear%>" value="<%=i%>"><%=i%></aui:option>
								<%
									}
								%>
							</aui:select></td>
						<td class="col-md-8">
							<aui:select name="publishYearNumber"
								id="publishYearNumber" label=""
								placeholder="choose-publish-year-number" cssClass="">
								<aui:option value="">
									<liferay-ui:message key="choose" />
								</aui:option>
							</aui:select></td>
					</table>
				</div>
			</aui:form>
		</div>
	</aui:nav-bar-search>
</aui:nav-bar>
<div class="list-vl-video">
	<%
		PortletURL portletURL = renderResponse.createRenderURL();
			portletURL.setParameter("mgzId", String.valueOf(magazineId));
			portletURL.setParameter("publishYear", String.valueOf(publishYear));
	%>

	<liferay-ui:search-container emptyResultsMessage="no-found-video"
		iteratorURL="<%=portletURL%>">
		<%
			List<Content> contents = ContentLocalServiceUtil.GetAllContentByMagazineId(magazineId, searchContainer.getStart(), searchContainer.getEnd());
			int totalContent = ContentLocalServiceUtil.CountAll(magazineId);
		%>

		<liferay-ui:search-container-results results="<%=contents%>"
			total="<%=totalContent%>" />

		<liferay-ui:search-container-row className="Content" keyProperty="ID"
			modelVar="content" escapedModel="<%=true%>">

			<portlet:renderURL var="editContentURL"
				windowState="<%=LiferayWindowState.POP_UP.toString()%>">
				<portlet:param name="jspPage" value="/html/admin/edit_content.jsp" />
				<portlet:param name="contentId"
					value="<%=String.valueOf(content.getID())%>" />
			</portlet:renderURL>

			<%
				StringBundler previewVideo = new StringBundler();

				previewVideo.append("javascript:");
				previewVideo.append("updateContent");
				previewVideo.append("('");
				previewVideo.append(editContentURL.toString());
				previewVideo.append("')");
			%>

			<liferay-ui:search-container-column-text name="head-line"
				orderable="<%=true%>" value="<%=content.getSubject()%>"
				href="<%=previewVideo.toString()%>"
				title="<%=HtmlUtil.escape(content.getSubject())%>" valign="middle" />
				
			<liferay-ui:search-container-column-text name="Author"
				orderable="<%=true%>" value="<%=content.getAuthor()%>"
				href="<%=previewVideo.toString()%>"
				title="<%=HtmlUtil.escape(content.getAuthor())%>" valign="middle" />

			<liferay-ui:search-container-column-text name="modified-date"
				value="<%=dateTimeFormat.format(content.getCreationDate())%>"
				orderable="<%=true%>" orderableProperty="modified-date"
				href="<%=previewVideo.toString()%>" />

			<liferay-ui:search-container-column-text name="fileurl"
				value="<%=content.getFileUrl()%>" orderable="<%=true%>"
				orderableProperty="video-url" href="<%=previewVideo.toString()%>" />

			<liferay-ui:search-container-column-text name="edit" align="center"
				cssClass="tbl_cell_action" href='<%=previewVideo.toString()%>'>
				<liferay-ui:icon image="edit" />
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="delete" align="center"
				cssClass="tbl_cell_action">
				<portlet:actionURL name="deleteContent" var="deleteVideoActionURL">
					<portlet:param name="videoId"
						value="<%=String.valueOf(content.getID())%>" />
					<portlet:param name="redirectURL"
						value='<%=adminHomePageURL + StringPool.AMPERSAND + themeDisplay.getPortletDisplay().getNamespace()%>' />
				</portlet:actionURL>
				<liferay-ui:icon-delete url="<%=deleteVideoActionURL%>" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>
<portlet:resourceURL var="serverURL2K"></portlet:resourceURL>
<aui:script use="aui-base,node,aui-io-request">
	function escapeHtml2010(html) {
		var text = document.createTextNode(html);
		var div = document.createElement('div');
		div.appendChild(text);
		return div.innerHTML;
	};
	getData2010("<%= serverURL2K%>", '<%= magazineId%>', "getMagazineByYear",
			"#<portlet:namespace/>publishYear",
			"#<portlet:namespace/>publishYearNumber");
	A.one("#<portlet:namespace/>publishYear").on(
			"change",
			function() {
				//console.log("thay doi nhom van ban");
				getData2010("<%= serverURL2K %>", '<%= magazineId%>',
						"getMagazineByYear",
						"#<portlet:namespace/>publishYear",
						"#<portlet:namespace/>publishYearNumber");
			});

	A
			.ready(
					'liferay-portlet-url',
					function(A) {
						var renderUrl1 = Liferay.PortletURL.createRenderURL();

						var renderURL = Liferay.PortletURL.createRenderURL();
						renderURL.setPortletMode("view");
						renderURL.setWindowState("normal");
						renderURL
								.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");

						A.one("#<portlet:namespace/>publishYearNumber").on(
								"change",
								function() {
									if (this.val() != '') {
										renderURL.setParameter("mgzId", this
												.val());
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
	

<aui:script use="aui-base,uploader">
	Liferay.provide(window, 'updateContent', function(url) {

		var dialogWidow = {
			dialog : {
				constrain : true,
				align : Liferay.Util.Window.ALIGN_CENTER,
				modal : true,
				width : '60%',
				cache : false,
				after : {
					visibleChange : function(event) {
						location.reload();
					}
				}
			},
			title : Liferay.Language.get('update-content'),
			uri : url,

		};

		Liferay.Util.openWindow(dialogWidow);
	});

	
</aui:script>