package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;

public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();
	}
		
	public int create(User user) throws SQLException {
		String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserId(), user.getPassword(), 
						user.getName(), user.getEmail(), user.getPhone()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil ?��?��?�� insert?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert ?��?��?�� ?��?��?��?��?��?��
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ?��?��?��?��
		}		
		return 0;			
	}

	public int update(User user) throws SQLException {
		String sql = "UPDATE USERINFO "
					+ "SET passwd=?, name=?, email=?, phone=? "
					+ "WHERE userid=?";
		Object[] param = new Object[] {user.getPassword(), user.getName(), 
					user.getEmail(), user.getPhone(), user.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil?��?��?�� update?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update ?��?��?�� ?��?��?��?��?��?��
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ?��?��?��?��
		}		
		return 0;
	}

	public int remove(String userId) throws SQLException {
		String sql = "DELETE FROM USERINFO WHERE userid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil?��?��?�� delete?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��

		try {				
			int result = jdbcUtil.executeUpdate();	// delete ?��?��?�� ?��?��?��?��?��?��
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ?��?��?��?��
		}		
		return 0;
	}

	public User findUser(String userId) throws SQLException {
        String sql = "SELECT passwd, name, email, phone "
        			+ "FROM USERINFO WHERE userid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil?��?��?�� query?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ?��?��?��?��?��?��
			if (rs.next()) {						// ?��?��?��?�� ?��?��?��?��?��?�� ?��?��곤옙
				User user = new User(		// User ?��?��?��체占?��?�� ?��?��?��?��?��?��?��?��?��?�� ?��?��?��?�� ?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��
					userId,
					rs.getString("passwd"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"));
				
				logger.info("UserDAO user:{}", user);
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ?��?��?��?��
		}
		return null;
	}

	/**
	 * ?��?��?���? ?��?��?��?��?��?��?���? ?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��?��?�� List?��?��?�� ?��?��?��?��?��?�� ?��?��?�� ?��?��?��?��
	 */
	public List<User> findUserList() throws SQLException {
        String sql = "SELECT userId, passwd, name, email, phone " 
        		   + "FROM USERINFO ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil?��?��?�� query?��?��?�� ?��?��?��?��?��?��
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query ?��?��?��?��?��?��			
			List<User> userList = new ArrayList<User>();	// User?��?��?��?��?��?�� ?��?��?��?��?��?��?�� ?��?��?��?��?��?��
			while (rs.next()) {
				User user = new User(			// User ?��?��?��체占?��?�� ?��?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��
					rs.getString("userId"),
					rs.getString("passwd"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"));	
				userList.add(user);				// List?��?��?�� User ?��?��?���? ?��?��?��?��?��?��
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ?��?��?��?��
		}
		return null;
	}
	
	/**
	 * ?��?��?���? ?��?��?��?��?��?��?���? ?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��?�� ?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��?���? ?��?��?��?��?��?��?���? ?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��
	 * ?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��?���? ?��?��?��?��?��?��?��?��?��?��?��?�� List?��?��?�� ?��?��?��?��?��?��?��?��?��?�� ?��?��?��?��.
	 */
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT userId, passwd, name, email, phone " 
        		   + "FROM USERINFO ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil?��?��?�� query?��?��?�� ?��?��?��?��?��?��
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ?��?��?��?��?��?��
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query ?��?��?��?��?��?��			
			int start = ((currentPage-1) * countPerPage) + 1;	// ?��?��?��?��?��?��?���? ?��?��?��?��?��?��?��?��?�� ?��?��?�� ?��?��?��?�� ?��?��?��?���?
			if ((start >= 0) && rs.absolute(start)) {			// 커占?��?��?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��?�� ?��?��?��?��
				List<User> userList = new ArrayList<User>();	// User?��?��?��?��?��?�� ?��?��?��?��?��?��?�� ?��?��?��?��?��?��
				do {
					User user = new User(		// User ?��?��?��체占?��?�� ?��?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?�� ?��?��?��?��?��?��?��?��?�� ?��?��?��?��?��?��
						rs.getString("userId"),
						rs.getString("passwd"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"));	
					userList.add(user);							// ?��?��?��?��?��?��?��?��?��?�� User ?��?��?���? ?��?��?��?��?��?��
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ?��?��?��?��
		}
		return null;
	}

	/**
	 * ?��?��?��?��?��?��?�� ?��?��?��?��?��?��?���? ID?��?��?�� ?��?��?��?��?��?��?��?�� ?��?��?��?��?��?���??���? ?��?��?��?��?��?��?��?��?��?��?��?��?�� ?��?��?��?�� 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM USERINFO WHERE userid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil?��?��?�� query?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ?��?��?��?��?��?��
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ?��?��?��?��
		}
		return false;
	}
}
