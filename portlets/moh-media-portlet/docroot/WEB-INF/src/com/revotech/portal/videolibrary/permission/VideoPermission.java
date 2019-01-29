
package com.revotech.portal.videolibrary.permission;

import com.revotech.portal.videolibrary.model.VLVideo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;


/**
 * @author Keli
 *
 */
public class VideoPermission {

	public static void check(PermissionChecker permissionChecker, long threadId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, threadId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, VLVideo video, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, video, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, VLVideo video, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(video.getGroupId(), VLVideo.class.getName(), video.getPrimaryKey(), actionId);
	}
	
	
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId){
		
		return permissionChecker.hasPermission(groupId, VLVideo.class.getName(), groupId, actionId);
	}
}
