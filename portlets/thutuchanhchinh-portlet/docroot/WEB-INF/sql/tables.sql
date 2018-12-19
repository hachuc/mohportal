create table tthc_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(255) null,
	categoryDesc VARCHAR(255) null,
	isActive BOOLEAN,
	categoryType INTEGER,
	catOrder INTEGER
);

create table tthc_LegalDocument (
	ldId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ldCode VARCHAR(255) null,
	ldTitle STRING null,
	ldLink VARCHAR(1000) null,
	ldLevel3Link VARCHAR(1000) null,
	ldSubcontent STRING null,
	isActive BOOLEAN,
	idLinhvuc LONG,
	idCoquanbanhanh LONG,
	ldDonvithuchien VARCHAR(255) null,
	ldLevel INTEGER
);