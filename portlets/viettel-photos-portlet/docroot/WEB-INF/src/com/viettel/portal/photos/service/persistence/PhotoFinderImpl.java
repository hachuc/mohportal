package com.viettel.portal.photos.service.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.photos.model.Photo;
import com.viettel.portal.photos.model.impl.PhotoImpl;
import com.viettel.portal.photos.service.persistence.PhotoFinderImpl;

public class PhotoFinderImpl extends BasePersistenceImpl<Photo> implements PhotoFinder {
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = PhotoFinder.class
			.getName() + ".finder";
	private static final String COUNT_BY_KEYWORD_SQL_STR_ID = PhotoFinder.class
			.getName() + ".count";
	
	public List<Photo> findByAlbumIds(Long groupId, List<Long> categoryIds){
		Session session = null;
		try {
			session = openSession();
			List<Object> params = new ArrayList<Object>();
			params.add(groupId);
			String sqlStr = "SELECT * FROM portal_photo pp WHERE pp.status = 1 AND pp.groupId = ? ";
			if(categoryIds != null && !categoryIds.isEmpty()){
				sqlStr += " AND pp.categoryId in (";
				for (Long id : categoryIds) {
					sqlStr += "?" + (categoryIds.indexOf(id) < categoryIds.size() - 1 ? "," : "");
					params.add(id);
				}
				sqlStr += ")";
			}

			SQLQuery query = session.createSQLQuery(sqlStr);
			query.addEntity("portal_photo", PhotoImpl.class);

			QueryPos queryPost = QueryPos.getInstance(query);
			for (Object param : params) {
				queryPost.add(param);
			}
			return (List<Photo>) query.list();
		} catch (Exception e) {
			_log.error(e);
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	public List<Photo> findPhotos(Long groupId, String keyword, long categoryId, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
				if(keyword == null || keyword.isEmpty()){
					sqlStr = sqlStr.replace("AND lower(pp.caption) LIKE ?", StringPool.BLANK);
				}
				if(categoryId < 0){
					sqlStr = sqlStr.replace("AND pp.categoryId = ?", StringPool.BLANK);
				}

				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_photo", PhotoImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword + "%");
				}
				if(categoryId >= 0){
					queryPost.add(categoryId);
				}

				if (start >= 0 && end >= 0) {
					return (List<Photo>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<Photo>) query.list();
				}
			} catch (Exception e) {
				_log.error(e);
				return Collections.emptyList();
			} finally {
				closeSession(session);
			}

		} else {
			return Collections.emptyList();
		}
	}

	public int countPhotos(Long groupId, String keyword, long categoryId){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = CustomSQLUtil.get(COUNT_BY_KEYWORD_SQL_STR_ID);
				if(keyword == null || keyword.isEmpty()){
					sqlStr = sqlStr.replace("AND lower(pp.caption) LIKE ?", StringPool.BLANK);
				}
				if(categoryId < 0){
					sqlStr = sqlStr.replace("AND pp.categoryId = ?", StringPool.BLANK);
				}

				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addScalar("TOTAL", Type.LONG);
				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword + "%");
				}
				if(categoryId >= 0){
					queryPost.add(categoryId);
				}
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

		} else {
			return 0;
		}
	}
	private final static Log _log = LogFactoryUtil
			.getLog(PhotoFinderImpl.class);
}
