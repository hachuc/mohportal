/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.viettel.portal.vbpq;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author ChucHV
 */
public class LoaiVanBanTenException extends PortalException {

	public LoaiVanBanTenException() {
		super();
	}

	public LoaiVanBanTenException(String msg) {
		super(msg);
	}

	public LoaiVanBanTenException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LoaiVanBanTenException(Throwable cause) {
		super(cause);
	}

}