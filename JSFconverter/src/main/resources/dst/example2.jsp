<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets">
	<h:head>
		<title>JSF graphic image example.</title>
	</h:head>
    <h:body>
    <h1>dummy</h1>
      <h3>Java Image</h3>
      <img value="image/java.jpg"/>

      <h3>Java Image</h3>
      <c:if test="${!empty fn:escapeXML(Bean.pic)}">
<img alt="pic for demo" id="pic2" title="example pic" class="img" url="image/java.jpg"/>
</c:if>
      <h3>Java Image example 2</h3>
      <c:if test="${!empty fn:escapeXML(Bean.pic)}">
<img alt="pic for demo" id="pic3" title="example pic" class="img" url="image/java.jpg"/>
</c:if>
    </h:body>
</html>