package com.kekcoe.quadraticequationsolver.controller.impl;

import com.kekcoe.quadraticequationsolver.model.QuadraticEquationRequest;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

import javax.xml.ws.soap.SOAPFaultException;

@Service
@Slf4j
public class EquationEndpointImpl {
    public QuadraticEquationResponse solveEquation(@RequestPayload QuadraticEquationRequest request) throws SOAPFaultException {
        log.info("***** QuadraticEquationRequest ,{}", request);
        int A = request.getA();
        int B = request.getB();
        int C = request.getC();

        double D = B * B - 4 * A * C;
        QuadraticEquationResponse response = new QuadraticEquationResponse();

        if (D < 0) {
            String message = "The discriminant is less than zero. Discriminant: " + D + ", Formula: " + A + "x^2+"
                    + B + "x+" + C + "=0";
            throw new DiscriminantException(message);
        }


        double x1 = (-B + Math.sqrt(D)) / (2 * A);
        double x2 = (-B - Math.sqrt(D)) / (2 * A);


        response.setFormula(A + "x^2+" + B + "x+" + C + "=0");
        response.setD(D);
        response.setX1(x1);
        if (D != 0) {
            response.setX2(x2);
        }
        return response;
    }

    @SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://my.custom.namespace}DiscriminantException", faultStringOrReason = "")
    public static class DiscriminantException extends RuntimeException {
        public DiscriminantException(String message) {
            super(message);
        }
    }
}