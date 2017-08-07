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
                <form:input path="login"/>
                <form:errors path="login" cssClass="error-msg" /><br>

                <form:label path="password">Пароль</form:label><br>
                <form:password cssClass="password" path="password"/>
                <form:errors path="password" cssClass="error-msg" /><br>

                <form:label path="confirmPassword">Подтвердите пароль</form:label><br>
                <form:password cssClass="confirmPassword" path="confirmPassword"/>
                <form:errors path="confirmPassword" cssClass="error-msg" /><br>

                <form:label path="email">Электронная почта</form:label><br>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error-msg" /><br>

                <form:label path="firstName">Имя</form:label><br>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error-msg" /><br>

                <form:label path="lastName">Фамилия</form:label><br>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error-msg" /><br>

                <form:label path="phone">Телефон</form:label><br>
                <form:input path="phone"/>
                <form:errors path="phone" cssClass="error-msg" /><br>

            </fieldset>
            <footer>
                <input type="submit" class="btnReg" value="Зарегистрировать"/>
            </footer>
        </form:form>
        <div>${error}</div>
        <div>${passerror}</div>
    </div>
</body>
</html>
