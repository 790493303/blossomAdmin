package com.blossom.site.base.utils.list;

import com.blossom.site.base.utils.ObjectUtils;
import com.blossom.site.base.utils.ReflectUtils;
import com.blossom.site.base.utils.StringUtils;
import com.blossom.site.base.utils.CollectionUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Blossom
 * @Description list 分组处理
 * @time 2017/3/23 11:08
 */
public class ListGroupUtils {

    /**
     * @description list 根据依据分组(属性名称)操作
     * @author Blossom
     * @DateTime 2017/3/23 11:17
     * @param
     */
    public static final <T extends Comparable<T>,D>Map<T,List<D>> group(Collection<D> collection,GroupBy<T> groupBy) throws Exception {
        if (CollectionUtils.isEmpty(collection)){
            throw new Exception("分组集合不能为空!");
        }
        if (ObjectUtils.isEmpty(groupBy)){
            throw new Exception("分组依据不能为空!");
        }
        Iterator<D> iterator = collection.iterator();
        Map<T,List<D>> map = new HashMap<T,List<D>>();
        List<D> list = null;
        while (iterator.hasNext()){
            D d = iterator.next();
            T t = groupBy.groupBy(d);
            if (map.containsKey(t)){
                map.get(t).add(d);
            }else{
                list = new ArrayList<D>();
                list.add(d);
                map.put(t,list);
            }
        }
        return map;
    }

    /**
     * @description 将List<V>按照V的methodName方法返回值（返回值必须为K类型）分组，合入到Map<K, List<V>>中<br>
     *              要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为K类型
     * @author Blossom
     * @DateTime 2017/3/23 11:32
     * @param
     */
    public static <K,V> void listGroupToMap(List<V> list,Map<K,List<V>> map,Class<V> clazz,String methodName) throws Exception {
        if (null == list || null == map || ObjectUtils.isEmpty(clazz) || StringUtils
                .isBlank(methodName)){
            throw new  Exception("参数错误!");
        }

        Method method = (Method) ReflectUtils.invoke(clazz,methodName);
        if (ObjectUtils.isEmpty(method)){
            throw new Exception("此方法不存在!");
        }

        Object key = null;
        List<V> vList = null;
        for(V val : list){
            key = method.invoke(val);
            vList = map.get(key);
            if (CollectionUtils.isEmpty(vList)){
                vList = new ArrayList<V>();
                map.put((K)key,vList);
            }
            vList.add(val);
        }
    }

}
