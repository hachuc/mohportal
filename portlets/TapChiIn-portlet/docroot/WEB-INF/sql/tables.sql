create table Magazine (
	ID INTEGER not null primary key,
	Name VARCHAR(255) null,
	PublishNumber INTEGER,
	PublishYear INTEGER,
	ImageUrl VARCHAR(255) null,
	ImageID LONG,
	CreationDate DATE null,
	ModifiedDate DATE null,
	DistributedDate DATE null
);

create table MagazineContent (
	ID INTEGER not null primary key,
	Headline VARCHAR(75) null,
	Teaser VARCHAR(75) null,
	Body TEXT null,
	MagazineZoneID INTEGER,
	MagazineID INTEGER,
	Author VARCHAR(255) null,
	Jobtitle VARCHAR(75) null,
	ViewedCount INTEGER,
	SortOrder INTEGER,
	MailedCount INTEGER,
	CreationDate DATE null,
	ModifiedDate DATE null
);

create table MagazineZone (
	ID INTEGER not null primary key,
	Name VARCHAR(255) null,
	MagazineID INTEGER,
	SortOrder INTEGER
);