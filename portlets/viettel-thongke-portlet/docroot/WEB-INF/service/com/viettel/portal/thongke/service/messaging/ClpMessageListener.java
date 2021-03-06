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

package com.viettel.portal.thongke.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;
import com.viettel.portal.thongke.service.ClpSerializer;
import com.viettel.portal.thongke.service.ContentProfitLocalServiceUtil;
import com.viettel.portal.thongke.service.ContentProfitServiceUtil;
import com.viettel.portal.thongke.service.ContentTypeCostLocalServiceUtil;
import com.viettel.portal.thongke.service.ContentTypeCostServiceUtil;
import com.viettel.portal.thongke.service.ContentTypeLocalServiceUtil;
import com.viettel.portal.thongke.service.ContentTypeServiceUtil;
import com.viettel.portal.thongke.service.PhongBanLocalServiceUtil;
import com.viettel.portal.thongke.service.PhongBanNhuanButChiTietLocalServiceUtil;
import com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil;

/**
 * @author lamvn
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BaiVietNhuanButLocalServiceUtil.clearService();

			ContentProfitLocalServiceUtil.clearService();

			ContentProfitServiceUtil.clearService();
			ContentTypeLocalServiceUtil.clearService();

			ContentTypeServiceUtil.clearService();
			ContentTypeCostLocalServiceUtil.clearService();

			ContentTypeCostServiceUtil.clearService();
			PhongBanLocalServiceUtil.clearService();

			PhongBanNhuanButLocalServiceUtil.clearService();

			PhongBanNhuanButChiTietLocalServiceUtil.clearService();
		}
	}
}