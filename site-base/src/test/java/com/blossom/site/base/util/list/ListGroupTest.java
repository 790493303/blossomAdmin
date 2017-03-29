package com.blossom.site.base.util.list;

import com.blossom.site.base.utils.list.GroupBy;
import com.blossom.site.base.utils.list.ListGroupUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author Blossom
 * @Description list分组测试
 * @time 2017/3/23 11:33
 */
public class ListGroupTest {

    @Test
    public void GroupTest() throws Exception {
        final int loop = 2 * 2;
        List<Data> list = new ArrayList<Data>(); // size=8 * loop
        for (int i = 0; i < loop; i++) {
            list.add(new Data().setId(1L).setCourseId(200010L).setContent("AAA"));
            list.add(new Data().setId(2L).setCourseId(200010L).setContent("BBB"));
            list.add(new Data().setId(3L).setCourseId(200011L).setContent("CCC"));
            list.add(new Data().setId(4L).setCourseId(200011L).setContent("DDD"));
            list.add(new Data().setId(5L).setCourseId(200010L).setContent("EEE"));
            list.add(new Data().setId(6L).setCourseId(200011L).setContent("FFF"));
            list.add(new Data().setId(7L).setCourseId(200010L).setContent("GGG"));
            list.add(new Data().setId(8L).setCourseId(200012L).setContent("HHH"));
        }
        // 进行分组 1
        long time = System.currentTimeMillis();
        Map<Long, List<Data>> map2 = new LinkedHashMap<Long, List<Data>>();
       // ListGroupUtils.listGroupToMap(list, map2, Data.class, "getId");// 输入方法名

        long duration = System.currentTimeMillis() - time;

        System.out.println("分组一执行：" + duration + "毫秒!");

        // 分组二
        time = System.currentTimeMillis();
        Map<Long, List<Data>> map = ListGroupUtils.group(list, new GroupBy<Long>() {
            @Override
            public Long groupBy(Object object) {
                Data d = (Data) object;
                return d.getCourseId(); // 分组依据为课程ID
            }

        });
        Iterator<Long> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            List<Data> dataList = map.get(iterator.next());
            for (Data data : dataList){
                System.out.print(data.toString());
            }
        }
        duration = System.currentTimeMillis() - time;

        System.out.println("分组二执行：" + duration + "毫秒!");
    }
}
