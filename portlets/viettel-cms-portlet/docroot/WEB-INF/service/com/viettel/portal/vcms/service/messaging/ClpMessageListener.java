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

package com.viettel.portal.vcms.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.viettel.portal.vcms.service.CategoryLocalServiceUtil;
import com.viettel.portal.vcms.service.CategoryServiceUtil;
import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.CommentLocalServiceUtil;
import com.viettel.portal.vcms.service.CommentServiceUtil;
import com.viettel.portal.vcms.service.ContentDetailLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentDetailServiceUtil;
import com.viettel.portal.vcms.service.ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentProfitLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentProfitServiceUtil;
import com.viettel.portal.vcms.service.ContentServiceUtil;
import com.viettel.portal.vcms.service.ContentTypeLocalServiceUtil;
import com.viettel.portal.vcms.service.ContentTypeServiceUtil;
import com.viettel.portal.vcms.service.DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionServiceUtil;
import com.viettel.portal.vcms.service.DistributionVisistedLocalServiceUtil;
import com.viettel.portal.vcms.service.DistributionVisistedServiceUtil;
import com.viettel.portal.vcms.service.Legal_CommentLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_CommentServiceUtil;
import com.viettel.portal.vcms.service.Legal_ContentLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_ContentProfitLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_ContentProfitServiceUtil;
import com.viettel.portal.vcms.service.Legal_ContentServiceUtil;
import com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_DistributionServiceUtil;
import com.viettel.portal.vcms.service.Legal_ZoneLocalServiceUtil;
import com.viettel.portal.vcms.service.Legal_ZoneServiceUtil;
import com.viettel.portal.vcms.service.NotesLocalServiceUtil;
import com.viettel.portal.vcms.service.NotesServiceUtil;

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
			CommentLocalServiceUtil.clearService();

			CommentServiceUtil.clearService();
			ContentLocalServiceUtil.clearService();

			ContentServiceUtil.clearService();
			ContentDetailLocalServiceUtil.clearService();

			ContentDetailServiceUtil.clearService();
			ContentProfitLocalServiceUtil.clearService();

			ContentProfitServiceUtil.clearService();
			ContentTypeLocalServiceUtil.clearService();

			ContentTypeServiceUtil.clearService();
			DistributionLocalServiceUtil.clearService();

			DistributionServiceUtil.clearService();
			DistributionVisistedLocalServiceUtil.clearService();

			DistributionVisistedServiceUtil.clearService();
			Legal_CommentLocalServiceUtil.clearService();

			Legal_CommentServiceUtil.clearService();
			Legal_ContentLocalServiceUtil.clearService();

			Legal_ContentServiceUtil.clearService();
			Legal_ContentProfitLocalServiceUtil.clearService();

			Legal_ContentProfitServiceUtil.clearService();
			Legal_DistributionLocalServiceUtil.clearService();

			Legal_DistributionServiceUtil.clearService();
			Legal_ZoneLocalServiceUtil.clearService();

			Legal_ZoneServiceUtil.clearService();
			NotesLocalServiceUtil.clearService();

			NotesServiceUtil.clearService();
		}
	}
}