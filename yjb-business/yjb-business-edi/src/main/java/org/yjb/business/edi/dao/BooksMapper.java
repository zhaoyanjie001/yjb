package org.yjb.business.edi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yjb.business.edi.entity.BooksEntity;
@Mapper
public interface BooksMapper {
    public List<BooksEntity> selectBooks(@Param("id") String id, @Param("title") String title);
    
    public List<BooksEntity> selectBooksLimit(@Param("limit") int limit);
    public List<BooksEntity> selectBookById(@Param("id") String id);
}