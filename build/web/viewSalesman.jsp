<%-- 
    Document   : viewSalesman
    Created on : 24-11-2023, 21:14:31
    Author     : chuva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Bạn có muốn xóa sản phẩm này không ?")) {
                    window.location = "adminDeleteProduct?pid=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="grid wide table-wrapper">
                <div class="row container_header">
                    <div class="col l-4">
                        <h2><b>Sản phẩm muốn bán</b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="home">Shop</a></b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="salesman">Quay lại</a></b></h2>
                    </div>
<!--                    <div class="col l-3">
                        <a href="adminAddProduct" class="container_header_add" data-toggle="modal"><i class="fa-solid fa-circle-plus"></i><span>&nbsp;Thêm sản phẩm mới</span></a>
                    </div>-->
                </div>
                <div class="table">
                    <table class="container_table">
                        <tr class="row container_table_list">
                            <th class="col l-1 container_table_item">ID</th>
                            <th class="col l-3 container_table_item">Tên sản phẩm</th>
                            <th class="col l-3 container_table_item">Hình ảnh</th>
                            <th class="col l-1 container_table_item">Số lượng</th>
                            <th class="col l-2 container_table_item">Giá</th>
                            <th class="col l-2 container_table_item">Tinh chỉnh</th>
                        </tr>
                        <c:forEach items="${listP}" var="o">
                            <tr class="row container_content_list">
                                <td class="col l-1 container_content_item">${o.getId()}</td>
                                <td class="col l-3 container_content_item" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${o.name}</td>
                                <td class="col l-3 container_content_item">
                                    <img src="${o.image}">
                                </td>
                                <td class="col l-1 container_content_item" style="text-align: center">${o.amount}</td>
                                <td class="col l-2 container_content_item">${o.price} $</td>
                                <td class="col l-2 container_content_item">
                                    <!--<a href="loadProduct?pid=${o.id} " class="edit " data-toggle="modal "><i class="fa-solid fa-pen" data-toggle="tooltip " title="Edit " style="color: orange;"></i></a>-->
                                    <a href="#" onclick="doDelete('${o.id}')" class="delete " data-toggle="modal "><i class="fa-solid fa-trash" data-toggle="tooltip " title="Delete " style="color: red;padding-left: 10px;"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="row">
                    <div class="col l-12">
                        <h1 style="text-align: center;margin-top: 40px">${notification}</h1>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
