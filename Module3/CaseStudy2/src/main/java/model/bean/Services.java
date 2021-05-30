package model.bean;

public class Services {
    private int id;
    private String name;
    private String area;
    private double cost;
    private int maxPeople;
    private int rentType;
    private int serviceType;
    private String standardRoom;
    private String decriptionOtherConvenience;
    private double poolArea;
    private int numOfFloors;

    public Services() {
    }

    public Services(String name, String area, double cost, int maxPeople, int rentType, int serviceType, String standardRoom, String decriptionOtherConvenience, double poolArea, int numOfFloors) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.decriptionOtherConvenience = decriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
    }

    public Services(int id, String name, String area, double cost, int maxPeople, int rentType, int serviceType, String standardRoom, String decriptionOtherConvenience, double poolArea, int numOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.decriptionOtherConvenience = decriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDecriptionOtherConvenience() {
        return decriptionOtherConvenience;
    }

    public void setDecriptionOtherConvenience(String decriptionOtherConvenience) {
        this.decriptionOtherConvenience = decriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }
}


