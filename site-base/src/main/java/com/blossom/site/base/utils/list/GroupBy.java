package com.blossom.site.base.utils.list;

/**
 * @author Blossom
 * @Description 分组依据接口，用于分组时，获取分组依据
 * @time 2017/3/23 11:07
 */
public interface GroupBy<T> {

    T groupBy(Object object);

}
