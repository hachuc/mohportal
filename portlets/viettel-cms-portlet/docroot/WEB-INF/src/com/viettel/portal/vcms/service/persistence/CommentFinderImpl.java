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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vcms.model.Comment;
import com.viettel.portal.vcms.model.impl.CommentImpl;

public class CommentFinderImpl extends BasePersistenceImpl<Comment> implements CommentFinder {
	public static final String SEARCH_BY_KEYWORD_SQL = CommentFinder.class.getName() + ".searchByName";
	public static final String COUNT_BY_KEYWORD_SQL = CommentFinder.class.getName() + ".countByName";
	public static final String CUSTOM_SEARCH_BY_KEYWORD_SQL = CommentFinder.class.getName() + ".customSearchByKeyword";
	public static final String CUSTOM_COUNT_BY_KEYWORD_SQL = CommentFinder.class.getName() + ".customCountByKeyword";
	public static final String CUSTOM_SEARCH_ONE_FIELD_BY_KEWORD_SQL = CommentFinder.class.getName() + ".customOneFieldSearchByKeyword";
	public static final String CUSTOM_COUNT_ONE_FIELD_BY_KEWORD_SQL = CommentFinder.class.getName() + ".customOneFieldCountByKeyword";

	public List<Comment> findByKeywords(long companyId, long groupId, String keywords, int start, int end) throws PortalException, SystemException{

		String[] fullNames = null;
		String[] email = null;
		String[] body = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			fullNames = CustomSQLUtil.keywords(keywords);
			email = CustomSQLUtil.keywords(keywords);
			body = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return findByC_G_F_E_B(companyId, groupId, fullNames, email, body, andOperator, start, end);
	}

	public List<Comment> findByC_G_F_E_B(long companyId, long groupId, String[] fullNames, String[] emails,
			String[] body, boolean andOperator, int start, int end) throws PortalException, SystemException{

		fullNames = CustomSQLUtil.keywords(fullNames);
		emails = CustomSQLUtil.keywords(emails);
		body = CustomSQLUtil.keywords(body);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(SEARCH_BY_KEYWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(fullName)", StringPool.LIKE, false, fullNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(email)", StringPool.LIKE, false, emails);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(body)", StringPool.LIKE, true, body);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Comment", CommentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(fullNames, 2);
			qPos.add(emails, 2);
			qPos.add(body, 2);

			return (List<Comment>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public int countByKeywords(long companyId, long groupId, String keywords) throws PortalException, SystemException{
		String[] fullName = null;
		String[] email = null;
		String[] body = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			fullName = CustomSQLUtil.keywords(keywords);
			email = CustomSQLUtil.keywords(keywords);
			body = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return countByC_G_F_N_D(companyId, groupId, fullName, email, body, andOperator);
	}

	public int countByC_G_F_N_D(long companyId, long groupId, String fullName, String email, String body,
			boolean andOperator) throws PortalException, SystemException{

		String[] fullNames = CustomSQLUtil.keywords(fullName);
		String[] emails = CustomSQLUtil.keywords(email);
		String[] bodys = CustomSQLUtil.keywords(body);

		return countByC_G_F_N_D(companyId, groupId, fullNames, emails, bodys, andOperator);
	}

	public int countByC_G_F_N_D(long companyId, long groupId, String[] feedIds, String[] names, String[] descriptions,
			boolean andOperator) throws PortalException, SystemException{

		feedIds = CustomSQLUtil.keywords(feedIds);
		names = CustomSQLUtil.keywords(names);
		descriptions = CustomSQLUtil.keywords(descriptions);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_KEYWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(fullName)", StringPool.LIKE, false, feedIds);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(email)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(body)", StringPool.LIKE, true, descriptions);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(feedIds, 2);
			qPos.add(names, 2);
			qPos.add(descriptions, 2);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	//
	public List customSearchByKeywords(long companyId, long groupId, String keywords, int type, int start, int end) throws PortalException, SystemException{

		String[] fullNames = null;
		String[] email = null;
		String[] body = null;
		String[] keywordSearch = null;
		boolean andOperator = true;

		if (Validator.isNotNull(keywords)) {
			fullNames = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			email = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			body = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			keywordSearch = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			andOperator = false;
		}
		if(type==0){
			return customSearchByC_G_F_E_B(companyId, groupId, fullNames, email, body, andOperator, start, end);
		}else{
			return customOneFieldSearchByC_G_F_E_B(companyId, groupId, keywordSearch, type, start, end);
		}
	}
	public List customOneFieldSearchByC_G_F_E_B(long companyId, long groupId, String[] keywords, int type, int start, int end) throws PortalException, SystemException{

		keywords = CustomSQLUtil.keywords(keywords);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(CUSTOM_SEARCH_ONE_FIELD_BY_KEWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(a.groupId = ?) AND", StringPool.BLANK);
			}
			if(type==1){
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.fullName)", StringPool.LIKE, true, keywords);
			}else if(type==2){
				sql = StringUtil.replace(sql, "LOWER(a.fullName)","lower(a.email)");
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.email)", StringPool.LIKE, true, keywords);
			}else if(type==3){
				sql = StringUtil.replace(sql, "LOWER(a.fullName)", "lower(a.body)");
				//(sql, "LOWER(a.fullName)","lower(a.body)");
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.body)", StringPool.LIKE, true, keywords);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("commentId", Type.LONG);
			q.addScalar("distributionId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.addScalar("email", Type.STRING);
			q.addScalar("body", Type.STRING);
			q.addScalar("createDate", Type.STRING);
			q.addScalar("autoId", Type.LONG);
			q.addScalar("visible", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}
			qPos.add(keywords);
			return (List) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public List customSearchByC_G_F_E_B(long companyId, long groupId, String[] fullNames, String[] emails,
			String[] body, boolean andOperator, int start, int end) throws PortalException, SystemException{

		fullNames = CustomSQLUtil.keywords(fullNames);
		emails = CustomSQLUtil.keywords(emails);
		body = CustomSQLUtil.keywords(body);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(CUSTOM_SEARCH_BY_KEYWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(a.groupId = ?) AND", StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.fullName)", StringPool.LIKE, false, fullNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.email)", StringPool.LIKE, false, emails);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.body)", StringPool.LIKE, true, body);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("commentId", Type.LONG);
			q.addScalar("distributionId", Type.LONG);
			q.addScalar("title", Type.STRING);
			q.addScalar("fullName", Type.STRING);
			q.addScalar("email", Type.STRING);
			q.addScalar("body", Type.STRING);
			q.addScalar("createDate", Type.STRING);
			q.addScalar("autoId", Type.LONG);
			q.addScalar("visible", Type.BOOLEAN);
			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(fullNames, 2);
			qPos.add(emails, 2);
			qPos.add(body, 2);

			return (List) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	public int customCountByKeywords(long companyId, long groupId, String keywords, int type) throws PortalException, SystemException{
		String[] fullName = null;
		String[] email = null;
		String[] body = null;
		boolean andOperator = true;

		if (Validator.isNotNull(keywords)) {
			fullName = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			email = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			body = new String[]{"%" + StringUtil.toLowerCase(keywords) + "%"};
			andOperator = false;
		} 
		if(type==0)
			return customCountByC_G_F_N_D(companyId, groupId, fullName, email, body, andOperator);
		else
			return customCountOneFieldByC_G_F_N_D(companyId, groupId, fullName, type);
	}
	public int customCountByC_G_F_N_D(long companyId, long groupId, String[] feedIds, String[] names, String[] descriptions,
			boolean andOperator) throws PortalException, SystemException{

		feedIds = CustomSQLUtil.keywords(feedIds);
		names = CustomSQLUtil.keywords(names);
		descriptions = CustomSQLUtil.keywords(descriptions);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(CUSTOM_COUNT_BY_KEYWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", StringPool.BLANK);
			}

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.fullName)", StringPool.LIKE, false, feedIds);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.email)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.body)", StringPool.LIKE, true, descriptions);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(feedIds, 2);
			qPos.add(names, 2);
			qPos.add(descriptions, 2);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int customCountOneFieldByC_G_F_N_D(long companyId, long groupId, String[] searchKeywords, int type) throws PortalException, SystemException{

		searchKeywords = CustomSQLUtil.keywords(searchKeywords);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(CUSTOM_COUNT_ONE_FIELD_BY_KEWORD_SQL);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", StringPool.BLANK);
			}

			if(type==1){
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.fullName)", StringPool.LIKE, true, searchKeywords);
			}else if(type==2){
				sql = StringUtil.replace(sql, "LOWER(a.fullName)","lower(a.email)");
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.email)", StringPool.LIKE, true, searchKeywords);
			}else if(type==3){
				sql = StringUtil.replace(sql, "LOWER(a.fullName)","lower(a.body)");
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(a.body)", StringPool.LIKE, true, searchKeywords);
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(searchKeywords);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	private static final Log LOG = LogFactoryUtil.getLog(CommentFinderImpl.class);
}