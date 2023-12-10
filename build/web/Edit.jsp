<%-- 
    Document   : ManagerProduct
    Created on : 10-11-2023, 22:47:46
    Author     : chuva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="main">
            <div class="header">
                <h2><b>Thay đổi thông tin sản phẩm</b></h2>
            </div>
            <div id="addEmployeeModal">
                <div class="content">
                    <form action="edit" method="post" class="content_form">
                        <div class="content_header">
                            <h4 class="content_header_title">Thay đổi thông tin</h4>
                        </div>
                        <div class="content_body">
                            <div class="form-group">
                                <label>ID</label>
                                <input value="${detail.id}" name="id" type="text" class="form-control" readonly required>
                            </div>
                            <div class="form-group">
                                <label>Tên sản phẩm</label>
                                <input value="${detail.name}" name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Hình ảnh</label>
                                <input value="${detail.image}" name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Giá</label>
                                <input value="${detail.price}" name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Số lượng</label>
                                <input value="${detail.amount}" name="amount" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Tiêu đề</label>
                                <textarea name="title" class="form-control" required>${detail.title}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Miêu tả</label>
                                <textarea name="description" class="form-control" required>${detail.description}</textarea>
                            </div>
                            <div class="form-group">
                                <label>Nhãn hiệu</label>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <!-- <c:forEach items="${listC}" var="o"> -->
                                        <option value="${o.cid}"><p>${o.cname}</p></option>
                                        <!-- </c:forEach> -->
                                </select>
                            </div>

                        </div>
                        <div class="content_footer">
                            <input type="submit" class="content_footer_btn" value="Thay đổi">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>