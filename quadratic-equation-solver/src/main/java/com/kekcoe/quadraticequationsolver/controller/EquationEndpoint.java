package com.kekcoe.quadraticequationsolver.controller;

import generated.Request;
import generated.Response;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EquationEndpoint {
    private static final String NAMESPACE_URI = "http://yourdomain.com";
    @PayloadRoot(namespace = "http://yourdomain.com", localPart = "request")
    @ResponsePayload
    public Response solveEquation(@RequestPayload Request request) {

        return new Response();
    }
}
