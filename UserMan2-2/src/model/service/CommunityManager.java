package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Comment;
import model.Community;
import model.dao.CommunityDAO;

public class CommunityManager {
	private static CommunityManager comm = new CommunityManager();
	private CommunityDAO communityDAO;
	
	public CommunityManager(){
		try{
			communityDAO = new CommunityDAO();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static CommunityManager getInstance(){
		return comm;
	}
	
	public int create(Community community) throws SQLException{
		return communityDAO.create(community);
	}
	
	public int update(Community community) throws SQLException{
		return communityDAO.update(community);
	}
	
	public int remove(int postId) throws SQLException {
		return communityDAO.remove(postId);
	}
	
	public List<Community> searchPost(String content, String title, int currentPage, int countPerPage) throws SQLException {
		return communityDAO.searchPost(content, title, currentPage, countPerPage);
	}
	
	public List<Community> findPosts(int currentPage, int countPerPage) throws SQLException {
		return communityDAO.findPosts(currentPage, countPerPage);
	}
	
	public Community findPost(int postId) throws SQLException {
		return communityDAO.findPost(postId);
	}
	
	public int viewPost(int postId) throws SQLException{
		return communityDAO.viewPost(postId);
	}
	
	public int createComment(Comment comment)throws SQLException{
		return communityDAO.createComment(comment);
	}
	
	public List<Comment> findComments(int postId) throws SQLException {
		return communityDAO.findComments(postId);
	}
	
}
