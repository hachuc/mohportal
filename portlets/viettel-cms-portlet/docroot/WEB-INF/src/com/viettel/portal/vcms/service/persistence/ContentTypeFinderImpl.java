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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.vcms.model.ContentType;
import com.viettel.portal.vcms.model.Distribution;
import com.viettel.portal.vcms.model.impl.ContentTypeImpl;
import com.viettel.portal.vcms.model.impl.DistributionImpl;

public class ContentTypeFinderImpl extends BasePersistenceImpl<ContentType> implements ContentTypeFinder {
	public static final String FINDER_BY_NAME_SQL = ContentTypeFinder.class.getName()
			+ ".searchByName";
	public static final String COUNT_BY_NAME_SQL = ContentTypeFinder.class.getName()
			+ ".countByName";
	public List<ContentType> findByName(long groupId, String keyword, int start, int end) throws PortalException, SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FINDER_BY_NAME_SQL);
			if(keyword == null || keyword.isEmpty()){
				sql = sql.replace("AND (lower(a1.name) LIKE ? )", StringPool.BLANK);
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("ContentType", ContentTypeImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if(keyword != null && !keyword.isEmpty()){
				qPos.add("%" + keyword + "%");
			}
			
			return (List<ContentType>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countByName(long groupId, String keyword) throws PortalException, SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_NAME_SQL);
			if(keyword == null || keyword.isEmpty()){
				sql = sql.replace("AND (lower(a1.name) LIKE ?)", StringPool.BLANK);
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(groupId);
			if(keyword != null && !keyword.isEmpty()){
				qPos.add("%" + keyword + "%");
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
	private static final Log LOG = LogFactoryUtil
			.getLog(ContentTypeFinderImpl.class);
}
