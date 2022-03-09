package com.ffyc.myfirstboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串操作类
 *
 * @author Deevan
 */
public class StringUtil {
    /**
     * 截取文件后缀名
     */
    public static String subFileType(String fileName) {
        if (fileName != null) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return null;
    }
    
    /**
     * 生成一个新文件名 （按时间）
     */
    public static String getNewFileName(String oldFileName) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date) + "." + subFileType(oldFileName);
    }


    public static String subFileType1(String fileName){
        if(fileName!=null){
            return fileName.substring(fileName.lastIndexOf("/")+1);
        }
        return null;
    }
    public static String newFileName(String oldFileName){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return  sdf.format(date)+"."+subFileType(oldFileName);
    }
}
