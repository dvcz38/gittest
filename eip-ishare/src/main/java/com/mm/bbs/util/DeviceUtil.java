package com.mm.bbs.util;

import java.util.HashMap;
import java.util.Map;

import com.mm.bbs.common.DeviceStatus;
import com.mm.bbs.common.DoorStatus;

public class DeviceUtil {

	public static Map<String,String> parse(String str) {
		Map<String,String>  map=new HashMap<String,String>();
		String[] items=str.split(" ");
		
		
		String deviceStatus=items[0];
		if(DeviceStatus.isDoorCheck(deviceStatus)) {
			StringBuilder sb=new StringBuilder();
			for(int i=1;i<7;i++) {
				sb.append(items[i]);
			}
//			sb.append(items[1]).append(items[2]))
			map.put("deviceStatus", deviceStatus); 
			
			String deviceId=String.valueOf(Long.parseLong(sb.toString(),  16));
			map.put("deviceId", deviceId); 
			
			String doorStatus=items[7];
			if("00".equals(doorStatus)) {
				map.put("doorStatus", DoorStatus.DOOR_CLOSE.getValue());
			}else {
				map.put("doorStatus", DoorStatus.DOOR_OPEN.getValue());

			}
			
			//Door Distance
			sb=new StringBuilder();

			for(int i=9;i>7;i--) {
				sb.append(items[i]);
			}
			String doordistance=String.valueOf(Long.parseLong(sb.toString(),  16));
			map.put("doordistance", doordistance);
			//Signal Power
			sb=new StringBuilder();

			for(int i=11;i>9;i--) {
				sb.append(items[i]);
			}
			String signlpwr=String.valueOf(Long.parseLong(sb.toString(),  16));
			map.put("signlpwr", signlpwr);
			//Signal Power
			sb=new StringBuilder();

			for(int i=13;i>11;i--) {
				sb.append(items[i]);
			}
			long bv=Long.parseLong(sb.toString(),  16);
			
			String battVol=String.valueOf(((float)bv/4096)*3.3*2);
			map.put("battVol", battVol);
			
			long yr=2000+Long.parseLong(items[14],  16);
			long month=Long.parseLong(items[15],  16);
			long day=Long.parseLong(items[16],  16);
			long hour=Long.parseLong(items[17],  16);
			long minute=Long.parseLong(items[18],  16);
			long second=Long.parseLong(items[19],  16);
			
			//datatime
			sb=new StringBuilder();
			sb.append(yr).append("-");
			sb.append(month).append("-");
			sb.append(day).append(" ");
			sb.append(hour).append(":");
			sb.append(minute).append(":");
			sb.append(second).append(":"); 
			map.put("inputDt", sb.toString());
			//			String isStaffCheck=items[4]; 
//			String signlpwr=items[5]; 
//			String batVol=items[6];
			
			
		}
		return map;
    	
		
		
	}
}
