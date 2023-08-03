package com.github.savely03.servletapp.service;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class RequestParserService {

    public String parseMethodName(HttpServletRequest req) {
        return req.getMethod();
    }

    public String parseUrl(HttpServletRequest req) {
        return req.getRequestURI();
    }

    public String parseHeaders(HttpServletRequest req) {
        List<String> res = new ArrayList<>();
        Enumeration<String> headers = req.getHeaderNames();

        while (headers.hasMoreElements()) {
            String param = headers.nextElement();
            res.add(String.format("%s = %s", param, req.getHeader(param)));
        }

        return String.join("\n,", res);
    }

    public String parseParams(HttpServletRequest req) {
        List<String> res = new ArrayList<>();
        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String param = params.nextElement();
            res.add(String.format("%s = %s", param, req.getParameter(param)));
        }

        return String.join("\n,", res);
    }

    public String parseBody(HttpServletRequest req) {
        try (BufferedReader br = req.getReader()) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
