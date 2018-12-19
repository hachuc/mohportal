<%@page import="java.util.Arrays"%>
<%@page import="com.viettel.portal.vcms.service.ContentLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.viettel.portal.vcms.model.Content"%>
<%@page import="com.viettel.portal.vcms.permission.CategoryPermission"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.viettel.portal.vcms.model.Category"%>
<%@ page
    import="com.viettel.portal.vcms.service.CategoryLocalServiceUtil"%>
<%@include file="/html/admin/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%
System.out.println("compare_content");
    long contentId = ParamUtil.getLong(request, "contentId", 0L);
    int version = ParamUtil.getInteger(request, "version");
    int versionLeft = ParamUtil.getInteger(request, "versionLeft", 4);
    int versionRight = ParamUtil.getInteger(request, "versionRight", 4);
    int statusBt = ParamUtil.getInteger(request, "statusBt",0);
    int indexL = 0, indexR = 0;
    List<Content> contents = ContentLocalServiceUtil
            .findByGroupContent(scopeGroupId, contentId);
    Content contentLeft = null, contentRight = null;
    for(Content sub : contents){
        if(sub.getVersion() == versionLeft)
            contentLeft = sub;
        if(sub.getVersion() == versionRight)
            contentRight = sub;
    }
%>
<liferay-ui:panel-container cssClass="basic-info" id="basic-info-container" extended="true">

    <liferay-ui:panel collapsible="<%=false%>" extended="<%=true%>"
        id="basic-info" persistState="<%=true%>" title='so-sanh-bai-viet'
        iconCssClass="glyphicon icon-random">
        <aui:fieldset>
        <aui:form action="<%=PortalUtil.getCurrentURL(request)%>" method="post" name="fm">
            <aui:input type="hidden" name="diffs" value="true" />
            <aui:column columnWidth="50">
                <div class="list_header">
                        <aui:select name="versionLeft" label="Phiên bản chọn"  inlineLabel="true" onChange='<%= renderResponse.getNamespace() + "versionChanged();" %>' style="width: 50%; margin-bottom: 0;">
                            <aui:option  value='1' selected="<%=versionLeft == 1 %>"><liferay-ui:message key="version-creator" /></aui:option>
                            <aui:option  value='2' selected="<%=versionLeft == 2 %>"><liferay-ui:message key="version-editor" /></aui:option>
                            <aui:option  value='3' selected="<%=versionLeft == 3 %>"><liferay-ui:message key="version-reviewer" /></aui:option>
                            <aui:option  value='4' selected="<%=versionLeft == 4 %>"><liferay-ui:message key="version-deployer" /></aui:option>
                        </aui:select>
                </div>
                <c:if test='<%=contentLeft != null%>'>
                    <%
                        String authorLeft = PortalUtil.getUserName(contentLeft.getCreatedByUserId(), "");
                        String editorLeft = PortalUtil.getUserName(contentLeft.getEditedByUserId(), "");
                        String approverLeft = PortalUtil.getUserName(contentLeft.getReviewedByUserId(), "");
                        String deployerLeft = PortalUtil.getUserName(contentLeft.getPublishedByUserId(), "");
                    %>
                    <div class="main-content">
                        <div class="content-wrapper">
                            <c:if test='<%=contentLeft.getSubTitle().length()>0%>'>
                                <p style="color: red; font-size: 14px;"><%=HtmlUtil.escape(contentLeft.getSubTitle())%></p>
                            </c:if>
                            <div class="story" id="title1">
                                <span style="font-size: 18px;"><%=HtmlUtil.escape(contentLeft.getTitle())%></span>
                            </div>
                            <div class="storytime">
                                <span><%=dateTimeFormat.format(contentLeft.getCreateDate())%></span>
                            </div>
                            <c:if test='<%=contentLeft.getSmallImageUrl().length()>0 || contentLeft.getSummary().length()>0  %>'>
                                <div class="img-caption" style="height: 155px;" >
                                    <c:if test='<%=contentLeft.getSmallImageUrl().length()>0 %>'>
                                        <img src="<%=contentLeft.getSmallImageUrl() %>" alt="Image Caption"  style="float: left;width: 20%; height: 150px; margin: 5px ">
                                    </c:if>
                                    <c:if test='<%=contentLeft.getSummary().length()>0 && contentLeft.getSmallImageUrl().length()>0%>'>
                                        <p style="float: left; width:75%;"><%=HtmlUtil.escape(contentLeft.getSummary()) %></p>
                                    </c:if>
                                    <c:if test='<%=contentLeft.getSummary().length()>0 && contentLeft.getSmallImageUrl().length()<=0%>'>
                                        <p style="float: left; width:100%;"><%=HtmlUtil.escape(contentLeft.getSummary()) %></p>
                                    </c:if>
                                </div>
                            </c:if>
                            <div>
                            </div>
                            <hr>
                            <c:if test="<%=contentLeft.getCopyRight().length()>0 %>">
                            <div class="text">
                            	
                            		<strong style="font-style: italic;">( <%=HtmlUtil.escape(contentLeft.getCopyRight()) %> )</strong>
                            	
                            </div>
                            </c:if>
                            
                            <div class="text" >
                            	<%=HtmlUtil.escape(contentLeft.getSubContent()) %>
                            </div>
                            <div class="text" id="content1">
                                <%= HtmlUtil.escape(contentLeft.getContent()) %>
                            </div>
                            <c:if test='<%=contentLeft.getAuthor().length()>0 %>'>
                                <div style="text-align: right;">
                                    <%=HtmlUtil.escape(contentLeft.getAuthor()) %>
                                </div>
                            </c:if>
                            <div class="author-info">
                                <div class="notice">
                                    <c:if test='<%=version >= 1%>'>
                                        <span><liferay-ui:message key="creator-by-user" /> :</span>
                                        <strong><%=HtmlUtil.escape(authorLeft)%></strong>
                                    </c:if>
                                    <c:if test='<%=version >= 2%>'>
                                        <span><liferay-ui:message key="editor-by-user" /> : <%=HtmlUtil.escape(editorLeft)%></span>
                                    </c:if>
                                    <c:if test='<%=version >= 3%>'>
                                        <span><liferay-ui:message key="reviewer-by-user" /> :
                                            <%=HtmlUtil.escape(approverLeft)%></span>
                                    </c:if>
                                    <c:if test='<%=version == 4%>'>
                                        <span><liferay-ui:message key="deployer-by-user" /> :
                                            <%=HtmlUtil.escape(deployerLeft)%></span>
                                    </c:if>
                                </div>
                            </div>                      
                        </div>
                    </div>
                </c:if>
            </aui:column>
            <aui:column columnWidth="50">
                <div class="list_header">
                        <aui:select name="versionRight" label="Phiên bản so sánh" inlineLabel="true" onChange='<%= renderResponse.getNamespace() + "versionChanged();" %>' style="width: 50%; margin-bottom: 0;">
                            <aui:option  value='1' selected="<%=versionLeft == 1 %>"><liferay-ui:message key="version-creator" /></aui:option>
                            <aui:option  value='2' selected="<%=versionLeft == 2 %>"><liferay-ui:message key="version-editor" /></aui:option>
                            <aui:option  value='3' selected="<%=versionLeft == 3 %>"><liferay-ui:message key="version-reviewer" /></aui:option>
                            <aui:option  value='4' selected="<%=versionLeft == 4 %>"><liferay-ui:message key="version-deployer" /></aui:option>
                        </aui:select>
                </div>
                <c:if test='<%=contentRight != null%>'>
                    <%
                        String authorRight = PortalUtil.getUserName(contentRight.getCreatedByUserId(), "");
                        String editorRight = PortalUtil.getUserName(contentRight.getEditedByUserId(), "");
                        String approverRight = PortalUtil.getUserName(contentRight.getReviewedByUserId(), "");
                        String deployerRight = PortalUtil.getUserName(contentRight.getPublishedByUserId(), "");
                    %>
                    <div class="main-content">
                        <div class="content-wrapper">
                            <c:if test='<%=contentRight.getSubTitle().length()>0 %>'>
                                <p style="color: red; font-size: 14" ><%=HtmlUtil.escape(contentRight.getSubTitle()) %></p>
                            </c:if>
                            <div class="story" id="title2">
                                <span style="font-size: 18px;"><%=HtmlUtil.escape(contentRight.getTitle())%></span>
                            </div>
                            <div class="storytime"> 
                                <span><%=dateTimeFormat.format(contentRight.getCreateDate())%></span>
                            </div>
                            <c:if test="<%=contentRight.getSmallImageUrl().length()>0 || contentRight.getSummary().length()>0 %>">
                                <div class="img-caption" style="height: 155px;" >
                                <c:if test='<%=contentRight.getSmallImageUrl().length()>0 %>'>
                                    <img src="<%=contentRight.getSmallImageUrl() %>" alt="Image Caption"  style="float: left;width: 20%; height: 150px; margin: 5px ">
                                </c:if>
                                <c:if test='<%=contentRight.getSummary().length()>0 && contentRight.getSmallImageUrl().length()>0%>'>
                                    <p style="float: left;width:75%; "><%=HtmlUtil.escape(contentRight.getSummary()) %></p>
                                </c:if>
                                <c:if test='<%=contentRight.getSummary().length()>0 && contentRight.getSmallImageUrl().length()<=0%>'>
                                    <p style="float: left;width:100%; "><%=HtmlUtil.escape(contentRight.getSummary()) %></p>
                                </c:if>
                            </div>
                            </c:if>
                            <hr>
                            <c:if test="<%=contentRight.getCopyRight().length()>0 %>">
                            <div class="text">
                            		<strong style="font-style: italic;">( <%=HtmlUtil.escape(contentRight.getCopyRight()) %> )</strong>
                            </div>
                            </c:if>
                            
                            <div class="text">
                            	<%=HtmlUtil.escape(contentRight.getSubContent()) %>
                            </div>
                            <div class="text" id="content2">
                                <%= HtmlUtil.escape(contentRight.getContent()) %>
                            </div>
                            <c:if test='<%=contentRight.getAuthor().length()>0 %>'>
                                <div style="text-align: right;">
                                    <%=HtmlUtil.escape(contentRight.getAuthor()) %>
                                </div>
                            </c:if>
                            <div class="author-info">
                                <div class="notice">
                                    <c:if test='<%=version >= 1%>'>
                                        <span><liferay-ui:message key="creator-by-user" /> : <%=HtmlUtil.escape(authorRight)%></span>
                                    </c:if>
                                    <c:if test='<%=version >= 2%>'>
                                        <span><liferay-ui:message key="editor-by-user" /> : <%=HtmlUtil.escape(editorRight)%></span>
                                    </c:if>
                                    <c:if test='<%=version >= 3%>'>
                                        <span><liferay-ui:message key="reviewer-by-user" /> : <%=HtmlUtil.escape(approverRight)%></span>
                                    </c:if>
                                    <c:if test='<%=version == 4%>'>
                                        <span><liferay-ui:message key="deployer-by-user" /> : <%=HtmlUtil.escape(deployerRight)%></span>
                                    </c:if>
                                </div>
                            </div>                            
                        </div>
                    </div>
                </c:if>
            </aui:column>
            <aui:row >
                
                <aui:column style="text-align:center;" columnWidth="100">
                    <portlet:renderURL var="publishContentURL">
                        <portlet:param name="mvcPath" value='<%= templatePath + "publish_content.jsp" %>' />
                        <portlet:param name="autoId" value="<%= String.valueOf(contentLeft.getAutoId()) %>"/>
                        <portlet:param name="contentId" value="<%= String.valueOf(contentLeft.getContentId()) %>"/>
                        <portlet:param name="redirect" value="<%= redirect %>"/>
                    </portlet:renderURL>
                    <portlet:actionURL var="publishActionURL" name="updateNextStatus">
                        <portlet:param name="autoId" value="<%=String.valueOf(contentLeft.getAutoId())%>" />
                        <portlet:param name="cmd" value="UDDEPLOYER" />
                        <portlet:param name="version" value="<%=String.valueOf(contentLeft.getVersion())%>" />
                        <portlet:param name="nextStatus" value="4096" />
                        <portlet:param name="redirect" value="<%=publishContentURL.toString()%>" />
                    </portlet:actionURL>
                    <c:if test='<%=versionLeft<4 || statusBt==8192%>'>
                        <aui:button disabled='disabled' name="btnChontrienkhai" value="chon-trien-khai"  />
                        <aui:button disabled='disabled' name="btnChonlambanchinh" value="chon-lam-ban-chinh" />
                    </c:if>
                    <c:if test='<%=versionLeft==4 && statusBt!=8192%>'>
                        <aui:button  name="btnChontrienkhai" value="chon-trien-khai" href="<%=publishActionURL %>" />
                        <aui:button  name="btnChonlambanchinh" value="chon-lam-ban-chinh" />
                    </c:if>
                </aui:column>
                
            </aui:row>
            <aui:row>
                <aui:column>
                    <strong>Chú ý : Khi bạn chọn làm phiên bản chính. Nội dung phiên bản được so sánh sẽ bị ghi đè bởi nội dung của phiên bản chọn.</strong>
                </aui:column>
            </aui:row>
        </aui:form>
        </aui:fieldset>
    </liferay-ui:panel>
</liferay-ui:panel-container>
<aui:script>
document.getElementById('title1').innerHTML = '<%=HtmlUtil.escapeJS(contentLeft.getTitle()) %>';
var diffTitle = <portlet:namespace />diff('<%=HtmlUtil.escapeJS(contentLeft.getTitle()) %>', '<%=HtmlUtil.escapeJS(contentRight.getTitle()) %>');
document.getElementById('title2').innerHTML = diffTitle;
document.getElementById('content1').innerHTML = '<%=HtmlUtil.escapeJS(contentLeft.getContent()) %>';
var diffDescription = <portlet:namespace />diff('<%=HtmlUtil.escapeJS(contentLeft.getContent()) %>', '<%=HtmlUtil.escapeJS(contentRight.getContent()) %>');
document.getElementById('content2').innerHTML = diffDescription;
function <portlet:namespace />versionChanged(){
    submitForm(document.<portlet:namespace />fm);
}
function <portlet:namespace />diff(text1, text2) {
    var dmp = new diff_match_patch();
    dmp.Diff_Timeout = parseFloat('3');
    var d = dmp.diff_main(text1, text2);
    dmp.diff_cleanupSemantic(d);
    var ds = dmp.diff_prettyHtml(d);
    return ds;
}
function <portlet:namespace />initArticleContent1() {
    return '<%=UnicodeFormatter.toString(contentLeft.getContent()) %>';
}
function <portlet:namespace />initArticleContent2() {
    var text1 = <portlet:namespace />initArticleContent1();
    var text2 = '<%=UnicodeFormatter.toString(contentRight.getContent()) %>';
    return <portlet:namespace />diff(text1, text2);
}
</aui:script>