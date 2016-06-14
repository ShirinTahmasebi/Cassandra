package ir.ac.sbu.cassandraproject.util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CasssandraHelper {

    public static Session getSession() {
        Cluster cluster;
        Session session;

        // Connect to the cluster and keyspace "demo"
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect();

        //Query
        String query = "CREATE KEYSPACE IF NOT EXISTS hotelie  WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};";

        //Executing the query
        session.execute(query);

        //using the KeySpace
        session.execute("USE hotelie");

        return session;
    }

    public static void createTable(Session session) {
//        createHotelTable(session);
//        createGuestTable(session);
//        createHotelByCityTable(session);
//        createReservationTable(session);
    }

    private static void createHotelTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE hotel (\n"
                + "hotelId int, \n"
                + "name text, \n"
                + "phone text, \n"
                + "email text, \n"
                + "city text, \n"
                + "PRIMARY KEY (hotelId));";
        //Executing the query
        session.execute(tableFamilyQuery);
    }

    private static void createGuestTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE guest (\n"
                + "phone text, \n"
                + "fname text, \n"
                + "lname text, \n"
                + "email text, \n"
                + "PRIMARY KEY (phone));";
        //Executing the query
        session.execute(tableFamilyQuery);
    }

    private static void createHotelByCityTable(Session session) {
        // TODO: Inja Chi bashe??
    }

    private static void createReservationTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE reservation (\n"
                + "resId int, \n"
                + "hotelId int, \n"
                + "roomId int, \n"
                + "guestId int, \n"
                + "PRIMARY KEY (resId));";
        //Executing the query
        session.execute(tableFamilyQuery);
    }

    private static void createPOITable(Session session) {
        String tableFamilyQuery = "CREATE TABLE poi (\n"
                + "poiId int, \n"
                + "hotelId int, \n"
                + "name text, \n"
                + "PRIMARY KEY (resId));";
        //Executing the query
        session.execute(tableFamilyQuery);
    }

    private static void createRoomTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE room (\n"
                + "roomId int, \n"
                + "hotelId int, \n"
                + "number int, \n"
                + "cost text, \n"
                + "facilityOne text, \n"
                + "facilityTwo text, \n"
                + "facilityThree text, \n"
                + "PRIMARY KEY (resId));";
        //Executing the query
        session.execute(tableFamilyQuery);
    }

}
