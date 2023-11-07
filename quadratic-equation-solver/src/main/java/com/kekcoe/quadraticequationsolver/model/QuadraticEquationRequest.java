package com.kekcoe.quadraticequationsolver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;


@XmlType(name = "quadraticEquationRequest", namespace = "http://kekcoe.com/quadratic", propOrder = {"a", "b", "c"})
@XmlRootElement(namespace = "http://kekcoe.com/quadratic")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
public class QuadraticEquationRequest {

    @XmlElement(name = "a")
    private int a;

    @XmlElement(name = "b")
    private int b;

    @XmlElement(name = "c")
    private int c;

}