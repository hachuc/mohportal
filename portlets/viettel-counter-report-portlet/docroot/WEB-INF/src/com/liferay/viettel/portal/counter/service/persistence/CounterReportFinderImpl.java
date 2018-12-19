package com.liferay.viettel.portal.counter.service.persistence;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.servlet.SessionParameters;
import com.liferay.viettel.portal.counter.model.CounterReport;
import com.liferay.viettel.portal.counter.ReportCounter;

import java.util.Date;

public class CounterReportFinderImpl extends BasePersistenceImpl<CounterReport> implements CounterReportFinder {
	@SuppressWarnings("unchecked")
	public int counterCategory(long categoryId, Date start, Date end) {
		Session session = null;

		try {
			session = openSession();

			/*
			 * String sqlStr =
			 * "SELECT COUNT(*) AS TOTAL FROM AssetCounter WHERE categoryId = ? AND createDate >= ? AND createDate < ? "
			 * ;
			 */
			String sqlStr = "SELECT COUNT(*) AS TOTAL"
					+ " FROM vcms_distribution_visisted a inner join  vcms_distribution b on a.distributionID = b.distributionID "
					+ "WHERE b.categoryId = ? AND a.createDate >= ? AND a.createDate <= ? ";
			List<Object> params = new ArrayList<Object>();
			params.add(categoryId);
			params.add(start);
			params.add(end);

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

	public int counterVisitor(Date date) {
		Session session = null;

		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 1);
			Date end = c.getTime();

			session = openSession();

			String sqlStr = "SELECT SUM(hitCounter) AS TOTAL FROM VisitCounterLog WHERE createDate >= ? AND createDate < ? GROUP BY createDate";
			List<Object> params = new ArrayList<Object>();
			params.add(date);
			params.add(end);

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

	@SuppressWarnings("unchecked")
	public List counterArticle(long categoryId, Date startDate, Date endDate, int start, int end) {
		Session session = null;

		try {
			session = openSession();

			String sqlStr = "SELECT c.title, COUNT(a.distributionId) as TOTAL"
					+ " FROM vcms_distribution_visisted a INNER JOIN vcms_distribution b on a.distributionId=b.distributionId"
					+ " INNER JOIN vcms_content c ON b.contentId = c.contentId AND c.version = 4 AND c.status = 8192"
					+ " WHERE a.createDate >= ? and a.createDate <= ?"
					+ " GROUP BY a.distributionId, c.title"
					+ " ORDER BY TOTAL DESC";
			_log.error("sqlStr: " + sqlStr);
			_log.error("startDate: " + startDate);
			_log.error("endDate: " + endDate);
			List<Object> params = new ArrayList<Object>();
			params.add(startDate);
			params.add(endDate);
			
			SQLQuery query = session.createSQLQuery(sqlStr);
			QueryPos pos = QueryPos.getInstance(query);
			for (Object param : params) {
				pos.add(param);
			}
			query.addScalar("title", Type.STRING);
			query.addScalar("total", Type.INTEGER);
			
			
			List list = QueryUtil.list(query, getDialect(), start, end);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			return list;
		} catch (Exception e) {
			_log.error(e);
			return null;
		} finally {
			closeSession(session);
		}
	}

	public int countArticle(long categoryId, Date startDate, Date endDate, int start, int end) {
		Session session = null;

		try {
			session = openSession();

			String sqlStr = "SELECT COUNT(*) as TOTAL from (SELECT COUNT(*) AS distributionId"
					+ " FROM vcms_distribution_visisted a INNER JOIN vcms_distribution b on a.distributionId=b.distributionId"
					+ " INNER JOIN vcms_content c ON b.contentId = c.contentId AND c.version = 4 AND c.status = 8192"
					+ " WHERE a.createDate >= ? and a.createDate <= ?"
					+ " GROUP BY a.distributionId) as TBLTEM";
//					+ "	ORDER BY TOTAL DESC";
			_log.error("sqlStr: " + sqlStr);
			_log.error("startDate: " + startDate);
			_log.error("endDate: " + endDate);
			List<Object> params = new ArrayList<Object>();
			params.add(startDate);
			params.add(endDate);

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

	private final static Log _log = LogFactoryUtil.getLog(CounterReportFinderImpl.class);
}
