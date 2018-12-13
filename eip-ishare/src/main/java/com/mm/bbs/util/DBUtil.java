package com.mm.bbs.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.mm.bbs.pojo.DoorSensor;
import com.mm.bbs.pojo.DoorSensorDtl;

public class DBUtil {

	public Connection getConn() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PropertiesReader prop=new PropertiesReader();
		String val=prop.getValue("jdbc.url");

        String dirver=prop.getValue("jdbc.driver"); 
        
        String user=prop.getValue("jdbc.username");

        String psd=prop.getValue("jdbc.password"); 

//        String tablename="device";

        String url=prop.getValue("jdbc.url");
        
        
        Class.forName(dirver).newInstance();
//      Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
      Connection conn= DriverManager.getConnection(url,user,psd);
      return conn;
	}

    


}
