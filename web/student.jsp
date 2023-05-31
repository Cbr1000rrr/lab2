<%-- 
    Document   : student
    Created on : Apr 15, 2023, 8:01:50 PM
    Author     : 84375
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="post" action="StudentServlet">
            NumberOfStudent: <input type="text" name="numberOfStudent" value=""> <input type="submit" name="generate" value="Generate"> 
            <c:choose>
                <c:when test="${!(data eq null)}">
                    <table border="1">
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Gender</td>
                            <td>DOB</td>
                        </tr>
                        <c:forEach items="${data}" var="item">
                            <tr>
                                <td>${item.getId()}</td>
                                <td>${item.getName()}</td>
                                <c:if test="${item.isGender() eq true}">
                                    <td><input type="checkbox" name="checkbox" value="" checked="">  </td>
                                </c:if>
                                <c:if test="${item.isGender() eq false}">
                                    <td><input type="checkbox" name="checkbox" value="" >  </td>
                                </c:if>
                                <td>${item.getDOB()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
            </c:choose>
        </form>
    </body>
</html>
