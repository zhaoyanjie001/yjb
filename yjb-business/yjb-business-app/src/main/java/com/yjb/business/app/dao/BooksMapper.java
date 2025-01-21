package com.yjb.business.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yjb.business.app.entity.BooksEntity;
@Mapper
public interface BooksMapper {
    public List<BooksEntity> selectBooks(@Param("id") String id, @Param("title") String title);
    
    public List<BooksEntity> selectBooksLimit(@Param("limit") int limit);
    public List<BooksEntity> selectBookById(@Param("id") String id);
}