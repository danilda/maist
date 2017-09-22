<%@ page contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>
    <div>
        <a href="?lang=ru"><spring:message code="lang.ru"/></a>
        <a href="?lang=en"><spring:message code="lang.en"/></a>
        <form method="POST" class="" action="/login">
            <h3 class="form-signin-heading"><spring:message code="greeting"/></h3><br>
            <p><spring:message code="login.login"/></p>
            <input type="text" id="login" name="login" class="form-control" /> <br>
            <p><spring:message code="login.password"/></p>
            <input type="password" id="password" name="password" class="form-control" /><br>
            <label for="remember">Запомнить</label><input type="checkbox" id="remember">
            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit">Войти</button>
            <% if(request.getParameter("error") != null) {%>
                <div>Неправильной логин или пароль</div>
            <%}%>
        </form>
    </div>
</body>
</html>
