<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
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
        <link rel="stylesheet" href="./css/voucher.css"/>
    </head>

    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <!-- begin content  -->
            <div class="grid wide content_cart">
                <table class="content_table_cart" style="width: 100%; text-align: left;">
                    <tr class="row content_table_list1">
                        <th class="col l-6 content_table_item">
                            <div class="">SẢN PHẨM</div>
                        </th>
                        <th class="col l-2 content_table_item">
                            <div class="">ĐƠN GIÁ</div>
                        </th>
                        <th class="col l-2 content_table_item">
                            <div class="">SỐ LƯỢNG</div>
                        </th>
                        <th class="col l-2 content_table_item">
                            <div class="">XÓA</div>
                        </th>
                    </tr>
                <c:forEach items="${list}" var="o"> 
                    <tr class="row content_table_list2">
                        <td class="col l-6 content_table_item2">
                            <img src="${o.image}" alt="" width="70" class="content_table_img">
                            <div class="content_table_name">
                                <a href="detail?pid=${o.id}" class="content_table_txt">${o.name}</a>
                            </div>
                        </td>
                        <td class="col l-2 content_table_item2">
                            <strong class="content_table_price">${o.price}</strong>
                        </td>
                        <td class="col l-2 content_table_item2">
                            <a href="sub?id=${o.id}&action=subtract"><button class="btnSub">-</button></a>
                            <strong class="content_table_amount">${o.amount}</strong>
                            <a href="sub?id=${o.id}&action=add"><button class="btnAdd">+</button></a>
                        </td>
                        <td class="col l-2 content_table_item2">
                            <a href="remove?id=${o.id}" class="content_table_submit">
                                <button type="button" class="content_table_submit_btn">Xóa</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach> 
            </table>
            <div class="row">
                <div class="col l-6 content_voucher">
                    <div class="content_voucher_title">NHẬP MÃ GIẢM GIÁ</div>
                    <div class="content_voucher_code" style="margin-bottom: 20px">
                        <form action="applyVoucher" method="post">
                            <input name="voucher" type="text" placeholder="Nhập mã giảm giá" aria-describedby="button-addon3"
                                   class="content_voucher_input">
                            <button id="button-addon3" type="submit" class="content_voucher_btn"><i
                                    class="fa-solid fa-gift"></i>&nbsp;Sử dụng</button>
                        </form>
                    </div>
                    <c:forEach items="${voucherList}" var="o">
                        <div class="content_voucher_lists">
                            <ul class="content_voucher_list">
                                <li class="content_voucher_item">
                                    <span class="content_voucher_code_title">Mã Voucher: ${o.id}</span>
                                    <span class="content_voucher_value">Số tiền áp dụng: ${o.moneyVoucher}</span>
                                    <span><a href="deleteVoucher?id=${o.id}" class="content_voucher_delete"><i class="fa-solid fa-trash"></i></a></span>
                                </li>
                            </ul>
                        </div>
                    </c:forEach>
                </div>
                <div class="col l-6 content_money">
                    <div class="content_into_money">THÀNH TIỀN</div>
                    <div class="content_money_title">
                        <ul class="content_money_list">
                            <li class="content_money_item">
                                <span class="content_money_item_title">Tổng tiền hàng</span>
                                <span class="content_money_item_value">${total}</span>
                            </li>
                            <li class="content_money_item">
                                <span class="content_money_item_title">Phí vận chuyển</span>
                                <span class="content_money_item_value">Free ship</span>
                            </li>
                            <li class="content_money_item">
                                <span class="content_money_item_title">VAT</span>
                                <span class="content_money_item_value">${vat}</span>
                            </li>
                            <li class="content_money_item">
                                <span class="content_money_item_title">Tổng tiền</span>
                                <span class="content_money_item_value">${sum}</span>
                            </li>
                            <li class="content_money_item">
                                <span class="content_money_item_title">Tổng thanh toán</span>
                                <span class="content_money_item_value">${voucher}</span>
                            </li>
                        </ul>
                        <a href="buy" class="content_money_btn">Mua hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
</html>
