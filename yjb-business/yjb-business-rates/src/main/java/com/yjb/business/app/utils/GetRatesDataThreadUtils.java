package com.yjb.business.app.utils;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class GetRatesDataThreadUtils {
	
	@Bean
	public static void getInit() throws SQLException {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Task executed at: " + System.currentTimeMillis());
				try {
					java.sql.Connection con = JdbcUtils.getConnect();
					Statement stat = con.createStatement();
					ArrayList<String> list = new ArrayList<String>();
					int times = 0;
					while(true) {
						list = new CreateRecorder().createRecord();
						for (String item : list) {
							stat.addBatch(item);
						}
						times++;
						stat.executeBatch();
						GetNewsDataThreadUtils.getHtmlNewDataContent1();
						Thread.sleep(1000 * 60);
						if(times > 1000 * 60 * 24* 60 ) {
							break;
						}
					}
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的08:00:00执行，
        calendar.set(year, month, day, 9, 00, 00);

		Timer timer = new Timer();;
		Calendar nextEightAm = Calendar.getInstance();
        nextEightAm.set(Calendar.HOUR_OF_DAY, 8);
        nextEightAm.set(Calendar.MINUTE, 0);
        nextEightAm.set(Calendar.SECOND, 0);
        nextEightAm.set(Calendar.MILLISECOND, 0);
 
        // 如果当前时间已经是或超过了下午8点，则需要设置为第二天
        if (Calendar.getInstance().getTimeInMillis() > nextEightAm.getTimeInMillis()) {
            nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
        }
 
        // 排除周六和周日
        if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
            nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            
            // 如果是周六，则设置为下一个周一
            if (nextEightAm.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                nextEightAm.add(Calendar.DAY_OF_MONTH, 2);
            } else {
                nextEightAm.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
        nextEightAm.set(year, month, day, 9, 00, 00);
        timer.schedule(task, nextEightAm.getTime(), 1000 * 24 * 60* 60   );
        task.run();
	}
}
