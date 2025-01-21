package com.yjb.business.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yjb.business.app.dto.RequestUserDto;
import com.yjb.business.app.dto.ResponseUserDto;
import com.yjb.business.app.service.BooksService;
@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/booksInfo")
	public String getBooksInfo() {
		return booksService.getBooksList();
	}
	@PostMapping("/booksInfoByPass")
	public String getBookInfoByPass(@RequestBody RequestUserDto dto) {
		return booksService.getBookById( dto);
	}
	@GetMapping("/booksInfoById")
	public String getUserInfoById(RequestUserDto dto) {
		return booksService.getBookById(dto);
	}
}
