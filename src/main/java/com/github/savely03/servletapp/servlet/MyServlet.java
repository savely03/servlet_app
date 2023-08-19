package com.github.savely03.servletapp.servlet;

import com.github.savely03.servletapp.service.RequestFormatter;
import com.github.savely03.servletapp.service.impl.RequestFormatterProxy;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

    private RequestFormatter requestFormatterService;

    @Override
    public void init() throws ServletException {
        requestFormatterService = RequestFormatterProxy.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(requestFormatterService.formatRequest(req));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(requestFormatterService.formatRequest(req));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(requestFormatterService.formatRequest(req));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(requestFormatterService.formatRequest(req));
    }
}
