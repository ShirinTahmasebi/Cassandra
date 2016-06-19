<%@page import="ir.ac.sbu.cassandraproject.dao.model.Guest"%>
<%@page import="java.util.List"%>
<%@page import="ir.ac.sbu.cassandraproject.util.CasssandraHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.AvailableRoom"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/contact_us_style.css">  
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <div id="form-main" dir = "rtl">
            <div id="form-div">
                <form class="form" id="reservationForm" role="form" method="post" action="ReserveController">

                    <div class = "lables">نام و نام خانوادگی مهمان مورد نظر خود را مشخص کنید:</div>
                    <br>
                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6"></div>
                        <div class = "col-md-6 col-sm-6 col-xs-6">
                            <select class="form-control" 
                                    style="font-size: 30px;margin: 10px; "
                                    name="mySelect1">
                                <%List<Guest> guests = new ArrayList<>();
                                    guests = CasssandraHelper.getGuestData(CasssandraHelper.getSession());
                                    for (int i = 0; i < guests.size(); i++) {
                                        Guest g = guests.get(i);
                                %>
                                <option value= <%=i + ""%>> <%=g.fname%>   <%=g.lname%>  </option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <hr>

                    <div class = "lables">شماره هتل و اتاق خود را مشخص کنید:</div>
                    <br>
                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6"></div>
                        <div class = "col-md-6 col-sm-6 col-xs-6">
                            <select class="form-control" 
                                    style="font-size: 30px;margin: 10px; "
                                    name="mySelect2">
                                <%List<AvailableRoom> rooms = new ArrayList<>();
                                    rooms = CasssandraHelper.getAvailableRoomData(CasssandraHelper.getSession());
                                    for (int i = 0; i < rooms.size(); i++) {
                                        AvailableRoom room = rooms.get(i);
                                %>
                                <option value= <%=i + ""%>> هتل شماره <%=room.hotelId%>  اتاق شماره   <%=room.roomId%>  </option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <hr>
                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6">
                            <div class="submit">
                                <input type="submit" value="رزرو" id="button-red"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </body>
</html>

