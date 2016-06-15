package ir.ac.sbu.cassandraproject.util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import ir.ac.sbu.cassandraproject.dao.model.Guest;
import ir.ac.sbu.cassandraproject.dao.model.Hotel;
import ir.ac.sbu.cassandraproject.dao.model.POI;
import ir.ac.sbu.cassandraproject.dao.model.Room;
import java.util.ArrayList;
import java.util.List;

public class CasssandraHelper {

    public static Session getSession() {
        Cluster cluster;
        Session session;

        // Connect to the cluster and keyspace "demo"
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect();

        // Query
        String query = "CREATE KEYSPACE IF NOT EXISTS hotelie  WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};";

        // Executing the query
        session.execute(query);

        // Using the KeySpace
        session.execute("USE hotelie");

        return session;
    }

    public static void createTable(Session session) {
        // TODO: baraye dafeye avval az comment bayad dar biad
//        createHotelTable(session);
//        createPOITable(session);
//        createGuestTable(session);
//        createHotelByCityTable(session);
//        createRoomTable(session);
//        createReservationTable(session);
        insertFakeDataToTables(session);
    }

    private static void createHotelTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE hotel (\n"
                + "hotelId int, \n"
                + "name text, \n"
                + "phone text, \n"
                + "city text, \n"
                + "PRIMARY KEY (hotelId));";
        // Executing the query
        session.execute(tableFamilyQuery);
    }

    private static void createGuestTable(Session session) {
        String tableFamilyQuery = "CREATE TABLE guest (\n"
                + "phone text, \n"
                + "fname text, \n"
                + "lname text, \n"
                + "email text, \n"
                + "PRIMARY KEY (phone));";
        // Executing the query
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
                + "PRIMARY KEY (poiId));";
        // Executing the query
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
                + "PRIMARY KEY (roomId));";
        // Executing the query
        session.execute(tableFamilyQuery);
    }

    public static void insertFakeDataToTables(Session session) {
        insertFakeDataToHotelTable(session);
        insertFakeDataToGuestTable(session);
        insertFakeDataToReservationTable(session);
        insertFakeDataToPOITable(session);
        insertFakeDataToRoomTable(session);
    }

    private static void insertFakeDataToHotelTable(Session session) {
        for (int i = 0; i < 100; i++) {
            Hotel hotel = new Hotel(i, "هتل شماره " + i % 5, "0912111111" + i, "شهر شماره " + i);
            String query = "INSERT INTO hotel (hotelId, name, phone, city)"
                    + " VALUES "
                    + hotel.toString();
            System.out.println(query);
            session.execute(query);
        }
    }

    private static void insertFakeDataToGuestTable(Session session) {
        for (int i = 0; i < 100; i++) {
            Guest guest = new Guest("0912111111" + i, "نام مهمان " + i,
                    "نام خانوادگی مهمان " + i, "ایمیل مهمان" + i);
            String query = "INSERT INTO guest (phone, fname, lname, email)"
                    + " VALUES "
                    + guest.toString();
            System.out.println(query);
            session.execute(query);
        }
    }

    private static void insertFakeDataToReservationTable(Session session) {
    }

    private static void insertFakeDataToPOITable(Session session) {
        for (int i = 0; i < 100; i++) {
            POI poi = new POI(i, i % 50, "منظره شماره " + i);
            String query = "INSERT INTO poi (poiId, hotelId, name)"
                    + " VALUES "
                    + poi.toString();
            System.out.println(query);
            session.execute(query);
        }
    }

    private static void insertFakeDataToRoomTable(Session session) {
        for (int i = 0; i < 1000; i++) {
            Room room;
            if (i % 3 == 0) {
                // With One Facility
                room = new Room(i, i % 100, i, "قیمت اتاق " + i, "ویژگی اول");
            } else if (i % 3 == 1) {
                // With Two Facility
                room = new Room(i, i % 100, i, "قیمت اتاق " + i, "ویژگی اول", "ویژگی دوم");
            } else {
                // With Three Facility
                room = new Room(i, i % 100, i, "قیمت اتاق " + i, "ویژگی اول", "ویژگی دوم", "ویژگی سوم");
            }
            String query = "INSERT INTO room (roomId, hotelId, number, "
                    + "cost, facilityOne, facilityTwo, facilityThree )"
                    + " VALUES "
                    + room.toString();
            System.out.println(query);
            session.execute(query);
        }
    }

    public static List<Hotel> getHotelData(Session session) {
        List<Hotel> hotels = new ArrayList<>();
        // Use select to get the hotel we just entered
        ResultSet results = session.execute("SELECT * FROM hotel");
        for (Row row : results) {
            Hotel hotel = new Hotel(
                    row.getInt("hotelId"),
                    row.getString("name"),
                    row.getString("phone"),
                    row.getString("city"));
            hotels.add(hotel);
        }
        return hotels;
    }

    public static List<POI> getPOIData(Session session) {
        List<POI> pois = new ArrayList<>();
        // Use select to get the poi we just entered
        ResultSet results = session.execute("SELECT * FROM poi");
        for (Row row : results) {
            POI poi = new POI(
                    row.getInt("poiId"),
                    row.getInt("hotelId"),
                    row.getString("name"));
            pois.add(poi);
        }
        return pois;
    }

    public static List<Guest> getGuestData(Session session) {
        List<Guest> guests = new ArrayList<>();
        // Use select to get the guest we just entered
        ResultSet results = session.execute("SELECT * FROM guest");
        for (Row row : results) {
            Guest guest = new Guest(
                    row.getString("phone"),
                    row.getString("fname"),
                    row.getString("lname"),
                    row.getString("email"));

            guests.add(guest);
        }
        return guests;
    }

    public static List<Room> getRoomData(Session session) {
        List<Room> rooms = new ArrayList<>();
        // Use select to get the guest we just entered
        ResultSet results = session.execute("SELECT * FROM room");
        for (Row row : results) {
            Room room = new Room(
                    row.getInt("roomId"),
                    row.getInt("hotelId"),
                    row.getInt("number"),
                    row.getString("cost"),
                    row.getString("facilityOne"),
                    row.getString("facilityTwo"),
                    row.getString("facilityThree"));

            rooms.add(room);
        }
        return rooms;
    }

}
