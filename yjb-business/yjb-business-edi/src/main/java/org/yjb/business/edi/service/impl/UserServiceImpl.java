package org.yjb.business.edi.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjb.business.edi.config.JedisConnectionFactory;
import org.yjb.business.edi.dao.UserMapper;
import org.yjb.business.edi.dto.RequestUserDto;
import org.yjb.business.edi.entity.BooksEntity;
import org.yjb.business.edi.entity.UserEntity;
import org.yjb.business.edi.service.UserService;

import com.google.gson.Gson;

@Service
public class UserServiceImpl extends BaseService<BooksEntity> implements UserService {

	@Autowired
	UserMapper userMapper;
	
    public String getUserList() {
		Gson gson = new Gson();
		List<UserEntity> list = userMapper.selectUserLimit(100);
		System.out.println(list);
		String books = gson.toJson(list).toString(); 
        return books;
    }
    
    public String getUserById(RequestUserDto userRequest) {
		Gson gson = new Gson();
		String uuid = UUID.randomUUID().toString();
		List<UserEntity> userEntity = userMapper.selectUserById(userRequest);
		for(UserEntity entity: userEntity) {
			 entity.setUuid(uuid);
		}
		System.out.println(userEntity);
		String user = null;
		if(userEntity.size() > 0) {
			user = gson.toJson(userEntity.get(0)).toString(); 
			JedisConnectionFactory.set(2,  uuid, user);
		}
		
        return user;
    }
}
