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

package com.viettel.portal.thongke.service.base;

import com.viettel.portal.thongke.service.BaiVietNhuanButLocalServiceUtil;

import java.util.Arrays;

/**
 * @author lamvn
 * @generated
 */
public class BaiVietNhuanButLocalServiceClpInvoker {
	public BaiVietNhuanButLocalServiceClpInvoker() {
		_methodName0 = "addBaiVietNhuanBut";

		_methodParameterTypes0 = new String[] {
				"com.viettel.portal.thongke.model.BaiVietNhuanBut"
			};

		_methodName1 = "createBaiVietNhuanBut";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBaiVietNhuanBut";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBaiVietNhuanBut";

		_methodParameterTypes3 = new String[] {
				"com.viettel.portal.thongke.model.BaiVietNhuanBut"
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

		_methodName10 = "fetchBaiVietNhuanBut";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBaiVietNhuanBut";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBaiVietNhuanButs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBaiVietNhuanButsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBaiVietNhuanBut";

		_methodParameterTypes15 = new String[] {
				"com.viettel.portal.thongke.model.BaiVietNhuanBut"
			};

		_methodName70 = "getBeanIdentifier";

		_methodParameterTypes70 = new String[] {  };

		_methodName71 = "setBeanIdentifier";

		_methodParameterTypes71 = new String[] { "java.lang.String" };

		_methodName76 = "getByBaiVietId";

		_methodParameterTypes76 = new String[] { "long" };

		_methodName77 = "findBaiVietNhuanButs";

		_methodParameterTypes77 = new String[] {
				"int", "java.lang.Long", "java.lang.String", "java.util.Date",
				"java.util.Date", "int", "int"
			};

		_methodName78 = "countBaiVietNhuanButs";

		_methodParameterTypes78 = new String[] {
				"int", "java.lang.Long", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName79 = "findBaiVietRatings";

		_methodParameterTypes79 = new String[] {
				"long", "int", "long", "java.lang.String", "java.util.Date",
				"java.util.Date", "int", "int"
			};

		_methodName80 = "countBaiVietRatings";

		_methodParameterTypes80 = new String[] {
				"long", "int", "long", "java.lang.String", "java.util.Date",
				"java.util.Date"
			};

		_methodName81 = "findBaiVietNhuanButBySQL";

		_methodParameterTypes81 = new String[] { "java.lang.String", "int", "int" };

		_methodName82 = "countBaiVietNhuanButBySQL";

		_methodParameterTypes82 = new String[] { "java.lang.String" };

		_methodName83 = "updateBaiVietNhuanBut";

		_methodParameterTypes83 = new String[] {
				"int", "int", "long", "long", "long", "long", "java.lang.String",
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"double", "com.liferay.portal.service.ServiceContext"
			};

		_methodName84 = "addBaiVietNhuanBut";

		_methodParameterTypes84 = new String[] {
				"int", "int", "long", "long", "long", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.lang.String", "double",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut((com.viettel.portal.thongke.model.BaiVietNhuanBut)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.createBaiVietNhuanBut(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.deleteBaiVietNhuanBut(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.deleteBaiVietNhuanBut((com.viettel.portal.thongke.model.BaiVietNhuanBut)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.fetchBaiVietNhuanBut(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getBaiVietNhuanBut(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getBaiVietNhuanButs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getBaiVietNhuanButsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut((com.viettel.portal.thongke.model.BaiVietNhuanBut)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			BaiVietNhuanButLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.getByBaiVietId(((Long)arguments[0]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButs(((Integer)arguments[0]).intValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.countBaiVietNhuanButs(((Integer)arguments[0]).intValue(),
				(java.lang.Long)arguments[1], (java.lang.String)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.findBaiVietRatings(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.countBaiVietRatings(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5]);
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.findBaiVietNhuanButBySQL((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.countBaiVietNhuanButBySQL((java.lang.String)arguments[0]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.updateBaiVietNhuanBut(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10], (java.util.Date)arguments[11],
				(java.lang.String)arguments[12],
				((Double)arguments[13]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return BaiVietNhuanButLocalServiceUtil.addBaiVietNhuanBut(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9], (java.util.Date)arguments[10],
				(java.lang.String)arguments[11],
				((Double)arguments[12]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[13]);
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
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
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
}