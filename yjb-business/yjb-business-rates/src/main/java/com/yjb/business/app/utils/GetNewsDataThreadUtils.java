package com.yjb.business.app.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetNewsDataThreadUtils {
	public static String getHtmlNewDataContent2(String url1, String title,String type) throws IOException, SQLException, InterruptedException {
		
		Document document = Jsoup.connect(url1).get();
		Elements ui2 = document.getElementsByTag("article");
		Elements ui2s = ui2.get(0).getElementsByTag("p");
		Element uiItem = ui2s.get(3);
		System.out.println(uiItem.text());
		SimpleDateFormat format_R = new SimpleDateFormat("yyyyMMdd");
		String date =format_R.format(new Date());
		String sql = "insert into news( dt,url,news,type,title) values('"+date+"','"+url1+"','"+uiItem.text()+"','"+type+"','"+title+"')";
		java.sql.Connection con = JdbcUtils.getConnect();
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select count(id) as cnt from news where url='" +url1+"'");
		if(!(rs!=null && rs.next() && rs.getInt("cnt") > 0 )) {
			java.sql.Connection con1 = JdbcUtils.getConnect();
			Statement stat1 = con.createStatement();
			stat1 = con1.createStatement();
			stat1.execute(sql);
			stat1.close();
		}
		stat.close();
		
		return "";
	}
	public static String getHtmlNewDataContent1() throws IOException {
		try {
			System.out.println("--------------------------------");
			
			Map<String,String> list = new HashMap<String,String>();
			list.put("https://news.yahoo.co.jp/categories/domestic","00");
			list.put("https://news.yahoo.co.jp/categories/world","01");
			list.put("https://news.yahoo.co.jp/categories/business","02");
			list.put("https://news.yahoo.co.jp/categories/it","03");
			list.put("https://news.yahoo.co.jp/categories/local","04");
			
			// 国内
			Map<String, String> map = new HashMap<String, String>();
			for(String str: list.keySet()) {
				Document document = Jsoup.connect(str).get();
				Element ui2 = document.getElementById("uamods-topics");
				Elements ui2s = ui2.getElementsByTag("ul");
				Element uiItem = ui2s.get(0);
				Elements li2s = uiItem.getElementsByTag("li");
				for (Element li : li2s) {
					Elements items = li.getElementsByTag("li");
					for (Element item : items) {
						Elements element = item.getElementsByTag("a");
						System.out.println(element.get(0).text());
						System.out.println(element.get(0).attr("href"));
						map.put(element.get(0).text(), element.get(0).attr("href"));
						getHtmlNewDataContent2(element.get(0).attr("href"), element.get(0).text(), list.get(str));
					}
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static void main(String[] args) throws Exception {
		getHtmlNewDataContent1();
	}
}
