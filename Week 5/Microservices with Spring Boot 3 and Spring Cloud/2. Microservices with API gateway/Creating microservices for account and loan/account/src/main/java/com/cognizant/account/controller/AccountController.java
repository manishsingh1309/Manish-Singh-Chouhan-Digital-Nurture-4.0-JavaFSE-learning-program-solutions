package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@GetMapping("/{number}")
	public AccountDetails getAccountDetails(@PathVariable String number) {
	    return new AccountDetails(number, "savings", 234343);
	}

	public record AccountDetails(String number, String type, long balance) {}
}
