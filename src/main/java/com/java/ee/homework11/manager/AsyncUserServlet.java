package com.java.ee.homework11.manager;

import com.java.ee.homework11.tasks.UserTask;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/usersAsync")
public class AsyncUserServlet extends HttpServlet {
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    protected void doGet(HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync(req, resp);
        asyncContext.setTimeout(Integer.MAX_VALUE);
        executorService.submit(new UserTask(asyncContext));
    }
}
