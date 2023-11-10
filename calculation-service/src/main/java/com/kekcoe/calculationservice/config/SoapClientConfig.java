package com.kekcoe.calculationservice.config;

import com.kekcoe.calculationservice.binding.QuadraticEquationRequest;
import com.kekcoe.calculationservice.soap_client.SoapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@Slf4j
public class SoapClientConfig {

    @Value("${quadratic.equation.solver.url}") String quadraticEquationSolverUrl;

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/equation");
    }

    @Bean
    public SoapClient soapClient (Jaxb2Marshaller marshaller) {
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri(quadraticEquationSolverUrl);
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);
        return soapClient;
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
    public DefaultWsdl11Definition defaultWsdl11Definition(@Value("${quadratic.equation.solver.url}") String quadraticEquationSolverUrl, XsdSchema requestSchema2, XsdSchema responseSchema2) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EquationPort");
        wsdl11Definition.setLocationUri(quadraticEquationSolverUrl);
        wsdl11Definition.setTargetNamespace("http://kekcoe.com/quadratic");
        wsdl11Definition.setSchema(requestSchema2);
        wsdl11Definition.setSchema(responseSchema2);
        return wsdl11Definition;
    }

    @Bean
    public QuadraticEquationRequest quadraticEquationRequest() {
        return new QuadraticEquationRequest();
    }

}