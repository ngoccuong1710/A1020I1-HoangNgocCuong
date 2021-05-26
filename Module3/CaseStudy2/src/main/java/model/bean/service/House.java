package model.bean.service;

public class House extends Service{
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, String descriptionOtherConvenience, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String name, String area, double cost, int maxPeople, String rentType, String standardRoom, String descriptionOtherConvenience, int numberOfFloors) {
        super(name, area, cost, maxPeople, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
