package com.viettel.portal.vcms.service.persistence;

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
import com.viettel.portal.vcms.model.impl.ContentImpl;

public class ContentFinderImpl extends BasePersistenceImpl<Content> implements
		ContentFinder {
	public static final String FINDER_SQL = ContentFinder.class.getName()
			+ ".findByKeyword";

	public static final String COUNT_SQL = ContentFinder.class.getName()
			+ ".countByKeyword";
	
	public static final String FIND_BY_CATEGORY_SQL = ContentFinder.class.getName()
			+ ".findByCategory";

	public static final String COUNT_BY_CATEGORY_SQL = ContentFinder.class.getName()
			+ ".countByCategory";
	
	public static final String FINDER_BY_STATUS_VERSION_SQL = ContentFinder.class.getName()
			+ ".searchByStatusVersion";

	public static final String COUNT_BY_STATUS_VERSION_SQL = ContentFinder.class.getName()
			+ ".countByStatusVersion";
	
	public static final String FIND_BY_VERSION = ContentFinder.class.getName() + ".findByVersions";
	
	public static final String FIND_BY_SCALAR_SQL = ContentFinder.class.getName() + ".findByAutoId";
	
	public static final String FIND_BY_CONTENTID_SQL = ContentFinder.class.getName() + ".findByContentId";
	
	public static final String FIND_BY_G_CA_AU_V_S = ContentFinder.class.getName() + ".findByG_CA_AU_V_S";
	
	public static final String COUNT_BY_G_CA_AU_V_S = ContentFinder.class.getName() + ".countByG_CA_AU_V_S";
	
	/*
	 * Tim kiem theo GROUP, CATEGORY, VERSION, STATUS, KEYWORD, AUTHOR
	 */
	public List<Content> findByVersion(long groupId, long contentId, int[] version) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_VERSION);
			
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(contentId);
			for(int j = 0; j< version.length; j++){
				qPos.add(version[j]);
			}
			return (List<Content>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Content> findByG_CA_AU_V_S(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {

		String[] names = null;
		boolean andOperator = false;
		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return findByG_CA_AU_V_S(names, andOperator, groupId, categoryId, authorId, status, version, obc, start, end);
	}
	public int countByG_CA_AU_V_S(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version) throws PortalException,
	SystemException {

		String[] names = null;
		boolean andOperator = false;
		
		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}
		return countByG_CA_AU_V_S(names, andOperator, groupId, categoryId, authorId, status, version);
	}
	private List<Content> findByG_CA_AU_V_S(String[] keywords, boolean andOperator,
			long groupId, long categoryId, long authorId, int[] status, int[] version, OrderByComparator obc, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_BY_STATUS_VERSION_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (createdByUserId = ?)", "");
			StringBuilder statusCondition = new StringBuilder();
			for(int i = 0; i< status.length ; i ++){
				statusCondition.append("status = ?");
				if(i < status.length - 1)
					statusCondition.append(" OR ");
			}
			sql = StringUtil.replace(sql, "status = ?", statusCondition.toString());
			
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			if (obc != null)
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);
			for(int j = 0; j< status.length; j++){
				qPos.add(status[j]);
			}
			qPos.add(version);
			qPos.add(keywords, 2);
			return (List<Content>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private int countByG_CA_AU_V_S(String[] keywords, boolean andOperator, long groupId, long categoryId, long authorId, int[] status, int[] version) throws PortalException, SystemException {
		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_STATUS_VERSION_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (createdByUserId = ?)", "");
			StringBuilder statusCondition = new StringBuilder();
			for(int i = 0; i< status.length ; i ++){
				statusCondition.append("status = ?");
				if(i < status.length - 1)
					statusCondition.append(" OR ");
			}
			sql = StringUtil.replace(sql, "status = ?", statusCondition.toString());
			
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);
			for(int j = 0; j< status.length; j++){
				qPos.add(status[j]);
			}
			qPos.add(version);
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
	
	
	/**/
	
	public List<Content> searchByStatusVersion(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version, int searchOption,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {

		String[] names = null;
		boolean andOperator = false;
		if (Validator.isNotNull(keyword) && searchOption == 0) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			names = new String[]{"%" + StringUtil.toLowerCase(keyword) + "%"};
			andOperator = true;
		}

		return findByK_G_S_V(names, andOperator, groupId, categoryId, authorId, status, version, obc, start, end);
	}
	
	public Content findByAutoId(long autoId, long groupId) throws PortalException, SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_SCALAR_SQL);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(autoId);
			qPos.add(groupId);
			Iterator<Content> itr = q.list().iterator();
			if (itr.hasNext()) {
				Content count = itr.next();
				if (count != null) {
					return count;
				}
			}
			return null;
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public Content findByContentId(long contentId, long groupId, int version, int status) throws PortalException, SystemException{
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_CONTENTID_SQL);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			qPos.add(contentId);
			qPos.add(version);
			qPos.add(status);
			Iterator<Content> itr = q.iterate();
			if (itr.hasNext()) {
				Content count = itr.next();
				if (count != null) {
					return count;
				}
			}
			return null;
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByStatusVersion(String keyword, long groupId, long categoryId, long authorId, int[] status, int[] version) throws PortalException,
	SystemException {

		String[] names = null;
		boolean andOperator = false;
		
		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}
		return countByK_G_S_V(names, andOperator, groupId, categoryId, authorId, status, version);
	}
	private List<Content> findByK_G_S_V(String[] keywords, boolean andOperator,
			long groupId, long categoryId, long authorId, int[] status, int[] version, OrderByComparator obc, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_BY_STATUS_VERSION_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (createdByUserId = ?)", "");
			StringBuilder statusCondition = new StringBuilder();
			for(int i = 0; i< status.length ; i ++){
				statusCondition.append("status = ?");
				if(i < status.length - 1)
					statusCondition.append(" OR ");
			}
			sql = StringUtil.replace(sql, "status = ?", statusCondition.toString());
			
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			if (obc != null)
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);
			for(int j = 0; j< status.length; j++){
				qPos.add(status[j]);
			}
			for(int j = 0; j< version.length; j++){
				qPos.add(version[j]);
			}
			
			qPos.add(keywords, 2);
			return (List<Content>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private int countByK_G_S_V(String[] keywords, boolean andOperator, long groupId, long categoryId, long authorId, int[] status, int[] version) throws PortalException, SystemException {
		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_STATUS_VERSION_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			if (authorId == 0)
				sql = StringUtil.replace(sql, "AND (createdByUserId = ?)", "");
			StringBuilder statusCondition = new StringBuilder();
			for(int i = 0; i< status.length ; i ++){
				statusCondition.append("status = ?");
				if(i < status.length - 1)
					statusCondition.append(" OR ");
			}
			sql = StringUtil.replace(sql, "status = ?", statusCondition.toString());
			
			StringBuilder versionConn = new StringBuilder();
			for(int i = 0; i< version.length ; i ++){
				versionConn.append("version = ?");
				if(i < version.length - 1)
					versionConn.append(" OR ");
			}
			sql = StringUtil.replace(sql, "version = ?", versionConn.toString());
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			if (authorId > 0)
				qPos.add(authorId);
			for(int j = 0; j< status.length; j++){
				qPos.add(status[j]);
			}
			qPos.add(version);
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
	public List<Content> findByKeyword(String keyword, long groupId, long categoryId,
			OrderByComparator obc, int start, int end) throws PortalException,
			SystemException {

		String[] names = null;
		boolean andOperator = false;
		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}

		return findByK_G(names, andOperator, groupId, categoryId, obc, start, end);

	}
	public int countByKeyword(String keyword, long groupId, long categoryId) throws PortalException,
	SystemException {

		String[] names = null;
		boolean andOperator = false;
		
		if (Validator.isNotNull(keyword)) {
			names = CustomSQLUtil.keywords(keyword);
		} else {
			andOperator = true;
		}
		return countByK_G(names, andOperator, groupId, categoryId);
	}
	private List<Content> findByK_G(String[] keywords, boolean andOperator,
			long groupId, long categoryId, OrderByComparator obc, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			if (obc != null)
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			qPos.add(keywords, 2);
			return (List<Content>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private int countByK_G(String[] keywords, boolean andOperator, long groupId, long categoryId) throws PortalException, SystemException {
		Session session = null;
		keywords = CustomSQLUtil.keywords(keywords);
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a1.title)",
					StringPool.LIKE, true, keywords);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
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
	
	public List<Content> findByCategory(long groupId, long categoryId, OrderByComparator obc, int start,
			int end) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_CATEGORY_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			sql = CustomSQLUtil.replaceAndOperator(sql, true);
			if (obc != null)
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("Content", ContentImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
			return (List<Content>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByCategory(long groupId, long categoryId) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_CATEGORY_SQL);
			if (categoryId == 0)
				sql = StringUtil.replace(sql, "AND (categoryId = ?)", "");
			sql = CustomSQLUtil.replaceAndOperator(sql, true);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if (categoryId > 0)
				qPos.add(categoryId);
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
			.getLog(ContentFinderImpl.class);
}
