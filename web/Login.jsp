<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link rel="stylesheet" href="./css/style.css"/>
        <title>Login Form</title>
    </head>
    <body>
        <div id="logreg-forms">
            <form class="form-signin" action="login" method="post">
                <h1 class="signin"> Đăng nhập</h1>
                <p class="signin_error">${error}</p>
                <input name="user" type="text" id="inputEmail" class="signin_signup" placeholder="Username" required="" autofocus="">
                <input name="pass" type="password" id="inputPassword" class="signin_signup" placeholder="Password" required="">
                <div class="signin_check">
                    <input name="remember" value="1" type="checkbox" class="signin-checkbox" id="exampleCheck1">
                    <label class="signin_check_miss" for="exampleCheck1">&nbsp;Nhớ tài khoản</label>
                </div>
                <button class="sigin_login_btn" type="submit"><i class="fa-solid fa-right-to-bracket"></i>&nbsp;Đăng nhập</button>
                <hr>
                <button class="sigin_register_btn" type="button" id="btn-signup"><i class="fa-solid fa-user-plus"></i> Tạo tài khoản</button>
            </form>
            <form action="signup" method="post" class="form-signup">
                <h1 class="signup" style="text-align: center">&nbsp;Tạo tài khoản</h1>
                <p class="signin_error">${error}</p>
                <input name="user" type="text" id="user-name" class="signin_signup" placeholder="User name" required="" autofocus="">
                <input name="pass" type="password" id="user-pass" class="signin_signup" placeholder="Password" required autofocus="">
                <input name="repass" type="password" id="user-repeatpass" class="signin_signup" placeholder="Repeat Password" required autofocus="">
                <button class="signup_register_btn" type="submit"><i class="fa-solid fa-user-plus"></i>&nbsp;Tạo tài khoản</button>
                <a href="#" id="cancel_signup" class="signup_back"><i class="fa-solid fa-angle-left"></i>&nbsp;Quay lại</a>
            </form>
            <br>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                document.querySelector('.form-signup').style.display = 'none';
                document.querySelector('.sigin_register_btn').addEventListener('click', function () {
                    document.querySelector('.form-signin').style.display = 'none';
                    document.querySelector('.form-signup').style.display = 'block';
                });
                document.querySelector('#cancel_signup').addEventListener('click', function () {
                    document.querySelector('.form-signup').style.display = 'none';
                    document.querySelector('.form-signin').style.display = 'block';
                });
            });
        </script>
    </body>
</html>