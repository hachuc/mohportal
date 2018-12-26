<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionList"%>
<%@page import="com.viettel.portal.vbpq.service.LoaiVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.service.LinhVucVanBanLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.viettel.portal.vbpq.service.NhomVanBanLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.model.NhomVanBan"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.viettel.portal.vbpq.util.VanBanPhapQuyUtils"%>
<%@page import="com.viettel.portal.vbpq.model.LinhVucVanBan"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LinhVucVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.admin.business.CoQuanBanHanhBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.CoQuanBanHanhVanBan"%>
<%@page import="com.viettel.portal.vbpq.admin.business.LoaiVanBanBusiness"%>
<%@page import="com.viettel.portal.vbpq.model.LoaiVanBan"%>
<%@include file="/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<% 
	System.err.println("===LIST===");
%>
<%

	List<Group> groups = new ArrayList<Group>();//GroupLocalServiceUtil.getUserGroups(themeDisplay.getUserId());
	
	List<CoQuanBanHanhVanBan> lsCoQuanBanHanh = new ArrayList<CoQuanBanHanhVanBan>();
	List<LinhVucVanBan> lsLinhVuc  = new ArrayList<LinhVucVanBan>();
	List<LoaiVanBan> lsLoaiVanBan  = new ArrayList<LoaiVanBan>();
	String nhom = portletPreferences.getValue("nhomVanBanId", "");
	
	String[] nhomVanBanIds = new String[0];
	if (nhom.length() > 0) {
		nhomVanBanIds = nhom.split(",");
	}
	
	
	
	List<Long> nhomVBIDs = new ArrayList();
	for (String st : nhomVanBanIds) {
		if (st.trim().length() > 0) {
			nhomVBIDs.add(Long.parseLong(st));
		}
	}
	
	DynamicQuery linhVucDynamicQuery = DynamicQueryFactoryUtil.forClass(LinhVucVanBan.class);
	linhVucDynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", scopeId));
	if(!nhomVBIDs.isEmpty()){
		linhVucDynamicQuery.add(RestrictionsFactoryUtil.in("nhomVanBanId", nhomVBIDs.toArray()));
	}
	linhVucDynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
	lsLinhVuc = LinhVucVanBanLocalServiceUtil.dynamicQuery(linhVucDynamicQuery);
	System.err.println("LinhVucVanBan");

	DynamicQuery coQuanBHDynamicQuery = DynamicQueryFactoryUtil.forClass(CoQuanBanHanhVanBan.class);
	coQuanBHDynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", scopeId));
	if(!nhomVBIDs.isEmpty()){
		coQuanBHDynamicQuery.add(RestrictionsFactoryUtil.in("nhomVanBanId", nhomVBIDs.toArray()));
	}
	coQuanBHDynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
	lsCoQuanBanHanh = CoQuanBanHanhVanBanLocalServiceUtil.dynamicQuery(coQuanBHDynamicQuery);
	System.err.println("CoQuanBanHanhVanBan");
	
	DynamicQuery loaiVBDynamicQuery = DynamicQueryFactoryUtil.forClass(LoaiVanBan.class);
	loaiVBDynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", scopeId));
	if(!nhomVBIDs.isEmpty()){
		loaiVBDynamicQuery.add(RestrictionsFactoryUtil.in("nhomVanBanId", nhomVBIDs.toArray()));
	}
	loaiVBDynamicQuery.addOrder(OrderFactoryUtil.asc("ten"));
	lsLoaiVanBan = LoaiVanBanLocalServiceUtil.dynamicQuery(loaiVBDynamicQuery);
	System.err.println("LoaiVanBan");

	boolean showNhomvanBan = Boolean.parseBoolean(portletPreferences.getValue("showNhomVanBan", "true"));
	String titleDisplayTemp = portletPreferences.getValue("titleDisplay", "");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="menuVbpqPortletConfigURL">	
	<liferay-portlet:param  name="portletResource" value="<%= portletResource %>"/>
</liferay-portlet:actionURL>

<aui:form name="fm" method="post" action="<%=menuVbpqPortletConfigURL %>">
	<aui:fieldset>
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
		<aui:row>
			<aui:col width="50">
				<aui:select name="preferences--scopeId--" label="scope">
				<% for(Group site : groups) { %>
					<c:if test="<%= site.isSite() %>">
						<aui:option value="<%= site.getGroupId() %>" label="<%=HtmlUtil.escape( site.getName()) %>" selected="<%= scopeId == site.getGroupId()  %>"/>
					</c:if>
				<% } %>
				</aui:select>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:input type="checkbox" name="preferences--showNhomVanBan--" checked="<%= showNhomvanBan %>" cssClass="tthc_input_select" label="show-search-loai-van-ban" />
				<aui:col width="25">
				<aui:select name="preferences--nhomVanBanId--" multiple="true" label="Nhóm văn bản">
					<aui:option value="0" label=""></aui:option>
					<%
						List<NhomVanBan> ls = NhomVanBanLocalServiceUtil.getNhomVanBanByGroupId(scopeId);
						for (NhomVanBan nv : ls) {
							boolean selected = (ArrayUtil.contains(nhomVanBanIds, String.valueOf(nv.getId())) ? true:false);
					%>
					<aui:option value="<%= String.valueOf(nv.getId()) %>" label="<%= HtmlUtil.escape( nv.getTenNhom() )%>" selected="<%= selected %>" ></aui:option>
				<% } %>
				</aui:select>
			</aui:col>
		</aui:row>
				
		<aui:row>
		
		<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchLinhVuc--" value="<%= showSearchLinhVuc %>" cssClass="tthc_input_select" label="show-search-loai-van-ban" />
				
				<aui:select name="preferences--linhvuc--" cssClass="multi_select" label="loaivanban" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (LinhVucVanBan linhvuc : lsLinhVuc)
						{
							String label = linhvuc.getTen();
							long id = linhvuc.getNhomVanBanId();
							if (id > 0) {
								try {
									NhomVanBan nv = NhomVanBanLocalServiceUtil.getNhomVanBan(id);
									if (nv != null) {
										label += "("+ nv.getTenNhom() +")";
									}
								} catch(Exception e) {};
							}
					%>
							<aui:option value="<%= linhvuc.getId() %>" label="<%= HtmlUtil.escape( label )%>" selected="<%= ArrayUtil.contains(linhVucVanBanIdPrefs, linhvuc.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchCoQuanBanHanh--" value="<%= showSearchCoQuanBanHanh %>" cssClass="tthc_input_select" label="show-search-co-quan-ban-hanh" />
				
				<aui:select name="preferences--coquanbanhanh--" cssClass="multi_select" label="coquanbanhanh" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (CoQuanBanHanhVanBan coquan : lsCoQuanBanHanh)
						{
							String label = coquan.getTen();
							long id = coquan.getNhomVanBanId();
							if (id > 0) {
								try {
									NhomVanBan nv = NhomVanBanLocalServiceUtil.getNhomVanBan(id);
									if (nv != null) {
										label += "("+ nv.getTenNhom() +")";
									}
								} catch(Exception e) {};
							}
					%>
							<aui:option value="<%= coquan.getId() %>" label="<%= HtmlUtil.escape( label )%>" selected="<%= ArrayUtil.contains(coQuanBanHanhIdPrefs, coquan.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchLoaiVanBan--" value="<%= showSearchLoaiVanBan %>" cssClass="tthc_input_select" label="show-search-linh-vuc" />
				
				<aui:select name="preferences--loaivanban--" cssClass="multi_select" label="linhvuc" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (LoaiVanBan loaivanban : lsLoaiVanBan)
						{
							String label = loaivanban.getTen();
							long id = loaivanban.getNhomVanBanId();
							if (id > 0) {
								try {
									NhomVanBan nv = NhomVanBanLocalServiceUtil.getNhomVanBan(id);
									if (nv != null) {
										label += "("+ nv.getTenNhom() +")";
									}
								} catch(Exception e) {};
							}
					%>
							<aui:option value="<%= loaivanban.getId() %>" label="<%= HtmlUtil.escape( label )%>" selected="<%= ArrayUtil.contains(loaiVanBanIdPrefs, loaivanban.getId()) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			
			<aui:col width="<%= 25 %>">
				<aui:input type="checkbox" name="preferences--showSearchYear--" value="<%= showSearchYear %>" label="year" cssClass="tthc_input_select" />
				
				<aui:select name="preferences--year--" cssClass="multi_select"  label="year" multiple="<%= true %>" showEmptyOption="<%= true %>">
					<%
						for (int i = 1992; i< 2020; i++)
						{
					%>
							<aui:option value="<%= i %>" label="<%= i %>" selected="<%= ArrayUtil.contains(years, i) %>"/>
					<%
						}
					%>
				</aui:select>
			</aui:col>
			
			
		</aui:row>
		
		<aui:row>
			<aui:col width="<%= 25 %>">
			<%
				String cd = portletPreferences.getValue("chieuDaiTrichYeu", "80");
			%>
			<aui:input name="preferences--chieuDaiTrichYeu--" value="<%= cd %>" label="Chiều dài tiêu đề trích yếu:" type="text">
					<aui:validator name="digits" errorMessage="Nhập kiểu số!"></aui:validator>
			</aui:input>
			</aui:col>
		</aui:row>
		
		<aui:input type="checkbox" name="preferences--showNgayBanHanh--" value="<%= showNgayBanHanh %>" cssClass="tthc_input_select" label="show-ngay-ban-hanh" />
		
		<aui:input type="checkbox" name="preferences--showNguoiKy--" value="<%= showNguoiKy %>" cssClass="tthc_input_select" label="show-nguoi-ky" />
		
		<aui:input type="checkbox" name="preferences--showDetail--" value="<%= showDetail %>" cssClass="tthc_input_select" label="show-detail" />
		
		<aui:input type="checkbox" name="preferences--showAttachment--" value="<%= showAttachment %>" cssClass="tthc_input_select" label="show-attachment" />
		
		<aui:input type="checkbox" name="preferences--showCQBH--" value="<%= showCQBH %>" cssClass="tthc_input_select" label="show-cqbh" />
		
		
		<%
			int itemPerPage = Integer.parseInt(portletPreferences.getValue("itemPerPage", "10"));
			boolean showTrichYeu = Boolean.parseBoolean(portletPreferences.getValue("showTrichYeu", "false"));
			boolean showIconBaiVietMoiNhat = Boolean.parseBoolean(portletPreferences.getValue("showIconBaiVietMoiNhat", "true"));
			boolean showSearch = Boolean.parseBoolean(portletPreferences.getValue("showSearch", "true"));

		%>
		
		<aui:input type="checkbox" name="preferences--showTrichYeu--" checked="<%= showTrichYeu %>" cssClass="tthc_input_select" label="Chỉ hiển thị cột trích yếu" />
		<aui:input type="checkbox" name="preferences--showIconBaiVietMoiNhat--" checked="<%= showIconBaiVietMoiNhat %>" cssClass="tthc_input_select" label="Hiển thị icon bài viêt mới nhất" />
		<aui:input type="checkbox" name="preferences--showSearch--" value="<%= showSearch %>" cssClass="tthc_input_select" label="Hiển thị tìm kiếm" />
	<aui:row>
		<aui:col width="30">
			<aui:select name="preferences--itemPerPage--" label="Phân trang">
			<aui:option value="4" selected="<%= (itemPerPage == 4 ? true:false) %>">4</aui:option>
			<aui:option value="5" selected="<%= (itemPerPage == 5 ? true:false) %>">5</aui:option>
			<aui:option value="10" selected="<%= (itemPerPage == 10 ? true:false) %>">10</aui:option>
			<aui:option value="15" selected="<%= (itemPerPage == 15 ? true:false) %>">15</aui:option>
			<aui:option value="20" selected="<%= (itemPerPage == 20 ? true:false) %>">20</aui:option>
			<aui:option value="25" selected="<%= (itemPerPage == 25 ? true:false) %>">25</aui:option>
			<aui:option value="30" selected="<%= (itemPerPage == 30 ? true:false) %>">30</aui:option>
			<aui:option value="35" selected="<%= (itemPerPage == 35 ? true:false) %>">35</aui:option>
			<aui:option value="40" selected="<%= (itemPerPage == 40 ? true:false) %>">40</aui:option>
			<aui:option value="45" selected="<%= (itemPerPage == 45 ? true:false) %>">45</aui:option>
			<aui:option value="50" selected="<%= (itemPerPage == 50 ? true:false) %>">50</aui:option>
		</aui:select>
		</aui:col>
	</aui:row>

	
	<%
		String[] cols = new String[]{
			"MAVANBAN_DESC", "NGAYTAO_DESC", "nhomVanBanId_ASC", "NGAYSUA_DESC", "COQUANBANHANH_ASC", "LOAIVANBAN_ASC", "LINHVUCVANBAN_ASC", "NGAYBANHANH_DESC", "NGAYCOHIEULUC_ASC"
		};
		String[] labels = new String[]{
				"Mã văn bản", "Ngày tạo", "Nhóm văn bản", "Ngày sửa", 	"Cơ quan ban hành", "Loại văn bản", "Lĩnh vực văn bản", "Ngày ban hành", "Ngày có hiệu lực"
			};
		String strCate = portletPreferences.getValue("chuyenMucUuTien", "NGAYBANHANH_ASC");
		String[] currentCategory = strCate.split(",");
	%>
	
	<aui:row>
		<aui:col width="30">
					<aui:select name="preferences--chuyenMucUuTien--" id="category" label="Trường dữ liệu sắp xếp:" multiple="true" cssClass="select-box">
					<% 
					for(int i = 0; i < cols.length; i++) { 
							String name = cols[i].split("_")[0];
							String select = "";
							for(String st : currentCategory) {
								String[] spl = st.split("_");
								if (name.equals(spl[0])){
									select = " selected ";
									break;
								}
							}
							
						%>
						<option value="<%= cols[i] %>" "<%= select %>" ><%= labels[i] %></option>
						<% } %>
				</aui:select>
		</aui:col>
</aui:row>

<aui:row>
	<aui:col width="30">
		<span id="sortASC1" class="btn btn-default">
		<i class="icon-arrow-up"></i>
		</span>
		
		<span id="sortDESC1" class="btn btn-default">
			<i class="icon-arrow-down"></i>
		</span>
		<br/>
	</aui:col>
		
	</aui:row>
	<aui:row></aui:row>
	<br/>
<aui:script use="aui-base,node">

	A.one("#sortASC1").on("click", function(){
		sortASC("#<portlet:namespace/>category", "#<portlet:namespace/>category option", "DESC");
	});
	
	A.one("#sortDESC1").on("click", function(){
		sortDESC("#<portlet:namespace/>category", "#<portlet:namespace/>category option", "DESC");
	});
	
	
		
	
	window.sortASC = function(selectId, selectOptionId, ascOrDesc) {
		
		var op = A.all(selectOptionId);
		var selected = A.one(selectId).val().split("_")[0];
		var vt = 0;
		var sort = [];
		var loc = [];
		for (var i = 0; i < op._nodes.length; i++) {
			var split = op._nodes[i].value.split("_");
			var o = {value: op._nodes[i].value, label: op._nodes[i].text, selected:""};
			if (selected == split[0]) {
				vt = i;
			}
			loc.push(o);
		}
		
		if (loc.length > 1) {
			if (vt != 0) {
				
				for (var i = 0; i < loc.length; i++) {
					
					var o = loc[i];
					if (i == vt) {
						o.selected = " selected ";
						if (sort.length > 0) {
							var p = sort[sort.length -1];
							sort[sort.length -1] = o;
							sort.push(p);
						} else {
							sort.push(o);
						}
						
					} else 
					sort.push(o);
				}
				
				var sl = A.one(selectId);
				sl.empty();
				for (var i = 0; i < loc.length; i++) {
					var tag = "<option value='"+ sort[i].value +"' "+ sort[i].selected +" >"+ sort[i].label +"</option>";
					sl.append(tag);
				}
			} else {
				var p = loc[0];
				p.selected = " selected ";
				var split = p.value.split("_");
				p.value = split[0] + "_" + ascOrDesc;
				loc[0] = p;
				var sl = A.one(selectId);
				sl.empty();
				for (var i = 0; i < loc.length; i++) {
					var tag = "<option value='"+ loc[i].value +"' "+ loc[i].selected +" >"+ loc[i].label +"</option>";
					sl.append(tag);
				}
			}
			
		}
		
	}
	
window.sortDESC = function(selectId, selectOptionId, ascOrDesc) {
		
		var op = A.all(selectOptionId);
		var selected = A.one(selectId).val().split("_")[0];
		var vt = 0;
		var sort = [];
		var loc = [];
		for (var i = 0; i < op._nodes.length; i++) {
			var split = op._nodes[i].value.split("_");
			var o = {value: op._nodes[i].value, label: op._nodes[i].text, selected: ""};
			if (selected == split[0]) {
				vt = i;
			}
			loc.push(o);
		}
		if (loc.length > 1) {
			if (vt != loc.length - 1) {
				for (var i = 0; i < loc.length; i++) {
					
					var o = loc[i];
					if (i == vt) {
						o.selected = " selected ";
						loc[i] = loc[i + 1];
						loc[i + 1] = o;
						
					} 
					sort.push(loc[i]);
				}
				var sl = A.one(selectId);
				sl.empty();
				for (var i = 0; i < loc.length; i++) {
					var tag = "<option value='"+ sort[i].value +"' "+ sort[i].selected +" >"+ sort[i].label +"</option>";
					sl.append(tag);
				}
			} else {
				var p = loc[loc.length - 1];
				p.selected = " selected ";
				var split = p.value.split("_");
				p.value = split[0] + "_" + ascOrDesc;
				loc[loc.length - 1] = p;
				var sl = A.one(selectId);
				sl.empty();
				for (var i = 0; i < loc.length; i++) {
					var tag = "<option value='"+ loc[i].value +"' "+ loc[i].selected +" >"+ loc[i].label +"</option>";
					sl.append(tag);
				}
			}
			
		}
		
	}
	
	
</aui:script>		
<aui:input type="text" name="preferences--portletTitle--" label="portlet-title" value="<%=portletTitle %>"/>

<aui:row>
	<aui:col width="30">
		<aui:select name="preferences--lienKetTrang--" label="Chọn liên kết trang:">
		<%
			layoutId = Long.parseLong(portletPreferences.getValue("lienKetTrang", "0"));
			List<Layout> lls = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
			for (Layout lt : lls) {
				boolean select = (layoutId == lt.getPlid() ? true:false);
		%>
		<aui:option label="<%= lt.getName(themeDisplay.getLocale()) %>" selected="<%= select %>" value="<%= String.valueOf(lt.getPlid()) %>"></aui:option>
		<% } %>
	</aui:select>
	</aui:col>
	
</aui:row>
	
		<aui:button-row>
			<aui:button type="submit" value="save"/>
			<aui:button type="cancel"/>
		</aui:button-row>
	</aui:fieldset>
</aui:form>