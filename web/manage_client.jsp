<%-- 
    Document   : manage_client
    Created on : 21-11-2023, 20:54:29
    Author     : chuva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý khách hàng</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Bạn có muốn xóa người dùng này không ?" )) {
                    window.location = "deleteClient?accID=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="grid wide">
                <div class="row container_header">
                    <div class="col l-4">
                        <h2><b>Quản lý khách hàng</b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="home">Shop</a></b></h2>
                    </div>
                    <div class="col l-4">
                        <a href="addClient" class="container_header_add" data-toggle="modal"><i class="fa-solid fa-circle-plus"></i><span>&nbsp;Thêm khách hàng</span></a>
                    </div>
                </div>
                <div class="table">
                    <table class="container_table">
                        <tr class="row container_table_list">
                            <th class="col l-2 container_table_item">ID</th>
                            <th class="col l-3 container_table_item">Tên khách hàng</th>
                            <th class="col l-2 container_table_item">Số lượng hàng đã mua</th>
                            <th class="col l-3 container_table_item">Số tiền đã thanh toán</th>
                            <th class="col l-2 container_table_item">Tinh chỉnh</th>
                        </tr>
                        <c:forEach items="${list}" var="o">
                            <tr class="row container_content_list">
                                <td class="col l-2 container_content_item">${o.getId()}</td>
                                <td class="col l-3 container_content_item">${o.user}</td>
                                <td class="col l-2 container_content_item">${o.daMua}</td>
                                <td class="col l-3 container_content_item">${o.daThanhToan} $</td>
                                <td class="col l-2 container_content_item" style="margin-left: -10px">
                                    <a href="editClient?accID=${o.id} " data-toggle="modal "><i class="fa-solid fa-pen" data-toggle="tooltip " title="Edit " style="color: orange;"></i></a>
                                    <a href="#" onclick="doDelete('${o.id}')" data-toggle="modal "><i class="fa-solid fa-trash" data-toggle="tooltip " title="Delete " style="color: red;"></i></a>
                                    <a href="viewClient?accID=${o.id} " data-toggle="modal "><i class="fa-solid fa-eye" data-toggle="tooltip " title="View " style="color: blue;"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
