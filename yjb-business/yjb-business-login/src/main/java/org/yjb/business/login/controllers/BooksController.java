package org.yjb.business.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yjb.business.login.dto.RequestUserDto;
import org.yjb.business.login.service.BooksService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/userInfo")
	public String getBooksInfo() {
		return booksService.getBooksList();
	}
	@PostMapping("/userInfoById")
	public String getBookInfoById( @RequestBody RequestUserDto book) {
		return booksService.getBookById(book);
	}
	@GetMapping("/userInfoByUserPwd")
	public String getBookInfoByUserPwd( RequestUserDto user) {
		return booksService.getBookById(user);
	}
}
