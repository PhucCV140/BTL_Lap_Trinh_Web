<%-- 
    Document   : Left
    Created on : 10-11-2023, 22:53:08
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
        <link rel="stylesheet" href="./css/style2.css"/>

    </head>
    <body>
        <div class="content_left">
            <div class="content_left_category">
                <div class="content_category_header"><i class="fa-solid fa-list"></i>&nbsp; DANH MỤC</div>
                <ul class="content_category_list">
                    <c:forEach items="${listC}" var="o">
                        <a href="category?cid=${o.cid}">
                            <div class="content_category_item ${tag==o.cid?"active":""}">${o.cname}</div>
                        </a>
                    </c:forEach>
                </ul>
            </div>
            <div class="content_left_last">
                <div class="content_last_header">SẢN PHẨM MỚI NHẤT</div>
                <div class="content_last_body">
                    <img class="content_last_img" src="${p.image}" />
                    <h4 class="content_last_txt" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;"><a href="detail?pid=${p.id}" title="View Product">${p.name}</a></h4>
                    <p class="content_last_title">${p.title}</p>
                    <p class="content_last_price">${p.price} $</p>
                    <c:if test="${p.amount!=0}">
                        <p class="content_last_amount1">Còn ${p.amount}</p>
                    </c:if>
                    <c:if test="${p.amount==0}">
                        <p class="content_last_amount2">Hết hàng</p>
                    </c:if>
                    <a href="cart?id=${p.id}" class="content_last_btn">
                        <p>Thêm vào giỏ hàng</p>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>
