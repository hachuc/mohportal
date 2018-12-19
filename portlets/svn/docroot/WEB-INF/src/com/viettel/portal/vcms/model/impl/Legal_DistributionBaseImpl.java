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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.viettel.portal.vcms.model.Legal_Distribution;
import com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil;

/**
 * The extended model base implementation for the Legal_Distribution service. Represents a row in the &quot;Distribution&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Legal_DistributionImpl}.
 * </p>
 *
 * @author chuchv
 * @see Legal_DistributionImpl
 * @see com.viettel.portal.vcms.model.Legal_Distribution
 * @generated
 */
public abstract class Legal_DistributionBaseImpl
	extends Legal_DistributionModelImpl implements Legal_Distribution {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal_ distribution model instance should use the {@link Legal_Distribution} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_DistributionLocalServiceUtil.addLegal_Distribution(this);
		}
		else {
			Legal_DistributionLocalServiceUtil.updateLegal_Distribution(this);
		}
	}
}