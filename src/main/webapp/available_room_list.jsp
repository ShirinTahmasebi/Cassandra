<%@page import="ir.ac.sbu.cassandraproject.dao.model.AvailableRoom"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.Reservation"%>
<%@page import="ir.ac.sbu.cassandraproject.dao.model.POI"%>
<%@page import="ir.ac.sbu.cassandraproject.util.CasssandraHelper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
                            <th style="text-align:right;">کلید&nbsp;هتل</th>
                            <th style="text-align:right;">کلید&nbsp;اتاق</th>
                        </tr>  
                    </thead>  
                    <tbody>  
                        <%  List<AvailableRoom> rooms = new ArrayList<>();
                            rooms = CasssandraHelper.getAvailableRoomData(CasssandraHelper.getSession());
                            for (AvailableRoom room : rooms) {
                        %>
                        <tr>
                            <td><%=room.hotelId + ""%></td>  
                            <td><%=room.roomId + ""%></td>  
                        </tr>
                        <%}%>
                    </tbody>  
                </table> 
            </div>
        </div>
    </body>
</html>