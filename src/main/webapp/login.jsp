<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>${project.name}: <spring:message code="login.header"/></title>

        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="css/unipoole.css" type="text/css">
        <link rel="stylesheet" href="css/admin-tool.css" type="text/css">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link rel="shortcut icon" href="css/images/favicon.ico">
    </head>
    <body onload='document.f.j_username.focus();'>
        <div id="banner-style">
            <div id="headerFrame">
                <div id="headerLogo">
                    <img src="css/images/logo.gif" alt="Logo" title="Logo" />
                </div>
            </div>
        </div>
        <br/>
        <hr>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span9">
                    <div class="hero-unit">
                        <%-- TODO Report errors on the page --%>
                        <h3><spring:message code="login.title"/></h3>
                        <!--
                        <span style="float: right">
                            <a href="?lang=en">en</a>
                            |
                            <a href="?lang=af">af</a>
                        </span>
                        -->
                        <form name='f' action='${pageContext.request.contextPath}/j_spring_security_check' method='POST'>
                            <table>
                                <tr>
                                    <td><spring:message code="login.username"/>:</td>
                                    <td><input type='text' name='j_username' value=''></td>
                                </tr>
                                <tr>
                                    <td><spring:message code="login.password"/>:</td>
                                    <td><input type='password' name='j_password'/></td>
                                </tr>
                                <tr>
                                    <td colspan='2'><input name="submit" type="submit" value="<spring:message code="login.submit"/>"/></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div class="row-fluid">
                    </div>
                </div>
            </div>      
            <hr>
            <div id="footer-style"></div>
            <script src="http://code.jquery.com/jquery.js"></script>
            <script src="js/bootstrap.js"></script>
    </body>
</html>