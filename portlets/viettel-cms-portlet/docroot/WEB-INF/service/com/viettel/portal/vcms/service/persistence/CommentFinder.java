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

package com.viettel.portal.vcms.service.persistence;

/**
 * @author chuchv
 */
public interface CommentFinder {
	public java.util.List<com.viettel.portal.vcms.model.Comment> findByKeywords(
		long companyId, long groupId, java.lang.String keywords, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.viettel.portal.vcms.model.Comment> findByC_G_F_E_B(
		long companyId, long groupId, java.lang.String[] fullNames,
		java.lang.String[] emails, java.lang.String[] body,
		boolean andOperator, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countByKeywords(long companyId, long groupId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_F_N_D(long companyId, long groupId,
		java.lang.String fullName, java.lang.String email,
		java.lang.String body, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countByC_G_F_N_D(long companyId, long groupId,
		java.lang.String[] feedIds, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List customSearchByKeywords(long companyId, long groupId,
		java.lang.String keywords, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List customOneFieldSearchByC_G_F_E_B(long companyId,
		long groupId, java.lang.String[] keywords, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List customSearchByC_G_F_E_B(long companyId, long groupId,
		java.lang.String[] fullNames, java.lang.String[] emails,
		java.lang.String[] body, boolean andOperator, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int customCountByKeywords(long companyId, long groupId,
		java.lang.String keywords, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int customCountByC_G_F_N_D(long companyId, long groupId,
		java.lang.String[] feedIds, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int customCountOneFieldByC_G_F_N_D(long companyId, long groupId,
		java.lang.String[] searchKeywords, int type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}