package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;
import controller.user.UserSessionUtils;
import model.Machine;
import model.User;

public class MachineDAO {
	private static JDBCUtil jdbcUtil = null;
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
	
	public MachineDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	
	// 1.list �쟾泥� �솕硫�
	public List<Machine> findTotalMachineList() throws SQLException {
	       String sql = "SELECT * "
	        		   + "FROM MACHINEINFO";
	        
			jdbcUtil.setSqlAndParameters(sql, null);
						
			try {
				ResultSet rs = jdbcUtil.executeQuery();					
				List<Machine> TotalMachineList = new ArrayList<Machine>();
				
				while (rs.next()) {
					Machine machine = new Machine(			
                                                  rs.getInt("machineId"),
                                                  rs.getString("machineName"),
                                                  rs.getString("location"),
                                                  rs.getInt("price"),
                                                  rs.getInt("rentCount"),
                                                  rs.getString("userId"),
                                                  rs.getString("machineImgUrl"),
                                                  rs.getString("detail"));
                    					TotalMachineList.add(machine);
				}		
				return TotalMachineList;					
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
			return null;
	}
    //2.�냽湲곌?�� �씠?��꾩쑝濡� 寃��깋
    public static List<Machine> findMachine(String machineName) {    //findDetailMachineList�� �룞
        String sql = "SELECT * "
        + "FROM MACHINEINFO WHERE machineName=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {machineName});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            List<Machine> list = new ArrayList<Machine>();
            while (rs.next()) {
                Machine searchMachine = new Machine(
                                                    rs.getInt("machineId"),
                                                    machineName,
                                                    rs.getString("location"),
                                                    rs.getInt("price"),
                                                    rs.getInt("rentCount"),
                                                    rs.getString("userId"),
                                                    rs.getString("machineImgUrl"),
                                                    rs.getString("detail"));
                                                list.add(searchMachine);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
    
	//3.�겢?����?�� detail
		public static Machine findDetailMachine(int machineId) throws SQLException {    //findDetailMachineList�� �룞
	        String sql = "SELECT * "
	        			+ "FROM MACHINEINFO WHERE machineId=? ";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {machineId});

			try {
				ResultSet rs = jdbcUtil.executeQuery();	
				
				 if (rs.next()) {
		                Machine searchMachine = new Machine(
		                									machineId,
		                									rs.getString("machineName"),
		                                                    rs.getString("location"),
		                                                    rs.getInt("price"),
		                                                    rs.getInt("rentCount"),
		                                                    rs.getString("userId"),
		                                                    rs.getString("machineImgUrl"),
		                                                    rs.getString("detail"));
		                									return searchMachine;
		            }
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();
			}
			return null;
		}
    
    public int registMachine(Machine machine) throws SQLException {
        String sql = "INSERT INTO MACHINEINFO (machineId, machineName, location, price, rentCount, userId, detail)VALUES (machine_fkfk.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        
        Object[] param = new Object[] {machine.getMachineName(), machine.getLocation(), machine.getPrice(),
            machine.getRentCount(), machine.getUserId(), machine.getDetail()};
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil �뜝�룞�삕 insert�뜝�룞�삕�뜝�룞�삕 �뜝�떊?�ㅼ?�� �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
        
        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource �뜝�룞�삕�솚
        }
        return 0;
    }
    
    
    public boolean existingMachine(String machineName) throws SQLException {
        String sql = "SELECT count(*) FROM MACHINEINFO WHERE machineName=?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {machineName});
        
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();      // resource �뜝�룞�삕�솚
        }
        return false;
    }



		
}
