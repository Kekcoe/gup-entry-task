package com.kekcoe.quadraticequationsolver.custom_exception;

import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

import static org.springframework.ws.soap.server.endpoint.annotation.FaultCode.SERVER;

@SoapFault(faultCode = SERVER, faultStringOrReason = "Discriminant is less than zero")
public class DiscriminantException extends RuntimeException {

    public DiscriminantException(String message) {
        super(message);
    }

    public DiscriminantException(String message, Throwable cause) {
        super(message, cause);
    }
}