/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package com.revotech.portal.vbpq.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.revotech.portal.vbpq.service.base.NhomVanBanLocalServiceBaseImpl;
import com.revotech.portal.vbpq.model.NhomVanBan;

/**
 * The implementation of the nhom van ban local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.revotech.portal.vbpq.service.NhomVanBanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author ChucHV
 * @see com.revotech.portal.vbpq.service.base.NhomVanBanLocalServiceBaseImpl
 * @see com.revotech.portal.vbpq.service.NhomVanBanLocalServiceUtil
 */
public class NhomVanBanLocalServiceImpl extends NhomVanBanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.revotech.portal.vbpq.service.NhomVanBanLocalServiceUtil} to access the nhom van ban local service.
	 */
public List<NhomVanBan> getNhomVanBanByGroupId(long groupId) throws Exception {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
		dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", WorkflowConstants.STATUS_APPROVED));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("tenNhom"));
		
		return nhomVanBanLocalService.dynamicQuery(dynamicQuery);
	}
	
	public List<NhomVanBan> getNhomVanBanByGroupId(List<Long> groupIds) throws Exception {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
		dynamicQuery.add(RestrictionsFactoryUtil.in("groupId", groupIds));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", WorkflowConstants.STATUS_APPROVED));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("tenNhom"));
		
		return nhomVanBanLocalService.dynamicQuery(dynamicQuery);
	}
	
	public List<NhomVanBan> getNhomVanBanById(List<Long> ids) throws Exception {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(NhomVanBan.class);
		if (ids != null && ids.size() > 0)
		dynamicQuery.add(RestrictionsFactoryUtil.in("id", ids));
		dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", WorkflowConstants.STATUS_APPROVED));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("tenNhom"));
		
		return nhomVanBanLocalService.dynamicQuery(dynamicQuery);
	}
	
	
}