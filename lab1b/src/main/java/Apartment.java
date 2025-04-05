import org.json.JSONObject;

import java.util.ArrayList;

public class Apartment {
    private String apartmentNo;
    private String propertyName;
    private Integer floorNo;
    private Integer size;
    private Integer numberOfRooms;
    private ArrayList<Lease> leases;

    public Apartment(String apartmentNo, String propertyName, Integer floorNo, Integer size, Integer numberOfRooms) {
        this.apartmentNo = apartmentNo;
        this.propertyName = propertyName;
        this.floorNo = floorNo;
        this.size = size;
        this.numberOfRooms = numberOfRooms;
        this.leases = new ArrayList<>();
    }

    public void addLease(Lease lease) {
        this.leases.add(lease);
    }

    public ArrayList<Lease> getLeases() {
        return leases;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
