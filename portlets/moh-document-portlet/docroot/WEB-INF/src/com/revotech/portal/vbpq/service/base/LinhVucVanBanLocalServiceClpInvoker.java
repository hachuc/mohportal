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

package com.revotech.portal.vbpq.service.base;

import com.revotech.portal.vbpq.service.LinhVucVanBanLocalServiceUtil;

import java.util.Arrays;

/**
 * @author ChucHV
 * @generated
 */
public class LinhVucVanBanLocalServiceClpInvoker {
	public LinhVucVanBanLocalServiceClpInvoker() {
		_methodName0 = "addLinhVucVanBan";

		_methodParameterTypes0 = new String[] {
				"com.revotech.portal.vbpq.model.LinhVucVanBan"
			};

		_methodName1 = "createLinhVucVanBan";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLinhVucVanBan";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLinhVucVanBan";

		_methodParameterTypes3 = new String[] {
				"com.revotech.portal.vbpq.model.LinhVucVanBan"
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

		_methodName10 = "fetchLinhVucVanBan";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLinhVucVanBan";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getLinhVucVanBans";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getLinhVucVanBansCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateLinhVucVanBan";

		_methodParameterTypes15 = new String[] {
				"com.revotech.portal.vbpq.model.LinhVucVanBan"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "findByNhomVanBanId";

		_methodParameterTypes66 = new String[] { "long" };

		_methodName67 = "getByGroupId_Ten";

		_methodParameterTypes67 = new String[] { "long", "java.lang.String" };

		_methodName68 = "countLinhVuc";

		_methodParameterTypes68 = new String[] { "java.lang.String", "long" };

		_methodName69 = "findLinhVuc";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "long",
				"com.liferay.portal.kernel.util.OrderByComparator", "int", "int"
			};

		_methodName70 = "getLinhVuc";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "countByTrangThai";

		_methodParameterTypes71 = new String[] { "long", "boolean" };

		_methodName72 = "countAll";

		_methodParameterTypes72 = new String[] { "long" };

		_methodName73 = "getByTrangThai";

		_methodParameterTypes73 = new String[] { "long", "boolean", "int", "int" };

		_methodName74 = "getAll";

		_methodParameterTypes74 = new String[] { "long", "int", "int" };

		_methodName75 = "deleteLinhVuc";

		_methodParameterTypes75 = new String[] { "long" };

		_methodName76 = "deleteLinhVuc";

		_methodParameterTypes76 = new String[] {
				"com.revotech.portal.vbpq.model.LinhVucVanBan"
			};

		_methodName77 = "updateLinhVucVanBan";

		_methodParameterTypes77 = new String[] {
				"long", "long", "java.lang.String", "boolean", "int", "long",
				"long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.addLinhVucVanBan((com.revotech.portal.vbpq.model.LinhVucVanBan)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.createLinhVucVanBan(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.deleteLinhVucVanBan(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.deleteLinhVucVanBan((com.revotech.portal.vbpq.model.LinhVucVanBan)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.fetchLinhVucVanBan(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getLinhVucVanBan(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getLinhVucVanBans(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getLinhVucVanBansCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan((com.revotech.portal.vbpq.model.LinhVucVanBan)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			LinhVucVanBanLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.findByNhomVanBanId(((Long)arguments[0]).longValue());
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getByGroupId_Ten(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.countLinhVuc((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.findLinhVuc((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getLinhVuc(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.countByTrangThai(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.countAll(((Long)arguments[0]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getByTrangThai(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.getAll(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			LinhVucVanBanLocalServiceUtil.deleteLinhVuc(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			LinhVucVanBanLocalServiceUtil.deleteLinhVuc((com.revotech.portal.vbpq.model.LinhVucVanBan)arguments[0]);

			return null;
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return LinhVucVanBanLocalServiceUtil.updateLinhVucVanBan(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Integer)arguments[4]).intValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue());
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
}