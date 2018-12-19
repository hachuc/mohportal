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

package com.viettel.portal.magazine.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the MagazineZone service. Represents a row in the &quot;MagazineZone&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.viettel.portal.magazine.model.impl.MagazineZoneImpl}.
 * </p>
 *
 * @author namtv
 * @see MagazineZone
 * @see com.viettel.portal.magazine.model.impl.MagazineZoneImpl
 * @see com.viettel.portal.magazine.model.impl.MagazineZoneModelImpl
 * @generated
 */
public interface MagazineZoneModel extends BaseModel<MagazineZone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a magazine zone model instance should use the {@link MagazineZone} interface instead.
	 */

	/**
	 * Returns the primary key of this magazine zone.
	 *
	 * @return the primary key of this magazine zone
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this magazine zone.
	 *
	 * @param primaryKey the primary key of this magazine zone
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the i d of this magazine zone.
	 *
	 * @return the i d of this magazine zone
	 */
	public int getID();

	/**
	 * Sets the i d of this magazine zone.
	 *
	 * @param ID the i d of this magazine zone
	 */
	public void setID(int ID);

	/**
	 * Returns the name of this magazine zone.
	 *
	 * @return the name of this magazine zone
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this magazine zone.
	 *
	 * @param Name the name of this magazine zone
	 */
	public void setName(String Name);

	/**
	 * Returns the magazine i d of this magazine zone.
	 *
	 * @return the magazine i d of this magazine zone
	 */
	public int getMagazineID();

	/**
	 * Sets the magazine i d of this magazine zone.
	 *
	 * @param MagazineID the magazine i d of this magazine zone
	 */
	public void setMagazineID(int MagazineID);

	/**
	 * Returns the sort order of this magazine zone.
	 *
	 * @return the sort order of this magazine zone
	 */
	public int getSortOrder();

	/**
	 * Sets the sort order of this magazine zone.
	 *
	 * @param SortOrder the sort order of this magazine zone
	 */
	public void setSortOrder(int SortOrder);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.viettel.portal.magazine.model.MagazineZone magazineZone);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.viettel.portal.magazine.model.MagazineZone> toCacheModel();

	@Override
	public com.viettel.portal.magazine.model.MagazineZone toEscapedModel();

	@Override
	public com.viettel.portal.magazine.model.MagazineZone toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}