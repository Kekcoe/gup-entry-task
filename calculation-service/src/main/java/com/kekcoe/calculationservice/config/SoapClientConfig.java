package com.kekcoe.calculationservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@Slf4j
public class SoapClientConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/equation2");
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.kekcoe.calculationservice.binding");
        return marshaller;
    }

    @Bean
    public XsdSchema requestSchema2() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/QuadraticEquationRequest.xsd"));
    }

    @Bean
    public XsdSchema responseSchema2() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/QuadraticEquationResponse.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema requestSchema2, XsdSchema responseSchema2) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EquationPort2");
        wsdl11Definition.setLocationUri("${quadratic.equation.solver}");
        wsdl11Definition.setTargetNamespace("http://kekcoe.com/quadratic");
        wsdl11Definition.setSchema(requestSchema2);
        wsdl11Definition.setSchema(responseSchema2);
        return wsdl11Definition;
    }

}