create table portal_baivietnhuanbut (
	id_ LONG not null primary key,
	baiVietId LONG,
	loaiBaiViet INTEGER,
	tieuDe VARCHAR(1000) null,
	tacGia VARCHAR(1000) null,
	diaChi VARCHAR(1000) null,
	ngayXuatBan DATE null,
	rating VARCHAR(75) null,
	ratingValue DOUBLE,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifyDate DATE null,
	userName VARCHAR(75) null,
	userId LONG,
	type_ INTEGER
);

create table portal_phongban (
	id_ LONG not null primary key,
	name VARCHAR(1000) null,
	order_ INTEGER,
	descriptions STRING null,
	status BOOLEAN,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifyDate DATE null,
	userName VARCHAR(75) null,
	userId LONG
);

create table portal_phongbannhuanbut (
	id_ LONG not null primary key,
	caption VARCHAR(1000) null,
	fromDate DATE null,
	toDate DATE null,
	status BOOLEAN,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifyDate DATE null,
	userName VARCHAR(75) null,
	userId LONG
);

create table portal_phongbannhuanbutchitiet (
	id_ LONG not null primary key,
	phongBanNhuanButId LONG,
	phongBanId LONG,
	phongBanTen VARCHAR(1000) null,
	rating VARCHAR(75) null,
	ratingValue DOUBLE
);

create table vcms_Content_Profit (
	contentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	distributedDate DATE null,
	contentTypeID INTEGER,
	headline VARCHAR(75) null,
	cost DOUBLE,
	status INTEGER
);

create table vcms_Content_Type (
	contenTypeId INTEGER not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	sortOrder INTEGER
);

create table vcms_Content_TypeCost (
	costId INTEGER not null primary key,
	groupId LONG,
	contentTypeID INTEGER,
	fromDate DATE null,
	toDate DATE null,
	cost DOUBLE
);