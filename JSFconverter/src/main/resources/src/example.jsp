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
      <h:graphicImage value="image/java.jpg"/>
      <h3>Java Image</h3>
      <h:graphicImage id="pic2" class="img" url="image/java.jpg" alt="pic for demo"
        title="example pic"  rendered="${!empty Bean.pic}"/>
    </h:body>
</html>