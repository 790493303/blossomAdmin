package com.blossom.site.base.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * @author Blossom
 * @Description json工具类
 * @time 2017/3/2 18:28
 */
public class JsonUtils {

    /**
     * 判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
     *
     * @param args
     * @return
     */
    public static JSONObject isJSONObject(Object args) {
        JSONObject result = null;

        if (args instanceof JSONObject) {
            return (JSONObject) args;
        }

        if (StringUtils.isBlank(args)) {
            return result;
        }
        try {
            return JSONObject.fromObject(args);
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * 判断一个字符串是否为JSONArray,是返回JSONArray,不是返回null
     *
     * @param args
     * @return
     */
    public static JSONArray isJSONArray(Object args) {

        if (args instanceof JSONArray) {
            return (JSONArray) args;
        }

        JSONArray result = null;
        if (StringUtils.isBlank(args)) {
            return result;
        }
        try {
            return JSONArray.fromObject(args);
        } catch (Exception e) {
            return result;
        }
    }

    /**
     * @Description: 校验json对象是否为空
     * @author Blossom
     * @time 2016年12月17日 下午8:19:03
     * @return_type boolean
     *
     */
    public static boolean checkJSONIsNull(JSONObject json){
        if (null == json || json.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 验证key是否存在，value是否为空
     * @author Blossom
     * @time 2016年12月15日 下午9:00:54
     * @return_type boolean
     *
     */
    public static boolean checkJSONKey(JSONObject json,String key){
        if (!json.containsKey(key) || null == json.getString(key) || "".equals(json.getString(key))) {
            return true;
        }
        return false;
    }

    /**
     * @Description: 封装json信息
     * @author Blossom
     * @time 2016年12月15日 下午9:01:06
     * @return_type JSONObject
     *
     */
    public static JSONObject sealedJSON(Object...objects) throws Exception{
        if (null == objects) {
            throw new Exception("参数不全!");
        }
        JSONObject resultJSON = new JSONObject();
        if (null != objects && objects.length >=2){
            for (int i = 0; i < objects.length; i = i+2) {
                resultJSON.put(objects[i], objects[i+1]);
            }
        }
        return resultJSON;
    }

    /**
     * @description 封装错误json信息
     * @author Blossom
     * @DateTime 2017/3/8 11:45
     */
    public static JSONObject sealedErrorJSON(String errMessage) throws Exception {
        if (null == errMessage || "".equals(errMessage)){
            throw new Exception("参数不全!");
        }
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("status","0");
        resultJSON.put("message",errMessage);

        return resultJSON;
    }

    /**
     * @description 封装成功json信息
     * @author Blossom
     * @DateTime 2017/3/8 11:47
     */
    public static JSONObject sealedSuccessJSON(String sucMessage,Object...objects) throws Exception {
        if (null == objects) {
            throw new Exception("参数不全!");
        }
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("status","1");
        resultJSON.put("message",sucMessage);
        if (null != objects && objects.length >= 2){
            for (int i = 0; i < objects.length; i = i+2) {
                resultJSON.put(objects[i], objects[i+1]);
            }
        }
        return resultJSON;
    }

    /**
     * @Description : 封装Exception信息为json格式
     * @author Blossom
     * @time 2016年12月21日 下午2:34:56
     * @param exception
     * @return
     */
    public static JSONObject sealedExceptionJSON(Throwable exception){
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("status", -1);
        resultJSON.put("message", exception.getMessage());
        return resultJSON;
    }

    /**
     * @Description: 获取json当中的所有key
     * @author Blossom
     * @time 2016年12月15日 下午9:01:30
     * @return_type List<String>
     *
     */
    public static List<String> getJSONKey(String param) throws Exception{

        Iterator<String> iterator = getIterator(param);
        JSONObject json = JSONObject.fromObject(param);
        List<String> keyList = new ArrayList<String>();
        String keyStr = null;
        while (iterator.hasNext()) {
            keyStr = iterator.next();
            keyList.add(keyStr);
        }
        return keyList;
    }

    /**
     * @Description: 将json转换为map
     * @author Blossom
     * @time 2016年12月15日 下午9:01:41
     * @return_type Map<String,Object>
     *
     */
    public static Map<String, Object> jsonToMap(String param) throws Exception{

        Iterator<String> iterator = getIterator(param);
        JSONObject json = JSONObject.fromObject(param);
        Map<String, Object> map = new HashMap<String, Object>();
        String keyStr = null;
        Object object = null;
        while (iterator.hasNext()) {
            keyStr = iterator.next();
            object = json.get(keyStr);
            map.put(keyStr, object);
        }
        return map;
    }

    /**
     * @Description: 获取json迭代
     * @author Blossom
     * @time 2016年12月15日 下午9:01:56
     * @return_type Iterator
     *
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private static Iterator getIterator(String param) throws Exception{
        JSONObject json = isJSONObject(param);
        if (null == json || !json.containsKey("data")) {
            throw new Exception("格式错误!");
        }
        json = JSONObject.fromObject(param);
        Iterator<String> iterator = json.keys();

        return iterator;
    }
}
