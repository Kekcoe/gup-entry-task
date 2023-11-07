package com.kekcoe.quadraticequationsolver.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.kekcoe.quadraticequationsolver");
        return marshaller;
    }

    @Bean
    public XsdSchema requestSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/QuadraticEquationRequest.xsd"));
    }

    @Bean
    public XsdSchema responseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/QuadraticEquationResponse.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema requestSchema, XsdSchema responseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EquationPort");
        wsdl11Definition.setLocationUri("/ws/equation");
        wsdl11Definition.setTargetNamespace("http://kekcoe.com/quadratic");
        wsdl11Definition.setSchema(requestSchema);
        wsdl11Definition.setSchema(responseSchema);
        return wsdl11Definition;
    }

}