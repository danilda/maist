<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">

<body>
    <a href="?lang=ru"><spring:message code="lang.ru"/></a>
    <a href="?lang=en"><spring:message code="lang.en"/></a>
    <div>

        <form:form method="POST" commandName="user" action="/registration">
        <h3 class="form-signin-heading"><spring:message code="greeting"/></h3>
            <fieldset class="inputContainer">

                <form:label path="login"><spring:message code="registration.login"/></form:label><br>
                <form:input path="login"/>
                <form:errors path="login" cssClass="error-msg" /><br>

                <form:label path="password"><spring:message code="registration.password"/></form:label><br>
                <form:password cssClass="password" path="password"/>
                <form:errors path="password" cssClass="error-msg" /><br>

                <form:label path="confirmPassword"><spring:message code="registration.confirmPassword"/></form:label><br>
                <form:password cssClass="confirmPassword" path="confirmPassword"/>
                <form:errors path="confirmPassword" cssClass="error-msg" /><br>

                <form:label path="email"><spring:message code="registration.email"/></form:label><br>
                <form:input path="email"/>
                <form:errors path="email" cssClass="error-msg" /><br>

                <form:label path="firstName"><spring:message code="registration.firstName"/></form:label><br>
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error-msg" /><br>

                <form:label path="lastName"><spring:message code="registration.lastName"/></form:label><br>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error-msg" /><br>

                <form:label path="phone"><spring:message code="registration.phone"/></form:label><br>
                <form:input path="phone"/>
                <form:errors path="phone" cssClass="error-msg" /><br>

            </fieldset>
            <footer>
                <button class="btnReg"><spring:message code="registration.registrationButton"/></button>
                <input type="submit" class="btnReg" value="Зарегистрировать"/>
            </footer>
        </form:form>
        <div>${error}</div>
        <div>${passerror}</div>
    </div>
</body>
</html>
