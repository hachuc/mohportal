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

package com.portal_egov.portlet.legal_faq.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.portal_egov.portlet.legal_faq.service.ClpSerializer;
import com.portal_egov.portlet.legal_faq.service.FeedbackLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.FeedbackServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQCategoryServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;
import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryServiceUtil;

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
			FeedbackLocalServiceUtil.clearService();

			FeedbackServiceUtil.clearService();
			LegalFAQCategoryLocalServiceUtil.clearService();

			LegalFAQCategoryServiceUtil.clearService();
			LegalFAQEntryLocalServiceUtil.clearService();

			LegalFAQEntryServiceUtil.clearService();
		}
	}
}