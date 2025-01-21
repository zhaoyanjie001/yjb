package com.yjb.business.app.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yjb.business.app.dao.BooksMapper;
import com.yjb.business.app.dto.RequestUserDto;
import com.yjb.business.app.dto.ResponseUserDto;
import com.yjb.business.app.entity.BooksEntity;
import com.yjb.business.app.service.BooksService;
import com.yjb.business.app.utils.HttpClientUtils;

@Service
public class BooksServiceImpl extends BaseService<BooksEntity> implements BooksService {

	@Autowired
	BooksMapper booksMapper;

	public String getBooksList() {
		Gson gson = new Gson();
		List<BooksEntity> list = booksMapper.selectBooksLimit(100);
		System.out.println(list);
		String books = gson.toJson(list).toString();
		return books;
	}

	public String getBookById(RequestUserDto dto) {
		try {
			String result1 = HttpClientUtils.getApiResult("http://localhost:8086", "/api/edi/userInfoByUserPwd?", null,
					null, "id=1&name="+ dto.getUsername()+"&pwd="+ dto.getPassword()+"");

			Gson gson = new Gson();
			ResponseUserDto userDTO = gson.fromJson(result1, ResponseUserDto.class);

			System.out.println("result: " + result1);

			if(!ObjectUtils.isEmpty(userDTO)) {
				String result2 = HttpClientUtils.getApiResult("http://localhost:8085", "/api/user/userInfoByUserPwd?", null,
						null, "uuid="+userDTO.getUuid()+"&name="+userDTO.getUsername()+"&pwd="+userDTO.getPassword()+"");
				
				System.out.println("result: " + result2);
				
				if(result2.equals(result1)) {
					return result2;
				}
			}
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}catch (JsonSyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}


}
