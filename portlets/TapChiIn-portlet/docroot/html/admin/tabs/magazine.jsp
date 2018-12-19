<%@page import="com.viettel.portal.magazine.util.NotAloneException"%>
<%@page import="com.viettel.portal.magazine.service.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.viettel.portal.magazine.model.*" %>
<%@ include file="/html/admin/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int publishNumber = ParamUtil.getInteger(request, "publishNumber",-1);
	int publishYear = ParamUtil.getInteger(request, "publishYear",-1);
%>

<liferay-portlet:renderURL varImpl="searchMagazineURL">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="admin_magazine"/>
</liferay-portlet:renderURL>
<portlet:renderURL var="updateMagazineFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/magazine/form.jsp" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
</portlet:renderURL>
<%
	String javascriptHref = "javascript:updateMagazineForm('" + updateMagazineFormURL.toString() + "')";
%>
<div class="span12" style="margin: 0px !important;">
<aui:nav-item href="<%=javascriptHref%>"
	iconCssClass="icon-file" 
	label='add-magazine' />
</div>
<aui:form action="<%=searchMagazineURL%>" method="post" name="fm" cssClass="form-horizontal magazine-form">
	<liferay-portlet:renderURLParams varImpl="searchMagazineURL" />
	<div>
		<div class="span6">
			<aui:input name="publishNumber" id="publishNumber" label="publishNumber" type="number" value='<%=publishNumber < 0 ? "" : publishNumber %>'></aui:input>
		</div>
		<div class="span6">
			<aui:select name="publishYear" id="publishYear" label="publishYear" showEmptyOption="true"  onchange="this.form.submit()">
				<%
					Date now = new Date();
					int year = now.getYear() + 1900;
					for(int i = year; i >= 1955; i--){
						%>
						<aui:option value="<%= i %>" label="<%= i %>" selected="<%= publishYear == i %>"></aui:option>
						<%
					}
				%>
			</aui:select>
		</div>
	</div>
	<div class="span12" style="text-align: center;margin: 0px !important;">
		<aui:button name="search" type="submit" value="magazine-search" cssClass="btn btn-grey text-bold"/>
	</div>
	<div class="span12" style="margin: 0px !important;">
		<liferay-ui:error key="<%=NotAloneException.class.getName()%>"
		message="not-alone-magazine" />
		<liferay-ui:search-container emptyResultsMessage="no-found-magazine">
			<%
				List<Magazine> list = MagazineLocalServiceUtil.searchMagazine(publishNumber, publishYear, searchContainer.getStart(), searchContainer.getEnd());
				total = MagazineLocalServiceUtil.countMagazine(publishNumber, publishYear);
			%>
				<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
				<liferay-ui:search-container-row className="Magazine" keyProperty="id" modelVar="magazine" escapedModel="<%=true %>">
					<liferay-ui:search-container-column-text name="name" value="<%= magazine.getName()%>" 
						orderable="<%=false %>"
					/>
					<liferay-ui:search-container-column-text name="publishNumber" value='<%= String.valueOf( magazine.getPublishNumber() )%>' 
						orderable="<%=false %>"
					/>
					<liferay-ui:search-container-column-text name="publishYear" value='<%= String.valueOf(magazine.getPublishYear())%>' 
						orderable="<%=false %>"
					/>
					<liferay-ui:search-container-column-text name="creationDate" value="<%= dateTimeFormat.format(magazine.getCreationDate())%>" 
						orderable="<%=false %>"
					/>
					<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
						<portlet:renderURL var="editMagazineFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="jspPage" value="/html/admin/magazine/form.jsp" />
							<portlet:param name="id" value="<%= String.valueOf(magazine.getID()) %>" />
							<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
						</portlet:renderURL>
						
						<a href="javascript:;" onclick='updateMagazineForm("<%=editMagazineFormURL.toString() %>");'>
							<liferay-ui:icon image="edit"/>
						</a>
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
						<portlet:actionURL  name="deleteMagazine" var="deleteMagazineActionURL">
							<portlet:param name="id" value="<%=String.valueOf(magazine.getID())%>"/>
							<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>
							<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
						</portlet:actionURL>            
						<liferay-ui:icon-delete url="<%= deleteMagazineActionURL %>" />
					</liferay-ui:search-container-column-text>
					
					<liferay-ui:search-container-column-text name="view-magazine-zone" align="center" cssClass="tbl_cell_action">
						<portlet:renderURL var="viewMagazineZoneURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="jspPage" value="/html/admin/magazine/zone.jsp" />
							<portlet:param name="magazineId" value="<%= String.valueOf(magazine.getID()) %>" />
							<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.VIEW %>" />
						</portlet:renderURL>
						
						<a href="javascript:;" onclick='viewMagazineZone("<%=viewMagazineZoneURL.toString() %>");'>
							<liferay-ui:icon image="view"/>
						</a>
					</liferay-ui:search-container-column-text>	
					
					<liferay-ui:search-container-column-text name="view-magazine-content" align="center" cssClass="tbl_cell_action">
						<portlet:renderURL var="viewMagazineZoneURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="jspPage" value="/html/admin/magazine/content.jsp" />
							<portlet:param name="magazineId" value="<%= String.valueOf(magazine.getID()) %>" />
							<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.VIEW %>" />
						</portlet:renderURL>
						
						<a href="javascript:;" onclick='viewMagazineContent("<%=viewMagazineZoneURL.toString() %>");'>
							<liferay-ui:icon image="view"/>
						</a>
					</liferay-ui:search-container-column-text>		
				</liferay-ui:search-container-row>	
				
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>
	</div>
</aui:form>

<aui:script use="aui-base,uploader">
	
		Liferay.provide(
			window,
			'updateMagazineForm',
			function(url){
				
				var dialogWidow = {
					dialog: {
						constrain: true,
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal: true,
						width: '60%',
						cache: false,
						after: {
							visibleChange: function(event) {
								location.reload();
							}
                        }
					},
					title: '<liferay-ui:message key="add-magazine" />',
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
		
		Liferay.provide(
				window,
				'viewMagazineZone',
				function(url){
					
					var dialogWidow = {
						dialog: {
							constrain: true,
							align: Liferay.Util.Window.ALIGN_CENTER,
							modal: true,
							width: '80%',
							cache: false,
							after: {
								visibleChange: function(event) {
									location.reload();
								}
	                        }
						},
						title: '<liferay-ui:message key="view-magazine-zone" />',
						uri: url,
						
					};
					
					Liferay.Util.openWindow(dialogWidow);	
				}
			);
		Liferay.provide(
				window,
				'viewMagazineContent',
				function(url){
					
					var dialogWidow = {
						dialog: {
							constrain: true,
							align: Liferay.Util.Window.ALIGN_CENTER,
							modal: true,
							width: '80%',
							cache: false,
							after: {
								visibleChange: function(event) {
									location.reload();
								}
	                        }
						},
						title: Liferay.Language.get('view-magazine-content'),
						uri: url,
						
					};
					
					Liferay.Util.openWindow(dialogWidow);	
				}
			);		
</aui:script>