package com.yjb.business.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yjb.business.app.entity.NewsEntity;

@Mapper
public interface NewsMapper {
    public List<NewsEntity> getNews();
}