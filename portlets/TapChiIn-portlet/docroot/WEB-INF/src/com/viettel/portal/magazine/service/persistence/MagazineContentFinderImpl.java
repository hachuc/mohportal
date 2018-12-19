package com.viettel.portal.magazine.service.persistence;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.magazine.model.Magazine;
import com.viettel.portal.magazine.model.MagazineContent;
import com.viettel.portal.magazine.model.impl.MagazineContentImpl;
import com.viettel.portal.magazine.model.impl.MagazineImpl;
import com.viettel.portal.magazine.service.persistence.MagazineFinder;

public class MagazineContentFinderImpl extends BasePersistenceImpl<MagazineContent> implements MagazineContentFinder {
	
	public List<MagazineContent> getOlderContent(int ID, int MagazineID, int MagazineZoneID, int SortOrder) {

		Session session = null;

		try {
			session = openSession();

			String sqlStr = CustomSQLUtil.get(GetOlderContent);

			SQLQuery query = session.createSQLQuery(sqlStr);

			query.addEntity("MagazineContent", MagazineContentImpl.class);
			
			QueryPos queryPost = QueryPos.getInstance(query);
			queryPost.add(MagazineID);
			queryPost.add(MagazineZoneID);
			queryPost.add(SortOrder);

			return (List<MagazineContent>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	
	public List<MagazineContent> getNewerContent(int ID, int MagazineID, int MagazineZoneID, int SortOrder) {

		Session session = null;

		try {
			session = openSession();

			String sqlStr = CustomSQLUtil.get(GetNewerContent);

			SQLQuery query = session.createSQLQuery(sqlStr);

			query.addEntity("MagazineContent", MagazineContentImpl.class);
			
			QueryPos queryPost = QueryPos.getInstance(query);
			queryPost.add(MagazineID);
			queryPost.add(MagazineZoneID);
			queryPost.add(SortOrder);

			return (List<MagazineContent>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			closeSession(session);
		}
	}
	
	private static final String GetOlderContent = MagazineContentFinder.class
			.getName() + ".getOlderContent";
	private static final String GetNewerContent = MagazineContentFinder.class
			.getName() + ".getNewerContent";
}
