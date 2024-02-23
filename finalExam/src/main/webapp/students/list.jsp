<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/22/2024
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách học viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="my-3">Danh sách học viên</h1>
    <div class="row d-flex mx-3">
        <div class="col-8">
            <a class="btn btn-warning" role="button" href="/students?action=create">Thêm mới</a>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">DateOfBirth</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Phone</th>
            <th scope="col">Classroom</th>


            <th scope="col">Chỉnh sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="s" items="${listStudent}" >
            <tr>
                <td>${s.id_student}</td>
                <td>${s.nameStudent}</td>
                <td>${s.email}</td>
                <td>${s.dateOfBirth}</td>
                <td>${s.address}</td>
                <td>${s.phone}</td>
                <td>${s.nameClass}</td>
                <td>
                    <a class="btn btn-warning" href="/students?action=edit&id_student=${s.id_student}" role="button">Chỉnh
                        sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="/students?action=delete&id_student=${s.id_student}" role="button">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
