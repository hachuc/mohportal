create index IX_40F513D1 on tthc_Category (categoryName, groupId, categoryType);
create index IX_8C1C8F2 on tthc_Category (categoryType, isActive, groupId);
create index IX_96BFB4EB on tthc_Category (groupId, categoryName, categoryType);

create index IX_844E54CC on tthc_LegalDocument (groupId, ldLevel, isActive);