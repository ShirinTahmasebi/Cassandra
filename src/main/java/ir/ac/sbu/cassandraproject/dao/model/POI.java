package ir.ac.sbu.cassandraproject.dao.model;

public class POI {

    public String name;
    public int poiId;
    public int hotelId;
    
    @Override
    public String toString() {
        return "( "
                + poiId + ", "
                + hotelId + ", '"
                + name + "') ";
    }
}
