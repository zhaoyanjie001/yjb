package org.yjb.business.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.yjb.business.login.dao.BooksMapper;
import org.yjb.business.login.dao.UserMapper;
import org.yjb.business.login.dto.RequestBooksDto;
import org.yjb.business.login.dto.RequestUserDto;
import org.yjb.business.login.dto.ResponseUserDto;
import org.yjb.business.login.entity.BooksEntity;
import org.yjb.business.login.entity.UserEntity;
import org.yjb.business.login.service.BooksService;

import com.google.gson.Gson;

import org.yjb.business.login.config.JedisConnectionFactory;
@Service
public class BooksServiceImpl extends BaseService<RequestBooksDto> implements BooksService {

	@Resource
	BooksMapper booksMapper;
	
	@Resource
	UserMapper userMapper;
	
    public String getBooksList() {
		Gson gson = new Gson();
		List<BooksEntity> list = booksMapper.selectBooksLimit(100);
		System.out.println(list);
		String books = gson.toJson(list).toString(); 
        return books;
    }
    
    public String getBookById( RequestUserDto user) {
    	Gson gson = new Gson();
    	String userDto = JedisConnectionFactory.get(2,  user.getUuid());

    	if(StringUtils.isNotEmpty(userDto)) {
    		ResponseUserDto userDTO = gson.fromJson(userDto, ResponseUserDto.class);
    		RequestUserDto requestUserDto = new RequestUserDto();
    		requestUserDto.setName(userDTO.getUsername());
    		requestUserDto.setPwd(userDTO.getPassword());
    		List<UserEntity> list = userMapper.selectUserById(requestUserDto);
    		if(list.size() > 0) {
    			System.out.println(list);
    			list.get(0).setUuid(user.getUuid());
    	        return gson.toJson(list.get(0)).toString();
    		}
    	}
		
        return "";
    }

}
