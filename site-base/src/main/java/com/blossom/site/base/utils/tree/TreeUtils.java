package com.blossom.site.base.utils.tree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Blossom
 * @Description 讲一个list转换为树形结构
 * @time 2017/3/23 13:43
 */
public class TreeUtils {

    /**
     * @description 根据父节点的ID获取所有子节点
     * @author Blossom
     * @DateTime 2017/3/23 13:48
     * @param list  分类表
     * @param parentId 传入的父节点ID
     */
    public static List<TreeEntity> getChildResourcess(List<TreeEntity> list,int parentId){
        List<TreeEntity> returnList = new ArrayList<>();
        Iterator<TreeEntity> iterator = list.iterator();
        while (iterator.hasNext()){
            TreeEntity entity = (TreeEntity) iterator.next();
            //根据传入的某个父节点ID，遍历该父节点的所有子节点
            if (entity.getParentId() == parentId){
                recursionFn(list,entity);
                returnList.add(entity);
            }
        }
        return returnList;
    }

    /**
     * @description 递归列表
     * @author Blossom
     * @DateTime 2017/3/23 13:53
     * @param list
     * @param entity
     */
    private static void recursionFn(List<TreeEntity> list,TreeEntity entity){
       //得到子节列表
        List<TreeEntity> childList = getChildList(list,entity);
        entity.setChildren(childList);
        for(TreeEntity child: childList){
            if (hasChild(list,child)){
                Iterator<TreeEntity> iterator = childList.iterator();
                while (iterator.hasNext()){
                    TreeEntity treeEntity = (TreeEntity) iterator.next();
                    recursionFn(list,treeEntity);
                }
            }
        }
    }

    /**
     * @description 得到子节点列表
     * @author Blossom
     * @DateTime 2017/3/23 13:54
     * @param list
     * @param entity
     */
    private static List<TreeEntity> getChildList(List<TreeEntity> list,TreeEntity entity){
        List<TreeEntity> treeList = new ArrayList<>();
        Iterator<TreeEntity> iterator = list.iterator();
        while (iterator.hasNext()){
            TreeEntity treeEntity = (TreeEntity)iterator.next();
            if (treeEntity.getParentId() == entity.getId()){
                treeList.add(treeEntity);
            }
        }
        return treeList;
    }

    /**
     * @description 判断是否有子节点
     * @author Blossom
     * @DateTime 2017/3/23 13:58
     * @param list
     * @param entity
     */
    private static boolean hasChild(List<TreeEntity> list,TreeEntity entity){
        return getChildList(list,entity).size() > 0 ? true : false;
    }

}
