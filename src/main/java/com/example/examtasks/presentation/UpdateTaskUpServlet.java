package com.example.examtasks.presentation;

import com.example.examtasks.buisiness.DefaultServices;
import com.example.examtasks.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/updatetop")
public class UpdateTaskUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typofswap = "top";
        Integer taskId = Integer.valueOf(request.getParameter("id"));
        Task task2;
        Task task1 = DefaultServices.getInstance().getById(taskId);
            task2 = DefaultServices.getInstance().getById(taskId - 1);
        System.out.println(task1 +"ssssssssssssss1" + task2 + "sssss2");

        DefaultServices.getInstance().modifyTask(task1, task2, typofswap);
        response.sendRedirect("tasks");
    }
}
