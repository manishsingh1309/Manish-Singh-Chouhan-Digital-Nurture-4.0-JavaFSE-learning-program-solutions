package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
	@GetMapping("/{number}")
	public LoanDetails getLoanDetails(@PathVariable String number) {
		return new LoanDetails(number,"car",40000,3258,18);
	}
	
	public record LoanDetails(String number,String type,long loan,long emi,int tenure) {}
}
