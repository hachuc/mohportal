create table LegalFAQCategory (
	categoryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	parentId LONG,
	categoryName VARCHAR(300) null,
	categoryDesc VARCHAR(1000) null,
	categoryType INTEGER,
	createDate DATE null,
	modifiedDate DATE null
);

create table LegalFAQEntry (
	entryId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	categoryId LONG,
	citizenName VARCHAR(75) null,
	citizenPhone VARCHAR(75) null,
	citizenEmail VARCHAR(75) null,
	askDate DATE null,
	askTitle VARCHAR(300) null,
	askContent STRING null,
	answerDate DATE null,
	answerContent STRING null,
	createDate DATE null,
	modifiedDate DATE null,
	publishDate DATE null,
	viewCount INTEGER,
	publishStatus INTEGER,
	status INTEGER
);

create table vcms_feedback (
	feedbackId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(1000) null,
	summary VARCHAR(2000) null,
	body STRING null,
	fullName VARCHAR(255) null,
	workFor VARCHAR(500) null,
	address VARCHAR(255) null,
	phone VARCHAR(75) null,
	email VARCHAR(255) null,
	fileId LONG,
	fileSize VARCHAR(75) null,
	fileName VARCHAR(255) null,
	fileURL VARCHAR(2000) null,
	ipAddress VARCHAR(75) null
);