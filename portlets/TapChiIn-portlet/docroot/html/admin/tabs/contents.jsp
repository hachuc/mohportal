<%@page import="com.viettel.portal.magazine.util.NotAloneException"%>
<%@page import="com.viettel.portal.magazine.service.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.viettel.portal.magazine.model.*" %>
<%@ include file="/html/admin/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	int publishYear = ParamUtil.getInteger(request, "publishYear",-1);
	int magazineId = ParamUtil.getInteger(request, "magazineId",-1);
	int magazineZoneId = ParamUtil.getInteger(request, "magazineZoneId",-1);
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
	
	List<MagazineZone> zones = MagazineZoneLocalServiceUtil.findByMagazineID(magazineId, 0, Integer.MAX_VALUE);
	if(zones == null || zones.isEmpty()){
		magazineZoneId = -1;
	}
	else{
		boolean flag = false;
		for(MagazineZone zone : zones){
			if(zone.getMagazineID() == magazineId){
				flag = true;
				break;
			}
		}
		if(!flag){
			magazineZoneId = zones.get(0).getID();
		}
	}
%>

<liferay-portlet:renderURL varImpl="searchMagazineContentURL">
	<liferay-portlet:param name="jspPage" value="/html/admin/view.jsp"/>
	<liferay-portlet:param name="tabs1" value="admin_contents"/>
</liferay-portlet:renderURL>
<portlet:renderURL var="updateMagazineContentFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/html/admin/content/form.jsp" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId) %>" />
	<portlet:param name="magazineId" value="<%=String.valueOf(magazineId) %>" />
	<portlet:param name="magazineZoneId" value="<%=String.valueOf(magazineId) %>" />
</portlet:renderURL>
<%
	String javascriptHref = "javascript:updateMagazineContentForm('" + updateMagazineContentFormURL.toString() + "')";
%>
<div class="span12"  style="margin: 0px !important;">
	<aui:nav-item href="<%=javascriptHref%>"
		iconCssClass="icon-file" 
		label='add-magazine-content' />
</div>
<aui:form action="<%=searchMagazineContentURL%>" method="post" name="fm" cssClass="form-horizontal magazine-form magazine-content" >
	<liferay-portlet:renderURLParams varImpl="searchZoneURL" />
	<div>
		<div class="span4">
			<aui:select name="publishYear" id="publishYear" label="publishYear" showEmptyOption="false"  onchange="this.form.submit()">
				<%
					for(int i = year; i >= 1955; i--){
						%>
						<aui:option value="<%= i %>" label="<%= i %>" selected="<%= publishYear == i %>"></aui:option>
						<%
					}
				%>
			</aui:select>
		</div>
		<div class="span4">
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
		<div class="span4">
			<aui:select name="magazineZoneId" id="magazineZoneId" label="magazineZoneId" showEmptyOption="true"  onchange="this.form.submit()">
				<%
				for(MagazineZone mz : zones){
					%>
					<aui:option value="<%= mz.getID() %>" label="<%= HtmlUtil.escape(mz.getName()) %>" selected="<%= mz.getID() == magazineZoneId %>"></aui:option>
					<%
				}
				%>
			</aui:select>
		</div>
	</div>
	<div class="span12" style="text-align: center;margin: 0px !important;">
		<aui:button name="search" type="submit" value="magazine-content-search" cssClass="btn btn-grey text-bold"/>
	</div>
	<div class="span12" style="margin: 0px !important;">
		<liferay-ui:error key="<%=NotAloneException.class.getName()%>"
			message="not-alone-magazine-content" />
		<liferay-ui:search-container emptyResultsMessage="no-found-magazine-content" delta="100">
		<%
			List<MagazineContent> list = magazineZoneId > 0 ?
					MagazineContentLocalServiceUtil.findByMagazineAndZone(magazineId, magazineZoneId, searchContainer.getStart(), searchContainer.getEnd()) :
					MagazineContentLocalServiceUtil.findByMagazineID(magazineId, searchContainer.getStart(), searchContainer.getEnd());
			total = magazineZoneId > 0 ?
					MagazineContentLocalServiceUtil.countByMagazineAndZone(magazineId, magazineZoneId) :
					MagazineContentLocalServiceUtil.countByMagazineID(magazineId);
		%>
			<liferay-ui:search-container-results results="<%=list %>" total="<%=total %>"/>
			<liferay-ui:search-container-row className="MagazineContent" keyProperty="id" modelVar="mc" escapedModel="<%=true %>">
				<liferay-ui:search-container-column-text name="name" value="<%= mc.getHeadline()%>" 
					orderable="<%=false %>"
				/>
				<liferay-ui:search-container-column-text name="author" value="<%= mc.getAuthor()%>" 
					orderable="<%=false %>"
				/>
				<%
					String zoneName = "";
					for(MagazineZone mz : zones){
						if (mc.getMagazineZoneID() == mz.getID()){
							zoneName = mz.getName();
							break;
						}
					}
				%>
				<liferay-ui:search-container-column-text name="magazineZoneID" value="<%= zoneName %>" 
					orderable="<%=false %>"
				/>
				<%
					String magazineName = "";
					for(Magazine maz : magazines){
						if(maz.getID() == mc.getMagazineID()){
							magazineName = maz.getName();
							break;
						}
					}
				%>
				<liferay-ui:search-container-column-text name="magazineName" value='<%= magazineName %>' 
					orderable="<%=false %>"
				/>
				<liferay-ui:search-container-column-text name="sortOrder" value='<%= String.valueOf( mc.getSortOrder() )%>' 
					orderable="<%=false %>"
				/>
				<liferay-ui:search-container-column-text name="edit" align="center" cssClass="tbl_cell_action">
					<portlet:renderURL var="editMagazineContentFormURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="jspPage" value="/html/admin/content/form.jsp" />
						<portlet:param name="id" value="<%= String.valueOf(mc.getID()) %>" />
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
						<portlet:param name="magazineId" value="<%=String.valueOf(magazineId) %>" />
						<portlet:param name="magazineZoneId" value="<%=String.valueOf(magazineZoneId) %>" />
					</portlet:renderURL>
					
					<a href="javascript:;" onclick='updateMagazineContentForm("<%=editMagazineContentFormURL.toString() %>");'>
						<liferay-ui:icon image="edit"/>
					</a>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="delete" align="center" cssClass="tbl_cell_action">
					<portlet:actionURL  name="deleteMagazineContent" var="deleteMagazineContentActionURL">
						<portlet:param name="id" value="<%=String.valueOf(mc.getID())%>"/>
						<portlet:param name="groupId" value="<%=String.valueOf(scopeGroupId)%>"/>
						<portlet:param name="redirectURL" value="<%=PortalUtil.getCurrentURL(request)%>" />
					</portlet:actionURL>            
					<liferay-ui:icon-delete url="<%= deleteMagazineContentActionURL %>" />
				</liferay-ui:search-container-column-text>	
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</div>
</aui:form>

<aui:script use="aui-base,uploader">
	
		Liferay.provide(
			window,
			'updateMagazineContentForm',
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
					title: '<liferay-ui:message key="add-magazine-content" />',
					uri: url,
					
				};
				
				Liferay.Util.openWindow(dialogWidow);	
			}
		);
</aui:script>