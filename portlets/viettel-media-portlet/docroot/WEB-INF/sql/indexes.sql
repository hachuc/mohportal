create index IX_870704BE on VideoClip (CategoryID);

create index IX_BB0565CD on portal_relatevideo (relateId, groupId);
create index IX_1A1104F9 on portal_relatevideo (videoId, groupId);

create index IX_F2BD786F on portal_video (categoryId, groupId);
create index IX_13816FBC on portal_video (groupId);

create index IX_98D98541 on portal_videocategory (categoryName, groupId);
create index IX_FC3DAFFE on portal_videocategory (groupId);
create index IX_7231355F on portal_videocategory (groupId, invisible);

create index IX_75D26FE1 on portal_videocategorymap (categoryId, groupId);
create index IX_859C01C0 on portal_videocategorymap (videoId, groupId);

create index IX_AF26297D on portal_videotag (tagId, groupId);
create index IX_2D72A3BC on portal_videotag (videoId, groupId);