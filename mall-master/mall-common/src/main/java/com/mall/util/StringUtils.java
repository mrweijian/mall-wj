package com.mall.util;

public class StringUtils {

    /**
     *字符串校验
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }
}
