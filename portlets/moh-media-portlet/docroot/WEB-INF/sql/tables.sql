create table VideoCategory (
	ID INTEGER not null primary key,
	Name VARCHAR(75) null,
	Url VARCHAR(75) null,
	SortOrder INTEGER,
	ItemCount INTEGER
);

create table VideoClip (
	ID INTEGER not null primary key,
	Name VARCHAR(75) null,
	CategoryID INTEGER,
	Description VARCHAR(75) null,
	ImageUrl VARCHAR(75) null,
	VideoUrl VARCHAR(75) null,
	Duration INTEGER,
	ViewCount INTEGER,
	Status INTEGER,
	CreationDate DATE null,
	ModifiedDate DATE null
);

create table portal_relatevideo (
	id_ LONG not null primary key,
	videoId LONG,
	relateId LONG,
	groupId LONG
);

create table portal_video (
	videoId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	videoName VARCHAR(500) null,
	description VARCHAR(2000) null,
	videoType VARCHAR(250) null,
	videoUrl VARCHAR(2000) null,
	viewCount INTEGER,
	fileId LONG,
	image BOOLEAN,
	imageId LONG,
	smallImageUrl VARCHAR(75) null,
	relateId LONG,
	invisible BOOLEAN,
	categoryId LONG
);

create table portal_videocategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(250) null,
	invisible BOOLEAN
);

create table portal_videocategorymap (
	id_ LONG not null primary key,
	categoryId LONG,
	videoId LONG,
	groupId LONG
);

create table portal_videotag (
	id_ LONG not null primary key,
	videoId LONG,
	tagId LONG,
	groupId LONG
);