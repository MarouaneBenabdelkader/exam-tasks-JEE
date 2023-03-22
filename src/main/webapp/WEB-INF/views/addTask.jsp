<%--
  Created by IntelliJ IDEA.
  User: Marouane
  Date: 3/22/2023
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://localhost:8080/exam_tasks_war_exploded/style/main.css">

</head>
<body>
<h1>Add Task Page</h1>
<form method="post" action ="addTask">
    <label>
        <b> Task</b>
        <input type="text" name="task" placeholder="Write your task here">
        <input type="submit" value="Add task">
    </label>
</form>
<%=request.getAttribute("message")==null?"":request.getAttribute("message") %>
</body>
</html>
