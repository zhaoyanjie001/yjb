package com.yjb.business.app.utils;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
@Component
public class CreateRecorder {
	public  ArrayList<String> createRecord()throws SQLException {
    	ArrayList<String> list = new ArrayList<String>();
    	 try {
             // 发送HTTP GET请求并获取网页内容
             Document document = Jsoup.connect("https://www.waihui580.com").get();
             String sql = "insert into rates( currency_name,code,buy_exchange,buy_cash,selling_exchange,selling_cash,bank_conversion) values(";
             StringBuilder sb = new StringBuilder();
             Element body = document.getElementById("bankofchina");
             Elements tbodys = body.getElementsByTag("tbody");
             for(Element trs : tbodys)
             {
             	Elements tds  = trs.getElementsByTag("tr");
             	for(Element td : tds) {
             		Elements values  = td.getElementsByTag("td");
             		int i =0;
             		for(Element value : values) {
             			System.out.println("td：" + value.text());
             			if(i == 0) {
             				sb.append(sql).append("'").append( value.text()).append("'");
             			} else if(i == 1) {
 							sb.append(",'").append( value.text()).append("'");
             			}  else {
             				if("-".equals(value.text())) {
             					sb.append(",").append( 0 );
             				}else {
             					sb.append(",").append( value.text());
             				}
             			}
             			i++;
             		}
             		sb.append(")");
             		System.out.println(sb.toString());
             		list.add(sb.toString());
             		sb = new StringBuilder();
             	}
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    	 return list;
    }
}
