package com.tk.utils.response;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : HttpResponseUtil
 * @description : [HTTP 接口协作工具]
 * @createTime : [2021/12/13 14:25]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/13 14:25]
 * @updateRemark : [描述说明本次修改内容]
 */
public class HttpResponseUtil {
    public static <T> void sendJson(HttpServletResponse response, ResultDTO<T> data) {
        String body = (JSON.toJSONString(data));
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try (
                ServletOutputStream outputStream = response.getOutputStream()
        ) {
            outputStream.write(body.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
