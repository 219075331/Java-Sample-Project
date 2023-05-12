<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.SiteEV" %>
<%
	SiteEV siteEV = (SiteEV)application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>湊くんページようこそ</title>
</head>
<body>
<h1>湊くんページようこそ</h1>
<p>
<a href = "/sampleApplicationScope2/MinatoIndex?action=like">良いね</a>
<%= siteEV.getLike() %>人
<a href = "/sampleApplicationScope2/MinatoIndex?action=dislike">良くないね</a>
<%= siteEV.getDislike() %>人

</p>
</body>
</html>