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

package com.liferay.viettel.portal.counter.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.viettel.portal.counter.service.CategoryLocalServiceUtil;
import com.liferay.viettel.portal.counter.service.CategoryServiceUtil;
import com.liferay.viettel.portal.counter.service.ClpSerializer;
import com.liferay.viettel.portal.counter.service.CounterReportLocalServiceUtil;
import com.liferay.viettel.portal.counter.service.CounterReportServiceUtil;

/**
 * @author chuchv
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
			CategoryLocalServiceUtil.clearService();

			CategoryServiceUtil.clearService();
			CounterReportLocalServiceUtil.clearService();

			CounterReportServiceUtil.clearService();
		}
	}
}