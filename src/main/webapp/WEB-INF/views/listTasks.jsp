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
            request.setAttribute("task1",task);
            request.setAttribute("task2", DefaultServices.getInstance().getById(task.getId()+1));
            request.setAttribute("methode" , "down");
    %>
    <li>

        <%= task.getId()%> : | <%= task.getContent() %>
        <div></div>
        <a href="deleteTask?id=<%=task.getId()%>">Delete</a>

        <% if (task.getId().equals(0)) {%>
        <a href="update"
                <%
                    request.getSession().setAttribute("task1",task);
                    request.getSession().setAttribute("task2", DefaultServices.getInstance().getById(task.getId()+1));
                    request.getSession().setAttribute("methode" , "top");
                %>
        >Down</a>

        </div>
        <div>
        <% } else if (task.getId().equals(tasks.size() - 1)) {%>
        <a href="update"<%
        %>>Top</a>
        </div>
        <div>
        <%
        } else {
            request.getSession().setAttribute("task1",task);
            request.getSession().setAttribute("task2", DefaultServices.getInstance().getById(task.getId()+1));
            request.getSession().setAttribute("method" , "down");
        %>
        <a href="update"<%
            request.getSession().setAttribute("task1",task);
            request.getSession().setAttribute("task2", DefaultServices.getInstance().getById(task.getId()+1));
            request.getSession().setAttribute("method" , "top");
        %>>Down</a>
        <a href="update"<%
        %>>Top</a>

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
