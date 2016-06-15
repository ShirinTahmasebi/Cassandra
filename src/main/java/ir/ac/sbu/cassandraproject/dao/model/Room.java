package ir.ac.sbu.cassandraproject.dao.model;

public class Room {

    public int roomId;
    public int hotelId;
    public int number;
    public String cost;
    public String facilityOne;
    public String facilityTwo;
    public String facilityThree;

    public Room(int roomId, int hotelId, int number, String cost,
            String facilityOne, String facilityTwo, String facilityThree) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.number = number;
        this.cost = cost;
        this.facilityOne = facilityOne;
        this.facilityTwo = facilityTwo;
        this.facilityThree = facilityThree;
    }

    public Room(int roomId, int hotelId, int number, String cost,
            String facilityOne) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.number = number;
        this.cost = cost;
        this.facilityOne = facilityOne;
        this.facilityTwo = "";
        this.facilityThree = "";
    }

    public Room(int roomId, int hotelId, int number, String cost,
            String facilityOne, String facilityTwo) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.number = number;
        this.cost = cost;
        this.facilityOne = facilityOne;
        this.facilityTwo = facilityTwo;
        this.facilityThree = "";
    }

    @Override
    public String toString() {
        return "( "
                + roomId + ", "
                + hotelId + ", "
                + number + ", '"
                + cost + "', '"
                + facilityOne + "', '"
                + facilityTwo + "', '"
                + facilityThree + "') ";
    }

}
