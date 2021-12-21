package edu.java.jdbc05;

import java.util.Date;

// MVC(Model-View-Controller) 아키텍쳐에서 Model에 해당하는 클래스
public class Blog {
	// 멤버 변수
	private int blogNo; // blog_no 컬럼
	private String title; // title 컬럼
	private String content; // content 컬럼
	private Date updateTime; // update_time 컬럼
	// 생성자
	public Blog(int blogNo, String title, String content, Date updateTime) {
		this.blogNo = blogNo;
		this.title = title;
		this.content = content;
		this.updateTime = updateTime;
	}
	// getters & setters
	public int getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	// toString()
	@Override
	public String toString() {
		return "Blog [blogNo=" + blogNo + ", title=" + title + ", content=" + content + ", updateTime=" + updateTime
				+ "]";
	}
	
}
