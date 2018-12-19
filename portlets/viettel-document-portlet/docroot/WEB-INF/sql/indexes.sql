create index IX_EF7E1695 on portal_attachfile (VANBANID);

create index IX_EE3C1C12 on portal_coquanbanhanh (GROUPID);
create index IX_F30CB61B on portal_coquanbanhanh (GROUPID, TEN);
create index IX_876DD0FA on portal_coquanbanhanh (TRANGTHAI, GROUPID);
create index IX_6DF774EB on portal_coquanbanhanh (nhomVanBanId);

create index IX_7257CBBE on portal_linhvucvanban (GROUPID);
create index IX_8D67F1EF on portal_linhvucvanban (GROUPID, TEN);
create index IX_8FD9DDCE on portal_linhvucvanban (TRANGTHAI, GROUPID);
create index IX_852B0BF on portal_linhvucvanban (nhomVanBanId);

create index IX_6E0770BA on portal_loaivanban (GROUPID);
create index IX_FE40A73 on portal_loaivanban (GROUPID, TEN);
create index IX_219A8352 on portal_loaivanban (TRANGTHAI, GROUPID);
create index IX_8ACEC943 on portal_loaivanban (nhomVanBanId);

create index IX_C64E8976 on portal_vanban (GROUPID, COQUANBANHANH, STATUS);
create index IX_1AD21E19 on portal_vanban (GROUPID, MAVANBAN);
create index IX_F017FEAB on portal_vanban (GROUPID, STATUS);
create index IX_9BCD6F2B on portal_vanban (STATUS);