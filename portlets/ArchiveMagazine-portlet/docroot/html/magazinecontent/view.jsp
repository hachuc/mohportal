<%@ include file="/html/magazinecontent/init.jsp"%>

<div class="bacday">
	<h4 class="headerBox0">
		<%=HtmlUtil.escape(portletTitle)%>
	</h4>
	<c:if test='<%=Validator.isNotNull(mgz)%>'>
		<table class="table">
			<tbody>
				<tr>
					<td class="text" style="text-align: center" width="180px"><c:if
							test='<%=Validator.isNotNull(mgz.getImageUrl())%>'>
							<img src="<%=imageFolderPath + mgz.getImageUrl()%>"
								style="border-width: 0px;">
						</c:if></td>
					<td width="10px"></td>
					<td valign="top">
						<table class="table borderless">
							<tbody>
								<tr>
									<td style="WIDTH: 110px" class="magazine"><liferay-ui:message
											key="magazine-title" />&nbsp; :</td>
									<td class="magazine"><span><%=HtmlUtil.escape(mgz.getName())%></span></td>
								</tr>
								<tr>
									<td style="WIDTH: 110px" class="magazine"><liferay-ui:message
											key="magazine-number" /> :</td>
									<td class="magazine"><span><%=mgz.getPublishNumber()%></span></td>
								</tr>
								<tr>
									<td class="magazine" style="WIDTH: 110px"><liferay-ui:message
											key="publish-year-label" /> :</td>
									<td class="magazine"><span><%=mgz.getPublishYear()%></span></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<hr />

		<%
			List<Content> lstContent = ContentLocalServiceUtil.GetAllContentByMagazineId(magazineId, 0, 1000);
		%>
		<div class="col-md-12 ml10">
			<%
				for (Content content : lstContent) {
			%>
			<div class="magazineheadline">
				<img src="/TapChiIn-portlet/images/timetip.gif" align="absmiddle">
				<a href="<%=imageFolderPath + content.getFileUrl()%>"><%=HtmlUtil.escape(content.getSubject())%></a>
			</div>
			<div class="magazineauthor">
				<c:if test='<%=Validator.isNotNull(content.getAuthor())%>'>
					<span> <liferay-ui:message key="magazine-author" /> : <%=HtmlUtil.escape(content.getAuthor())%><c:if
							test='<%=Validator.isNotNull(content
									.getAuthorTitle())%>'> - <%=HtmlUtil.escape(content.getAuthorTitle())%></c:if></span>
				</c:if>
			</div>
			<%
				}
			%>
		</div>
	</c:if>
</div>
