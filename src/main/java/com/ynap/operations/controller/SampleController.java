package com.ynap.operations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/print")
	public ResponseEntity<String> getSamplePrint() {
		return new ResponseEntity<String>("Sample response for API", HttpStatus.OK);
	}

}
