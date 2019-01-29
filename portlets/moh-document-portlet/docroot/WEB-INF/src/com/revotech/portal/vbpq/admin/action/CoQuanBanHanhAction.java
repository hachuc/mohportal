package com.revotech.portal.vbpq.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.revotech.portal.vbpq.portlet.NhomVanBanController;
import com.revotech.portal.vbpq.service.CoQuanBanHanhVanBanLocalServiceUtil;
import com.revotech.portal.vbpq.terms.CoQuanBanHanhTerms;
import com.revotech.portal.vbpq.util.MessageErrors;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

public class CoQuanBanHanhAction {
	/**
	 * Delele CoQuanBanHanh by Id
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {
		long coQuanId = ParamUtil.getLong(actionRequest, CoQuanBanHanhTerms.ID);

		CoQuanBanHanhVanBanLocalServiceUtil.deleteCoQuan(coQuanId);
	}

	/**
	 * Update CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateCoQuanBanHanh(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		CoQuanBanHanhTerms terms = new CoQuanBanHanhTerms(actionRequest);

		ServiceContext context = ServiceContextFactory
				.getInstance(actionRequest);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(terms.getTen(), errors);
		
		long nhomVanBanId = ParamUtil.getLong(actionRequest, NhomVanBanController.NHOM_VAN_BAN_ID, 0);

		if (valid) {
			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {
				CoQuanBanHanhVanBanLocalServiceUtil.updateCoQuanBanHanh(
						context.getUserId(), terms.getId(), terms.getTen(),
						terms.isTrangThai(), terms.getOrder(), context.getScopeGroupId(), nhomVanBanId);
			}
		}
		
		for(String error : errors) {
			SessionErrors.add(actionRequest, error);
		}

	}

	/**
	 * Validation input form
	 * 
	 * @param ten
	 * @param errors
	 * @return
	 */
	private boolean validationInput(String ten, List<String> errors) {

		boolean result = true;

		if (Validator.isNull(ten)) {
			errors.add(MessageErrors.EMPTY_TEN_CO_QUAN_BAN_HANH);
			result = false;
		}

		return result;
	}
}
