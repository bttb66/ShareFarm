package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;
import model.Community;

public class CommunityDAO {
	private JDBCUtil jdbcUtil;
	
	public CommunityDAO(){
		jdbcUtil = new JDBCUtil();
	}
	
	public int create(Community community) throws SQLException {
		String sql = "INSERT INTO COMMUNITY (postId, title, content, userId) VALUES (post_seq.NEXTVAL, ?, ?, ?)";		
		Object[] param = new Object[] {community.getTitle(), community.getContent(), community.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil ? ?? insert? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;			
	}
	
	public int update(Community community) throws SQLException {
		String sql = "UPDATE COMMUNITY "
					+ "SET content=? "
					+ "WHERE postid=?";
		Object[] param = new Object[] {community.getContent(), community.getPostId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil? ?? update? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;
	}
	
	public int remove(int postId) throws SQLException {
		String sql = "DELETE FROM COMMUNITY WHERE postid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});	// JDBCUtil? ?? delete? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??

		try {				
			int result = jdbcUtil.executeUpdate();	// delete ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;
	}
	
	public List<Community> searchPost(String content, String title, int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT * "
        			+ "FROM COMMUNITY WHERE content like '%"+content+"%' or title like '%"+title+"%'";              
		jdbcUtil.setSql(sql);	// JDBCUtil? ?? query? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??

		try {
			List<Community> list = new ArrayList<Community>();
			ResultSet rs = jdbcUtil.executeQuery();		// query ? ??? ??
			int start = ((currentPage-1) * countPerPage) + 1;	// ? ??? ??? ďż? ? ??? ??? ?? ? ?? ? ???¸ ? ??? ďż?
			if ((start >= 0) && rs.absolute(start)) {
				do {						// ? ?ť?ź? ? ??? ?? ? ?Šęł¤ě
					Community comm = new Community(		// User ? ??ě˛´ĺ ?? ? ??? ??? ?š?¸? ? ?ť?ź? ? ??? ??? ?? ? ??? ??
						rs.getInt("postId"),
						rs.getString("content"),
						rs.getString("userId"),
						rs.getString("title"),
						rs.getInt("viewNum"),
						rs.getDate("regDate"));
					list.add(comm);
				} while ((rs.next()) && (--countPerPage > 0));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ? ???
		}
		return null;
	}
	public List<Community> findPosts(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT * FROM COMMUNITY order by postId desc";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {}, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);	// JDBCUtil? ?? query? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??

		try {
			List<Community> list = new ArrayList<Community>();
			ResultSet rs = jdbcUtil.executeQuery();		// query ? ??? ??
			int start = ((currentPage-1) * countPerPage) + 1;	// ? ??? ??? ďż? ? ??? ??? ?? ? ?? ? ???¸ ? ??? ďż?
			if ((start >= 0) && rs.absolute(start)) {
				do {						// ? ?ť?ź? ? ??? ?? ? ?Šęł¤ě
					Community comm = new Community(		// User ? ??ě˛´ĺ ?? ? ??? ??? ?š?¸? ? ?ť?ź? ? ??? ??? ?? ? ??? ??
							rs.getInt("postId"),
							rs.getString("content"),
							rs.getString("userId"),
							rs.getString("title"),
							rs.getInt("viewNum"),
							rs.getDate("regDate"));
					list.add(comm);
				} while ((rs.next()) && (--countPerPage > 0));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ? ???
		}
		return null;
	}
	
	public Community findPost(int postId) throws SQLException {
        String sql = "SELECT * FROM COMMUNITY WHERE postId=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});	// JDBCUtil? ?? query? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ? ??? ??
			if(rs.next()){
				Community comm = new Community(		// User ? ??ě˛´ĺ ?? ? ??? ??? ?š?¸? ? ?ť?ź? ? ??? ??? ?? ? ??? ??
						rs.getInt("postId"),
						rs.getString("content"),
						rs.getString("userId"),
						rs.getString("title"),
						rs.getInt("viewNum"),
						rs.getDate("regDate"));
				return comm;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ? ???
		}
		return null;
	}
	
	public int viewPost(int postId)throws SQLException{
		String sql = "UPDATE COMMUNITY "
				+ "SET viewNum = viewNum+1 "
				+ "WHERE postid=?";
	
		jdbcUtil.setSqlAndParameters(sql, new Object[] { postId });	// JDBCUtil? ?? update? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;
	}
	
	public int createComment(Comment comment)throws SQLException{
		String sql = "INSERT INTO COMMENTINFO (commentId, content, userId, postId)VALUES(comment_seq.NEXTVAL, ?, ?, ?)";
		Object[] parameters = new Object[] {comment.getContent(), comment.getUserId(), comment.getPostId()};
		jdbcUtil.setSqlAndParameters(sql, parameters);
		try {				
			int result = jdbcUtil.executeUpdate();	// insert ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;	
	}
	
	public List<Comment> findComments(int postId) throws SQLException {
        String sql = "SELECT * FROM COMMENTINFO where postId=? order by commentId desc";              
		jdbcUtil.setSql(sql);	// JDBCUtil? ?? query? ??? ?? ? ? ęł¤ě ? ??? ?? ? ??? ??

		try {
			List<Comment> list = new ArrayList<Comment>();
			ResultSet rs = jdbcUtil.executeQuery();		// query ? ??? ??
			
			while (rs.next()){						// ? ?ť?ź? ? ??? ?? ? ?Šęł¤ě
				Comment comm = new Comment(		// User ? ??ě˛´ĺ ?? ? ??? ??? ?š?¸? ? ?ť?ź? ? ??? ??? ?? ? ??? ??
						rs.getInt("commentId"),
						rs.getString("content"),
						rs.getString("userId"),
						rs.getInt("postId"),
						rs.getDate("regDate"));
				list.add(comm);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ? ???
		}
		return null;
	}
	
	/*public int deleteComment(int commentId)throws SQLException{
		String sql = "DELETE FROM COMMENTINFO WHERE commentId=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {commentId});
		try {				
			int result = jdbcUtil.executeUpdate();	// insert ? ?? ? ??? ??
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ? ???
		}		
		return 0;	
	}*/
	
}
