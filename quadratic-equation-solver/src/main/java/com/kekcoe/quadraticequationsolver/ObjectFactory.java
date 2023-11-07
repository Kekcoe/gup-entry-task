package com.kekcoe.quadraticequationsolver;

import com.kekcoe.quadraticequationsolver.model.QuadraticEquationRequest;
import com.kekcoe.quadraticequationsolver.model.QuadraticEquationResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(namespace = "http://kekcoe.com/quadratic", name = "quadraticEquationRequest")
    public  JAXBElement<QuadraticEquationRequest> createRequest(QuadraticEquationRequest value) {
        return new JAXBElement<>(new QName("quadraticEquationRequest"), QuadraticEquationRequest.class, null, value);
    }

    @XmlElementDecl(namespace = "http://kekcoe.com/quadratic", name = "quadraticEquationResponse")
    public JAXBElement<QuadraticEquationResponse> createResponse(QuadraticEquationResponse value) {
        return new JAXBElement<>(new QName("quadraticEquationResponse"), QuadraticEquationResponse.class, null, value);
    }
}