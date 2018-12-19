/**
 * @author HiepTH6
 * @time 10:18:13 AM
 * @project visit_counter-portlet
 */
package com.liferay.viettel.portal.visitcounter.model.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class OnlineVisitorCounter implements HttpSessionListener{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		ONLINE_VISITOR_COUNTER ++;
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		ONLINE_VISITOR_COUNTER -- ;
		
	}

	public static int getOnlineVisitorCounter(){
		
		if(ONLINE_VISITOR_COUNTER <= 0){
			
			ONLINE_VISITOR_COUNTER = 1;
		}
		
		return ONLINE_VISITOR_COUNTER;
	}
	
	private static int ONLINE_VISITOR_COUNTER = 1;
}
