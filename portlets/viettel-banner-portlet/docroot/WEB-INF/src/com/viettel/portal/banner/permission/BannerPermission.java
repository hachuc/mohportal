
package com.viettel.portal.banner.permission;

import com.viettel.portal.banner.model.Banner;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


/**
 * @author Keli
 *
 */
public class BannerPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, Banner banner, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, banner, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Banner banner, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(banner.getGroupId(), Banner.class.getName(), banner.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, Banner.class.getName(), groupId, actionId);
	}
}
