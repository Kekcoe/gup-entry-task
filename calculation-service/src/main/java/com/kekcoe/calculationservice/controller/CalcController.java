package com.kekcoe.calculationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kekcoe.calculationservice.binding.QuadraticEquationRequest;
import com.kekcoe.calculationservice.soap_client.SoapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CalcController {

    @Autowired
    private SoapClient soapClientService;

    private final QuadraticEquationRequest request;

    @Autowired
    public CalcController(QuadraticEquationRequest request) {
        this.request = request;
    }

    @PostMapping("/api/calc")
    public ResponseEntity<String> calculate(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        request.setA(a);
        request.setB(b);
        request.setC(c);
        log.info("******* sending request {}", request);
        String response = soapClientService.callWebService(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
