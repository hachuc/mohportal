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

package com.viettel.portal.magazine.archive;

import com.liferay.portal.NoSuchModelException;

/**
 * @author namtv
 */
public class NoSuchMagazineException extends NoSuchModelException {

	public NoSuchMagazineException() {
		super();
	}

	public NoSuchMagazineException(String msg) {
		super(msg);
	}

	public NoSuchMagazineException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchMagazineException(Throwable cause) {
		super(cause);
	}

}