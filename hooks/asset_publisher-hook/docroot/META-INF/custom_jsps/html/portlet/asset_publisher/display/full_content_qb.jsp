<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<style type="text/css">
	.bn-top-sub {
	    /*background: url(../images/fullimage6.jpg) no-repeat top center #eab33c;*/
	    height: 300px;
	    background-attachment: fixed;
	    background-size: 100% auto;
	}
	.site-main article {
	    position: relative;
	}	
	.aui .site-main a:hover,.aui .site-main a:focus {
	    color: #23527c;
	    text-decoration: underline;
	}
	.aui .page-header {
	    padding-bottom: unset;
	    margin: unset;
	    border-bottom: unset;
	    background-color: #fff;
	    -webkit-transform: translateY(-99%);
	    transform: translateY(-99%);
	    position: absolute;
	    left: 0;
	    right: 0;
	    border-bottom: none;
	}	
	.aui .site-main a {
	    color: #111;
	    text-decoration: none !important;
	}
	.aui h1.entry-title {
	    font-family: "Roboto";
	    font-size: 30px;
	    line-height: 1;
	    padding: 0;
	    text-align: center;
	    text-transform: uppercase;
	    font-weight: 600;
	    text-rendering: optimizelegibility;
	    margin-top: 0;
	    color: #222222;
        margin-bottom: 10px;
	}	
	.p-t-10 {
	    padding-top: 10px!important;
	}	
	.entry-content {
	}
	.p-30 {
	    padding: 30px!important;
	}	
	.uppercase{
		text-transform: uppercase;
	}
	.text-bold{
		font-weight: bold;
	}
	.newsDifferent ul {
	    margin-left: 25px;
	    padding-left: 0;
	}
	.newsDifferent li {
	    padding-bottom: 3px;
	    list-style: none outside none;
	}	
	.newsDifferent li a {
	    padding-left: 10px;
	}	
	.newsDifferent ul li:before {
	    font-family: FontAwesome;
	    content: '\f111';
	    font-size: 4px;
	    line-height: 18px;
	    vertical-align: middle;
	    color: #0081d7;
	}	
</style>

<%@ include file="/html/portlet/asset_publisher/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");

	if (Validator.isNull(redirect)) {
		redirect = ParamUtil.getString(PortalUtil.getOriginalServletRequest(request), "redirect");
	}
	
	List results = (List)request.getAttribute("view.jsp-results");
	
	if (Validator.isNull(redirect) && results.isEmpty()) {
		PortletURL portletURL = renderResponse.createRenderURL();
	
		portletURL.setParameter("struts_action", "/asset_publisher/view");
	
		redirect = portletURL.toString();
	}
	
	int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
	
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	
	String languageId = LanguageUtil.getLanguageId(request);
	
	String title = assetRenderer.getTitle(LocaleUtil.fromLanguageId(languageId));
	
	String smallImagePath = assetRenderer.getThumbnailPath(renderRequest);
	
	boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
	boolean print = ((Boolean)request.getAttribute("view.jsp-print")).booleanValue();
	
	if (defaultAssetPublisher || Validator.isNull(defaultAssetPublisherPortletId) || !PortletPermissionUtil.contains(permissionChecker, layout, defaultAssetPublisherPortletId, ActionKeys.VIEW)) {
		request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntry);
	}
	
	request.setAttribute("view.jsp-fullContentRedirect", currentURL);
	request.setAttribute("view.jsp-showIconLabel", true);
%>
	<div class="">
         <div class="site-main">
             <div class="bn-top-sub" style="background: url(<%=smallImagePath%>) no-repeat top center #eab33c; background-attachment: fixed; background-size: 100% auto;"></div>
             <div class="container">
             	<article id="" class="post-01">
             		<header class="page-header">
           				<ol class="breadcrumb">
							<li><a href="#"><%="Kênh giao tiếp Thành phố Tây Ninh" %></a></li>
							<li><a href="/quang-ba">Nét đẹp Thành phố</a></li>
							<li><a href="#"><%=HtmlUtil.escape(title)%></a></li>
						  </ol>
           				<h1 class="entry-title"><%=HtmlUtil.escape(title)%></h1>
           			</header>
            			<div class="p-t-10"></div>
            			<div class="entry-content p-30">
<div class="contentDetail">
	<c:if test="<%=!print%>">
		<liferay-util:include
			page="/html/portlet/asset_publisher/asset_actions.jsp" />
	</c:if>

	<c:if test="<%=(enableConversions && assetRenderer.isConvertible()) || (enablePrint && assetRenderer.isPrintable()) || (showAvailableLocales && assetRenderer.isLocalizable())%>">
		<div class="asset-user-actions">
			<c:if test="<%=enablePrint%>">
				<div class="print-action">
					<%@ include file="/html/portlet/asset_publisher/asset_print.jspf"%>
				</div>
			</c:if>

			<c:if
				test="<%=(enableConversions && assetRenderer.isConvertible()) && !print%>">

				<%
					PortletURL exportAssetURL = assetRenderer.getURLExport(liferayPortletRequest, liferayPortletResponse);
				%>

				<div class="export-actions">
					<%@ include file="/html/portlet/asset_publisher/asset_export.jspf"%>
				</div>
			</c:if>
			<c:if test="<%=(showAvailableLocales && assetRenderer.isLocalizable()) && !print%>">

				<%
					String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();
				%>

				<c:if test="<%=availableLanguageIds.length > 1%>">
					<c:if test="<%=enableConversions || enablePrint%>">
						<div class="locale-separator"></div>
					</c:if>

					<div class="locale-actions">
						<liferay-ui:language displayStyle="<%=0%>"
							formAction="<%=currentURL%>" languageId="<%=languageId%>"
							languageIds="<%=availableLanguageIds%>" />
					</div>
				</c:if>
			</c:if>
		</div>
	</c:if>
	<%
		// Dynamically created asset entries are never persisted so incrementing the view counter breaks

		if (!assetEntry.isNew() && assetEntry.isVisible()) { //enableViewCountIncrement && 
			AssetEntry incrementAssetEntry = null;

			if (assetEntryQuery.isEnablePermissions()) {
				incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntry.getClassName(), assetEntry.getClassPK());
			}
			else {
				incrementAssetEntry = AssetEntryLocalServiceUtil.incrementViewCounter(user.getUserId(), assetEntry.getClassName(), assetEntry.getClassPK());
			}

			if (incrementAssetEntry != null) {
				assetEntry = incrementAssetEntry;
			}
		}

		PortletURL viewFullContentURL = renderResponse.createRenderURL();

		viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
		viewFullContentURL.setParameter("type", assetRendererFactory.getType());
		viewFullContentURL.setParameter("viewMode", print ? Constants.PRINT : Constants.VIEW);

		if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
			if (assetRenderer.getGroupId() != scopeGroupId) {
				viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
			}

			viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
		}
	%>

	<c:if test="<%=show%>">
		<div class="asset-metadata">

			<%
				request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
			%>

			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf"%>
		</div>
	</c:if>

	<div class="contentDetail text-change-size" id="<portlet:namespace /><%=assetEntry.getEntryId()%>">
		<c:if test='<%=enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") && !print%>'>
			<liferay-ui:social-bookmarks
				contentId="<%=String.valueOf(assetEntry.getEntryId())%>"
				displayStyle="<%=socialBookmarksDisplayStyle%>" target="_blank"
				title="<%=title%>"
				url="<%=PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout)%>" />
		</c:if>

		<%
			String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);

				request.setAttribute(WebKeys.ASSET_RENDERER_FACTORY, assetRendererFactory);
				request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
		%>

		<liferay-util:include page="<%=path%>"
			portletId="<%=assetRendererFactory.getPortletId()%>">
			<liferay-util:param name="showComments"
				value="<%=Boolean.FALSE.toString()%>" />
			<liferay-util:param name="showHeader"
				value="<%=Boolean.FALSE.toString()%>" />
		</liferay-util:include>

		<c:if test="<%=enableFlags%>">
			<div class="asset-flag">
				<liferay-ui:flags className="<%=assetEntry.getClassName()%>"
					classPK="<%=assetEntry.getClassPK()%>"
					contentTitle="<%=title%>"
					reportedUserId="<%=assetRenderer.getUserId()%>" />
			</div>
		</c:if>

		<c:if test='<%=enableSocialBookmarks && socialBookmarksDisplayPosition.equals("bottom") && !print%>'>
			<liferay-ui:social-bookmarks
				displayStyle="<%=socialBookmarksDisplayStyle%>" target="_blank"
				title="<%=title%>"
				url="<%=PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout)%>" />
		</c:if>

		<c:if test="<%=enableRatings%>">
			<div class="asset-ratings">

				<%
					String assetEntryClassName = assetEntry.getClassName();

						String ratingsType = "stars";

						if (assetEntryClassName.equals(MBDiscussion.class.getName()) || assetEntryClassName.equals(MBMessage.class.getName())) {
							ratingsType = "thumbs";
						}
				%>

				<liferay-ui:ratings className="<%=assetEntry.getClassName()%>"
					classPK="<%=assetEntry.getClassPK()%>" type="<%=ratingsType%>" />
			</div>
		</c:if>

		<%
			if (showContextLink) {
				if (PortalUtil.getPlidFromPortletId(assetRenderer.getGroupId(), assetRendererFactory.getPortletId()) == 0) {
					showContextLink = false;
				}
			}
		%>

		<c:if
			test="<%=showContextLink && !print && assetEntry.isVisible()%>">
			<div class="asset-more">
				<a href="<%=assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, HttpUtil.setParameter(viewFullContentURL.toString(), "redirect", currentURL))%>"><liferay-ui:message
						key="<%=assetRenderer.getViewInContextMessage()%>" /> &raquo;</a>
			</div>
		</c:if>

		<br />

		<c:if test="<%=enableRelatedAssets%>">
			<liferay-ui:asset-links assetEntryId="<%=assetEntry.getEntryId()%>" />
		</c:if>

		<c:if test="<%=Validator.isNotNull(assetRenderer.getDiscussionPath()) && enableComments%>">
			<br />
			<portlet:actionURL var="discussionURL">
				<portlet:param name="struts_action"
					value='<%="/asset_publisher/" + assetRenderer.getDiscussionPath()%>' />
			</portlet:actionURL>

			<liferay-ui:discussion className="<%=assetEntry.getClassName()%>"
				classPK="<%=assetEntry.getClassPK()%>"
				formAction="<%=discussionURL%>"
				formName='<%="fm" + assetEntry.getClassPK()%>'
				ratingsEnabled="<%=enableCommentRatings%>"
				redirect="<%=currentURL%>"
				userId="<%=assetRenderer.getUserId()%>" />
		</c:if>
	</div>
</div>
			  			</div>
             	</article>


<%
	AssetEntryQuery assetQuery = assetEntryQuery;
	
	assetQuery.setOrderByCol1(orderByColumn1);
	assetQuery.setOrderByCol2(orderByColumn2);
	assetQuery.setOrderByType1(orderByType1);
	assetQuery.setOrderByType2(orderByType2);
	assetQuery.setClassNameIds(classNameIds);
	assetQuery.setGroupIds(groupIds);
	assetQuery.setStart(0);
	assetQuery.setEnd(7);
	
	List<AssetEntry> newAssetList = AssetEntryLocalServiceUtil.getEntries(assetQuery);
%>

<c:if test="<%=newAssetList!= null && !newAssetList.isEmpty() && !print%>">
	<div class="clearfix newsDifferent">
		<div class="col-sm-12 tinlienquan">
			<hr>
			<h5 class="text-bold uppercase">
				<liferay-ui:message key="news-new" />
			</h5>
		</div>
		<div class="newsDifferent">
			<ul class="tinlienquan">
				<ul>
					<% for(AssetEntry newAsset : newAssetList){
							AssetRenderer newAssetRenderer = newAsset.getAssetRenderer();
							
							if(newAssetRenderer == null) {
								continue;
							}
							
							
							if(assetEntry.getEntryId() == newAsset.getEntryId()){
								continue;
							}
							
							
							String newAssetTitle = newAssetRenderer.getTitle(locale);
							
							PortletURL viewNewAssetContentURL = renderResponse.createRenderURL();
					
							viewNewAssetContentURL.setParameter("struts_action", "/asset_publisher/view_content");
							viewNewAssetContentURL.setParameter("type", newAsset.getAssetRendererFactory().getType());
							viewNewAssetContentURL.setParameter("displayStyle", "full_content_qb");
					
							if (Validator.isNotNull(newAssetRenderer.getUrlTitle())) {
								if (newAssetRenderer.getGroupId() != scopeGroupId) {
									viewNewAssetContentURL.setParameter("groupId", String.valueOf(newAssetRenderer.getGroupId()));
								}
					
								viewNewAssetContentURL.setParameter("urlTitle", newAssetRenderer.getUrlTitle());
							}
					
							String viewNewAssetContentURLString = viewNewAssetContentURL.toString();
					%>
					<li><a href="<%=viewNewAssetContentURLString%>"><%=newAssetTitle%></a></li>
					<%
						}
					%>
				</ul>
		</div>
	</div>
</c:if>
             </div>
         </div>
     </div>
<script type="text/javascript">
	$(document).ready(function() {
		getSize();
		$("#up").on("click", function() {

			// parse font size, if less than 50 increase font size
			if ((size + 1) <= 50) {
				$(".text-change-size").css("font-size", "+=1");
			}
		});

		$("#down").on("click", function() {
			if ((size - 1) >= 12) {
				$(".text-change-size").css("font-size", "-=1");
			}
		});
	});
	function getSize() {
		size = $(".contentDetail").css("font-size");
		size = parseInt(size, 14);
	}

	//get inital font size
</script>
<%!private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.display_full_content_jsp");%>