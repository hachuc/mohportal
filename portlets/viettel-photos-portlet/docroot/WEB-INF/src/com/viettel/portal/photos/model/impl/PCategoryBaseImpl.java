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

package com.viettel.portal.photos.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.viettel.portal.photos.model.PCategory;
import com.viettel.portal.photos.service.PCategoryLocalServiceUtil;

/**
 * The extended model base implementation for the PCategory service. Represents a row in the &quot;portal_photocategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PCategoryImpl}.
 * </p>
 *
 * @author ChucHV
 * @see PCategoryImpl
 * @see com.viettel.portal.photos.model.PCategory
 * @generated
 */
public abstract class PCategoryBaseImpl extends PCategoryModelImpl
	implements PCategory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p category model instance should use the {@link PCategory} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PCategoryLocalServiceUtil.addPCategory(this);
		}
		else {
			PCategoryLocalServiceUtil.updatePCategory(this);
		}
	}
}