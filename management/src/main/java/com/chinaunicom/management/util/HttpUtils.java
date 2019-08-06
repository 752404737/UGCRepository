package com.chinaunicom.management.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-1 上午8:24
 * 用于作为与用户交互的最后一层，所以HttpUtils中涉及和前端交互的api方法不建议抛出异常，应当进行适当的异常处理
 */
public class HttpUtils {

    private static Logger logger = LogManager.getLogger(HttpUtils.class);

    /**
     * @param response HttpServletResponse
     * @param result 后台返回给前端的字符串、例如JSON格式的字符串
     */
    public static void printJsonToResponse(HttpServletResponse response, String result) {
        try {
            PrintWriter writer = response.getWriter();
            writer.write(result);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {

        }
    }

    /**
     * @param response HttpServletResponse
     * @param result 后台返回给前端的JSON对象
     */
    public static void printJsonToResponse(HttpServletResponse response, JSONObject result) {
        try {
            PrintWriter writer = response.getWriter();
            writer.write(result.toJSONString());
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {

        }
    }

    /**
     * @param response HttpServletResponse
     * @param result 后台放回给前端的JSON数组对象
     */
    public static void printJsonToResponse(HttpServletResponse response, JSONArray result) {
        try {
            PrintWriter writer = response.getWriter();
            writer.write(result.toJSONString());
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {

        }
    }
}
