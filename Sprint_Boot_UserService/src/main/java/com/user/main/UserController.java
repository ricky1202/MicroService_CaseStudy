package com.user.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

	private static final String template = "User Name, %s!";

	public UserController()
	{}
	
	@GetMapping("/info")
	@ResponseBody
	public UserContract bookInfo(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new UserContract(1, String.format(template, name),"sanjiv.ricky@gmail.com","123456");
	}
}
