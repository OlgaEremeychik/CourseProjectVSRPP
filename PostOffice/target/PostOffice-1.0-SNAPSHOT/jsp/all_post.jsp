<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : all_post
    Created on : May 30, 2015, 2:41:35 PM
    Author     : notepad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="jsp/css.css">
        <title>All Posts</title>
    </head>
    <body>
        <table class="features-table" border="1">
            <thead>
                <tr>
                    <td>Номер посылки</td>
                    <td class="grey">Название</t>
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
                <c:forEach var="elem" items="${listPost}">
                    <tr>
                        <td>${elem.id}</td>
                        <td class="grey">${elem.name}</td>
                        <td class="green">${elem.idFrom.lastName}</td>
                        <td>${elem.idTo.lastName}</td>
                        <td class="grey">${elem.idCountry.sngParam}</td>
                        <td class="green">${elem.idCountry.countryName}</td>
                        <td>${elem.idCountry.idAdress.idTown.name}</td>
                        <td class="grey">${elem.idCountry.idAdress.idStreet.name}</td>
                        <td class="green">${elem.idCountry.idAdress.house}</td>
                        <td>${elem.idCountry.idAdress.flat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="wrapper-center">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="redirect" />
                <input type="hidden" name="hidden" value="back" />
                <p align="center"><input type="submit" value="Назад" /></p> </form> </div>
    </body>
</html>
