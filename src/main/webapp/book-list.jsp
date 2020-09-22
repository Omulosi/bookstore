<%@ page import="model.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype HTML>
<html>
<head>
    <title>Book Listing</title>
</head>

<body>
<table>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Price</th>
        <th>Publication Date</th>
    </tr>

    <%
        ArrayList<Book> books = (ArrayList) request.getAttribute("books");
        for (Book book: books) {
            out.print("<tr>");
            out.print("<td><a href=\"${pageContext.request.contextPath}/book?id=" + book.getId() + "\">" + book.getTitle() + "</td>");
            out.print("<td><a href=\"${pageContext.request.contextPath}/book?id=" + book.getId() + "\">" + book.getDescription() + "</td>");
            out.print("<td><a href=\"${pageContext.request.contextPath}/book?id=" + book.getId() + "\">" + book.getPrice() + "</td>");
            out.print("<td><a href=\"${pageContext.request.contextPath}/book?id=" + book.getId() + "\">" + book.getPubDate() + "</td>");
            out.print("</tr>");
    }
    %>

<%--    <c:forEach var="book" items="${requestScope.books}" >--%>
<%--        <tr>--%>
<%--            <td><c:out value="${book.title}"></c:out></td>--%>
<%--            <td><c:out value="${book.description}"></c:out></td>--%>
<%--            <td><c:out value="${book.price}"></c:out></td>--%>
<%--            <td><c:out value="${book.pubDate}"></c:out></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>
</body>

</html>