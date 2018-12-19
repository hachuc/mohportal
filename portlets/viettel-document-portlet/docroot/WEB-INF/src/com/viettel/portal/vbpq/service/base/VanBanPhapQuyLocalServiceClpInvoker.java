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

package com.viettel.portal.vbpq.service.base;

import com.viettel.portal.vbpq.service.VanBanPhapQuyLocalServiceUtil;

import java.util.Arrays;

/**
 * @author ChucHV
 * @generated
 */
public class VanBanPhapQuyLocalServiceClpInvoker {
	public VanBanPhapQuyLocalServiceClpInvoker() {
		_methodName0 = "addVanBanPhapQuy";

		_methodParameterTypes0 = new String[] {
				"com.viettel.portal.vbpq.model.VanBanPhapQuy"
			};

		_methodName1 = "createVanBanPhapQuy";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVanBanPhapQuy";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVanBanPhapQuy";

		_methodParameterTypes3 = new String[] {
				"com.viettel.portal.vbpq.model.VanBanPhapQuy"
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

		_methodName10 = "fetchVanBanPhapQuy";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVanBanPhapQuy";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVanBanPhapQuies";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVanBanPhapQuiesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVanBanPhapQuy";

		_methodParameterTypes15 = new String[] {
				"com.viettel.portal.vbpq.model.VanBanPhapQuy"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "getByGroupId_MaVanBan";

		_methodParameterTypes66 = new String[] { "long", "java.lang.String" };

		_methodName67 = "countAll";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "getAll";

		_methodParameterTypes68 = new String[] { "long", "int", "int" };

		_methodName69 = "getVanBan";

		_methodParameterTypes69 = new String[] { "long" };

		_methodName70 = "deleteVanBan";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "findByG_CQBH_S";

		_methodParameterTypes71 = new String[] { "long", "long", "int" };

		_methodName72 = "findByG_CQBH_S";

		_methodParameterTypes72 = new String[] {
				"long", "long", "int", "int", "int"
			};

		_methodName73 = "deleteVanBan";

		_methodParameterTypes73 = new String[] {
				"com.viettel.portal.vbpq.model.VanBanPhapQuy"
			};

		_methodName74 = "updateVanBanPhapQuy";

		_methodParameterTypes74 = new String[] {
				"long", "long", "long", "java.lang.String", "boolean", "long",
				"long", "long", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "java.lang.String", "long",
				"int", "long"
			};

		_methodName75 = "updateStatusVanBan";

		_methodParameterTypes75 = new String[] { "long", "int", "long" };

		_methodName76 = "count";

		_methodParameterTypes76 = new String[] {
				"java.lang.String", "long", "long[][]", "long[][]", "long[][]",
				"long[][]", "java.lang.Integer", "java.util.Date",
				"java.util.Date"
			};

		_methodName77 = "find";

		_methodParameterTypes77 = new String[] {
				"java.lang.String", "long", "long[][]", "long[][]", "long[][]",
				"long[][]", "java.lang.Integer", "java.util.Date",
				"java.util.Date", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator",
				"java.lang.String[][]"
			};

		_methodName78 = "timKiemVanBanPhapQuy";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "long", "long[][]", "long[][]", "long[][]",
				"long[][]", "java.lang.Integer", "java.util.Date",
				"java.util.Date", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator",
				"java.lang.String[][]"
			};

		_methodName79 = "timKiemVanBanPhapQuyTheoNgayTao";

		_methodParameterTypes79 = new String[] {
				"java.lang.String", "long", "long[][]", "long[][]", "long[][]",
				"long[][]", "java.lang.Integer", "java.util.Date",
				"java.util.Date", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator",
				"java.lang.String[][]"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.addVanBanPhapQuy((com.viettel.portal.vbpq.model.VanBanPhapQuy)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.createVanBanPhapQuy(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.deleteVanBanPhapQuy(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.deleteVanBanPhapQuy((com.viettel.portal.vbpq.model.VanBanPhapQuy)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.fetchVanBanPhapQuy(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuy(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuies(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getVanBanPhapQuiesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy((com.viettel.portal.vbpq.model.VanBanPhapQuy)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			VanBanPhapQuyLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getByGroupId_MaVanBan(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.countAll(((Long)arguments[0]).longValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getAll(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.getVanBan(((Long)arguments[0]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			VanBanPhapQuyLocalServiceUtil.deleteVanBan(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.findByG_CQBH_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.findByG_CQBH_S(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			VanBanPhapQuyLocalServiceUtil.deleteVanBan((com.viettel.portal.vbpq.model.VanBanPhapQuy)arguments[0]);

			return null;
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.updateVanBanPhapQuy(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(), (java.util.Date)arguments[8],
				(java.util.Date)arguments[9], (java.util.Date)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Long)arguments[13]).longValue(),
				((Integer)arguments[14]).intValue(),
				((Long)arguments[15]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.updateStatusVanBan(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.count((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (long[])arguments[2],
				(long[])arguments[3], (long[])arguments[4],
				(long[])arguments[5], (java.lang.Integer)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.find((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (long[])arguments[2],
				(long[])arguments[3], (long[])arguments[4],
				(long[])arguments[5], (java.lang.Integer)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[11],
				(java.lang.String[])arguments[12]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.timKiemVanBanPhapQuy((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (long[])arguments[2],
				(long[])arguments[3], (long[])arguments[4],
				(long[])arguments[5], (java.lang.Integer)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[11],
				(java.lang.String[])arguments[12]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return VanBanPhapQuyLocalServiceUtil.timKiemVanBanPhapQuyTheoNgayTao((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (long[])arguments[2],
				(long[])arguments[3], (long[])arguments[4],
				(long[])arguments[5], (java.lang.Integer)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[11],
				(java.lang.String[])arguments[12]);
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
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
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
}