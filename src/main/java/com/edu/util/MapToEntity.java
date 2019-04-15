package com.edu.util;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapToEntity {
    public static <T> List<T> convertListMap2ListBean(List<Map<String,Object>> listMap, Class target) {
        List<T> beanList = new ArrayList<T>();

        for(Map<String,Object> map:listMap){
            Object obj = null;
            try {
                obj = target.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                BeanUtils.populate( obj, map );
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            beanList.add((T) obj);
        }
        return beanList;
    }
}
