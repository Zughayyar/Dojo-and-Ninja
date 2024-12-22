<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="main-container">
    <div class="form-add">
        <h2>Add a Burger:</h2>
        <form:form action="/ninjas/addNinja" method="post" modelAttribute="ninja" >
            <div class="mb-3">
                <form:label path="dojo" cssClass="form-label" for="dojo">Burger Name</form:label>
                <form:select path="dojo" class="form-control" id="dojo">
                    <c:forEach var="dojo" items="${dojos}">
                        <form:option value="${dojo.id}">${dojo.name}</form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="dojo" cssClass="errorMessage" />
            </div>
            <div class="mb-3">
                <form:label path="firstName" cssClass="form-label" for="firstName">First Name</form:label>
                <form:input path="firstName" class="form-control" id="firstName" />
                <form:errors path="firstName" cssClass="errorMessage" />
            </div>
            <div class="mb-3">
                <form:label path="lastName" cssClass="form-label" for="lastName">Last Name</form:label>
                <form:input path="lastName" class="form-control" id="lastName" />
                <form:errors path="lastName" cssClass="errorMessage" />
            </div>
            <div class="mb-3">
                <form:label path="age" cssClass="form-label" for="age">Age</form:label>
                <form:input path="age" class="form-control" id="age" />
                <form:errors path="age" cssClass="errorMessage" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>

<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>