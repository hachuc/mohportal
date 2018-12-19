create index IX_10EADDBF on portal_baivietnhuanbut (baiVietId);
create index IX_44DD0672 on portal_baivietnhuanbut (groupId);
create index IX_170A9F23 on portal_baivietnhuanbut (groupId, type_);

create index IX_AD65A552 on portal_phongban (groupId);
create index IX_82F2F91 on portal_phongban (groupId, name);
create index IX_9A1A7238 on portal_phongban (groupId, status);
create index IX_2DC1593E on portal_phongban (status);

create index IX_1FB53B99 on portal_phongbannhuanbut (groupId);
create index IX_4741A81D on portal_phongbannhuanbut (groupId, caption);
create index IX_856ED17F on portal_phongbannhuanbut (groupId, status);
create index IX_B5925E17 on portal_phongbannhuanbut (status);

create index IX_FA14228A on portal_phongbannhuanbutchitiet (phongBanNhuanButId);
create index IX_89E63578 on portal_phongbannhuanbutchitiet (phongBanNhuanButId, phongBanId);

create index IX_F46F2C2E on vcms_Content_Profit (groupId);

create index IX_E56BC0F8 on vcms_Content_Type (groupId);

create index IX_CCDD0CEB on vcms_Content_TypeCost (groupId);