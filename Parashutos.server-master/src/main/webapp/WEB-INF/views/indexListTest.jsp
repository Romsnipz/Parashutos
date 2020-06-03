<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Index Page</title>
</head>

<body>

<spring:form method="post" modelAttribute="ListModel"  action="model">

    <a href="<c:url value="list"></c:url>">fuck go back</a><br/><>

    <c:forEach items="${ListModel.listElems}" var="elem" varStatus="status">
        <tr>
            <td>
                <a href="
                    <c:url value="listGet">
                        <c:param name="elemName" value="${elem.name}"/>
                    </c:url>
                ">${elem.name}</a> <br/>
            </td>
        </tr>
    </c:forEach>
</spring:form>

</body>

</html>