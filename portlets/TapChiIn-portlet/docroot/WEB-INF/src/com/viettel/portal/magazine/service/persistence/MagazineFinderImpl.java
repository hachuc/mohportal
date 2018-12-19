package com.viettel.portal.magazine.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.magazine.model.Magazine;
import com.viettel.portal.magazine.model.impl.MagazineImpl;
import com.viettel.portal.magazine.service.persistence.MagazineFinder;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MagazineFinderImpl extends BasePersistenceImpl<Magazine> implements MagazineFinder {
	
	@SuppressWarnings("unchecked")
	public List<Magazine> getLatestMagazine() {

		Session session = null;

		try {
			session = openSession();

			String sqlStr = CustomSQLUtil.get(GetLatestRecord);

			SQLQuery query = session.createSQLQuery(sqlStr);

			query.addEntity("Magazine", MagazineImpl.class);

			return (List<Magazine>) QueryUtil.list(query, getDialect(), 0, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Magazine> searchMagazine(long number, long year, int begin, int end){
		Session session = null;

		try {
			session = openSession();

			String sqlStr = "SELECT * FROM Magazine " + (number > 0 || year > 0 ? " WHERE " : "");
			List<Object> params = new ArrayList<Object>();
			if (number > 0){
				sqlStr += " PublishNumber = ? ";
				params.add(number);
			}
			if (year > 0){
				sqlStr += " PublishYear = ? ";
				params.add(year);
			}
			
			sqlStr += " ORDER BY PublishYear DESC , PublishNumber DESC, DistributedDate DESC, CreationDate DESC ";
			
			System.err.printf("sqlStr: " + sqlStr);

			SQLQuery query = session.createSQLQuery(sqlStr);
			QueryPos pos = QueryPos.getInstance(query);
			for (Object param : params) {
				pos.add(param);
			}
			query.addEntity("Magazine", MagazineImpl.class);

			return (List<Magazine>) QueryUtil.list(query, getDialect(), begin, end);
		} catch (Exception e) {
			_log.error(e);
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	
	public int countMagazine(long number, long year){
		Session session = null;

		try {
			session = openSession();

			String sqlStr = "SELECT COUNT(*) AS TOTAL FROM Magazine " + (number > 0 || year > 0 ? " WHERE " : "");
			List<Object> params = new ArrayList<Object>();
			if (number > 0){
				sqlStr += " PublishNumber = ? ";
				params.add(number);
			}
			if (year > 0){
				sqlStr += " PublishYear = ? ";
				params.add(year);
			}

			SQLQuery query = session.createSQLQuery(sqlStr);
			QueryPos pos = QueryPos.getInstance(query);
			for (Object param : params) {
				pos.add(param);
			}
			query.addScalar("TOTAL", Type.LONG);

			Iterator<Long> itr = query.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			_log.error(e);
			return 0;
		} finally {
			closeSession(session);
		}
	}
	private final static Log _log = LogFactoryUtil
			.getLog(MagazineFinderImpl.class);
	
	private static final String GetLatestRecord = MagazineFinder.class
			.getName() + ".getLastestRecord";
}
