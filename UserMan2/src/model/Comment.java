package model;

import java.sql.Date;

public class Comment {
	private int commentId;
	private String content;
	private String userId;
	private int postId;
	private Date regdate;
	public int getCommentId() {
		return commentId;
	}
	
	
	public Comment(int commentId, String content, String userId, int postId, Date regdate) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.userId = userId;
		this.postId = postId;
		this.regdate = regdate;
	}
	
	public Comment(int commentId, String content, String userId, int postId) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.userId = userId;
		this.postId = postId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
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
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content + ", userId=" + userId + ", postId=" + postId
				+ ", regdate=" + regdate + "]";
	}

	
}
