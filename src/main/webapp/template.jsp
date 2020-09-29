<%--
  Created by IntelliJ IDEA.
  User: jp
  Date: 9/29/20
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html>
<head>
    <title>${param.title}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />
</head>
<body>

<jsp:include page="includes/header.jsp" />
<h1>${param.title}</h1>
<jsp:include page="${param.content}.jsp" />
<jsp:include page="includes/footer.jsp" />

</body>
</html>
