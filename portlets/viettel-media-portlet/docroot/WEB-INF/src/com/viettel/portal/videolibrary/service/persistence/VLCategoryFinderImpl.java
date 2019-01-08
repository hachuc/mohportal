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

package com.viettel.portal.videolibrary.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.viettel.portal.videolibrary.model.VLCategory;
import com.viettel.portal.videolibrary.model.impl.VLCategoryImpl;

/**
 * The persistence implementation for the v l category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author ChucHV
 * @see VLCategoryPersistence
 * @see VLCategoryUtil
 * @generated
 */
public class VLCategoryFinderImpl extends BasePersistenceImpl<VLCategory>
	implements VLCategoryFinder {
	
	public static final String GET_ALL_BY_GROUP_ID ="SELECT * FROM portal_videocategory  a1 WHERE (a1.groupid = ?) AND (a1.invisible = ?) ORDER BY a1.modifiedDate desc ";
	
	/**
	 * Returns all the v l categories where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> getByGroupUserSite(long groupId) throws SystemException {
		return findByGroup(groupId);
	}

	

	/**
	 * Returns an ordered range of all the v l categories where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.viettel.portal.videolibrary.model.impl.VLCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of v l categories
	 * @param end the upper bound of the range of v l categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v l categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VLCategory> findByGroup(long groupId) throws SystemException {
		Session session = null;


		try {
			session = openSession();

			SQLQuery q = session.createSQLQuery(GET_ALL_BY_GROUP_ID);

			q.addEntity("VLCategory", VLCategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(true);

			return (List<VLCategory>) QueryUtil.list(q, getDialect(),0,9999999);

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

}