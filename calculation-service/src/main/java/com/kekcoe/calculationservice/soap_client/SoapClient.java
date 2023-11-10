package com.kekcoe.calculationservice.soap_client;

import com.kekcoe.calculationservice.binding.QuadraticEquationRequest;
import com.kekcoe.calculationservice.binding.QuadraticEquationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.client.SoapFaultClientException;

@Slf4j
public class SoapClient extends WebServiceGatewaySupport {

    public String callWebService(QuadraticEquationRequest request) {
        try {
            log.info("********** getDefaultUri " + getWebServiceTemplate().getDefaultUri());
            QuadraticEquationResponse response = (QuadraticEquationResponse) getWebServiceTemplate().marshalSendAndReceive(request);
            return response.toString();
        } catch (SoapFaultClientException e) {
            SoapFault soapFault = e.getSoapFault();
            String faultString = soapFault.getFaultStringOrReason();
            log.error("Received SOAP Fault: " + faultString);
            return faultString;
        } catch (Exception e) {
            log.error("An error occurred: ", e);
            return "An error occurred: " + e.getMessage();
        }
    }

}