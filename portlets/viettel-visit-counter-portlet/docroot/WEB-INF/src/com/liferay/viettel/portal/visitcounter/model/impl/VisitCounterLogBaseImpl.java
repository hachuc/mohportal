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

package com.liferay.viettel.portal.visitcounter.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;
import com.liferay.viettel.portal.visitcounter.service.VisitCounterLogLocalServiceUtil;

/**
 * The extended model base implementation for the VisitCounterLog service. Represents a row in the &quot;VisitCounterLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VisitCounterLogImpl}.
 * </p>
 *
 * @author hiepth6
 * @see VisitCounterLogImpl
 * @see com.liferay.viettel.portal.visitcounter.model.VisitCounterLog
 * @generated
 */
public abstract class VisitCounterLogBaseImpl extends VisitCounterLogModelImpl
	implements VisitCounterLog {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a visit counter log model instance should use the {@link VisitCounterLog} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VisitCounterLogLocalServiceUtil.addVisitCounterLog(this);
		}
		else {
			VisitCounterLogLocalServiceUtil.updateVisitCounterLog(this);
		}
	}
}