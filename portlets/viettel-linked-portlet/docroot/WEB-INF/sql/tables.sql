create table portal_link (
	linkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	linkName VARCHAR(500) null,
	url VARCHAR(2000) null,
	isActive BOOLEAN,
	corder INTEGER,
	categoryId LONG
);

create table portal_linkcategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(250) null,
	corder INTEGER,
	isActive BOOLEAN
);