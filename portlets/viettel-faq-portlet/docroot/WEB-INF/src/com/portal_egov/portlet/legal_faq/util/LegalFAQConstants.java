/**
 * @author ChucHV
 * @time 8:52:45 AM
 * @project legal_fag-portlet
 */
package com.portal_egov.portlet.legal_faq.util;


public class LegalFAQConstants {

	//Status mac dinh cua faq entry khi moi khoi tao (chua update noi dung tra loi)
	public static final int LEGAL_FAQ_ENTRY_DEFAULT_STATUS_VALUE = 0;
	
	//Status tuong ung voi trang thai cua faq entry khi da update cau tra loi
	public static final int LEGAL_FAQ_ENTRY_ANSWERED_STATUS_VALUE = 1;
	
	//Luot xem mac dinh khi khoi tao
	public static final int LEGAL_FAQ_ENTRY_STARTED_VIEW_COUNT_VALUE = 0;
	
	//Trang thai publish mac dinh luc khoi tao (chua publish ngoai Site)
	public static final int LEGAL_FAQ_ENTRY_UNPUBLISH_STATUS_VALUE = 0;
	
	//Trang thai publish,hien thi noi dug tren site
	public static final int LEGAL_FAQ_ENTRY_PUBLISH_STATUS_VALUE = 1;
	
	public static final String FAQ_ENTRY_COMMAND = "FAQ_ENTRY_COMMAND";
	
	public static final String UPDATE_ASK_CONTENT = "UPDATE_ASK_CONTENT";
	
	public static final String UPDATE_FAQ_ENTRY_CONTENT = "UPDATE_FAQ_ENTRY_CONTENT";
	
	public static final String UPDATE_ANSWER_CONTENT = "UPDATE_ANSWER_CONTENT";
	
	public static final String PUBLISH_FAQ_ENTRY = "PUBLISH_FAQ_ENTRY";
	
	public static final String UNPUBLISH_FAQ_ENTRY = "UNPUBLISH_FAQ_ENTRY";
	
	public static final String FAQ_ENTRY_STATUS = "FAQ_ENTRY_STATUS";
	
	public static final String FAQ_ENTRY_PUBLISH_STATUS = "FAQ_ENTRY_PUBLISH_STATUS";
	
}
