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

package com.viettel.portal.staticasset.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.viettel.portal.staticasset.service.http.FooServiceSoap}.
 *
 * @author chuchv
 * @see com.viettel.portal.staticasset.service.http.FooServiceSoap
 * @generated
 */
public class FooSoap implements Serializable {
	public static FooSoap toSoapModel(Foo model) {
		FooSoap soapModel = new FooSoap();

		soapModel.setId_(model.getId_());

		return soapModel;
	}

	public static FooSoap[] toSoapModels(Foo[] models) {
		FooSoap[] soapModels = new FooSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FooSoap[][] toSoapModels(Foo[][] models) {
		FooSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FooSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FooSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FooSoap[] toSoapModels(List<Foo> models) {
		List<FooSoap> soapModels = new ArrayList<FooSoap>(models.size());

		for (Foo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FooSoap[soapModels.size()]);
	}

	public FooSoap() {
	}

	public long getPrimaryKey() {
		return _id_;
	}

	public void setPrimaryKey(long pk) {
		setId_(pk);
	}

	public long getId_() {
		return _id_;
	}

	public void setId_(long id_) {
		_id_ = id_;
	}

	private long _id_;
}