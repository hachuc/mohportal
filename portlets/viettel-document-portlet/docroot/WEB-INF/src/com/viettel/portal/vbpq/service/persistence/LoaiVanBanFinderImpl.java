package com.viettel.portal.vbpq.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.viettel.portal.vbpq.model.LoaiVanBan;
import com.viettel.portal.vbpq.model.impl.LoaiVanBanImpl;
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

public class LoaiVanBanFinderImpl extends BasePersistenceImpl<LoaiVanBan>
		implements LoaiVanBanFinder {
	public static final String FINDER_SQL = LoaiVanBanFinder.class.getName()
			+ ".finder";

	public static final String COUNT_SQL = LoaiVanBanFinder.class.getName()
			+ ".count";

	/**
	 * @param keyword
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public int count(String keyword, long groupId) throws PortalException,
			SystemException {

		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return countBy_K(names, andOperator, groupId);
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
	public List<LoaiVanBan> find(String keyword, long groupId,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {

		String[] names = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return findBy_K(names, andOperator, groupId, obc, start, end);

	}

	/**
	 * @param keywords
	 * @param andOperator
	 * @param groupId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private int countBy_K(String[] keywords, boolean andOperator, long groupId)
			throws PortalException, SystemException {
		Session session = null;

		keywords = CustomSQLUtil.keywords(keywords);

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.ten)",
					StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

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
	private List<LoaiVanBan> findBy_K(String[] keywords, boolean andOperator,
			long groupId, OrderByComparator obc, int start, int end)
			throws PortalException, SystemException {

		Session session = null;

		keywords = CustomSQLUtil.keywords(keywords);

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FINDER_SQL);

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.ten)",
					StringPool.LIKE, true, keywords);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("LoaiVanBan", LoaiVanBanImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			qPos.add(keywords, 2);

			return (List<LoaiVanBan>) QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private static final Log LOG = LogFactoryUtil
			.getLog(LoaiVanBanFinderImpl.class);

}
