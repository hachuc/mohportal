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
 * This class is a wrapper for {@link Legal_Comment}.
 * </p>
 *
 * @author chuchv
 * @see Legal_Comment
 * @generated
 */
public class Legal_CommentWrapper implements Legal_Comment,
	ModelWrapper<Legal_Comment> {
	public Legal_CommentWrapper(Legal_Comment legal_Comment) {
		_legal_Comment = legal_Comment;
	}

	@Override
	public Class<?> getModelClass() {
		return Legal_Comment.class;
	}

	@Override
	public String getModelClassName() {
		return Legal_Comment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("DistributionID", getDistributionID());
		attributes.put("Fullname", getFullname());
		attributes.put("Address", getAddress());
		attributes.put("Email", getEmail());
		attributes.put("Body", getBody());
		attributes.put("Visible", getVisible());
		attributes.put("CreationDate", getCreationDate());
		attributes.put("ModifiedDate", getModifiedDate());
		attributes.put("IPAddress", getIPAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer ID = (Integer)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		Integer DistributionID = (Integer)attributes.get("DistributionID");

		if (DistributionID != null) {
			setDistributionID(DistributionID);
		}

		String Fullname = (String)attributes.get("Fullname");

		if (Fullname != null) {
			setFullname(Fullname);
		}

		String Address = (String)attributes.get("Address");

		if (Address != null) {
			setAddress(Address);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String Body = (String)attributes.get("Body");

		if (Body != null) {
			setBody(Body);
		}

		Boolean Visible = (Boolean)attributes.get("Visible");

		if (Visible != null) {
			setVisible(Visible);
		}

		Date CreationDate = (Date)attributes.get("CreationDate");

		if (CreationDate != null) {
			setCreationDate(CreationDate);
		}

		Date ModifiedDate = (Date)attributes.get("ModifiedDate");

		if (ModifiedDate != null) {
			setModifiedDate(ModifiedDate);
		}

		String IPAddress = (String)attributes.get("IPAddress");

		if (IPAddress != null) {
			setIPAddress(IPAddress);
		}
	}

	/**
	* Returns the primary key of this legal_ comment.
	*
	* @return the primary key of this legal_ comment
	*/
	@Override
	public int getPrimaryKey() {
		return _legal_Comment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legal_ comment.
	*
	* @param primaryKey the primary key of this legal_ comment
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legal_Comment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this legal_ comment.
	*
	* @return the i d of this legal_ comment
	*/
	@Override
	public int getID() {
		return _legal_Comment.getID();
	}

	/**
	* Sets the i d of this legal_ comment.
	*
	* @param ID the i d of this legal_ comment
	*/
	@Override
	public void setID(int ID) {
		_legal_Comment.setID(ID);
	}

	/**
	* Returns the distribution i d of this legal_ comment.
	*
	* @return the distribution i d of this legal_ comment
	*/
	@Override
	public int getDistributionID() {
		return _legal_Comment.getDistributionID();
	}

	/**
	* Sets the distribution i d of this legal_ comment.
	*
	* @param DistributionID the distribution i d of this legal_ comment
	*/
	@Override
	public void setDistributionID(int DistributionID) {
		_legal_Comment.setDistributionID(DistributionID);
	}

	/**
	* Returns the fullname of this legal_ comment.
	*
	* @return the fullname of this legal_ comment
	*/
	@Override
	public java.lang.String getFullname() {
		return _legal_Comment.getFullname();
	}

	/**
	* Sets the fullname of this legal_ comment.
	*
	* @param Fullname the fullname of this legal_ comment
	*/
	@Override
	public void setFullname(java.lang.String Fullname) {
		_legal_Comment.setFullname(Fullname);
	}

	/**
	* Returns the address of this legal_ comment.
	*
	* @return the address of this legal_ comment
	*/
	@Override
	public java.lang.String getAddress() {
		return _legal_Comment.getAddress();
	}

	/**
	* Sets the address of this legal_ comment.
	*
	* @param Address the address of this legal_ comment
	*/
	@Override
	public void setAddress(java.lang.String Address) {
		_legal_Comment.setAddress(Address);
	}

	/**
	* Returns the email of this legal_ comment.
	*
	* @return the email of this legal_ comment
	*/
	@Override
	public java.lang.String getEmail() {
		return _legal_Comment.getEmail();
	}

	/**
	* Sets the email of this legal_ comment.
	*
	* @param Email the email of this legal_ comment
	*/
	@Override
	public void setEmail(java.lang.String Email) {
		_legal_Comment.setEmail(Email);
	}

	/**
	* Returns the body of this legal_ comment.
	*
	* @return the body of this legal_ comment
	*/
	@Override
	public java.lang.String getBody() {
		return _legal_Comment.getBody();
	}

	/**
	* Sets the body of this legal_ comment.
	*
	* @param Body the body of this legal_ comment
	*/
	@Override
	public void setBody(java.lang.String Body) {
		_legal_Comment.setBody(Body);
	}

	/**
	* Returns the visible of this legal_ comment.
	*
	* @return the visible of this legal_ comment
	*/
	@Override
	public boolean getVisible() {
		return _legal_Comment.getVisible();
	}

	/**
	* Returns <code>true</code> if this legal_ comment is visible.
	*
	* @return <code>true</code> if this legal_ comment is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _legal_Comment.isVisible();
	}

	/**
	* Sets whether this legal_ comment is visible.
	*
	* @param Visible the visible of this legal_ comment
	*/
	@Override
	public void setVisible(boolean Visible) {
		_legal_Comment.setVisible(Visible);
	}

	/**
	* Returns the creation date of this legal_ comment.
	*
	* @return the creation date of this legal_ comment
	*/
	@Override
	public java.util.Date getCreationDate() {
		return _legal_Comment.getCreationDate();
	}

	/**
	* Sets the creation date of this legal_ comment.
	*
	* @param CreationDate the creation date of this legal_ comment
	*/
	@Override
	public void setCreationDate(java.util.Date CreationDate) {
		_legal_Comment.setCreationDate(CreationDate);
	}

	/**
	* Returns the modified date of this legal_ comment.
	*
	* @return the modified date of this legal_ comment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _legal_Comment.getModifiedDate();
	}

	/**
	* Sets the modified date of this legal_ comment.
	*
	* @param ModifiedDate the modified date of this legal_ comment
	*/
	@Override
	public void setModifiedDate(java.util.Date ModifiedDate) {
		_legal_Comment.setModifiedDate(ModifiedDate);
	}

	/**
	* Returns the i p address of this legal_ comment.
	*
	* @return the i p address of this legal_ comment
	*/
	@Override
	public java.lang.String getIPAddress() {
		return _legal_Comment.getIPAddress();
	}

	/**
	* Sets the i p address of this legal_ comment.
	*
	* @param IPAddress the i p address of this legal_ comment
	*/
	@Override
	public void setIPAddress(java.lang.String IPAddress) {
		_legal_Comment.setIPAddress(IPAddress);
	}

	@Override
	public boolean isNew() {
		return _legal_Comment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legal_Comment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legal_Comment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legal_Comment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legal_Comment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legal_Comment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legal_Comment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legal_Comment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legal_Comment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legal_Comment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legal_Comment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new Legal_CommentWrapper((Legal_Comment)_legal_Comment.clone());
	}

	@Override
	public int compareTo(
		com.viettel.portal.vcms.model.Legal_Comment legal_Comment) {
		return _legal_Comment.compareTo(legal_Comment);
	}

	@Override
	public int hashCode() {
		return _legal_Comment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.viettel.portal.vcms.model.Legal_Comment> toCacheModel() {
		return _legal_Comment.toCacheModel();
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Comment toEscapedModel() {
		return new Legal_CommentWrapper(_legal_Comment.toEscapedModel());
	}

	@Override
	public com.viettel.portal.vcms.model.Legal_Comment toUnescapedModel() {
		return new Legal_CommentWrapper(_legal_Comment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legal_Comment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legal_Comment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legal_Comment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Legal_CommentWrapper)) {
			return false;
		}

		Legal_CommentWrapper legal_CommentWrapper = (Legal_CommentWrapper)obj;

		if (Validator.equals(_legal_Comment, legal_CommentWrapper._legal_Comment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Legal_Comment getWrappedLegal_Comment() {
		return _legal_Comment;
	}

	@Override
	public Legal_Comment getWrappedModel() {
		return _legal_Comment;
	}

	@Override
	public void resetOriginalValues() {
		_legal_Comment.resetOriginalValues();
	}

	private Legal_Comment _legal_Comment;
}