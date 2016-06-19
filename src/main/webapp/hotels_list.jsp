<%@page import="ir.ac.sbu.cassandraproject.util.CasssandraHelper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Hotel"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Hotel"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Hotel"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Hotel"%>
<html dir="rtl" lang="fa">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
        <link rel="stylesheet" type="text/css" href="css/table_style.css">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body  class= "table-body">
        <%@ include file="menu.jsp" %> 
        <div style="height:50px;"></div>
        <div style="margin:20px auto" class="container" >
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
                            hotels = CasssandraHelper.getHotelData(CasssandraHelper.getSession());
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
    </body>
</html>