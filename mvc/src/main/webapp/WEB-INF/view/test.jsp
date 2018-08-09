<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>实体类测试</title>
        <style>
            table, tr, td{
                border: 0px solid brown;
            }
        </style>
    </head>
    <body>

    <h2>Student Information</h2>
        <table>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>