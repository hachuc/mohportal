create index IX_3759ECB8 on Comment (DistributionID);

create index IX_C57671E5 on Content (Status);
create index IX_A966727A on Content (ZoneID);

create index IX_95B72705 on Distribution (ZoneID);

create index IX_BA4A96B0 on Zone (Visible);

create index IX_F8675A9A on vcms_Category (groupId);

create index IX_B97B7924 on vcms_Comment (groupId, distributionId);

create index IX_CA7308C4 on vcms_Content (groupId, categoryId);
create index IX_5B54DD on vcms_Content (groupId, categoryId, createdByUserId, version, status);
create index IX_C751E1DD on vcms_Content (groupId, categoryId, title, createdByUserId, version, status);
create index IX_654B44AA on vcms_Content (groupId, categoryId, version, status);
create index IX_4955E56D on vcms_Content (groupId, contentId);
create index IX_C2D15B3B on vcms_Content (groupId, contentId, version);
create index IX_694A2F21 on vcms_Content (groupId, contentId, version, status);
create index IX_68B7F4FE on vcms_Content (groupId, createdByUserId);
create index IX_9D0913B0 on vcms_Content (groupId, createdByUserId, version, status);
create index IX_8F09B11 on vcms_Content (groupId, editedByUserId);
create index IX_E70F82C4 on vcms_Content (groupId, publishedByUserId);
create index IX_3D1A5D1F on vcms_Content (groupId, reviewedByUserId);
create index IX_8F31DA74 on vcms_Content (groupId, urlTitle);
create index IX_CBF8655A on vcms_Content (groupId, urlTitle, status);
create index IX_11721977 on vcms_Content (groupId, version, status);

create index IX_C8B0E56E on vcms_Content_Detail (groupId, categoryId);
create index IX_EFE11140 on vcms_Content_Detail (groupId, categoryId, version, status);
create index IX_FEF4CB83 on vcms_Content_Detail (groupId, contentId);
create index IX_78E4EDE5 on vcms_Content_Detail (groupId, contentId, version);
create index IX_D91D77CB on vcms_Content_Detail (groupId, contentId, version, status);

create index IX_F46F2C2E on vcms_Content_Profit (groupId);

create index IX_E56BC0F8 on vcms_Content_Type (groupId);
create index IX_393F76B7 on vcms_Content_Type (groupId, name);

create index IX_179F3A48 on vcms_Content_TypeCost (fromDate, toDate);
create index IX_CCDD0CEB on vcms_Content_TypeCost (groupId);

create index IX_B06B4841 on vcms_Distribution (groupId, categoryId);
create index IX_71C94250 on vcms_Distribution (groupId, contentId);
create index IX_391060A5 on vcms_Distribution (groupId, contentId, version, categoryId);

create index IX_B1DC215F on vcms_Distribution_Visisted (groupId, distributionId);

create index IX_604B6313 on vcms_Notes (groupId, ContentID, Version);