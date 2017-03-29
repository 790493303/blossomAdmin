package com.blossom.site.base.lump;

import com.blossom.site.base.utils.JsonUtils;
import com.blossom.site.base.utils.LoggerUtils;
import net.sf.json.JSONObject;

/**
 * @author Blossom
 * @Description 异常代码块
 * @time 2017/3/24 15:09
 */
public class ErrorCodeLump {

    /**
     * @description 异常处理块
     * @author Blossom
     * @DateTime 2017/3/24 15:12
     * @param clazz
     * @param method
     * @param e
     */
    public static JSONObject exception(Class clazz,String method,Exception e){
        LoggerUtils.addLoggerError(clazz,method,e.getMessage());
        e.printStackTrace();
        return JsonUtils.sealedExceptionJSON(e);
    }

    /**
     * @description 错误处理代码块
     * @author Blossom
     * @DateTime 2017/3/24 15:27
     * @param clazz
     * @param method
     * @param message
     */
    public static JSONObject error(Class clazz,String method,String message) throws Exception {
        LoggerUtils.addLoggerError(clazz,method,message);
        return JsonUtils.sealedErrorJSON(message);
    }

}
