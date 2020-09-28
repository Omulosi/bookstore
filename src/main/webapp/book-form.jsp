<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<c:import url="includes/head.html"></c:import>
<body>

<h1>Book Form</h1>


<form method="post"
      action="${pageContext.request.contextPath}/book">
    <fieldset>
        <legend>
            <c:choose>
                <c:when test="${not empty book.id }">
                    Updating Book
                </c:when>
                <c:otherwise>
                    Adding Book
                </c:otherwise>
            </c:choose>
        </legend>

        <div>
            <label for="title">Title</label>
            <input type="text" name="title"
                   id="title" value="${book.title}" />
        </div>

        <div>
            <label for="description">Description</label>
            <textarea name="description" id="description" rows="2" cols="60">
                ${book.description}
            </textarea>
        </div>

        <div>
            <label for="price">Price $</label>
            <input name="price" id="price"
                   value="${book.price}" />
        </div>

        <div>
            <label for="pubDate">Publication Date</label>
            <input name="pubDate" id="pubDate"
                   value="${bookPubDate}" />
            <label class="after">(MM/DD/YYYY)</label>
        </div>

        <c:if test="${not empty book.id}">
            <input type="hidden" name="id" value="${book.id}" />
        </c:if>

    </fieldset>

    <div class="button-row">
        <a href="${pageContext.request.contextPath}/book/">Cancel</a> or
        <input type="submit" value="Submit" />
    </div>
</form>

</body>
</html>