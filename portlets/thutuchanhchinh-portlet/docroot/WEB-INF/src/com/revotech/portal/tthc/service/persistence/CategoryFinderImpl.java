package com.revotech.portal.tthc.service.persistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.impl.CategoryImpl;

public class CategoryFinderImpl extends BasePersistenceImpl<Category> implements CategoryFinder {
	public static final String FINDER_SQL = CategoryFinder.class.getName() + ".findByKeyword";

	public static final String COUNT_SQL = CategoryFinder.class.getName() + ".countByKeyword";
	
	public static final String FINDER_SQL_ADMIN = CategoryFinder.class.getName() + ".findByKeywordAdmin";
	
	public static final String COUNT_SQL_ADMIN = CategoryFinder.class.getName() + ".countByKeywordAdmin";

	public int countByKeyword(String keyword, long groupId, int categoryType,boolean isSiteAdmin) throws PortalException, SystemException {

		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return countBy_K(names, andOperator, groupId, categoryType,isSiteAdmin);
	}

	/**
	 * @param keyword
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Category> findByKeyword(String keyword, long groupId, int categoryType, int start, int end,boolean isSiteAdmin)
			throws PortalException, SystemException {

		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return findBy_K(names, andOperator, groupId, categoryType, start, end,isSiteAdmin);

	}

	/**
	 * @param keywords
	 * @param andOperator
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private int countBy_K(String[] keywords, boolean andOperator, long groupId, int categoryType,boolean isSiteAdmin)
			throws PortalException, SystemException {
		Session session = null;

		keywords = CustomSQLUtil.keywords(keywords);

		try {
			session = openSession();

			String sql = isSiteAdmin ? CustomSQLUtil.get(COUNT_SQL_ADMIN) : CustomSQLUtil.get(COUNT_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.categoryName)", StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(categoryType);
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

	/**
	 * @param keywords
	 * @param andOperator
	 * @param groupId
	 * @param obc
	 * @param start
	 * @param end
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<Category> findBy_K(String[] keywords, boolean andOperator, long groupId, int categoryType,
			int start, int end ,boolean isSiteAdmin) throws PortalException, SystemException {

		Session session = null;

		keywords = CustomSQLUtil.keywords(keywords);

		try {
			session = openSession();

			String sql = isSiteAdmin ? CustomSQLUtil.get(FINDER_SQL_ADMIN) : CustomSQLUtil.get(FINDER_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.categoryName)", StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			//sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Category", CategoryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(categoryType);
			qPos.add(keywords, 2);

			return (List<Category>) QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private static final Log LOG = LogFactoryUtil.getLog(CategoryFinderImpl.class);
}
