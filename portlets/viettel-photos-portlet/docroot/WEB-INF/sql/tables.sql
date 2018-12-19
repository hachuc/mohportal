create table portal_photo (
	photoId LONG not null primary key,
	caption VARCHAR(75) null,
	fileId LONG,
	fileLink VARCHAR(75) null,
	fileName VARCHAR(75) null,
	fileSize VARCHAR(75) null,
	createDate DATE null,
	modifyDate DATE null,
	ORDER_ INTEGER,
	status BOOLEAN,
	userName VARCHAR(75) null,
	userId LONG,
	companyId LONG,
	categoryId LONG,
	groupId LONG
);

create table portal_photocategory (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	order_ INTEGER,
	status BOOLEAN,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifyDate DATE null,
	userName VARCHAR(75) null,
	userId LONG
);