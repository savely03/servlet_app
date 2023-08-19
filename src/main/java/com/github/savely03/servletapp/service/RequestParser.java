package com.github.savely03.servletapp.service;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestParser {
    String parseMethodName(HttpServletRequest req);

    String parseUrl(HttpServletRequest req);

    String parseHeaders(HttpServletRequest req);

    String parseParams(HttpServletRequest req);

    String parseBody(HttpServletRequest req);
}
