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

package com.viettel.portal.vcms.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.viettel.portal.vcms.model.Legal_Distribution;
import com.viettel.portal.vcms.service.base.Legal_DistributionLocalServiceBaseImpl;
import com.viettel.portal.vcms.service.persistence.Legal_DistributionUtil;

/**
 * The implementation of the legal_ distribution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.viettel.portal.vcms.service.Legal_DistributionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author chuchv
 * @see com.viettel.portal.vcms.service.base.Legal_DistributionLocalServiceBaseImpl
 * @see com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil
 */
public class Legal_DistributionLocalServiceImpl
	extends Legal_DistributionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil} to access the legal_ distribution local service.
	 */
	public List<Legal_Distribution> getByZone(int zoneId) throws SystemException, PortalException{
		return Legal_DistributionUtil.findByByZoneID(zoneId);
	}
}