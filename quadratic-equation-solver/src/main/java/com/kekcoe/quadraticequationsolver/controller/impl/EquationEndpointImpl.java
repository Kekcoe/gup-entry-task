package com.kekcoe.quadraticequationsolver.controller.impl;

import com.kekcoe.quadraticequationsolver.custom_exception.DiscriminantException;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationRequest;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Service
@Slf4j
public class EquationEndpointImpl {
    public QuadraticEquationResponse solveEquation(@RequestPayload QuadraticEquationRequest request) {
        log.info("***** QuadraticEquationResponse solveEquation,{}", request);
        int A = request.getA();
        int B = request.getB();
        int C = request.getC();

        double D = B * B - 4 * A * C;

        if (D < 0) {
            throw new DiscriminantException("The discriminant is less than zero");
        }

        double x1 = (-B + Math.sqrt(D)) / (2 * A);
        double x2 = (-B - Math.sqrt(D)) / (2 * A);

        QuadraticEquationResponse response = new QuadraticEquationResponse();
        response.setFormula(A + "x^2+" + B + "x+" + C + "=0");
        response.setD(D);
        response.setX1(x1);
        if (D != 0) {
            response.setX2(x2);
        }
        return response;
    }
}