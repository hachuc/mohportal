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

package com.viettel.portal.links.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.viettel.portal.links.model.LCategory;
import com.viettel.portal.links.service.LCategoryLocalServiceUtil;

/**
 * The extended model base implementation for the LCategory service. Represents a row in the &quot;portal_linkcategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LCategoryImpl}.
 * </p>
 *
 * @author ChucHV
 * @see LCategoryImpl
 * @see com.viettel.portal.links.model.LCategory
 * @generated
 */
public abstract class LCategoryBaseImpl extends LCategoryModelImpl
	implements LCategory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a l category model instance should use the {@link LCategory} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LCategoryLocalServiceUtil.addLCategory(this);
		}
		else {
			LCategoryLocalServiceUtil.updateLCategory(this);
		}
	}
}