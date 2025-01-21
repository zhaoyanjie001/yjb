package com.yjb.business.app.dto;

import java.sql.Date;

import org.apache.commons.net.ntp.TimeStamp;

public class ResponseNewsDto {
	private String dt;
	private String url;
	private String news;
	private String title;
	private String type;
	private Date date;
	private TimeStamp time;
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TimeStamp getTime() {
		return time;
	}
	public void setTime(TimeStamp time) {
		this.time = time;
	}
	
	
}
