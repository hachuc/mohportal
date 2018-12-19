package com.viettel.portal.thongke.service.persistence;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.oracle.jrockit.jfr.ContentType;
import com.sun.xml.internal.ws.encoding.ContentTypeImpl;
import com.viettel.portal.thongke.model.ContentProfit;
import com.viettel.portal.thongke.model.impl.ContentProfitImpl;

public class ContentProfitFinderImpl extends BasePersistenceImpl<ContentProfit> implements ContentProfitFinder {
	private final static Log _log = LogFactoryUtil
			.getLog(ContentProfitFinderImpl.class);
	@Override
	public List findNhuanBut(Long groupId, String fromDate, String toDate, Long tinBai, Long tacGia){
        if(groupId>0){
            Session session = null;
            try {
            	String sqlStr ="";
            	 
            	//SQLQuery queryObject = session.createSQLQuery(sqlStr);
                session = openSession();
                 sqlStr = "SELECT headline , userName , a.cost ,  b.name , distributedDate ";
                    sqlStr +="FROM vcms_content_profit a LEFT JOIN vcms_content_type b on "
                            + "a.contentTypeID = b.contenTypeID "
                            //+ "WHERE a.distributedDate>= ?  AND a.distributedDate<= ?  AND a.contentTypeID= ? "
                            + "WHERE a.distributedDate>= ?  AND a.distributedDate<= ?   ";
                            //+ "AND a.userId= ?";
                    		
                    boolean statusContent = false;
                    boolean statusUser =false;
                    if(tinBai>0){
                    	sqlStr = sqlStr +  " AND a.contentTypeID= ?";
                    	statusContent =true;
                    }
                    
                    if(tacGia>0){
                    	sqlStr = sqlStr + " AND a.userId= ?";
                    	statusUser = true;
                    }
                    SQLQuery queryObject = session.createSQLQuery(sqlStr);
                    queryObject.setCacheable(false);
                    queryObject.addScalar("headline",Type.STRING);
                    queryObject.addScalar("userName", Type.STRING);
                    queryObject.addScalar("a.cost", Type.STRING);
                    queryObject.addScalar("b.name", Type.STRING);
                    queryObject.addScalar("distributedDate", Type.STRING);
                        
                    QueryPos qPos = QueryPos.getInstance(queryObject);
                    //DateFrom
                    String dateF = "1996" ;
                    if(!"".equalsIgnoreCase(fromDate) && fromDate!=null){
                    	String[] str = fromDate.split("\\/");
                    		dateF =str[2]+"-"+str[1]+"-"+str[0];
                    }
                   //DateTo
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    String day = dateFormat.format(date);
                    String dateT=day+" 23:59:59' ";
                    if(!"".equalsIgnoreCase(toDate)&&toDate!=null){
                    	String[] str = toDate.split("\\/");
                    	dateT =str[2]+"-"+str[1]+"-"+str[0]+" 23:59:59";
                    }
                    qPos.add(dateF);
                    qPos.add(dateT);
                    if(statusContent){
                    	qPos.add(tinBai);
                    }
                    if(statusUser){
                    	qPos.add(tacGia);
                    }
                    return (List) queryObject.list();                   
            } catch (Exception e) {
            	_log.error(e);
            	return Collections.emptyList();
            }finally {
    			closeSession(session);
    		}
        }else{return Collections.emptyList();}
      }
	public List findContentProfit(Long groupId, String fromDate, String toDate, Long tinBai, Long tacGia, int start, int end){
		 if(groupId>0){
	            Session session = null;
	            try {
	                session = openSession();
	                String sqlStr = "SELECT headline , userName , a.cost ,  b.name , distributedDate ";
	                    sqlStr +="FROM vcms_content_profit a LEFT JOIN vcms_content_type b on "
	                            + "a.contentTypeID = b.contenTypeID "      
	                            + "WHERE a.distributedDate>= ?  AND a.distributedDate<= ?   ";		
	                    boolean statusContent = false;
	                    boolean statusUser =false;
	                    if(tinBai>0){
	                    	sqlStr = sqlStr +  " AND a.contentTypeID= ?";
	                    	statusContent =true;
	                    }
	                    
	                    if(tacGia>0){
	                    	sqlStr = sqlStr + " AND a.userId= ?";
	                    	statusUser = true;
	                    }
	                    sqlStr = sqlStr +" LIMIT ?,?";
	                    SQLQuery queryObject = session.createSQLQuery(sqlStr);
	                    queryObject.setCacheable(false);
	                    queryObject.addScalar("headline",Type.STRING);
	                    queryObject.addScalar("userName", Type.STRING);
	                    queryObject.addScalar("a.cost", Type.STRING);
	                    queryObject.addScalar("b.name", Type.STRING);
	                    queryObject.addScalar("distributedDate", Type.STRING);
	                        
	                    QueryPos qPos = QueryPos.getInstance(queryObject);
	                    //DateFrom
	                    String dateF = "1996" ;
	                    if(!"".equalsIgnoreCase(fromDate) && fromDate!=null){
	                    	String[] str = fromDate.split("\\/");
	                    		dateF =str[2]+"-"+str[1]+"-"+str[0];
	                    }
	                   //DateTo
	                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                    Date date = new Date();
	                    String day = dateFormat.format(date);
	                    String dateT=day+" 23:59:59' ";
	                    if(!"".equalsIgnoreCase(toDate)&&toDate!=null){
	                    	String[] str = toDate.split("\\/");
	                    	dateT =str[2]+"-"+str[1]+"-"+str[0]+" 23:59:59";
	                    }
	                    qPos.add(dateF);
	                    qPos.add(dateT);
	                    if(statusContent){
	                    	qPos.add(tinBai);
	                    }
	                    if(statusUser){
	                    	qPos.add(tacGia);
	                    }
	                    qPos.add(start);
	                    qPos.add((end-start));
	                    return (List) queryObject.list();   
	                    
	            } catch (Exception e) {
	            	_log.error(e);
	            	return Collections.emptyList();
	            }finally {
	    			closeSession(session);
	    		}
	        }else{return Collections.emptyList();}
	}
	public int countContentTotal(Long groupId, String fromDate, String toDate, Long tinBai, Long tacGia){
		if(groupId>0){
            Session session = null;
            try {
                session = openSession();
                String sqlStr = "SELECT COUNT(contentId)as total ";
                    sqlStr +="FROM vcms_content_profit a LEFT JOIN vcms_content_type b on "
                            + "a.contentTypeID = b.contenTypeID "      
                            + "WHERE a.distributedDate>= ?  AND a.distributedDate<= ?   ";		
                    boolean statusContent = false;
                    boolean statusUser =false;
                    if(tinBai>0){
                    	sqlStr = sqlStr +  " AND a.contentTypeID= ?";
                    	statusContent =true;
                    }
                    
                    if(tacGia>0){
                    	sqlStr = sqlStr + " AND a.userId= ?";
                    	statusUser = true;
                    }
                    SQLQuery queryObject = session.createSQLQuery(sqlStr);
                    queryObject.setCacheable(false);
                    queryObject.addScalar("total",Type.LONG);
                    QueryPos qPos = QueryPos.getInstance(queryObject);
                    //DateFrom
                    String dateF = "1996" ;
                    if(!"".equalsIgnoreCase(fromDate) && fromDate!=null){
                    	String[] str = fromDate.split("\\/");
                    		dateF =str[2]+"-"+str[1]+"-"+str[0];
                    }
                   //DateTo
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    String day = dateFormat.format(date);
                    String dateT=day+" 23:59:59' ";
                    if(!"".equalsIgnoreCase(toDate)&&toDate!=null){
                    	String[] str = toDate.split("\\/");
                    	dateT =str[2]+"-"+str[1]+"-"+str[0]+" 23:59:59";
                    }
                    qPos.add(dateF);
                    qPos.add(dateT);
                    if(statusContent){
                    	qPos.add(tinBai);
                    }
                    if(statusUser){
                    	qPos.add(tacGia);
                    }
                    Iterator<Long> itr = queryObject.iterate();
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
            }finally {
    			closeSession(session);
    		}
        }else{return 0;}
		
	}
}
