package com.github.savely03.servletapp.service;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestFormatter {
    String formatRequest(HttpServletRequest req);
}
