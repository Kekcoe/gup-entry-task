package com.kekcoe.quadraticequationsolver.controller;

import com.kekcoe.quadraticequationsolver.controller.impl.EquationEndpointImpl;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationRequest;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class EquationEndpoint {
    private final EquationEndpointImpl equationEndpointImpl;

    @Autowired
    public EquationEndpoint(EquationEndpointImpl equationEndpointImpl) {
        this.equationEndpointImpl = equationEndpointImpl;
    }

    @PayloadRoot(namespace = "http://kekcoe.com/quadratic", localPart = "quadraticEquationRequest")
    @ResponsePayload
    public QuadraticEquationResponse solveEquation(@RequestPayload QuadraticEquationRequest request) {
        log.info("****" + request);
        try {
            return equationEndpointImpl.solveEquation(request);
        } catch (EquationEndpointImpl.DiscriminantException e) {
            log.error("Error: ", e);
            throw e;
        } catch (Exception e) {
            log.error("Error: ", e);
            return null;
        }
    }
}