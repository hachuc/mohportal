package com.viettel.portal.vcms.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vcms.model.Content;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.impl.ContentImpl;
import com.viettel.portal.vcms.model.impl.DistributionImpl;

public class DistributionFinderImpl extends BasePersistenceImpl<Distribution> implements DistributionFinder {
	public static final String FINDER_BY_PUBLISHEDDATE_SQL = DistributionFinder.class.getName() + ".findByPubishedDate";
	public static final String COUNT_BY_PUBLISHEDDATE_SQL = DistributionFinder.class.getName() + ".countByPubishedDate";
	public static final String DISTRIBUTION_FINDER_SQL = DistributionFinder.class.getName() + ".findByGroupAndCategory";
	public static final String DISTRIBUTION_COUNT_SQL = DistributionFinder.class.getName() + ".countByGroupAndCategory";
	public static final String FETCH_DISTRIBUTION_FINDER_SQL = DistributionFinder.class.getName()
			+ ".findNewsestContent";
	public static final String FIND_BY_VERSION_STATUS_SQL = DistributionFinder.class.getName()
			+ ".findByVersionAndStatus";
	public static final String COUNT_BY_VERSION_STATUS_SQL = DistributionFinder.class.getName()
			+ ".countByVersionAndStatus";
	public static final String GET_MOST_VIEWED_SQL = DistributionFinder.class.getName() + ".getMostViewdContent";

	public List findByVersionAndStatus(long groupId, long categoryId, String keyword, long authorId, int searchOption,
			int start, int end) throws PortalException, SystemException {

		String[] names = null;
		boolean andOperator = false;
		if (Validator.isNotNull(keyword) && searchOption == 0) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			names = new String[] { "%" + StringUtil.toLowerCase(keyword) + "%" };
			andOperator = true;
		}

		return findByK_G_S_V(names, andOperator, groupId, categoryId, authorId, start, end);
	}

	private List findByK_G_S_V(String[] keywords, boolean andOperator, long groupId, long categoryId, long authorId,
			int start, int end) throws PortalException, SystemException {

		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_VERSION_STATUS_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (a.categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (a.createdByUserId = ?)", "");

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.title)", StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("autoId", Type.LONG);
			q.addScalar("distributionId", Type.LONG);
			q.addScalar("contentId", Type.LONG);
			q.addScalar("groupId", Type.LONG);
			q.addScalar("companyId", Type.LONG);
			q.addScalar("userId", Type.LONG);
			q.addScalar("userName", Type.STRING);
			q.addScalar("createDate", Type.STRING);
			q.addScalar("distributedDate", Type.STRING);
			q.addScalar("version", Type.INTEGER);
			q.addScalar("title", Type.STRING);
			q.addScalar("categoryId", Type.LONG);
			q.addScalar("status", Type.INTEGER);
			q.addScalar("createdByUserId", Type.LONG);
			q.addScalar("editedByUserId", Type.LONG);
			q.addScalar("reviewedByUserId", Type.LONG);
			q.addScalar("publishedByUserId", Type.LONG);
			q.addScalar("createdByUserName", Type.STRING);
			q.addScalar("editedByUserName", Type.STRING);
			q.addScalar("reviewedByUserName", Type.STRING);
			q.addScalar("publishedByUserName", Type.STRING);
			q.addScalar("totalComments", Type.INTEGER);
			q.addScalar("categoryName", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);

			qPos.add(keywords, 2);
			return (List) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByVersionAndStatus(long groupId, long categoryId, String keyword, long authorId, int searchOption)
			throws PortalException, SystemException {

		String[] names = null;
		boolean andOperator = false;
		if (Validator.isNotNull(keyword) && searchOption == 0) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			names = new String[] { "%" + StringUtil.toLowerCase(keyword) + "%" };
			andOperator = true;
		}
		return countByK_G_S_V(names, andOperator, groupId, categoryId, authorId);
	}

	private int countByK_G_S_V(String[] keywords, boolean andOperator, long groupId, long categoryId, long authorId)
			throws PortalException, SystemException {
		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_VERSION_STATUS_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (a.categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (a.createdByUserId = ?)", "");

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.title)", StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);
			qPos.add(keywords, 2);
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

	public List<Distribution> findByPubishedDate(long groupId, long[] categoryIds, String publishedDate, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_BY_PUBLISHEDDATE_SQL);

			if (categoryIds.length == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			else {
				StringBuilder statusCondition = new StringBuilder();
				for (int i = 0; i < categoryIds.length; i++) {
					statusCondition.append("categoryId = ?");
					if (i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Distribution", DistributionImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);

			if (categoryIds.length > 0) {
				for (int j = 0; j < categoryIds.length; j++) {
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

	public int countByPubishedDate(long groupId, long[] categoryIds, String publishedDate)
			throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PUBLISHEDDATE_SQL);
			if (categoryIds.length == 0) {
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			} else {
				StringBuilder statusCondition = new StringBuilder();
				for (int i = 0; i < categoryIds.length; i++) {
					statusCondition.append("categoryId = ?");
					if (i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryIds.length > 0) {
				for (int j = 0; j < categoryIds.length; j++) {
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
			else {
				StringBuilder statusCondition = new StringBuilder();
				for (int i = 0; i < categoryIds.length; i++) {
					statusCondition.append("categoryId = ?");
					if (i < categoryIds.length - 1)
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
			if (categoryIds.length > 0) {
				for (int j = 0; j < categoryIds.length; j++) {
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
				for (int i = 0; i < categoryIds.length; i++) {
					statusCondition.append("categoryId = ?");
					if (i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "categoryId = ?", statusCondition.toString());
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryIds.length > 0) {
				for (int j = 0; j < categoryIds.length; j++) {
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

	public List<Distribution> findNewsestContents(long groupId, long distributionId, int start, int end)
			throws PortalException, SystemException {
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

	public List getMostViewedNews(long groupId, long[] categoryIds, Date fromDate, Date toDate, int start, int end)
			throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_MOST_VIEWED_SQL);
			if (categoryIds.length == 0)
				sql = StringUtil.replace(sql, "AND (a.categoryId = ?)", "");
			else {
				StringBuilder statusCondition = new StringBuilder();
				for (int i = 0; i < categoryIds.length; i++) {
					statusCondition.append("a.categoryId = ?");
					if (i < categoryIds.length - 1)
						statusCondition.append(" OR ");
				}
				sql = StringUtil.replace(sql, "a.categoryId = ?", statusCondition.toString());
			}
			if (Validator.isNull(fromDate)) {
				sql = StringUtil.replace(sql, "AND (c.createDate >= ?)", "");
			}
			if (Validator.isNull(toDate)) {
				sql = StringUtil.replace(sql, "AND (c.createDate < ?)", "");
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("viewCount", Type.INTEGER);
			q.addScalar("distributionId", Type.LONG);
			q.addScalar("contentId", Type.LONG);
			q.addScalar("distributedDate", Type.STRING);
			q.addScalar("title", Type.STRING);
			q.addScalar("smallImageUrl", Type.STRING);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryIds.length > 0) {
				for (int j = 0; j < categoryIds.length; j++) {
					qPos.add(categoryIds[j]);
				}
			}
			if (Validator.isNotNull(fromDate))
				qPos.add(fromDate);
			if (Validator.isNotNull(toDate))
				qPos.add(toDate);
			return (List) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private static final Log LOG = LogFactoryUtil.getLog(DistributionFinderImpl.class);
}
