create index IX_F0DAFFAE on Magazine (PublishNumber, PublishYear);
create index IX_A122BEC2 on Magazine (PublishYear);

create index IX_A76C6AE on MagazineContent (MagazineID);
create index IX_EDB807FD on MagazineContent (MagazineID, MagazineZoneID);
create index IX_10081FFA on MagazineContent (MagazineZoneID);

create index IX_35678EC9 on MagazineZone (MagazineID);