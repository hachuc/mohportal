package com.revotech.portal.videolibrary.permission;

import com.revotech.portal.videolibrary.model.VLCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;



/**
 * @author Keli
 *
 */

public class CategoryPermission {
	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, threadId, actionId)) {
				throw new PrincipalException();
			}
		}

		public static void check(PermissionChecker permissionChecker, VLCategory category, String actionId)
			throws PortalException, SystemException {

			if (!contains(permissionChecker, category, actionId)) {
				throw new PrincipalException();
			}
		}

		public static boolean contains(PermissionChecker permissionChecker, VLCategory category, String actionId)
			throws PortalException, SystemException {

			return permissionChecker.hasPermission(category.getGroupId(), VLCategory.class.getName(), category.getPrimaryKey(), actionId);
		}
		
		
		public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
			
			return permissionChecker.hasPermission(groupId, VLCategory.class.getName(), groupId, actionId);
		}
}
