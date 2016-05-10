<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title><spring:message code="main.page.header"/></title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/unipoole.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-tool.css" type="text/css">
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/css/images/favicon.ico">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="/admin-tool/js/bootstrap.js"></script>
    </head>
    <body>
        <div id="banner-style"><tiles:insertAttribute name="header-content" /></div>
        <br/>
        <hr>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div id="left-menu-content" class="container"><tiles:insertAttribute name="left-menu-content" /></div>
                </div><!--/span-->
                <div class="span9">
                    <div class="hero-unit">
                        <div id="primary-style"><tiles:insertAttribute name="primary-content" /></div>
                    </div>
                    <div class="row-fluid">
                </div>
            </div>
        </div>      
        <hr>
        <div id="footer-style"><tiles:insertAttribute name="footer-content" /></div>

    </body>
</html>