<%@ page import="com.example.examtasks.models.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.examtasks.buisiness.DefaultServices" %><%--
  Created by IntelliJ IDEA.
  User: Marouane
  Date: 3/22/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://localhost:8080/exam_tasks_war_exploded/style/main.css">
</head>
<body>
<h1>Welcome to Home Page</h1>

<ul>
    <%
        List<Task> tasks = (List<Task>) request.getAttribute("tasks");
        for (Task task : tasks) {
    %>
    <li>

        <%= task.getId()%> : | <%= task.getContent() %>
        <div></div>
        <a href="deleteTask?id=<%=task.getId()%>">Delete</a>

        <% if (task.getId().equals(0)) {%>
        <a href="updatedown?id=<%=task.getId()%>">Down</a>

        </div>
        <div>
        <% } else if (task.getId().equals(tasks.size() - 1)) {%>
        <a href="updatetop?id=<%=task.getId()%>">Top</a>
        </div>
        <div>
        <%
        } else {
        %>
        <a href="updatedown?id=<%= task.getId()%>">Down</a>
        <a href="updatetop?id=<%= task.getId()%>">Top</a>

        <%
            }
        %>
    </div>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
