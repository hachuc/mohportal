create index IX_E225DCA on portal_link (categoryId, groupId);
create index IX_8FE74597 on portal_link (groupId);
create index IX_ACCCE4C8 on portal_link (groupId, categoryId, isActive);

create index IX_486FB4DC on portal_linkcategory (categoryName, groupId);
create index IX_A897AD9 on portal_linkcategory (groupId);
create index IX_374E175D on portal_linkcategory (groupId, isActive);