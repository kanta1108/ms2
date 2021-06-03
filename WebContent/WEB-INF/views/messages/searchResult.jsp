<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
 <c:param name="content">
  <c:forEach var="message" items="${messages}">
    <li>
      <a href="${pageContext.request.contextPath}/show?id=${message.id}">
        <c:out value="${message.id}"/>
      </a>
      :<c:out value="${message.title}"></c:out> &gt;<c:out value="${message.content}"/>
    </li>
  </c:forEach>

 </c:param>
</c:import>