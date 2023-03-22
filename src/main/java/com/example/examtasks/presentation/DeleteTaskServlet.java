package com.example.examtasks.presentation;

import com.example.examtasks.buisiness.DefaultServices;
import com.example.examtasks.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id")) ;

        Task task = DefaultServices.getInstance().getById(id);
        if(task == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            ;
        }
        DefaultServices.getInstance().removeTask(task);
        response.sendRedirect("tasks");
    }


}
