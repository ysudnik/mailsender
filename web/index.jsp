<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.10.2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/emailSender" method="post">
    <div class="row">
        <input type="hidden" value="127.0.0.1" name="host ">
        <p><b>Адрес отправителя:</b><br>
            <input type="text" size="40" name="from">
        <p><b>Адрес получателя:</b><br>
            <input type="text" size="40" name="to">
        <p><b>Введите текст сообщения:</b><br>
            <textarea name="text" cols="40" rows="3"></textarea><br>
            <input type="submit"  value="send">
    </div>
</form>
</body>
</html>
