<%-- 
    Document   : addVoucher
    Created on : Dec 2, 2023, 9:59:04 AM
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
            <form action="addVoucher" method="post" class="content_add_form">
                <div class="content_header">
                    <h4 class="content_header_title">Thêm Voucher</h4>
                </div>
                <h3 style="color: red; margin-bottom: 20px">${requestScope.error}</h3>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Mã Voucher</label>
                        <input name="id" type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Số tiền áp dụng</label>
                        <input name="money" type="text" class="form-control" required>
                    </div>
                </div>
                <div class="content_footer">
                    <a href="voucher" style="text-decoration: none">
                        <input type="button" class="content_footer_btn1" data-dismiss="modal" value="Quay lại">
                    </a>
                    <input type="submit" class="content_footer_btn" value="Thêm">
                </div>
            </form>
        </div>
    </body>
</html>
