package model;

public class Machine {
	private int machineId;//湲� �븘�씠�뵒
    private String machineName;
	private String location;//吏��뿭
//	private String category;//?��꾨쪟(?��?���?)
	private int price;//媛�
	private int rentCount;//?��?��?���슏�닔?
//    private String startDate;//���뿬   ?? string query??
//    private String endDate;//諛섎�?
    private String userId;
    private String machineImgUrl;
    //detail, img?��붽� - date�뒗 apply�뿉 �엳吏� �븡�굹?, category�뒗 蹂�?�?
    private String detail;
    
	public Machine() { }
	
	public Machine(int machineId, String machineName, String location, int price,
			int rentCount, String userId, String machineImgUrl, String detail) {
		super();
		this.machineId = machineId;
        this.machineName = machineName;
		this.location = location;
	//	this.category = category;  //? �냽�옉吏��옉 �냽湲곌?�� �굹�닃?���吏�? - farm�뿉�꽌�뒗 farming(�냽�옉?���?) 媛숈�嫄�??
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
	
	public Machine(String machineName, String location, String machineImgUrl) { //�씠誘몄�? �겢?����?�� 寃��깋
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
