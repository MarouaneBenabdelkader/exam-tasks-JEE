package com.example.examtasks.presentation;

import com.example.examtasks.buisiness.DefaultServices;
import com.example.examtasks.models.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/update")
public class UpdateTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Task task1 = (Task) session.getAttribute("task1");
        Task task2 = (Task) session.getAttribute("task2");
        System.out.println("TAAASK 1" + task1.getContent() + "TAAAAAAAAAASk 2 " + task2.getContent());
        String typofswap = (String) session.getAttribute("method");
        DefaultServices.getInstance().modifyTask(task1, task2, typofswap);
        response.sendRedirect("tasks");
    }


}
