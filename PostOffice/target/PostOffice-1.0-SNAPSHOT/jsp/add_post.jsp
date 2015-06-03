<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : add_post
    Created on : May 30, 2015, 5:03:17 PM
    Author     : notepad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="jsp/css.css">
        <title>Add post</title>
    </head>
    <body>
        <form action="controller" method="POST">
            <table class="features-table" border="1">
                <thead>
                    <tr>
                        <td>Название посылки</td>
                        <td class="grey">ФИО отправителя</td>
                        <td class="grey">ФИО получателя</td>
                        <td class="green">по СНГ</td>
                        <td>Страна</td>
                        <td class="grey" nowrap>Город</td>
                        <td class="green">Улица</td>
                        <td class="grey">Дом</td>
                        <td class="grey" nowrap>Квартира</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input size = "15" type="text" name="name" value="" /></td>
                        <td>
                            <p>
                                <input  size ="15" type="text" name="fromLastName" value="" />
                                <input  size ="15" type="text" name="fromName" value="" />
                                <input  size ="15" type="text" name="fromSurName" value="" />
                            </p>
                        </td>
                        <td>
                            <p>
                                <input  size ="15" type="text" name="toLastName" value="" />
                                <input  size ="15" type="text" name="toName" value="" />
                                <input  size ="15" type="text" name="toSurName" value="" />
                            </p>
                        </td>
                        <td>
                            <select name="sng">
                                <option>Yes</option>
                                <option>No</option>
                            </select>
                        </td>
                        <td>
                            <select name="country">
                                <c:forEach var="elem" items="${listCountry}">
                                    <option>${elem.countryName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="town">
                                <c:forEach var="elem" items="${listTown}">
                                    <option>${elem.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input size="10" type="text" name="street" value="" /></td>
                        <td><input size="5" type="text" name="house" value="" /></td>
                        <td><input size="5" type="text" name="flat" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="command" value="add_post" />
            <input class="input" type="submit" value="Отправить запрос" />
        </form>
    </body>
</html>
