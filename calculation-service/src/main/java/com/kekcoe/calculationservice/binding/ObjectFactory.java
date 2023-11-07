package com.kekcoe.calculationservice.binding;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    @XmlElementDecl(namespace = "http://kekcoe.com/quadratic2", name = "quadraticEquationRequest2")
    public  JAXBElement<QuadraticEquationRequest> createRequest(QuadraticEquationRequest value) {
        return new JAXBElement<>(new QName("quadraticEquationRequest2"), QuadraticEquationRequest.class, null, value);
    }

    @XmlElementDecl(namespace = "http://kekcoe.com/quadratic2", name = "quadraticEquationResponse2")
    public JAXBElement<QuadraticEquationResponse> createResponse(QuadraticEquationResponse value) {
        return new JAXBElement<>(new QName("quadraticEquationResponse2"), QuadraticEquationResponse.class, null, value);
    }
}