/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package com.portal_egov.portlet.legal_faq.service.base;

import com.portal_egov.portlet.legal_faq.service.LegalFAQEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author chuchv
 * @generated
 */
public class LegalFAQEntryLocalServiceClpInvoker {
	public LegalFAQEntryLocalServiceClpInvoker() {
		_methodName0 = "addLegalFAQEntry";

		_methodParameterTypes0 = new String[] {
				"com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"
			};

		_methodName1 = "createLegalFAQEntry";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLegalFAQEntry";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLegalFAQEntry";

		_methodParameterTypes3 = new String[] {
				"com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLegalFAQEntry";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLegalFAQEntry";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLegalFAQEntries";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLegalFAQEntriesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLegalFAQEntry";

		_methodParameterTypes15 = new String[] {
				"com.portal_egov.portlet.legal_faq.model.LegalFAQEntry"
			};

		_methodName52 = "getBeanIdentifier";

		_methodParameterTypes52 = new String[] {  };

		_methodName53 = "setBeanIdentifier";

		_methodParameterTypes53 = new String[] { "java.lang.String" };

		_methodName58 = "countAll";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "countByCompany";

		_methodParameterTypes59 = new String[] { "long" };

		_methodName60 = "countByGroup";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "countByCategory";

		_methodParameterTypes61 = new String[] { "long", "long" };

		_methodName62 = "countByCategory";

		_methodParameterTypes62 = new String[] { "long", "long", "int", "int" };

		_methodName63 = "countByStatus";

		_methodParameterTypes63 = new String[] { "long", "int" };

		_methodName64 = "countByPublishStatus";

		_methodParameterTypes64 = new String[] { "long", "int" };

		_methodName65 = "findByCompany";

		_methodParameterTypes65 = new String[] { "long" };

		_methodName66 = "findByCompany";

		_methodParameterTypes66 = new String[] { "long", "int", "int" };

		_methodName67 = "findByGroup";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "findByGroup";

		_methodParameterTypes68 = new String[] { "long", "int", "int" };

		_methodName69 = "findByCategory";

		_methodParameterTypes69 = new String[] { "long", "long" };

		_methodName70 = "findByCategory";

		_methodParameterTypes70 = new String[] { "long", "long", "int", "int" };

		_methodName71 = "findByStatus";

		_methodParameterTypes71 = new String[] { "long", "int" };

		_methodName72 = "findByStatus";

		_methodParameterTypes72 = new String[] { "long", "int", "int", "int" };

		_methodName73 = "findByPublishStatus";

		_methodParameterTypes73 = new String[] { "long", "int" };

		_methodName74 = "findByPublishStatus";

		_methodParameterTypes74 = new String[] { "long", "int", "int", "int" };

		_methodName75 = "findByKeyword";

		_methodParameterTypes75 = new String[] {
				"long", "long", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName76 = "findByKeywordAndStatus";

		_methodParameterTypes76 = new String[] {
				"long", "long", "java.lang.String", "int", "int"
			};

		_methodName77 = "findByViewCount";

		_methodParameterTypes77 = new String[] { "long", "long", "int", "int" };

		_methodName78 = "findByGroupStatusEntryId";

		_methodParameterTypes78 = new String[] { "long", "int" };

		_methodName79 = "findByCompanyAndStatus";

		_methodParameterTypes79 = new String[] { "long", "int", "int" };

		_methodName80 = "findByCompanyAndStatus";

		_methodParameterTypes80 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName81 = "findByGroupAndStatus";

		_methodParameterTypes81 = new String[] { "long", "int", "int" };

		_methodName82 = "findByGroupAndStatus";

		_methodParameterTypes82 = new String[] {
				"long", "int", "int", "int", "int"
			};

		_methodName83 = "findByCategoryAndStatus";

		_methodParameterTypes83 = new String[] { "long", "long", "int", "int" };

		_methodName84 = "findByCategoryAndStatus";

		_methodParameterTypes84 = new String[] {
				"long", "long", "int", "int", "int", "int"
			};

		_methodName85 = "getEntry";

		_methodParameterTypes85 = new String[] { "long" };

		_methodName86 = "addFAQEntry";

		_methodParameterTypes86 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "int", "int", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName87 = "updateFAQEntry";

		_methodParameterTypes87 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "int", "int"
			};

		_methodName88 = "updateAnswerContent";

		_methodParameterTypes88 = new String[] {
				"long", "java.util.Date", "java.lang.String", "boolean"
			};

		_methodName89 = "publishFAQEntry";

		_methodParameterTypes89 = new String[] { "long" };

		_methodName90 = "unPublishFAQEntry";

		_methodParameterTypes90 = new String[] { "long" };

		_methodName91 = "deleteFAQEntry";

		_methodParameterTypes91 = new String[] { "long" };

		_methodName92 = "incrementViewCounter";

		_methodParameterTypes92 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.addLegalFAQEntry((com.portal_egov.portlet.legal_faq.model.LegalFAQEntry)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.createLegalFAQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.deleteLegalFAQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.deleteLegalFAQEntry((com.portal_egov.portlet.legal_faq.model.LegalFAQEntry)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.fetchLegalFAQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getLegalFAQEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getLegalFAQEntries(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getLegalFAQEntriesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.updateLegalFAQEntry((com.portal_egov.portlet.legal_faq.model.LegalFAQEntry)arguments[0]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			LegalFAQEntryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countAll();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.countByPublishStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCompany(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByPublishStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByPublishStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByKeyword(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByKeywordAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByViewCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByGroupStatusEntryId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCompanyAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByGroupAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByGroupAndStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCategoryAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.findByCategoryAndStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.getEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.addFAQEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.util.Date)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.util.Date)arguments[10], (java.lang.String)arguments[11],
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.updateFAQEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.util.Date)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			LegalFAQEntryLocalServiceUtil.updateAnswerContent(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1], (java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue());

			return null;
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			LegalFAQEntryLocalServiceUtil.publishFAQEntry(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			LegalFAQEntryLocalServiceUtil.unPublishFAQEntry(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			LegalFAQEntryLocalServiceUtil.deleteFAQEntry(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return LegalFAQEntryLocalServiceUtil.incrementViewCounter(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
}