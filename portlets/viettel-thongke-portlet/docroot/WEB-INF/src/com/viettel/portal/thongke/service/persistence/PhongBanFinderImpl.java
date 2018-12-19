package com.viettel.portal.thongke.service.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.viettel.portal.thongke.model.PhongBan;
import com.viettel.portal.thongke.model.PhongBanRating;
import com.viettel.portal.thongke.model.impl.PhongBanImpl;

public class PhongBanFinderImpl extends BasePersistenceImpl<PhongBan> implements PhongBanFinder{
	SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
	public List<PhongBan> findPhongBans(Long groupId, String keyword, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT * FROM portal_phongban p WHERE p.status = 1 AND p.groupId = ? ";
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.name) LIKE ?";
				}
				
				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_phongban", PhongBanImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				
				if (start >= 0 && end >= 0) {
					return (List<PhongBan>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<PhongBan>) query.list();
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
	public List<Object> findPhongBanRatings(long phongBanNhuanButId,long groupId, String keyword,Date fromDate,Date toDate, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "";
				if(phongBanNhuanButId>0){
					sqlStr = "SELECT p.id_ phongBanId,p.name phonBanTen, p.createDate ngayTao,p.userName nguoiTao,isnull(A.rating,'') rating,isnull(A.ratingValue,0) ratingValue FROM portal_phongban p ";
					sqlStr+=" left join portal_phongbannhuanbutchitiet A on p.id_ =A.phongBanId "+ " and A.phongBanNhuanButId="+phongBanNhuanButId;
					sqlStr+=" WHERE p.status = 1 AND p.groupId = ? ";
				}
				else{
					sqlStr = "SELECT p.id_ phongBanId,p.name phonBanTen, p.createDate ngayTao,p.userName nguoiTao,'' rating,convert(float,0) ratingValue FROM portal_phongban p ";
					sqlStr+=" WHERE p.status = 1 AND p.groupId = ? ";
				}
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
				//query.addEntity("portal_phongban", PhongBanImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				
				if (start >= 0 && end >= 0) {
					return (List<Object>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<Object>) query.list();
				}
			} catch (Exception e) {
				_log.error(e);
				return null;//Collections.emptyList();
			} finally {
				closeSession(session);
			}

		} else {
			return  null;//Collections.emptyList();
		}
	}
	public int countPhongBans(Long groupId, String keyword){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT count(p.id_) FROM portal_phongban p WHERE p.status = 1 AND p.groupId = ? ";
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.name) LIKE ?";
				}
				
				SQLQuery query = session.createSQLQuery(sqlStr);
				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				Iterator<Integer> itr = query.list().iterator();
				if (itr.hasNext()) {
					return itr.next().intValue();
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
	public int countPhongBanRatings(long phongBanNhuanButId,long groupId, String keyword,Date fromDate,Date toDate){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "";
				if(phongBanNhuanButId>0){
					sqlStr = "SELECT count(p.id_) FROM portal_phongban p ";
					sqlStr+=" left join portal_phongbannhuanbutchitiet A on p.id_ =A.phongBanId "+ " and A.phongBanNhuanButId="+phongBanNhuanButId;
					sqlStr+=" WHERE p.status = 1 AND p.groupId = ? ";
				}
				else{
					sqlStr = "SELECT count(p.id_)  FROM portal_phongban p ";
					sqlStr+=" WHERE p.status = 1 AND p.groupId = ? ";
				}
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
				Iterator<Integer> itr = query.list().iterator();
				if (itr.hasNext()) {
					return itr.next().intValue();
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
			.getLog(PhongBanFinderImpl.class);
}
