package org.yjb.business.edi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjb.business.edi.dto.RequestUserDto;
import org.yjb.business.edi.service.UserService;

@RestController
@RequestMapping("/api/edi")
public class BooksController {

	@Autowired
	UserService userService;

	@GetMapping("/userInfo")
	public String getUserInfo() {
		return userService.getUserList();
	}
	@PostMapping("/userInfoById")
	public String getUserInfoById( @RequestBody RequestUserDto userDto) {
		return userService.getUserById(userDto);
	}
	@GetMapping("/userInfoByUserPwd")
	public String getUserInfoByUserPwd( RequestUserDto userDto) {
		return userService.getUserById(userDto);
	}
}
