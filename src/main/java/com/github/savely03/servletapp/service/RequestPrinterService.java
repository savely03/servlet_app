package com.github.savely03.servletapp.service;

import jakarta.servlet.http.HttpServletRequest;

public class RequestPrinterService {

    private final RequestParserService requestParser;

    public RequestPrinterService(RequestParserService requestParser) {
        this.requestParser = requestParser;
    }

    public void printRequest(HttpServletRequest req) {
        System.out.printf("""
                         Получен запрос типа: %s,
                         C заголовками: %s,
                         C параметрами: %s,
                         C телом: %s
                        """,
                requestParser.parseMethodName(req),
                requestParser.parseHeaders(req),
                requestParser.parseParams(req),
                requestParser.parseBody(req));
    }
}
