package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Apply;

public class ApplyDAO {
private JDBCUtil jdbcUtil = null;
   
   public ApplyDAO() {         
      jdbcUtil = new JDBCUtil();
   }
         
   //4. 
   public int applyFarm(Apply apply) throws SQLException {
         String sql = "INSERT INTO APPLYINFO (applyId, farmId, userId, StartDate, EndDate, name)VALUES (apply_seq.NEXTVAL, ?, ?, ?, ?, ?)"; //userId는 어떻게 얻어오지? (의문)   
         Object[] param = new Object[] { apply.getFarmId(), apply.getUserId(), 
               apply.getStartDate(), apply.getEndDate(), apply.getName()};   //accept는 아직 호스트가 허락을 안해서 -1
         
         jdbcUtil.setSqlAndParameters(sql, param);
                        
         try {            
            int result = jdbcUtil.executeUpdate();
            return result;
         } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
         } finally {      
            jdbcUtil.commit();
            jdbcUtil.close();
         }      
         return 0;         
   }
   
   public int applyMachine(Apply apply) throws SQLException {
       String sql = "INSERT INTO APPLYINFO (applyId, machineId, userId, StartDate, EndDate, name)VALUES (apply_seq.NEXTVAL, ?, ?, ?, ?, ?)"; //userId는 어떻게 얻어오지? (의문)   
       Object[] param = new Object[] { apply.getMachineId(), apply.getUserId(), 
             apply.getStartDate(), apply.getEndDate(), apply.getName()};   //accept는 아직 호스트가 허락을 안해서 -1
       
       jdbcUtil.setSqlAndParameters(sql, param);
                      
       try {            
          int result = jdbcUtil.executeUpdate();
          return result;
       } catch (Exception ex) {
          jdbcUtil.rollback();
          ex.printStackTrace();
       } finally {      
          jdbcUtil.commit();
          jdbcUtil.close();
       }      
       return 0;         
 }
   
   //내가 신청한 리스트
   public List<Apply> findMyFarmApplyList(String userId)throws SQLException{
      String sql = "SELECT * FROM APPLYINFO WHERE userId=? and farmId is not NULL and machineId is NULL";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
 //내가 신청한 리스트
   public List<Apply> findMyMachineApplyList(String userId)throws SQLException{
      String sql = "SELECT * FROM APPLYINFO WHERE userId=? and machineId is not NULL and farmId is NULL";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
   
 //내에게 신청된 리스트
   public List<Apply> findFarmAppliedList(String userId)throws SQLException{
      String sql = "SELECT a.* FROM APPLYINFO a, FARMINFO f WHERE a.farmId=f.farmId and f.userId=? and a.accept=0";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
   public List<Apply> findMachineAppliedList(String userId)throws SQLException{
      String sql = "SELECT a.* FROM APPLYINFO a, MACHINEINFO m WHERE a.machineId=m.machineId and m.userId=? and a.accept=0";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
   public int acceptApply(int applyId, boolean accept) throws SQLException{
      String sql = "UPDATE APPLYINFO SET accept=1 WHERE applyId=?";
      if(!accept){
         sql = "UPDATE APPLYINFO SET accept=-1 WHERE applyId=?";
      }
      jdbcUtil.setSqlAndParameters(sql, new Object[]{applyId});
      try{
         int result = jdbcUtil.executeUpdate();
         return result;
      }catch(Exception e){
         jdbcUtil.rollback();
         e.printStackTrace();
      } finally{
         jdbcUtil.commit();
         jdbcUtil.close();
      }
      
      return 0;
   }
   
   public List<Apply> findCompleteMachineAppliedList(String userId)throws SQLException{
      String sql = "SELECT a.* FROM APPLYINFO a, MACHINEINFO m WHERE a.machineId=m.machineId and m.userId=? and a.accept!=0";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
   public List<Apply> findCompleteFarmAppliedList(String userId)throws SQLException{
      String sql = "SELECT a.* FROM APPLYINFO a, FARMINFO f WHERE a.farmId=f.farmId and f.userId=? and a.accept!=0";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         List<Apply> list = new ArrayList<Apply>();
         while(rs.next()){
            Apply apply = new Apply(
                  rs.getInt("applyId"),
                  rs.getInt("machineId"),
                  rs.getInt("farmId"),
                  rs.getString("userId"),
                  rs.getInt("accept"),
                  rs.getDate("StartDate"),
                  rs.getDate("EndDate"),
                  rs.getString("name"));
            list.add(apply);
         }
         return list;
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return null;
   }
   
   public int isAppliedFarm(int farmId)throws SQLException{
	      String sql = "SELECT accept FROM APPLYINFO WHERE farmId=?";
      jdbcUtil.setSqlAndParameters(sql, new Object[] {farmId});
      try{
         ResultSet rs = jdbcUtil.executeQuery();
         if(rs.next()){
        	 return rs.getInt("accept");
         }
      }catch(Exception e){
         e.printStackTrace();
      }finally{
           jdbcUtil.close();
      }
      return 0;
   }
   
   public int isAppliedMachine(int machineId)throws SQLException{
	      String sql = "SELECT accept FROM APPLYINFO WHERE machineId=?";
   jdbcUtil.setSqlAndParameters(sql, new Object[] {machineId});
   try{
      ResultSet rs = jdbcUtil.executeQuery();
      if(rs.next()){
     	 return rs.getInt("accept");
      }
      return 0;
   }catch(Exception e){
      e.printStackTrace();
   }finally{
        jdbcUtil.close();
   }
   return 0;
}
}
