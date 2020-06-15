
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<!--<jsp:forward page="/jsp/login.jsp"/> -->
<!--<h5>Счетчик времени от запуска приложения до нажатия кнопки</h5>
<form name="Simple" action="control" method="get">
    <input type="hidden" name="time" value="${calendar.timeInMillis}"/>
    <input type="submit" name="button" value="Посчитать время"/>
</form> -->
<p>Hello!</p>


<form name="loginForm" method="post" action="controller">
    <input type="hidden" name="command" value="login"/>
    Логин:<br/>
    <input type="text" name="login" value=""/>
    <br/>Пароль:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <input type="submit" value="log in"/>
</form>
</body>
</html>
