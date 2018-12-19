package com.viettel.portal.thongke.service.persistence;

import java.text.DateFormat;
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
import com.viettel.portal.thongke.model.BaiVietNhuanBut;
import com.viettel.portal.thongke.model.ContentProfit;
import com.viettel.portal.thongke.model.impl.BaiVietNhuanButImpl;
import com.viettel.portal.thongke.model.impl.ContentProfitImpl;
import com.viettel.portal.thongke.model.impl.PhongBanImpl;

public class BaiVietNhuanButFinderImpl extends BasePersistenceImpl<BaiVietNhuanBut> implements BaiVietNhuanButFinder{
	SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
	public List<BaiVietNhuanBut> findBaiVietNhuanButs(int type,Long groupId, String keyword,Date fromDate,Date toDate, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT * FROM portal_baivietnhuanbut p WHERE p.groupId = ? ";
				if(type>0){
					sqlStr += " AND p.type_="+type;
				}
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',p.ngayXuatBan)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,p.ngayXuatBan,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.tieuDe) LIKE ?";
				}
				
				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addEntity("portal_baivietnhuanbut", BaiVietNhuanButImpl.class);

				QueryPos queryPost = QueryPos.getInstance(query);
				queryPost.add(groupId);
				if(keyword != null && !keyword.isEmpty()){
					queryPost.add("%" + keyword.toLowerCase() + "%");
				}
				
				if (start >= 0 && end >= 0) {
					return (List<BaiVietNhuanBut>) QueryUtil.list(query, getDialect(), start, end);
				} else {
					return (List<BaiVietNhuanBut>) query.list();
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
	public List<Object> findBaiVietRatings(long classTypeId,int type,long groupId, String keyword,Date fromDate,Date toDate, int start, int end){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT J.articleId,J.title,A.publishDate,convert(nvarchar(4000),J.content) content ,isnull(K.rating,'') rating,isnull(K.ratingValue,0) ratingValue  FROM AssetEntry A inner join JournalArticle J ";
				sqlStr+=" on  A.classPK=J.resourcePrimKey And A.groupId=J.groupId and A.companyId=J.companyId ";
				if(classTypeId>0)sqlStr+=" and A.classTypeId = "+classTypeId;
				sqlStr+=" left join portal_baivietnhuanbut K on J.groupId=K.groupId and J.companyId=K.companyId ";
				if(type>0)sqlStr+=" and K.type_="+type;
				sqlStr+=" and J.articleId=convert(nvarchar(75),K.baiVietId)  where  A.publishDate is not null ";
				sqlStr+=" and [version]=(select top 1 [version] from JournalArticle J1 where J.articleId=J1.articleId  order by [version] desc) ";

				sqlStr+=" and A.groupId = ? ";
				
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',A.publishDate)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,A.publishDate,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(J.title) LIKE ?"; 
				}
				
				SQLQuery query = session.createSQLQuery(sqlStr);
				//query.addEntity("portal_phongban", PhongBanImpl.class);
				query.setCacheable(false);
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
	public int countBaiVietNhuanButs(int type,Long groupId, String keyword,Date fromDate,Date toDate){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT count(p.id_) FROM portal_baivietnhuanbut p WHERE p.groupId = ? ";
				if(type>0)sqlStr += " AND p.type_="+type;;
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',p.ngayXuatBan)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,p.ngayXuatBan,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(p.tieuDe) LIKE ?";
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
	public int countBaiVietRatings(long classTypeId,int type,long groupId, String keyword,Date fromDate,Date toDate){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr = "SELECT  count(J.articleId)  FROM AssetEntry A inner join JournalArticle J ";
				sqlStr+=" on  A.classPK=J.resourcePrimKey And A.groupId=J.groupId and A.companyId=J.companyId ";
				if(classTypeId>0)sqlStr+=" and A.classTypeId = "+classTypeId;
				sqlStr+=" left join portal_baivietnhuanbut K on J.groupId=K.groupId and J.companyId=K.companyId ";
				if(type>0)sqlStr+=" and K.type_="+type;
				sqlStr+=" and J.articleId=convert(nvarchar(75),K.baiVietId)  where  A.publishDate is not null ";
				sqlStr+=" and [version]=(select top 1 [version] from JournalArticle J1 where J.articleId=J1.articleId  order by [version] desc) ";

				sqlStr+=" and A.groupId = ? ";
				if(fromDate!=null){
					sqlStr += " AND datediff(day,'"+dft.format(fromDate)+"',A.publishDate)>=0 "; 
				}
				if(toDate!=null){
					sqlStr += " AND datediff(day,A.publishDate,'"+dft.format(toDate)+"')>=0 "; 
				}
				if(keyword != null && !keyword.isEmpty()){
					sqlStr += " AND lower(J.title) LIKE ?"; 
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
	public List<Object> findBaiVietNhuanButBySQL(String sql,int start,int end){
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			//query.addEntity("portal_phongban", PhongBanImpl.class);
			//query.setCacheable(false);
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
    }
	public int countBaiVietNhuanButBySQL(String sql){
		
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
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
	
	}
	private final static Log _log = LogFactoryUtil
			.getLog(BaiVietNhuanButFinderImpl.class);
	
}
		

