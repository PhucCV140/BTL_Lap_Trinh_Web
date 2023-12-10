<%-- 
    Document   : viewClient
    Created on : 24-11-2023, 21:12:15
    Author     : chuva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="container">
            <div class="grid wide table-wrapper">
                <div class="row container_header">
                    <div class="col l-4">
                        <h2><b>Sản phẩm khách đã mua</b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="home">Shop</a></b></h2>
                    </div>
                    <div class="col l-4">
                        <h2><b><a class="container_header_txt" style="text-decoration: none" href="client">Quay lại</a></b></h2>
                    </div>
                </div>
                <div class="table">
                    <table class="container_table">
                        <tr class="row container_table_list">
                            <th class="col l-3 container_table_item">Tên sản phẩm</th>
                            <th class="col l-1 container_table_item">Số lượng</th>
                            <th class="col l-2 container_table_item">Tiền thanh toán</th>
                            <th class="col l-3 container_table_item">Hình ảnh</th>
                            <th class="col l-3 container_table_item">Ngày mua hàng</th>
                        </tr>
                        <c:forEach items="${listCart}" var="o">
                            <tr class="row container_content_list">
                                <td class="col l-3 container_content_item">${o.productName}</td>
                                <td class="col l-1 container_content_item">${o.quantity}</td>
                                <td class="col l-2 container_content_item">${o.totalPayment}</td>
                                <td class="col l-3 container_content_item">
                                    <img src="${o.productImage}">
                                </td>
                                <td class="col l-3 container_content_item" style="padding-left: 10px;">${o.getPurchasedDate()}</td>
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
