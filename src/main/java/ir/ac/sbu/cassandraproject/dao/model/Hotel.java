package ir.ac.sbu.cassandraproject.dao.model;

public class Hotel {

    public int id;
    public String name;
    public String phone;
    public String city;

    public Hotel(int id, String name, String phone, String city){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "( "
                + id + ", '"
                + name + "', '"
                + phone + "', '"
                + city + "') ";
    }

}
