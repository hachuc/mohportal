package com.revotech.portal.vbpq.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.revotech.portal.vbpq.portlet.NhomVanBanController;
import com.revotech.portal.vbpq.service.LoaiVanBanLocalServiceUtil;
import com.revotech.portal.vbpq.terms.LoaiVanBanTerms;
import com.revotech.portal.vbpq.util.MessageErrors;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

public class LoaiVanBanAction {
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		long loaiId = ParamUtil
				.getLong(actionRequest, LoaiVanBanTerms.ID);

		LoaiVanBanLocalServiceUtil.deleteLoaiVanBan(loaiId);
	}

	/**
	 * Update CoQuanBanHanh
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateLoaiVanBan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException {

		LoaiVanBanTerms terms = new LoaiVanBanTerms(actionRequest);

		ServiceContext context = ServiceContextFactory
				.getInstance(actionRequest);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		List<String> errors = new ArrayList<String>();

		boolean valid = validationInput(terms.getTen(), errors);
		long nhomVanBanId = ParamUtil.getLong(actionRequest, NhomVanBanController.NHOM_VAN_BAN_ID, 0);

		if (valid) {
			if (cmd.contentEquals(Constants.ADD)
					|| cmd.contentEquals(Constants.UPDATE)) {
				LoaiVanBanLocalServiceUtil.updateLoaiVanBan(
						context.getUserId(), terms.getId(), terms.getTen(),
						terms.isTrangThai(), terms.getOrder(),
						context.getScopeGroupId(), nhomVanBanId);
			}
		}

		for (String error : errors) {
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
			errors.add(MessageErrors.EMPTY_TEN_LOAI_VAN_BAN);
			result = false;
		}

		return result;
	}

}
