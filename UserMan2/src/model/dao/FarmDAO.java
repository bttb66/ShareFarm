package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;
import controller.user.UserSessionUtils;
import model.Farm;
import model.User;

public class FarmDAO {
   private JDBCUtil jdbcUtil = null;
   private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
   
   public FarmDAO() {         
      jdbcUtil = new JDBCUtil();
   }

   
   // 1.硫붿?���뿉 二쇰쭚�?���옣?��?�뒪�듃 ?��?��?��二쇨�?
   public List<Farm> findTotalFarmList() throws SQLException {
          String sql = "SELECT * " 
                    + "FROM FARMINFO";
           
         jdbcUtil.setSqlAndParameters(sql, null);
                  
         try {
            ResultSet rs = jdbcUtil.executeQuery();               
            List<Farm> TotalfarmList = new ArrayList<Farm>();
            
            while (rs.next()) {
               Farm farm = new Farm(         
            		   rs.getInt("farmId"),
                       rs.getString("farmName"),
                       rs.getString("location"),
                       rs.getString("farming"),
                       rs.getInt("area"),
                       rs.getString("userId"),
                       rs.getString("farmImgUrl"),
                       rs.getInt("price"), 
                       rs.getString("detail"));   
               TotalfarmList.add(farm);         
            }      
            return TotalfarmList;               
            
         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
            jdbcUtil.close();
         }
         return null;
   }
   
   //2.硫붿?���뿉�꽌 �냽�옣寃��깋�븯湲�
      public List<Farm> findFarm(String farmName) throws SQLException {
           String sql = "SELECT * "
                    + "FROM FARMINFO WHERE farmName=? ";              
         jdbcUtil.setSqlAndParameters(sql, new Object[] {farmName});

         try {
            ResultSet rs = jdbcUtil.executeQuery();   
            List<Farm> list = new ArrayList<Farm>();
            while (rs.next()) {         
               Farm searchFarm = new Farm(      
                     rs.getInt("farmId"),
                     farmName,
                     rs.getString("location"),
                     rs.getString("farming"),
                     rs.getInt("area"),
                     rs.getString("userId"),
                     rs.getString("farmImgUrl"),
                     rs.getInt("price"), 
                     rs.getString("detail"));
                   list.add(searchFarm);
               }   
            return list;
         } catch (Exception ex) {
            ex.printStackTrace();
         } finally {
            jdbcUtil.close();
         }
         return null;
      }
      
      // 3. �뵒��?��?���궡�슜 ?��?��?��二쇨�?
      public Farm findDetailFarmList(int farmId) throws SQLException {
             String sql = "SELECT * " 
                         + "FROM FARMINFO "
                       + "where farmid=?";
            jdbcUtil.setSqlAndParameters(sql, new Object[] {farmId});
            
            
            try {
               ResultSet rs = jdbcUtil.executeQuery();            
               
               if (rs.next()) {                  
                   Farm searchFarm = new Farm(
                       farmId,
                         rs.getString("farmName"),
                         rs.getString("location"),
                         rs.getString("farming"),
                         rs.getInt("area"),
                         rs.getString("userId"),
                         rs.getString("farmImgUrl"),
                         rs.getInt("price"), 
                         rs.getString("detail"));
                     return searchFarm;
                  }           
            } catch (Exception ex) {
               ex.printStackTrace();
            } finally {
               jdbcUtil.close();
            }
            return null;
      }

      public int registFarm(Farm farm) throws SQLException {
          String sql = "INSERT INTO FARMINFO (farmId, farmName, location, farming, area, price, userId, detail)VALUES (farm_fkfk.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";      
          
          Object[] param = new Object[] {farm.getFarmName(), farm.getLocation(), farm.getFarming(),
                farm.getArea(), farm.getPrice(), farm.getUserId(), farm.getDetail()};            
          jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil ?��?��?�� insert?��?��?��?��?��?�� ?��?��곤옙 ?��?��?��?��?��?�� ?��?��?��?��?��?��
                      
          try {            
             int result = jdbcUtil.executeUpdate();
             return result;
          } catch (Exception ex) {
             jdbcUtil.rollback();
             ex.printStackTrace();
          } finally {      
             jdbcUtil.commit();
             jdbcUtil.close();   // resource ?��?��?��?��
          }      
          return 0;         
       }
       
       
       public boolean existingFarm(String farmName) throws SQLException {
          String sql = "SELECT count(*) FROM FARMINFO WHERE farmname=?";      
          jdbcUtil.setSqlAndParameters(sql, new Object[] {farmName});

          try {
             ResultSet rs = jdbcUtil.executeQuery();
             if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
             }
          } catch (Exception ex) {
             ex.printStackTrace();
          } finally {
             jdbcUtil.close();      // resource ?��?��?��?��
          }
          return false;
       }
}