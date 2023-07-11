<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron">
    <h1>
        SAP Commerce Monitoring
    </h1>
    <p>
        SAP Commerce Monitoring Tool
    </p>
</div>
<div class="row">
    <div class="container">
        <table>
            <tbody>
            <c:forEach items="${items}" var="item">
            <tr>

                <td style="font-size: 18pt; font-weight: bold">${item.heading}&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><c:if test="${item.result != 1}"><img src="../resource/img/Ampel_Rot.png" height="200" width="100" alt="Rote_Ampel"/></c:if>
                    <c:if test="${item.result == 1}"><img src="../resource/img/Ampel_Grun.png" height="200" width="100" alt="Gruene_Ampel"/></c:if>
                </td>

            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>
