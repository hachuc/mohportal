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

package com.viettel.portal.thongke.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author lamvn
 * @generated
 */
public class PhongBanNhuanButChiTietSoap implements Serializable {
	public static PhongBanNhuanButChiTietSoap toSoapModel(
		PhongBanNhuanButChiTiet model) {
		PhongBanNhuanButChiTietSoap soapModel = new PhongBanNhuanButChiTietSoap();

		soapModel.setId(model.getId());
		soapModel.setPhongBanNhuanButId(model.getPhongBanNhuanButId());
		soapModel.setPhongBanId(model.getPhongBanId());
		soapModel.setPhongBanTen(model.getPhongBanTen());
		soapModel.setRating(model.getRating());
		soapModel.setRatingValue(model.getRatingValue());

		return soapModel;
	}

	public static PhongBanNhuanButChiTietSoap[] toSoapModels(
		PhongBanNhuanButChiTiet[] models) {
		PhongBanNhuanButChiTietSoap[] soapModels = new PhongBanNhuanButChiTietSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhongBanNhuanButChiTietSoap[][] toSoapModels(
		PhongBanNhuanButChiTiet[][] models) {
		PhongBanNhuanButChiTietSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhongBanNhuanButChiTietSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhongBanNhuanButChiTietSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhongBanNhuanButChiTietSoap[] toSoapModels(
		List<PhongBanNhuanButChiTiet> models) {
		List<PhongBanNhuanButChiTietSoap> soapModels = new ArrayList<PhongBanNhuanButChiTietSoap>(models.size());

		for (PhongBanNhuanButChiTiet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhongBanNhuanButChiTietSoap[soapModels.size()]);
	}

	public PhongBanNhuanButChiTietSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getPhongBanNhuanButId() {
		return _phongBanNhuanButId;
	}

	public void setPhongBanNhuanButId(long phongBanNhuanButId) {
		_phongBanNhuanButId = phongBanNhuanButId;
	}

	public long getPhongBanId() {
		return _phongBanId;
	}

	public void setPhongBanId(long phongBanId) {
		_phongBanId = phongBanId;
	}

	public String getPhongBanTen() {
		return _phongBanTen;
	}

	public void setPhongBanTen(String phongBanTen) {
		_phongBanTen = phongBanTen;
	}

	public String getRating() {
		return _rating;
	}

	public void setRating(String rating) {
		_rating = rating;
	}

	public double getRatingValue() {
		return _ratingValue;
	}

	public void setRatingValue(double ratingValue) {
		_ratingValue = ratingValue;
	}

	private long _id;
	private long _phongBanNhuanButId;
	private long _phongBanId;
	private String _phongBanTen;
	private String _rating;
	private double _ratingValue;
}