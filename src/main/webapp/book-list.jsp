<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!Doctype HTML>
<html>
<c:import url="includes/head.html" />
<body>

<div>
    <a href="${pageContext.request.contextPath}/book">Add Book</a>
</div>

<table>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Price</th>
        <th>Publication Date</th>
    </tr>

    <c:forEach var="book" items="${requestScope.books}" >
        <tr>
            <td><a href="${pageContext.request.contextPath}/book?id=${book.id}">${book.title}</a></td>
            <td>${book.description}</td>
            <td>${book.price}</td>
            <td>${book.pubDate}</td>
        </tr>
    </c:forEach>
</table>

<c:import url="includes/footer.jsp" />
</body>

</html>