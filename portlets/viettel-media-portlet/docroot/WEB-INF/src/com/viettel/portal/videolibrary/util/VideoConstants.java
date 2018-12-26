package com.viettel.portal.videolibrary.util;

import com.liferay.portal.kernel.util.StringPool;

public class VideoConstants {

	public static final int DEFAULT_VIDEO_FRAME_WIDTH = 340;
	
	public static final int DEFAULT_VIDEO_FRAME_HEIGHT = 200;
	
	public static final long DEFAULT_VIDEO_MAX_SIZE = 200000000;
	
	public static final long DEFAULT_IMAGE_THUMBNAIL_MAX_SIZE = 5;
	
	public static final long FILE_SIZE_COEFFICENT = 1048576; //== 2^10 * 2^10 == 1024 * 1024
	
	public static final String INTERNAL_VIDEO_TYPE="internal";
	
	public static final String EXTERNAL_VIDEO_TYPE="external";
	
	public static final String INTERNAL_NAME="Cấp trung ương";
	
	public static final String EXTERNAL_NAME="Cấp địa phương";
	
	protected static final String[] DEFAULT_FILE_EXTENSIONS = {".pdf",".xlsx",".xls",".rar",".zip"};
	
	protected static final String[] DEFAULT_IMAGE_THUMBNAIL_EXTENSIONS = {".gif",".jpeg",".jpg",".png"};
	
	public static final String PERCENT=StringPool.PERCENT;
	
	public static final String PIXEL="px";
	
}
