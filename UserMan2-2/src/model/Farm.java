package model;

public class Farm {
   private int farmId;//�냽�옣 �븘�씠�뵒
   private String farmName;//�냽�옣�씠?���?
   private String location;//吏��뿭
   private String farming;//�냽�옉?���?
   private int area;//硫댁?��
   private String userId;
   private String farmImgUrl;//�냽�옣�씠誘몄�url
   private String detail;
   private int price;
   
   public Farm() { }
   
   public Farm(int farmId, String userId, String farmName, String location, String farming, int area, String detail, int price) {
	super();
	this.farmId = farmId;
	this.userId = userId;
	this.farmName = farmName;
	this.location = location;
	this.farming = farming;
	this.area = area;
	this.detail = detail;
	this.price = price;
}

public Farm(String farmName, String location, String farming, int area, String address, String farmPhone, int price) {
	super();
	this.farmName = farmName;
	this.location = location;
	this.farming = farming;
	this.area = area;
	this.price = price;
   }

public Farm(int farmId, String farmName, String location, String farming, int area, String userId,
         String farmImgUrl, int price, String detail) {
      super();
      this.farmId = farmId;
      this.farmName = farmName;
      this.location = location;
      this.farming = farming;
      this.area = area;
      this.userId = userId;
      this.farmImgUrl = farmImgUrl;
      this.price = price;
      this.detail = detail;
 }

   public Farm(String farmName, String location, String farmImgUrl) {
      super();
      this.farmName = farmName;
      this.location = location;
      this.farmImgUrl = farmImgUrl;
   }

   public int getFarmId() {
      return farmId;
   }

   public void setFarmId(int farmId) {
      this.farmId = farmId;
   }

   public String getFarmName() {
      return farmName;
   }

   public void setFarmName(String farmName) {
      this.farmName = farmName;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getFarming() {
      return farming;
   }

   public void setFarming(String farming) {
      this.farming = farming;
   }

   public int getArea() {
      return area;
   }

   public void setArea(int area) {
      this.area = area;
   }

   public String getFarmImgUrl() {
      return farmImgUrl;
   }

   public void setFarmImgUrl(String farmImgUrl) {
      farmImgUrl = farmImgUrl;
   }

   
   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   
   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   
   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }

   @Override
   public String toString() {
      return "Farm [" + "farmId=" + farmId + "userId=" + userId + ", farmName=" + farmName + ", location=" + location + ", farming=" + farming
            + ", area=" + area + ", FarmImgUrl=" + farmImgUrl + "]";
   }
}