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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.viettel.portal.vcms.model.Legal_Content;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Legal_Content in entity cache.
 *
 * @author chuchv
 * @see Legal_Content
 * @generated
 */
public class Legal_ContentCacheModel implements CacheModel<Legal_Content>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", ContentID=");
		sb.append(ContentID);
		sb.append(", Version=");
		sb.append(Version);
		sb.append(", CreationDate=");
		sb.append(CreationDate);
		sb.append(", ModifiedDate=");
		sb.append(ModifiedDate);
		sb.append(", Byline=");
		sb.append(Byline);
		sb.append(", Headline=");
		sb.append(Headline);
		sb.append(", Tagline=");
		sb.append(Tagline);
		sb.append(", Teaser=");
		sb.append(Teaser);
		sb.append(", Body=");
		sb.append(Body);
		sb.append(", Avatar=");
		sb.append(Avatar);
		sb.append(", ImageUrl=");
		sb.append(ImageUrl);
		sb.append(", ImageDescription=");
		sb.append(ImageDescription);
		sb.append(", ImageAlign=");
		sb.append(ImageAlign);
		sb.append(", ZoneID=");
		sb.append(ZoneID);
		sb.append(", Source=");
		sb.append(Source);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", Author=");
		sb.append(Author);
		sb.append(", Editor=");
		sb.append(Editor);
		sb.append(", Approver=");
		sb.append(Approver);
		sb.append(", Deployer=");
		sb.append(Deployer);
		sb.append(", Authors=");
		sb.append(Authors);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Legal_Content toEntityModel() {
		Legal_ContentImpl legal_ContentImpl = new Legal_ContentImpl();

		legal_ContentImpl.setID(ID);
		legal_ContentImpl.setContentID(ContentID);
		legal_ContentImpl.setVersion(Version);

		if (CreationDate == Long.MIN_VALUE) {
			legal_ContentImpl.setCreationDate(null);
		}
		else {
			legal_ContentImpl.setCreationDate(new Date(CreationDate));
		}

		if (ModifiedDate == Long.MIN_VALUE) {
			legal_ContentImpl.setModifiedDate(null);
		}
		else {
			legal_ContentImpl.setModifiedDate(new Date(ModifiedDate));
		}

		if (Byline == null) {
			legal_ContentImpl.setByline(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setByline(Byline);
		}

		if (Headline == null) {
			legal_ContentImpl.setHeadline(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setHeadline(Headline);
		}

		if (Tagline == null) {
			legal_ContentImpl.setTagline(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setTagline(Tagline);
		}

		if (Teaser == null) {
			legal_ContentImpl.setTeaser(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setTeaser(Teaser);
		}

		if (Body == null) {
			legal_ContentImpl.setBody(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setBody(Body);
		}

		if (Avatar == null) {
			legal_ContentImpl.setAvatar(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setAvatar(Avatar);
		}

		if (ImageUrl == null) {
			legal_ContentImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setImageUrl(ImageUrl);
		}

		if (ImageDescription == null) {
			legal_ContentImpl.setImageDescription(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setImageDescription(ImageDescription);
		}

		legal_ContentImpl.setImageAlign(ImageAlign);
		legal_ContentImpl.setZoneID(ZoneID);

		if (Source == null) {
			legal_ContentImpl.setSource(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setSource(Source);
		}

		legal_ContentImpl.setStatus(Status);

		if (Author == null) {
			legal_ContentImpl.setAuthor(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setAuthor(Author);
		}

		if (Editor == null) {
			legal_ContentImpl.setEditor(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setEditor(Editor);
		}

		if (Approver == null) {
			legal_ContentImpl.setApprover(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setApprover(Approver);
		}

		if (Deployer == null) {
			legal_ContentImpl.setDeployer(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setDeployer(Deployer);
		}

		if (Authors == null) {
			legal_ContentImpl.setAuthors(StringPool.BLANK);
		}
		else {
			legal_ContentImpl.setAuthors(Authors);
		}

		legal_ContentImpl.resetOriginalValues();

		return legal_ContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readInt();
		ContentID = objectInput.readInt();
		Version = objectInput.readInt();
		CreationDate = objectInput.readLong();
		ModifiedDate = objectInput.readLong();
		Byline = objectInput.readUTF();
		Headline = objectInput.readUTF();
		Tagline = objectInput.readUTF();
		Teaser = objectInput.readUTF();
		Body = objectInput.readUTF();
		Avatar = objectInput.readUTF();
		ImageUrl = objectInput.readUTF();
		ImageDescription = objectInput.readUTF();
		ImageAlign = objectInput.readInt();
		ZoneID = objectInput.readInt();
		Source = objectInput.readUTF();
		Status = objectInput.readInt();
		Author = objectInput.readUTF();
		Editor = objectInput.readUTF();
		Approver = objectInput.readUTF();
		Deployer = objectInput.readUTF();
		Authors = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(ID);
		objectOutput.writeInt(ContentID);
		objectOutput.writeInt(Version);
		objectOutput.writeLong(CreationDate);
		objectOutput.writeLong(ModifiedDate);

		if (Byline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Byline);
		}

		if (Headline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Headline);
		}

		if (Tagline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Tagline);
		}

		if (Teaser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Teaser);
		}

		if (Body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Body);
		}

		if (Avatar == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Avatar);
		}

		if (ImageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImageUrl);
		}

		if (ImageDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImageDescription);
		}

		objectOutput.writeInt(ImageAlign);
		objectOutput.writeInt(ZoneID);

		if (Source == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Source);
		}

		objectOutput.writeInt(Status);

		if (Author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Author);
		}

		if (Editor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Editor);
		}

		if (Approver == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Approver);
		}

		if (Deployer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Deployer);
		}

		if (Authors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Authors);
		}
	}

	public int ID;
	public int ContentID;
	public int Version;
	public long CreationDate;
	public long ModifiedDate;
	public String Byline;
	public String Headline;
	public String Tagline;
	public String Teaser;
	public String Body;
	public String Avatar;
	public String ImageUrl;
	public String ImageDescription;
	public int ImageAlign;
	public int ZoneID;
	public String Source;
	public int Status;
	public String Author;
	public String Editor;
	public String Approver;
	public String Deployer;
	public String Authors;
}