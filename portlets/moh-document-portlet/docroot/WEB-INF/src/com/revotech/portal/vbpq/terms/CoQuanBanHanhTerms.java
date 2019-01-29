package com.revotech.portal.vbpq.terms;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class CoQuanBanHanhTerms extends DisplayTerms {

	public static final String TEN = "ten";
	public static final String TRANG_THAI = "trangThai";
	public static final String ORDER = "order_";
	public static final String GROUPID = "groupId";
	public static final String ID = "id";

	public CoQuanBanHanhTerms(ActionRequest actionRequest) {
		super(actionRequest);

		ten = ParamUtil.getString(actionRequest, TEN);

		trangThai = ParamUtil.getBoolean(actionRequest, TRANG_THAI);

		order = ParamUtil.getInteger(actionRequest, ORDER);

		groupId = ParamUtil.getLong(actionRequest, GROUPID);
		
		id = ParamUtil.getLong(actionRequest, ID);
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	protected String ten;
	protected boolean trangThai;
	protected int order;
	protected long groupId;

	protected long id;
}
