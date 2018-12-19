create index IX_B22B00DD on LegalFAQCategory (categoryType, groupId);
create index IX_D9E9A6A7 on LegalFAQCategory (companyId);
create index IX_C1E2700 on LegalFAQCategory (companyId, parentId);
create index IX_3729AAE9 on LegalFAQCategory (groupId);

create index IX_CFFE5A0D on LegalFAQEntry (companyId);
create index IX_8719157A on LegalFAQEntry (companyId, categoryId);
create index IX_648A157D on LegalFAQEntry (companyId, categoryId, publishStatus, status);
create index IX_CCC800A4 on LegalFAQEntry (companyId, publishStatus);
create index IX_8DD5B8A on LegalFAQEntry (companyId, publishStatus, status);
create index IX_10BC3BF3 on LegalFAQEntry (companyId, status);
create index IX_697FFFCF on LegalFAQEntry (groupId);
create index IX_1996283C on LegalFAQEntry (groupId, categoryId);
create index IX_6AA7087B on LegalFAQEntry (groupId, categoryId, publishStatus, status);
create index IX_D5B1DEA2 on LegalFAQEntry (groupId, publishStatus);
create index IX_48805B88 on LegalFAQEntry (groupId, publishStatus, status);
create index IX_D7FA9A12 on LegalFAQEntry (groupId, publishStatus, status, viewCount);

create index IX_CA5D9D3 on vcms_feedback (groupId);