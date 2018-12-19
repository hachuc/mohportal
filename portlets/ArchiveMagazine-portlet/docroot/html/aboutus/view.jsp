<%@include file="/html/aboutus/init.jsp"%>
<div class="mt15">
	<div class="headerBox">
		<a href="<%= url %>"><%= HtmlUtil.escape(portletTitle) %></a>
	</div>
<table class="table table-bordered table-striped">
    <thead>
      <tr style="background-color: #F1DB51";>
        <th colspan="2"><a href="<%= url %>" style="color: red;"><%= HtmlUtil.escape(portletTitle2) %></a></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="col-md-5 text-bold"><liferay-ui:message key="job1-title" />:</td>
        <td class="col-md-7 text-bold" style="color:red;"><%= HtmlUtil.escape(job1Title) %></td>
      </tr>
      <tr>
        <td class="col-md-5 text-bold"><liferay-ui:message key="job2-title" />:</td>
        <td class="col-md-7 text-bold" style="color:red;"><%= HtmlUtil.escape(job2Title) %></td>
      </tr>
      <tr>
        <td class="col-md-5 text-bold"><liferay-ui:message key="job3-title" />:</td>
        <td class="col-md-7 text-bold" style="color:red;"><%= HtmlUtil.escape(job3Title) %></td>
      </tr>
    </tbody>
  </table>
</div>