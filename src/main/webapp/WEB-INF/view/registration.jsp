<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
    <div>
        <form:form method="POST" commandName="user" action="/registration">
        <h3 class="form-signin-heading">Добро пожаловать</h3>
            <fieldset class="inputContainer">

                <form:label path="login">Логин</form:label><br>
                <form:input path="login"/><br>


                <form:label path="password">Пароль</form:label><br>
                <form:password cssClass="password" path="password"/><br>

                <label for="check-password">Повторите пароль</label><br>
                <input type="password" name="check-password" class="check-password" /><br>

                <form:label path="email">Электронная почта</form:label><br>
                <form:input path="email"/><br>

            </fieldset>
            <footer>
                <input type="submit" class="btnReg" value="Зарегистрировать"/>
            </footer>
        </form:form>
        <div>${error}</div>
        <% if(request.getParameter("error") != null) {%>


        <%}%>
    </div>
</body>
</html>