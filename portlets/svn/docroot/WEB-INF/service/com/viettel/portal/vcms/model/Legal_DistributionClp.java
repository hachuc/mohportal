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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.viettel.portal.vcms.service.ClpSerializer;
import com.viettel.portal.vcms.service.Legal_DistributionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chuchv
 */
public class Legal_DistributionClp extends BaseModelImpl<Legal_Distribution>
	implements Legal_Distribution {
	public Legal_DistributionClp() {
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

	@Override
	public int getID() {
		return _ID;
	}

	@Override
	public void setID(int ID) {
		_ID = ID;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setID", int.class);

				method.invoke(_legal_DistributionRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getContentID() {
		return _ContentID;
	}

	@Override
	public void setContentID(int ContentID) {
		_ContentID = ContentID;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setContentID", int.class);

				method.invoke(_legal_DistributionRemoteModel, ContentID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVersion() {
		return _Version;
	}

	@Override
	public void setVersion(int Version) {
		_Version = Version;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", int.class);

				method.invoke(_legal_DistributionRemoteModel, Version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getZoneID() {
		return _ZoneID;
	}

	@Override
	public void setZoneID(int ZoneID) {
		_ZoneID = ZoneID;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setZoneID", int.class);

				method.invoke(_legal_DistributionRemoteModel, ZoneID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDistributedDate() {
		return _DistributedDate;
	}

	@Override
	public void setDistributedDate(Date DistributedDate) {
		_DistributedDate = DistributedDate;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributedDate", Date.class);

				method.invoke(_legal_DistributionRemoteModel, DistributedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRanking() {
		return _Ranking;
	}

	@Override
	public void setRanking(int Ranking) {
		_Ranking = Ranking;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setRanking", int.class);

				method.invoke(_legal_DistributionRemoteModel, Ranking);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAllowDiscussion() {
		return _AllowDiscussion;
	}

	@Override
	public boolean isAllowDiscussion() {
		return _AllowDiscussion;
	}

	@Override
	public void setAllowDiscussion(boolean AllowDiscussion) {
		_AllowDiscussion = AllowDiscussion;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setAllowDiscussion",
						boolean.class);

				method.invoke(_legal_DistributionRemoteModel, AllowDiscussion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getViewedCount() {
		return _ViewedCount;
	}

	@Override
	public void setViewedCount(int ViewedCount) {
		_ViewedCount = ViewedCount;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setViewedCount", int.class);

				method.invoke(_legal_DistributionRemoteModel, ViewedCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMailedCount() {
		return _MailedCount;
	}

	@Override
	public void setMailedCount(int MailedCount) {
		_MailedCount = MailedCount;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setMailedCount", int.class);

				method.invoke(_legal_DistributionRemoteModel, MailedCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRatedCount() {
		return _RatedCount;
	}

	@Override
	public void setRatedCount(int RatedCount) {
		_RatedCount = RatedCount;

		if (_legal_DistributionRemoteModel != null) {
			try {
				Class<?> clazz = _legal_DistributionRemoteModel.getClass();

				Method method = clazz.getMethod("setRatedCount", int.class);

				method.invoke(_legal_DistributionRemoteModel, RatedCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegal_DistributionRemoteModel() {
		return _legal_DistributionRemoteModel;
	}

	public void setLegal_DistributionRemoteModel(
		BaseModel<?> legal_DistributionRemoteModel) {
		_legal_DistributionRemoteModel = legal_DistributionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _legal_DistributionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_legal_DistributionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Legal_DistributionLocalServiceUtil.addLegal_Distribution(this);
		}
		else {
			Legal_DistributionLocalServiceUtil.updateLegal_Distribution(this);
		}
	}

	@Override
	public Legal_Distribution toEscapedModel() {
		return (Legal_Distribution)ProxyUtil.newProxyInstance(Legal_Distribution.class.getClassLoader(),
			new Class[] { Legal_Distribution.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Legal_DistributionClp clone = new Legal_DistributionClp();

		clone.setID(getID());
		clone.setContentID(getContentID());
		clone.setVersion(getVersion());
		clone.setZoneID(getZoneID());
		clone.setDistributedDate(getDistributedDate());
		clone.setRanking(getRanking());
		clone.setAllowDiscussion(getAllowDiscussion());
		clone.setViewedCount(getViewedCount());
		clone.setMailedCount(getMailedCount());
		clone.setRatedCount(getRatedCount());

		return clone;
	}

	@Override
	public int compareTo(Legal_Distribution legal_Distribution) {
		int value = 0;

		value = DateUtil.compareTo(getDistributedDate(),
				legal_Distribution.getDistributedDate());

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

		if (!(obj instanceof Legal_DistributionClp)) {
			return false;
		}

		Legal_DistributionClp legal_Distribution = (Legal_DistributionClp)obj;

		int primaryKey = legal_Distribution.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", ContentID=");
		sb.append(getContentID());
		sb.append(", Version=");
		sb.append(getVersion());
		sb.append(", ZoneID=");
		sb.append(getZoneID());
		sb.append(", DistributedDate=");
		sb.append(getDistributedDate());
		sb.append(", Ranking=");
		sb.append(getRanking());
		sb.append(", AllowDiscussion=");
		sb.append(getAllowDiscussion());
		sb.append(", ViewedCount=");
		sb.append(getViewedCount());
		sb.append(", MailedCount=");
		sb.append(getMailedCount());
		sb.append(", RatedCount=");
		sb.append(getRatedCount());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.viettel.portal.vcms.model.Legal_Distribution");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ContentID</column-name><column-value><![CDATA[");
		sb.append(getContentID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ZoneID</column-name><column-value><![CDATA[");
		sb.append(getZoneID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DistributedDate</column-name><column-value><![CDATA[");
		sb.append(getDistributedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Ranking</column-name><column-value><![CDATA[");
		sb.append(getRanking());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AllowDiscussion</column-name><column-value><![CDATA[");
		sb.append(getAllowDiscussion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ViewedCount</column-name><column-value><![CDATA[");
		sb.append(getViewedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MailedCount</column-name><column-value><![CDATA[");
		sb.append(getMailedCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RatedCount</column-name><column-value><![CDATA[");
		sb.append(getRatedCount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ID;
	private int _ContentID;
	private int _Version;
	private int _ZoneID;
	private Date _DistributedDate;
	private int _Ranking;
	private boolean _AllowDiscussion;
	private int _ViewedCount;
	private int _MailedCount;
	private int _RatedCount;
	private BaseModel<?> _legal_DistributionRemoteModel;
	private Class<?> _clpSerializerClass = com.viettel.portal.vcms.service.ClpSerializer.class;
}