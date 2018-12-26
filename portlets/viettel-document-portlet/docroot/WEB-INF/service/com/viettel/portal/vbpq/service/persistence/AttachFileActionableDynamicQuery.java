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

package com.viettel.portal.vbpq.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.viettel.portal.vbpq.model.AttachFile;
import com.viettel.portal.vbpq.service.AttachFileLocalServiceUtil;

/**
 * @author ChucHV
 * @generated
 */
public abstract class AttachFileActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public AttachFileActionableDynamicQuery() throws SystemException {
		setBaseLocalService(AttachFileLocalServiceUtil.getService());
		setClass(AttachFile.class);

		setClassLoader(com.viettel.portal.vbpq.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("id");
	}
}