<%-- 
    Document   : AddProduct
    Created on : 21-11-2023, 18:56:06
    Author     : chuva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="content_add">
            <form action="add" method="post" class="content_add_form">
                <div class="content_header">
                    <h4 class="content_header_title">Thêm sản phẩm</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Tên sản phẩm</label>
                        <input name="name" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Hình ảnh</label>
                        <input name="image" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input name="price" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Số lượng</label>
                        <input name="amount" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Tiêu đề</label>
                        <textarea name="title" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Miêu tả</label>
                        <textarea name="description" class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Nhãn hiệu</label>
                        <select name="category" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listC}" var="o">
                                <option value="${o.cid}">${o.cname}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="content_footer">
                    <a href="manager" style="text-decoration: none">
                        <input type="button" class="content_footer_btn1" data-dismiss="modal" value="Quay lại">
                    </a>
                    <input type="submit" class="content_footer_btn" value="Thêm">
                </div>
            </form>
        </div>
    </body>
</html>
