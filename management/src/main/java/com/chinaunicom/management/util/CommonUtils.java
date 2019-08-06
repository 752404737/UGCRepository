package com.chinaunicom.management.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-5 下午10:46
 */
public class CommonUtils {
    /**
     * 加密算法MD5
     * 加盐 usrName + salt
     * 迭代次数
     * @param usrName
     * @param passWord
     * @return
     */
    public static String MD5Pwd(String usrName, String passWord) {
        String md5Pwd = new SimpleHash("MD5", passWord,
                ByteSource.Util.bytes(usrName + "salt"), 2).toHex();
        return md5Pwd;
    }
}
