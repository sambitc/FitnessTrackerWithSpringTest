
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fitness Tracker Login Page</title>
        <style>
            .errorblock{
                color: #ff0000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body onload='document.f.j_username.focus();'>
        <h3>Fitness Tracker Custom Login Page</h3>
        <c:if test="${not empty error}">
            <div class="errorblock">
                Your login was unsucessfull. <br/>
                Caused : ${sessionSceope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <form action="j_spring_security_check" name="f" method="post">
            <table>
                <tr>
                    <td>User :</td>
                    <td><input type="text" name="j_username" value="" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" name="j_password" /></td>
                </tr>
                <tr>
                    <td>Company :</td>
                    <td><input type="text" name="j_company" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="submit" value="submit" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="reset" name="reset"  />
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="_spring_security_remember_me"  checked="true"/>
                    </td>
                </tr>
            </table>

        </form>

    </body>
</html>
