package com.viettel.portal.links.service.persistence;

import java.util.ArrayList;
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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.links.model.VLink;
import com.viettel.portal.links.model.impl.VLinkImpl;
import com.viettel.portal.links.service.persistence.VLinkFinderImpl;
import com.viettel.portal.links.VLinkGrid;

public class VLinkFinderImpl extends BasePersistenceImpl<VLink> implements VLinkFinder{
	public VLinkGrid findByKeyword(long groupId, long categoryId, String keyword, int start, int end, OrderByComparator obc) throws PortalException,
		SystemException {
		Session session = null;
		try {
			List<Object> params = new ArrayList<Object>();
			VLinkGrid grid = new VLinkGrid();
			session = openSession();
			String sqlStr = " FROM portal_link pc WHERE pc.isActive = 1 "
					+ " AND pc.groupId = ? AND pc.categoryId = ? AND lower(pc.linkName) like ? "
					+ "";
			params.add(groupId);
			params.add(categoryId);
			params.add("%" + (keyword == null ? "" : keyword.toLowerCase().trim()) +  "%"  );
			
			SQLQuery query = session.createSQLQuery("SELECT count(*) as TOTAL " + sqlStr);
			query.addScalar("TOTAL", Type.LONG);
			QueryPos queryPost = QueryPos.getInstance(query);
			for (Object param : params) {
				queryPost.add(param);
			}
			
			int total = 0;
			Iterator<Long> itr = query.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					total = count.intValue();
				}
			}
			if(total > 0){
				sqlStr = "SELECT * " + sqlStr + " order by corder desc ";
				if(obc != null){
					sqlStr = CustomSQLUtil.replaceOrderBy(sqlStr, obc);
				}
				query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_link", VLinkImpl.class);
				queryPost = QueryPos.getInstance(query);
				for (Object param : params) {
					queryPost.add(param);
				}	
				List<VLink> list;
				if (start >= 0 && end >= 0) {
					list = (List<VLink>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					list = (List<VLink>) query.list();
				}	
				grid.setList(list);
			}
			return grid;
		} catch (Exception e) {
			LOG.error(e);
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}		
	}
	private static final Log LOG = LogFactoryUtil.getLog(VLinkFinderImpl.class);
}
