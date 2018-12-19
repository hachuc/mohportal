package com.viettel.portal.vbpq.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class AdminPermission {
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) 
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {
		
		return permissionChecker.hasPermission(groupId, _NAME, groupId,
				actionId);
	}

	private static final String _NAME = "com.viettel.portal.admin.vbpq";
}
