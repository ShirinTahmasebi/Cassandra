<%@page import="ir.ac.sbu.cassandraproject.util.CasssandraHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Hotel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html >
    <head>
        <link rel="stylesheet" type="text/css" href="css/edit_profile_style.css">
        <link rel="stylesheet" type="text/css" href="css/projects_list_admin_style.css">

        <link rel='stylesheet prefetch' href='css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/projects_list_admin_style.css">

        <script type="text/javascript" src="js/jquery-latest.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>

    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <div id="form-div">
            <form class="form" id="reservationForm" role="form" method="post" action="FilterHotelController">
                <div class = "container" dir="rtl">

                    <div class = "row" >
                        <div class = "col-md-6 col-sm-6 col-xs-6"></div>
                        <div class = "col-md-3 col-sm-3 col-xs-3">
                            <select class="form-control"  name="mySelect">
                                <%List<String> cities = new ArrayList<>();
                                    cities = CasssandraHelper.getCityData(CasssandraHelper.getSession());
                                    for (int i = 0; i < cities.size(); i++) {
                                %>
                                <option value= <%=i + ""%>> <%=cities.get(i)%> </option>
                                <%}%>
                            </select>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">شهر مورد نظر خود را انتخاب کنید:</div>
                    </div>

                    <hr>

                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="اعمال فیلتر" id="button-red"/>
                                <div class="ease"></div>
                            </div>
                        </div>
                        <div class = "col-md-4 col-sm-4 col-xs-4"></div>
                    </div>

                    <div id="table" >
                        <div class="table-responsive">
                            <table id="hotelTable"class="table hover" collapsing="0" width="100%" >
                                <thead>  
                                    <tr >  
                                        <th style="text-align:right;">کلید</th>  
                                        <th style="text-align:right;">نام</th>
                                        <th style="text-align:right;">شهر</th>
                                        <th style="text-align:right;">تلفن</th>
                                    </tr>  
                                </thead>  
                                <tbody>  
                                    <%  List<Hotel> hotels = new ArrayList<>();
                                        if (request.getAttribute("hotelList") == null) {
                                            hotels = CasssandraHelper.getHotelData(CasssandraHelper.getSession());
                                        } else {
                                            hotels = (List<Hotel>) request.getAttribute("hotelList");
                                        }
                                        for (Hotel hotel : hotels) {
                                    %>
                                    <tr>
                                        <td><%=hotel.id + ""%></td>  
                                        <td><%=hotel.name%></td>
                                        <td><%=hotel.city%></td>
                                        <td><%=hotel.phone%></td>
                                    </tr>
                                    <%}%>
                                </tbody>  
                            </table>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

