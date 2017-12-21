package model;

public class Machine {
	private int machineId;//æ¹²ï¿½ ï¿½ë¸˜ï¿½ì” ï¿½ëµ’
    private String machineName;
	private String location;//ï§ï¿½ï¿½ë¿­
//	private String category;//?ºê¾¨ìªŸ(?†«?‚…ìª?)
	private int price;//åª›ï¿½
	private int rentCount;//?®?š®?”›ï¿½ìŠï¿½ë‹”?
//    private String startDate;//ï¿½ï¿½ï¿½ë¿¬   ?? string query??
//    private String endDate;//è«›ì„ê¶?
    private String userId;
    private String machineImgUrl;
    //detail, img?•°ë¶½ï¿½ - dateï¿½ë’— applyï¿½ë¿‰ ï¿½ì—³ï§ï¿½ ï¿½ë¸¡ï¿½êµ¹?, categoryï¿½ë’— è¹‚ë?ìª?
    private String detail;
    
	public Machine() { }
	
	public Machine(int machineId, String machineName, String location, int price,
			int rentCount, String userId, String machineImgUrl, String detail) {
		super();
		this.machineId = machineId;
        this.machineName = machineName;
		this.location = location;
	//	this.category = category;  //? ï¿½ëƒ½ï¿½ì˜‰ï§ï¿½ï¿½ì˜‰ ï¿½ëƒ½æ¹²ê³Œ?„ ï¿½êµ¹ï¿½ë‹ƒ?Œ¿ï¿½ï§ï¿? - farmï¿½ë¿‰ï¿½ê½Œï¿½ë’— farming(ï¿½ëƒ½ï¿½ì˜‰?‡¾ï¿?) åª›ìˆˆï¿½å«„ï¿??
		this.price = price;
		this.rentCount = rentCount;
//        this.startDate = startDate;
//        this.endDate = endDate;
		this.userId = userId;
        this.machineImgUrl = machineImgUrl;
        this.detail = detail;
	}
    
    public Machine(int machineId, String machineName, String location, int price,
                   int rentCount, String userId, String detail) {
        super();
        this.machineId = machineId;
        this.machineName = machineName;
        this.location = location;
        this.price = price;
        this.rentCount = rentCount;
        this.userId = userId;
        this.detail = detail;
    }
	
	public Machine(String machineName, String location, String machineImgUrl) { //ï¿½ì” èª˜ëª„ï¿? ï¿½ê²¢?”±ï¿½ï¿½?–† å¯ƒï¿½ï¿½ê¹‹
		super();
		this.machineName = machineName;
		this.location = location;
		this.machineImgUrl = machineImgUrl;
	}
    
//    public Farm(String farmName, String location, String farming, int area, String address, String farmPhone, int price) {
//        super();
//        this.farmName = farmName;
//        this.location = location;
//        this.farming = farming;
//        this.area = area;
//        this.price = price;
//    }
//
//    public Farm(int farmId, String farmName, String location, String farming, int area, String userId,
//                String farmImgUrl, int price, String detail) {
//        super();
//        this.farmId = farmId;
//        this.farmName = farmName;
//        this.location = location;
//        this.farming = farming;
//        this.area = area;
//        this.userId = userId;
//        this.farmImgUrl = farmImgUrl;
//        this.price = price;
//        this.detail = detail;
//    }

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
    
    public String getMachineName() {
        return machineName;
    }
    
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

//    public String getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(String endDate) {
//        this.endDate = endDate;
//    }
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
    public String getMachineImgUrl() {
        return machineImgUrl;
    }
    
    public void setMachineImgUrl(String machineImgUrl) {
        this.machineImgUrl = machineImgUrl;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }


	@Override
	public String toString() {
		return "Machine [machineId=" + machineId + ", machineName=" + machineName +", location=" + location +  ", price=" + price + ", rentCount=" + rentCount +  ", userId=" + userId + ", machineImgUrl=" + machineImgUrl  + ", detail=" + detail +"]";
	}
}
