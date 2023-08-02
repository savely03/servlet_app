package com.github.savely03.servletapp.servlet;

import com.github.savely03.servletapp.service.RequestPrinterService;
import com.github.savely03.servletapp.service.RequestParserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet")
public class MyServlet extends HttpServlet {

    private RequestPrinterService requestPrinter;

    @Override
    public void init() throws ServletException {
        requestPrinter = new RequestPrinterService(new RequestParserService());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestPrinter.printRequest(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestPrinter.printRequest(req);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestPrinter.printRequest(req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        requestPrinter.printRequest(req);
    }
}
