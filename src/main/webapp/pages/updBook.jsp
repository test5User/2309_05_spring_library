<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
  <sf:form method="post" action="/saveUpdated" modelAttribute="book">
      <sf:input path="id" type="hidden"/>
      <sf:input path="title"/><br>
      <sf:input path="author"/><br>
      <sf:input path="pages"/><br>
      <sf:input path="library_id" type="hidden"/><br>
      <input type="submit" value="Change">
  </sf:form>
</body>
</html>
