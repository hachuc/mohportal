package com.revotech.portal.tthc.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.revotech.portal.tthc.model.Category;
import com.revotech.portal.tthc.model.LegalDocument;
import com.revotech.portal.tthc.model.impl.LegalDocumentImpl;


public class LegalDocumentFinderImpl extends BasePersistenceImpl<LegalDocument> implements LegalDocumentFinder {
	public static final String FINDER_SQL = LegalDocumentFinder.class.getName()
			+ ".findByKeyword";
	public static final String FINDER2_SQL = LegalDocumentFinder.class.getName()
			+ ".getFieldsByKeyword";
	public static final String COUNT_SQL = LegalDocumentFinder.class.getName()
			+ ".countByKeyword";
	public List<LegalDocument> searchByStatusVersion(String keywords, long groupId, long category1Id, long category12d, int level,
			int start, int end) throws PortalException, SystemException {

		String[] ldCodes = null;
		String[] ldTitles = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			ldCodes = CustomSQLUtil.keywords(keywords);
			ldTitles = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return findByK_G_S_V(ldCodes, ldTitles, andOperator, groupId, category1Id, category12d, level, start, end);
	}
	public List searchFieldByStatusVersion(String keywords, long groupId, long category1Id, long category12d, int level,
			int start, int end) throws PortalException, SystemException {

		String[] ldCodes = null;
		String[] ldTitles = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			ldCodes = CustomSQLUtil.keywords(keywords);
			ldTitles = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return findFieldByK_G_S_V(ldCodes, ldTitles, andOperator, groupId, category1Id, category12d, level, start, end);
	}
	public int countByStatusVersion(String keywords, long groupId, long category1Id, long category2Id, int level) throws PortalException,
	SystemException {

		String[] ldCodes = null;
		String[] ldTitles = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			ldCodes = CustomSQLUtil.keywords(keywords);
			ldTitles = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}
		return countByK_G_S_V(ldCodes, ldTitles, andOperator, groupId, category1Id, category2Id, level);
	}
	private List<LegalDocument> findByK_G_S_V(String[] ldCodes, String[] ldTitles, boolean andOperator,
			long groupId, long category1Id, long category2Id, int level, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		ldCodes = CustomSQLUtil.keywords(ldCodes);
		ldTitles = CustomSQLUtil.keywords(ldTitles);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_SQL);
			if (category1Id == 0)
				sql = StringUtil.replace(sql, "AND (idCoquanbanhanh = ?)", "");
			if (category2Id == 0)
				sql = StringUtil.replace(sql, "AND (idLinhvuc =?)", "");
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ldCode)", StringPool.LIKE, false, ldCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ldTitle)", StringPool.LIKE, true, ldTitles);
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LegalDocument", LegalDocumentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (category1Id > 0)
				qPos.add(category1Id);
			if (category2Id > 0)
				qPos.add(category2Id);
			qPos.add(level);
			qPos.add(ldCodes, 2);
			qPos.add(ldTitles, 2);
			return (List<LegalDocument>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	private List findFieldByK_G_S_V(String[] ldCodes, String[] ldTitles, boolean andOperator,
			long groupId, long category1Id, long category2Id, int level, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		ldCodes = CustomSQLUtil.keywords(ldCodes);
		ldTitles = CustomSQLUtil.keywords(ldTitles);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER2_SQL);
			if (category1Id == 0)
				sql = StringUtil.replace(sql, "AND (ld.idCoquanbanhanh = ?)", "");
			if (category2Id == 0)
				sql = StringUtil.replace(sql, "AND (ld.idLinhvuc =?)", "");
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ld.ldCode)", StringPool.LIKE, false, ldCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ld.ldTitle)", StringPool.LIKE, true, ldTitles);
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("ldCode", Type.STRING);
			q.addScalar("ldTitle", Type.STRING);
			q.addScalar("ldLink", Type.STRING);
			q.addScalar("ldLevel3Link", Type.STRING);
			q.addScalar("ldLevel", Type.INTEGER);
			q.addScalar("tenLinhVuc", Type.STRING);
			q.addScalar("tenCoQuanBanHanh", Type.STRING);
			q.addScalar("ldDonvithuchien", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (category1Id > 0)
				qPos.add(category1Id);
			if (category2Id > 0)
				qPos.add(category2Id);
			qPos.add(level);
			qPos.add(ldCodes, 2);
			qPos.add(ldTitles, 2);
			return (List) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	private int countByK_G_S_V(String[] ldCodes, String[] ldTitles,boolean andOperator, long groupId, long category1Id, long category2Id, int level) throws PortalException, SystemException {
		Session session = null;
		ldCodes = CustomSQLUtil.keywords(ldCodes);
		ldTitles = CustomSQLUtil.keywords(ldTitles);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_SQL);
			if (category1Id == 0)
				sql = StringUtil.replace(sql, "AND (idCoquanbanhanh = ?)", "");
			if (category2Id == 0)
				sql = StringUtil.replace(sql, "AND (idLinhvuc =?)", "");
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ldCode)", StringPool.LIKE, false, ldCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ldTitle)", StringPool.LIKE, true, ldTitles);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (category1Id > 0)
				qPos.add(category1Id);
			if (category2Id > 0)
				qPos.add(category2Id);
			qPos.add(level);
			qPos.add(ldCodes, 2);
			qPos.add(ldTitles, 2);
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
	private static final Log LOG = LogFactoryUtil
			.getLog(LegalDocumentFinderImpl.class);
}
