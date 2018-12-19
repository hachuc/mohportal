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
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="init.jsp"%>

<%
	String randomInstance = PwdGenerator.getPassword();
	String elementName = name;
%>

<style>
	.bound-category-taglib {
		position: relative;
	}
	
	.bound-category-taglib>div:last-child {
		border: 1px solid #ccc;
		border-width: 0 0 1px 1px;
		padding: 5px 10px;
		border-radius: 4px;
		position: absolute;
		top: 100%;
		left: 0;
		background-color: white;
		z-index: 500;
	}
	
	.category-result-scroll-view {
		overflow-y: scroll;
		overflow-x: auto;
		height: 150px;
	}
</style>

<aui:input type="hidden" name='<%=elementName%>'/>
<div class="bound-category-taglib">
	<aui:input 
		name='<%= elementName + "label"%>'
		cssClass="<%=cssClass %>"
		inlineLabel="<%=inlineLabel %>"
		label="<%=showLabel ? elementName : StringPool.BLANK %>"
		helpMessage="if-you-does-not-select-value-on-tree-the-real-value-also-does-not-set"
		autocomplete="off"
	/>
	
	<div 
		id='<%=themeDisplay.getPortletDisplay().getNamespace() + randomInstance + "showTreeCategory" %>' 
		class="category-result-scroll-view"
	>
		<div id='<%= themeDisplay.getPortletDisplay().getNamespace() + randomInstance + "treeView" %>' class="category-tree-view"></div>
	</div>
</div>
<div id='<%=themeDisplay.getPortletDisplay().getNamespace() + randomInstance + "htmlResponse" %>' class="html-response"></div>
<aui:script>
	AUI().ready('aui-io','event-focus','aui-tree-view','liferay-util-list-fields','liferay-portlet-url','liferay-util-window','aui-base', function(A){
		
		var showTreeCategory<%=randomInstance %> = A.one('#<portlet:namespace /><%=randomInstance %>showTreeCategory'); 
		var treeView<%=randomInstance %> = A.one('#<portlet:namespace /><%=randomInstance%>treeView'); 
		var elementNameInp<%= randomInstance %> = A.one('#<portlet:namespace /><%=elementName %>label');
		var categoryIdInp<%=randomInstance %> = A.one('#<portlet:namespace /><%=elementName %>');
		if(showTreeCategory<%=randomInstance %>) {
			showTreeCategory<%=randomInstance %>.hide();
		}
		
		if(elementNameInp<%= randomInstance %>) {
		
			 var value<%=randomInstance %> = '<%=value %>';
				
			 if(value<%=randomInstance %> != '0') {
					if(categoryIdInp<%=randomInstance %>) {
						categoryIdInp<%=randomInstance %>.val(value<%=randomInstance %>);
					}
					
					Liferay.Service(
					  '/portal-cms-workflow-portlet.usercategory/get-name-category-by-id',
					  {
					    categoryId: value<%=randomInstance %>,
					  },
					  function(objs) {
					  		 if(objs){
							  	 elementNameInp<%= randomInstance %>.val(objs.categoryName);
							 }
					  });
				}
		
			elementNameInp<%= randomInstance %>.on('keyup', function() {
			treeView<%=randomInstance %>.empty();
				<portlet:namespace /><%=randomInstance %>generateTreeCategories(categoryIdInp<%=randomInstance %>, 
								elementNameInp<%= randomInstance %>, treeView<%=randomInstance %>);
								
				<%-- if('<%=valueOption %>' == 'name') {
					categoryIdInp<%=randomInstance %>.val(elementNameInp<%= randomInstance %>.val());
				} --%>
				
				
			});
			
			if('<%=valueOption %>' == 'name') {
				categoryIdInp<%=randomInstance %>.val(elementNameInp<%= randomInstance %>.val());
			}
			
			if(showTreeCategory<%=randomInstance %>) {
				elementNameInp<%= randomInstance %>.on('focus', function() {
					treeView<%=randomInstance %>.empty();
					<portlet:namespace /><%=randomInstance %>generateTreeCategories(categoryIdInp<%=randomInstance %>, 
									elementNameInp<%= randomInstance %>, treeView<%=randomInstance %>);
					showTreeCategory<%=randomInstance %>.show();
				});
				
				elementNameInp<%= randomInstance %>.on('blur', function() {
					showTreeCategory<%=randomInstance %>.hide();
				});
				elementNameInp<%= randomInstance %>.on('change', function() {
					treeView<%=randomInstance %>.empty();
					if (elementNameInp<%= randomInstance %>.val()==''){
						categoryIdInp<%=randomInstance %>.val('');
					}	
				});
			}
		}
		
		
		<%-- if(expandTreeCategory<%=randomInstance %>) {
			expandTreeCategory<%=randomInstance %>.on('click', function(){
				<portlet:namespace /><%=randomInstance %>generateTreeCategories(categoryIdInp<%=randomInstance %>, 
								elementNameInp<%= randomInstance %>, treeView<%=randomInstance %>);
			});
		} --%>
	});
	
	Liferay.provide(window, '<portlet:namespace /><%=randomInstance %>generateTreeCategories', function(
		categoryIdInp<%=randomInstance %>, elementNameInp<%= randomInstance %>, treeView<%=randomInstance %>) {
		var A = AUI();
		var elementNameVal<%=randomInstance %> = elementNameInp<%= randomInstance %>.val();
		console.log(elementNameVal<%=randomInstance %>);	
		var data<%=randomInstance %> = null;
		Liferay.Service(
		  '/portal-cms-workflow-portlet.usercategory/get-tree-array-json',
		  {
		    keywords: elementNameVal<%=randomInstance %>,
		    userId: themeDisplay.getUserId(),
		  },
		  function(objs) {
			  if(objs.length > 0){
			  	 if(objs.length > 0){
			  	 	data<%=randomInstance %> = objs;
			  	 }
			  	 
			  	 if(data<%=randomInstance %> != null) {
			  	 	var treeViewBuild<%=randomInstance %> = new A.TreeViewDD(
		            {
		              boundingBox: treeView<%=randomInstance %>,
		              children: objs,
		              on: {
		 				 render: function(){
		 				 		// alert("a")
		 				 	}
		 		        }
		            }).render();
		            
		            treeViewBuild<%=randomInstance %>.after('lastSelectedChange', function(event){
		            	var label<%=randomInstance %> = event.newVal.get('label');
		            	var categoryId<%=randomInstance %> = event.newVal.get('id');
		            	
		            	if(label<%=randomInstance %> != '' && categoryId<%=randomInstance %> != '') {
		            		elementNameInp<%= randomInstance %>.val(label<%=randomInstance %>);
		            		if(categoryIdInp<%=randomInstance %>) {
		            			if('<%=valueOption %>' == 'id') {
		            				categoryIdInp<%=randomInstance %>.val(categoryId<%=randomInstance %>);
		            			} else {
		            				categoryIdInp<%=randomInstance %>.val(label<%=randomInstance %>);
		            			}
		            			
		            		}
		            	}
		            });
			  	 }
			  } 
		  });
	});
	
	
</aui:script>
