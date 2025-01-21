package com.yjb.business.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yjb.business.app.entity.RatesEntity;

@Mapper
public interface RatesMapper {
    public int ratesMapper();
    public List<RatesEntity> getRates();
}