
<%@ include file="/html/init.jsp" %>

<%
	List<Group> sites = NewsPublisherUtil.getSiteAvailables(themeDisplay);
%>

<liferay-portlet:renderURL portletConfiguration="true" varImpl="configurationRenderURL" >
	<liferay-portlet:param name="jspPage" value="/html/configuration.jsp"/>
</liferay-portlet:renderURL>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" >
	<liferay-portlet:param name="portletResource" value="<%=portletResource %>"/>
</liferay-portlet:actionURL>

<liferay-portlet:renderURL portletName="<%=portletResource %>" var="editQueryRuleURL" 
	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/config/edit_query_rule.jsp"/>
</liferay-portlet:renderURL>

<liferay-portlet:renderURL portletName="<%=portletResource %>" var="renderCnfBlockURL" 
	windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
	<liferay-portlet:param name="jspPage" value="/html/config/cnf_block_pattern.jsp"/>
</liferay-portlet:renderURL>


<aui:form action="<%=configurationActionURL%>" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	
	<liferay-ui:panel-container cssClass="cnf-panel"> 
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="display-setting" 
			persistState="<%= true %>" title="display-settings">
			<aui:fieldset >
				<aui:input type="text" name="preferences--portletTitle--" label="portlet-title" value="<%=portletTitle %>"/>
				
				<aui:input type="text" name="preferences--portletClass--" label="portlet-class" value="<%=portletClass %>"/>
				
				<div id='<portlet:namespace/>layoutUuidWrapper'>
					<aui:select name="preferences--layoutUuid--" label="link-to-page" showEmptyOption="<%=true %>">
						<%=HtmlUtil.escape(NewsPublisherUtil.buildLayoutsToSelect(layoutUuid, true, themeDisplay)) %>
					</aui:select>
				</div>
				
				<div class="hide1">
					<aui:select name="preferences--scopeId--" label="scope" multiple="<%= true %>">
					<% for(Group site : sites) { %>
						<c:if test="<%= site.isSite() %>">
							<aui:option value="<%= site.getGroupId() %>" label="<%= HtmlUtil.escape(site.getDescriptiveName(locale)) %>" selected="<%= ArrayUtil.contains(arrGroupIds, site.getGroupId()) %>"/>
						</c:if>
					<%
					
					} %>
					</aui:select>
				</div>
				
				<aui:select name="displayStyle" id="displayStyle">
					<aui:option value="focus_news_tyle" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "focus_news_tyle") %>' label="focus_news_tyle"/>
					<aui:option value="flash_news" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "flash_news") %>' label="flash_news"/>
					<aui:option value="slider_show" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "slider_show") %>' label="slider_show"/>
					<aui:option value="suvien_ykien" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "suvien_ykien") %>' label="suvien_ykien"/>	
					<aui:option value="anpham_tapchi" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "anpham_tapchi") %>' label="press_release_style"/>					
					<aui:option value="phongsu_anh" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "phongsu_anh") %>' label="phongsu_anh"/>														
					<aui:option value="block_2_boxes" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "block_2_boxes") %>' label="block_2_boxes"/>
					<aui:option value="sub_category_style" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "sub_category_style") %>' label="sub_category_style"/>
					<aui:option value="small_image_list_style" selected='<%=StringUtil.equalsIgnoreCase(displayStyle, "small_image_list_style") %>' label="small_image_list_style"/>					
				</aui:select>
			</aui:fieldset>
				
			<aui:fieldset id="cnf-block-pattern" cssClass="aui-helper-hidden">
				
				<div class="cnf-display-wrapper">
					<aui:input label="" type="hidden" id="blockNumber" name="blockNumber" value="<%=blockNumber %>"/>
					<aui:input label="" type="hidden" id="blockIndex" name="blockIndex" value="<%=blockIndex %>"/>
					<div class="add-block">
						<div class="btn" id="add-block"><liferay-ui:message key="add-block"/></div>
					</div>
					
					<%
						String[] arrIndex = StringUtil.split(blockIndex);
					
						if(blockNumber > 0 && arrIndex!= null){
							for(int i = 0; i < arrIndex.length; i++){
								%>
									<liferay-util:include page="/html/config/cnf_block_pattern.jsp" servletContext="<%=this.getServletContext() %>">
										<portlet:param name="index" value="<%=arrIndex[i] %>"/>
									</liferay-util:include>
								<%
							}
						}
					%>
				</div>
			</aui:fieldset>
			
			
			<aui:fieldset>
				<aui:input type="checkbox" name="preferences--showMore--" label="show-more-link" value="<%=showMore %>" checked="<%=showMore %>"/>
				
				<aui:input type="checkbox" name="preferences--showSmallImage--" label="show-small-image" value="<%=showSmallImage %>" checked="<%=showSmallImage %>"/>
				
				<aui:input type="checkbox" name="preferences--showSummary--" label="show-summary" value="<%=showSummary %>" checked="<%=showSummary %>"/>
				
				<aui:input type="checkbox" name="preferences--useImageDefault--" label="show-image-default-if-do-not-image"
					value="<%=useImageDefault %>" checked="<%=useImageDefault %>"/>
				
				<aui:select name="preferences--displayItem--" label="display-item">
					<%
					int[] displayItems = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100};
			
					for (int displayItem_ : displayItems) {
					%>
			
						<aui:option label="<%= displayItem_ %>" selected="<%= (displayItem_ == displayItem) %>" />
			
					<%
					}
					%>
				</aui:select>
				
				<aui:select name="preferences--titleLength--" label="title-length">
					<%
					int[] titleLengths = {20, 50, 80, 100, 110, 120, 130, 140, 150, 170, 200, 250, 300};
			
					for (int titleLength_ : titleLengths) {
					%>
			
						<aui:option label="<%= titleLength_ %>" selected="<%= (titleLength_ == titleLength) %>" />
			
					<%
					}
					%>
				</aui:select>
			
				<aui:select name="preferences--paginationType--">
				<aui:option label="none" selected='<%= paginationType.equals("none") %>' />
				<aui:option label="simple" selected='<%= paginationType.equals("simple") %>' />
				<aui:option label="regular" selected='<%= paginationType.equals("regular") %>' />
				
			
				</aui:select>
				
				<aui:select name="preferences--summaryLength--" label="summary-length">
					<%
					int[] summaryLengths = {50, 100, 150, 200, 250, 3000, 400, 500};
			
					for (int summaryLength_ : summaryLengths) {
					%>
			
						<aui:option label="<%= summaryLength_ %>" selected="<%= (summaryLength_ == summaryLength) %>" />
			
					<%
					}
					%>
				</aui:select>
				
				<aui:input type="checkbox" name="preferences--displayPublishedDate--" label="display-date"
					value="<%=displayPublishedDate %>" checked="<%=displayPublishedDate %>"/>
					
				<aui:input type="checkbox" name="preferences--displayIconNew--" label="display-icon-new"
					value="<%=displayIconNew %>" checked="<%=displayIconNew %>"/>
			</aui:fieldset>
			
		</liferay-ui:panel>
		
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" 
				id="filter-setting" persistState="<%= true %>" title="filter[action]" cssClass="aui-helper-hidden">
				
			<liferay-ui:asset-tags-error />
			<aui:fieldset>
				<liferay-util:include page="/html/config/edit_query_rule.jsp" servletContext="<%= application %>" />
			</aui:fieldset>
			
		</liferay-ui:panel>
			
		<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>" id="order-and-group-setting" persistState="<%= true %>" title="order-and-group-setting">
			<aui:fieldset>
				<span class="aui-field-row" style="display: block;">
					<aui:select inlineField="<%= true %>" inlineLabel="left" label="order-by" name="preferences--orderByColumn1--">
						<aui:option label="article-title" selected='<%= orderByColumn1.equals("title") %>' />
						<aui:option label="publish-date" selected='<%= orderByColumn1.equals("publishDate") %>' value="publishDate" />
						<aui:option label="view-count" selected='<%= orderByColumn1.equals("viewCount") %>' value="viewCount" />
					</aui:select>

					<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType1--">
						<aui:option label="ascending" selected='<%= orderByType1.equals("asc") %>' value="asc" />
						<aui:option label="descending" selected='<%= orderByType1.equals("desc") %>' value="desc" />
					</aui:select>
				</span>

				<span class="aui-field-row" style="display: block;">
					<aui:select inlineField="<%= true %>" inlineLabel="left" label="and-then-by" name="preferences--orderByColumn2--">
						<aui:option label="article-title" selected='<%= orderByColumn2.equals("title") %>' />
						<aui:option label="publish-date" selected='<%= orderByColumn2.equals("publishDate") %>' value="publishDate" />
						<aui:option label="view-count" selected='<%= orderByColumn2.equals("viewCount") %>' value="viewCount" />
					</aui:select>

					<aui:select inlineField="<%= true %>" label="" name="preferences--orderByType2--">
						<aui:option label="ascending" selected='<%= orderByType2.equals("asc") %>' value="asc" />
						<aui:option label="descending" selected='<%= orderByType2.equals("desc") %>' value="desc" />
					</aui:select>
				</span>
			</aui:fieldset>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
	
	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "saveSelectBoxes();" %>' type="submit"/>
	</aui:button-row>
</aui:form>
<aui:script>
	AUI().ready(function(A){
		
		var displayStyle = '<%=displayStyle%>';
		<portlet:namespace />loadingDialogState(displayStyle);
		
		var displayStyleInput = A.one("#<portlet:namespace/>displayStyle");
		displayStyleInput.on('change', function(){
			var value = displayStyleInput.val();
			<portlet:namespace />loadingDialogState(value);
		});
		
		var addBlock = A.one('#add-block');
		addBlock.on('click', function(){
			var cnfBlockPattern = A.one('#<portlet:namespace/>cnf-block-pattern');
			cnfBlockPattern.plug(A.LoadingMask);
			cnfBlockPattern.loadingmask.show();
			<portlet:namespace />renderCnfBlock();
		});
		
		var removeBlocks = A.all('div.remove-block');
		if(removeBlocks){
			removeBlocks.each(function(item){
				item.on('click', function(){
					var blockNumberInput = A.one('#<portlet:namespace/>blockNumber');
					var blockNumber = parseInt(blockNumberInput.val()) - 1;
					var blockIndexInput = A.one('#<portlet:namespace/>blockIndex');
					var blockIndex = blockIndexInput.val();
					blockNumberInput.val(blockNumber);
					
					var indexArray = blockIndex.split(",");
					var removeIndex = item.attr('index');
					var index = indexArray.indexOf(removeIndex);
					if (index > -1) {
						indexArray.splice(index, 1);
					}
					blockIndexInput.val(indexArray);
					
					item.ancestor('div').ancestor('div').remove();
				});
			});
		}
	});
	
	Liferay.provide(window, '<portlet:namespace />renderCnfBlock',
		function(){
			
	    	var A = AUI();
			var blockNumberInput = A.one('#<portlet:namespace/>blockNumber');
			var blockIndexInput = A.one('#<portlet:namespace/>blockIndex');
			var blockNumber = parseInt(blockNumberInput.val()) + 1; 
			var blockIndex = blockIndexInput.val();
			var indexArray = blockIndex.split(",");
			var displayStyle = A.one('#<portlet:namespace/>displayStyle');
			blockNumberInput.val(blockNumber);
			indexArray.push(blockNumber);
			
			blockIndexInput.val(indexArray);
			
	        A.io.request(
	        	'<%=configurationActionURL.toString() %>',
	            {
	            	dataType: 'json',
	                data:{
	                	_<%= PortletKeys.PORTLET_CONFIGURATION %>_cmd: '<%=Constants.UPDATE%>',
	                	_<%= PortletKeys.PORTLET_CONFIGURATION %>_addNewsBlock: 'true',
	                	_<%= PortletKeys.PORTLET_CONFIGURATION %>_blockNumber: blockNumber,
						_<%= PortletKeys.PORTLET_CONFIGURATION %>_blockIndex: blockIndexInput.val(),
						_<%= PortletKeys.PORTLET_CONFIGURATION %>_displayStyle: displayStyle.val()
	                	
	                },   
	                on: {
	                	success: function(data) {
	                		location.reload();
	                		var cnfBlockPattern = A.one('#<portlet:namespace/>cnf-block-pattern');
	            			cnfBlockPattern.plug(A.LoadingMask);
	            			cnfBlockPattern.loadingmask.hide();
	            			<portlet:namespace />loadingDialogState();
	                  	},
	                  	error: function(){}
	            	}
				}
	    	);
		},['aui-io']
	);
	
	Liferay.provide(window, '<portlet:namespace />loadingDialogState',
		function(value){
		    var A = AUI();
		    var filterPanel = A.one('#filter-setting');
		    var layoutUuid = A.one('#<portlet:namespace/>layoutUuidWrapper');
		    var cnfBlockPattern = A.one('#<portlet:namespace/>cnf-block-pattern');
			if(value.substring(0, 6) == 'block_'){
				filterPanel.hide();
				layoutUuid.hide();
				cnfBlockPattern.show();
			}else{
				layoutUuid.show();
				filterPanel.show();
				cnfBlockPattern.hide();
			}
		}
	);
</aui:script>


