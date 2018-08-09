<%@ page contentType="text/html; charset=UTF-8" %>
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
        <div>编号：${student.id}</div>
        <div>姓名：${student.name}</div>
        <div>年龄：${student.age}</div>
    </body>
</html>