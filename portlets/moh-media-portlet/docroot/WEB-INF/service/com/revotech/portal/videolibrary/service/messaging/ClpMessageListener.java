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

package com.revotech.portal.videolibrary.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.revotech.portal.videolibrary.service.ClpSerializer;
import com.revotech.portal.videolibrary.service.VLCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLCategoryServiceUtil;
import com.revotech.portal.videolibrary.service.VLRelateVideoLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLRelateVideoServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoCategoryServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoTagLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VLVideoTagServiceUtil;
import com.revotech.portal.videolibrary.service.VideoCategoryLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VideoCategoryServiceUtil;
import com.revotech.portal.videolibrary.service.VideoClipLocalServiceUtil;
import com.revotech.portal.videolibrary.service.VideoClipServiceUtil;

/**
 * @author ChucHV
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
			VideoCategoryLocalServiceUtil.clearService();

			VideoCategoryServiceUtil.clearService();
			VideoClipLocalServiceUtil.clearService();

			VideoClipServiceUtil.clearService();
			VLCategoryLocalServiceUtil.clearService();

			VLCategoryServiceUtil.clearService();
			VLRelateVideoLocalServiceUtil.clearService();

			VLRelateVideoServiceUtil.clearService();
			VLVideoLocalServiceUtil.clearService();

			VLVideoServiceUtil.clearService();
			VLVideoCategoryLocalServiceUtil.clearService();

			VLVideoCategoryServiceUtil.clearService();
			VLVideoTagLocalServiceUtil.clearService();

			VLVideoTagServiceUtil.clearService();
		}
	}
}