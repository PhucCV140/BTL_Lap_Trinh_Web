<%-- 
    Document   : editVoucher
    Created on : Dec 2, 2023, 9:58:50 AM
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
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <div class="header">
                <h2><b>Thay đổi thông tin Voucher</b></h2>
            </div>
            <div id="addEmployeeModal">
                <div class="content">
                    <form action="editVoucher" method="post" class="content_form">
                        <div class="content_header">
                            <h4 class="content_header_title">Thay đổi Voucher</h4>
                        </div>
                        <div class="content_body">
                            <div class="form-group">
                                <label>Mã Voucher</label>
                                <input value="${v.id}" name="id" type="text" class="form-control" readonly required>
                            </div>
                            <div class="form-group">
                                <label>Số tiền áp dụng</label>
                                <input value="${v.moneyVoucher}" name="money" type="text" class="form-control" required>
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
