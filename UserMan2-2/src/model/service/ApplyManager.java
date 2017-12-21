package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Apply;
import model.dao.ApplyDAO;

public class ApplyManager {
   private static ApplyManager applyMan = new ApplyManager();
   private ApplyDAO applyDAO;

   private ApplyManager() {
      try {
         applyDAO = new ApplyDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   
   public static ApplyManager getInstance() {
      return applyMan;
   }
   
   //4. 게스트가 [농장]체험 신청하기위해 정보불러오기
      public int applyFarm(Apply apply) throws SQLException {
         
         return applyDAO.applyFarm(apply);
      }
      
      public int applyMachine(Apply apply) throws SQLException {
          
          return applyDAO.applyMachine(apply);
       }

      public List<Apply> findMyFarmApplyList(String userId)throws SQLException{
         return applyDAO.findMyFarmApplyList(userId);
      }
      
      public List<Apply> findMyMachineApplyList(String userId)throws SQLException{
         return applyDAO.findMyMachineApplyList(userId);
      }
      
      public List<Apply> findFarmAppliedList(String userId)throws SQLException{
         return applyDAO.findFarmAppliedList(userId);
      }
      
      public List<Apply> findMachineAppliedList(String userId)throws SQLException{
         return applyDAO.findMachineAppliedList(userId);
      }
      
      public int acceptApply(int applyId, boolean accept) throws SQLException{
         return applyDAO.acceptApply(applyId, accept);
      }
      public List<Apply> findCompleteFarmAppliedList(String userId)throws SQLException{
         return applyDAO.findCompleteFarmAppliedList(userId);
      }
      public List<Apply> findCompleteMachineAppliedList(String userId)throws SQLException{
         return applyDAO.findCompleteMachineAppliedList(userId);
      }
         
}
