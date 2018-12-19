package com.viettel.portal.magazine.util;

import com.liferay.portal.kernel.exception.PortalException;

public class NotAloneException extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAloneException() {
		super();
	}

	public NotAloneException(String msg) {
		super(msg);
	}

	public NotAloneException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NotAloneException(Throwable cause) {
		super(cause);
	}

}
