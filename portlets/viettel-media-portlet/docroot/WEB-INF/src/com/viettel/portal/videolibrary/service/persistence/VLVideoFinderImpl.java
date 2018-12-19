package com.viettel.portal.videolibrary.service.persistence;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.viettel.portal.videolibrary.model.VLVideo;
import com.viettel.portal.videolibrary.model.impl.VLVideoImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VLVideoFinderImpl extends BasePersistenceImpl<VLVideo> implements
		VLVideoFinder {

	public long countByKeyword(long groupId, long categoryId, String keyword) {

		if (groupId > 0) {

			Session session = null;

			try {
				session = openSession();

				String sqlStr = CustomSQLUtil.get(COUNT_BY_KEYWORD_SQL_STR_ID);

				if (categoryId < 0L) {
					sqlStr = StringUtil.replace(sqlStr,
							"AND (portal_video.categoryId = ?)",
							StringPool.BLANK);
				}

				SQLQuery query = session.createSQLQuery(sqlStr);

				query.addScalar("TOTAL", Type.LONG);

				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);

				if (categoryId >= 0) {
					queryPost.add(categoryId);
				}
				if(keyword == null){
					keyword = "";
				}
				queryPost.add("%" + keyword.toLowerCase().trim() + "%");
				queryPost.add("%" + keyword.toLowerCase().trim() + "%");

				Iterator<Long> itr = query.iterate();

				if (itr.hasNext()) {
					Long count = itr.next();

					if (count != null) {
						return count.intValue();
					}
				}

				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				closeSession(session);
			}

		} else {
			return 0;
		}
	}

	public List<VLVideo> findByKeyword(long groupId, long categoryId,
			String keyword, int start, int end, OrderByComparator obc) {

		if (groupId > 0) {

			Session session = null;

			try {
				session = openSession();

				String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);

				if (categoryId < 0L) {
					sqlStr = StringUtil.replace(sqlStr,
							"AND (portal_video.categoryId = ?)",
							StringPool.BLANK);
				}

				sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);

				SQLQuery query = session.createSQLQuery(sqlStr);

				query.addEntity("VLVideo", VLVideoImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);

				if (categoryId >= 0) {
					queryPost.add(categoryId);
				}
				if(keyword == null){
					keyword = "";
				}
				queryPost.add("%" + keyword.toLowerCase().trim() + "%");
				queryPost.add("%" + keyword.toLowerCase().trim() + "%");

				if (start >= 0 && end >= 0) {

					return (List<VLVideo>) QueryUtil.list(query, getDialect(),
							start, end);

				} else {

					return (List<VLVideo>) query.list();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Collections.emptyList();
			} finally {
				closeSession(session);
			}

		} else {
			return Collections.emptyList();
		}
	}

	private static final String FIND_BY_KEYWORD_SQL_STR_ID = VLVideoFinder.class
			.getName() + ".findByKeyword";

	private static final String COUNT_BY_KEYWORD_SQL_STR_ID = VLVideoFinder.class
			.getName() + ".countByKeyword";

}
