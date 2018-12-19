package com.portal_egov.portlet.legal_faq.service.persistence;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.portal_egov.portlet.legal_faq.model.Feedback;
import com.portal_egov.portlet.legal_faq.model.impl.FeedbackImpl;

public class FeedbackFinderImpl extends BasePersistenceImpl<Feedback> implements FeedbackFinder{
	public List<Feedback> findByKeyword(long groupId, String keyword, int start, int end){
		
		if(groupId > 0){
			
			Session session = null;
			
			try{
			    session = openSession();
			
			    //String sqlStr =FIND_BY_KEYWORD_SQL_FEEBACK;
			    /*f.feedbackId, f.groupId,"
			    		+ " f.companyId, f.userId,"
			    		+ " f.userName, f.createDate, f.modifiedDate,"
			    		+ " f.title, f.summary, f.body,"
			    		+ " f.fullName, f.workFor, f.address,"
			    		+ " f.phone, f.email, f.fileId,"
			    		+ " f.fileSize, f.fileName, f.fileURL"
			    		+ " f.ipAddress*/			    
			    String sqlStr ="SELECT * "
			    		+ " FROM 	vcms_feedback f"
			    		+ " WHERE   (f.groupId = ?)"
			    		+ " AND ((f.title LIKE ?)"
			    		+ " OR (f.summary LIKE ?)"
			    		+ " OR (f.body LIKE ?)"
			    		+ " OR (f.fullName LIKE ?)"
			    		+ " OR (f.email LIKE ?)"
			    		+ " OR (f.phone LIKE ?)"
			    		+ " OR (f.userName LIKE ?)"
			    		+ " OR (f.fileName LIKE ?))"
			    		+ " ORDER BY f.createDate DESC";
			    
			    if(keyword.equals("") && keyword.isEmpty()){
					sqlStr = sqlStr.replace(" AND ((f.title LIKE ?)"
				    		+ " OR (f.summary LIKE ?)"
				    		+ " OR (f.body LIKE ?)"
				    		+ " OR (f.fullName LIKE ?)"
				    		+ " OR (f.email LIKE ?)"
				    		+ " OR (f.phone LIKE ?)"
				    		+ " OR (f.userName LIKE ?)"
				    		+ " OR (f.fileName LIKE ?))", StringPool.BLANK);
				}
			    
			    SQLQuery query = session.createSQLQuery(sqlStr);
			    
			    query.addEntity("Feedback", FeedbackImpl.class);
			    
			    QueryPos queryPost = QueryPos.getInstance(query);

			    queryPost.add(groupId);
			    if(!keyword.isEmpty() && !keyword.equals("")){
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
			    }
			    if(start >= 0 && end >= 0){
			    	
			    	return (List<Feedback>) QueryUtil.list(query, getDialect(), start, end);
			    
			    }else{
			    	
			    	return (List<Feedback>) query.list();
			    }
			}catch (Exception e){
				e.printStackTrace();
			    return Collections.emptyList();
			}finally{
			    closeSession(session);
			}
		}else{
			
			return Collections.emptyList();
		}
	}
	
	public int countFeedbacks(long groupId, String keyword){
		if (groupId > 0) {
			Session session = null;
			try {
				session = openSession();
				String sqlStr ="select count(*) as total from"
						+ "	(SELECT * FROM vcms_feedback f"
			    		+ " WHERE (f.groupId = ?)"
			    		+ " AND ((f.title LIKE ?)"
			    		+ " OR (f.summary LIKE ?)"
			    		+ " OR (f.body LIKE ?)"
			    		+ " OR (f.fullName LIKE ?)"
			    		+ " OR (f.email LIKE ?)"
			    		+ " OR (f.phone LIKE ?)"
			    		+ " OR (f.userName LIKE ?)"
			    		+ " OR (f.fileName LIKE ?))) as TMP";
			    
			    if(keyword.equals("") && keyword.isEmpty()){
					sqlStr = sqlStr.replace(" AND ((f.title LIKE ?)"
				    		+ " OR (f.summary LIKE ?)"
				    		+ " OR (f.body LIKE ?)"
				    		+ " OR (f.fullName LIKE ?)"
				    		+ " OR (f.email LIKE ?)"
				    		+ " OR (f.phone LIKE ?)"
				    		+ " OR (f.userName LIKE ?)"
				    		+ " OR (f.fileName LIKE ?))", StringPool.BLANK);
				}


				SQLQuery query = session.createSQLQuery(sqlStr);
				query.addScalar("TOTAL", Type.LONG);
				QueryPos queryPost = QueryPos.getInstance(query);

				queryPost.add(groupId);
				if(!keyword.isEmpty() && !keyword.equals("")){
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
				    queryPost.add("%" + keyword + "%");
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
	
	private static final String FIND_BY_KEYWORD_SQL_FEEBACK = "com.portal_egov.portlet.legal_faq.service.persistence.FeedbackFinder.findByKeyword";

}
