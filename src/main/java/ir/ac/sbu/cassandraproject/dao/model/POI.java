package ir.ac.sbu.cassandraproject.dao.model;

public class POI {

    public String name;
    public int poiId;
    public int hotelId;

    public POI(int poiId, int hotelId, String name) {
        this.name = name;
        this.poiId = poiId;
        this.hotelId = hotelId;
    }
    
    @Override
    public String toString() {
        return "( "
                + poiId + ", "
                + hotelId + ", '"
                + name + "') ";
    }
}
