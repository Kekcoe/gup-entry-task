package com.kekcoe.calculationservice.binding;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@XmlType(name = "quadraticEquationResponce", namespace = "http://kekcoe.com/quadratic", propOrder = {"formula", "d", "x1", "x2"})
@XmlRootElement(namespace = "http://kekcoe.com/quadratic")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class QuadraticEquationResponse {
    @XmlElement(name = "formula")
    private String formula;

    @XmlElement(name = "D")
    private double d;

    @XmlElement(name = "x1")
    private double x1;

    @XmlElement(name = "x2")
    private Double x2;

}