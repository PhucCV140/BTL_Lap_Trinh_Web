<%-- 
    Document   : Menu
    Created on : 10-11-2023, 22:30:08
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
        <script type="text/javascript">
            function doUpdate(id) {
                if (confirm("Bạn có muốn trở thành người bán hàng không ?"+"\n"+"Sau khi đăng ký cần phải đăng nhập lại" )) {
                    window.location = "registerSales?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <!-- begin header -->
        <div class="header">
            <div class="header_nav" style="padding: 0 100px;">
                <a class="header_nav_home" href="home">Shop</a>
                <div class="header_nav_actions">
                    <ul class="header_nav_list">
                        <c:if test="${sessionScope.acc.isAdmin==1}">
                            <li class="header_nav_item">
                                <a href="#"> Quản lý tài khoản&nbsp;<i class="fa-solid fa-caret-down"></i></a>
                                <ul class="header_nav_item_list">
                                    <li class="header_nav_item_item" style="height: 60px; padding: 0; line-height: 60px;">
                                        <a href="client">Quản lý khách hàng</a>
                                    </li>
                                    <li class="header_nav_item_item" style="height: 60px; padding: 0; line-height: 60px;">
                                        <a href="salesman">Quản lý người bán</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="header_nav_item">
                                <a href="voucher">&nbsp;Quản lý Voucher</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc.isSell==1}">
                            <li class="header_nav_item">
                                <a href="manager">&nbsp;Quản lý sản phẩm</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc!=null}">
                            <li class="header_nav_item">
                                <a href="#">Xin chào ${sessionScope.acc.user}</a>
                            </li>
                            <li class="header_nav_item">
                                <a href="logout">&nbsp;Đăng xuất</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc==null}">
                            <li class="header_nav_item">
                                <a href="Login.jsp">&nbsp;Đăng nhập</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc.isSell==0 and sessionScope.acc.isAdmin==0}">
                            <li class="header_nav_item">
                                <a href="#" onclick="doUpdate('${sessionScope.acc.getId()}')">&nbsp;Đăng ký bán hàng</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc!=null}">
                            <li class="header_nav_item">
                                <a href="purchased">&nbsp;Sản phẩm đã mua</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <form action="search" method="post" class="header_nav_action">
                    <div class="header_nav_search">
                        <input value="${txtS}" name="txt" type="text" class="header_nav_input" aria-label="Small"
                               aria-describedby="inputGroup-sizing-sm" placeholder="Tìm kiếm...">
                        <div class="header_nav_icon">
                            <button type="submit" class="header_nav_submit">
                                <i class="fa-solid fa-magnifying-glass header_nav_submit_icon"></i>
                            </button>
                        </div>
                    </div>
                    <a class="header_nav_cart" href="show">
                        <i class="fa-solid fa-cart-shopping"></i>&nbsp;Giỏ hàng&nbsp;
                        <span class="header_nav_quantity">${sessionScope.totalProduct}</span>
                    </a>
                </form>
            </div>
        </div>
        <!-- end header -->
    </body>
</html>
