package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BusinessRuleService;

@RestController
public class RuleEngineController {
	@Autowired
	private BusinessRuleService businessRuleService;
	
	Logger logger = LoggerFactory.getLogger("");
	
    @GetMapping(value = "payment/rules/{ruleName}", produces = "application/json")
    public ResponseEntity<?> generetePresignedUrl(@PathVariable(value = "ruleName") String ruleName) {
        logger.info("Handling order based on rule of payment");
        Object object =  businessRuleService.processOrderSystem(ruleName);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

}
