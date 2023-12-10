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
                            <div class="row">
                            <c:forEach items="${listP}" var="o">
                                <div class="col l-4">
                                    <div class="content_product">
                                        <img class="content_product_img" src="${o.image}" alt="Card image cap">
                                        <div class="content_product_body">
                                            <h4 class="content_product_name"><a href="detail?pid=${o.id}" title="View Product"><p>${o.name}</p></a></h4>
                                            <p class="content_product_title">${o.title}</p>
                                            <p class="content_product_price">${o.price}</p>
                                            <c:if test="${o.amount!=0}">
                                                <p class="content_product_amount1">Còn ${o.amount}</p>
                                            </c:if>
                                            <c:if test="${o.amount==0}">
                                                <p class="content_product_amount2">Hết hàng</p>
                                            </c:if>
                                            <a href="cart?id=${o.id}" class="conten_product_btn">
                                                <p>Thêm vào giỏ hàng</p>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end content  -->
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>
    </body>
</html>

