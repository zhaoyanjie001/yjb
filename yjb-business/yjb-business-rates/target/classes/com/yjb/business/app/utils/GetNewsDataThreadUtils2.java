//package com.yjb.business.app.utils;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.SimpleDateFormat;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.HtmlElement;
//import com.gargoylesoftware.htmlunit.html.HtmlInput;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//
//public class GetNewsDataThreadUtils2 {
//	private static class innerWebClient {
//		private static final WebClient webClient = new WebClient();
//	}
//
//	/**
//	 * 获取指定网页实体
//	 * 
//	 * @param url
//	 * @return
//	 */
//	public static HtmlPage getHtmlPage(String url) {
//		// 调用此方法时加载WebClient
//		WebClient webClient = innerWebClient.webClient;
//		// 取消 JS 支持
//		webClient.getOptions().setJavaScriptEnabled(false);
//		// 取消 CSS 支持
//		webClient.getOptions().setCssEnabled(false);
//		webClient.getOptions().setActiveXNative(false);
//		webClient.getOptions().setWebSocketEnabled(false);
//		;
//		HtmlPage page = null;
//		try {
//			// 获取指定网页实体
//			page = (HtmlPage) webClient.getPage(url);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return page;
//	}
//
//	public static String getHtmlNewDataContent2(String url1, String title,String type) throws IOException {
//		
//		Document document = Jsoup.connect(url1).get();
//		Elements ui2 = document.getElementsByTag("article");
//		Elements ui2s = ui2.get(0).getElementsByTag("p");
//		Element uiItem = ui2s.get(3);
//		System.out.println(uiItem);
//		SimpleDateFormat format_R = new SimpleDateFormat("yyyyMMddHHmmss");
//		String date =format_R.format(new Date());
//		String sql = "insert into new( dt,url,news,type) values('"+date+"','"+title+"','"+uiItem+"','"+type+"')";
//		
//		
//		return "";
//	}
//	public static String getHtmlNewDataContent1(String url1) throws IOException {
//		try {
//			System.out.println("--------------------------------");
//			
//			Map<String,String> list = new HashMap<String,String>();
//			list.put("","https://news.yahoo.co.jp/categories/domestic");
//			list.put("","https://news.yahoo.co.jp/categories/world");
//			list.put("","https://news.yahoo.co.jp/categories/business");
//			
//			// 国内
//			Map<String, String> map = new HashMap<String, String>();
//			for(String str: map.keySet()) {
//				Document document = Jsoup.connect(str).get();
//				Element ui2 = document.getElementById("uamods-topics");
//				Elements ui2s = ui2.getElementsByTag("ul");
//				Element uiItem = ui2s.get(0);
//				Elements li2s = uiItem.getElementsByTag("li");
//				for (Element li : li2s) {
//					Elements items = li.getElementsByTag("li");
//					for (Element item : items) {
//						Elements element = item.getElementsByTag("a");
//						System.out.println(element.get(0).text());
//						System.out.println(element.get(0).attr("href"));
//						map.put(element.get(0).text(), element.get(0).attr("href"));
//						getHtmlNewDataContent2(element.get(0).attr("href"), element.get(0).text(),str);
//					}
//				}	
//			}
//
//
////			System.out.println("--------------------------------");
////			document = Jsoup.connect("https://news.yahoo.co.jp/categories/world").get();
////			//国際
////			Element ui3 = document.getElementById("uamods-topics");
////			System.out.println(ui3);
////			System.out.println("--------------------------------");
////			document = Jsoup.connect("https://news.yahoo.co.jp/categories/business").get();
////			//経済
////			Element ui4 = document.getElementById("uamods-topics");
////			System.out.println(ui4);
////			System.out.println("--------------------------------");
//
//			StringBuffer sb = new StringBuffer();
//
////			for (Element li : ui) {
////				Elements item = li.getElementsByTag("li");
////				System.out.println(item);
////			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//
//	}
//
//	public static void main(String[] args) throws Exception {
////		getHtmlPage("https://news.yahoo.co.jp");
//		getHtmlNewDataContent1("https://news.yahoo.co.jp/");
//	}
////	public static void main(String str[]) {
////		try {
////			String strContent0 = getHtmlNewDataContent("https://news.yahoo.co.jp/");
////			System.out.println(strContent0);
////
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//
//	public static String getHtmlNewDataContent(String url1) throws IOException {
//
//		try {
//			Document document = Jsoup.connect(url1).get();
//			Elements links = document.select("table");
//			StringBuffer sb = new StringBuffer();
//
//			if (links != null && links.size() > 2) {
//				Elements tr = links.get(1).getElementsByTag("tr");
//
//				for (Element td : tr) {
//					Elements tdItem = td.getElementsByTag("td");
//					String[] strItem = tdItem.text().split(" ");
//					int i = 0;
//					sb.append("insert into rates(" + "currencyCode," + "buyingRate," + "purchasePriceOfCash,"
//							+ "exchangeSellingPrice," + "sellingPriceOfCash," + "middPrice," + "releaseDate,"
//							+ "releaseTime" + ") values(");
//					for (String item : strItem) {
//						System.out.println(item);
//						i++;
//						if (i == 8) {
//							sb.append("'" + item + "'");
//						} else if (i < 8) {
//							sb.append("'" + item + "',");
//						} else {
//						}
//					}
//					sb.append(");");
//					System.out.println(sb.toString());
//					sb = new StringBuffer();
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//	public static String getHtmlContent(String url1) throws IOException {
//
//		try {
//			Document document = Jsoup.connect(url1).get();
//			Elements links = document.select("table");
//			StringBuffer sb = new StringBuffer();
//
//			if (links != null && links.size() > 2) {
//				Elements tr = links.get(1).getElementsByTag("tr");
//
//				for (Element td : tr) {
//					Elements tdItem = td.getElementsByTag("td");
//					String[] strItem = tdItem.text().split(" ");
//					int i = 0;
//					sb.append("insert into rates(" + "currencyCode," + "buyingRate," + "purchasePriceOfCash,"
//							+ "exchangeSellingPrice," + "sellingPriceOfCash," + "middPrice," + "releaseDate,"
//							+ "releaseTime" + ") values(");
//					for (String item : strItem) {
//						System.out.println(item);
//						i++;
//						if (i == 8) {
//							sb.append("'" + item + "'");
//						} else if (i < 8) {
//							sb.append("'" + item + "',");
//						} else {
//						}
//					}
//					sb.append(");");
//					System.out.println(sb.toString());
//					sb = new StringBuffer();
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//}
