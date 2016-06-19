package ir.ac.sbu.cassandraproject.dao.model;

public class AvailableRoom {

    public int roomId;
    public int hotelId;

    public AvailableRoom(int roomId, int hotelId) {
        this.roomId = roomId;
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "( "
                + roomId + ", "
                + hotelId + ") ";
    }
}
