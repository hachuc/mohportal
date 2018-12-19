package com.viettel.portal.thongke.service.persistence;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.model.PhongBanNhuanBut;
import com.viettel.portal.thongke.model.impl.PhongBanNhuanButImpl;

public class PhongBanNhuanButFinderImpl  extends BasePersistenceImpl<PhongBanNhuanBut> implements PhongBanNhuanButFinder {
	SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
	public List<PhongBanNhuanBut> findPhongBanNhuanButs(long groupId, String keyword,Date fromDate,Date toDate, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT * FROM portal_phongbannhuanbut p  WHERE p.status = 1 AND p.groupId = ? ";
				
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',p.createDate)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,p.createDate,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.name) LIKE ?"; 
				}
				
				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_phongbannhuanbut", PhongBanNhuanButImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				
				if (start >= 0 && end >= 0) {
					return (List<PhongBanNhuanBut>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<PhongBanNhuanBut>) query.list();
				}
			} catch (Exception e) {
				_log.error(e);
				return Collections.emptyList();
			} finally {
				closeSession(session);
			}

		} else {
			return  Collections.emptyList();
		}
	}
	public int countPhongBanNhuanButs(long groupId, String keyword,Date fromDate,Date toDate){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT convert(bigint,count(p.id_)) FROM portal_phongbannhuanbut p  WHERE p.status = 1 AND p.groupId = ? ";
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',p.createDate)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,p.createDate,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.name) LIKE ?"; 
				}
				SQLQuery query = session.createSQLQuery(sqlStr);
				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				Iterator<java.math.BigInteger> itr = query.list().iterator();
				if (itr.hasNext()) {
					Long count = itr.next().longValue();
					return count.intValue();
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
			.getLog(PhongBanNhuanButFinderImpl.class);
}
