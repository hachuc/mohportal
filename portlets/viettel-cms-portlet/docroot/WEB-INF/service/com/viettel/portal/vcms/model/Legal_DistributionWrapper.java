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

package com.viettel.portal.vcms.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Legal_Distribution}.
 * </p>
 *
 * @author chuchv
 * @see Legal_Distribution
 * @generated
 */
public class Legal_DistributionWrapper implements Legal_Distribution,
	ModelWrapper<Legal_Distribution> {
	public Legal_DistributionWrapper(Legal_Distribution legal_Distribution) {
		_legal_Distribution = legal_Distribution;
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Distribution.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Distribution.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("ContentID", getContentID());
		attributes.put("Version", getVersion());
		attributes.put("ZoneID", getZoneID());
		attributes.put("DistributedDate", getDistributedDate());
		attributes.put("Ranking", getRanking());
		attributes.put("AllowDiscussion", getAllowDiscussion());
		attributes.put("ViewedCount", getViewedCount());
		attributes.put("MailedCount", getMailedCount());
		attributes.put("RatedCount", getRatedCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer ContentID = (Integer)attributes.get("ContentID");

		if (ContentID != null) {
			setContentID(ContentID);
		}

		Integer Version = (Integer)attributes.get("Version");

		if (Version != null) {
			setVersion(Version);
		}

		Integer ZoneID = (Integer)attributes.get("ZoneID");

		if (ZoneID != null) {
			setZoneID(ZoneID);
		}

		Date DistributedDate = (Date)attributes.get("DistributedDate");

		if (DistributedDate != null) {
			setDistributedDate(DistributedDate);
		}

		Integer Ranking = (Integer)attributes.get("Ranking");

		if (Ranking != null) {
			setRanking(Ranking);
		}

		Boolean AllowDiscussion = (Boolean)attributes.get("AllowDiscussion");

		if (AllowDiscussion != null) {
			setAllowDiscussion(AllowDiscussion);
		}

		Integer ViewedCount = (Integer)attributes.get("ViewedCount");

		if (ViewedCount != null) {
			setViewedCount(ViewedCount);
		}

		Integer MailedCount = (Integer)attributes.get("MailedCount");

		if (MailedCount != null) {
			setMailedCount(MailedCount);
		}

		Integer RatedCount = (Integer)attributes.get("RatedCount");

		if (RatedCount != null) {
			setRatedCount(RatedCount);
		}
	}

	/**
	* Returns the primary key of this legal_ distribution.
	*
	* @return the primary key of this legal_ distribution
	*/
	@Override
	public int getPrimaryKey() {
		return _legal_Distribution.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal_ distribution.
	*
	* @param primaryKey the primary key of this legal_ distribution
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legal_Distribution.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this legal_ distribution.
	*
	* @return the i d of this legal_ distribution
	*/
	@Override
	public int getID() {
		return _legal_Distribution.getID();
	}

	/**
	* Sets the i d of this legal_ distribution.
	*
	* @param ID the i d of this legal_ distribution
	*/
	@Override
	public void setID(int ID) {
		_legal_Distribution.setID(ID);
	}

	/**
	* Returns the content i d of this legal_ distribution.
	*
	* @return the content i d of this legal_ distribution
	*/
	@Override
	public int getContentID() {
		return _legal_Distribution.getContentID();
	}

	/**
	* Sets the content i d of this legal_ distribution.
	*
	* @param ContentID the content i d of this legal_ distribution
	*/
	@Override
	public void setContentID(int ContentID) {
		_legal_Distribution.setContentID(ContentID);
	}

	/**
	* Returns the version of this legal_ distribution.
	*
	* @return the version of this legal_ distribution
	*/
	@Override
	public int getVersion() {
		return _legal_Distribution.getVersion();
	}

	/**
	* Sets the version of this legal_ distribution.
	*
	* @param Version the version of this legal_ distribution
	*/
	@Override
	public void setVersion(int Version) {
		_legal_Distribution.setVersion(Version);
	}

	/**
	* Returns the zone i d of this legal_ distribution.
	*
	* @return the zone i d of this legal_ distribution
	*/
	@Override
	public int getZoneID() {
		return _legal_Distribution.getZoneID();
	}

	/**
	* Sets the zone i d of this legal_ distribution.
	*
	* @param ZoneID the zone i d of this legal_ distribution
	*/
	@Override
	public void setZoneID(int ZoneID) {
		_legal_Distribution.setZoneID(ZoneID);
	}

	/**
	* Returns the distributed date of this legal_ distribution.
	*
	* @return the distributed date of this legal_ distribution
	*/
	@Override
	public java.util.Date getDistributedDate() {
		return _legal_Distribution.getDistributedDate();
	}

	/**
	* Sets the distributed date of this legal_ distribution.
	*
	* @param DistributedDate the distributed date of this legal_ distribution
	*/
	@Override
	public void setDistributedDate(java.util.Date DistributedDate) {
		_legal_Distribution.setDistributedDate(DistributedDate);
	}

	/**
	* Returns the ranking of this legal_ distribution.
	*
	* @return the ranking of this legal_ distribution
	*/
	@Override
	public int getRanking() {
		return _legal_Distribution.getRanking();
	}

	/**
	* Sets the ranking of this legal_ distribution.
	*
	* @param Ranking the ranking of this legal_ distribution
	*/
	@Override
	public void setRanking(int Ranking) {
		_legal_Distribution.setRanking(Ranking);
	}

	/**
	* Returns the allow discussion of this legal_ distribution.
	*
	* @return the allow discussion of this legal_ distribution
	*/
	@Override
	public boolean getAllowDiscussion() {
		return _legal_Distribution.getAllowDiscussion();
	}

	/**
	* Returns <code>true</code> if this legal_ distribution is allow discussion.
	*
	* @return <code>true</code> if this legal_ distribution is allow discussion; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllowDiscussion() {
		return _legal_Distribution.isAllowDiscussion();
	}

	/**
	* Sets whether this legal_ distribution is allow discussion.
	*
	* @param AllowDiscussion the allow discussion of this legal_ distribution
	*/
	@Override
	public void setAllowDiscussion(boolean AllowDiscussion) {
		_legal_Distribution.setAllowDiscussion(AllowDiscussion);
	}

	/**
	* Returns the viewed count of this legal_ distribution.
	*
	* @return the viewed count of this legal_ distribution
	*/
	@Override
	public int getViewedCount() {
		return _legal_Distribution.getViewedCount();
	}

	/**
	* Sets the viewed count of this legal_ distribution.
	*
	* @param ViewedCount the viewed count of this legal_ distribution
	*/
	@Override
	public void setViewedCount(int ViewedCount) {
		_legal_Distribution.setViewedCount(ViewedCount);
	}

	/**
	* Returns the mailed count of this legal_ distribution.
	*
	* @return the mailed count of this legal_ distribution
	*/
	@Override
	public int getMailedCount() {
		return _legal_Distribution.getMailedCount();
	}

	/**
	* Sets the mailed count of this legal_ distribution.
	*
	* @param MailedCount the mailed count of this legal_ distribution
	*/
	@Override
	public void setMailedCount(int MailedCount) {
		_legal_Distribution.setMailedCount(MailedCount);
	}

	/**
	* Returns the rated count of this legal_ distribution.
	*
	* @return the rated count of this legal_ distribution
	*/
	@Override
	public int getRatedCount() {
		return _legal_Distribution.getRatedCount();
	}

	/**
	* Sets the rated count of this legal_ distribution.
	*
	* @param RatedCount the rated count of this legal_ distribution
	*/
	@Override
	public void setRatedCount(int RatedCount) {
		_legal_Distribution.setRatedCount(RatedCount);
	}

	@Override
	public boolean isNew() {
		return _legal_Distribution.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legal_Distribution.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legal_Distribution.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legal_Distribution.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legal_Distribution.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legal_Distribution.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legal_Distribution.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legal_Distribution.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legal_Distribution.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legal_Distribution.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legal_Distribution.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Legal_DistributionWrapper((Legal_Distribution)_legal_Distribution.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.Legal_Distribution legal_Distribution) {
		return _legal_Distribution.compareTo(legal_Distribution);
	}

	@Override
	public int hashCode() {
		return _legal_Distribution.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Legal_Distribution> toCacheModel() {
		return _legal_Distribution.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution toEscapedModel() {
		return new Legal_DistributionWrapper(_legal_Distribution.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Distribution toUnescapedModel() {
		return new Legal_DistributionWrapper(_legal_Distribution.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legal_Distribution.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legal_Distribution.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legal_Distribution.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legal_DistributionWrapper)) {
			return false;
		}

		Legal_DistributionWrapper legal_DistributionWrapper = (Legal_DistributionWrapper)obj;

		if (Validator.equals(_legal_Distribution,
					legal_DistributionWrapper._legal_Distribution)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legal_Distribution getWrappedLegal_Distribution() {
		return _legal_Distribution;
	}

	@Override
	public Legal_Distribution getWrappedModel() {
		return _legal_Distribution;
	}

	@Override
	public void resetOriginalValues() {
		_legal_Distribution.resetOriginalValues();
	}

	private Legal_Distribution _legal_Distribution;
}