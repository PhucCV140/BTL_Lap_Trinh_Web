<%-- 
    Document   : addSalesman
    Created on : 24-11-2023, 20:17:21
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
        <link rel="stylesheet" href="./css/style.css"/>
    </head>
    <body>
        <div id="logreg-forms">
            <form action="addSalesman" method="post" class="form-signup" style="display: block">
                <h1 class="signup" style="text-align: center">&nbsp;Tạo tài khoản</h1>
                <h3 style="color: red; margin-bottom: 20px">${requestScope.error}</h3>
                <input name="user" type="text" id="user-name" class="signin_signup" placeholder="User name" required="" autofocus="">
                <input name="pass" type="password" id="user-pass" class="signin_signup" placeholder="Password" required autofocus="">
                <input name="repass" type="password" id="user-repeatpass" class="signin_signup" placeholder="Repeat Password" required autofocus="">
                <button class="signup_register_btn" type="submit"><i class="fa-solid fa-user-plus"></i>&nbsp;Tạo tài khoản</button>
                <a href="salesman" id="cancel_signup" class="signup_back"><i class="fa-solid fa-angle-left"></i>&nbsp;Quay lại</a>
            </form>
            <br>
        </div>
    </body>
</html>
