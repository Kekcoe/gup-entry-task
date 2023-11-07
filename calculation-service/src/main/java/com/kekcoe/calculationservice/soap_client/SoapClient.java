package com.kekcoe.calculationservice.soap_client;

import com.kekcoe.calculationservice.binding.QuadraticEquationRequest;
import com.kekcoe.calculationservice.binding.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Slf4j
@Service
public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    public SoapClient(Jaxb2Marshaller marshaller) {
        setDefaultUri("http://localhost:8080/ws/equation");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public QuadraticEquationResponse callWebService(QuadraticEquationRequest request) {
        log.info("********** getDefaultUri " + getWebServiceTemplate().getDefaultUri());
        return (QuadraticEquationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}