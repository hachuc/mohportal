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

<%@ include file="/html/portlet/journal/init.jsp" %>
<%@page import="com.liferay.portlet.asset.model.AssetLink"%>
<%@page import="com.liferay.portlet.asset.service.AssetLinkLocalServiceUtil"%>

<%
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute(WebKeys.ASSET_RENDERER_FACTORY);

JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
//JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(article.getResourcePrimKey());


String templateId = (String)request.getAttribute(WebKeys.JOURNAL_TEMPLATE_ID);
String languageId = LanguageUtil.getLanguageId(request);
int articlePage = ParamUtil.getInteger(request, "page", 1);
String viewMode = ParamUtil.getString(request, "viewMode", Constants.VIEW);

boolean workflowAssetPreview = ParamUtil.getBoolean(request, "workflowAssetPreview");

boolean showheadimg = GetterUtil.getBoolean(portletPreferences.getValue("showheadimg", null), false);

boolean showsimgsh = GetterUtil.getBoolean(portletPreferences.getValue("showsimgsh", null), false);

boolean showheaddes = GetterUtil.getBoolean(portletPreferences.getValue("showheaddes", null), true);


boolean showauthor = GetterUtil.getBoolean(portletPreferences.getValue("showauthor", null), true);

String portletTitle1 = portletPreferences.getValue("portletTitle", StringPool.BLANK);


JournalArticleDisplay articleDisplay = null;

if (!workflowAssetPreview && article.isApproved()) {
	String xmlRequest = PortletRequestUtil.toXML(renderRequest, renderResponse);

	articleDisplay = JournalContentUtil.getDisplay(article.getGroupId(), article.getArticleId(), article.getVersion(), templateId, viewMode, languageId, themeDisplay, articlePage, xmlRequest);
}
else {
	articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(article, null, viewMode, languageId, 1, null, themeDisplay);
}
%>

<%
String smallImagePath = StringPool.BLANK;
if (articleDisplay.isSmallImage()) {
	if (Validator.isNotNull(articleDisplay.getSmallImageURL())) {
		smallImagePath = articleDisplay.getSmallImageURL();
	} else {
		smallImagePath = themeDisplay.getPathImage()
				+ "/journal/article?img_id="
				+ articleDisplay.getSmallImageId()
				+ "&t="
				+ WebServerServletTokenUtil.getToken(articleDisplay
						.getSmallImageId());
	}
}
%>



<div class="sapo-wrapper clearfix">

<c:if test='<%= showheadimg %>'>
	<c:if test="<%= Validator.isNotNull(smallImagePath) %>">
		<img src="<%= smallImagePath %>" alt="" class="pull-left" style="margin-right: 5px; width: 250px; padding: 0 10px 10px 0;">
	</c:if>
	
	</c:if>
	
	<c:if test='<%= showheaddes %>'>
	
	<p class="sapo">
		<strong><%= HtmlUtil.escape(articleDisplay.getDescription()) %></strong>
	</p>
	</c:if>
	
</div>
<% 
boolean showRelatednew = GetterUtil.getBoolean(portletPreferences.getValue("showRelatednew", null), true);
%>
<c:if test='<%= showRelatednew %>'>
<style>
.Relatednew {
    border: 1px solid #145192;
    padding: 10px;
    position: relative;
    margin-top: 5px;
    border-width: 1px 0;
}
.Relatednew .related_asset_title {
    background-color: white;
    display: inline-block;
    padding: 3px 10px;
    position: absolute;
    top: -12px;
    color: #145192;
    font-weight: bold
}
.Relatednew ul li {
    padding-left: 3px !important;
    position: relative;
    margin: 5px 0;
    color: #555;
}
.Relatednew ul li:before {
    content: "\f0c8";
    font-family: FontAwesome;
    position: absolute;
    top: 4px;
    left: -10px !important;
    font-size: 6px;
    color: #145192;
}

</style>
<div class="Relatednew">
<div class="related_asset_title"><liferay-ui:message key="news-relate"/></div>
	<ul>
	<%
	String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_input_asset_links_page") + StringPool.UNDERLINE;
	String eventName = randomNamespace + "selectAsset";
	
	JournalArticle article1 = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
	
	
	
	
	
	
	try {
		article1 = JournalArticleLocalServiceUtil.getArticle(scopeGroupId, String.valueOf(article1.getArticleId()));
	} catch(Exception e){}
	
	long resourcePrimaryKey = (Validator.isNotNull(article1)) ? article1.getResourcePrimKey() : 0;
	
	String className = JournalArticle.class.getName();
	
	AssetEntry  assetEntryReq = AssetEntryLocalServiceUtil.fetchEntry(className, resourcePrimaryKey);
	
	long assetEntryId = Validator.isNotNull(assetEntryReq) ? assetEntryReq.getPrimaryKey() : 0;
	
	List<AssetLink> assetLinks = new ArrayList<AssetLink>();
	
	String assetLinksSearchContainerPrimaryKeys = ParamUtil.getString(request, "assetLinksSearchContainerPrimaryKeys");
	if (Validator.isNull(assetLinksSearchContainerPrimaryKeys) && SessionErrors.isEmpty(renderRequest) && (assetEntryId > 0)) {
		List<AssetLink> directAssetLinks = AssetLinkLocalServiceUtil.getDirectLinks(assetEntryId);
		for (AssetLink assetLink : directAssetLinks) {
			AssetEntry assetLinkEntry = null;
			if ((assetEntryId > 0) || (assetLink.getEntryId1() == assetEntryId)) {
				assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId2());
			}
			else {
				assetLinkEntry = AssetEntryLocalServiceUtil.getEntry(assetLink.getEntryId1());
			}
	
			AssetRendererFactory assetRendererFactory1 = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(assetLinkEntry.getClassName());
			AssetRenderer assetRenderer1 = assetRendererFactory.getAssetRenderer(assetLinkEntry.getClassPK());
			String newAssetTitle1 = assetRenderer1.getTitle(locale);
			if (assetRendererFactory1.isActive(company.getCompanyId())) {
				assetLinks.add(assetLink);
			}
			
			PortletURL viewNewAssetContentURL = renderResponse.createRenderURL();
	
			
			
			viewNewAssetContentURL.setParameter("struts_action", "/asset_publisher/view_content");
			viewNewAssetContentURL.setParameter("type", assetLinkEntry.getAssetRendererFactory().getType());
			
			viewNewAssetContentURL.setParameter("urlTitle", assetRenderer1.getUrlTitle());
			String viewNewAssetContentURLString = viewNewAssetContentURL.toString();
			
			assetLinkEntry = assetLinkEntry.toEscapedModel();
			
			%>
			
			<li><a href="<%=viewNewAssetContentURLString%>"><%=newAssetTitle1 %></a></li>
		<%
			
		}
	}
	
	
	
	%>
	</ul>
</div>
<% if(assetLinks.isEmpty()){ 

%>

<style>
.Relatednew{
display: none !important;
}
</style>
<%
}
%>

</c:if>


<c:if test="<%= !showsimgsh %>" >
<div class="journal-content-article">
<%
String pattern = "pt\"";
String content = articleDisplay.getContent().replace(pattern, "px\"");

 pattern = "pt;\"";
 content = content.replace(pattern, "px;\"");

%>
	<%= RuntimePageUtil.processXML(request, response, content) %>
	<c:if test='<%= showauthor %>'>
	
	<p align="right" class="view-content-author">
		<strong><em><%= HtmlUtil.escape(PortalUtil.getUserName(articleDisplay.getUserId(), StringPool.BLANK)) %></em></strong>
	</p>
	</c:if>
	
</div>
</c:if>
<c:if test="<%= showsimgsh %>" >

	<div class="journal-content-article">
							<%= RuntimePageUtil.processXML(request, response, articleDisplay.getContent()) %>
	</div>

</c:if>
<c:if test="<%= articleDisplay.isPaginate() %>">

	<%
	String pageRedirect = ParamUtil.getString(request, "redirect");

	if (Validator.isNull(pageRedirect)) {
		pageRedirect = currentURL;
	}

	int cur = ParamUtil.getInteger(request, "cur");

	PortletURL articlePageURL = renderResponse.createRenderURL();

	articlePageURL.setParameter("struts_action", "/asset_publisher/view_content");
	articlePageURL.setParameter("type", assetRendererFactory.getType());
	articlePageURL.setParameter("redirect", pageRedirect);
	articlePageURL.setParameter("urlTitle", articleDisplay.getUrlTitle());
	articlePageURL.setParameter("cur", String.valueOf(cur));
	%>

	<br />

	<liferay-ui:page-iterator
		cur="<%= articleDisplay.getCurrentPage() %>"
		curParam="page"
		delta="<%= 1 %>"
		id="articleDisplayPages"
		maxPages="<%= 25 %>"
		total="<%= articleDisplay.getNumberOfPages() %>"
		type="article"
		url="<%= articlePageURL.toString() %>"
	/>

	<br />
</c:if>