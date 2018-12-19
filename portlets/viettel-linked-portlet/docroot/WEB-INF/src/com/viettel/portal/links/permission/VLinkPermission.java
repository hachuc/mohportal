
package com.viettel.portal.links.permission;

import com.viettel.portal.links.model.VLink;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


/**
 * @author Keli
 *
 */
public class VLinkPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, VLink vcontact, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, vcontact, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, VLink vcontact, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(vcontact.getGroupId(), VLink.class.getName(), vcontact.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, VLink.class.getName(), groupId, actionId);
	}
}
