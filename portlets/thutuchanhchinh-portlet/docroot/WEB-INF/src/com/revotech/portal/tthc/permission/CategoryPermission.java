package com.revotech.portal.tthc.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.LegalDocument;

public class CategoryPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, Category banner, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, banner, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, Category banner, String actionId)
			throws PortalException, SystemException {

		return permissionChecker.hasPermission(banner.getGroupId(), Category.class.getName(), banner.getPrimaryKey(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, Category.class.getName(), groupId, actionId);
	}
}