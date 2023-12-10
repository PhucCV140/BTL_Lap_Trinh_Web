<%-- 
    Document   : Detail
    Created on : 10-11-2023, 22:47:46
    Author     : chuva
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-...your-sha-here..." crossorigin="anonymous">
        <link rel="stylesheet" href="./css/responsive.css"/>
        <link rel="stylesheet" href="./css/style.css"/>
        <link rel="stylesheet" href="./css/style2.css"/>
    </head>
    <body>
        <div class="main">
            <jsp:include page="Menu.jsp"></jsp:include>
                <div class="header_content">
                    <img src="./image/background.png" alt="Background">
                </div>
                <!-- begin content  -->
                <div class="grid wide content">
                    <div class="row">
                        <div class="col l-3">
                        <jsp:include page="Left.jsp"></jsp:include>
                        </div>
                        <div class="col l-9">
                            <div class="row detail">
                                <div class="col l-5">
                                    <div class="detail_img"> <a href="#"><img src="${detail.image}"></a></div>
                            </div>
                            <div class="col l-7">
                                <div class="detail_info">
                                    <h3 class="detail_name">${detail.name}</h3>
                                    <div class="detail_price">US ${detail.price} $</div>
                                    <c:if test="${detail.amount!=0}">
                                        <div class="detail_amount1">Còn lại ${detail.amount}</div>
                                    </c:if>
                                    <c:if test="${detail.amount==0}">
                                        <div class="detail_amount2">Hết hàng</div>
                                    </c:if>
                                    <dt class="detail_title">Description</dt>
                                    <p class="detail_txt">${detail.description}</p>
                                    <hr>
                                    <div class="detail_cart">
                                        <a href="cart?id=${detail.id}" class="detail_btn">
                                            <i class="fa-solid fa-cart-shopping"></i> ADD TO CART</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end content  -->
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </body>
</html>
