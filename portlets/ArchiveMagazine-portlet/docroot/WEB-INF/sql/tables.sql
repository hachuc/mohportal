create table ArchiveContent (
	ID INTEGER not null primary key,
	Subject VARCHAR(75) null,
	NormalZoneID INTEGER,
	SpecialZoneID INTEGER,
	FileUrl VARCHAR(75) null,
	Author VARCHAR(75) null,
	AuthorTitle VARCHAR(75) null,
	MagazineID INTEGER,
	SortOrder INTEGER,
	CreationDate DATE null
);

create table ArchiveMagazine (
	ID INTEGER not null primary key,
	Name VARCHAR(75) null,
	PublishNumber INTEGER,
	PublishMonth INTEGER,
	PublishYear INTEGER,
	ImageUrl VARCHAR(75) null,
	MagazineType INTEGER
);

create table Content (
	ID INTEGER not null primary key,
	Subject VARCHAR(75) null,
	NormalZoneID INTEGER,
	SpecialZoneID INTEGER,
	FileUrl VARCHAR(75) null,
	Author VARCHAR(75) null,
	AuthorTitle VARCHAR(75) null,
	MagazineID INTEGER,
	SortOrder INTEGER,
	CreationDate DATE null
);

create table Magazine (
	ID INTEGER not null primary key,
	Name VARCHAR(75) null,
	PublishNumber INTEGER,
	PublishMonth INTEGER,
	PublishYear INTEGER,
	ImageUrl VARCHAR(75) null,
	MagazineType INTEGER
);