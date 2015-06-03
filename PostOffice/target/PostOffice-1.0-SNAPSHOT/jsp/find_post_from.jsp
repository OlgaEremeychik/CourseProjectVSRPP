<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : find_post_from
    Created on : May 31, 2015, 11:40:22 AM
    Author     : notepad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="jsp/css.css">
        <title>Find by From Last Name</title>
    </head>
    <body>
        <table class="features-table" border="1">
            <thead>
                <tr>
                    <td>Номер посылки</td>
                    <td class="grey">Название посылки</td>
                    <td class="green">Фамилия отправителя</td>
                    <td>Фамилия получателя</td>
                    <td class="grey">по СНГ</td>
                    <td class="green">Страна</td>
                    <td>Город</td>
                    <td class="grey">Улица</td>
                    <td class="green">Дом</td>
                    <td>Квартира</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="post" items="${listPost}">
                    <tr>
                        <td>${post.id}</td>
                        <td class="grey">${post.name}</td>
                        <td class="green">${post.idFrom.lastName}</td>
                        <td >${post.idTo.lastName}</td>
                        <td class="grey">${post.idCountry.sngParam}</td>
                        <td class="green">${post.idCountry.countryName}</td>
                        <td>${post.idCountry.idAdress.idTown.name}</td>
                        <td class="grey">${post.idCountry.idAdress.idStreet.name}</td>
                        <td class="green">${post.idCountry.idAdress.house}</td>
                        <td>${post.idCountry.idAdress.flat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
