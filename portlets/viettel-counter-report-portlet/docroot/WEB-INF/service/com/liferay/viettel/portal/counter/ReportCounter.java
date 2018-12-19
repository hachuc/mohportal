package com.liferay.viettel.portal.counter;
import java.util.Date;

public class ReportCounter {
	//ev.data_ as mark, ja.articleId, ja.userId, ja.userName, ja.urlTitle, ja.createDate, ja.status
	private long entryId;
	private String title;
	private Date publishDate;
	private long total;
	private String assetUrl;

	public long getEntryId() {
		return entryId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public Date getPublishDate(){
		return publishDate;
	}
	public void setPublishDate(Date publishDate){
		this.publishDate = publishDate;
	}
	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	public String getAssetUrl(){
		return assetUrl;
	}
	public void setAssetUrl(String assetUrl){
		this.assetUrl = assetUrl;
	}
}