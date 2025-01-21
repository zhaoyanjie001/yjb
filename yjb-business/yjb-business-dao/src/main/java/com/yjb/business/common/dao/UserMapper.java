package com.yjb.business.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yjb.business.common.dto.UserDto;
import com.yjb.business.common.entity.UserEntity;
@Mapper
public interface UserMapper {
    public List<UserEntity> selectUser(@Param("id") String id, @Param("title") String title);
    
    public List<UserEntity> selectUserLimit(@Param("limit") int limit);
    public List<UserEntity> selectUserById(@Param("userDto")UserDto userDto);
}