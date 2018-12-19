package com.viettel.portal.banner.service.persistence;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.viettel.portal.banner.model.Banner;
import com.viettel.portal.banner.model.impl.BannerImpl;
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

public class BannerFinderImpl extends BasePersistenceImpl<Banner> implements BannerFinder{
	private static final String FIND_BY_KEYWORD_SQL_STR_ID = BannerFinder.class
			.getName() + ".finder";
	private static final String COUNT_BY_KEYWORD_SQL_STR_ID = BannerFinder.class
			.getName() + ".count";

	public List<Banner> findBannersByIds(List<Long> ids){
		if(ids == null || ids.isEmpty()){
			return Collections.emptyList();
		}
		Session session = null;
		try {
			session = openSession();
			String sqlStr = "SELECT * FROM portal_banner p WHERE p.id in (";
			for(Long id : ids){
				sqlStr += "?,";
			}
			sqlStr = sqlStr.substring(0, sqlStr.length() - 1);
			sqlStr += ") order by p.order_ desc";

			SQLQuery query = session.createSQLQuery(sqlStr);
			query.addEntity("portal_banner", BannerImpl.class);

			QueryPos queryPost = QueryPos.getInstance(query);
			for(Long id : ids){
				queryPost.add(id);
			}
			return (List<Banner>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	public List<Banner> findBanners(Long groupId, String keyword, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = CustomSQLUtil.get(FIND_BY_KEYWORD_SQL_STR_ID);
				if(keyword == null || keyword.isEmpty()){
					sqlStr = sqlStr.replace("AND lower(pl.TEN) LIKE ?", StringPool.BLANK);
				}
				//sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);

				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_banner", BannerImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword + "%");
				}

				if (start >= 0 && end >= 0) {
					return (List<Banner>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<Banner>) query.list();
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

	public int countBanners(Long groupId, String keyword){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = CustomSQLUtil.get(COUNT_BY_KEYWORD_SQL_STR_ID);
				if(keyword == null || keyword.isEmpty()){
					sqlStr = sqlStr.replace("AND lower(pl.TEN) LIKE ?", StringPool.BLANK);
				}

				//sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);

				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addScalar("TOTAL", Type.LONG);
				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword + "%");
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
				e.printStackTrace();
				return 0;
			} finally {
				closeSession(session);
			}

		} else {
			return 0;
		}
	}
}
