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

package com.viettel.portal.thongke.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.service.PhongBanNhuanButLocalServiceUtil;

/**
 * @author lamvn
 * @generated
 */
public abstract class PhongBanNhuanButActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PhongBanNhuanButActionableDynamicQuery() throws SystemException {
		setBaseLocalService(PhongBanNhuanButLocalServiceUtil.getService());
		setClass(PhongBanNhuanBut.class);

		setClassLoader(com.viettel.portal.thongke.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}