create table portal_attachfile (
	ID LONG not null primary key,
	VANBANID LONG,
	FILEID LONG,
	FILELINK VARCHAR(255) null,
	FILENAME VARCHAR(255) null,
	FILESIZE VARCHAR(75) null
);

create table portal_coquanbanhanh (
	ID LONG not null primary key,
	TEN VARCHAR(500) null,
	TRANGTHAI BOOLEAN,
	NGAYTAO DATE null,
	NGAYSUA DATE null,
	NGUOITAO VARCHAR(75) null,
	NGUOISUA VARCHAR(75) null,
	GROUPID LONG,
	ORDER_ INTEGER,
	nhomVanBanId LONG
);

create table portal_linhvucvanban (
	ID LONG not null primary key,
	TEN VARCHAR(500) null,
	TRANGTHAI BOOLEAN,
	NGAYTAO DATE null,
	NGAYSUA DATE null,
	NGUOITAO VARCHAR(75) null,
	NGUOISUA VARCHAR(75) null,
	GROUPID LONG,
	ORDER_ INTEGER,
	nhomVanBanId LONG
);

create table portal_loaivanban (
	ID LONG not null primary key,
	TEN VARCHAR(500) null,
	TRANGTHAI BOOLEAN,
	NGAYTAO DATE null,
	NGAYSUA DATE null,
	NGUOITAO VARCHAR(75) null,
	NGUOISUA VARCHAR(75) null,
	GROUPID LONG,
	ORDER_ INTEGER,
	nhomVanBanId LONG
);

create table portal_vanban (
	ID LONG not null primary key,
	MAVANBAN VARCHAR(150) null,
	NGAYTAO DATE null,
	NGAYSUA DATE null,
	NGUOITAO VARCHAR(75) null,
	NGUOISUA VARCHAR(75) null,
	TRICHYEU VARCHAR(2000) null,
	COQUANBANHANH LONG,
	LOAIVANBAN LONG,
	LINHVUCVANBAN LONG,
	NGAYBANHANH DATE null,
	NGAYCOHIEULUC DATE null,
	NGAYHETHIEULUC DATE null,
	NGUOIKY VARCHAR(250) null,
	VANBANTHAYTHE LONG,
	GROUPID LONG,
	STATUS INTEGER,
	STATUSBYDATE DATE null,
	STATUSBYUSERID LONG,
	STATUSBYUSERNAME VARCHAR(75) null,
	nhomVanBanId LONG
);

create table portal_vbpq_nhom_van_ban (
	id LONG not null primary key,
	tenNhom VARCHAR(500) null,
	nguoiTao VARCHAR(75) null,
	nguoiTaoId LONG,
	ngayTao DATE null,
	ngaySua DATE null,
	nguoiSua VARCHAR(75) null,
	nguoiSuaId LONG,
	trangThai INTEGER,
	groupId LONG
);