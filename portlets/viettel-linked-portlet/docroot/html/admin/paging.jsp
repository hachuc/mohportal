<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.sun.corba.se.spi.orb.StringPair"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/admin/init.jsp"%>

<%
    totalPage = ParamUtil.getInteger(request, "totalPage", 1);
    curLinkPage = ParamUtil.getInteger(request, "curLinkPage", 1);
    PortletURL pageURL = renderResponse.createRenderURL();
    pageURL.setParameter("categoryId", String.valueOf(categoryId));
    
%>
<div class="contact-paging-wrapper">
    <div class="contact-paging-container">
        <%
        PortletURL firstPageURL = pageURL;
        firstPageURL.setParameter("curLinkPage", String.valueOf(1));
        
        PortletURL prevPageURL = pageURL;
        prevPageURL.setParameter("curLinkPage", String.valueOf(curLinkPage -1));
        %>
	    <a class="first-page" href="<%=firstPageURL%>"><span class=""></span></a>
	    <a class="prev-page" href="<%=prevPageURL%>"><span class=""></span></a>
		<ul class="contact-paging">
		    
		<%
		   int pageTemp = curLinkPage;
		
		   int count = 1;
		   
		   while(pageTemp <= totalPage && count <= displayPage){
			   
			   String selectedPage = StringPool.BLANK;
			   
			   if(pageTemp == curLinkPage){
				   
				   selectedPage = "selected-page";
			   }
			   %>
			       <li class="page-number <%=selectedPage%>"><a href=""><%=pageTemp %></a></li>
			   <%
			   pageTemp += 1;
		       count += 1;
		   }
		%>
		</ul>
	    <a class="next-page" href=""><span class=""></span></a>
	    <a class="last-page" href=""><span class=""></span></a>
    </div>
</div>

