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

package com.liferay.viettel.portal.counter.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CounterReport}.
 * </p>
 *
 * @author chuchv
 * @see CounterReport
 * @generated
 */
public class CounterReportWrapper implements CounterReport,
	ModelWrapper<CounterReport> {
	public CounterReportWrapper(CounterReport counterReport) {
		_counterReport = counterReport;
	}

	@Override
	public Class<?> getModelClass() {
		return CounterReport.class;
	}

	@Override
	public String getModelClassName() {
		return CounterReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this counter report.
	*
	* @return the primary key of this counter report
	*/
	@Override
	public long getPrimaryKey() {
		return _counterReport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this counter report.
	*
	* @param primaryKey the primary key of this counter report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_counterReport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report ID of this counter report.
	*
	* @return the report ID of this counter report
	*/
	@Override
	public long getReportId() {
		return _counterReport.getReportId();
	}

	/**
	* Sets the report ID of this counter report.
	*
	* @param reportId the report ID of this counter report
	*/
	@Override
	public void setReportId(long reportId) {
		_counterReport.setReportId(reportId);
	}

	/**
	* Returns the company ID of this counter report.
	*
	* @return the company ID of this counter report
	*/
	@Override
	public long getCompanyId() {
		return _counterReport.getCompanyId();
	}

	/**
	* Sets the company ID of this counter report.
	*
	* @param companyId the company ID of this counter report
	*/
	@Override
	public void setCompanyId(long companyId) {
		_counterReport.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this counter report.
	*
	* @return the group ID of this counter report
	*/
	@Override
	public long getGroupId() {
		return _counterReport.getGroupId();
	}

	/**
	* Sets the group ID of this counter report.
	*
	* @param groupId the group ID of this counter report
	*/
	@Override
	public void setGroupId(long groupId) {
		_counterReport.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this counter report.
	*
	* @return the user ID of this counter report
	*/
	@Override
	public long getUserId() {
		return _counterReport.getUserId();
	}

	/**
	* Sets the user ID of this counter report.
	*
	* @param userId the user ID of this counter report
	*/
	@Override
	public void setUserId(long userId) {
		_counterReport.setUserId(userId);
	}

	/**
	* Returns the user uuid of this counter report.
	*
	* @return the user uuid of this counter report
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _counterReport.getUserUuid();
	}

	/**
	* Sets the user uuid of this counter report.
	*
	* @param userUuid the user uuid of this counter report
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_counterReport.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this counter report.
	*
	* @return the user name of this counter report
	*/
	@Override
	public java.lang.String getUserName() {
		return _counterReport.getUserName();
	}

	/**
	* Sets the user name of this counter report.
	*
	* @param userName the user name of this counter report
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_counterReport.setUserName(userName);
	}

	/**
	* Returns the create date of this counter report.
	*
	* @return the create date of this counter report
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _counterReport.getCreateDate();
	}

	/**
	* Sets the create date of this counter report.
	*
	* @param createDate the create date of this counter report
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_counterReport.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _counterReport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_counterReport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _counterReport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_counterReport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _counterReport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _counterReport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_counterReport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _counterReport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_counterReport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_counterReport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_counterReport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CounterReportWrapper((CounterReport)_counterReport.clone());
	}

	@Override
	public int compareTo(
		com.liferay.viettel.portal.counter.model.CounterReport counterReport) {
		return _counterReport.compareTo(counterReport);
	}

	@Override
	public int hashCode() {
		return _counterReport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.viettel.portal.counter.model.CounterReport> toCacheModel() {
		return _counterReport.toCacheModel();
	}

	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport toEscapedModel() {
		return new CounterReportWrapper(_counterReport.toEscapedModel());
	}

	@Override
	public com.liferay.viettel.portal.counter.model.CounterReport toUnescapedModel() {
		return new CounterReportWrapper(_counterReport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _counterReport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _counterReport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_counterReport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CounterReportWrapper)) {
			return false;
		}

		CounterReportWrapper counterReportWrapper = (CounterReportWrapper)obj;

		if (Validator.equals(_counterReport, counterReportWrapper._counterReport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CounterReport getWrappedCounterReport() {
		return _counterReport;
	}

	@Override
	public CounterReport getWrappedModel() {
		return _counterReport;
	}

	@Override
	public void resetOriginalValues() {
		_counterReport.resetOriginalValues();
	}

	private CounterReport _counterReport;
}