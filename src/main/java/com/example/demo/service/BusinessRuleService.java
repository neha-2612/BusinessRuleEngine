package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface BusinessRuleService {
	Object processOrderSystem(String ruleName);
}
