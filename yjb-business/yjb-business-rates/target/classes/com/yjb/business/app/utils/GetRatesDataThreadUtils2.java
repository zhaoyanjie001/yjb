//package com.yjb.business.app.utils;
//
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//@Configuration
//public class GetRatesDataThreadUtils2 {
//	
//	@Bean
//	public static void getInit() throws SQLException {
//		TimerTask task = new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("Task executed at: " + System.currentTimeMillis());
//				try {
//					java.sql.Connection con = JdbcUtils.getConnect();
//					Statement stat = con.createStatement();
//					ArrayList<String> list = new ArrayList<String>();
//					int times = 0;
//					ArrayList<String> preList = new ArrayList<String>();
//					while(true) {
//						
//						list = new CreateRecorder().createRecord();
//						if(list.equals(preList)) {
//							continue;
//						}
//						for (String item : list) {
//							stat.addBatch(item);
//						}
//						times++;
//						
//						stat.executeBatch();
//						GetNewsDataThreadUtils.getHtmlNewDataContent1();
//						Thread.sleep(1000 * 60);
//						
//						preList = list;
//						if(times > 60 * 12) {
//							break;
//						}
//					}
//					stat.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//
//		Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
//        //定制每天的08:00:00执行，
//        calendar.set(year, month, day, 9, 00, 00);
//
//		Timer timer = new Timer();;
//		Calendar nextEightAm = Calendar.getInstance();
//        nextEightAm.set(Calendar.HOUR_OF_DAY, 8);
//        nextEightAm.set(Calendar.MINUTE, 0);
//        nextEightAm.set(Calendar.SECOND, 0);
//        nextEightAm.set(Calendar.MILLISECOND, 0);
// 
//        // 如果当前时间已经是或超过了下午8点，则需要设置为第二天
//        if (Calendar.getInstance().getTimeInMillis() > nextEightAm.getTimeInMillis()) {
//            nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
//        }
// 
//        // 排除周六和周日
//        if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
//            nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
//            
//            // 如果是周六，则设置为下一个周一
//            if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
//                nextEightAm.add(Calendar.DAY_OF_MONTH, 2);
//            } else {
//                nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
//            }
//        }
//        nextEightAm.set(year, month, day, 9, 00, 00);
//        timer.schedule(task, nextEightAm.getTime(), 12 * 60 * 60 * 1000);
//        
//	}
//	
//	
////	public static void main(String[] args) throws SQLException {
////		TimerTask task = new TimerTask() {
////			@Override
////			public void run() {
////				// 这里是需要每小时执行的代码
////				System.out.println("Task executed at: " + System.currentTimeMillis());
////				try {
////					java.sql.Connection con = JdbcUtils.getConnect();
////					Statement stat = con.createStatement();
////					ArrayList<String> list = new ArrayList<String>();
////					int times = 0;
////					while(true) {
////						
////						list = new CreateRecorder().createRecord();
////						for (String item : list) {
////							stat.addBatch(item);
////						}
////						times++;
////						if(times > 60 * 60 * 1000 * 12) {
////							break;
////						}
////						Thread.sleep(1000 * 60);
////						stat.executeBatch();
////					}
////					
////					stat.close();
////					con.close();
////				} catch (SQLException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				} catch (InterruptedException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////			}
////		};
////
//////
//////		Timer timer = new Timer();
//////		long delay = 0; // 任务启动前的延迟时间（现在开始）
//////		long period = 60 * 60 * 1000 * 16; // 每小时执行一次，以毫秒为单位
//////
//////		// 安排在指定的时间间隔重复执行任务
//////		timer.scheduleAtFixedRate(task, delay, period);
////		
////		Calendar calendar = Calendar.getInstance();
////        int year = calendar.get(Calendar.YEAR);
////        int month = calendar.get(Calendar.MONTH);
////        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
////        //定制每天的08:00:00执行，
////        calendar.set(year, month, day, 9, 00, 00);
//////        java.util.Date date = calendar.getTime();
//////        //            创建定时器
//////        Timer timer = new Timer();
//////        //设置的定时器 period(每隔多长时间运行几次) 单位毫秒
//////        timer.schedule(task, date);
////
////
////		Timer timer = new Timer();;
////		Calendar nextEightAm = Calendar.getInstance();
////        nextEightAm.set(Calendar.HOUR_OF_DAY, 8);
////        nextEightAm.set(Calendar.MINUTE, 0);
////        nextEightAm.set(Calendar.SECOND, 0);
////        nextEightAm.set(Calendar.MILLISECOND, 0);
//// 
////        // 如果当前时间已经是或超过了下午8点，则需要设置为第二天
////        if (Calendar.getInstance().getTimeInMillis() > nextEightAm.getTimeInMillis()) {
////            nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
////        }
//// 
////        // 排除周六和周日
////        if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
////            nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
////            
////            // 如果是周六，则设置为下一个周一
////            if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
////                nextEightAm.add(Calendar.DAY_OF_MONTH, 2);
////            } else {
////                nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
////            }
////        }
////        nextEightAm.set(year, month, day, 9, 00, 00);
////        timer.schedule(task, nextEightAm.getTime(), 12 * 60 * 60 * 1000);
////        
////	}
//}
