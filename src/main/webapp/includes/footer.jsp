<%--
  Created by IntelliJ IDEA.
  User: jp
  Date: 9/28/20
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="footer_section">
    <%
        GregorianCalendar date = new GregorianCalendar();
        int yr = date.get(Calendar.YEAR);
    %>
    <p>&copy; Copyright <%= yr %></p>

</div>
