package com.example.examtasks.presentation;

import com.example.examtasks.buisiness.DefaultServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/tasks")
public class ListTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tasks", DefaultServices.getInstance().loadTasks());
        request.getRequestDispatcher("WEB-INF/views/listTasks.jsp").forward(request,response);
    }


}
