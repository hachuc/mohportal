create index IX_AB5D37BE on portal_photo (categoryId, groupId, status);
create index IX_612F24F8 on portal_photo (categoryId, status);
create index IX_6B9CA78B on portal_photo (groupId, status);
create index IX_6B354A8B on portal_photo (status);

create index IX_4EB824E7 on portal_photocategory (groupId);
create index IX_E566EB66 on portal_photocategory (groupId, name);
create index IX_8528CCD on portal_photocategory (groupId, status);
create index IX_75061309 on portal_photocategory (status);