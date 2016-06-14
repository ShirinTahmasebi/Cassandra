<%@page import="ir.ac.sbu.redisproject.dao.model.User"%>
<%@page import="ir.ac.sbu.redisproject.util.Tag"%>
<html>
    <head>
        <link rel="stylesheet" href="css/menu_style.css">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    </head>
    <body style= "margin:0">
        <div id = "mySidenav" class = "sidenav">
            <a href="javascript:void(0)" class="closebtn menu-item-line" onclick="closeNav()">x</a>
           
        </div>
        <div id="header">
            <span style="box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24); font-size:15px;cursor:pointer;position: absolute;right:10px;top:5px; border:1px solid black; margin: 5px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#ffffff;" onclick="openNav()">
                <img src="img/menu-black.png"/> 
            </span>
            <span dir="rtl" style="cursor:pointer;position: absolute;right:100px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">
                <%if (session.getAttribute(Tag.USER) != null) {
                        out.println(
                                "<span id='header_text' style='cursor:pointer;position: absolute;right:50px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;' onclick='openProfileLink();'>Ø³ÙØ§ÙØ" + (((User) session.getAttribute(Tag.USER)).getUserName()) + "</span>");
                    } else {
                        out.println(
                                "<span id='header_text' style='cursor:pointer;position: absolute;right:50px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;' onclick='openLoginLink();'>ÙØ§Ø±Ø¯&nbspØ´ÙÛØ¯</span>");
                    }
                %>
            </span>
            <span style="cursor:pointer;position: absolute;left:10px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">
                <a href="first_page.jsp" id="logo"></a>
            </span>
            <span id="header_text" style="cursor:pointer;position: absolute;left:110px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;" onclick="openLink();">Ù¾Ø±ÙÚÙ Ø¯Ø±Ø³ ÙÙØ¶ÙØ¹Ø§Øª Ù¾ÛØ´Ø±ÙØªÙ :) </span>
        </div>
        <!-- Slidebars -->
        <script src="js/menu_functions.js"></script>
    </body>
</html>