package com.viettel.portal.vcms.service.persistence;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.impl.DistributionImpl;

public class DistributionFinderImpl extends BasePersistenceImpl<Distribution> implements
DistributionFinder {
	public static final String FINDER_BY_PUBLISHEDDATE_SQL = DistributionFinder.class.getName()
			+ ".findByPubishedDate";
	public static final String COUNT_BY_PUBLISHEDDATE_SQL = DistributionFinder.class.getName()
			+ ".countByPubishedDate";
	public static final String DISTRIBUTION_FINDER_SQL = DistributionFinder.class.getName()
			+ ".findByGroupAndCategory";
	public static final String DISTRIBUTION_COUNT_SQL = DistributionFinder.class.getName()
			+ ".countByGroupAndCategory";
	public static final String FETCH_DISTRIBUTION_FINDER_SQL = DistributionFinder.class.getName()
			+ ".findNewsestContent";
	public List<Distribution> findByPubishedDate(long groupId, long[] categoryIds, String publishedDate, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_BY_PUBLISHEDDATE_SQL);
			
			if (categoryIds.length == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			else{
				StringBuilder statusCondition = new StringBuilder();
				for(int i = 0; i< categoryIds.length ; i ++){
					statusCondition.append("categoryId = ?");
					if(i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Distribution", DistributionImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			
			if(categoryIds.length > 0){
				for(int j = 0; j< categoryIds.length; j++){
					qPos.add(categoryIds[j]);
				}
			}
			
			qPos.add(publishedDate);
			
			return (List<Distribution>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByPubishedDate(long groupId, long[] categoryIds, String publishedDate) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PUBLISHEDDATE_SQL);
			if (categoryIds.length == 0){
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			}
			else{
				StringBuilder statusCondition = new StringBuilder();
				for(int i = 0; i< categoryIds.length ; i ++){
					statusCondition.append("categoryId = ?");
					if(i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if(categoryIds.length>0){
				for(int j = 0; j< categoryIds.length; j++){
					qPos.add(categoryIds[j]);
				}
			}
			qPos.add(publishedDate);
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Distribution> findByGroupAndCategory(long groupId, long[] categoryIds, OrderByComparator obc, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(DISTRIBUTION_FINDER_SQL);
			if (categoryIds.length == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			else{
				StringBuilder statusCondition = new StringBuilder();
				for(int i = 0; i< categoryIds.length ; i ++){
					statusCondition.append("categoryId = ?");
					if(i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			if (obc != null)
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Distribution", DistributionImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryIds.length > 0){
				for(int j = 0; j< categoryIds.length; j++){
					qPos.add(categoryIds[j]);
				}
			}
			return (List<Distribution>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByGroupAndCategory(long groupId, long[] categoryIds) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(DISTRIBUTION_COUNT_SQL);
			if (categoryIds.length == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			{
				StringBuilder statusCondition = new StringBuilder();
				for(int i = 0; i< categoryIds.length ; i ++){
					statusCondition.append("categoryId = ?");
					if(i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryIds.length > 0)
			{
				for(int j = 0; j< categoryIds.length; j++){
					qPos.add(categoryIds[j]);
				}
			}
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List<Distribution> findNewsestContents(long groupId, long distributionId, int start, int end) throws PortalException, SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FETCH_DISTRIBUTION_FINDER_SQL);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Distribution", DistributionImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(distributionId);
			return (List<Distribution>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	private static final Log LOG = LogFactoryUtil
			.getLog(DistributionFinderImpl.class);
}
