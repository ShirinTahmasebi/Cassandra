package ir.ac.sbu.cassandraproject.controller;

import ir.ac.sbu.cassandraproject.dao.model.AvailableRoom;
import ir.ac.sbu.cassandraproject.dao.model.Guest;
import ir.ac.sbu.cassandraproject.dao.model.Hotel;
import ir.ac.sbu.cassandraproject.dao.model.Reservation;
import ir.ac.sbu.cassandraproject.util.CasssandraHelper;
import ir.ac.sbu.redisproject.util.Helper;
import ir.ac.sbu.redisproject.util.Response;
import ir.ac.sbu.redisproject.util.Tag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FilterHotelController", urlPatterns = {"/FilterHotelController"})
public class FilterHotelController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();

        String cityRowId = Helper.getRequestString(request, "mySelect");
        String city = CasssandraHelper.getCityData(CasssandraHelper.getSession()).get(Integer.parseInt(cityRowId));

        List<Hotel> hotels = new ArrayList<>();
        hotels = CasssandraHelper.getHotelByCityData(
                CasssandraHelper.getSession(),
                city
        );
        String url = "/search_hotel.jsp";

        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);

        request.setAttribute("hotelList", hotels);
        rd.forward(request, response);

    }
}
