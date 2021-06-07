<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
 <c:param name="content">
 <c:choose>
  <c:when test="${rtitle} != null">
  <h2>メッセージは存在しません</h2>
  </c:when>
  <c:otherwise>
  <c:forEach var="rtitle" items="${rtitle}">
    <li>
        タイトル：<c:out value="${rtitle}"/>
    </li>
  </c:forEach>
  </c:otherwise>
</c:choose>



  <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>

 </c:param>
</c:import>