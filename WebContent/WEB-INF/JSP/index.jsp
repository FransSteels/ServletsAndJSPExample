<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VoorbeelProject</title>
</head>

<body>

<h1>Voorbeeld Project</h1>

<ul>

<li>
<c:url var="inleidingURL" value="/EenServletIsEenController"/>

<a href="${inleidingURL}">Inleiding: een Servlet en een JSP</a> 
</li>

<li>
<c:url var="formURL" value="/ToonEnVerwerkFormServlet"/>

<a href="${formURL}">EL en een Form</a> 
</li>

<li>
<c:url var="JSTLURL" value="/JSTLServlet"/>

<a href="${JSTLURL}">JSTL </a> 
</li>

<li>
<c:url var="requestAndCookieURL" value="/LesVijfServlet?eersteParameter=waardeVanEersteParameter&tweedeParameter=waardeVanTweedeParameter"/>

<a href="${requestAndCookieURL}">RequestParameters en Cookies</a>
</li>

<li>
<c:url var="sessions" value="/Sessions" />

<a href="${sessions}">Sessions</a>
</li>

</ul>

</body>

</html>