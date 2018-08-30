
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
public class Html {
	//get 
	
	public Document getHtmlTextByUrl(String url)
	{
		Document doc=null;
		try {
			int i=(int)(Math.random()*1000)
		}
		while(i!=0) 
		{ i--; } 
		doc= Jsoup.connect(url).data("query", "Java") 
		.userAgent("Mozilla") .cookie("auth", "token") 
		.timeout(300000) .post(); 
		} catch (IOException e) 
		{ e.printStackTrace();
		 try { 
		    doc = Jsoup.connect(url).timeout(5000000).get(); 
		} 
		catch (IOException e1)
		 { // TODO Auto-generated catch block  e1.printStackTrace(); } } 

		return doc; 
	}

}
