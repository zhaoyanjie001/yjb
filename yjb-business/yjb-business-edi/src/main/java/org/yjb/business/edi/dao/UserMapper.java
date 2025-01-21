package org.yjb.business.edi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yjb.business.edi.dto.RequestUserDto;
import org.yjb.business.edi.entity.UserEntity;
@Mapper
public interface UserMapper {
    public List<UserEntity> selectUser(@Param("id") String id, @Param("title") String title);
    
    public List<UserEntity> selectUserLimit(@Param("limit") int limit);
    public List<UserEntity> selectUserById(@Param("userDto")RequestUserDto userDto);
}