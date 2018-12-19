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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vcms.model.Legal_Comment;
import com.viettel.portal.vcms.model.Legal_CommentModel;
import com.viettel.portal.vcms.model.Legal_CommentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Legal_Comment service. Represents a row in the &quot;Comment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.viettel.portal.vcms.model.Legal_CommentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Legal_CommentImpl}.
 * </p>
 *
 * @author chuchv
 * @see Legal_CommentImpl
 * @see com.viettel.portal.vcms.model.Legal_Comment
 * @see com.viettel.portal.vcms.model.Legal_CommentModel
 * @generated
 */
@JSON(strict = true)
public class Legal_CommentModelImpl extends BaseModelImpl<Legal_Comment>
	implements Legal_CommentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a legal_ comment model instance should use the {@link com.viettel.portal.vcms.model.Legal_Comment} interface instead.
	 */
	public static final String TABLE_NAME = "Comment";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.INTEGER },
			{ "DistributionID", Types.INTEGER },
			{ "Fullname", Types.VARCHAR },
			{ "Address", Types.VARCHAR },
			{ "Email", Types.VARCHAR },
			{ "Body", Types.VARCHAR },
			{ "Visible", Types.BOOLEAN },
			{ "CreationDate", Types.TIMESTAMP },
			{ "ModifiedDate", Types.TIMESTAMP },
			{ "IPAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Comment (ID INTEGER not null primary key,DistributionID INTEGER,Fullname VARCHAR(255) null,Address VARCHAR(255) null,Email VARCHAR(255) null,Body STRING null,Visible BOOLEAN,CreationDate DATE null,ModifiedDate DATE null,IPAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Comment";
	public static final String ORDER_BY_JPQL = " ORDER BY legal_Comment.ModifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Comment.ModifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.viettel.portal.vcms.model.Legal_Comment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.viettel.portal.vcms.model.Legal_Comment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.viettel.portal.vcms.model.Legal_Comment"),
			true);
	public static long DISTRIBUTIONID_COLUMN_BITMASK = 1L;
	public static long MODIFIEDDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Legal_Comment toModel(Legal_CommentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Legal_Comment model = new Legal_CommentImpl();

		model.setID(soapModel.getID());
		model.setDistributionID(soapModel.getDistributionID());
		model.setFullname(soapModel.getFullname());
		model.setAddress(soapModel.getAddress());
		model.setEmail(soapModel.getEmail());
		model.setBody(soapModel.getBody());
		model.setVisible(soapModel.getVisible());
		model.setCreationDate(soapModel.getCreationDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setIPAddress(soapModel.getIPAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Legal_Comment> toModels(Legal_CommentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Legal_Comment> models = new ArrayList<Legal_Comment>(soapModels.length);

		for (Legal_CommentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.viettel.portal.vcms.model.Legal_Comment"));

	public Legal_CommentModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
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

	@JSON
	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;
	}

	@JSON
	@Override
	public int getDistributionID() {
		return _DistributionID;
	}

	@Override
	public void setDistributionID(int DistributionID) {
		_columnBitmask |= DISTRIBUTIONID_COLUMN_BITMASK;

		if (!_setOriginalDistributionID) {
			_setOriginalDistributionID = true;

			_originalDistributionID = _DistributionID;
		}

		_DistributionID = DistributionID;
	}

	public int getOriginalDistributionID() {
		return _originalDistributionID;
	}

	@JSON
	@Override
	public String getFullname() {
		if (_Fullname == null) {
			return StringPool.BLANK;
		}
		else {
			return _Fullname;
		}
	}

	@Override
	public void setFullname(String Fullname) {
		_Fullname = Fullname;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_Address == null) {
			return StringPool.BLANK;
		}
		else {
			return _Address;
		}
	}

	@Override
	public void setAddress(String Address) {
		_Address = Address;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_Email == null) {
			return StringPool.BLANK;
		}
		else {
			return _Email;
		}
	}

	@Override
	public void setEmail(String Email) {
		_Email = Email;
	}

	@JSON
	@Override
	public String getBody() {
		if (_Body == null) {
			return StringPool.BLANK;
		}
		else {
			return _Body;
		}
	}

	@Override
	public void setBody(String Body) {
		_Body = Body;
	}

	@JSON
	@Override
	public boolean getVisible() {
		return _Visible;
	}

	@Override
	public boolean isVisible() {
		return _Visible;
	}

	@Override
	public void setVisible(boolean Visible) {
		_Visible = Visible;
	}

	@JSON
	@Override
	public Date getCreationDate() {
		return _CreationDate;
	}

	@Override
	public void setCreationDate(Date CreationDate) {
		_CreationDate = CreationDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _ModifiedDate;
	}

	@Override
	public void setModifiedDate(Date ModifiedDate) {
		_columnBitmask = -1L;

		_ModifiedDate = ModifiedDate;
	}

	@JSON
	@Override
	public String getIPAddress() {
		if (_IPAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _IPAddress;
		}
	}

	@Override
	public void setIPAddress(String IPAddress) {
		_IPAddress = IPAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Legal_Comment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Legal_Comment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Legal_CommentImpl legal_CommentImpl = new Legal_CommentImpl();

		legal_CommentImpl.setID(getID());
		legal_CommentImpl.setDistributionID(getDistributionID());
		legal_CommentImpl.setFullname(getFullname());
		legal_CommentImpl.setAddress(getAddress());
		legal_CommentImpl.setEmail(getEmail());
		legal_CommentImpl.setBody(getBody());
		legal_CommentImpl.setVisible(getVisible());
		legal_CommentImpl.setCreationDate(getCreationDate());
		legal_CommentImpl.setModifiedDate(getModifiedDate());
		legal_CommentImpl.setIPAddress(getIPAddress());

		legal_CommentImpl.resetOriginalValues();

		return legal_CommentImpl;
	}

	@Override
	public int compareTo(Legal_Comment legal_Comment) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				legal_Comment.getModifiedDate());

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

		if (!(obj instanceof Legal_Comment)) {
			return false;
		}

		Legal_Comment legal_Comment = (Legal_Comment)obj;

		int primaryKey = legal_Comment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		Legal_CommentModelImpl legal_CommentModelImpl = this;

		legal_CommentModelImpl._originalDistributionID = legal_CommentModelImpl._DistributionID;

		legal_CommentModelImpl._setOriginalDistributionID = false;

		legal_CommentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Legal_Comment> toCacheModel() {
		Legal_CommentCacheModel legal_CommentCacheModel = new Legal_CommentCacheModel();

		legal_CommentCacheModel.ID = getID();

		legal_CommentCacheModel.DistributionID = getDistributionID();

		legal_CommentCacheModel.Fullname = getFullname();

		String Fullname = legal_CommentCacheModel.Fullname;

		if ((Fullname != null) && (Fullname.length() == 0)) {
			legal_CommentCacheModel.Fullname = null;
		}

		legal_CommentCacheModel.Address = getAddress();

		String Address = legal_CommentCacheModel.Address;

		if ((Address != null) && (Address.length() == 0)) {
			legal_CommentCacheModel.Address = null;
		}

		legal_CommentCacheModel.Email = getEmail();

		String Email = legal_CommentCacheModel.Email;

		if ((Email != null) && (Email.length() == 0)) {
			legal_CommentCacheModel.Email = null;
		}

		legal_CommentCacheModel.Body = getBody();

		String Body = legal_CommentCacheModel.Body;

		if ((Body != null) && (Body.length() == 0)) {
			legal_CommentCacheModel.Body = null;
		}

		legal_CommentCacheModel.Visible = getVisible();

		Date CreationDate = getCreationDate();

		if (CreationDate != null) {
			legal_CommentCacheModel.CreationDate = CreationDate.getTime();
		}
		else {
			legal_CommentCacheModel.CreationDate = Long.MIN_VALUE;
		}

		Date ModifiedDate = getModifiedDate();

		if (ModifiedDate != null) {
			legal_CommentCacheModel.ModifiedDate = ModifiedDate.getTime();
		}
		else {
			legal_CommentCacheModel.ModifiedDate = Long.MIN_VALUE;
		}

		legal_CommentCacheModel.IPAddress = getIPAddress();

		String IPAddress = legal_CommentCacheModel.IPAddress;

		if ((IPAddress != null) && (IPAddress.length() == 0)) {
			legal_CommentCacheModel.IPAddress = null;
		}

		return legal_CommentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", DistributionID=");
		sb.append(getDistributionID());
		sb.append(", Fullname=");
		sb.append(getFullname());
		sb.append(", Address=");
		sb.append(getAddress());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", Body=");
		sb.append(getBody());
		sb.append(", Visible=");
		sb.append(getVisible());
		sb.append(", CreationDate=");
		sb.append(getCreationDate());
		sb.append(", ModifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", IPAddress=");
		sb.append(getIPAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Comment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DistributionID</column-name><column-value><![CDATA[");
		sb.append(getDistributionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Fullname</column-name><column-value><![CDATA[");
		sb.append(getFullname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CreationDate</column-name><column-value><![CDATA[");
		sb.append(getCreationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ModifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IPAddress</column-name><column-value><![CDATA[");
		sb.append(getIPAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Legal_Comment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Legal_Comment.class
		};
	private int _ID;
	private int _DistributionID;
	private int _originalDistributionID;
	private boolean _setOriginalDistributionID;
	private String _Fullname;
	private String _Address;
	private String _Email;
	private String _Body;
	private boolean _Visible;
	private Date _CreationDate;
	private Date _ModifiedDate;
	private String _IPAddress;
	private long _columnBitmask;
	private Legal_Comment _escapedModel;
}