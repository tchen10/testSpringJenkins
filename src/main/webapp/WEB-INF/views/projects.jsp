<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<h1>All Projects</h1>
<c:forEach var="project" items="${projectList}">
    <li>${project.name}</li>
</c:forEach>
</body>
</html>