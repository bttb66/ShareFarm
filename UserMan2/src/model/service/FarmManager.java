package model.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.DispatcherServlet;
import model.Farm;
import model.dao.FarmDAO;

public class FarmManager {

   private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
   private static FarmManager farmMan = new FarmManager();
   private FarmDAO farmDAO;

   private FarmManager() {
      try {
         farmDAO = new FarmDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   
   public static FarmManager getInstance() {
      return farmMan;
   }
   
   // 1.筌롫?���뵥?��?��?�� ?��?��?��彛싷?���꺗?��?��?���뵳�딅뮞占?���? �굢�슢�젻?��?��?��?���?
   public List<Farm> findTotalFarmList() throws SQLException {
      return farmDAO.findTotalFarmList();
   }
   
   //2.筌롫?���뵥?��?��?��?��?��?�� ?��?��꺗占?��?��?��껓옙?��?��?��?��?���??��?�옙
   public List<Farm> findFarm(String farmName)
      throws SQLException, FarmNameNotFoundException{
      List<Farm> Findfarm = null;
      Findfarm = farmDAO.findFarm(farmName);
      
      if (Findfarm == null) {
         throw new FarmNameNotFoundException(farmName + "is null");
      }      
      return Findfarm;
   }
   
   // 3. ?��?��?��?��?����???���뵬?��?��???��?��?�� �굢�슢�젻?��?��?��?���?
   public Farm findDetailFarmList(int farmId) throws SQLException, FarmDetailNotFoundException{
      Farm Detailfarm = farmDAO.findDetailFarmList(farmId);
      
      logger.info("Farm Detailfarm: {}", Detailfarm);
      if(Detailfarm == null){
         throw new FarmDetailNotFoundException(farmId + "is null");
      }
      return Detailfarm;
   }
   
   public FarmDAO getUserDAO() {
      return this.farmDAO;
   }
   public int registFarm(Farm farm) throws SQLException, ExistingUserException {
      //if (farmDAO.existingFarm(farm.getFarmName()) == true) {
        // throw new ExistingUserException(farm.getFarmName() + "?�� 존재?��?�� ?��?��?��?��?��.");
      //}
      return farmDAO.registFarm(farm);
   }
   
}