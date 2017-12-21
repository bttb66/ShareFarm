package model;

import java.sql.Date;

public class Community {
	private int postId;
	private String content;
	private String userId;
	private String title;
	private int viewNum;
	private Date regdate;
	public Community(int postId, String content, String userId, String title, int viewNum, Date regdate) {
		super();
		this.postId = postId;
		this.content = content;
		this.userId = userId;
		this.title = title;
		this.viewNum = viewNum;
		this.regdate = regdate;
	}
	public Community(int postId, String content, String userId, String title) {
		super();
		this.postId = postId;
		this.content = content;
		this.userId = userId;
		this.title = title;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Community [postId=" + postId + ", content=" + content + ", userId=" + userId + ", title=" + title
				+ ", viewNum=" + viewNum + ", regdate=" + regdate + "]";
	}
	
	
	
}
