<%@page import="ir.ac.sbu.cassandraproject.util.CasssandraHelper"%>
<html>
    <head>
        <meta charset = "UTF-8">
        <link rel="stylesheet" type="text/css" href="css/table_style.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">   
        <script src="js/jquery-latest.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/first_page_style.css">
        <title>Collapsing Header Effect</title>
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    </head>
    <body>
        <div id ="container">
            <header>
                <%@ include file="menu.jsp" %> 
            </header>

            <% CasssandraHelper.createTable(CasssandraHelper.getSession());
            %>

            <div id="banner">
                <script src="js/slider_contents.js"></script>
            </div>
            <div id = "content" dir="rtl">
                <div class="text-center">
                    <h1>برنامه نویسی، طراحی، ترجمه و بیشتر!</h1>
                </div>

                <div class="row">
                    <div class="col-sm-2">
                    </div>
                    <div class="col-sm-8">
                        <div class="row margin-top-25">
                            <div class="col-sm-4">
                                <div class="text-center">
                                    <img src="img/step1-.png" width="200" alt="ایجاد پروژه جدید">
                                    <h3 >ایجاد پروژه جدید</h3>
                                    <br>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class=" text-center">
                                    <img src="img/step-2.png" width="200" alt="انتخاب بهترین پیشنهاد">
                                    <h3 >انتخاب بهترین پیشنهاد</h3>
                                    <br>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="text-center">
                                    <img src="img/step-3.png" width="200" alt="پرداخت پس از دریافت کار">
                                    <h3 >پرداخت پس از دریافت کار</h3>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2"></div>

                </div>

            </div>	
        </div>

        <script type='text/javascript'>

            $(document).ready(function () {


                $('#myTable').on('click', 'tbody tr', function () {
                    window.location.href = "index.html";
                });
            });
        </script>
    </body>

</html>