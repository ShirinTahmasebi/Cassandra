package ir.ac.sbu.cassandraproject.dao.model;

public class Reservation {

    public int resId;
    public int hotelId;
    public int roomId;
    public String guestId;

    public Reservation(int resId, int hotelId, int roomId, String guestId) {
        this.resId = resId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.guestId = guestId;
    }

    @Override
    public String toString() {
        return "( "
                + resId + ", "
                + hotelId + ", "
                + roomId + ", '"
                + guestId + "') ";
    }
}
