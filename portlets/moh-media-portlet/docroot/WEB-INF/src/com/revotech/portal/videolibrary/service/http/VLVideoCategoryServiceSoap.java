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

package com.revotech.portal.videolibrary.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.revotech.portal.videolibrary.service.VLVideoCategoryServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.revotech.portal.videolibrary.service.VLVideoCategoryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.revotech.portal.videolibrary.model.VLVideoCategorySoap}.
 * If the method in the service utility returns a
 * {@link com.revotech.portal.videolibrary.model.VLVideoCategory}, that is translated to a
 * {@link com.revotech.portal.videolibrary.model.VLVideoCategorySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author ChucHV
 * @see VLVideoCategoryServiceHttp
 * @see com.revotech.portal.videolibrary.model.VLVideoCategorySoap
 * @see com.revotech.portal.videolibrary.service.VLVideoCategoryServiceUtil
 * @generated
 */
public class VLVideoCategoryServiceSoap {
	public static com.revotech.portal.videolibrary.model.VLVideoCategorySoap[] findByCategory(
		long categoryId, long groupId) throws RemoteException {
		try {
			java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> returnValue =
				VLVideoCategoryServiceUtil.findByCategory(categoryId, groupId);

			return com.revotech.portal.videolibrary.model.VLVideoCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.revotech.portal.videolibrary.model.VLVideoCategorySoap[] findByVideo(
		long videoId, long groupId) throws RemoteException {
		try {
			java.util.List<com.revotech.portal.videolibrary.model.VLVideoCategory> returnValue =
				VLVideoCategoryServiceUtil.findByVideo(videoId, groupId);

			return com.revotech.portal.videolibrary.model.VLVideoCategorySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VLVideoCategoryServiceSoap.class);
}