<%-- 
    Document   : voucher
    Created on : Dec 2, 2023, 9:28:22 AM
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
                if (confirm("Bạn có muốn xóa voucher này không ?")) {
                    window.location = "adminDeleteVoucher?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <div class="grid wide table-wrapper">
                <div class="row container_header">
                    <div class="col l-4">
                        <h2><b>Quản lý Voucher</b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="home">Shop</a></b></h2>
                    </div>
                    <div class="col l-4">
                        <a href="addVoucher" class="container_header_add" data-toggle="modal"><i class="fa-solid fa-circle-plus"></i><span>&nbsp;Thêm Voucher mới</span></a>
                    </div>
                </div>
                <div class="table">
                    <table class="container_table">
                        <tr class="row container_table_list">
                            <th class="col l-4 container_table_item" style="text-align: center">Mã Voucher</th>
                            <th class="col l-4 container_table_item" style="text-align: center">Số tiền áp dụng</th>
                            <th class="col l-4 container_table_item" style="text-align: center">Tinh chỉnh</th>
                        </tr>
                        <c:forEach items="${listV}" var="o">
                            <tr class="row container_content_list">
                                <td class="col l-4 container_content_item" style="text-align: center">${o.getId()}</td>
                                <td class="col l-4 container_content_item" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; text-align: center">${o.moneyVoucher}</td>
                                <td class="col l-4 container_content_item"  style="text-align: center">
                                    <a href="editVoucher?id=${o.id} " class="edit " data-toggle="modal "><i class="fa-solid fa-pen" data-toggle="tooltip " title="Edit " style="color: orange;"></i></a>
                                    <a href="#" onclick="doDelete('${o.id}')" class="delete " data-toggle="modal "><i class="fa-solid fa-trash" data-toggle="tooltip " title="Delete " style="color: red;"></i></a>
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
