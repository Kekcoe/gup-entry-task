package com.kekcoe.calculationservice.soap_client;

import com.kekcoe.calculationservice.binding.QuadraticEquationRequest;
import com.kekcoe.calculationservice.binding.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Slf4j
public class SoapClient extends WebServiceGatewaySupport {

    public QuadraticEquationResponse callWebService(QuadraticEquationRequest request) {
        log.info("********** getDefaultUri " + getWebServiceTemplate().getDefaultUri());
        return (QuadraticEquationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}