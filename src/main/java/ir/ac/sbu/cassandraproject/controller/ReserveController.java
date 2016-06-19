package ir.ac.sbu.cassandraproject.controller;

import ir.ac.sbu.cassandraproject.dao.model.AvailableRoom;
import ir.ac.sbu.cassandraproject.dao.model.Guest;
import ir.ac.sbu.cassandraproject.dao.model.Reservation;
import ir.ac.sbu.cassandraproject.util.CasssandraHelper;
import ir.ac.sbu.redisproject.util.Helper;
import ir.ac.sbu.redisproject.util.Response;
import ir.ac.sbu.redisproject.util.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ReserveController", urlPatterns = {"/ReserveController"})
public class ReserveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();

        String guestRowId = Helper.getRequestString(request, "mySelect1");
        String roomRowId = Helper.getRequestString(request, "mySelect2");

        Guest g = CasssandraHelper.getGuestData(CasssandraHelper.getSession()).get(Integer.parseInt(guestRowId));
        AvailableRoom r = CasssandraHelper.getAvailableRoomData(CasssandraHelper.getSession()).get(Integer.parseInt(roomRowId));
        int resId = CasssandraHelper.getReservationData(CasssandraHelper.getSession()).size();
        String guestId = g.phone;
        int roomId = r.roomId;
        int hotelId = r.hotelId;

        CasssandraHelper.deleteFromAvailableRoomTable(
                CasssandraHelper.getSession(),
                new AvailableRoom(roomId, hotelId)
        );
        CasssandraHelper.insertDataToReservationTable(
                CasssandraHelper.getSession(), 
                new Reservation(resId, hotelId, roomId, guestId));
        
        response.sendRedirect(Tag.FIRST_PAGE);
    }

}
