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

package com.viettel.portal.vcms.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.CommentModel;
import com.viettel.portal.vcms.model.CommentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Comment service. Represents a row in the &quot;vcms_Comment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.CommentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommentImpl}.
 * </p>
 *
 * @author chuchv
 * @see CommentImpl
 * @see com.viettel.portal.vcms.model.Comment
 * @see com.viettel.portal.vcms.model.CommentModel
 * @generated
 */
@JSON(strict = true)
public class CommentModelImpl extends BaseModelImpl<Comment>
	implements CommentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a comment model instance should use the {@link com.viettel.portal.vcms.model.Comment} interface instead.
	 */
	public static final String TABLE_NAME = "vcms_Comment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "distributionId", Types.BIGINT },
			{ "fullName", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "body", Types.VARCHAR },
			{ "visible", Types.BOOLEAN },
			{ "ipAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vcms_Comment (commentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,distributionId LONG,fullName VARCHAR(255) null,address VARCHAR(255) null,email VARCHAR(255) null,body STRING null,visible BOOLEAN,ipAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vcms_Comment";
	public static final String ORDER_BY_JPQL = " ORDER BY comment.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY vcms_Comment.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.Comment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.Comment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.Comment"),
			true);
	public static long DISTRIBUTIONID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long VISIBLE_COLUMN_BITMASK = 4L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Comment toModel(CommentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Comment model = new CommentImpl();

		model.setCommentId(soapModel.getCommentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDistributionId(soapModel.getDistributionId());
		model.setFullName(soapModel.getFullName());
		model.setAddress(soapModel.getAddress());
		model.setEmail(soapModel.getEmail());
		model.setBody(soapModel.getBody());
		model.setVisible(soapModel.getVisible());
		model.setIpAddress(soapModel.getIpAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Comment> toModels(CommentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Comment> models = new ArrayList<Comment>(soapModels.length);

		for (CommentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.Comment"));

	public CommentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Comment.class;
	}

	@Override
	public String getModelClassName() {
		return Comment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("distributionId", getDistributionId());
		attributes.put("fullName", getFullName());
		attributes.put("address", getAddress());
		attributes.put("email", getEmail());
		attributes.put("body", getBody());
		attributes.put("visible", getVisible());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long distributionId = (Long)attributes.get("distributionId");

		if (distributionId != null) {
			setDistributionId(distributionId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@JSON
	@Override
	public long getCommentId() {
		return _commentId;
	}

	@Override
	public void setCommentId(long commentId) {
		_commentId = commentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getDistributionId() {
		return _distributionId;
	}

	@Override
	public void setDistributionId(long distributionId) {
		_columnBitmask |= DISTRIBUTIONID_COLUMN_BITMASK;

		if (!_setOriginalDistributionId) {
			_setOriginalDistributionId = true;

			_originalDistributionId = _distributionId;
		}

		_distributionId = distributionId;
	}

	public long getOriginalDistributionId() {
		return _originalDistributionId;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getBody() {
		if (_body == null) {
			return StringPool.BLANK;
		}
		else {
			return _body;
		}
	}

	@Override
	public void setBody(String body) {
		_body = body;
	}

	@JSON
	@Override
	public boolean getVisible() {
		return _visible;
	}

	@Override
	public boolean isVisible() {
		return _visible;
	}

	@Override
	public void setVisible(boolean visible) {
		_columnBitmask |= VISIBLE_COLUMN_BITMASK;

		if (!_setOriginalVisible) {
			_setOriginalVisible = true;

			_originalVisible = _visible;
		}

		_visible = visible;
	}

	public boolean getOriginalVisible() {
		return _originalVisible;
	}

	@JSON
	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Comment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Comment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Comment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommentImpl commentImpl = new CommentImpl();

		commentImpl.setCommentId(getCommentId());
		commentImpl.setGroupId(getGroupId());
		commentImpl.setCompanyId(getCompanyId());
		commentImpl.setUserId(getUserId());
		commentImpl.setUserName(getUserName());
		commentImpl.setCreateDate(getCreateDate());
		commentImpl.setModifiedDate(getModifiedDate());
		commentImpl.setDistributionId(getDistributionId());
		commentImpl.setFullName(getFullName());
		commentImpl.setAddress(getAddress());
		commentImpl.setEmail(getEmail());
		commentImpl.setBody(getBody());
		commentImpl.setVisible(getVisible());
		commentImpl.setIpAddress(getIpAddress());

		commentImpl.resetOriginalValues();

		return commentImpl;
	}

	@Override
	public int compareTo(Comment comment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(), comment.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comment)) {
			return false;
		}

		Comment comment = (Comment)obj;

		long primaryKey = comment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CommentModelImpl commentModelImpl = this;

		commentModelImpl._originalGroupId = commentModelImpl._groupId;

		commentModelImpl._setOriginalGroupId = false;

		commentModelImpl._originalDistributionId = commentModelImpl._distributionId;

		commentModelImpl._setOriginalDistributionId = false;

		commentModelImpl._originalVisible = commentModelImpl._visible;

		commentModelImpl._setOriginalVisible = false;

		commentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Comment> toCacheModel() {
		CommentCacheModel commentCacheModel = new CommentCacheModel();

		commentCacheModel.commentId = getCommentId();

		commentCacheModel.groupId = getGroupId();

		commentCacheModel.companyId = getCompanyId();

		commentCacheModel.userId = getUserId();

		commentCacheModel.userName = getUserName();

		String userName = commentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commentCacheModel.createDate = createDate.getTime();
		}
		else {
			commentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commentCacheModel.distributionId = getDistributionId();

		commentCacheModel.fullName = getFullName();

		String fullName = commentCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			commentCacheModel.fullName = null;
		}

		commentCacheModel.address = getAddress();

		String address = commentCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			commentCacheModel.address = null;
		}

		commentCacheModel.email = getEmail();

		String email = commentCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			commentCacheModel.email = null;
		}

		commentCacheModel.body = getBody();

		String body = commentCacheModel.body;

		if ((body != null) && (body.length() == 0)) {
			commentCacheModel.body = null;
		}

		commentCacheModel.visible = getVisible();

		commentCacheModel.ipAddress = getIpAddress();

		String ipAddress = commentCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			commentCacheModel.ipAddress = null;
		}

		return commentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{commentId=");
		sb.append(getCommentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", distributionId=");
		sb.append(getDistributionId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", visible=");
		sb.append(getVisible());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Comment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commentId</column-name><column-value><![CDATA[");
		sb.append(getCommentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distributionId</column-name><column-value><![CDATA[");
		sb.append(getDistributionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Comment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Comment.class
		};
	private long _commentId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _distributionId;
	private long _originalDistributionId;
	private boolean _setOriginalDistributionId;
	private String _fullName;
	private String _address;
	private String _email;
	private String _body;
	private boolean _visible;
	private boolean _originalVisible;
	private boolean _setOriginalVisible;
	private String _ipAddress;
	private long _columnBitmask;
	private Comment _escapedModel;
}