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

package com.revotech.portal.videolibrary.service.base;

import com.revotech.portal.videolibrary.service.VLVideoLocalServiceUtil;

import java.util.Arrays;

/**
 * @author ChucHV
 * @generated
 */
public class VLVideoLocalServiceClpInvoker {
	public VLVideoLocalServiceClpInvoker() {
		_methodName0 = "addVLVideo";

		_methodParameterTypes0 = new String[] {
				"com.revotech.portal.videolibrary.model.VLVideo"
			};

		_methodName1 = "createVLVideo";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVLVideo";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVLVideo";

		_methodParameterTypes3 = new String[] {
				"com.revotech.portal.videolibrary.model.VLVideo"
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

		_methodName10 = "fetchVLVideo";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVLVideo";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVLVideos";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVLVideosCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVLVideo";

		_methodParameterTypes15 = new String[] {
				"com.revotech.portal.videolibrary.model.VLVideo"
			};

		_methodName74 = "getBeanIdentifier";

		_methodParameterTypes74 = new String[] {  };

		_methodName75 = "setBeanIdentifier";

		_methodParameterTypes75 = new String[] { "java.lang.String" };

		_methodName80 = "removeAll";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "addVideo";

		_methodParameterTypes81 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "boolean", "long",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};

		_methodName82 = "addLegalVideo";

		_methodParameterTypes82 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "boolean", "long",
				"java.lang.String", "java.util.Date", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName83 = "countAllByGroup";

		_methodParameterTypes83 = new String[] { "long" };

		_methodName84 = "countByByKeyword";

		_methodParameterTypes84 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName85 = "findByGroup";

		_methodParameterTypes85 = new String[] { "long" };

		_methodName86 = "findByGroup";

		_methodParameterTypes86 = new String[] { "long", "int", "int" };

		_methodName87 = "findByCategoryId";

		_methodParameterTypes87 = new String[] { "long", "long" };

		_methodName88 = "findByCategoryId";

		_methodParameterTypes88 = new String[] { "long", "long", "int", "int" };

		_methodName89 = "findByKeyword";

		_methodParameterTypes89 = new String[] {
				"long", "long", "java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName90 = "findByKeywordFrontend";

		_methodParameterTypes90 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"java.lang.String", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName91 = "countByKeywordFrontend";

		_methodParameterTypes91 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName92 = "updateVideo";

		_methodParameterTypes92 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "boolean", "long",
				"com.liferay.portal.service.ServiceContext", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VLVideoLocalServiceUtil.addVLVideo((com.revotech.portal.videolibrary.model.VLVideo)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VLVideoLocalServiceUtil.createVLVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VLVideoLocalServiceUtil.deleteVLVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VLVideoLocalServiceUtil.deleteVLVideo((com.revotech.portal.videolibrary.model.VLVideo)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VLVideoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VLVideoLocalServiceUtil.fetchVLVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VLVideoLocalServiceUtil.getVLVideo(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VLVideoLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VLVideoLocalServiceUtil.getVLVideos(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VLVideoLocalServiceUtil.getVLVideosCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VLVideoLocalServiceUtil.updateVLVideo((com.revotech.portal.videolibrary.model.VLVideo)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return VLVideoLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			VLVideoLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			VLVideoLocalServiceUtil.removeAll(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return VLVideoLocalServiceUtil.addVideo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8],
				((Long)arguments[9]).longValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Long)arguments[11]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[12],
				(java.lang.String)arguments[13]);
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return VLVideoLocalServiceUtil.addLegalVideo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8],
				((Long)arguments[9]).longValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Long)arguments[11]).longValue(),
				(java.lang.String)arguments[12], (java.util.Date)arguments[13],
				(java.util.Date)arguments[14],
				(com.liferay.portal.service.ServiceContext)arguments[15]);
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return VLVideoLocalServiceUtil.countAllByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return VLVideoLocalServiceUtil.countByByKeyword(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByGroup(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByCategoryId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByCategoryId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByKeyword(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[5]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return VLVideoLocalServiceUtil.findByKeywordFrontend(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[7]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return VLVideoLocalServiceUtil.countByKeywordFrontend(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return VLVideoLocalServiceUtil.updateVideo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				((Long)arguments[10]).longValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Long)arguments[12]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[13],
				(java.lang.String)arguments[14]);
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
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
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