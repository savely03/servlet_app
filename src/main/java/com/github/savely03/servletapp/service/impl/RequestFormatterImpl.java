package com.github.savely03.servletapp.service.impl;

import com.github.savely03.servletapp.service.RequestFormatter;
import com.github.savely03.servletapp.service.RequestParser;
import jakarta.servlet.http.HttpServletRequest;

public class RequestFormatterImpl implements RequestFormatter {
    private static final RequestFormatter INSTANCE = new RequestFormatterImpl();
    private final RequestParser requestParser = RequestParserImpl.getInstance();

    private RequestFormatterImpl() {
    }

    public static RequestFormatter getInstance() {
        return INSTANCE;
    }

    @Override
    public String formatRequest(HttpServletRequest req) {
        return String.format("""
                         Получен запрос типа: %s,
                         На адрес: %s
                         C заголовками: %s,
                         C параметрами: %s,
                         C телом: %s
                        """,
                requestParser.parseMethodName(req),
                requestParser.parseUrl(req),
                requestParser.parseHeaders(req),
                requestParser.parseParams(req),
                requestParser.parseBody(req));
    }
}
