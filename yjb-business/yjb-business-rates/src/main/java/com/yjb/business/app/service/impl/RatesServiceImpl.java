package com.yjb.business.app.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.yjb.business.app.dao.NewsMapper;
import com.yjb.business.app.dao.RatesMapper;
import com.yjb.business.app.entity.RatesEntity;
import com.yjb.business.app.service.RatesService;
import com.yjb.business.app.utils.GetRatesDataThreadUtils;

@Service
public class RatesServiceImpl extends BaseService<RatesEntity> implements RatesService {
	@Autowired
	RatesMapper ratesMapper;
	@Autowired
	NewsMapper newsMapper;
	public String getInitRates() {
		return "zhaoyanjie"+ratesMapper.ratesMapper();
	}
	public void getInitStart() {
		try {
			GetRatesDataThreadUtils.getInit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public String getNews(){
		Gson gson = new Gson();
		String json = gson.toJson(newsMapper.getNews());
		System.out.println("json: " + json);

		return json;
	}
	public String getRates() {
		Gson gson = new Gson();
		String json = gson.toJson(ratesMapper.getRates());
		System.out.println("json: " + json);
		return json;
	}
}
