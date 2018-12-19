create table CounterReport (
	reportId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null
);

create table vcms_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(75) null,
	categoryDesc VARCHAR(75) null,
	sortOrder INTEGER,
	archived BOOLEAN,
	layoutId LONG
);