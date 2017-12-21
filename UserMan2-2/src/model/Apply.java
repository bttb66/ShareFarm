package model;

import java.sql.Date;

public class Apply {
   private int applyId;
   private int machineId;
   private int farmId;
   private String userId;
   private int accept;
   private Date startDate;//농장체험시작기간
   private Date endDate;//농장체험끝나는기간
   private String name;
   
   
      
   public Apply(int applyId, int machineId, int farmId, String userId, int accept, Date startDate, Date endDate,
      String name) {
   super();
   this.applyId = applyId;
   this.machineId = machineId;
   this.farmId = farmId;
   this.userId = userId;
   this.accept = accept;
   this.startDate = startDate;
   this.endDate = endDate;
   this.name = name;
}
   public int getApplyId() {
      return applyId;
   }
   public void setApplyId(int applyId) {
      this.applyId = applyId;
   }
   public int getMachineId() {
      return machineId;
   }
   public void setMachineId(int machineId) {
      this.machineId = machineId;
   }
   public int getFarmId() {
      return farmId;
   }
   public void setFarmId(int farmId) {
      this.farmId = farmId;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public int getAccept() {
      return accept;
   }
   public void setAccept(int accept) {
      this.accept = accept;
   }
   public Date getStartDate() {
      return startDate;
   }
   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }
   public Date getEndDate() {
      return endDate;
   }
   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   @Override
   public String toString() {
      return "Apply [applyId=" + applyId + ", machineId=" + machineId + ", farmId=" + farmId + ", userId=" + userId
            + ", accept=" + accept + ", startDate=" + startDate + ", endDate=" + endDate + "]";
   }
   
   
   
}