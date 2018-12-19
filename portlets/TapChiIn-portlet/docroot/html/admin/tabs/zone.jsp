<%@page import="com.viettel.portal.magazine.util.NotAloneException"%>
<%@page import="com.viettel.portal.magazine.service.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.viettel.portal.magazine.model.*" %>
<%@ include file="/html/admin/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int magazineId = ParamUtil.getInteger(request, "magazineId",-1);
	int publishYear = ParamUtil.getInteger(request, "publishYear",-1);
	Date now = new Date();
	int year = now.getYear() + 1900;
	if(publishYear <= -1){
		publishYear = year;
	}
	List<Magazine> magazines = MagazineLocalServiceUtil.findByPublishYear(publishYear);
	if(magazines != null && !magazines.isEmpty()){
		if (magazineId == -1){
			magazineId = magazines.get(0).getID();
		}
		else{
			boolean flag = false;
			for(Magazine maz : magazines){
				if(maz.getID() == magazineId){
					flag = true;
					break;
				}
			}
			if(!flag){
				magazineId = magazines.get(0).getID();
			}
		}
	}
	else{
		magazineId = -1;
	}
%>
<liferay-portlet:renderURL varImpl="searchMagazineZoneURL">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="admin_zone"/>
</liferay-portlet:renderURL>
<portlet:renderURL var="updateMagazineZoneFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/zone/form.jsp" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
	<portlet:param name="magazineId" value="<%=String.valueOf(magazineId) %>" />
</portlet:renderURL>
<%
	String javascriptHref = "javascript:updateMagazineZoneForm('" + updateMagazineZoneFormURL.toString() + "')";
%>
<div class="span12" style="margin: 0px !important;">
	<aui:nav-item href="<%=javascriptHref%>"
		iconCssClass="icon-file" 
		label='add-magazine-zone' />
</div>
<aui:form action="<%=searchMagazineZoneURL%>" method="post" name="fm" cssClass="form-horizontal magazine-form">
	<liferay-portlet:renderURLParams varImpl="searchZoneURL" />
	<div>
		<div class="span6">
			<aui:select name="publishYear" id="publishYear" label="publishYear" showEmptyOption="false" onchange="this.form.submit()">
				<%
					for(int i = year; i >= 1955; i--){
						%>
						<aui:option value="<%= i %>" label="<%= i %>" selected="<%= publishYear == i %>"></aui:option>
						<%
					}
				%>
			</aui:select>		
		</div>
		<div class="span6">
			<aui:select name="magazineId" id="magazineId" label="magazineId" showEmptyOption="false"  onchange="this.form.submit()">
				<%
				for(Magazine magazine : magazines){
					%>
					<aui:option value="<%= magazine.getID() %>" label="<%= HtmlUtil.escape(magazine.getName()) %>" selected="<%= magazine.getID() == magazineId %>"></aui:option>
					<%
				}
				%>
			</aui:select>		
		</div>
	</div>
	<div class="span12" style="text-align: center;margin: 0px !important;">
		<aui:button name="search" type="submit" value="magazine-zone-search" cssClass="btn btn-grey text-bold"/>
	</div>
	<div class="span12" style="margin: 0px !important;">
		<liferay-ui:error key="<%=NotAloneException.class.getName()%>"
			message="not-alone-magazine" />
		<liferay-ui:search-container emptyResultsMessage="no-found-magazine-zone" delta="100">
		<%
			List<MagazineZone> list = MagazineZoneLocalServiceUtil.findByMagazineID(magazineId, searchContainer.getStart(), searchContainer.getEnd());
			total = MagazineZoneLocalServiceUtil.countByMagazineID(magazineId);
		%>
			<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
			<liferay-ui:search-container-row className="MagazineZone" keyProperty="id" modelVar="mz" escapedModel="<%=true %>">
				<liferay-ui:search-container-column-text name="name" value="<%= mz.getName()%>" 
					orderable="<%=false %>"
				/>
				<%
					String magazineName = "";
					for(Magazine maz : magazines){
						if(maz.getID() == mz.getMagazineID()){
							magazineName = maz.getName();
							break;
						}
					}
				%>
				<liferay-ui:search-container-column-text name="magazineName" value='<%= magazineName %>' 
					orderable="<%=false %>"
				/>
				<liferay-ui:search-container-column-text name="sortOrder" value='<%= String.valueOf( mz.getSortOrder() )%>' 
					orderable="<%=false %>"
				/>
				<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
					<portlet:renderURL var="editMagazineZoneFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/zone/form.jsp" />
						<portlet:param name="id" value="<%= String.valueOf(mz.getID()) %>" />
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
						<portlet:param name="magazineId" value="<%=String.valueOf(magazineId) %>" />
					</portlet:renderURL>
					
					<a href="javascript:;" onclick='updateMagazineZoneForm("<%=editMagazineZoneFormURL.toString() %>");'>
						<liferay-ui:icon image="edit"/>
					</a>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
					<portlet:actionURL  name="deleteMagazineZone" var="deleteMagazineZoneActionURL">
						<portlet:param name="id" value="<%=String.valueOf(mz.getID())%>"/>
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
					</portlet:actionURL>            
					<liferay-ui:icon-delete url="<%= deleteMagazineZoneActionURL %>" />
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</aui:form>

<aui:script use="aui-base,uploader">
	
		Liferay.provide(
			window,
			'updateMagazineZoneForm',
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
					title: '<liferay-ui:message key="add-magazine-zone" />',
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
</aui:script>