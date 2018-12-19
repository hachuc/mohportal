package com.viettel.portal.banner.util;

import com.liferay.portal.kernel.util.StringPool;

public class BannerConstants {

	public static final int DEFAULT_BANNER_FRAME_WIDTH = 340;
	
	public static final int DEFAULT_BANNER_FRAME_HEIGHT = 200;
	
	public static final long DEFAULT_BANNER_MAX_SIZE = 200000000;
	
	public static final long DEFAULT_IMAGE_THUMBNAIL_MAX_SIZE = 5;
	
	public static final long FILE_SIZE_COEFFICENT = 1048576; //== 2^10 * 2^10 == 1024 * 1024
	
	public static final String INTERNAL_BANNER_TYPE="internal";
	
	public static final String EXTERNAL_BANNER_TYPE="external";
	
	public static final String[] DEFAULT_BANNER_EXTENSIONS = {".flv",".mp4"};
	
	public static final String[] DEFAULT_IMAGE_THUMBNAIL_EXTENSIONS = {".gif",".jpeg",".jpg",".png"};
	
	public static final String PERCENT=StringPool.PERCENT;
	
	public static final String PIXEL="px";
	
}
