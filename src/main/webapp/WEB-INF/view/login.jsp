<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
    <div>
        <form method="POST" class="">
            <h3 class="form-signin-heading">Добро пожаловать</h3><br>
            <p>Логин</p>
            <input type="text" id="login" name="login" class="form-control" /> <br>
            <p>Пароль</p>
            <input type="password" id="password" name="password" class="form-control" /><br>
            <label for="remember">Замонить меня</label><input type="checkbox" id="remember">
            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Войти</button>
            <% if(request.getParameter("error") != null) {%>
                <div><%= request.getParameter("error") %> </div>
            <%}%>
        </form>
    </div>
</body>
</html>
