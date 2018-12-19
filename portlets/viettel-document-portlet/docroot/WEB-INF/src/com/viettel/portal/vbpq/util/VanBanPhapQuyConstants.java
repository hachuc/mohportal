package com.viettel.portal.vbpq.util;

public class VanBanPhapQuyConstants {
	public static final String[] DEFAULT_VANBAN_EXTENSIONS = { ".doc", ".pdf", ".docx",".rar",".zip" };
	
	public static final long FILE_SIZE_COEFFICENT = 1048576; //== 2^10 * 2^10 == 1024 * 1024
	
	public static final long DEFAULT_VANBAN_MAX_SIZE = 20;
	
	public static final int STATUS_PUBLISH = 0;
	
	public static final int STATUS_DRAFT = 1;
	
	public static final boolean TRANGTHAI_NEVER_EXPIRE = true;
	
	public static final boolean TRANGTHAI_EXPIRE = false;
}
