<%@ include file="/html/frontend/init.jsp"%>

<c:if test='<%=Validator.isNotNull(mgz)%>'>
	<liferay-portlet:renderURL var="viewMagazine">
		<portlet:param name="magazineId"
			value="<%=String.valueOf(magazineId)%>" />
	</liferay-portlet:renderURL>
	<div class="bacday" style="padding-bottom: 20px;">
		<h4 class="headerBox0">
			<a href='<%=viewMagazine%>'><%=HtmlUtil.escape(mgz.getName())%></a>
		</h4>
		<%
			if (mcId > 0) {
					MagazineContent mcontent = MagazineContentLocalServiceUtil
							.fetchMagazineContent(mcId);
					List<MagazineContent> lstOder = MagazineContentLocalServiceUtil
							.getOlderContents(mcId, mzId, magazineId,
									mcontent.getSortOrder());
					List<MagazineContent> lstNewer = MagazineContentLocalServiceUtil
							.getNewerContents(mcId, mzId, magazineId,
									mcontent.getSortOrder());
		%>
		<c:if test='<%=Validator.isNotNull(mcontent)%>'>
			<div class="magazine-detail">
				<span class="magazine-content-title"> <%=HtmlUtil.escape(mcontent.getHeadline())%>
				</span>
				<p class="magazine-content">
					<%=mcontent.getBody()%>
				</p>
				<div class="magazineauthor">
					<span><%=mcontent.getAuthor()%></span> <br> <span><%=HtmlUtil.escape(mcontent.getJobtitle())%></span>
				</div>
			</div>
			<c:if test='<%=Validator.isNotNull(lstOder) && !lstOder.isEmpty()%>'>
				<div class="older-conent">
					<div class="magazineother">
						<liferay-ui:message key="older-news" />
					</div>
					<%
						for (MagazineContent mgc : lstOder) {
					%>
					<liferay-portlet:renderURL var="viewMagazineContentDetail">
						<portlet:param name="magazineId"
							value="<%=String.valueOf(magazineId)%>" />
						<portlet:param name="mzId" value="<%=String.valueOf(mgc.getMagazineZoneID())%>" />
						<portlet:param name="mcId" value="<%=String.valueOf(mgc.getID())%>" />
					</liferay-portlet:renderURL>
					<div class="magazineheadline">
						<img src="/TapChiIn-portlet/images/timetip.gif" align="absmiddle">
						<a href="<%=viewMagazineContentDetail%>"><%=HtmlUtil.escape(mgc.getHeadline())%></a>
					</div>
					<div class="magazineauthor">
						<span>
							<liferay-ui:message key="magazine-author" /> : <%=HtmlUtil.escape(mgc.getAuthor())%>
							<c:if test='<%=Validator.isNotNull(mgc.getJobtitle())%>'> - <%=HtmlUtil.escape(mgc.getJobtitle())%></c:if>
						</span>
					</div>
					<%
						}
					%>
				</div>
			</c:if>
			<c:if test='<%=Validator.isNotNull(lstNewer) && !lstNewer.isEmpty()%>'>
				<div class="newer-conent">
					<div class="magazineother">
						<liferay-ui:message key="newer-news" />
					</div>
					<%
						for (MagazineContent mgc : lstNewer) {
					%>
					<liferay-portlet:renderURL var="viewMagazineContentDetail">
						<portlet:param name="magazineId"
							value="<%=String.valueOf(magazineId)%>" />
						<portlet:param name="mzId" value="<%=String.valueOf(mgc.getMagazineZoneID())%>" />
						<portlet:param name="mcId" value="<%=String.valueOf(mgc.getID())%>" />
					</liferay-portlet:renderURL>
					<div class="magazineheadline">
						<img src="/TapChiIn-portlet/images/timetip.gif" align="absmiddle">
						<a href="<%=viewMagazineContentDetail%>"><%=HtmlUtil.escape(mgc.getHeadline())%></a>
					</div>
					<div class="magazineauthor">
						<span>
							<liferay-ui:message key="magazine-author" /> : <%=HtmlUtil.escape(mgc.getAuthor())%>
							<c:if test='<%=Validator.isNotNull(mgc.getJobtitle())%>'> - <%=HtmlUtil.escape(mgc.getJobtitle())%></c:if>
						</span>
					</div>
					<%
						}
					%>
				</div>
			</c:if>
		</c:if>
		<%
			}
		%>
	</div>
</c:if>
