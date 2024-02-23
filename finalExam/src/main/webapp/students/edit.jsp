<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/22/2024
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa thông tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Chỉnh sửa thông tin</h1>
            <div class="form-group">
                <label for="nameStudent">Name</label>
                <input type="text" class="form-control" name="nameStudent" id="nameStudent" value="${requestScope["students"].getNameStudent()}">
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="text" class="form-control" name="email" id="email" value="${requestScope["students"].getEmail()}">
            </div>
            <div class="form-group">
                <label for="dateOfBirth">Date of Birth</label>
                <input type="text" class="form-control" name="dateOfBirth" id="dateOfBirth" value="${requestScope["students"].getDateOfBirth()}">
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" name="address" id="address" value="${requestScope["students"].getAddress()}">
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="text" class="form-control" name="phone" id="phone" value="${requestScope["students"].getPhone()}">
            </div>
            <div class="form-group">
                <label for="id_class">Lớp</label>
                <select id="id_class" class="form-control" name="id_class">
                    <c:forEach items="${classes}" var="c">
                        <option value="${c.idClass}">${c.nameClass}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Lưu thông tin</button>
                <a class="btn btn-warning" role="button" href="/students">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
