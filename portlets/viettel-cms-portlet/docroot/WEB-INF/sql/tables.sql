create table Comment (
	ID INTEGER not null primary key,
	DistributionID INTEGER,
	Fullname VARCHAR(255) null,
	Address VARCHAR(255) null,
	Email VARCHAR(255) null,
	Body STRING null,
	Visible BOOLEAN,
	CreationDate DATE null,
	ModifiedDate DATE null,
	IPAddress VARCHAR(75) null
);

create table Content (
	ID INTEGER not null primary key,
	ContentID INTEGER,
	Version INTEGER,
	CreationDate DATE null,
	ModifiedDate DATE null,
	Byline VARCHAR(500) null,
	Headline VARCHAR(500) null,
	Tagline STRING null,
	Teaser STRING null,
	Body TEXT null,
	Avatar VARCHAR(255) null,
	ImageUrl VARCHAR(255) null,
	ImageDescription VARCHAR(255) null,
	ImageAlign INTEGER,
	ZoneID INTEGER,
	Source VARCHAR(255) null,
	Status INTEGER,
	Author VARCHAR(75) null,
	Editor VARCHAR(75) null,
	Approver VARCHAR(75) null,
	Deployer VARCHAR(75) null,
	Authors VARCHAR(255) null
);

create table ContentProfit (
	ContentID INTEGER not null primary key,
	ContentTypeID INTEGER,
	Headline STRING null,
	Cost DOUBLE,
	Author VARCHAR(75) null,
	Status INTEGER,
	CreationDate DATE null,
	ModifiedDate DATE null,
	DistributedDate DATE null
);

create table Distribution (
	ID INTEGER not null primary key,
	ContentID INTEGER,
	Version INTEGER,
	ZoneID INTEGER,
	DistributedDate DATE null,
	Ranking INTEGER,
	AllowDiscussion BOOLEAN,
	ViewedCount INTEGER,
	MailedCount INTEGER,
	RatedCount INTEGER
);

create table Zone (
	ID INTEGER not null primary key,
	CreationDate DATE null,
	ModifiedDate DATE null,
	Name VARCHAR(255) null,
	Url VARCHAR(75) null,
	Description VARCHAR(255) null,
	ParentID INTEGER,
	RealUrl VARCHAR(255) null,
	Visible BOOLEAN,
	Archived BOOLEAN,
	SortOrder INTEGER
);

create table vcms_Category (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryName VARCHAR(255) null,
	categoryDesc VARCHAR(255) null,
	sortOrder INTEGER,
	archived BOOLEAN,
	layoutId LONG
);

create table vcms_Comment (
	commentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	distributionId LONG,
	fullName VARCHAR(255) null,
	address VARCHAR(255) null,
	email VARCHAR(255) null,
	body STRING null,
	visible BOOLEAN,
	ipAddress VARCHAR(75) null
);

create table vcms_Content (
	autoId LONG not null primary key,
	contentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	preVersion INTEGER,
	version INTEGER,
	subversion DOUBLE,
	subTitle STRING null,
	title STRING null,
	summary STRING null,
	subContent STRING null,
	content TEXT null,
	smallImageId LONG,
	smallImageUrl VARCHAR(500) null,
	categoryId LONG,
	copyRight VARCHAR(255) null,
	status INTEGER,
	urlTitle VARCHAR(500) null,
	newsType INTEGER,
	imageUrl VARCHAR(500) null,
	isLegalContent BOOLEAN,
	imageCaption VARCHAR(1000) null,
	imagePosition INTEGER,
	createdByUserId LONG,
	editedByUserId LONG,
	reviewedByUserId LONG,
	publishedByUserId LONG,
	createdByUserName VARCHAR(75) null,
	editedByUserName VARCHAR(75) null,
	reviewedByUserName VARCHAR(75) null,
	publishedByUserName VARCHAR(75) null,
	author VARCHAR(255) null,
	jobTitle VARCHAR(255) null
);

create table vcms_Content_Detail (
	autoId LONG not null primary key,
	contentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	version INTEGER,
	subversion DOUBLE,
	subTitle STRING null,
	title STRING null,
	summary STRING null,
	subContent STRING null,
	content TEXT null,
	smallImageId LONG,
	smallImageUrl VARCHAR(500) null,
	categoryId LONG,
	status INTEGER,
	newsType INTEGER,
	imageUrl VARCHAR(500) null,
	isLegalContent BOOLEAN,
	imageCaption VARCHAR(1000) null,
	imagePosition INTEGER
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
	contentTypeID LONG,
	headline STRING null,
	cost DOUBLE,
	status INTEGER
);

create table vcms_Content_Type (
	contenTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	name VARCHAR(255) null,
	description VARCHAR(255) null,
	sortOrder INTEGER,
	cost DOUBLE
);

create table vcms_Content_TypeCost (
	costId LONG not null primary key,
	groupId LONG,
	contentTypeID LONG,
	fromDate DATE null,
	toDate DATE null,
	cost DOUBLE
);

create table vcms_Distribution (
	distributionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	version INTEGER,
	subversion DOUBLE,
	contentId LONG,
	categoryId LONG,
	distributedDate DATE null,
	allowDiscussion BOOLEAN,
	title VARCHAR(255) null
);

create table vcms_Distribution_Visisted (
	visistedId LONG not null primary key,
	distributionId LONG,
	groupId LONG,
	createDate DATE null
);

create table vcms_Notes (
	ContentID LONG not null,
	Version INTEGER not null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	Content STRING null,
	primary key (ContentID, Version)
);