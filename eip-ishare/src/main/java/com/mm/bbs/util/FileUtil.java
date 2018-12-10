package com.mm.bbs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil extends ArrayList<String>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
     * 功能：将指定文件读出转换为字符串
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            // 读取字符文件
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName)));
            // 为什么单独在这里加上try块而不是直接使用外边的try块？
            // 需要考虑这么一种情况，如果文件没有成功打开，则finally关闭文件会出问题
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s + "\n");
                }
            }finally{
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     *
     * @param fileName 将要写入的文件名
     * @param text 写入的文本
     */
    public static void write(String fileName, String text){
        try{
            PrintWriter p = new PrintWriter(new File(fileName));
            try{
                p.print(text);
            }finally {
                p.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public FileUtil(String fileName, String splitter){
        // 将文件内容按指定形式分割后存放在ArrayList中
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) remove(0);
    }
    // 默认按行分割
    public FileUtil(String fileName){
        this(fileName, "\n");
    }

    /** 将本对象保存数据写入文件中
     *
     * @param fileName 文件名
     */
    public void write(String fileName){
        try (
            PrintWriter out = new PrintWriter(new File(fileName))) {
            try{
                for(String item : this){
                    out.println(item);
                }
            }finally{
                out.close();
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    } 
}
