package com.github.savely03.servletapp.service.impl;

import com.github.savely03.servletapp.service.RequestFormatter;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;


public class RequestFormatterProxy implements RequestFormatter {
    public static final RequestFormatter INSTANCE = new RequestFormatterProxy();
    private final RequestFormatter requestFormatterService = RequestFormatterImpl.getInstance();
    private final List<String> requestsHistory = new ArrayList<>();

    private RequestFormatterProxy() {
    }

    public static RequestFormatter getInstance() {
        return INSTANCE;
    }

    @Override
    public String formatRequest(HttpServletRequest req) {
        requestsHistory.add(requestFormatterService.formatRequest(req));
        return String.join("\n", requestsHistory);
    }
}
