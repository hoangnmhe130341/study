<%-- 
    Document   : index.jsp
    Created on : Nov 13, 2019, 8:32:22 PM
    Author     : Shado
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/sb-admin-2.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/3607879eb4.js" crossorigin="anonymous"></script>
        <title>JSP Page</title>
        <style>
            table {
                border-collapse: collapse;
                border-spacing: 0;
                width: 100%;
                border: 1px solid #ddd;
            }
            tr:nth-child(even)
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-dark sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="home">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink" aria-hidden="true"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Admin</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">
                        <i class="fas fa-fw fa-tachometer-alt" aria-hidden="true"></i>
                        <span>Dashboard</span></a>
                </li>

                <hr class="sidebar-divider mb-3">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="btn btn-outline-light ml-4" href="view"><i class="far fa-eye mr-2"></i>View Room</a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-outline-light ml-4 mt-3" href="calendar"><i class="fas fa-calendar-alt mr-2"></i>View Schedule</a>
                </li>

                <hr class="sidebar-divider mb-3 mt-3">


                <!-- Nav Item - Utilities Collapse Menu -->

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content" style="padding: 20px;">

                    <!-- Topbar -->

                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <h1 class="text-success text-center">Schedule</h1>
                    <form class="mt-3 w-25"action="calendar" method="post"  >
                        <h3>Choose Date</h3>
                        From:<input class="form-control w-75 ml-2"type="date" name="from" value="${requestScope.listDate.get(0)}" required/>
                        To: <input class="form-control w-75 ml-2"type="date" 
                                   name="to" 
                                   value="${requestScope.listDate.get(requestScope.listDate.size()-1)}"  required
                                   />
                        <input class="btn btn-outline-success mt-2 ml-2" type="submit" value="Search">
                    </form>
                    <br />
                    <div style="overflow-x:auto;">
                        <table class="table">
                            <tr >
                                <th>Room\Date</th>
                                    <c:forEach items="${requestScope.listDate}" var="date" >
                                    <td class="table-info" style="border-right: 1px solid black; border-bottom:  1px solid black;">
                                        <h5>
                                            <fmt:parseDate value="${date}" pattern="yyyy-MM-dd" var="parseDate" />
                                            <fmt:formatDate value="${parseDate}" pattern="dd/MM" />
                                        </h5>
                                    </td>
                                </c:forEach>
                            </tr>
                            <c:forEach items="${requestScope.listRoom}" var="room" >
                                <tr>
                                    <td class="table-info"><h5>${room.name}</h5></td>
                                            <c:forEach items="${requestScope.listDate}" var="i" >
                                        <td style="padding: 0px;">
                                            <c:forEach items="${room.schedule}" var="sc">
                                                <c:if test="${room.isSchedule(sc.from, i, sc.to)}">
                                                    <span  class="d-inline-block bg-warning w-100" tabindex="0" data-toggle="tooltip" title="${room.name}">&nbsp;</span> 
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <!-- End of Content Wrapper -->

                </div>
            </div>
        </div>

        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </body>
</html>
