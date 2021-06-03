<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
 <c:param name="content">
  <h2>メッセージ検索ページ</h2>
   <form method="post" action="${pageContext.request.contextPath}/search">
    <label>タイトル<br />
    <input type="text" name="title" value="${message.title}" />
    </label>
    <br /><br />
    <label>メッセージ<br />
    <input type="text"  name="content" value="${message.content}"/>
    </label>
    <br /><br />
    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">検索</button>

   </form>

   <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
 </c:param>
</c:import>