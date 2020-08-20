package com.subscription.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

	private static final String template = "Subscribe User Name, %s!";

	public SubscriptionController()
	{}
	
	@GetMapping("/info")
	@ResponseBody
	public SubscriptionContract bookInfo(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new SubscriptionContract(1, String.format(template, name),null,null);
	}

}
