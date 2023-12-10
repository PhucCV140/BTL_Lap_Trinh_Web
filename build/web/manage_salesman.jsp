<%-- 
    Document   : manage_salesman
    Created on : 21-11-2023, 20:54:53
    Author     : chuva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý người bán</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Bạn có muốn xóa người bán hàng này không ?" )) {
                    window.location = "deleteSalesman?accID=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="grid wide table-wrapper">
                <div class="row container_header">
                    <div class="col l-4">
                        <h2><b>Quản lý người bán</b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="home">Shop</a></b></h2>
                    </div>
                    <div class="col l-4">
                        <a href="addSalesman" class="container_header_add" data-toggle="modal"><i class="fa-solid fa-circle-plus"></i><span>&nbsp;Thêm người bán</span></a>
                    </div>
                </div>
                <div class="table">
                    <table class="container_table">
                        <tr class="row container_table_list">
                            <th class="col l-1 container_table_item">ID</th>
                            <th class="col l-3 container_table_item">Tên người bán</th>
                            <th class="col l-2 container_table_item">Số mặt hàng cần bán</th>
                            <th class="col l-2 container_table_item">Số lượng hàng đã bán</th>
                            <th class="col l-2 container_table_item">Số tiền đã thu về</th>
                            <th class="col l-2 container_table_item">Tinh chỉnh</th>
                        </tr>
                        <c:forEach items="${list}" var="o">
                            <tr class="row container_content_list">
                                <td class="col l-1 container_content_item">${o.getId()}</td>
                                <td class="col l-3 container_content_item" style="margin-left: 10px">${o.user}</td>
                                <td class="col l-2 container_content_item" style="padding-left: 90px">${o.canBan}</td>
                                <td class="col l-2 container_content_item" style="padding-left: 90px">${o.daBan}</td>
                                <td class="col l-2 container_content_item" style="padding-left: 60px">${o.tienThuVe} $</td>
                                <td class="col l-2 container_content_item" style="margin-left: -10px">
                                    <a href="editSalesman?accID=${o.id} " data-toggle="modal "><i class="fa-solid fa-pen" data-toggle="tooltip " title="Edit " style="color: orange;"></i></a>
                                    <a href="#" onclick="doDelete('${o.id}')"><i class="fa-solid fa-trash" data-toggle="tooltip " title="Delete " style="color: red;"></i></a>
                                    <a href="viewSalesman?accID=${o.id} " data-toggle="modal "><i class="fa-solid fa-eye" data-toggle="tooltip " title="View " style="color: blue;"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
