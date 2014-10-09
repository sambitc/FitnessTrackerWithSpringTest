<%-- 
    Document   : getGoals
    Created on : May 26, 2014, 3:37:10 PM
    Author     : sambitc
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Goal Reports</title>
    </head>
    <body>



        <table>
            <tr>
                <th>ID</th>
                <th>Minutes</th>
            </tr>

            <c:forEach items="${goals}" var="goal">

                <tr>
                    <td>${goal.id}</td>
                    <td>${goal.minutes}</td>

                    <td>
                        <table>
                            <tr>
                                <th>Exercise ID</th>
                                <th>Exercise Minutes</th>
                                <th>Exercise Activity</th>
                            </tr>
                            
                            <c:forEach items="${goal.exercises}" var="exercise">
                                <tr>
                                    <td>${exercise.id}</td>
                                    <td>${exercise.minutes}</td>
                                    <td>${exercise.activity}</td>
                                </tr>
                                
                            </c:forEach>
                            
                        </table>
                    </td>
                </tr>

            </c:forEach>

        </table>



    </body>
</html>
