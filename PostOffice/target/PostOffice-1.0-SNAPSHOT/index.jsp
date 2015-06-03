<%-- 
    Document   : index
    Created on : May 30, 2015, 2:41:16 PM
    Author     : notepad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="jsp/css.css">
        <title>Post Office</title>
    </head>
    <body>
        <div class="wrapper-left">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="show_all" />
                <input type="submit" value="Все посылки" />
            </form>
        </div>
        <div class="wrapper-right">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="redirect" />
                <input type="hidden" name="hidden" value="add" />
                <input type="submit" value="Отправить посылку" />
            </form>
        </div>
        <div class="wrapper-center">
            <br>
            <h2>Слежение за почтовыми отправлениями</h2>
            <img src="jsp/Gmail1 (1).png"/>
            <br><br><br>
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="remove_post" />
                <input type="text" name="id" value="" />
                <input type="submit" value="Отменить посылку" />
            </form>
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="redirect" />
                <input type="hidden" name="hidden" value="find_id" />
                <input type="text" name="id" value="" />
                <input type="submit" value="Поиск по номеру посылки" />
            </form>
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="redirect" />
                <input type="hidden" name="hidden" value="find_from" />
                <input type="text" name="lastName" value="" />
                <input type="submit" value="Поиск по фамилии отправителя" />
            </form>
            <br><br><br>
            <img src="jsp/0_b3c09_c9884252_L.png"/>
            <img src="jsp/w256h2561339870339Messagealreadyread256.png"/>
            <img src="jsp/46a1fd34.png"/>
        </div>
    </body>
</html>
