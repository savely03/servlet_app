package com.github.savely03.servletapp.service.impl;

import com.github.savely03.servletapp.service.RequestParser;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class RequestParserImpl implements RequestParser {
    private static final RequestParser INSTANCE = new RequestParserImpl();

    private RequestParserImpl() {
    }

    public static RequestParser getInstance() {
        return INSTANCE;
    }

    @Override
    public String parseMethodName(HttpServletRequest req) {
        return req.getMethod();
    }

    @Override
    public String parseUrl(HttpServletRequest req) {
        return req.getRequestURI();
    }

    @Override
    public String parseHeaders(HttpServletRequest req) {
        List<String> res = new ArrayList<>();
        Enumeration<String> headers = req.getHeaderNames();

        while (headers.hasMoreElements()) {
            String param = headers.nextElement();
            res.add(String.format("%s = %s", param, req.getHeader(param)));
        }

        return String.join("\n,", res);
    }

    @Override
    public String parseParams(HttpServletRequest req) {
        List<String> res = new ArrayList<>();
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String param = params.nextElement();
            res.add(String.format("%s = %s", param, req.getParameter(param)));
        }

        return String.join("\n,", res);
    }

    @Override
    public String parseBody(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
