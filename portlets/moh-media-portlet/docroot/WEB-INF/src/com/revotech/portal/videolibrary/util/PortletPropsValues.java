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

package com.revotech.portal.videolibrary.util;

import com.liferay.portal.kernel.util.GetterUtil;

public class PortletPropsValues {
	public static final String[] VIDEO_FILE_EXTENSIONS = GetterUtil.getStringValues(PortletPropsKeys.VIDEO_FILE_EXTENSIONS, VideoConstants.DEFAULT_FILE_EXTENSIONS);
	public static final long VIDEO_FILE_MAX_SIZE = GetterUtil.getLong(PortletPropsKeys.VIDEO_FILE_MAX_SIZE, VideoConstants.DEFAULT_VIDEO_MAX_SIZE);
}
