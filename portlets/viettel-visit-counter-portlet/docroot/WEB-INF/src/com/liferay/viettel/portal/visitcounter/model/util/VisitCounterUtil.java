/**
 * @author HiepTH6
 * @time 10:06:31 AM
 * @project visit_counter-portlet
 */
package com.liferay.viettel.portal.visitcounter.model.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.viettel.portal.visitcounter.model.VisitCounterLog;
import com.liferay.viettel.portal.visitcounter.service.VisitCounterLocalServiceUtil;
import com.liferay.viettel.portal.visitcounter.service.VisitCounterLogLocalServiceUtil;


public class VisitCounterUtil {


	public static int getTotalVisitCounter(long groupId){
		
		try {
			
			return VisitCounterLocalServiceUtil.getCounterValue(groupId);
		}
		catch (SystemException e) {
			_log.error(e);
			return DEFAULT_TOTAL_VISIT_COUNTER_VALUE;
		}
	}
	
	/**
	 * @todo Láº¥y sá»‘ lÆ°á»£ng ngÆ°á»�i Ä‘ang truy cáº­p
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return int
	 */
	public static int getOnlineVisiterCounter(){
		
		return OnlineVisitorCounter.getOnlineVisitorCounter();
	}
	
	/**
	 * @todo Cáº­p nháº­t sá»‘ liá»‡u thá»‘ng kÃª tá»•ng sá»‘ lÆ°á»£ng truy cáº­p Portal
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return void
	 */
	public static void updateCounter(long companyId,long groupId,long userId,String userName){
		
		try {
			
			VisitCounterLocalServiceUtil.incrementTotalCounter(companyId, groupId, userId, userName);
		}
		catch (SystemException e) {
			_log.error(e);
		}
	}
	
	/**
	 * @author HUNGDX	
	 * @date Dec 6, 2012
	 * @return void
	 */
	public static  void updateCounterLog(long companyId,long groupId,long userId,String userName,String visitorIp,long lastAccessPageId){
		
		try {
			
			VisitCounterLogLocalServiceUtil.incrementCounter(visitorIp, companyId, groupId, userId, userName, lastAccessPageId);
		}
		catch (SystemException e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactory.getLog(VisitCounterUtil.class);
	
	private static final int DEFAULT_TOTAL_VISIT_COUNTER_VALUE = 1;
}
