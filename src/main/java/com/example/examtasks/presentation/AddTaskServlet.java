package com.example.examtasks.presentation;

import com.example.examtasks.buisiness.DefaultServices;
import com.example.examtasks.buisiness.Service;
import com.example.examtasks.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/addTask.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("task");
        if(content.equals("")){
            request.setAttribute("message" , "Cannot add an empty task.");
            doGet(request, response);
        }

        Service service = DefaultServices.getInstance();
        Task task = new Task();
        task.setContent(content);
        service.addTask(task);
        List<Task> tasks = service.loadTasks();
        response.setStatus(201);
        response.sendRedirect("tasks");


    }
}
